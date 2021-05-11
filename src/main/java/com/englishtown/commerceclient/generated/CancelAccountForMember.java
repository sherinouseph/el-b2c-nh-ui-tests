
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
 *         &lt;element name="cancelAccountParams" type="{EFSchools.Englishtown.Commerce.Client.Accounts}CancelAccountParams" minOccurs="0"/>
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
    "cancelAccountParams"
})
@XmlRootElement(name = "CancelAccountForMember")
public class CancelAccountForMember {

    @XmlElementRef(name = "cancelAccountParams", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<CancelAccountParams> cancelAccountParams;

    /**
     * Gets the value of the cancelAccountParams property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link CancelAccountParams }{@code >}
     *     
     */
    public JAXBElement<CancelAccountParams> getCancelAccountParams() {
        return cancelAccountParams;
    }

    /**
     * Sets the value of the cancelAccountParams property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link CancelAccountParams }{@code >}
     *     
     */
    public void setCancelAccountParams(JAXBElement<CancelAccountParams> value) {
        this.cancelAccountParams = value;
    }

}
