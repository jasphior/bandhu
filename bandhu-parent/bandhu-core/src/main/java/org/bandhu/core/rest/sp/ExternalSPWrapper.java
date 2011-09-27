package org.bandhu.core.rest.sp;

import org.bandhu.core.BandhuServiceProvider;

public interface ExternalSPWrapper extends BandhuServiceProvider {

    public String getUserAuthorizationURL();

    public String getAccessToken();
}
