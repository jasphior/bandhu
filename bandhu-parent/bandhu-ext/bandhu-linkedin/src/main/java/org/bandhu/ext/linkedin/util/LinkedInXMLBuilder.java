package org.bandhu.ext.linkedin.util;

import javax.xml.bind.JAXBElement;

import org.bandhu.ext.linkedin.jaxb.ActivityType;
import org.bandhu.ext.linkedin.jaxb.CompanyType;
import org.bandhu.ext.linkedin.jaxb.JobBookmarkType;
import org.bandhu.ext.linkedin.jaxb.MailboxItemType;
import org.bandhu.ext.linkedin.jaxb.ObjectFactory;
import org.bandhu.ext.linkedin.jaxb.ShareType;
import org.bandhu.ext.linkedin.jaxb.UpdateCommentType;
import org.bandhu.util.XMLBuilder;

public class LinkedInXMLBuilder extends XMLBuilder {

    public static String toXMLIsLike(boolean flag) {
        JAXBElement<String> jaxbElement = new ObjectFactory()
                .createIsLiked(Boolean.toString(flag));
        return prepare(String.class, jaxbElement);
    }

    public static String toXML(MailboxItemType mailboxItemType) {
        JAXBElement<MailboxItemType> jaxbElement = new ObjectFactory()
                .createMailboxItem(mailboxItemType);
        return prepare(MailboxItemType.class, jaxbElement);
    }

    public static String toXML(ShareType shareType) {
        JAXBElement<ShareType> jaxbElement = new ObjectFactory()
                .createShare(shareType);
        return prepare(ShareType.class, jaxbElement);
    }

    public static String toXML(ActivityType activityType) {
        JAXBElement<ActivityType> jaxbElement = new ObjectFactory()
                .createActivity(activityType);
        return prepare(ActivityType.class, jaxbElement);
    }

    public static String toXML(UpdateCommentType commentType) {
        JAXBElement<UpdateCommentType> jaxbElement = new ObjectFactory()
                .createUpdateComment(commentType);
        return prepare(UpdateCommentType.class, jaxbElement);
    }

    public static String toXML(JobBookmarkType jobBookmark) {
        JAXBElement<JobBookmarkType> jaxbElement = new ObjectFactory()
                .createJobBookmark(jobBookmark);
        return prepare(UpdateCommentType.class, jaxbElement);
    }

    public static String toXML(CompanyType companyType) {
        JAXBElement<CompanyType> jaxbElement = new ObjectFactory()
                .createCompany(companyType);
        return prepare(UpdateCommentType.class, jaxbElement);
    }
}
