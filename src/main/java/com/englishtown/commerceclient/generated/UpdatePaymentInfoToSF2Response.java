
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
 *         &lt;element name="UpdatePaymentInfoToSF2Result" type="{EFSchools.Englishtown.Commerce.Client.Accounts}UpdatePaymentInfoToSFResult" minOccurs="0"/>
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
    "updatePaymentInfoToSF2Result"
})
@XmlRootElement(name = "UpdatePaymentInfoToSF2Response")
public class UpdatePaymentInfoToSF2Response {

    @XmlElementRef(name = "UpdatePaymentInfoToSF2Result", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<UpdatePaymentInfoToSFResult> updatePaymentInfoToSF2Result;

    /**
     * Gets the value of the updatePaymentInfoToSF2Result property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link UpdatePaymentInfoToSFResult }{@code >}
     *     
     */
    public JAXBElement<UpdatePaymentInfoToSFResult> getUpdatePaymentInfoToSF2Result() {
        return updatePaymentInfoToSF2Result;
    }

    /**
     * Sets the value of the updatePaymentInfoToSF2Result property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link UpdatePaymentInfoToSFResult }{@code >}
     *     
     */
    public void setUpdatePaymentInfoToSF2Result(JAXBElement<UpdatePaymentInfoToSFResult> value) {
        this.updatePaymentInfoToSF2Result = value;
    }

}
