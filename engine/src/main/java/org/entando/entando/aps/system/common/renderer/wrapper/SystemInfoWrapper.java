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
package org.entando.entando.aps.system.common.renderer.wrapper;

import com.agiletec.aps.system.RequestContext;
import com.agiletec.aps.system.services.lang.Lang;
import com.agiletec.aps.system.services.page.IPage;
import com.agiletec.aps.system.services.page.Widget;

/**
 * @author E.Santoboni, E.Mezzano
 */
public class SystemInfoWrapper {
	
	public SystemInfoWrapper(RequestContext reqCtx, ISystemInfoWrapperHelper helper) {
		this.setReqCtx(reqCtx);
		this.setHelper(helper);
	}
	
	/**
	 * Return the value of a System parameter.
	 * 
	 * @param paramName
	 *            The name of parameters
	 * @return The value to return
	 */
	public String getConfigParameter(String paramName) {
		return this.getHelper().getConfigParameter(paramName);
	}
	
	public IPage getCurrentPage() {
		return this.getHelper().getCurrentPage(this.getReqCtx());
	}
	
	public IPage getPageWithWidget(String widgetCode) {
		return this.getHelper().getPageWithWidget(widgetCode);
	}
	
	public String getPageURLWithWidget(String widgetCode) {
		return this.getHelper().getPageURLWithWidget(widgetCode, this.getReqCtx());
	}
	
	public Lang getCurrentLang() {
		return this.getHelper().getCurrentLang(this.getReqCtx());
	}
	
	/**
	 * @deprecated Use {@link #getCurrentWidget()} instead
	 */
	public Widget getCurrentShowlet() {
		return getCurrentWidget();
	}
	
	public Widget getCurrentWidget() {
		return this.getHelper().getCurrentWidget(this.getReqCtx());
	}
	
	protected RequestContext getReqCtx() {
		return _reqCtx;
	}
	private void setReqCtx(RequestContext reqCtx) {
		this._reqCtx = reqCtx;
	}
	
	protected ISystemInfoWrapperHelper getHelper() {
		return _helper;
	}
	public void setHelper(ISystemInfoWrapperHelper helper) {
		this._helper = helper;
	}
	
	private RequestContext _reqCtx;
	private ISystemInfoWrapperHelper _helper;
	
}