
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
 *         &lt;element name="UpdateFeatureAccessGrantBatchResult" type="{EFSchools.Englishtown.Commerce.Client.Accounts}UpdateFeatureAccessGrantBatchResult" minOccurs="0"/>
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
    "updateFeatureAccessGrantBatchResult"
})
@XmlRootElement(name = "UpdateFeatureAccessGrantBatchResponse")
public class UpdateFeatureAccessGrantBatchResponse {

    @XmlElementRef(name = "UpdateFeatureAccessGrantBatchResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<UpdateFeatureAccessGrantBatchResult> updateFeatureAccessGrantBatchResult;

    /**
     * Gets the value of the updateFeatureAccessGrantBatchResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link UpdateFeatureAccessGrantBatchResult }{@code >}
     *     
     */
    public JAXBElement<UpdateFeatureAccessGrantBatchResult> getUpdateFeatureAccessGrantBatchResult() {
        return updateFeatureAccessGrantBatchResult;
    }

    /**
     * Sets the value of the updateFeatureAccessGrantBatchResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link UpdateFeatureAccessGrantBatchResult }{@code >}
     *     
     */
    public void setUpdateFeatureAccessGrantBatchResult(JAXBElement<UpdateFeatureAccessGrantBatchResult> value) {
        this.updateFeatureAccessGrantBatchResult = value;
    }

}
