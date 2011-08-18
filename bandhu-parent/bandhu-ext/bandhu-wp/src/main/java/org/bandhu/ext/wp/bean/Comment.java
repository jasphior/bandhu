package org.bandhu.ext.wp.bean;

import java.sql.Timestamp;

import org.bandhu.core.rpc.annotation.Struct;

public class Comment {
    // datetime dateCreated (ISO.8601, always GMT)
    @Struct
    private Timestamp dateCreated;
    // string user_id
    @Struct(name = "user_id")
    private String userId;
    // string comment_id
    @Struct(name = "comment_id")
    private String commentId;
    // string parent
    @Struct
    private String parent;
    // string status
    @Struct
    private String status;
    // string content
    @Struct
    private String content;
    // string link
    @Struct
    private String link;
    // string post_id
    @Struct(name = "post_id")
    private String postId;
    // string post_title
    @Struct(name = "post_title")
    private String postTitle;
    // string author
    @Struct
    private String author;
    // string author_url
    @Struct(name = "author_url")
    private String authorUrl;
    // string author_email
    @Struct(name = "author_email")
    private String authorEmail;
    // string author_ip
    @Struct(name = "author_ip")
    private String authorIp;

    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthorUrl() {
        return authorUrl;
    }

    public void setAuthorUrl(String authorUrl) {
        this.authorUrl = authorUrl;
    }

    public String getAuthorEmail() {
        return authorEmail;
    }

    public void setAuthorEmail(String authorEmail) {
        this.authorEmail = authorEmail;
    }

    public String getAuthorIp() {
        return authorIp;
    }

    public void setAuthorIp(String authorIp) {
        this.authorIp = authorIp;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Comment [");
        if (dateCreated != null) {
            builder.append("dateCreated=");
            builder.append(dateCreated);
            builder.append(", ");
        }
        if (userId != null) {
            builder.append("userId=");
            builder.append(userId);
            builder.append(", ");
        }
        if (commentId != null) {
            builder.append("commentId=");
            builder.append(commentId);
            builder.append(", ");
        }
        if (parent != null) {
            builder.append("parent=");
            builder.append(parent);
            builder.append(", ");
        }
        if (status != null) {
            builder.append("status=");
            builder.append(status);
            builder.append(", ");
        }
        if (content != null) {
            builder.append("content=");
            builder.append(content);
            builder.append(", ");
        }
        if (link != null) {
            builder.append("link=");
            builder.append(link);
            builder.append(", ");
        }
        if (postId != null) {
            builder.append("postId=");
            builder.append(postId);
            builder.append(", ");
        }
        if (postTitle != null) {
            builder.append("postTitle=");
            builder.append(postTitle);
            builder.append(", ");
        }
        if (author != null) {
            builder.append("author=");
            builder.append(author);
            builder.append(", ");
        }
        if (authorUrl != null) {
            builder.append("authorUrl=");
            builder.append(authorUrl);
            builder.append(", ");
        }
        if (authorEmail != null) {
            builder.append("authorEmail=");
            builder.append(authorEmail);
            builder.append(", ");
        }
        if (authorIp != null) {
            builder.append("authorIp=");
            builder.append(authorIp);
        }
        builder.append("]");
        return builder.toString();
    }

}
