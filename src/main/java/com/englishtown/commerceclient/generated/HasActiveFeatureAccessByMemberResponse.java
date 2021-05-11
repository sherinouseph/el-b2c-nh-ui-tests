
package com.englishtown.commerceclient.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element name="HasActiveFeatureAccessByMemberResult" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
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
    "hasActiveFeatureAccessByMemberResult"
})
@XmlRootElement(name = "HasActiveFeatureAccessByMemberResponse")
public class HasActiveFeatureAccessByMemberResponse {

    @XmlElement(name = "HasActiveFeatureAccessByMemberResult")
    protected Boolean hasActiveFeatureAccessByMemberResult;

    /**
     * Gets the value of the hasActiveFeatureAccessByMemberResult property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHasActiveFeatureAccessByMemberResult() {
        return hasActiveFeatureAccessByMemberResult;
    }

    /**
     * Sets the value of the hasActiveFeatureAccessByMemberResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHasActiveFeatureAccessByMemberResult(Boolean value) {
        this.hasActiveFeatureAccessByMemberResult = value;
    }

}
