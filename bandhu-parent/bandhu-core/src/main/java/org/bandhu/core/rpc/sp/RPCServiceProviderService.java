package org.bandhu.core.rpc.sp;

public interface RPCServiceProviderService {
    public String getMethodName();

    public <P extends Parameters> Class<P> getPayload();

    public <T> Class<T> getEntity();

    public boolean isAuthenticationRequired();

    public interface Parameters {
        public Object getPayload();
    }

}
