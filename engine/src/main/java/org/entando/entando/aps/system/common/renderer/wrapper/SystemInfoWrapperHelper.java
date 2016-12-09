package org.entando.entando.aps.system.common.renderer.wrapper;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.agiletec.aps.system.RequestContext;
import com.agiletec.aps.system.SystemConstants;
import com.agiletec.aps.system.services.baseconfig.ConfigInterface;
import com.agiletec.aps.system.services.lang.Lang;
import com.agiletec.aps.system.services.page.IPage;
import com.agiletec.aps.system.services.page.IPageManager;
import com.agiletec.aps.system.services.page.Widget;
import com.agiletec.aps.system.services.url.IURLManager;
import com.agiletec.aps.system.services.url.PageURL;

/**
 * An helper useful for the class {@link SystemInfoWrapper}.
 * It is a Spring Bean that provides a direct access to the required Entando Services.
 * It's also an implementation of {@link ISystemInfoWrapperFactory}, providing a build point for the {@link SystemInfoWrapper} class.
 * @author E.Mezzano
 *
 */
public class SystemInfoWrapperHelper implements ISystemInfoWrapperHelper, ISystemInfoWrapperFactory {
	
	private static final Logger _logger = LoggerFactory.getLogger(SystemInfoWrapperHelper.class);
	
	@Override
	public SystemInfoWrapper buildSystemInfoWrapper(RequestContext reqCtx) {
		SystemInfoWrapper wrapper = new SystemInfoWrapper(reqCtx, this);
		return wrapper;
	}
	
	/**
	 * Return the value of a System parameter.
	 * @param paramName The name of parameters
	 * @return The value to return
	 */
	public String getConfigParameter(String paramName) {
		try {
			return this.getConfigManager().getParam(paramName);
		} catch (Throwable t) {
			_logger.error("Error extracting config parameter - parameter ", paramName, t);
			return null;
		}
	}
	
	public IPage getCurrentPage(RequestContext reqCtx) {
		try {
			IPage page = (IPage) reqCtx.getExtraParam(SystemConstants.EXTRAPAR_CURRENT_PAGE);
			return page;
		} catch (Throwable t) {
			_logger.error("Error getting current page", t);
			return null;
		}
	}
	
	public IPage getPageWithWidget(String widgetCode) {
		IPage page = null;
		try {
			List<IPage> pages = this.getPageManager().getWidgetUtilizers(widgetCode);
			if (null != pages && !pages.isEmpty()) {
				page = pages.get(0);
			}
			return page;
		} catch (Throwable t) {
			_logger.error("Error getting page with widget: {}", widgetCode, t);
			return null;
		}
	}
	
	public String getPageURLWithWidget(String widgetCode, RequestContext reqCtx) {
		String url = null;
		try {
			IPage page = this.getPageWithWidget(widgetCode);
			if (null != page) {
				PageURL pageUrl = this.getUrlManager().createURL(reqCtx);
				pageUrl.setPage(page);
				url = pageUrl.getURL();
			}
		} catch (Throwable t) {
			_logger.error("Error getting pageUrl with widget: {}", widgetCode, t);
			return null;
		}
		return url;
	}
	
	public Lang getCurrentLang(RequestContext reqCtx) {
		try {
			return (Lang) reqCtx.getExtraParam(SystemConstants.EXTRAPAR_CURRENT_LANG);
		} catch (Throwable t) {
			_logger.error("Error getting current lang", t);
			return null;
		}
	}
	
	public Widget getCurrentWidget(RequestContext reqCtx) {
		try {
			return (Widget) reqCtx.getExtraParam(SystemConstants.EXTRAPAR_CURRENT_WIDGET);
		} catch (Throwable t) {
			_logger.error("Error getting current Widget", t);
			return null;
		}
	}
	
	protected ConfigInterface getConfigManager() {
		return _configManager;
	}
	public void setConfigManager(ConfigInterface configManager) {
		this._configManager = configManager;
	}
	
	protected IPageManager getPageManager() {
		return _pageManager;
	}
	public void setPageManager(IPageManager pageManager) {
		this._pageManager = pageManager;
	}
	
	protected IURLManager getUrlManager() {
		return _urlManager;
	}
	public void setUrlManager(IURLManager urlManager) {
		this._urlManager = urlManager;
	}
	
	private ConfigInterface _configManager;
	private IPageManager _pageManager;
	private IURLManager _urlManager;
	
}
