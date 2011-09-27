package org.bandhu.ext.model;

public class SocialMessage extends ParamExtention {
    private Profile from;

    private String subject;

    private String message;

    private String description;

    private String location;

    private String link;

    private String icon;

    private String createdTime;

    private String updatedTime;

    private Long likes;

    private boolean likable;

    private boolean commentable;

    private boolean reply;

    private boolean tweetable;

    private boolean retweetable;

    private boolean favoritable;

    private Object entity;

    public Profile getFrom() {
        return from;
    }

    public void setFrom(Profile from) {
        this.from = from;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(String updatedTime) {
        this.updatedTime = updatedTime;
    }

    public Long getLikes() {
        return likes;
    }

    public void setLikes(Long likes) {
        this.likes = likes;
    }

    public boolean isLikable() {
        return likable;
    }

    public void setLikable(boolean likable) {
        this.likable = likable;
    }

    public boolean isCommentable() {
        return commentable;
    }

    public void setCommentable(boolean commentable) {
        this.commentable = commentable;
    }

    public boolean isReply() {
        return reply;
    }

    public void setReply(boolean reply) {
        this.reply = reply;
    }

    public boolean isTweetable() {
        return tweetable;
    }

    public void setTweetable(boolean tweetable) {
        this.tweetable = tweetable;
    }

    public boolean isRetweetable() {
        return retweetable;
    }

    public void setRetweetable(boolean retweetable) {
        this.retweetable = retweetable;
    }

    public boolean isFavoritable() {
        return favoritable;
    }

    public void setFavoritable(boolean favoritable) {
        this.favoritable = favoritable;
    }

    public Object getEntity() {
        return entity;
    }

    public void setEntity(Object entity) {
        this.entity = entity;
    }
}
