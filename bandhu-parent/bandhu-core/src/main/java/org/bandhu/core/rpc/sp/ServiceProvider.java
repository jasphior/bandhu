package org.bandhu.core.rpc.sp;

import java.util.List;

import org.bandhu.core.BandhuService;

public interface ServiceProvider extends BandhuService {
    public ServiceProviderService getRPCEndpoint();

    public <S extends ServiceProviderService> List<S> getServices();

    public static final String BLOG_ID = "blog_id";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String PAGE_ID = "page_id";
}
