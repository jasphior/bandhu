package org.bandhu.core.rpc.sp;

import java.util.List;

import org.bandhu.core.BandhuServiceProvider;

public interface RPCServiceProvider extends BandhuServiceProvider {
    public RPCServiceProviderService getRPCEndpoint();

    public <S extends RPCServiceProviderService> List<S> getServices();

    public static final String BLOG_ID = "blog_id";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String PAGE_ID = "page_id";
}
