package org.bandhu.core.rpc.sp.ext;

import org.bandhu.core.rpc.sp.RPCServiceProviderService;

public enum MetaWeblogService implements RPCServiceProviderService {
    /**
     * metaWeblog.newPost (blogid, username, password, struct, publish) returns
     * string
     */
    POST_POST("metaWeblog.newPost", null, true),

    /**
     * metaWeblog.editPost (postid, username, password, struct, publish) returns
     * true
     */
    EDIT_POST("metaWeblog.editPost", null, true),

    /**
     * metaWeblog.getPost (postid, username, password) returns struct
     */
    GET_POST("metaWeblog.getPost", null, true),

    /**
     * metaWeblog.getRecentPosts (blogid, username, password, numberOfPosts)
     * returns array of structs
     */
    GET_POSTS("metaWeblog.getRecentPosts ", null, true);

    private String method;
    private Class<?> entity;
    private boolean authenticationRequired;

    MetaWeblogService(final String method, final Class<?> entity,
            boolean authenticationRequired) {
        this.method = method;
        this.entity = entity;
        this.authenticationRequired = authenticationRequired;
    }

    public String getMethodName() {
        return method;
    }

    public Class<?> getEntity() {
        return entity;
    }

    public boolean isAuthenticationRequired() {
        return authenticationRequired;
    }
}
