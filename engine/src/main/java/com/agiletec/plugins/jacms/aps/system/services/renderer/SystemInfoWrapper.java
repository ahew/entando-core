/*
 * Copyright 2015-Present Entando Inc. (http://www.entando.com) All rights reserved.
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
package com.agiletec.plugins.jacms.aps.system.services.renderer;

import org.entando.entando.aps.system.common.renderer.wrapper.ISystemInfoWrapperHelper;

import com.agiletec.aps.system.RequestContext;
import com.agiletec.aps.util.ApsWebApplicationUtils;

/**
 * @author E.Santoboni
 */
public class SystemInfoWrapper extends org.entando.entando.aps.system.common.renderer.wrapper.SystemInfoWrapper {
	
	@Deprecated
	public SystemInfoWrapper(RequestContext reqCtx) {
		super(reqCtx, (ISystemInfoWrapperHelper) ApsWebApplicationUtils.getBean("SystemInfoWrapperHelper", reqCtx.getRequest()));
	}
	
	public SystemInfoWrapper(RequestContext reqCtx, ISystemInfoWrapperHelper helper) {
		super(reqCtx, helper);
	}
	
}