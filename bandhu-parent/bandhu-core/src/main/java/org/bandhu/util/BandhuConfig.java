package org.bandhu.util;

public class BandhuConfig {
    private static ServiceID serviceID;

    public static ServiceID getServiceID() throws BandhuException {
        if (serviceID == null) {
            throw new BandhuException("No service reolver configured!");
        }
        return serviceID;
    }

    public static void setServiceResolver(ServiceID serviceId) {
        serviceID = serviceId;
    }

    public static ServiceID resolve(Class<?> clazz) throws BandhuException {
        return getServiceID().resolve(clazz);
    }

    public static int resolveToId(Class<?> clazz) throws BandhuException {
        return getServiceID().resolve(clazz).getId();
    }
}
