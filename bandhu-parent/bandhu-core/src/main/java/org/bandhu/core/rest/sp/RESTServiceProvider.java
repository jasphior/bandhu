package org.bandhu.core.rest.sp;

import java.util.List;

import org.bandhu.core.BandhuServiceProvider;

public interface RESTServiceProvider extends BandhuServiceProvider {
    public RESTServiceProviderService getRequestTokenEndpoint();

    public RESTServiceProviderService getAuthorizeTokenEndpoint();

    public RESTServiceProviderService getAccessTokenEndpoint();

    public <S extends RESTServiceProviderService> List<S> getServices();

    public RESTServiceProviderService getProfileEndpoint();
}
