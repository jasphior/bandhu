package org.bandhu.ext.twitter.service;

import org.bandhu.core.rest.sp.RESTServiceProviderService;
import org.bandhu.util.BandhuUtil.Method;
import org.bandhu.util.BandhuUtil.Protocol;

public enum TwitterSPServices implements RESTServiceProviderService {
    POSTING_LIKES(
            Protocol.HTTP,
            Method.PUT,
            "http://api.linkedin.com/v1/people/~/network/updates/key={0}/is-liked",
            String.class, false, 1);

    private Protocol protocol;
    private Method method;
    private String url;
    private Class<?> entity;
    private int urlParams;
    private boolean authenticationRequired;

    TwitterSPServices(final Protocol protocol, final Method method,
            final String url, final Class<?> entity,
            boolean authenticationRequired) {
        this.protocol = protocol;
        this.method = method;
        this.url = url;
        this.entity = entity;
        this.authenticationRequired = authenticationRequired;
    }

    TwitterSPServices(final Protocol protocol, final Method method,
            final String url, final Class<?> entity,
            boolean authenticationRequired, int urlParams) {
        this.protocol = protocol;
        this.method = method;
        this.url = url;
        this.entity = entity;
        this.authenticationRequired = authenticationRequired;
        this.urlParams = urlParams;
    }

    public Protocol getProtocol() {
        return protocol;
    }

    public Method getMethod() {
        return method;
    }

    public String getURL() {
        return url;
    }

    public Class<?> getEntity() {
        return entity;
    }

    public int getURLParamCount() {
        return urlParams;
    }

    public boolean isAuthenticationRequired() {
        return authenticationRequired;
    }
}
