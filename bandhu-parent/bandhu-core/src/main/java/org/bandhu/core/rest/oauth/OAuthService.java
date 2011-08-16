package org.bandhu.core.rest.oauth;

import java.util.HashMap;
import java.util.Map;

import org.bandhu.core.rest.BandhuRESTService;
import org.bandhu.core.rest.sp.RESTServiceProvider;
import org.bandhu.core.rest.sp.RESTServiceProviderService;
import org.bandhu.core.rest.sp.SimpleSPService;
import org.bandhu.util.BandhuException;
import org.bandhu.util.BandhuUtil;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.oauth.client.OAuthClientFilter;
import com.sun.jersey.oauth.signature.HMAC_SHA1;
import com.sun.jersey.oauth.signature.OAuthParameters;
import com.sun.jersey.oauth.signature.OAuthSecrets;
import com.sun.jersey.oauth.signature.OAuthSignature;
import com.sun.jersey.oauth.signature.OAuthSignatureException;

public class OAuthService extends BandhuRESTService {
    private String scope;
    private OAuthToken token;
    private OAuthToken accessToken;
    private RESTServiceProvider serviceProvider;
    private Map<String, String> serviceParameters = new HashMap<String, String>();

    public OAuthService(OAuthConsumer oAuthConsumer,
            Class<? extends RESTServiceProvider> serviceProviderClazz)
            throws BandhuException {
        super(oAuthConsumer.getKey(), oAuthConsumer);
        this.serviceProvider = BandhuUtil.createInstance(serviceProviderClazz);
        init();
    }

    private void init() {
        this.serviceParameters.put(OAuthConstants.CLIENT_API_ID,
                getOAuthConsumer().getClientId());
        this.serviceParameters.put(OAuthConstants.CLIENT_API_KEY,
                getOAuthConsumer().getKey());
        this.serviceParameters.put(OAuthConstants.CONSUMER_SECRET,
                getOAuthConsumer().getSecret());
    }

    public OAuthService setScope(String scope) {
        this.scope = scope;
        return this;
    }

    public String getScope() {
        return scope;
    }

    public OAuthRequest createRequest(String url, String appendToURL,
            String... urlTokenData) {
        return new OAuthRequest(this, new SimpleSPService(url), appendToURL,
                urlTokenData);
    }

    public OAuthRequest createRequest(RESTServiceProviderService service) {
        return new OAuthRequest(this, service);
    }

    public OAuthRequest createRequest(RESTServiceProviderService service,
            String appendToURL, String... urlTokenData) {
        return new OAuthRequest(this, service, appendToURL, urlTokenData);
    }

    public OAuthToken getRequestToken(String callback) throws BandhuException {
        RESTServiceProviderService requestEndpoint = serviceProvider
                .getRequestTokenEndpoint();
        OAuthRequest request = createRequest(requestEndpoint, null);
        if (BandhuUtil.hasText(callback)) {
            request.parameters().callback(callback);
        } else {
            request.parameters().callback(OAuthConstants.OUT_OF_BAND);
        }

        token = (OAuthToken) execute(request, Call.REQUEST_TOKEN,
                ClientResponse.class);

        serviceParameters.put(OAuthConstants.TOKEN, token.getToken());
        return token;
    }

    public OAuthToken getRequestToken() throws BandhuException {
        return getRequestToken(null);
    }

    public OAuthToken fetchAccessToken(String callback) throws BandhuException {
        RESTServiceProviderService requestEndpoint = serviceProvider
                .getAccessTokenEndpoint();
        OAuthRequest request = createRequest(requestEndpoint, null);
        if (BandhuUtil.hasText(callback)) {
            request.parameters().callback(callback);
        }
        accessToken = (OAuthToken) execute(request, Call.ACCESS_TOKEN,
                ClientResponse.class);
        connected = true;
        serviceParameters.put(OAuthConstants.ACCESS_TOKEN,
                accessToken.getToken());
        return accessToken;
    }

    public OAuthToken fetchAccessToken() throws BandhuException {
        return fetchAccessToken(null);
    }

    public OAuthToken getAccessToken() throws BandhuException {
        return accessToken;
    }

    public String getAuthenticationURL(String callback) throws BandhuException {
        if (token == null) {
            token = getRequestToken(callback);
        }

        return getCallableAuthUrl();
    }

    public String getAuthenticationURL() throws BandhuException {
        if (token == null) {
            token = getRequestToken();
        }

        return getCallableAuthUrl();
    }

    private String getCallableAuthUrl() {
        String url = null;
        String oauth_token = "";
        if (token != null) {
            url = token.getAuthUrl() != null ? token.getAuthUrl()
                    : serviceProvider.getAuthorizeTokenEndpoint().getURL();
            oauth_token = token.getToken();
        } else {
            url = serviceProvider.getAuthorizeTokenEndpoint().getURL();
        }
        url = BandhuUtil.replaceTokens(url, serviceParameters);
        if (BandhuUtil.hasText(url)) {
            if (url.contains(OAuthConstants.TOKEN)) {
                return url;
            } else {
                return url + ((url.contains("?")) ? "&" : "?")
                        + OAuthConstants.TOKEN + "=" + oauth_token;
            }
        } else {
            return null;
        }
    }

