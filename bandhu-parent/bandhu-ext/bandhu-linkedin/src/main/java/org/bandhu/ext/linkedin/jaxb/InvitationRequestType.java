//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.08.12 at 02:30:18 PM IST 
//


package org.bandhu.ext.linkedin.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for invitation-requestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="invitation-requestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="connect-type" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="authorization" type="{}authorizationType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "invitation-requestType", propOrder = {
    "connectType",
    "authorization"
})
public class InvitationRequestType {

    @XmlElement(name = "connect-type", required = true)
    protected String connectType;
    @XmlElement(required = true)
    protected AuthorizationType authorization;

    /**
     * Gets the value of the connectType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConnectType() {
        return connectType;
    }

    /**
     * Sets the value of the connectType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConnectType(String value) {
        this.connectType = value;
    }

    /**
     * Gets the value of the authorization property.
     * 
     * @return
     *     possible object is
     *     {@link AuthorizationType }
     *     
     */
    public AuthorizationType getAuthorization() {
        return authorization;
    }

    /**
     * Sets the value of the authorization property.
     * 
     * @param value
     *     allowed object is
     *     {@link AuthorizationType }
     *     
     */
    public void setAuthorization(AuthorizationType value) {
        this.authorization = value;
    }

}
