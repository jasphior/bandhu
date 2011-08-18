package org.bandhu.ext.wp.service;

import java.util.List;

import org.bandhu.core.rpc.sp.RPCServiceProvider;
import org.bandhu.core.rpc.sp.RPCServiceProviderService;

public class WordPressSP implements RPCServiceProvider {

    @Override
    public String getServiceName() {
        return "WordPress";
    }

    @Override
    public String getServiceHomeURL() {
        return "wordpress.org";
    }

    @Override
    public String getServiceVersion() {
        return "3.1";
    }

    @Override
    public RPCServiceProviderService getRPCEndpoint() {
        return null;
    }

    @Override
    public <S extends RPCServiceProviderService> List<S> getServices() {
        // TODO Auto-generated method stub
        return null;
    }

}
