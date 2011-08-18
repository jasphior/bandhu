package org.bandhu.ext.wp.bean;

import java.util.Arrays;

import org.bandhu.core.rpc.annotation.Struct;

public class Post {
    // title The title of the item.
    @Struct
    private String title;
    // link The URL of the item.
    @Struct
    private String link;
    // description The item synopsis.
    @Struct
    private String description;
    // author Email address of the author of the item.
    @Struct
    private String author;
    // category Includes the item in one or more categories.
    @Struct
    private String[] category;
    // comments URL of a page for comments relating to the item.
    @Struct
    private String comments;
    // enclosure Describes a media object that is attached to the item.
    @Struct
    private String enclosure;
    // guid A string that uniquely identifies the item.
    @Struct
    private String guid;
    // pubDate Indicates when the item was published.
    @Struct
    private String pubDate;
    // source The RSS channel that the item came from.
    @Struct
    private String source;

    private boolean publish;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String[] getCategory() {
        return category;
    }

    public void setCategory(String[] category) {
        this.category = category;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getEnclosure() {
        return enclosure;
    }

    public void setEnclosure(String enclosure) {
        this.enclosure = enclosure;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public boolean isPublish() {
        return publish;
    }

    public void setPublish(boolean publish) {
        this.publish = publish;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Post [");
        if (title != null) {
            builder.append("title=");
            builder.append(title);
            builder.append(", ");
        }
        if (link != null) {
            builder.append("link=");
            builder.append(link);
            builder.append(", ");
        }
        if (description != null) {
            builder.append("description=");
            builder.append(description);
            builder.append(", ");
        }
        if (author != null) {
            builder.append("author=");
            builder.append(author);
            builder.append(", ");
        }
        if (category != null) {
            builder.append("category=");
            builder.append(Arrays.toString(category));
            builder.append(", ");
        }
        if (comments != null) {
            builder.append("comments=");
            builder.append(comments);
            builder.append(", ");
        }
        if (enclosure != null) {
            builder.append("enclosure=");
            builder.append(enclosure);
            builder.append(", ");
        }
        if (guid != null) {
            builder.append("guid=");
            builder.append(guid);
            builder.append(", ");
        }
        if (pubDate != null) {
            builder.append("pubDate=");
            builder.append(pubDate);
            builder.append(", ");
        }
        if (source != null) {
            builder.append("source=");
            builder.append(source);
            builder.append(", ");
        }
        builder.append("publish=");
        builder.append(publish);
        builder.append("]");
        return builder.toString();
    }

}
