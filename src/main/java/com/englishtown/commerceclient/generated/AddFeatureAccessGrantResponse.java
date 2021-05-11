
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
 *         &lt;element name="AddFeatureAccessGrantResult" type="{EFSchools.Englishtown.Commerce.Client.Accounts}AddFeatureAccessGrantResult" minOccurs="0"/>
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
    "addFeatureAccessGrantResult"
})
@XmlRootElement(name = "AddFeatureAccessGrantResponse")
public class AddFeatureAccessGrantResponse {

    @XmlElementRef(name = "AddFeatureAccessGrantResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<AddFeatureAccessGrantResult> addFeatureAccessGrantResult;

    /**
     * Gets the value of the addFeatureAccessGrantResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AddFeatureAccessGrantResult }{@code >}
     *     
     */
    public JAXBElement<AddFeatureAccessGrantResult> getAddFeatureAccessGrantResult() {
        return addFeatureAccessGrantResult;
    }

    /**
     * Sets the value of the addFeatureAccessGrantResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AddFeatureAccessGrantResult }{@code >}
     *     
     */
    public void setAddFeatureAccessGrantResult(JAXBElement<AddFeatureAccessGrantResult> value) {
        this.addFeatureAccessGrantResult = value;
    }

}
