package org.bandhu.core.rpc.sp;

public interface RPCServiceProviderService {
    public String getMethodName();

    public Class<?> getEntity();

    public boolean isAuthenticationRequired();

}
