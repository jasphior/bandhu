package org.bandhu.ext.gdata.blogger.service;

import org.bandhu.core.rest.sp.ExternalSPWrapper;

import com.google.gdata.client.authn.oauth.GoogleOAuthHelper;
import com.google.gdata.client.authn.oauth.GoogleOAuthParameters;
import com.google.gdata.client.authn.oauth.OAuthSigner;

public class BloggerSP extends GoogleOAuthHelper implements ExternalSPWrapper {

    private GoogleOAuthParameters oauthParameters;

    public BloggerSP(OAuthSigner signer, GoogleOAuthParameters oauthParameters) {
        super(signer);
        this.oauthParameters = oauthParameters;
    }

    private static final String REQUEST_TOKEN = "https://api.linkedin.com/uas/oauth/requestToken";
    private static final String AUTHORIZE = "https://api.linkedin.com/uas/oauth/authorize";
    private static final String ACCESS_TOKEN = "https://api.linkedin.com/uas/oauth/accessToken";
    public static final String SCOPE = "http://www.blogger.com/feeds/";

    public String getServiceName() {
        return "Blogger.com";
    }

    public String getServiceHomeURL() {
        return "http://blogger.com";
    }

    public String getServiceVersion() {
        return "2.0";
    }

    @Override
    public String getUserAuthorizationURL() {
        return createUserAuthorizationUrl(oauthParameters);
    }

    @Override
    public String getAccessToken() {
        // TODO Auto-generated method stub
        return null;
    }

}
