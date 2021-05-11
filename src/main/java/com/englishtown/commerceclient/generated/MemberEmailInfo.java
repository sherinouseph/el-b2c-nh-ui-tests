
package com.englishtown.commerceclient.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for MemberEmailInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MemberEmailInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MemberEmail_id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Member_id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="EmailAddress" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="IsValid" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="ValidationToken" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ValidateDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="ExpireDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MemberEmailInfo", namespace = "EFSchools.Englishtown.Commerce.Client.Members", propOrder = {
    "memberEmailId",
    "memberId",
    "emailAddress",
    "isValid",
    "validationToken",
    "validateDate",
    "expireDate"
})
public class MemberEmailInfo {

    @XmlElement(name = "MemberEmail_id", required = true, type = Integer.class, nillable = true)
    protected Integer memberEmailId;
    @XmlElement(name = "Member_id")
    protected int memberId;
    @XmlElement(name = "EmailAddress", required = true, nillable = true)
    protected String emailAddress;
    @XmlElement(name = "IsValid")
    protected boolean isValid;
    @XmlElement(name = "ValidationToken", required = true, nillable = true)
    protected String validationToken;
    @XmlElementRef(name = "ValidateDate", namespace = "EFSchools.Englishtown.Commerce.Client.Members", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> validateDate;
    @XmlElementRef(name = "ExpireDate", namespace = "EFSchools.Englishtown.Commerce.Client.Members", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> expireDate;

    /**
     * Gets the value of the memberEmailId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMemberEmailId() {
        return memberEmailId;
    }

    /**
     * Sets the value of the memberEmailId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMemberEmailId(Integer value) {
        this.memberEmailId = value;
    }

    /**
     * Gets the value of the memberId property.
     * 
     */
    public int getMemberId() {
        return memberId;
    }

    /**
     * Sets the value of the memberId property.
     * 
     */
    public void setMemberId(int value) {
        this.memberId = value;
    }

    /**
     * Gets the value of the emailAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Sets the value of the emailAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmailAddress(String value) {
        this.emailAddress = value;
    }

    /**
     * Gets the value of the isValid property.
     * 
     */
    public boolean isIsValid() {
        return isValid;
    }

    /**
     * Sets the value of the isValid property.
     * 
     */
    public void setIsValid(boolean value) {
        this.isValid = value;
    }

    /**
     * Gets the value of the validationToken property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValidationToken() {
        return validationToken;
    }

    /**
     * Sets the value of the validationToken property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValidationToken(String value) {
        this.validationToken = value;
    }

    /**
     * Gets the value of the validateDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getValidateDate() {
        return validateDate;
    }

    /**
     * Sets the value of the validateDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setValidateDate(JAXBElement<XMLGregorianCalendar> value) {
        this.validateDate = value;
    }

    /**
     * Gets the value of the expireDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getExpireDate() {
        return expireDate;
    }

    /**
     * Sets the value of the expireDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setExpireDate(JAXBElement<XMLGregorianCalendar> value) {
        this.expireDate = value;
    }

}
