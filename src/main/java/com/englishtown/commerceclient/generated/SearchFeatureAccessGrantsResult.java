
package com.englishtown.commerceclient.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SearchFeatureAccessGrantsResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SearchFeatureAccessGrantsResult">
 *   &lt;complexContent>
 *     &lt;extension base="{EFSchools.Englishtown.Commerce.Client}CommerceServiceResultBase">
 *       &lt;sequence>
 *         &lt;element name="FeatureAccessGrants" type="{EFSchools.Englishtown.Commerce.Client.Accounts}ArrayOfSearchFeatureAccessGrantsResult_FeatureAccessGrant" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SearchFeatureAccessGrantsResult", namespace = "EFSchools.Englishtown.Commerce.Client.Accounts", propOrder = {
    "featureAccessGrants"
})
public class SearchFeatureAccessGrantsResult
    extends CommerceServiceResultBase
{

    @XmlElementRef(name = "FeatureAccessGrants", namespace = "EFSchools.Englishtown.Commerce.Client.Accounts", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfSearchFeatureAccessGrantsResultFeatureAccessGrant> featureAccessGrants;

    /**
     * Gets the value of the featureAccessGrants property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfSearchFeatureAccessGrantsResultFeatureAccessGrant }{@code >}
     *     
     */
    public JAXBElement<ArrayOfSearchFeatureAccessGrantsResultFeatureAccessGrant> getFeatureAccessGrants() {
        return featureAccessGrants;
    }

    /**
     * Sets the value of the featureAccessGrants property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfSearchFeatureAccessGrantsResultFeatureAccessGrant }{@code >}
     *     
     */
    public void setFeatureAccessGrants(JAXBElement<ArrayOfSearchFeatureAccessGrantsResultFeatureAccessGrant> value) {
        this.featureAccessGrants = value;
    }

}
