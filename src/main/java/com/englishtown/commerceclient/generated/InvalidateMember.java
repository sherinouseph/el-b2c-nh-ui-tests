
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
 *         &lt;element name="invalidateMemberParams" type="{EFSchools.Englishtown.Commerce.Client.Members}InvalidateMemberParams" minOccurs="0"/>
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
    "invalidateMemberParams"
})
@XmlRootElement(name = "InvalidateMember")
public class InvalidateMember {

    @XmlElementRef(name = "invalidateMemberParams", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<InvalidateMemberParams> invalidateMemberParams;

    /**
     * Gets the value of the invalidateMemberParams property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link InvalidateMemberParams }{@code >}
     *     
     */
    public JAXBElement<InvalidateMemberParams> getInvalidateMemberParams() {
        return invalidateMemberParams;
    }

    /**
     * Sets the value of the invalidateMemberParams property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link InvalidateMemberParams }{@code >}
     *     
     */
    public void setInvalidateMemberParams(JAXBElement<InvalidateMemberParams> value) {
        this.invalidateMemberParams = value;
    }

}
