
package com.englishtown.commerceclient.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UpdateFeatureAccessGrantBatchParamsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UpdateFeatureAccessGrantBatchParamsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FeatureAccessGrants" type="{EFSchools.Englishtown.Commerce.Client.Accounts}ArrayOfUpdateFeatureAccessGrantBatchParams_FeatureAccessGrant"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UpdateFeatureAccessGrantBatchParamsType", namespace = "EFSchools.Englishtown.Commerce.Client.Accounts", propOrder = {
    "featureAccessGrants"
})
public class UpdateFeatureAccessGrantBatchParamsType {

    @XmlElement(name = "FeatureAccessGrants", required = true, nillable = true)
    protected ArrayOfUpdateFeatureAccessGrantBatchParamsFeatureAccessGrant featureAccessGrants;

    /**
     * Gets the value of the featureAccessGrants property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfUpdateFeatureAccessGrantBatchParamsFeatureAccessGrant }
     *     
     */
    public ArrayOfUpdateFeatureAccessGrantBatchParamsFeatureAccessGrant getFeatureAccessGrants() {
        return featureAccessGrants;
    }

    /**
     * Sets the value of the featureAccessGrants property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfUpdateFeatureAccessGrantBatchParamsFeatureAccessGrant }
     *     
     */
    public void setFeatureAccessGrants(ArrayOfUpdateFeatureAccessGrantBatchParamsFeatureAccessGrant value) {
        this.featureAccessGrants = value;
    }

}
