package org.bandhu.ext.linkedin.service;

import java.util.Arrays;
import java.util.List;

import org.bandhu.core.rest.oauth.OAuthConsumer;
import org.bandhu.core.rest.oauth.OAuthService;
import org.bandhu.core.rest.sp.RESTServiceProvider;
import org.bandhu.core.rest.sp.RESTServiceProviderService;
import org.bandhu.core.rest.sp.SimpleSPService;
import org.bandhu.util.BandhuException;
import org.bandhu.util.BandhuUtil.Method;
import org.bandhu.util.BandhuUtil.Protocol;

public class LinkedInSP extends OAuthService implements RESTServiceProvider {
    private static final String requestToken = "https://api.linkedin.com/uas/oauth/requestToken";
    private static final String authorize = "https://api.linkedin.com/uas/oauth/authorize";
    private static final String accessToken = "https://api.linkedin.com/uas/oauth/accessToken";

    public LinkedInSP(OAuthConsumer oAuthConsumer) throws BandhuException {
        super(oAuthConsumer);
    }

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
    public RESTServiceProviderService getRequestTokenEndpoint() {
        return new SimpleSPService(Protocol.HTTPS, Method.GET, requestToken,
                String.class, false, 0);
    }

    @Override
    public RESTServiceProviderService getAuthorizeTokenEndpoint() {
        return new SimpleSPService(Protocol.HTTPS, Method.GET, authorize,
                String.class, false, 0);
    }

    @Override
    public RESTServiceProviderService getAccessTokenEndpoint() {
        return new SimpleSPService(Protocol.HTTPS, Method.GET, accessToken,
                String.class, false, 0);
    }

    @Override
    public RESTServiceProviderService getProfileEndpoint() {
        return LinkedInSPService.PROFILE;
    }

    @Override
    public List<LinkedInSPService> getServices() {
        List<LinkedInSPService> list = Arrays
                .asList(LinkedInSPService.values());
        return list;
    }

}
