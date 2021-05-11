
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
 *         &lt;element name="getAllFeatureAccessGrantsWithFilterParams" type="{EFSchools.Englishtown.Commerce.Client.Accounts}GetAllFeatureAccessGrantsWithFilterParams" minOccurs="0"/>
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
    "getAllFeatureAccessGrantsWithFilterParams"
})
@XmlRootElement(name = "GetAllFeatureAccessGrantsWithFilter")
public class GetAllFeatureAccessGrantsWithFilter {

    @XmlElementRef(name = "getAllFeatureAccessGrantsWithFilterParams", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<GetAllFeatureAccessGrantsWithFilterParams> getAllFeatureAccessGrantsWithFilterParams;

    /**
     * Gets the value of the getAllFeatureAccessGrantsWithFilterParams property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link GetAllFeatureAccessGrantsWithFilterParams }{@code >}
     *     
     */
    public JAXBElement<GetAllFeatureAccessGrantsWithFilterParams> getGetAllFeatureAccessGrantsWithFilterParams() {
        return getAllFeatureAccessGrantsWithFilterParams;
    }

    /**
     * Sets the value of the getAllFeatureAccessGrantsWithFilterParams property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link GetAllFeatureAccessGrantsWithFilterParams }{@code >}
     *     
     */
    public void setGetAllFeatureAccessGrantsWithFilterParams(JAXBElement<GetAllFeatureAccessGrantsWithFilterParams> value) {
        this.getAllFeatureAccessGrantsWithFilterParams = value;
    }

}
