package org.bandhu.core;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.MultivaluedMap;

import org.bandhu.util.BandhuUtil;
import org.bandhu.util.BandhuUtil.Method;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.core.util.MultivaluedMapImpl;

public class BandhuRequest {
    protected Client client;
    protected WebResource resource;
    protected Method method;
    protected String endpoint;
    protected String appendToUrl;
    protected Class<?> entity;
    protected Object payload;
    protected Map<String, String> urlTokenData = new HashMap<String, String>();
    protected Map<String, String> queryParams = new HashMap<String, String>();
    protected boolean prepared;

    public BandhuRequest() {
        client = Client.create();
    }

    public BandhuRequest(Client client) {
        this.client = client;
    }

    public BandhuRequest(ClientConfig clientConfig) {
        this.client = Client.create(clientConfig);
    }

    public void setEndpoint(Method method, String endpoint) {
        this.method = method;
        this.endpoint = endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.method = Method.GET;
        this.endpoint = endpoint;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setAppendToUrl(String appendToUrl) {
        this.appendToUrl = appendToUrl;
    }

    public void setUrlTokenData(String... urlTokenData) {
        this.urlTokenData = BandhuUtil.convertToKeyValue(urlTokenData);
    }

    public void prepare() {
        prepare(null);
    }

    public void prepare(Map<String, String> serviceParameters) {
        Map<String, String> paramz = new HashMap<String, String>();
        if (BandhuUtil.hasValue(serviceParameters))
            paramz.putAll(serviceParameters);
        paramz.putAll(urlTokenData);
        if (BandhuUtil.hasText(appendToUrl)) {
            if (appendToUrl.indexOf(":") == 0) {
                endpoint += appendToUrl;
            } else {
                endpoint = (endpoint.indexOf("?") > -1) ? endpoint
                        .charAt(endpoint.length() - 1) == '=' ? endpoint
                        + appendToUrl : endpoint + "&" + appendToUrl : endpoint
                        + "?" + appendToUrl;
            }
        }
        if (urlTokenData != null) {
            endpoint = BandhuUtil.replaceTokens(endpoint, urlTokenData);
        }

        endpoint = BandhuUtil.encodeEndpoint(endpoint);

        resource = client.resource(endpoint);

        MultivaluedMap<String, String> mmap = new MultivaluedMapImpl();

        for (String key : queryParams.keySet()) {
            mmap.putSingle(key, queryParams.get(key));
        }

        resource = resource.queryParams(mmap);

        endpoint = resource.getURI().toString();

        prepared = true;
    }

    public WebResource buildWebResource() {
        return buildWebResource(null);
    }

    public WebResource buildWebResource(Map<String, String> serviceParameters) {
        if (!prepared) {
            prepare(serviceParameters);
        } else {
            resource = client.resource(endpoint);
        }
        return resource;
    }

    public Map<String, String> addQueryParams(Map<String, String> params) {
        queryParams.putAll(params);
        return queryParams;
    }

    public Map<String, String> addQueryParam(String key, String value) {
        queryParams.put(key, value);
        return queryParams;
    }

    public Map<String, String> removeQueryParam(String key) {
        queryParams.remove(key);
        return queryParams;
    }

    public void setEntity(Class<?> entity) {
        this.entity = entity;
    }

    public Class<?> getEntity() {
        return entity;
    }

    public Method getMethod() {
        return method;
    }

    public Client getClient() {
        return client;
    }

    public Object getPayload() {
        return payload;
    }

    public void setPayload(Object payload) {
        this.payload = payload;
    }

    public Map<String, String> getQueryParams() {
        return queryParams;
    }

    public Map<String, String> getUrlTokenData() {
        return urlTokenData;
    }
}
