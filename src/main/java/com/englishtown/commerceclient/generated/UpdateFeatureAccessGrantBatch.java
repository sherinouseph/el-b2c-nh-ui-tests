
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
 *         &lt;element name="_params" type="{EFSchools.Englishtown.Commerce.Client.Accounts}UpdateFeatureAccessGrantBatchParamsType" minOccurs="0"/>
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
    "params"
})
@XmlRootElement(name = "UpdateFeatureAccessGrantBatch")
public class UpdateFeatureAccessGrantBatch {

    @XmlElementRef(name = "_params", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<UpdateFeatureAccessGrantBatchParamsType> params;

    /**
     * Gets the value of the params property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link UpdateFeatureAccessGrantBatchParamsType }{@code >}
     *     
     */
    public JAXBElement<UpdateFeatureAccessGrantBatchParamsType> getParams() {
        return params;
    }

    /**
     * Sets the value of the params property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link UpdateFeatureAccessGrantBatchParamsType }{@code >}
     *     
     */
    public void setParams(JAXBElement<UpdateFeatureAccessGrantBatchParamsType> value) {
        this.params = value;
    }

}
