
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
 *         &lt;element name="headsetOrder" type="{EFSchools.Englishtown.Commerce.Client.Headset}CreateHeadsetOrderParams" minOccurs="0"/>
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
    "headsetOrder"
})
@XmlRootElement(name = "CreateHeadsetOrder")
public class CreateHeadsetOrder {

    @XmlElementRef(name = "headsetOrder", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<CreateHeadsetOrderParams> headsetOrder;

    /**
     * Gets the value of the headsetOrder property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link CreateHeadsetOrderParams }{@code >}
     *     
     */
    public JAXBElement<CreateHeadsetOrderParams> getHeadsetOrder() {
        return headsetOrder;
    }

    /**
     * Sets the value of the headsetOrder property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link CreateHeadsetOrderParams }{@code >}
     *     
     */
    public void setHeadsetOrder(JAXBElement<CreateHeadsetOrderParams> value) {
        this.headsetOrder = value;
    }

}
