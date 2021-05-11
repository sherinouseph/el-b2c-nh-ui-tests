
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
 *         &lt;element name="CancelSuspendedOrderResult" type="{EFSchools.Englishtown.Commerce.Client.Accounts}CancelSuspendedOrderResult" minOccurs="0"/>
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
    "cancelSuspendedOrderResult"
})
@XmlRootElement(name = "CancelSuspendedOrderResponse")
public class CancelSuspendedOrderResponse {

    @XmlElementRef(name = "CancelSuspendedOrderResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<CancelSuspendedOrderResult> cancelSuspendedOrderResult;

    /**
     * Gets the value of the cancelSuspendedOrderResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link CancelSuspendedOrderResult }{@code >}
     *     
     */
    public JAXBElement<CancelSuspendedOrderResult> getCancelSuspendedOrderResult() {
        return cancelSuspendedOrderResult;
    }

    /**
     * Sets the value of the cancelSuspendedOrderResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link CancelSuspendedOrderResult }{@code >}
     *     
     */
    public void setCancelSuspendedOrderResult(JAXBElement<CancelSuspendedOrderResult> value) {
        this.cancelSuspendedOrderResult = value;
    }

}
