package org.bandhu.ext.wp.bean;

public class Status {
    public enum PostStatus {
        DRAFT("draft"), PENDING("pending"), PRIVATE("private"), PUBLISH(
                "publish");
        private String code;

        private PostStatus(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }

    public enum CommentStatus {
        HOLD("hold"), APPROVE("approve"), SPAM("spam");
        private String code;

        private CommentStatus(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }

    public enum PageStatus {
        DRAFT("draft"), PRIVATE("private"), PUBLISH("publish");
        private String code;

        private PageStatus(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }
}
