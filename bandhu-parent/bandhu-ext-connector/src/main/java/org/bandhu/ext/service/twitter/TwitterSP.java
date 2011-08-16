package org.bandhu.ext.service.twitter;

import java.util.List;

import org.bandhu.core.rest.sp.ServiceProvider;
import org.bandhu.core.rest.sp.ServiceProviderService;
import org.bandhu.core.rest.sp.SimpleSPService;
import org.bandhu.util.BandhuUtil.Method;
import org.bandhu.util.BandhuUtil.Protocol;

public class TwitterSP implements ServiceProvider {
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
    public ServiceProviderService getRequestTokenEndpoint() {
        return new SimpleSPService(Protocol.HTTPS, Method.GET,
                "https://api.twitter.com/oauth/request_token", String.class, 0);
    }

    @Override
    public ServiceProviderService getAuthorizeTokenEndpoint() {
        return new SimpleSPService(Protocol.HTTPS, Method.GET,
                "https://api.twitter.com/oauth/authorize", String.class, 0);
    }

    @Override
    public ServiceProviderService getAccessTokenEndpoint() {
        return new SimpleSPService(Protocol.HTTPS, Method.GET,
                "https://api.twitter.com/oauth/access_token", String.class, 0);
    }

    @Override
    public <S extends ServiceProviderService> List<S> getServices() {
        // TODO Auto-generated method stub
        return null;
    }

}
