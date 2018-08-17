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

package com.liferay.portal.security.sso.openid.connect;

/**
 * @author Edward C. Han
 */
public enum OpenIdConnectFlowState {

	AUTH_COMPLETE,			//	2 - Completed OIDC auth flow
	AUTH_REQUESTED,			//	1 - User has been forwarded to OIDC for auth
	INITIALIZED,			//	0 - Initial State - OIDC Session initialized
	PORTAL_AUTH_COMPLETE	//	3 - Complete Auth flow - user signed into portal

}