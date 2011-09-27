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
 * <p>Java class for questionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="questionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="author" type="{}authorType"/>
 *         &lt;element name="question-categories" type="{}question-categoriesType"/>
 *         &lt;element name="web-url" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *         &lt;element name="answers" type="{}answersType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "questionType", propOrder = {
    "id",
    "title",
    "author",
    "questionCategories",
    "webUrl",
    "answers"
})
public class QuestionType {

    protected int id;
    @XmlElement(required = true)
    protected String title;
    @XmlElement(required = true)
    protected AuthorType author;
    @XmlElement(name = "question-categories", required = true)
    protected QuestionCategoriesType questionCategories;
    @XmlElement(name = "web-url")
    @XmlSchemaType(name = "anyURI")
    protected String webUrl;
    protected AnswersType answers;

    /**
     * Gets the value of the id property.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(int value) {
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
     * Gets the value of the author property.
     * 
     * @return
     *     possible object is
     *     {@link AuthorType }
     *     
     */
    public AuthorType getAuthor() {
        return author;
    }

    /**
     * Sets the value of the author property.
     * 
     * @param value
     *     allowed object is
     *     {@link AuthorType }
     *     
     */
    public void setAuthor(AuthorType value) {
        this.author = value;
    }

    /**
     * Gets the value of the questionCategories property.
     * 
     * @return
     *     possible object is
     *     {@link QuestionCategoriesType }
     *     
     */
    public QuestionCategoriesType getQuestionCategories() {
        return questionCategories;
    }

    /**
     * Sets the value of the questionCategories property.
     * 
     * @param value
     *     allowed object is
     *     {@link QuestionCategoriesType }
     *     
     */
    public void setQuestionCategories(QuestionCategoriesType value) {
        this.questionCategories = value;
    }

    /**
     * Gets the value of the webUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWebUrl() {
        return webUrl;
    }

    /**
     * Sets the value of the webUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWebUrl(String value) {
        this.webUrl = value;
    }

    /**
     * Gets the value of the answers property.
     * 
     * @return
     *     possible object is
     *     {@link AnswersType }
     *     
     */
    public AnswersType getAnswers() {
        return answers;
    }

    /**
     * Sets the value of the answers property.
     * 
     * @param value
     *     allowed object is
     *     {@link AnswersType }
     *     
     */
    public void setAnswers(AnswersType value) {
        this.answers = value;
    }

}
