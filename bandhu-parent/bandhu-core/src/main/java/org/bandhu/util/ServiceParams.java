package org.bandhu.util;

import java.util.HashMap;
import java.util.Map;

public abstract class ServiceParams {
    private static Map<Class, Map<String, Object>> params = new HashMap<Class, Map<String, Object>>();

    public static Map<String, ?> getParametersOf(Class clazz, String key) {
        return params.get(clazz);
    }

    public static Object getParameter(Class clazz, String key,
            Object defaultValue) {
        Map<String, ?> clazzParams = params.get(clazz);
        if (clazzParams != null) {
            return clazzParams.get(key);
        }
        return defaultValue;
    }

    public static void addParameter(Class clazz, String key, Object value) {
        Map<String, Object> clazzParams = params.get(clazz);
        if (clazzParams == null) {
            clazzParams = new HashMap<String, Object>();
            params.put(clazz, clazzParams);
        }
        clazzParams.put(key, value);
    }
}
