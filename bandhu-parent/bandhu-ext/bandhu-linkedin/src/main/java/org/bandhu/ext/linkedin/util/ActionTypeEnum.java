package org.bandhu.ext.linkedin.util;

public enum ActionTypeEnum {
    JOINED("joined"), LEFT("left"), CHANGED_POSITION("changed-position"), STARTED_FOLLOWING(
            "started-following"), STOPPED_FOLLOWING("stopped-following"), CREATED(
            "created"), UPDATED("updated"), DELETED("deleted");
    private String code;

    private ActionTypeEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static ActionTypeEnum valueByCode(String code) {
        for (ActionTypeEnum typeEnum : values()) {
            if (typeEnum.getCode().equals(code)) {
                return typeEnum;
            }
        }
        return null;
    }
}
