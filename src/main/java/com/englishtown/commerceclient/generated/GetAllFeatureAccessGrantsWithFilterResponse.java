
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
 *         &lt;element name="GetAllFeatureAccessGrantsWithFilterResult" type="{EFSchools.Englishtown.Commerce.Client.Accounts}GetAllFeatureAccessGrantsWithFilterResult" minOccurs="0"/>
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
    "getAllFeatureAccessGrantsWithFilterResult"
})
@XmlRootElement(name = "GetAllFeatureAccessGrantsWithFilterResponse")
public class GetAllFeatureAccessGrantsWithFilterResponse {

    @XmlElementRef(name = "GetAllFeatureAccessGrantsWithFilterResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<GetAllFeatureAccessGrantsWithFilterResult> getAllFeatureAccessGrantsWithFilterResult;

    /**
     * Gets the value of the getAllFeatureAccessGrantsWithFilterResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link GetAllFeatureAccessGrantsWithFilterResult }{@code >}
     *     
     */
    public JAXBElement<GetAllFeatureAccessGrantsWithFilterResult> getGetAllFeatureAccessGrantsWithFilterResult() {
        return getAllFeatureAccessGrantsWithFilterResult;
    }

    /**
     * Sets the value of the getAllFeatureAccessGrantsWithFilterResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link GetAllFeatureAccessGrantsWithFilterResult }{@code >}
     *     
     */
    public void setGetAllFeatureAccessGrantsWithFilterResult(JAXBElement<GetAllFeatureAccessGrantsWithFilterResult> value) {
        this.getAllFeatureAccessGrantsWithFilterResult = value;
    }

}
