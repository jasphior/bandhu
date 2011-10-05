package org.bandhu.util;

import java.util.Map;

public class BandhuConfig {
    private static ServiceID SERVICE_ID;
    private static ServiceParams SERVICE_PARAMS;

    private static Object[] MANDATORY = { SERVICE_ID, SERVICE_PARAMS };

    public static boolean isConfigured() {
        for (Object obj : MANDATORY) {
            if (obj == null) {
                return false;
            }

        }
        return true;
    }

    public static ServiceID getServiceID() throws BandhuException {
        if (SERVICE_ID == null) {
            throw new BandhuException("No service reolver configured!");
        }
        return SERVICE_ID;
    }

    public static void setServiceResolver(ServiceID serviceId) {
        SERVICE_ID = serviceId;
    }

    public static ServiceID resolve(Class<?> clazz) throws BandhuException {
        return SERVICE_ID.resolve(clazz);
    }

    public static int resolveToId(Class<?> clazz) throws BandhuException {
        return SERVICE_ID.resolve(clazz).getId();
    }

    public static ServiceParams getServiceParams() {
        return SERVICE_PARAMS;
    }

    public static void setServiceParams(ServiceParams serviceParams) {
        BandhuConfig.SERVICE_PARAMS = serviceParams;
    }

    public static Map<String, ?> getParametersOf(Class clazz, String key) {
        return SERVICE_PARAMS.getParametersOf(clazz, key);
    }

    public static Object getParameter(Class clazz, String key,
            Object defaultValue) {
        return SERVICE_PARAMS.getParameter(clazz, key, defaultValue);
    }

    public static void addParameter(Class clazz, String key, Object value) {
        SERVICE_PARAMS.addParameter(clazz, key, value);
    }
}
