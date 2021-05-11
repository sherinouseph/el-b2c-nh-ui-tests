
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
 *         &lt;element name="ValidateMemberEmailResult" type="{EFSchools.Englishtown.Commerce.Client.Members}ValidateMemberEmailResult" minOccurs="0"/>
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
    "validateMemberEmailResult"
})
@XmlRootElement(name = "ValidateMemberEmailResponse")
public class ValidateMemberEmailResponse {

    @XmlElementRef(name = "ValidateMemberEmailResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<ValidateMemberEmailResult> validateMemberEmailResult;

    /**
     * Gets the value of the validateMemberEmailResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ValidateMemberEmailResult }{@code >}
     *     
     */
    public JAXBElement<ValidateMemberEmailResult> getValidateMemberEmailResult() {
        return validateMemberEmailResult;
    }

    /**
     * Sets the value of the validateMemberEmailResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ValidateMemberEmailResult }{@code >}
     *     
     */
    public void setValidateMemberEmailResult(JAXBElement<ValidateMemberEmailResult> value) {
        this.validateMemberEmailResult = value;
    }

}
