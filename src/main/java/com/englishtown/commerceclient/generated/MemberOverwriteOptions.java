
package com.englishtown.commerceclient.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MemberOverwriteOptions complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MemberOverwriteOptions">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="IsOverwriteDivision" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="IsOverwritePartner" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="IsOverwriteFirstName" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="IsOverwriteLastName" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="IsOverwritePassword" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="IsOverwriteCountry" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="IsOverwriteEmailLanguage" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="IsOverwriteTelephone" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="IsOverwriteEmployeeId" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="IsOverwriteState" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="IsOverwriteOccupation" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="IsOverwriteMobile" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="IsOverwriteCity" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="IsOverwriteGender" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="IsOverwriteStudyTarget" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MemberOverwriteOptions", namespace = "EFSchools.Englishtown.Commerce.Client.Members", propOrder = {
    "isOverwriteDivision",
    "isOverwritePartner",
    "isOverwriteFirstName",
    "isOverwriteLastName",
    "isOverwritePassword",
    "isOverwriteCountry",
    "isOverwriteEmailLanguage",
    "isOverwriteTelephone",
    "isOverwriteEmployeeId",
    "isOverwriteState",
    "isOverwriteOccupation",
    "isOverwriteMobile",
    "isOverwriteCity",
    "isOverwriteGender",
    "isOverwriteStudyTarget"
})
public class MemberOverwriteOptions {

    @XmlElement(name = "IsOverwriteDivision")
    protected Boolean isOverwriteDivision;
    @XmlElement(name = "IsOverwritePartner")
    protected Boolean isOverwritePartner;
    @XmlElement(name = "IsOverwriteFirstName")
    protected Boolean isOverwriteFirstName;
    @XmlElement(name = "IsOverwriteLastName")
    protected Boolean isOverwriteLastName;
    @XmlElement(name = "IsOverwritePassword")
    protected Boolean isOverwritePassword;
    @XmlElement(name = "IsOverwriteCountry")
    protected Boolean isOverwriteCountry;
    @XmlElement(name = "IsOverwriteEmailLanguage")
    protected Boolean isOverwriteEmailLanguage;
    @XmlElement(name = "IsOverwriteTelephone")
    protected Boolean isOverwriteTelephone;
    @XmlElement(name = "IsOverwriteEmployeeId")
    protected Boolean isOverwriteEmployeeId;
    @XmlElement(name = "IsOverwriteState")
    protected Boolean isOverwriteState;
    @XmlElement(name = "IsOverwriteOccupation")
    protected Boolean isOverwriteOccupation;
    @XmlElement(name = "IsOverwriteMobile")
    protected Boolean isOverwriteMobile;
    @XmlElement(name = "IsOverwriteCity")
    protected Boolean isOverwriteCity;
    @XmlElement(name = "IsOverwriteGender")
    protected Boolean isOverwriteGender;
    @XmlElement(name = "IsOverwriteStudyTarget")
    protected Boolean isOverwriteStudyTarget;

    /**
     * Gets the value of the isOverwriteDivision property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsOverwriteDivision() {
        return isOverwriteDivision;
    }

    /**
     * Sets the value of the isOverwriteDivision property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsOverwriteDivision(Boolean value) {
        this.isOverwriteDivision = value;
    }

    /**
     * Gets the value of the isOverwritePartner property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsOverwritePartner() {
        return isOverwritePartner;
    }

    /**
     * Sets the value of the isOverwritePartner property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsOverwritePartner(Boolean value) {
        this.isOverwritePartner = value;
    }

    /**
     * Gets the value of the isOverwriteFirstName property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsOverwriteFirstName() {
        return isOverwriteFirstName;
    }

    /**
     * Sets the value of the isOverwriteFirstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsOverwriteFirstName(Boolean value) {
        this.isOverwriteFirstName = value;
    }

    /**
     * Gets the value of the isOverwriteLastName property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsOverwriteLastName() {
        return isOverwriteLastName;
    }

    /**
     * Sets the value of the isOverwriteLastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsOverwriteLastName(Boolean value) {
        this.isOverwriteLastName = value;
    }

    /**
     * Gets the value of the isOverwritePassword property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsOverwritePassword() {
        return isOverwritePassword;
    }

    /**
     * Sets the value of the isOverwritePassword property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsOverwritePassword(Boolean value) {
        this.isOverwritePassword = value;
    }

    /**
     * Gets the value of the isOverwriteCountry property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsOverwriteCountry() {
        return isOverwriteCountry;
    }

    /**
     * Sets the value of the isOverwriteCountry property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsOverwriteCountry(Boolean value) {
        this.isOverwriteCountry = value;
    }

    /**
     * Gets the value of the isOverwriteEmailLanguage property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsOverwriteEmailLanguage() {
        return isOverwriteEmailLanguage;
    }

    /**
     * Sets the value of the isOverwriteEmailLanguage property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsOverwriteEmailLanguage(Boolean value) {
        this.isOverwriteEmailLanguage = value;
    }

    /**
     * Gets the value of the isOverwriteTelephone property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsOverwriteTelephone() {
        return isOverwriteTelephone;
    }

    /**
     * Sets the value of the isOverwriteTelephone property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsOverwriteTelephone(Boolean value) {
        this.isOverwriteTelephone = value;
    }

    /**
     * Gets the value of the isOverwriteEmployeeId property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsOverwriteEmployeeId() {
        return isOverwriteEmployeeId;
    }

    /**
     * Sets the value of the isOverwriteEmployeeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsOverwriteEmployeeId(Boolean value) {
        this.isOverwriteEmployeeId = value;
    }

    /**
     * Gets the value of the isOverwriteState property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsOverwriteState() {
        return isOverwriteState;
    }

    /**
     * Sets the value of the isOverwriteState property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsOverwriteState(Boolean value) {
        this.isOverwriteState = value;
    }

    /**
     * Gets the value of the isOverwriteOccupation property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsOverwriteOccupation() {
        return isOverwriteOccupation;
    }

    /**
     * Sets the value of the isOverwriteOccupation property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsOverwriteOccupation(Boolean value) {
        this.isOverwriteOccupation = value;
    }

    /**
     * Gets the value of the isOverwriteMobile property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsOverwriteMobile() {
        return isOverwriteMobile;
    }

    /**
     * Sets the value of the isOverwriteMobile property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsOverwriteMobile(Boolean value) {
        this.isOverwriteMobile = value;
    }

    /**
     * Gets the value of the isOverwriteCity property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsOverwriteCity() {
        return isOverwriteCity;
    }

    /**
     * Sets the value of the isOverwriteCity property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsOverwriteCity(Boolean value) {
        this.isOverwriteCity = value;
    }

    /**
     * Gets the value of the isOverwriteGender property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsOverwriteGender() {
        return isOverwriteGender;
    }

    /**
     * Sets the value of the isOverwriteGender property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsOverwriteGender(Boolean value) {
        this.isOverwriteGender = value;
    }

    /**
     * Gets the value of the isOverwriteStudyTarget property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsOverwriteStudyTarget() {
        return isOverwriteStudyTarget;
    }

    /**
     * Sets the value of the isOverwriteStudyTarget property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsOverwriteStudyTarget(Boolean value) {
        this.isOverwriteStudyTarget = value;
    }

}
