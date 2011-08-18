package org.bandhu.ext.wp.bean;

import org.bandhu.core.rpc.annotation.Struct;

public class CommentCount {
    // int approved
    @Struct
    private int approved;
    // int awaiting_moderation
    @Struct(name = "awaiting_moderation")
    private int awaitingModeration;
    // int spam
    @Struct
    private int spam;
    // int total_comments
    @Struct(name = "total_comments")
    private int totalComments;

    public int getApproved() {
        return approved;
    }

    public void setApproved(int approved) {
        this.approved = approved;
    }

    public int getAwaitingModeration() {
        return awaitingModeration;
    }

    public void setAwaitingModeration(int awaitingModeration) {
        this.awaitingModeration = awaitingModeration;
    }

    public int getSpam() {
        return spam;
    }

    public void setSpam(int spam) {
        this.spam = spam;
    }

    public int getTotalComments() {
        return totalComments;
    }

    public void setTotalComments(int totalComments) {
        this.totalComments = totalComments;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("CommentCount [approved=");
        builder.append(approved);
        builder.append(", awaitingModeration=");
        builder.append(awaitingModeration);
        builder.append(", spam=");
        builder.append(spam);
        builder.append(", totalComments=");
        builder.append(totalComments);
        builder.append("]");
        return builder.toString();
    }

}
