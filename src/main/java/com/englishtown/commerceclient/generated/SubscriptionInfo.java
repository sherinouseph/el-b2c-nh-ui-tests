
package com.englishtown.commerceclient.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <summary>
 * 
 *                         </summary>
 * 
 * <p>Java class for SubscriptionInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SubscriptionInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Subscription_id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Member_id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ActivatedDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="DeactivatedDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="ExpirationDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="NextBillingDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="IsActive" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="IsMarkedForCancellation" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="RedemptionCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SalesOrder_id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="SubscriptionType" type="{EFSchools.Englishtown.Commerce.Client.Subscriptions}SubscriptionTypes" minOccurs="0"/>
 *         &lt;element name="SuspendDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="ResumeDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="IsRenewable" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SubscriptionInfo", namespace = "EFSchools.Englishtown.Commerce.Client.Subscriptions", propOrder = {
    "subscriptionId",
    "memberId",
    "activatedDate",
    "deactivatedDate",
    "expirationDate",
    "nextBillingDate",
    "isActive",
    "isMarkedForCancellation",
    "redemptionCode",
    "salesOrderId",
    "subscriptionType",
    "suspendDate",
    "resumeDate",
    "isRenewable"
})
public class SubscriptionInfo {

    @XmlElement(name = "Subscription_id", required = true, type = Integer.class, nillable = true)
    protected Integer subscriptionId;
    @XmlElement(name = "Member_id")
    protected int memberId;
    @XmlElement(name = "ActivatedDate", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar activatedDate;
    @XmlElement(name = "DeactivatedDate", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar deactivatedDate;
    @XmlElement(name = "ExpirationDate", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar expirationDate;
    @XmlElement(name = "NextBillingDate", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar nextBillingDate;
    @XmlElement(name = "IsActive")
    protected boolean isActive;
    @XmlElement(name = "IsMarkedForCancellation")
    protected boolean isMarkedForCancellation;
    @XmlElement(name = "RedemptionCode", required = true, nillable = true)
    protected String redemptionCode;
    @XmlElement(name = "SalesOrder_id")
    protected long salesOrderId;
    @XmlElement(name = "SubscriptionType")
    protected SubscriptionTypes subscriptionType;
    @XmlElementRef(name = "SuspendDate", namespace = "EFSchools.Englishtown.Commerce.Client.Subscriptions", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> suspendDate;
    @XmlElementRef(name = "ResumeDate", namespace = "EFSchools.Englishtown.Commerce.Client.Subscriptions", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> resumeDate;
    @XmlElement(name = "IsRenewable")
    protected Boolean isRenewable;

    /**
     * Gets the value of the subscriptionId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSubscriptionId() {
        return subscriptionId;
    }

    /**
     * Sets the value of the subscriptionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSubscriptionId(Integer value) {
        this.subscriptionId = value;
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
     * Gets the value of the activatedDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getActivatedDate() {
        return activatedDate;
    }

    /**
     * Sets the value of the activatedDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setActivatedDate(XMLGregorianCalendar value) {
        this.activatedDate = value;
    }

    /**
     * Gets the value of the deactivatedDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDeactivatedDate() {
        return deactivatedDate;
    }

    /**
     * Sets the value of the deactivatedDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDeactivatedDate(XMLGregorianCalendar value) {
        this.deactivatedDate = value;
    }

    /**
     * Gets the value of the expirationDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getExpirationDate() {
        return expirationDate;
    }

    /**
     * Sets the value of the expirationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setExpirationDate(XMLGregorianCalendar value) {
        this.expirationDate = value;
    }

    /**
     * Gets the value of the nextBillingDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getNextBillingDate() {
        return nextBillingDate;
    }

    /**
     * Sets the value of the nextBillingDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setNextBillingDate(XMLGregorianCalendar value) {
        this.nextBillingDate = value;
    }

    /**
     * Gets the value of the isActive property.
     * 
     */
    public boolean isIsActive() {
        return isActive;
    }

    /**
     * Sets the value of the isActive property.
     * 
     */
    public void setIsActive(boolean value) {
        this.isActive = value;
    }

    /**
     * Gets the value of the isMarkedForCancellation property.
     * 
     */
    public boolean isIsMarkedForCancellation() {
        return isMarkedForCancellation;
    }

    /**
     * Sets the value of the isMarkedForCancellation property.
     * 
     */
    public void setIsMarkedForCancellation(boolean value) {
        this.isMarkedForCancellation = value;
    }

    /**
     * Gets the value of the redemptionCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRedemptionCode() {
        return redemptionCode;
    }

    /**
     * Sets the value of the redemptionCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRedemptionCode(String value) {
        this.redemptionCode = value;
    }

    /**
     * Gets the value of the salesOrderId property.
     * 
     */
    public long getSalesOrderId() {
        return salesOrderId;
    }

    /**
     * Sets the value of the salesOrderId property.
     * 
     */
    public void setSalesOrderId(long value) {
        this.salesOrderId = value;
    }

    /**
     * Gets the value of the subscriptionType property.
     * 
     * @return
     *     possible object is
     *     {@link SubscriptionTypes }
     *     
     */
    public SubscriptionTypes getSubscriptionType() {
        return subscriptionType;
    }

    /**
     * Sets the value of the subscriptionType property.
     * 
     * @param value
     *     allowed object is
     *     {@link SubscriptionTypes }
     *     
     */
    public void setSubscriptionType(SubscriptionTypes value) {
        this.subscriptionType = value;
    }

    /**
     * Gets the value of the suspendDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getSuspendDate() {
        return suspendDate;
    }

    /**
     * Sets the value of the suspendDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setSuspendDate(JAXBElement<XMLGregorianCalendar> value) {
        this.suspendDate = value;
    }

    /**
     * Gets the value of the resumeDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getResumeDate() {
        return resumeDate;
    }

    /**
     * Sets the value of the resumeDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setResumeDate(JAXBElement<XMLGregorianCalendar> value) {
        this.resumeDate = value;
    }

    /**
     * Gets the value of the isRenewable property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsRenewable() {
        return isRenewable;
    }

    /**
     * Sets the value of the isRenewable property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsRenewable(Boolean value) {
        this.isRenewable = value;
    }

}
