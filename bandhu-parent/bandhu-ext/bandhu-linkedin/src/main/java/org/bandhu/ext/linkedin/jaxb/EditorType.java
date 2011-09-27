//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.09.23 at 06:48:16 PM IST 
//


package org.bandhu.ext.linkedin.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for editorType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="editorType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="first-name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="last-name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="headline" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="api-standard-profile-request" type="{}api-standard-profile-requestType"/>
 *         &lt;element name="site-standard-profile-request" type="{}site-standard-profile-requestType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "editorType", propOrder = {
    "id",
    "firstName",
    "lastName",
    "headline",
    "apiStandardProfileRequest",
    "siteStandardProfileRequest"
})
public class EditorType {

    @XmlElement(required = true)
    protected String id;
    @XmlElement(name = "first-name", required = true)
    protected String firstName;
    @XmlElement(name = "last-name", required = true)
    protected String lastName;
    @XmlElement(required = true)
    protected String headline;
    @XmlElement(name = "api-standard-profile-request", required = true)
    protected ApiStandardProfileRequestType apiStandardProfileRequest;
    @XmlElement(name = "site-standard-profile-request", required = true)
    protected SiteStandardProfileRequestType siteStandardProfileRequest;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the firstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the value of the firstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstName(String value) {
        this.firstName = value;
    }

    /**
     * Gets the value of the lastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the value of the lastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastName(String value) {
        this.lastName = value;
    }

    /**
     * Gets the value of the headline property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHeadline() {
        return headline;
    }

    /**
     * Sets the value of the headline property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHeadline(String value) {
        this.headline = value;
    }

    /**
     * Gets the value of the apiStandardProfileRequest property.
     * 
     * @return
     *     possible object is
     *     {@link ApiStandardProfileRequestType }
     *     
     */
    public ApiStandardProfileRequestType getApiStandardProfileRequest() {
        return apiStandardProfileRequest;
    }

    /**
     * Sets the value of the apiStandardProfileRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link ApiStandardProfileRequestType }
     *     
     */
    public void setApiStandardProfileRequest(ApiStandardProfileRequestType value) {
        this.apiStandardProfileRequest = value;
    }

    /**
     * Gets the value of the siteStandardProfileRequest property.
     * 
     * @return
     *     possible object is
     *     {@link SiteStandardProfileRequestType }
     *     
     */
    public SiteStandardProfileRequestType getSiteStandardProfileRequest() {
        return siteStandardProfileRequest;
    }

    /**
     * Sets the value of the siteStandardProfileRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link SiteStandardProfileRequestType }
     *     
     */
    public void setSiteStandardProfileRequest(SiteStandardProfileRequestType value) {
        this.siteStandardProfileRequest = value;
    }

}
