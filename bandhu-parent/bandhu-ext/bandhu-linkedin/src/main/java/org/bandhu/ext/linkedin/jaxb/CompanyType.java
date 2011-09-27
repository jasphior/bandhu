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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for companyType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="companyType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="universal-name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="status" type="{}statusType" minOccurs="0"/>
 *         &lt;element name="logo-url" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *         &lt;element name="website-url" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *         &lt;element name="blog-rss-url" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *         &lt;element name="twitter-id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="employee-count-range" type="{}employee-count-rangeType" minOccurs="0"/>
 *         &lt;element name="industries" type="{}industriesType" minOccurs="0"/>
 *         &lt;element name="specialties" type="{}specialtiesType" minOccurs="0"/>
 *         &lt;element name="locations" type="{}locationsType" minOccurs="0"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="founded-year" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *         &lt;element name="num-followers" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *         &lt;element name="size" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="industry" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ticker" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="company-type" type="{}company-typeType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "companyType", propOrder = {
    "id",
    "name",
    "universalName",
    "status",
    "logoUrl",
    "websiteUrl",
    "blogRssUrl",
    "twitterId",
    "employeeCountRange",
    "industries",
    "specialties",
    "locations",
    "description",
    "foundedYear",
    "numFollowers",
    "size",
    "type",
    "industry",
    "ticker",
    "companyType"
})
public class CompanyType {

    protected Integer id;
    protected String name;
    @XmlElement(name = "universal-name")
    protected String universalName;
    protected StatusType status;
    @XmlElement(name = "logo-url")
    @XmlSchemaType(name = "anyURI")
    protected String logoUrl;
    @XmlElement(name = "website-url")
    @XmlSchemaType(name = "anyURI")
    protected String websiteUrl;
    @XmlElement(name = "blog-rss-url")
    @XmlSchemaType(name = "anyURI")
    protected String blogRssUrl;
    @XmlElement(name = "twitter-id")
    protected String twitterId;
    @XmlElement(name = "employee-count-range")
    protected EmployeeCountRangeType employeeCountRange;
    protected IndustriesType industries;
    protected SpecialtiesType specialties;
    protected LocationsType locations;
    protected String description;
    @XmlElement(name = "founded-year")
    protected Short foundedYear;
    @XmlElement(name = "num-followers")
    protected Short numFollowers;
    protected String size;
    protected String type;
    protected String industry;
    protected String ticker;
    @XmlElement(name = "company-type")
    protected CompanyTypeType companyType;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setId(Integer value) {
        this.id = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the universalName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUniversalName() {
        return universalName;
    }

    /**
     * Sets the value of the universalName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUniversalName(String value) {
        this.universalName = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link StatusType }
     *     
     */
    public StatusType getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link StatusType }
     *     
     */
    public void setStatus(StatusType value) {
        this.status = value;
    }

    /**
     * Gets the value of the logoUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLogoUrl() {
        return logoUrl;
    }

    /**
     * Sets the value of the logoUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLogoUrl(String value) {
        this.logoUrl = value;
    }

    /**
     * Gets the value of the websiteUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWebsiteUrl() {
        return websiteUrl;
    }

    /**
     * Sets the value of the websiteUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWebsiteUrl(String value) {
        this.websiteUrl = value;
    }

    /**
     * Gets the value of the blogRssUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBlogRssUrl() {
        return blogRssUrl;
    }

    /**
     * Sets the value of the blogRssUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBlogRssUrl(String value) {
        this.blogRssUrl = value;
    }

    /**
     * Gets the value of the twitterId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTwitterId() {
        return twitterId;
    }

    /**
     * Sets the value of the twitterId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTwitterId(String value) {
        this.twitterId = value;
    }

    /**
     * Gets the value of the employeeCountRange property.
     * 
     * @return
     *     possible object is
     *     {@link EmployeeCountRangeType }
     *     
     */
    public EmployeeCountRangeType getEmployeeCountRange() {
        return employeeCountRange;
    }

    /**
     * Sets the value of the employeeCountRange property.
     * 
     * @param value
     *     allowed object is
     *     {@link EmployeeCountRangeType }
     *     
     */
    public void setEmployeeCountRange(EmployeeCountRangeType value) {
        this.employeeCountRange = value;
    }

    /**
     * Gets the value of the industries property.
     * 
     * @return
     *     possible object is
     *     {@link IndustriesType }
     *     
     */
    public IndustriesType getIndustries() {
        return industries;
    }

    /**
     * Sets the value of the industries property.
     * 
     * @param value
     *     allowed object is
     *     {@link IndustriesType }
     *     
     */
    public void setIndustries(IndustriesType value) {
        this.industries = value;
    }

    /**
     * Gets the value of the specialties property.
     * 
     * @return
     *     possible object is
     *     {@link SpecialtiesType }
     *     
     */
    public SpecialtiesType getSpecialties() {
        return specialties;
    }

    /**
     * Sets the value of the specialties property.
     * 
     * @param value
     *     allowed object is
     *     {@link SpecialtiesType }
     *     
     */
    public void setSpecialties(SpecialtiesType value) {
        this.specialties = value;
    }

    /**
     * Gets the value of the locations property.
     * 
     * @return
     *     possible object is
     *     {@link LocationsType }
     *     
     */
    public LocationsType getLocations() {
        return locations;
    }

    /**
     * Sets the value of the locations property.
     * 
     * @param value
     *     allowed object is
     *     {@link LocationsType }
     *     
     */
    public void setLocations(LocationsType value) {
        this.locations = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the foundedYear property.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getFoundedYear() {
        return foundedYear;
    }

    /**
     * Sets the value of the foundedYear property.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setFoundedYear(Short value) {
        this.foundedYear = value;
    }

    /**
     * Gets the value of the numFollowers property.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getNumFollowers() {
        return numFollowers;
    }

    /**
     * Sets the value of the numFollowers property.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setNumFollowers(Short value) {
        this.numFollowers = value;
    }

    /**
     * Gets the value of the size property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSize() {
        return size;
    }

    /**
     * Sets the value of the size property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSize(String value) {
        this.size = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the industry property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndustry() {
        return industry;
    }

    /**
     * Sets the value of the industry property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndustry(String value) {
        this.industry = value;
    }

    /**
     * Gets the value of the ticker property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTicker() {
        return ticker;
    }

    /**
     * Sets the value of the ticker property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTicker(String value) {
        this.ticker = value;
    }

    /**
     * Gets the value of the companyType property.
     * 
     * @return
     *     possible object is
     *     {@link CompanyTypeType }
     *     
     */
    public CompanyTypeType getCompanyType() {
        return companyType;
    }

    /**
     * Sets the value of the companyType property.
     * 
     * @param value
     *     allowed object is
     *     {@link CompanyTypeType }
     *     
     */
    public void setCompanyType(CompanyTypeType value) {
        this.companyType = value;
    }

}
