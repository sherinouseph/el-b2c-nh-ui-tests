
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
 *         &lt;element name="GetBatchSubscriptionsResult" type="{EFSchools.Englishtown.Commerce.Client.Subscriptions}GetBatchSubscriptionsResult" minOccurs="0"/>
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
    "getBatchSubscriptionsResult"
})
@XmlRootElement(name = "GetBatchSubscriptionsResponse")
public class GetBatchSubscriptionsResponse {

    @XmlElementRef(name = "GetBatchSubscriptionsResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<GetBatchSubscriptionsResult> getBatchSubscriptionsResult;

    /**
     * Gets the value of the getBatchSubscriptionsResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link GetBatchSubscriptionsResult }{@code >}
     *     
     */
    public JAXBElement<GetBatchSubscriptionsResult> getGetBatchSubscriptionsResult() {
        return getBatchSubscriptionsResult;
    }

    /**
     * Sets the value of the getBatchSubscriptionsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link GetBatchSubscriptionsResult }{@code >}
     *     
     */
    public void setGetBatchSubscriptionsResult(JAXBElement<GetBatchSubscriptionsResult> value) {
        this.getBatchSubscriptionsResult = value;
    }

}
