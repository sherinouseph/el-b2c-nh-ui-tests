
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
 *         &lt;element name="UpdateOrderStatusToSFResult" type="{EFSchools.Englishtown.Commerce.Client.Accounts}UpdateOrderStatusToSFResult" minOccurs="0"/>
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
    "updateOrderStatusToSFResult"
})
@XmlRootElement(name = "UpdateOrderStatusToSFResponse")
public class UpdateOrderStatusToSFResponse {

    @XmlElementRef(name = "UpdateOrderStatusToSFResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<UpdateOrderStatusToSFResult> updateOrderStatusToSFResult;

    /**
     * Gets the value of the updateOrderStatusToSFResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link UpdateOrderStatusToSFResult }{@code >}
     *     
     */
    public JAXBElement<UpdateOrderStatusToSFResult> getUpdateOrderStatusToSFResult() {
        return updateOrderStatusToSFResult;
    }

    /**
     * Sets the value of the updateOrderStatusToSFResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link UpdateOrderStatusToSFResult }{@code >}
     *     
     */
    public void setUpdateOrderStatusToSFResult(JAXBElement<UpdateOrderStatusToSFResult> value) {
        this.updateOrderStatusToSFResult = value;
    }

}
