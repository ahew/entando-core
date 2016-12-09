package org.entando.entando.aps.system.common.renderer.wrapper;

import com.agiletec.aps.system.RequestContext;

/**
 * The factory for build the {@link SystemInfoWrapper} class.
 * @author E.Mezzano
 */
public interface ISystemInfoWrapperFactory {
	
	public SystemInfoWrapper buildSystemInfoWrapper(RequestContext reqCtx);
	
}
