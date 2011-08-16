package org.bandhu.ext.service.twitter;

import org.bandhu.core.rest.sp.ServiceProviderService;
import org.bandhu.util.BandhuUtil.Method;
import org.bandhu.util.BandhuUtil.Protocol;

public enum TwitterSPServices implements ServiceProviderService {
    POSTING_LIKES(
            Protocol.HTTP,
            Method.PUT,
            "http://api.linkedin.com/v1/people/~/network/updates/key={0}/is-liked",
            String.class, 1);

    private Protocol protocol;
    private Method method;
    private String url;
    private Class<?> entity;
    private int urlParams;

    TwitterSPServices(final Protocol protocol, final Method method,
            final String url, final Class<?> entity) {
        this.protocol = protocol;
        this.method = method;
        this.url = url;
        this.entity = entity;
    }

    TwitterSPServices(final Protocol protocol, final Method method,
            final String url, final Class<?> entity, int urlParams) {
        this.protocol = protocol;
        this.method = method;
        this.url = url;
        this.entity = entity;
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

}
