//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.09.29 at 02:02:01 PM IST 
//


package org.bandhu.ext.linkedin.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for job-bookmarkType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="job-bookmarkType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="is-applied" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="is-saved" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="saved-timestamp" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="job" type="{}jobType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "job-bookmarkType", propOrder = {
    "isApplied",
    "isSaved",
    "savedTimestamp",
    "job"
})
public class JobBookmarkType {

    @XmlElement(name = "is-applied")
    protected String isApplied;
    @XmlElement(name = "is-saved")
    protected String isSaved;
    @XmlElement(name = "saved-timestamp")
    protected Long savedTimestamp;
    @XmlElement(required = true)
    protected JobType job;

    /**
     * Gets the value of the isApplied property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsApplied() {
        return isApplied;
    }

    /**
     * Sets the value of the isApplied property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsApplied(String value) {
        this.isApplied = value;
    }

    /**
     * Gets the value of the isSaved property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsSaved() {
        return isSaved;
    }

    /**
     * Sets the value of the isSaved property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsSaved(String value) {
        this.isSaved = value;
    }

    /**
     * Gets the value of the savedTimestamp property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSavedTimestamp() {
        return savedTimestamp;
    }

    /**
     * Sets the value of the savedTimestamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSavedTimestamp(Long value) {
        this.savedTimestamp = value;
    }

    /**
     * Gets the value of the job property.
     * 
     * @return
     *     possible object is
     *     {@link JobType }
     *     
     */
    public JobType getJob() {
        return job;
    }

    /**
     * Sets the value of the job property.
     * 
     * @param value
     *     allowed object is
     *     {@link JobType }
     *     
     */
    public void setJob(JobType value) {
        this.job = value;
    }

}
