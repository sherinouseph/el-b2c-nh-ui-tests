
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
 *         &lt;element name="ExtendAccountForMemberResult" type="{EFSchools.Englishtown.Commerce.Client.Accounts}ExtendAccountResult" minOccurs="0"/>
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
    "extendAccountForMemberResult"
})
@XmlRootElement(name = "ExtendAccountForMemberResponse")
public class ExtendAccountForMemberResponse {

    @XmlElementRef(name = "ExtendAccountForMemberResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<ExtendAccountResult> extendAccountForMemberResult;

    /**
     * Gets the value of the extendAccountForMemberResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ExtendAccountResult }{@code >}
     *     
     */
    public JAXBElement<ExtendAccountResult> getExtendAccountForMemberResult() {
        return extendAccountForMemberResult;
    }

    /**
     * Sets the value of the extendAccountForMemberResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ExtendAccountResult }{@code >}
     *     
     */
    public void setExtendAccountForMemberResult(JAXBElement<ExtendAccountResult> value) {
        this.extendAccountForMemberResult = value;
    }

}
