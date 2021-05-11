
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
 *         &lt;element name="CancelAccountForMemberResult" type="{EFSchools.Englishtown.Commerce.Client.Accounts}CancelAccountResult" minOccurs="0"/>
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
    "cancelAccountForMemberResult"
})
@XmlRootElement(name = "CancelAccountForMemberResponse")
public class CancelAccountForMemberResponse {

    @XmlElementRef(name = "CancelAccountForMemberResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<CancelAccountResult> cancelAccountForMemberResult;

    /**
     * Gets the value of the cancelAccountForMemberResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link CancelAccountResult }{@code >}
     *     
     */
    public JAXBElement<CancelAccountResult> getCancelAccountForMemberResult() {
        return cancelAccountForMemberResult;
    }

    /**
     * Sets the value of the cancelAccountForMemberResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link CancelAccountResult }{@code >}
     *     
     */
    public void setCancelAccountForMemberResult(JAXBElement<CancelAccountResult> value) {
        this.cancelAccountForMemberResult = value;
    }

}
