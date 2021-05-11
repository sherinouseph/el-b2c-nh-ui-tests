
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
 *         &lt;element name="GetFeatureAccessGrantsWithFilterResult" type="{EFSchools.Englishtown.Commerce.Client.FeatureAccess}ArrayOfFeatureAccessGrant" minOccurs="0"/>
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
    "getFeatureAccessGrantsWithFilterResult"
})
@XmlRootElement(name = "GetFeatureAccessGrantsWithFilterResponse")
public class GetFeatureAccessGrantsWithFilterResponse {

    @XmlElementRef(name = "GetFeatureAccessGrantsWithFilterResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfFeatureAccessGrant> getFeatureAccessGrantsWithFilterResult;

    /**
     * Gets the value of the getFeatureAccessGrantsWithFilterResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfFeatureAccessGrant }{@code >}
     *     
     */
    public JAXBElement<ArrayOfFeatureAccessGrant> getGetFeatureAccessGrantsWithFilterResult() {
        return getFeatureAccessGrantsWithFilterResult;
    }

    /**
     * Sets the value of the getFeatureAccessGrantsWithFilterResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfFeatureAccessGrant }{@code >}
     *     
     */
    public void setGetFeatureAccessGrantsWithFilterResult(JAXBElement<ArrayOfFeatureAccessGrant> value) {
        this.getFeatureAccessGrantsWithFilterResult = value;
    }

}
