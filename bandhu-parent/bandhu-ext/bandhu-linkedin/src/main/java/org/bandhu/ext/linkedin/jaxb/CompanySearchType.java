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
 * <p>Java class for company-searchType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="company-searchType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="companies" type="{}companiesType"/>
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
@XmlType(name = "company-searchType", propOrder = {
    "companies",
    "facets"
})
public class CompanySearchType {

    @XmlElement(required = true)
    protected CompaniesType companies;
    @XmlElement(required = true)
    protected FacetsType facets;

    /**
     * Gets the value of the companies property.
     * 
     * @return
     *     possible object is
     *     {@link CompaniesType }
     *     
     */
    public CompaniesType getCompanies() {
        return companies;
    }

    /**
     * Sets the value of the companies property.
     * 
     * @param value
     *     allowed object is
     *     {@link CompaniesType }
     *     
     */
    public void setCompanies(CompaniesType value) {
        this.companies = value;
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