    private <T> Object execute(OAuthRequest oAuthRequest, Call call, Class<T> t)
            throws BandhuException {

        OAuthParameters params = oAuthRequest.parameters()
                .signatureMethod(HMAC_SHA1.NAME).timestamp().nonce().version();
        params.consumerKey(getOAuthConsumer().getKey());

        OAuthSecrets secrets = oAuthRequest.secrets();
        secrets.consumerSecret(getOAuthConsumer().getSecret());

        // establish the secrets that will be used to sign the request
        String endpoint = null;
        switch (call) {
        case REQUEST_TOKEN:
            if (BandhuUtil.hasText(scope)) {
                params.put("scope", scope);
                oAuthRequest.addHeaderValue("scope",
                        BandhuUtil.encodeURL(scope));
            }
            endpoint = oAuthRequest.getServiceProvider()
                    .getRequestTokenEndpoint().getURL();
            break;
        case ACCESS_TOKEN:
            endpoint = oAuthRequest.getServiceProvider()
                    .getAccessTokenEndpoint().getURL();
            params.token(token.getToken()).verifier(token.getVerifier());
            secrets.tokenSecret(token.getTokenSecret());
            String realm = token.getRealm();
            if (realm != null)
                params.realm(realm);
            break;
        case PROCESS:
            endpoint = oAuthRequest.getServiceProviderService().getURL();
            params.token(accessToken.getToken());
            secrets.tokenSecret(accessToken.getTokenSecret());
            break;
        }

        if (!BandhuUtil.hasText(endpoint)) {
            throw new BandhuException("No endpoint specified!!");
        }

        oAuthRequest.prepare(serviceParameters);

        System.out.println("Endpoint resolved to -> "
                + oAuthRequest.getEndpoint());

        // generate the digital signature and set in the request
        try {
            OAuthSignature.sign(oAuthRequest, params, secrets);
        } catch (OAuthSignatureException e) {
            throw new BandhuException(e.getMessage());
        }

        Client client = oAuthRequest.getClient();
        client.setFollowRedirects(true);
        OAuthClientFilter filter = new OAuthClientFilter(client.getProviders(),
                params, secrets);
        // OAuth test server resource
        WebResource resource = oAuthRequest.buildWebResource();
        resource.addFilter(filter);
        System.out.println(oAuthRequest.getHeaderParameters());
        // make the request (signing it in the process)

        Object response = execute(resource, oAuthRequest, t);

        if (call == Call.REQUEST_TOKEN || call == Call.ACCESS_TOKEN) {
            ClientResponse clientResponse = (ClientResponse) response;
            String entity = clientResponse.getEntity(String.class);
            System.out.println("response : " + entity);
            System.out.println("HEAD-> " + clientResponse.getHeaders());
            System.out.println("PROP-> " + clientResponse.getProperties());
            System.out.println("STATUS-> " + clientResponse.getStatus());
            return OAuthToken.parse(call, entity);
        } else {
            System.out.println("response : " + response);
            if (response instanceof ClientResponse) {
                ClientResponse clientResponse = (ClientResponse) response;
                System.out.println("HEAD-> " + clientResponse.getHeaders());
                System.out.println("PROP-> " + clientResponse.getProperties());
                System.out.println("STATUS-> " + clientResponse.getStatus());

            }
            return response;
        }
    }

    public ClientResponse process(OAuthRequest oAuthRequest)
            throws BandhuException {
        ClientResponse clientResponse = (ClientResponse) process(oAuthRequest,
                ClientResponse.class);
        System.out.println("HEAD-> " + clientResponse.getHeaders());
        Client client = (Client) clientResponse.getProperties().get(
                Client.class.getName());
        System.out.println("PROP-> " + client.getProperties());
        System.out.println("STATUS-> " + clientResponse.getStatus());
        return clientResponse;
    }

    public <T> T process(OAuthRequest oAuthRequest, Class<T> t)
            throws BandhuException {
        if (accessToken == null) {
            fetchAccessToken();
        }
        return (T) execute(oAuthRequest, Call.PROCESS, t);
    }

    public OAuthConsumer getOAuthConsumer() {
        return (OAuthConsumer) consumer;
    }

    public OAuthToken getToken() {
        return token;
    }

    public void setVerifier(String verifier) {
        this.serviceParameters.put(OAuthConstants.VERIFIER, verifier);
        token.setVerifier(verifier);
    }

    public void setAccessToken(OAuthToken accessToken) {
        this.accessToken = accessToken;
    }

    public RESTServiceProvider getServiceProvider() {
        return serviceProvider;
    }

    public Map<String, String> getParameters() {
        return serviceParameters;
    }

    public Map<String, String> addParameter(String key, String value) {
        serviceParameters.put(key, value);
        return serviceParameters;
    }

    public void setToken(OAuthToken oAuthToken) {
        this.token = oAuthToken;
    }

    public enum Call {
        REQUEST_TOKEN, ACCESS_TOKEN, PROCESS
    }

}
