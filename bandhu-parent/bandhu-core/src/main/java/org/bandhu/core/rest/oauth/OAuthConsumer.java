package org.bandhu.core.rest.oauth;

import org.bandhu.core.Consumer;

/**
 * Contains the basic info of the consumer
 * 
 * @author jasphior
 * 
 */
public class OAuthConsumer extends Consumer {
    private String key;

    public OAuthConsumer(String clientId, String key, String secret) {
        super(clientId, secret);
        this.key = key;
    }

    public OAuthConsumer(String key, String secret) {
        this.key = key;
        super.secret = secret;
    }

    public String getClientId() {
        return super.userId;
    }

    public String getKey() {
        return key;
    }

    public String getSecret() {
        return secret;
    }

}
