
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
 *         &lt;element name="HasPhoneCoachingFeatureGrantResult" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
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
    "hasPhoneCoachingFeatureGrantResult"
})
@XmlRootElement(name = "HasPhoneCoachingFeatureGrantResponse")
public class HasPhoneCoachingFeatureGrantResponse {

    @XmlElement(name = "HasPhoneCoachingFeatureGrantResult")
    protected Boolean hasPhoneCoachingFeatureGrantResult;

    /**
     * Gets the value of the hasPhoneCoachingFeatureGrantResult property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHasPhoneCoachingFeatureGrantResult() {
        return hasPhoneCoachingFeatureGrantResult;
    }

    /**
     * Sets the value of the hasPhoneCoachingFeatureGrantResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHasPhoneCoachingFeatureGrantResult(Boolean value) {
        this.hasPhoneCoachingFeatureGrantResult = value;
    }

}
