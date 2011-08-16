//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.08.10 at 12:05:40 AM IST 
//


package org.bandhu.ext.linkedin.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for updateType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="updateType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="timestamp">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="update-key">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="update-type">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="CONN"/>
 *               &lt;enumeration value="NCON"/>
 *               &lt;enumeration value="PROF"/>
 *               &lt;enumeration value="JGRP"/>
 *               &lt;enumeration value="STAT"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="update-content" type="{}update-contentType"/>
 *         &lt;element name="is-commentable" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="update-comments" type="{}update-commentsType"/>
 *         &lt;element name="updated-fields" type="{}updated-fieldsType" minOccurs="0"/>
 *         &lt;element name="is-likable" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="is-liked" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="num-likes">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}byte">
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="likes" type="{}likesType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateType", propOrder = {
    "timestamp",
    "updateKey",
    "updateType",
    "updateContent",
    "isCommentable",
    "updateComments",
    "updatedFields",
    "isLikable",
    "isLiked",
    "numLikes",
    "likes"
})
public class UpdateType {

    protected long timestamp;
    @XmlElement(name = "update-key", required = true)
    protected String updateKey;
    @XmlElement(name = "update-type", required = true)
    protected String updateType;
    @XmlElement(name = "update-content", required = true)
    protected UpdateContentType updateContent;
    @XmlElement(name = "is-commentable", required = true)
    protected String isCommentable;
    @XmlElement(name = "update-comments", required = true)
    protected UpdateCommentsType updateComments;
    @XmlElement(name = "updated-fields")
    protected UpdatedFieldsType updatedFields;
    @XmlElement(name = "is-likable", required = true)
    protected String isLikable;
    @XmlElement(name = "is-liked", required = true)
    protected String isLiked;
    @XmlElement(name = "num-likes")
    protected byte numLikes;
    protected LikesType likes;

    /**
     * Gets the value of the timestamp property.
     * 
     */
    public long getTimestamp() {
        return timestamp;
    }

    /**
     * Sets the value of the timestamp property.
     * 
     */
    public void setTimestamp(long value) {
        this.timestamp = value;
    }

    /**
     * Gets the value of the updateKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUpdateKey() {
        return updateKey;
    }

    /**
     * Sets the value of the updateKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUpdateKey(String value) {
        this.updateKey = value;
    }

    /**
     * Gets the value of the updateType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUpdateType() {
        return updateType;
    }

    /**
     * Sets the value of the updateType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUpdateType(String value) {
        this.updateType = value;
    }

    /**
     * Gets the value of the updateContent property.
     * 
     * @return
     *     possible object is
     *     {@link UpdateContentType }
     *     
     */
    public UpdateContentType getUpdateContent() {
        return updateContent;
    }

    /**
     * Sets the value of the updateContent property.
     * 
     * @param value
     *     allowed object is
     *     {@link UpdateContentType }
     *     
     */
    public void setUpdateContent(UpdateContentType value) {
        this.updateContent = value;
    }

    /**
     * Gets the value of the isCommentable property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsCommentable() {
        return isCommentable;
    }

    /**
     * Sets the value of the isCommentable property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsCommentable(String value) {
        this.isCommentable = value;
    }

    /**
     * Gets the value of the updateComments property.
     * 
     * @return
     *     possible object is
     *     {@link UpdateCommentsType }
     *     
     */
    public UpdateCommentsType getUpdateComments() {
        return updateComments;
    }

    /**
     * Sets the value of the updateComments property.
     * 
     * @param value
     *     allowed object is
     *     {@link UpdateCommentsType }
     *     
     */
    public void setUpdateComments(UpdateCommentsType value) {
        this.updateComments = value;
    }

    /**
     * Gets the value of the updatedFields property.
     * 
     * @return
     *     possible object is
     *     {@link UpdatedFieldsType }
     *     
     */
    public UpdatedFieldsType getUpdatedFields() {
        return updatedFields;
    }

    /**
     * Sets the value of the updatedFields property.
     * 
     * @param value
     *     allowed object is
     *     {@link UpdatedFieldsType }
     *     
     */
    public void setUpdatedFields(UpdatedFieldsType value) {
        this.updatedFields = value;
    }

    /**
     * Gets the value of the isLikable property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsLikable() {
        return isLikable;
    }

    /**
     * Sets the value of the isLikable property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsLikable(String value) {
        this.isLikable = value;
    }

    /**
     * Gets the value of the isLiked property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsLiked() {
        return isLiked;
    }

    /**
     * Sets the value of the isLiked property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsLiked(String value) {
        this.isLiked = value;
    }

    /**
     * Gets the value of the numLikes property.
     * 
     */
    public byte getNumLikes() {
        return numLikes;
    }

    /**
     * Sets the value of the numLikes property.
     * 
     */
    public void setNumLikes(byte value) {
        this.numLikes = value;
    }

    /**
     * Gets the value of the likes property.
     * 
     * @return
     *     possible object is
     *     {@link LikesType }
     *     
     */
    public LikesType getLikes() {
        return likes;
    }

    /**
     * Sets the value of the likes property.
     * 
     * @param value
     *     allowed object is
     *     {@link LikesType }
     *     
     */
    public void setLikes(LikesType value) {
        this.likes = value;
    }

}