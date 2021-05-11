
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
 *         &lt;element name="getActiveMemberWithFeatureParams" type="{EFSchools.Englishtown.Commerce.Client.Accounts}GetActiveMemberWithFeatureParams" minOccurs="0"/>
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
    "getActiveMemberWithFeatureParams"
})
@XmlRootElement(name = "GetActiveMemberWithFeature")
public class GetActiveMemberWithFeature {

    @XmlElementRef(name = "getActiveMemberWithFeatureParams", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<GetActiveMemberWithFeatureParams> getActiveMemberWithFeatureParams;

    /**
     * Gets the value of the getActiveMemberWithFeatureParams property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link GetActiveMemberWithFeatureParams }{@code >}
     *     
     */
    public JAXBElement<GetActiveMemberWithFeatureParams> getGetActiveMemberWithFeatureParams() {
        return getActiveMemberWithFeatureParams;
    }

    /**
     * Sets the value of the getActiveMemberWithFeatureParams property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link GetActiveMemberWithFeatureParams }{@code >}
     *     
     */
    public void setGetActiveMemberWithFeatureParams(JAXBElement<GetActiveMemberWithFeatureParams> value) {
        this.getActiveMemberWithFeatureParams = value;
    }

}
