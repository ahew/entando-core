package org.entando.entando.aps.system.common.renderer.wrapper;

import com.agiletec.aps.system.RequestContext;
import com.agiletec.aps.system.services.lang.Lang;
import com.agiletec.aps.system.services.page.IPage;
import com.agiletec.aps.system.services.page.Widget;

/**
 * An helper useful for the class {@link SystemInfoWrapper}.
 * @author E.Mezzano
 */
public interface ISystemInfoWrapperHelper {
	
	/**
	 * Return the value of a System parameter.
	 * @param paramName The name of parameters
	 * @return The value to return
	 */
	public String getConfigParameter(String paramName);
	
	public IPage getCurrentPage(RequestContext reqCtx);
	
	public IPage getPageWithWidget(String widgetCode);
	
	public String getPageURLWithWidget(String widgetCode, RequestContext reqCtx);
	
	public Lang getCurrentLang(RequestContext reqCtx);
	
	public Widget getCurrentWidget(RequestContext reqCtx);
	
}
