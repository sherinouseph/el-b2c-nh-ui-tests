
package com.englishtown.commerceclient.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <summary>
 * 
 *                         </summary>
 * 
 * <p>Java class for ReferralInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ReferralInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DateEntered" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="IsMember" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="IsRedeemable" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="IsStudent" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="Redeemed" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="ReferFrom" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ReferralEmail" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ReferralFirstName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ReferralRedeemed" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="Referral_id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Referrer_id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReferralInfo", namespace = "EFSchools.Englishtown.Commerce.Client.Members", propOrder = {
    "dateEntered",
    "isMember",
    "isRedeemable",
    "isStudent",
    "redeemed",
    "referFrom",
    "referralEmail",
    "referralFirstName",
    "referralRedeemed",
    "referralId",
    "referrerId"
})
public class ReferralInfo {

    @XmlElement(name = "DateEntered", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateEntered;
    @XmlElement(name = "IsMember")
    protected boolean isMember;
    @XmlElement(name = "IsRedeemable")
    protected boolean isRedeemable;
    @XmlElement(name = "IsStudent")
    protected boolean isStudent;
    @XmlElement(name = "Redeemed")
    protected boolean redeemed;
    @XmlElement(name = "ReferFrom", required = true, nillable = true)
    protected String referFrom;
    @XmlElement(name = "ReferralEmail", required = true, nillable = true)
    protected String referralEmail;
    @XmlElement(name = "ReferralFirstName", required = true, nillable = true)
    protected String referralFirstName;
    @XmlElement(name = "ReferralRedeemed")
    protected boolean referralRedeemed;
    @XmlElement(name = "Referral_id", required = true, type = Integer.class, nillable = true)
    protected Integer referralId;
    @XmlElement(name = "Referrer_id")
    protected int referrerId;

    /**
     * Gets the value of the dateEntered property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateEntered() {
        return dateEntered;
    }

    /**
     * Sets the value of the dateEntered property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateEntered(XMLGregorianCalendar value) {
        this.dateEntered = value;
    }

    /**
     * Gets the value of the isMember property.
     * 
     */
    public boolean isIsMember() {
        return isMember;
    }

    /**
     * Sets the value of the isMember property.
     * 
     */
    public void setIsMember(boolean value) {
        this.isMember = value;
    }

    /**
     * Gets the value of the isRedeemable property.
     * 
     */
    public boolean isIsRedeemable() {
        return isRedeemable;
    }

    /**
     * Sets the value of the isRedeemable property.
     * 
     */
    public void setIsRedeemable(boolean value) {
        this.isRedeemable = value;
    }

    /**
     * Gets the value of the isStudent property.
     * 
     */
    public boolean isIsStudent() {
        return isStudent;
    }

    /**
     * Sets the value of the isStudent property.
     * 
     */
    public void setIsStudent(boolean value) {
        this.isStudent = value;
    }

    /**
     * Gets the value of the redeemed property.
     * 
     */
    public boolean isRedeemed() {
        return redeemed;
    }

    /**
     * Sets the value of the redeemed property.
     * 
     */
    public void setRedeemed(boolean value) {
        this.redeemed = value;
    }

    /**
     * Gets the value of the referFrom property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReferFrom() {
        return referFrom;
    }

    /**
     * Sets the value of the referFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReferFrom(String value) {
        this.referFrom = value;
    }

    /**
     * Gets the value of the referralEmail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReferralEmail() {
        return referralEmail;
    }

    /**
     * Sets the value of the referralEmail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReferralEmail(String value) {
        this.referralEmail = value;
    }

    /**
     * Gets the value of the referralFirstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReferralFirstName() {
        return referralFirstName;
    }

    /**
     * Sets the value of the referralFirstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReferralFirstName(String value) {
        this.referralFirstName = value;
    }

    /**
     * Gets the value of the referralRedeemed property.
     * 
     */
    public boolean isReferralRedeemed() {
        return referralRedeemed;
    }

    /**
     * Sets the value of the referralRedeemed property.
     * 
     */
    public void setReferralRedeemed(boolean value) {
        this.referralRedeemed = value;
    }

    /**
     * Gets the value of the referralId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getReferralId() {
        return referralId;
    }

    /**
     * Sets the value of the referralId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setReferralId(Integer value) {
        this.referralId = value;
    }

    /**
     * Gets the value of the referrerId property.
     * 
     */
    public int getReferrerId() {
        return referrerId;
    }

    /**
     * Sets the value of the referrerId property.
     * 
     */
    public void setReferrerId(int value) {
        this.referrerId = value;
    }

}
