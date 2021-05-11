
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
 *         &lt;element name="searchFeatureAccessGrantsParams" type="{EFSchools.Englishtown.Commerce.Client.Accounts}SearchFeatureAccessGrantsParams" minOccurs="0"/>
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
    "searchFeatureAccessGrantsParams"
})
@XmlRootElement(name = "SearchFeatureAccessGrants")
public class SearchFeatureAccessGrants {

    @XmlElementRef(name = "searchFeatureAccessGrantsParams", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<SearchFeatureAccessGrantsParams> searchFeatureAccessGrantsParams;

    /**
     * Gets the value of the searchFeatureAccessGrantsParams property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link SearchFeatureAccessGrantsParams }{@code >}
     *     
     */
    public JAXBElement<SearchFeatureAccessGrantsParams> getSearchFeatureAccessGrantsParams() {
        return searchFeatureAccessGrantsParams;
    }

    /**
     * Sets the value of the searchFeatureAccessGrantsParams property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link SearchFeatureAccessGrantsParams }{@code >}
     *     
     */
    public void setSearchFeatureAccessGrantsParams(JAXBElement<SearchFeatureAccessGrantsParams> value) {
        this.searchFeatureAccessGrantsParams = value;
    }

}
