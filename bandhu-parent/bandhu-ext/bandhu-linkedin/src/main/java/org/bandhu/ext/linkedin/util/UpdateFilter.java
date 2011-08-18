package org.bandhu.ext.linkedin.util;

public class UpdateFilter extends Filter {
    private String scope;
    private String after;
    private String before;
    private Boolean showHidden;

    String getScope() {
        return scope;
    }

    void setScope(String scope) {
        this.scope = scope;
    }

    String getAfter() {
        return after;
    }

    void setAfter(String after) {
        this.after = after;
    }

    String getBefore() {
        return before;
    }

    void setBefore(String before) {
        this.before = before;
    }

    Boolean getShowHidden() {
        return showHidden;
    }

    void setShowHidden(Boolean showHidden) {
        this.showHidden = showHidden;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(super.toString());
        if (scope != null) {
            builder.append("scope=");
            builder.append(scope);
            builder.append(SEPERATOR);
        }
        if (after != null) {
            builder.append("after=");
            builder.append(after);
            builder.append(SEPERATOR);
        }
        if (before != null) {
            builder.append("before=");
            builder.append(before);
            builder.append(SEPERATOR);
        }
        if (showHidden != null) {
            builder.append("show-hidden-members=");
            builder.append(showHidden);
            builder.append(SEPERATOR);
        }
        return builder.toString();
    }

}
