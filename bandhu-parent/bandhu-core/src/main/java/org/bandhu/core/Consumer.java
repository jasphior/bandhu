package org.bandhu.core;

import java.io.Serializable;

public class Consumer implements Serializable {
    protected String userId;
    protected String secret;

    public Consumer(String userId, String secret) {
        this.userId = userId;
        this.secret = secret;
    }

    public Consumer() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Consumer [userId=");
        builder.append(userId);
        builder.append(", secret=");
        builder.append(secret);
        builder.append("]");
        return builder.toString();
    }

}
