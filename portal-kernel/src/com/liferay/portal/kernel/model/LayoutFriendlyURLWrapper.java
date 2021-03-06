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

package com.liferay.portal.kernel.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link LayoutFriendlyURL}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LayoutFriendlyURL
 * @generated
 */
@ProviderType
public class LayoutFriendlyURLWrapper implements LayoutFriendlyURL,
	ModelWrapper<LayoutFriendlyURL> {
	public LayoutFriendlyURLWrapper(LayoutFriendlyURL layoutFriendlyURL) {
		_layoutFriendlyURL = layoutFriendlyURL;
	}

	@Override
	public Class<?> getModelClass() {
		return LayoutFriendlyURL.class;
	}

	@Override
	public String getModelClassName() {
		return LayoutFriendlyURL.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mvccVersion", getMvccVersion());
		attributes.put("uuid", getUuid());
		attributes.put("layoutFriendlyURLId", getLayoutFriendlyURLId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("plid", getPlid());
		attributes.put("privateLayout", isPrivateLayout());
		attributes.put("friendlyURL", getFriendlyURL());
		attributes.put("languageId", getLanguageId());
		attributes.put("lastPublishDate", getLastPublishDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long mvccVersion = (Long)attributes.get("mvccVersion");

		if (mvccVersion != null) {
			setMvccVersion(mvccVersion);
		}

		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long layoutFriendlyURLId = (Long)attributes.get("layoutFriendlyURLId");

		if (layoutFriendlyURLId != null) {
			setLayoutFriendlyURLId(layoutFriendlyURLId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long plid = (Long)attributes.get("plid");

		if (plid != null) {
			setPlid(plid);
		}

		Boolean privateLayout = (Boolean)attributes.get("privateLayout");

		if (privateLayout != null) {
			setPrivateLayout(privateLayout);
		}

		String friendlyURL = (String)attributes.get("friendlyURL");

		if (friendlyURL != null) {
			setFriendlyURL(friendlyURL);
		}

		String languageId = (String)attributes.get("languageId");

		if (languageId != null) {
			setLanguageId(languageId);
		}

		Date lastPublishDate = (Date)attributes.get("lastPublishDate");

		if (lastPublishDate != null) {
			setLastPublishDate(lastPublishDate);
		}
	}

	@Override
	public Object clone() {
		return new LayoutFriendlyURLWrapper((LayoutFriendlyURL)_layoutFriendlyURL.clone());
	}

	@Override
	public int compareTo(LayoutFriendlyURL layoutFriendlyURL) {
		return _layoutFriendlyURL.compareTo(layoutFriendlyURL);
	}

	/**
	* Returns the company ID of this layout friendly url.
	*
	* @return the company ID of this layout friendly url
	*/
	@Override
	public long getCompanyId() {
		return _layoutFriendlyURL.getCompanyId();
	}

	/**
	* Returns the create date of this layout friendly url.
	*
	* @return the create date of this layout friendly url
	*/
	@Override
	public Date getCreateDate() {
		return _layoutFriendlyURL.getCreateDate();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _layoutFriendlyURL.getExpandoBridge();
	}

	/**
	* Returns the friendly url of this layout friendly url.
	*
	* @return the friendly url of this layout friendly url
	*/
	@Override
	public String getFriendlyURL() {
		return _layoutFriendlyURL.getFriendlyURL();
	}

	/**
	* Returns the group ID of this layout friendly url.
	*
	* @return the group ID of this layout friendly url
	*/
	@Override
	public long getGroupId() {
		return _layoutFriendlyURL.getGroupId();
	}

	/**
	* Returns the language ID of this layout friendly url.
	*
	* @return the language ID of this layout friendly url
	*/
	@Override
	public String getLanguageId() {
		return _layoutFriendlyURL.getLanguageId();
	}

	/**
	* Returns the last publish date of this layout friendly url.
	*
	* @return the last publish date of this layout friendly url
	*/
	@Override
	public Date getLastPublishDate() {
		return _layoutFriendlyURL.getLastPublishDate();
	}

	/**
	* Returns the layout friendly url ID of this layout friendly url.
	*
	* @return the layout friendly url ID of this layout friendly url
	*/
	@Override
	public long getLayoutFriendlyURLId() {
		return _layoutFriendlyURL.getLayoutFriendlyURLId();
	}

	/**
	* Returns the modified date of this layout friendly url.
	*
	* @return the modified date of this layout friendly url
	*/
	@Override
	public Date getModifiedDate() {
		return _layoutFriendlyURL.getModifiedDate();
	}

	/**
	* Returns the mvcc version of this layout friendly url.
	*
	* @return the mvcc version of this layout friendly url
	*/
	@Override
	public long getMvccVersion() {
		return _layoutFriendlyURL.getMvccVersion();
	}

	/**
	* Returns the plid of this layout friendly url.
	*
	* @return the plid of this layout friendly url
	*/
	@Override
	public long getPlid() {
		return _layoutFriendlyURL.getPlid();
	}

	/**
	* Returns the primary key of this layout friendly url.
	*
	* @return the primary key of this layout friendly url
	*/
	@Override
	public long getPrimaryKey() {
		return _layoutFriendlyURL.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _layoutFriendlyURL.getPrimaryKeyObj();
	}

	/**
	* Returns the private layout of this layout friendly url.
	*
	* @return the private layout of this layout friendly url
	*/
	@Override
	public boolean getPrivateLayout() {
		return _layoutFriendlyURL.getPrivateLayout();
	}

	/**
	* Returns the user ID of this layout friendly url.
	*
	* @return the user ID of this layout friendly url
	*/
	@Override
	public long getUserId() {
		return _layoutFriendlyURL.getUserId();
	}

	/**
	* Returns the user name of this layout friendly url.
	*
	* @return the user name of this layout friendly url
	*/
	@Override
	public String getUserName() {
		return _layoutFriendlyURL.getUserName();
	}

	/**
	* Returns the user uuid of this layout friendly url.
	*
	* @return the user uuid of this layout friendly url
	*/
	@Override
	public String getUserUuid() {
		return _layoutFriendlyURL.getUserUuid();
	}

	/**
	* Returns the uuid of this layout friendly url.
	*
	* @return the uuid of this layout friendly url
	*/
	@Override
	public String getUuid() {
		return _layoutFriendlyURL.getUuid();
	}

	@Override
	public int hashCode() {
		return _layoutFriendlyURL.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _layoutFriendlyURL.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _layoutFriendlyURL.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _layoutFriendlyURL.isNew();
	}

	/**
	* Returns <code>true</code> if this layout friendly url is private layout.
	*
	* @return <code>true</code> if this layout friendly url is private layout; <code>false</code> otherwise
	*/
	@Override
	public boolean isPrivateLayout() {
		return _layoutFriendlyURL.isPrivateLayout();
	}

	@Override
	public void persist() {
		_layoutFriendlyURL.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_layoutFriendlyURL.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this layout friendly url.
	*
	* @param companyId the company ID of this layout friendly url
	*/
	@Override
	public void setCompanyId(long companyId) {
		_layoutFriendlyURL.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this layout friendly url.
	*
	* @param createDate the create date of this layout friendly url
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_layoutFriendlyURL.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel) {
		_layoutFriendlyURL.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_layoutFriendlyURL.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_layoutFriendlyURL.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the friendly url of this layout friendly url.
	*
	* @param friendlyURL the friendly url of this layout friendly url
	*/
	@Override
	public void setFriendlyURL(String friendlyURL) {
		_layoutFriendlyURL.setFriendlyURL(friendlyURL);
	}

	/**
	* Sets the group ID of this layout friendly url.
	*
	* @param groupId the group ID of this layout friendly url
	*/
	@Override
	public void setGroupId(long groupId) {
		_layoutFriendlyURL.setGroupId(groupId);
	}

	/**
	* Sets the language ID of this layout friendly url.
	*
	* @param languageId the language ID of this layout friendly url
	*/
	@Override
	public void setLanguageId(String languageId) {
		_layoutFriendlyURL.setLanguageId(languageId);
	}

	/**
	* Sets the last publish date of this layout friendly url.
	*
	* @param lastPublishDate the last publish date of this layout friendly url
	*/
	@Override
	public void setLastPublishDate(Date lastPublishDate) {
		_layoutFriendlyURL.setLastPublishDate(lastPublishDate);
	}

	/**
	* Sets the layout friendly url ID of this layout friendly url.
	*
	* @param layoutFriendlyURLId the layout friendly url ID of this layout friendly url
	*/
	@Override
	public void setLayoutFriendlyURLId(long layoutFriendlyURLId) {
		_layoutFriendlyURL.setLayoutFriendlyURLId(layoutFriendlyURLId);
	}

	/**
	* Sets the modified date of this layout friendly url.
	*
	* @param modifiedDate the modified date of this layout friendly url
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_layoutFriendlyURL.setModifiedDate(modifiedDate);
	}

	/**
	* Sets the mvcc version of this layout friendly url.
	*
	* @param mvccVersion the mvcc version of this layout friendly url
	*/
	@Override
	public void setMvccVersion(long mvccVersion) {
		_layoutFriendlyURL.setMvccVersion(mvccVersion);
	}

	@Override
	public void setNew(boolean n) {
		_layoutFriendlyURL.setNew(n);
	}

	/**
	* Sets the plid of this layout friendly url.
	*
	* @param plid the plid of this layout friendly url
	*/
	@Override
	public void setPlid(long plid) {
		_layoutFriendlyURL.setPlid(plid);
	}

	/**
	* Sets the primary key of this layout friendly url.
	*
	* @param primaryKey the primary key of this layout friendly url
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_layoutFriendlyURL.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_layoutFriendlyURL.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets whether this layout friendly url is private layout.
	*
	* @param privateLayout the private layout of this layout friendly url
	*/
	@Override
	public void setPrivateLayout(boolean privateLayout) {
		_layoutFriendlyURL.setPrivateLayout(privateLayout);
	}

	/**
	* Sets the user ID of this layout friendly url.
	*
	* @param userId the user ID of this layout friendly url
	*/
	@Override
	public void setUserId(long userId) {
		_layoutFriendlyURL.setUserId(userId);
	}

	/**
	* Sets the user name of this layout friendly url.
	*
	* @param userName the user name of this layout friendly url
	*/
	@Override
	public void setUserName(String userName) {
		_layoutFriendlyURL.setUserName(userName);
	}

	/**
	* Sets the user uuid of this layout friendly url.
	*
	* @param userUuid the user uuid of this layout friendly url
	*/
	@Override
	public void setUserUuid(String userUuid) {
		_layoutFriendlyURL.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this layout friendly url.
	*
	* @param uuid the uuid of this layout friendly url
	*/
	@Override
	public void setUuid(String uuid) {
		_layoutFriendlyURL.setUuid(uuid);
	}

	@Override
	public CacheModel<LayoutFriendlyURL> toCacheModel() {
		return _layoutFriendlyURL.toCacheModel();
	}

	@Override
	public LayoutFriendlyURL toEscapedModel() {
		return new LayoutFriendlyURLWrapper(_layoutFriendlyURL.toEscapedModel());
	}

	@Override
	public String toString() {
		return _layoutFriendlyURL.toString();
	}

	@Override
	public LayoutFriendlyURL toUnescapedModel() {
		return new LayoutFriendlyURLWrapper(_layoutFriendlyURL.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _layoutFriendlyURL.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LayoutFriendlyURLWrapper)) {
			return false;
		}

		LayoutFriendlyURLWrapper layoutFriendlyURLWrapper = (LayoutFriendlyURLWrapper)obj;

		if (Objects.equals(_layoutFriendlyURL,
					layoutFriendlyURLWrapper._layoutFriendlyURL)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _layoutFriendlyURL.getStagedModelType();
	}

	@Override
	public LayoutFriendlyURL getWrappedModel() {
		return _layoutFriendlyURL;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _layoutFriendlyURL.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _layoutFriendlyURL.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_layoutFriendlyURL.resetOriginalValues();
	}

	private final LayoutFriendlyURL _layoutFriendlyURL;
}