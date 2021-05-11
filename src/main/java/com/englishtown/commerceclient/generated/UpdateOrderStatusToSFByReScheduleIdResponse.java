
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
 *         &lt;element name="UpdateOrderStatusToSFByReScheduleIdResult" type="{EFSchools.Englishtown.Commerce.Client.Accounts}UpdateOrderStatusToSFResult" minOccurs="0"/>
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
    "updateOrderStatusToSFByReScheduleIdResult"
})
@XmlRootElement(name = "UpdateOrderStatusToSFByReScheduleIdResponse")
public class UpdateOrderStatusToSFByReScheduleIdResponse {

    @XmlElementRef(name = "UpdateOrderStatusToSFByReScheduleIdResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<UpdateOrderStatusToSFResult> updateOrderStatusToSFByReScheduleIdResult;

    /**
     * Gets the value of the updateOrderStatusToSFByReScheduleIdResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link UpdateOrderStatusToSFResult }{@code >}
     *     
     */
    public JAXBElement<UpdateOrderStatusToSFResult> getUpdateOrderStatusToSFByReScheduleIdResult() {
        return updateOrderStatusToSFByReScheduleIdResult;
    }

    /**
     * Sets the value of the updateOrderStatusToSFByReScheduleIdResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link UpdateOrderStatusToSFResult }{@code >}
     *     
     */
    public void setUpdateOrderStatusToSFByReScheduleIdResult(JAXBElement<UpdateOrderStatusToSFResult> value) {
        this.updateOrderStatusToSFByReScheduleIdResult = value;
    }

}
