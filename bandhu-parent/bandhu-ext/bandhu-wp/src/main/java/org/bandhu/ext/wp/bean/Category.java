package org.bandhu.ext.wp.bean;

import org.bandhu.core.rpc.annotation.Struct;

public class Category {
    // int categoryId
    @Struct
    private int categoryId;
    // int parentId
    @Struct
    private int parentId;
    // string description
    @Struct
    private String description;
    // string categoryName
    @Struct
    private String categoryName;
    // string htmlUrl
    @Struct
    private String htmlUrl;
    // string rssUrl
    @Struct
    private String rssUrl;

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    public String getRssUrl() {
        return rssUrl;
    }

    public void setRssUrl(String rssUrl) {
        this.rssUrl = rssUrl;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Category [categoryId=");
        builder.append(categoryId);
        builder.append(", parentId=");
        builder.append(parentId);
        builder.append(", ");
        if (description != null) {
            builder.append("description=");
            builder.append(description);
            builder.append(", ");
        }
        if (categoryName != null) {
            builder.append("categoryName=");
            builder.append(categoryName);
            builder.append(", ");
        }
        if (htmlUrl != null) {
            builder.append("htmlUrl=");
            builder.append(htmlUrl);
            builder.append(", ");
        }
        if (rssUrl != null) {
            builder.append("rssUrl=");
            builder.append(rssUrl);
        }
        builder.append("]");
        return builder.toString();
    }

}
