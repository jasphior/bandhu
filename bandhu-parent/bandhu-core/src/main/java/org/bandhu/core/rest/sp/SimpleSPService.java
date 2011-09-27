package org.bandhu.core.rest.sp;

import org.bandhu.util.BandhuUtil.Method;
import org.bandhu.util.BandhuUtil.Protocol;

public class SimpleSPService implements RESTServiceProviderService {
    private Protocol protocol;
    private Method method;
    private String url;
    private Class<?> entity;
    private int urlParams;
    private boolean authenticationRequired;

    public SimpleSPService(final String url) {
        this.protocol = Protocol.HTTP;
        this.method = Method.GET;
        this.url = url;
        this.entity = String.class;
        this.urlParams = 0;
        this.authenticationRequired = false;
    }

    public SimpleSPService(final Protocol protocol, final Method method,
            final String url, final Class<?> entity,
            boolean authenticationRequired, final int urlParams) {
        this.protocol = protocol;
        this.method = method;
        this.url = url;
        this.entity = entity;
        this.authenticationRequired = authenticationRequired;
        this.urlParams = urlParams;
    }

    @Override
    public Method getMethod() {
        return method;
    }

    @Override
    public String getURL() {
        return url;
    }

    @Override
    public Protocol getProtocol() {
        return protocol;
    }

    @Override
    public Class<?> getEntity() {
        return entity;
    }

    @Override
    public int getURLParamCount() {
        return urlParams;
    }

    @Override
    public boolean isAuthenticationRequired() {
        return authenticationRequired;
    }
}
