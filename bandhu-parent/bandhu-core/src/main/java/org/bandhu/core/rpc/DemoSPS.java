package org.bandhu.core.rpc;

import org.bandhu.core.rpc.sp.RPCServiceProviderService;

public enum DemoSPS implements RPCServiceProviderService {
    POST_NEW("metaWeblog.newPost", null, false);

    private String methodName;
    private Class entity;
    private boolean authenticationRequired;

    private DemoSPS(String methodName, Class entity,
            boolean authenticationRequired) {
        this.methodName = methodName;
        this.entity = entity;
        this.authenticationRequired = authenticationRequired;
    }

    @Override
    public String getMethodName() {
        return methodName;
    }

    @Override
    public Class getEntity() {
        return entity;
    }

    @Override
    public boolean isAuthenticationRequired() {
        return authenticationRequired;
    }
}
