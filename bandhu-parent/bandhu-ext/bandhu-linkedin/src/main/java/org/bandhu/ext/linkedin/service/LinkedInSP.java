package org.bandhu.ext.linkedin.service;

import java.util.Arrays;
import java.util.List;

import org.bandhu.core.rest.sp.ServiceProvider;
import org.bandhu.core.rest.sp.ServiceProviderService;
import org.bandhu.core.rest.sp.SimpleSPService;
import org.bandhu.util.BandhuUtil.Method;
import org.bandhu.util.BandhuUtil.Protocol;

public class LinkedInSP implements ServiceProvider {
    private static final String requestToken = "https://api.linkedin.com/uas/oauth/requestToken";
    private static final String authorize = "https://api.linkedin.com/uas/oauth/authorize";
    private static final String accessToken = "https://api.linkedin.com/uas/oauth/accessToken";

    public String getServiceName() {
        return "LinkedIn";
    }

    public String getServiceHomeURL() {
        return "LinkedIn.com";
    }

    public String getServiceVersion() {
        return "1.6";
    }

    @Override
    public ServiceProviderService getRequestTokenEndpoint() {
        return new SimpleSPService(Protocol.HTTPS, Method.GET, requestToken,
                String.class, 0);
    }

    @Override
    public ServiceProviderService getAuthorizeTokenEndpoint() {
        return new SimpleSPService(Protocol.HTTPS, Method.GET, authorize,
                String.class, 0);
    }

    @Override
    public ServiceProviderService getAccessTokenEndpoint() {
        return new SimpleSPService(Protocol.HTTPS, Method.GET, accessToken,
                String.class, 0);
    }

    @Override
    public List<LinkedInSPServices> getServices() {
        List<LinkedInSPServices> list = Arrays.asList(LinkedInSPServices
                .values());
        return list;
    }

}
