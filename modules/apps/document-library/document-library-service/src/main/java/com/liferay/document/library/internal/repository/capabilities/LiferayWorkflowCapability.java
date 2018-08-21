/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.document.library.internal.repository.capabilities;

import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFileEntryConstants;
import com.liferay.document.library.kernel.model.DLFileVersion;
import com.liferay.document.library.kernel.model.DLVersionNumberIncrease;
import com.liferay.document.library.kernel.util.DLAppHelperThreadLocal;
import com.liferay.document.library.kernel.util.DLUtil;
import com.liferay.document.library.sync.constants.DLSyncConstants;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.repository.LocalRepository;
import com.liferay.portal.kernel.repository.Repository;
import com.liferay.portal.kernel.repository.capabilities.WorkflowCapability;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.FileVersion;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowThreadLocal;
import com.liferay.portal.repository.capabilities.WorkflowSupport;
import com.liferay.portal.repository.capabilities.util.DLFileEntryServiceAdapter;
import com.liferay.portal.repository.capabilities.util.DLFileVersionServiceAdapter;
import com.liferay.portal.repository.liferayrepository.LiferayWorkflowLocalRepositoryWrapper;
import com.liferay.portal.repository.liferayrepository.LiferayWorkflowRepositoryWrapper;
import com.liferay.portal.repository.util.RepositoryWrapperAware;

/**
 * @author Adolfo Pérez
 */
public class LiferayWorkflowCapability
	implements RepositoryWrapperAware, WorkflowCapability, WorkflowSupport {

	public LiferayWorkflowCapability(
		DLFileEntryServiceAdapter dlFileEntryServiceAdapter,
		DLFileVersionServiceAdapter dlFileVersionServiceAdapter) {

		_dlFileEntryServiceAdapter = dlFileEntryServiceAdapter;
		_dlFileVersionServiceAdapter = dlFileVersionServiceAdapter;
	}

	@Override
	public void addFileEntry(
			long userId, FileEntry fileEntry, ServiceContext serviceContext)
		throws PortalException {

		boolean previousEnabled = WorkflowThreadLocal.isEnabled();

		if (!DLAppHelperThreadLocal.isEnabled()) {
			WorkflowThreadLocal.setEnabled(false);
		}

		try {
			FileVersion fileVersion = fileEntry.getFileVersion();

			DLUtil.startWorkflowInstance(
				userId, (DLFileVersion)fileVersion.getModel(),
				DLSyncConstants.EVENT_ADD, serviceContext);
		}
		finally {
			if (!DLAppHelperThreadLocal.isEnabled()) {
				WorkflowThreadLocal.setEnabled(previousEnabled);
			}
		}
	}

	/**
	 * @deprecated As of Judson (7.1.x), replaced by {@link #checkInFileEntry(long, FileEntry, DLVersionNumberIncrease, ServiceContext)}
	 */
	@Deprecated
	@Override
	public void checkInFileEntry(
			long userId, FileEntry fileEntry, boolean majorVersion,
			ServiceContext serviceContext)
		throws PortalException {

		checkInFileEntry(
			userId, fileEntry,
			DLVersionNumberIncrease.fromBoolean(majorVersion), serviceContext);
	}

	@Override
	public void checkInFileEntry(
			long userId, FileEntry fileEntry,
			DLVersionNumberIncrease dlVersionNumberIncrease,
			ServiceContext serviceContext)
		throws PortalException {

		if (serviceContext.getWorkflowAction() ==
				WorkflowConstants.ACTION_PUBLISH) {

			DLFileVersion latestDLFileVersion =
				_dlFileVersionServiceAdapter.getLatestFileVersion(
					fileEntry.getFileEntryId(), false);

			DLUtil.startWorkflowInstance(
				userId, latestDLFileVersion, DLSyncConstants.EVENT_UPDATE,
				serviceContext);
		}
	}

	@Override
	public int getStatus(FileEntry fileEntry) {
		DLFileEntry dlFileEntry = (DLFileEntry)fileEntry.getModel();

		return dlFileEntry.getStatus();
	}

	@Override
	public void revertFileEntry(
			long userId, FileEntry fileEntry, ServiceContext serviceContext)
		throws PortalException {

		_startWorkflowInstance(userId, fileEntry, serviceContext);
	}

	/**
	 * @deprecated As of Judson (7.1.x), replaced by {@link #updateFileEntry(long, FileEntry, DLVersionNumberIncrease, ServiceContext)}
	 */
	@Deprecated
	@Override
	public void updateFileEntry(
			long userId, FileEntry fileEntry, boolean majorVersion,
			ServiceContext serviceContext)
		throws PortalException {

		updateFileEntry(
			userId, fileEntry,
			DLVersionNumberIncrease.fromBoolean(majorVersion), serviceContext);
	}

	@Override
	public void updateFileEntry(
			long userId, FileEntry fileEntry,
			DLVersionNumberIncrease dlVersionNumberIncrease,
			ServiceContext serviceContext)
		throws PortalException {

		_startWorkflowInstance(userId, fileEntry, serviceContext);
	}

	@Override
	public LocalRepository wrapLocalRepository(
		LocalRepository localRepository) {

		return new LiferayWorkflowLocalRepositoryWrapper(localRepository, this);
	}

	@Override
	public Repository wrapRepository(Repository repository) {
		return new LiferayWorkflowRepositoryWrapper(repository, this);
	}

	private DLFileVersion _getWorkflowDLFileVersion(
			long fileEntryId, ServiceContext serviceContext)
		throws PortalException {

		DLFileEntry dlFileEntry = _dlFileEntryServiceAdapter.getDLFileEntry(
			fileEntryId);

		if (dlFileEntry.isCheckedOut()) {
			return null;
		}

		DLFileVersion dlFileVersion =
			_dlFileVersionServiceAdapter.getLatestFileVersion(
				fileEntryId, true);

		if (dlFileVersion.isApproved() ||
			(serviceContext.getWorkflowAction() ==
				WorkflowConstants.ACTION_PUBLISH)) {

			return dlFileVersion;
		}

		return null;
	}

	private void _startWorkflowInstance(
			long userId, DLFileVersion dlFileVersion,
			ServiceContext serviceContext)
		throws PortalException {

		if (dlFileVersion == null) {
			return;
		}

		String syncEvent = DLSyncConstants.EVENT_UPDATE;

		String version = dlFileVersion.getVersion();

		if (version.equals(DLFileEntryConstants.VERSION_DEFAULT)) {
			syncEvent = DLSyncConstants.EVENT_ADD;
		}

		DLUtil.startWorkflowInstance(
			userId, dlFileVersion, syncEvent, serviceContext);
	}

	private void _startWorkflowInstance(
			long userId, FileEntry fileEntry, ServiceContext serviceContext)
		throws PortalException {

		DLFileVersion dlFileVersion = _getWorkflowDLFileVersion(
			fileEntry.getFileEntryId(), serviceContext);

		_startWorkflowInstance(userId, dlFileVersion, serviceContext);
	}

	private final DLFileEntryServiceAdapter _dlFileEntryServiceAdapter;
	private final DLFileVersionServiceAdapter _dlFileVersionServiceAdapter;

}