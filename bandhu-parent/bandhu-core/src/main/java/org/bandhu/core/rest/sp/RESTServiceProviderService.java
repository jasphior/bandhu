package org.bandhu.core.rest.sp;

import org.bandhu.util.BandhuUtil.Method;
import org.bandhu.util.BandhuUtil.Protocol;

public interface RESTServiceProviderService {
    public Method getMethod();

    public String getURL();

    public Protocol getProtocol();

    public <T> Class<T> getEntity();

    /**
     * Basically the number of non static parameters to be passed in the url
     * 
     * @return param count
     */
    public int getURLParamCount();

    public boolean isAuthenticationRequired();

}
