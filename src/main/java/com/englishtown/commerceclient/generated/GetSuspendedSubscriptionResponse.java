
package com.englishtown.commerceclient.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GetSuspendedSubscriptionResult" type="{EFSchools.Englishtown.Commerce.Client.Subscriptions}SubscriptionInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getSuspendedSubscriptionResult"
})
@XmlRootElement(name = "GetSuspendedSubscriptionResponse")
public class GetSuspendedSubscriptionResponse {

    @XmlElementRef(name = "GetSuspendedSubscriptionResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<SubscriptionInfo> getSuspendedSubscriptionResult;

    /**
     * Gets the value of the getSuspendedSubscriptionResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link SubscriptionInfo }{@code >}
     *     
     */
    public JAXBElement<SubscriptionInfo> getGetSuspendedSubscriptionResult() {
        return getSuspendedSubscriptionResult;
    }

    /**
     * Sets the value of the getSuspendedSubscriptionResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link SubscriptionInfo }{@code >}
     *     
     */
    public void setGetSuspendedSubscriptionResult(JAXBElement<SubscriptionInfo> value) {
        this.getSuspendedSubscriptionResult = value;
    }

}
