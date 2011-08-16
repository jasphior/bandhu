package org.bandhu.core.rest.sp;

import java.util.List;

import org.bandhu.core.BandhuService;

public interface ServiceProvider extends BandhuService {
    public ServiceProviderService getRequestTokenEndpoint();

    public ServiceProviderService getAuthorizeTokenEndpoint();

    public ServiceProviderService getAccessTokenEndpoint();

    public <S extends ServiceProviderService> List<S> getServices();

}
