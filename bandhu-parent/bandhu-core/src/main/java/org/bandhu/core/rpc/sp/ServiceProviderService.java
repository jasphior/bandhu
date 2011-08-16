package org.bandhu.core.rpc.sp;

public interface ServiceProviderService {
    public String getMethodName();

    public <P extends Parameters> Class<P> getPayload();

    public <T> Class<T> getEntity();

    public interface Parameters {
        public Object getPayload();
    }
}
