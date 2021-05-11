
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
 *         &lt;element name="LicenseTransferByMemberIdResult" type="{EFSchools.Englishtown.Commerce.Client.Subscriptions}LicenseTransferResult" minOccurs="0"/>
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
    "licenseTransferByMemberIdResult"
})
@XmlRootElement(name = "LicenseTransferByMemberIdResponse")
public class LicenseTransferByMemberIdResponse {

    @XmlElementRef(name = "LicenseTransferByMemberIdResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<LicenseTransferResult> licenseTransferByMemberIdResult;

    /**
     * Gets the value of the licenseTransferByMemberIdResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LicenseTransferResult }{@code >}
     *     
     */
    public JAXBElement<LicenseTransferResult> getLicenseTransferByMemberIdResult() {
        return licenseTransferByMemberIdResult;
    }

    /**
     * Sets the value of the licenseTransferByMemberIdResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LicenseTransferResult }{@code >}
     *     
     */
    public void setLicenseTransferByMemberIdResult(JAXBElement<LicenseTransferResult> value) {
        this.licenseTransferByMemberIdResult = value;
    }

}
