package org.bandhu.ext.wp.bean;

import org.bandhu.core.rpc.annotation.Struct;

public class Blog {
    @Struct
    private String blogName;
    @Struct
    private String blogid;
    @Struct
    private String url;
    @Struct
    private String xmlrpc;
    @Struct
    private boolean admin;

    public String getBlogName() {
        return blogName;
    }

    public void setBlogName(String blogName) {
        this.blogName = blogName;
    }

    public String getBlogid() {
        return blogid;
    }

    public void setBlogid(String blogid) {
        this.blogid = blogid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getXmlrpc() {
        return xmlrpc;
    }

    public void setXmlrpc(String xmlrpc) {
        this.xmlrpc = xmlrpc;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Blog [");
        if (blogName != null) {
            builder.append("blogName=");
            builder.append(blogName);
            builder.append(", ");
        }
        if (blogid != null) {
            builder.append("blogid=");
            builder.append(blogid);
            builder.append(", ");
        }
        if (url != null) {
            builder.append("url=");
            builder.append(url);
            builder.append(", ");
        }
        if (xmlrpc != null) {
            builder.append("xmlrpc=");
            builder.append(xmlrpc);
            builder.append(", ");
        }
        builder.append("admin=");
        builder.append(admin);
        builder.append("]");
        return builder.toString();
    }

}