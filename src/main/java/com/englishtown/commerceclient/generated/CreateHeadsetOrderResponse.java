
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
 *         &lt;element name="CreateHeadsetOrderResult" type="{EFSchools.Englishtown.Commerce.Client.Headset}CreateHeadsetOrderResult" minOccurs="0"/>
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
    "createHeadsetOrderResult"
})
@XmlRootElement(name = "CreateHeadsetOrderResponse")
public class CreateHeadsetOrderResponse {

    @XmlElementRef(name = "CreateHeadsetOrderResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<CreateHeadsetOrderResult> createHeadsetOrderResult;

    /**
     * Gets the value of the createHeadsetOrderResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link CreateHeadsetOrderResult }{@code >}
     *     
     */
    public JAXBElement<CreateHeadsetOrderResult> getCreateHeadsetOrderResult() {
        return createHeadsetOrderResult;
    }

    /**
     * Sets the value of the createHeadsetOrderResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link CreateHeadsetOrderResult }{@code >}
     *     
     */
    public void setCreateHeadsetOrderResult(JAXBElement<CreateHeadsetOrderResult> value) {
        this.createHeadsetOrderResult = value;
    }

}
