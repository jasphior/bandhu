package org.bandhu.core;

import java.io.Serializable;

public interface BandhuServiceProvider extends Serializable {
    String getServiceName();

    String getServiceHomeURL();

    String getServiceVersion();

}
