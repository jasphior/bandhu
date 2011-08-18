package org.bandhu.ext.wp.bean;

import org.bandhu.core.rpc.annotation.Struct;

public class CommentFilter {
    // post_id
    @Struct(name = "post_id")
    private String postId;
    // status (defaults to approve)
    @Struct
    private String status;
    // offset
    @Struct
    private String offset;
    // number
    @Struct
    private String number;

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("CommentFilter [");
        if (postId != null) {
            builder.append("postId=");
            builder.append(postId);
            builder.append(", ");
        }
        if (status != null) {
            builder.append("status=");
            builder.append(status);
            builder.append(", ");
        }
        if (offset != null) {
            builder.append("offset=");
            builder.append(offset);
            builder.append(", ");
        }
        if (number != null) {
            builder.append("number=");
            builder.append(number);
        }
        builder.append("]");
        return builder.toString();
    }

}
