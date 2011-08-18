package org.bandhu.ext.wp.bean;

import org.bandhu.core.rpc.annotation.Struct;

public class Tag {
    @Struct(name = "tag_id")
    private int tagId;
    @Struct
    private String name;
    @Struct
    private int count;
    @Struct
    private String slug;
    @Struct(name = "html_url")
    private String htmlUrl;
    @Struct(name = "rss_url")
    private String rssUrl;

    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
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
        builder.append("Tag [tagId=");
        builder.append(tagId);
        builder.append(", ");
        if (name != null) {
            builder.append("name=");
            builder.append(name);
            builder.append(", ");
        }
        builder.append("count=");
        builder.append(count);
        builder.append(", ");
        if (slug != null) {
            builder.append("slug=");
            builder.append(slug);
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
