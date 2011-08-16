package org.bandhu.core.rest.oauth;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bandhu.core.BandhuRequest;
import org.bandhu.core.rest.sp.RESTServiceProvider;
import org.bandhu.core.rest.sp.RESTServiceProviderService;
import org.bandhu.util.BandhuException;
import org.bandhu.util.BandhuUtil;
import org.bandhu.util.BandhuUtil.Protocol;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.oauth.signature.OAuthParameters;
import com.sun.jersey.oauth.signature.OAuthSecrets;

/**
 * Implementation of OAuthRequest
 * 
 * {@link OAuthRequest}
 * 
 * @author jasphior
 * 
 */
public class OAuthRequest extends BandhuRequest implements
        com.sun.jersey.oauth.signature.OAuthRequest {

    private OAuthParameters oAuthParameters = new OAuthParameters();
    private OAuthSecrets oAuthSecrets = new OAuthSecrets();
    private Map<String, List<String>> headerParameters = new HashMap<String, List<String>>();

    private Protocol protocol;
    private String contentType;
    private OAuthService oAuthService;
    private RESTServiceProvider serviceProvider;
    private RESTServiceProviderService serviceProviderService;

    // public OAuthRequest(OAuthService oAuthService, String url,
    // String appendToURL, String... urlTokenData) {
    // this.oAuthService = oAuthService;
    // this.serviceProvider = oAuthService.getServiceProvider();
    // this.endpoint = url;
    // this.appendToUrl = appendToURL;
    // this.urlTokenData = BandhuUtil.convertToKeyValue(urlTokenData);
    // }

    public OAuthRequest(OAuthService oAuthService,
            RESTServiceProviderService service, String appendToURL,
            String... urlTokenData) {
        this.oAuthService = oAuthService;
        this.serviceProvider = oAuthService.getServiceProvider();
        this.serviceProviderService = service;
        this.endpoint = service.getURL();
        this.protocol = service.getProtocol();
        this.method = service.getMethod();
        this.entity = service.getEntity();
        this.appendToUrl = appendToURL;
        this.urlTokenData = BandhuUtil.convertToKeyValue(urlTokenData);
    }

    public OAuthRequest(OAuthService oAuthService,
            RESTServiceProviderService service) {
        this.oAuthService = oAuthService;
        this.serviceProvider = oAuthService.getServiceProvider();
        this.serviceProviderService = service;
        this.endpoint = service.getURL();
        this.protocol = service.getProtocol();
        this.method = service.getMethod();
        this.entity = service.getEntity();
    }

    public ClientResponse process() throws BandhuException {
        return oAuthService.process(this);
    }

    public <T> T process(Class<T> t) throws BandhuException {
        return oAuthService.process(this, t);
    }

    public void addHeaderValue(String key, String value)
            throws IllegalStateException {
        List<String> values = headerParameters
                .get(OAuthParameters.AUTHORIZATION_HEADER);
        String val;
        if (values != null && !values.isEmpty()) {
            val = values.get(0);
            if (BandhuUtil.hasText(val)) {
                if (val.contains(OAuthParameters.SCHEME)) {
                    val = val + ", " + key + "=" + value;
                } else {
                    val = value + ", " + val;
                }
            }
        } else {
            if (key.equals(OAuthParameters.AUTHORIZATION_HEADER)) {
                val = value;
            } else {
                val = key + "=" + value;
            }
        }
        values = new ArrayList<String>();
        values.add(val);
        headerParameters.put(OAuthParameters.AUTHORIZATION_HEADER, values);
    }

    public void addHeaderValues(Map<String, String> keyValues)
            throws IllegalStateException {
        for (String key : keyValues.keySet()) {
            addHeaderValue(key, keyValues.get(key));
        }
    }

    public List<String> getHeaderValues(String key) {
        return headerParameters.get(key);
    }

    public Set<String> getParameterNames() {
        return oAuthParameters.keySet();
    }

    public List<String> getParameterValues(String key) {
        String value = oAuthParameters.get(key);
        List<String> values = new ArrayList<String>();
        values.add(value);
        return values;
    }

    public String getRequestMethod() {
        return method.getText();
    }

    public URL getRequestURL() {
        try {
            String reqURL = "";
            if (BandhuUtil.hasText(endpoint)) {
                reqURL = endpoint;
            } else if (serviceProviderService != null) {
                reqURL = serviceProviderService.getURL();
            } else if (oAuthService != null) {
                reqURL = oAuthService.getServiceProvider()
                        .getRequestTokenEndpoint().getURL();
            }
            return new URL(reqURL);
        } catch (MalformedURLException e) {
            System.out.println("ERROR: Invalid URL!");
            e.printStackTrace();
            return null;
        }
    }

    public void addOAuthParameter(String key, String value) {
        oAuthParameters.put(key, value);
    }

    public void addOAuthParameters(Map<String, String> keyValues) {
        oAuthParameters.putAll(keyValues);
    }

    public OAuthParameters parameters() {
        return oAuthParameters;
    }

    public OAuthSecrets secrets() {
        return oAuthSecrets;
    }

    public Map<String, List<String>> getHeaderParameters() {
        return headerParameters;
    }

    public Protocol getProtocol() {
        return protocol;
    }

    public String getContentType() {
        return contentType;
    }

    public OAuthService getOAuthService() {
        return oAuthService;
    }

    public RESTServiceProvider getServiceProvider() {
        return serviceProvider;
    }

    public RESTServiceProviderService getServiceProviderService() {
        return serviceProviderService;
    }

}
