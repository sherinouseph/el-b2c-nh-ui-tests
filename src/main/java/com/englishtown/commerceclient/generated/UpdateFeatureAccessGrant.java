
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
 *         &lt;element name="updateFeatureAccessGrantParams" type="{EFSchools.Englishtown.Commerce.Client.Accounts}UpdateFeatureAccessGrantParams" minOccurs="0"/>
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
    "updateFeatureAccessGrantParams"
})
@XmlRootElement(name = "UpdateFeatureAccessGrant")
public class UpdateFeatureAccessGrant {

    @XmlElementRef(name = "updateFeatureAccessGrantParams", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<UpdateFeatureAccessGrantParams> updateFeatureAccessGrantParams;

    /**
     * Gets the value of the updateFeatureAccessGrantParams property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link UpdateFeatureAccessGrantParams }{@code >}
     *     
     */
    public JAXBElement<UpdateFeatureAccessGrantParams> getUpdateFeatureAccessGrantParams() {
        return updateFeatureAccessGrantParams;
    }

    /**
     * Sets the value of the updateFeatureAccessGrantParams property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link UpdateFeatureAccessGrantParams }{@code >}
     *     
     */
    public void setUpdateFeatureAccessGrantParams(JAXBElement<UpdateFeatureAccessGrantParams> value) {
        this.updateFeatureAccessGrantParams = value;
    }

}
