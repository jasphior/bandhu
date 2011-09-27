package org.bandhu.ext.linkedin.util;

public enum UpdateTypeEnum {
    ANSW("ANSW", "Answer Update",
            "A connection has answered a question posed on LinkedIn Answers."),

    APPM("APPM",
            "Application Update:Activity of a connection in an application"),

    APPS("APPS", "Application Update Applicaiton-to-member direct update. "),

    CMPY("CMPY", "Company Follow Updates",
            "A change to one of the companies the member is following."),

    CONN(
            "CONN",
            "Connection Updates",
            "A connection has added connections to their network. This update indicates who those new connections are."),

    NCON("NCON", "Connection Updates", "New connections of the member."), CCEM(
            "Connection Updates",
            "A contact (not a connection) has just joined LinkedIn and is open to be invited to become a connection. Contacts are added by importing from email. They remain contacts until specifically invited to become a connection."),

    JOBS("JOBS", "Posted a job"),

    JOBP("JOBP", "Posted a job"),

    JGRP("JGRP", "Joined a group", "A connection has joined a group."),

    PICT("PICT", "Changed a picture",
            "A connection has updated their profile picture."),

    PICU("PICU", "Profile picture updates"),

    PRFX(
            "PRFX",
            "Extended profile update",
            "A connection has updated their extended profile, personal information such as phone number, IM account, and Twitter handle."),

    RECU("RECU", "Recommendations", "A connection was recommended"),

    PREC("PREC", "Recommendations"),

    SVPR("SVPR", "Recommendations"),

    PRFU(
            "PRFU",
            "Changed profile",
            "A connection has updated their profile. This does not include picture updates, which are covered under PICT type. The fields updated are returned in the XML. Since the first name, last name, and headline are always returned for each update, if those are the only fields you see, then you can assume that the change was to the headline."),

    PROF("PROF", "Changed profile"),

    QSTN("QSTN", "Question update",
            "A connection has asked a question on LinkedIn Answers."),

    SHAR("SHAR", "Shared item", "A connection has shared an update or link."),

    STAT("STAT", "Status update",
            "This update type is deprecated in favor of SHAR."),

    VIRL("VIRL", "Viral update",
            "A connection has commented on or liked another update.");

    private String code;
    private String name;
    private String description;

    private UpdateTypeEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    private UpdateTypeEnum(String code, String name, String description) {
        this.code = code;
        this.name = name;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

}
