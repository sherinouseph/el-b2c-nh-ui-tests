
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
 *         &lt;element name="licenseTransferParams" type="{EFSchools.Englishtown.Commerce.Client.Subscriptions}LicenseTransferParams" minOccurs="0"/>
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
    "licenseTransferParams"
})
@XmlRootElement(name = "LicenseTransferByMemberId")
public class LicenseTransferByMemberId {

    @XmlElementRef(name = "licenseTransferParams", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<LicenseTransferParams> licenseTransferParams;

    /**
     * Gets the value of the licenseTransferParams property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LicenseTransferParams }{@code >}
     *     
     */
    public JAXBElement<LicenseTransferParams> getLicenseTransferParams() {
        return licenseTransferParams;
    }

    /**
     * Sets the value of the licenseTransferParams property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LicenseTransferParams }{@code >}
     *     
     */
    public void setLicenseTransferParams(JAXBElement<LicenseTransferParams> value) {
        this.licenseTransferParams = value;
    }

}
