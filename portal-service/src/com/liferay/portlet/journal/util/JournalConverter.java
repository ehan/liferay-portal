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

package com.liferay.portlet.journal.util;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.xml.Document;
import com.liferay.portlet.dynamicdatamapping.model.DDMStructure;
import com.liferay.portlet.dynamicdatamapping.storage.Fields;

import java.util.Locale;

/**
 * @author Marcellus Tavares
 * @author Bruno Basto
 */
@ProviderType
public interface JournalConverter {

	public String getContent(DDMStructure ddmStructure, Fields ddmFields)
		throws Exception;

	public Fields getDDMFields(DDMStructure ddmStructure, Document document)
		throws Exception;

	public Fields getDDMFields(DDMStructure ddmStructure, String content)
		throws Exception;

	public String getDDMXSD(String journalXSD) throws Exception;

	public String getDDMXSD(String journalXSD, Locale defaultLocale)
		throws Exception;

	public String getJournalXSD(String ddmXSD) throws Exception;

	public Locale getStructureNameDefaultLocale(String structureName)
		throws Exception;

}