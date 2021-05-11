
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
 *         &lt;element name="GetAllSubscriptionsResult" type="{EFSchools.Englishtown.Commerce.Client.Subscriptions}ArrayOfSubscriptionInfo" minOccurs="0"/>
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
    "getAllSubscriptionsResult"
})
@XmlRootElement(name = "GetAllSubscriptionsResponse")
public class GetAllSubscriptionsResponse {

    @XmlElementRef(name = "GetAllSubscriptionsResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfSubscriptionInfo> getAllSubscriptionsResult;

    /**
     * Gets the value of the getAllSubscriptionsResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfSubscriptionInfo }{@code >}
     *     
     */
    public JAXBElement<ArrayOfSubscriptionInfo> getGetAllSubscriptionsResult() {
        return getAllSubscriptionsResult;
    }

    /**
     * Sets the value of the getAllSubscriptionsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfSubscriptionInfo }{@code >}
     *     
     */
    public void setGetAllSubscriptionsResult(JAXBElement<ArrayOfSubscriptionInfo> value) {
        this.getAllSubscriptionsResult = value;
    }

}
