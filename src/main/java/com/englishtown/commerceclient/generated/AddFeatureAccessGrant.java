
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
 *         &lt;element name="addFeatureAccessGrantParams" type="{EFSchools.Englishtown.Commerce.Client.Accounts}AddFeatureAccessGrantParams" minOccurs="0"/>
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
    "addFeatureAccessGrantParams"
})
@XmlRootElement(name = "AddFeatureAccessGrant")
public class AddFeatureAccessGrant {

    @XmlElementRef(name = "addFeatureAccessGrantParams", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<AddFeatureAccessGrantParams> addFeatureAccessGrantParams;

    /**
     * Gets the value of the addFeatureAccessGrantParams property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AddFeatureAccessGrantParams }{@code >}
     *     
     */
    public JAXBElement<AddFeatureAccessGrantParams> getAddFeatureAccessGrantParams() {
        return addFeatureAccessGrantParams;
    }

    /**
     * Sets the value of the addFeatureAccessGrantParams property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AddFeatureAccessGrantParams }{@code >}
     *     
     */
    public void setAddFeatureAccessGrantParams(JAXBElement<AddFeatureAccessGrantParams> value) {
        this.addFeatureAccessGrantParams = value;
    }

}
