package org.bandhu.ext.wp.bean;

import org.bandhu.core.rpc.annotation.Struct;

public class Author {
    @Struct(name = "user_id")
    private int userId;
    @Struct(name = "user_login")
    private String userLogin;
    @Struct(name = "display_name")
    private String displayName;
    @Struct(name = "meta_value")
    private String metaValue;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getMetaValue() {
        return metaValue;
    }

    public void setMetaValue(String metaValue) {
        this.metaValue = metaValue;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Author [userId=");
        builder.append(userId);
        builder.append(", ");
        if (userLogin != null) {
            builder.append("userLogin=");
            builder.append(userLogin);
            builder.append(", ");
        }
        if (displayName != null) {
            builder.append("displayName=");
            builder.append(displayName);
            builder.append(", ");
        }
        if (metaValue != null) {
            builder.append("metaValue=");
            builder.append(metaValue);
        }
        builder.append("]");
        return builder.toString();
    }

}
