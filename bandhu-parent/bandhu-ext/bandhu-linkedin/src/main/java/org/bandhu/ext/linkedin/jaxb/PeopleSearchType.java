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
 * <p>Java class for people-searchType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="people-searchType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="people" type="{}peopleType"/>
 *         &lt;element name="facets" type="{}facetsType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "people-searchType", propOrder = {
    "people",
    "facets"
})
public class PeopleSearchType {

    @XmlElement(required = true)
    protected PeopleType people;
    @XmlElement(required = true)
    protected FacetsType facets;

    /**
     * Gets the value of the people property.
     * 
     * @return
     *     possible object is
     *     {@link PeopleType }
     *     
     */
    public PeopleType getPeople() {
        return people;
    }

    /**
     * Sets the value of the people property.
     * 
     * @param value
     *     allowed object is
     *     {@link PeopleType }
     *     
     */
    public void setPeople(PeopleType value) {
        this.people = value;
    }

    /**
     * Gets the value of the facets property.
     * 
     * @return
     *     possible object is
     *     {@link FacetsType }
     *     
     */
    public FacetsType getFacets() {
        return facets;
    }

    /**
     * Sets the value of the facets property.
     * 
     * @param value
     *     allowed object is
     *     {@link FacetsType }
     *     
     */
    public void setFacets(FacetsType value) {
        this.facets = value;
    }

}
