package org.bandhu.core;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class BandhuBucket implements Serializable {
    public final Map<String, Map<String, ServiceAccessor>> bucket = new HashMap<String, Map<String, ServiceAccessor>>();

    public void PUT(String serviceProvider, String id, ServiceAccessor service) {
        Map<String, ServiceAccessor> map = bucket.get(serviceProvider);
        if (map == null) {
            map = new HashMap<String, ServiceAccessor>();
            bucket.put(serviceProvider, map);
        }
        map.put(id, service);
    }

    public ServiceAccessor GET(String serviceProvider, String id) {
        Map<String, ServiceAccessor> map = bucket.get(serviceProvider);
        if (map == null) {
            return null;
        } else {
            return map.get(id);
        }
    }
}
