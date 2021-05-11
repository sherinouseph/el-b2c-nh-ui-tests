
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
 *         &lt;element name="UpdateFeatureAccessGrantResult" type="{EFSchools.Englishtown.Commerce.Client.Accounts}UpdateFeatureAccessGrantResult" minOccurs="0"/>
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
    "updateFeatureAccessGrantResult"
})
@XmlRootElement(name = "UpdateFeatureAccessGrantResponse")
public class UpdateFeatureAccessGrantResponse {

    @XmlElementRef(name = "UpdateFeatureAccessGrantResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<UpdateFeatureAccessGrantResult> updateFeatureAccessGrantResult;

    /**
     * Gets the value of the updateFeatureAccessGrantResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link UpdateFeatureAccessGrantResult }{@code >}
     *     
     */
    public JAXBElement<UpdateFeatureAccessGrantResult> getUpdateFeatureAccessGrantResult() {
        return updateFeatureAccessGrantResult;
    }

    /**
     * Sets the value of the updateFeatureAccessGrantResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link UpdateFeatureAccessGrantResult }{@code >}
     *     
     */
    public void setUpdateFeatureAccessGrantResult(JAXBElement<UpdateFeatureAccessGrantResult> value) {
        this.updateFeatureAccessGrantResult = value;
    }

}
