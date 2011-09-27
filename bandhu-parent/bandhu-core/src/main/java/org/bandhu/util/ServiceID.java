package org.bandhu.util;

public interface ServiceID {
    public int getId();

    public String getName();

    public Class<?> getServiceProvider();

    public Class<?> getAccessor();

    public ServiceID resolve(Class<?> clazz);
}
