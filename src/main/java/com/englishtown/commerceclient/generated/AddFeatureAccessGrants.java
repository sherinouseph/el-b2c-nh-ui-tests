
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
 *         &lt;element name="grant" type="{EFSchools.Englishtown.Commerce.Client.FeatureAccess}FeatureAccessGrant" minOccurs="0"/>
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
    "grant"
})
@XmlRootElement(name = "AddFeatureAccessGrants")
public class AddFeatureAccessGrants {

    @XmlElementRef(name = "grant", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<FeatureAccessGrant> grant;

    /**
     * Gets the value of the grant property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link FeatureAccessGrant }{@code >}
     *     
     */
    public JAXBElement<FeatureAccessGrant> getGrant() {
        return grant;
    }

    /**
     * Sets the value of the grant property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link FeatureAccessGrant }{@code >}
     *     
     */
    public void setGrant(JAXBElement<FeatureAccessGrant> value) {
        this.grant = value;
    }

}
