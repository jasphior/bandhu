package org.bandhu.ext;

import org.bandhu.ext.linkedin.LinkedInService;
import org.bandhu.ext.linkedin.service.LinkedInSP;
import org.bandhu.ext.twitter.TwitterService;
import org.bandhu.ext.twitter.service.TwitterSP;

public enum ServiceID implements org.bandhu.util.ServiceID {
    NULL(0, "REF", null, null),

    LinkedIn(1, "LinkedIn", LinkedInSP.class, LinkedInService.class),

    Twitter(2, "Twitter", TwitterSP.class, TwitterService.class);

    private int id;
    private String name;
    private Class<?> serviceProvider;
    private Class<?> service;

    ServiceID(int id, String name, Class<?> serviceProvider, Class<?> accessor) {
        this.id = id;
        this.name = name;
        this.serviceProvider = serviceProvider;
        this.service = accessor;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Class<?> getServiceProvider() {
        return serviceProvider;
    }

    public Class<?> getAccessor() {
        return service;
    }

    public ServiceID resolve(Class<?> clazz) {
        for (ServiceID serviceID : values()) {
            if (serviceID.getServiceProvider() == clazz) {
                return serviceID;
            }
        }
        return null;
    }

    public static int resolveToId(Class<?> clazz) {
        for (ServiceID serviceID : values()) {
            if (serviceID.getServiceProvider() == clazz) {
                return serviceID.getId();
            }
        }
        return -1;
    }

    public static ServiceID get(int id) {
        for (ServiceID serviceID : values()) {
            if (serviceID.getId() == id)
                return serviceID;
        }
        return null;
    }
}
