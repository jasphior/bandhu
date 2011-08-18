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
 * <p>Java class for positionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="positionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="job-functions" type="{}job-functionsType" minOccurs="0"/>
 *         &lt;element name="industries" type="{}industriesType" minOccurs="0"/>
 *         &lt;element name="job-type" type="{}job-typeType" minOccurs="0"/>
 *         &lt;element name="experience-level" type="{}experience-levelType" minOccurs="0"/>
 *         &lt;element name="location" type="{}locationType" minOccurs="0"/>
 *         &lt;element name="summary" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="start-date" type="{}start-dateType" minOccurs="0"/>
 *         &lt;element name="end-date" type="{}end-dateType" minOccurs="0"/>
 *         &lt;element name="is-current" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="company" type="{}companyType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "positionType", propOrder = {
    "id",
    "title",
    "jobFunctions",
    "industries",
    "jobType",
    "experienceLevel",
    "location",
    "summary",
    "startDate",
    "endDate",
    "isCurrent",
    "company"
})
public class PositionType {

    protected Integer id;
    @XmlElement(required = true)
    protected String title;
    @XmlElement(name = "job-functions")
    protected JobFunctionsType jobFunctions;
    protected IndustriesType industries;
    @XmlElement(name = "job-type")
    protected JobTypeType jobType;
    @XmlElement(name = "experience-level")
    protected ExperienceLevelType experienceLevel;
    protected LocationType location;
    protected String summary;
    @XmlElement(name = "start-date")
    protected StartDateType startDate;
    @XmlElement(name = "end-date")
    protected EndDateType endDate;
    @XmlElement(name = "is-current")
    protected String isCurrent;
    protected CompanyType company;

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
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Gets the value of the jobFunctions property.
     * 
     * @return
     *     possible object is
     *     {@link JobFunctionsType }
     *     
     */
    public JobFunctionsType getJobFunctions() {
        return jobFunctions;
    }

    /**
     * Sets the value of the jobFunctions property.
     * 
     * @param value
     *     allowed object is
     *     {@link JobFunctionsType }
     *     
     */
    public void setJobFunctions(JobFunctionsType value) {
        this.jobFunctions = value;
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
     * Gets the value of the jobType property.
     * 
     * @return
     *     possible object is
     *     {@link JobTypeType }
     *     
     */
    public JobTypeType getJobType() {
        return jobType;
    }

    /**
     * Sets the value of the jobType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JobTypeType }
     *     
     */
    public void setJobType(JobTypeType value) {
        this.jobType = value;
    }

    /**
     * Gets the value of the experienceLevel property.
     * 
     * @return
     *     possible object is
     *     {@link ExperienceLevelType }
     *     
     */
    public ExperienceLevelType getExperienceLevel() {
        return experienceLevel;
    }

    /**
     * Sets the value of the experienceLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExperienceLevelType }
     *     
     */
    public void setExperienceLevel(ExperienceLevelType value) {
        this.experienceLevel = value;
    }

    /**
     * Gets the value of the location property.
     * 
     * @return
     *     possible object is
     *     {@link LocationType }
     *     
     */
    public LocationType getLocation() {
        return location;
    }

    /**
     * Sets the value of the location property.
     * 
     * @param value
     *     allowed object is
     *     {@link LocationType }
     *     
     */
    public void setLocation(LocationType value) {
        this.location = value;
    }

    /**
     * Gets the value of the summary property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSummary() {
        return summary;
    }

    /**
     * Sets the value of the summary property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSummary(String value) {
        this.summary = value;
    }

    /**
     * Gets the value of the startDate property.
     * 
     * @return
     *     possible object is
     *     {@link StartDateType }
     *     
     */
    public StartDateType getStartDate() {
        return startDate;
    }

    /**
     * Sets the value of the startDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link StartDateType }
     *     
     */
    public void setStartDate(StartDateType value) {
        this.startDate = value;
    }

    /**
     * Gets the value of the endDate property.
     * 
     * @return
     *     possible object is
     *     {@link EndDateType }
     *     
     */
    public EndDateType getEndDate() {
        return endDate;
    }

    /**
     * Sets the value of the endDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link EndDateType }
     *     
     */
    public void setEndDate(EndDateType value) {
        this.endDate = value;
    }

    /**
     * Gets the value of the isCurrent property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsCurrent() {
        return isCurrent;
    }

    /**
     * Sets the value of the isCurrent property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsCurrent(String value) {
        this.isCurrent = value;
    }

    /**
     * Gets the value of the company property.
     * 
     * @return
     *     possible object is
     *     {@link CompanyType }
     *     
     */
    public CompanyType getCompany() {
        return company;
    }

    /**
     * Sets the value of the company property.
     * 
     * @param value
     *     allowed object is
     *     {@link CompanyType }
     *     
     */
    public void setCompany(CompanyType value) {
        this.company = value;
    }

}
