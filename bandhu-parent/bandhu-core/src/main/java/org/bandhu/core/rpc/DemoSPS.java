package org.bandhu.core.rpc;

import org.bandhu.core.rpc.sp.RPCServiceProviderService;

public enum DemoSPS implements RPCServiceProviderService {
    POST_NEW("metaWeblog.newPost", null, null, false);

    private String methodName;
    private Class payload;
    private Class entity;
    private boolean authenticationRequired;

    private <P extends Parameters, T> DemoSPS(String methodName,
            Class<P> payload, Class<T> entity, boolean authenticationRequired) {
        this.methodName = methodName;
        this.payload = payload;
        this.entity = entity;
        this.authenticationRequired = authenticationRequired;
    }

    @Override
    public String getMethodName() {
        return methodName;
    }

    @Override
    public <P extends Parameters> Class<P> getPayload() {
        return payload;
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
