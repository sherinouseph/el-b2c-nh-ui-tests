
package com.englishtown.commerceclient.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <summary>
 * 
 *                         </summary>
 * 
 * <p>Java class for MemberEnrollmentInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MemberEnrollmentInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HasSPIN" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="IsFirstVisitEnrollment" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="ActiveSubscription" type="{EFSchools.Englishtown.Commerce.Client.Subscriptions}SubscriptionInfo"/>
 *         &lt;element name="HasPhoneCoaching" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MemberEnrollmentInfo", namespace = "EFSchools.Englishtown.Commerce.Client.Members", propOrder = {
    "hasSPIN",
    "isFirstVisitEnrollment",
    "activeSubscription",
    "hasPhoneCoaching"
})
public class MemberEnrollmentInfo {

    @XmlElement(name = "HasSPIN")
    protected boolean hasSPIN;
    @XmlElement(name = "IsFirstVisitEnrollment")
    protected boolean isFirstVisitEnrollment;
    @XmlElement(name = "ActiveSubscription", required = true, nillable = true)
    protected SubscriptionInfo activeSubscription;
    @XmlElement(name = "HasPhoneCoaching")
    protected boolean hasPhoneCoaching;

    /**
     * Gets the value of the hasSPIN property.
     * 
     */
    public boolean isHasSPIN() {
        return hasSPIN;
    }

    /**
     * Sets the value of the hasSPIN property.
     * 
     */
    public void setHasSPIN(boolean value) {
        this.hasSPIN = value;
    }

    /**
     * Gets the value of the isFirstVisitEnrollment property.
     * 
     */
    public boolean isIsFirstVisitEnrollment() {
        return isFirstVisitEnrollment;
    }

    /**
     * Sets the value of the isFirstVisitEnrollment property.
     * 
     */
    public void setIsFirstVisitEnrollment(boolean value) {
        this.isFirstVisitEnrollment = value;
    }

    /**
     * Gets the value of the activeSubscription property.
     * 
     * @return
     *     possible object is
     *     {@link SubscriptionInfo }
     *     
     */
    public SubscriptionInfo getActiveSubscription() {
        return activeSubscription;
    }

    /**
     * Sets the value of the activeSubscription property.
     * 
     * @param value
     *     allowed object is
     *     {@link SubscriptionInfo }
     *     
     */
    public void setActiveSubscription(SubscriptionInfo value) {
        this.activeSubscription = value;
    }

    /**
     * Gets the value of the hasPhoneCoaching property.
     * 
     */
    public boolean isHasPhoneCoaching() {
        return hasPhoneCoaching;
    }

    /**
     * Sets the value of the hasPhoneCoaching property.
     * 
     */
    public void setHasPhoneCoaching(boolean value) {
        this.hasPhoneCoaching = value;
    }

}
