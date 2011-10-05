package org.bandhu.ext.util;

import org.bandhu.ext.twitter.TwitterService;

public class ServiceParams extends org.bandhu.util.ServiceParams {

    public static final String TWI_MAX_FETCH = "TWI_MAX_FETCH";

    static {
        addParameter(TwitterService.class, TWI_MAX_FETCH, 100);
    }

    public static final KeyValue<Integer, String> TWI_FOLLOWERS = new KeyValue<Integer, String>(
            21, "Followers");

    public static final KeyValue<Integer, String> TWI_FOLLOWING = new KeyValue<Integer, String>(
            22, "Following");

    public static final KeyValue<Integer, String> TWI_FAVOURITES = new KeyValue<Integer, String>(
            23, "Favourites");
}
