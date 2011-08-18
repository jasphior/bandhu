package org.bandhu.ext.service.twitter;

import java.util.List;

import org.bandhu.core.rest.sp.RESTServiceProvider;
import org.bandhu.core.rest.sp.RESTServiceProviderService;
import org.bandhu.core.rest.sp.SimpleSPService;
import org.bandhu.util.BandhuUtil.Method;
import org.bandhu.util.BandhuUtil.Protocol;

public class TwitterSP implements RESTServiceProvider {
    @Override
    public String getServiceName() {
        return "Twitter";
    }

    @Override
    public String getServiceHomeURL() {
        return "twitter.com";
    }

    @Override
    public String getServiceVersion() {
        return "1";
    }

    @Override
    public RESTServiceProviderService getRequestTokenEndpoint() {
        return new SimpleSPService(Protocol.HTTPS, Method.GET,
                "https://api.twitter.com/oauth/request_token", String.class,
                false, 0);
    }

    @Override
    public RESTServiceProviderService getAuthorizeTokenEndpoint() {
        return new SimpleSPService(Protocol.HTTPS, Method.GET,
                "https://api.twitter.com/oauth/authorize", String.class, false,
                0);
    }

    @Override
    public RESTServiceProviderService getAccessTokenEndpoint() {
        return new SimpleSPService(Protocol.HTTPS, Method.GET,
                "https://api.twitter.com/oauth/access_token", String.class,
                false, 0);
    }

    @Override
    public <S extends RESTServiceProviderService> List<S> getServices() {
        // TODO Auto-generated method stub
        return null;
    }

}
