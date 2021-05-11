
package com.englishtown.commerceclient.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetAllFeatureAccessGrantsWithFilterResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetAllFeatureAccessGrantsWithFilterResult">
 *   &lt;complexContent>
 *     &lt;extension base="{EFSchools.Englishtown.Commerce.Client}CommerceServiceResultBase">
 *       &lt;sequence>
 *         &lt;element name="FeatureAccessGrants" type="{EFSchools.Englishtown.Commerce.Client.Accounts}ArrayOfGetAllFeatureAccessGrantsWithFilterResult_FeatureAccessGrant" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetAllFeatureAccessGrantsWithFilterResult", namespace = "EFSchools.Englishtown.Commerce.Client.Accounts", propOrder = {
    "featureAccessGrants"
})
public class GetAllFeatureAccessGrantsWithFilterResult
    extends CommerceServiceResultBase
{

    @XmlElementRef(name = "FeatureAccessGrants", namespace = "EFSchools.Englishtown.Commerce.Client.Accounts", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfGetAllFeatureAccessGrantsWithFilterResultFeatureAccessGrant> featureAccessGrants;

    /**
     * Gets the value of the featureAccessGrants property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfGetAllFeatureAccessGrantsWithFilterResultFeatureAccessGrant }{@code >}
     *     
     */
    public JAXBElement<ArrayOfGetAllFeatureAccessGrantsWithFilterResultFeatureAccessGrant> getFeatureAccessGrants() {
        return featureAccessGrants;
    }

    /**
     * Sets the value of the featureAccessGrants property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfGetAllFeatureAccessGrantsWithFilterResultFeatureAccessGrant }{@code >}
     *     
     */
    public void setFeatureAccessGrants(JAXBElement<ArrayOfGetAllFeatureAccessGrantsWithFilterResultFeatureAccessGrant> value) {
        this.featureAccessGrants = value;
    }

}
