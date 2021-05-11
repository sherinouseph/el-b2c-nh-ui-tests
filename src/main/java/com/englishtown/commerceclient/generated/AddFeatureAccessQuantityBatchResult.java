
package com.englishtown.commerceclient.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AddFeatureAccessQuantityBatchResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AddFeatureAccessQuantityBatchResult">
 *   &lt;complexContent>
 *     &lt;extension base="{EFSchools.Englishtown.Commerce.Client}CommerceServiceResultBase">
 *       &lt;sequence>
 *         &lt;element name="InvalidMemberIds" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfint" minOccurs="0"/>
 *         &lt;element name="FeatureAccessGrants" type="{EFSchools.Englishtown.Commerce.Client.Accounts}ArrayOfAddFeatureAccessQuantityBatchResult_FeatureAccessGrant" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AddFeatureAccessQuantityBatchResult", namespace = "EFSchools.Englishtown.Commerce.Client.Accounts", propOrder = {
    "invalidMemberIds",
    "featureAccessGrants"
})
public class AddFeatureAccessQuantityBatchResult
    extends CommerceServiceResultBase
{

    @XmlElementRef(name = "InvalidMemberIds", namespace = "EFSchools.Englishtown.Commerce.Client.Accounts", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfint> invalidMemberIds;
    @XmlElementRef(name = "FeatureAccessGrants", namespace = "EFSchools.Englishtown.Commerce.Client.Accounts", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfAddFeatureAccessQuantityBatchResultFeatureAccessGrant> featureAccessGrants;

    /**
     * Gets the value of the invalidMemberIds property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfint }{@code >}
     *     
     */
    public JAXBElement<ArrayOfint> getInvalidMemberIds() {
        return invalidMemberIds;
    }

    /**
     * Sets the value of the invalidMemberIds property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfint }{@code >}
     *     
     */
    public void setInvalidMemberIds(JAXBElement<ArrayOfint> value) {
        this.invalidMemberIds = value;
    }

    /**
     * Gets the value of the featureAccessGrants property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfAddFeatureAccessQuantityBatchResultFeatureAccessGrant }{@code >}
     *     
     */
    public JAXBElement<ArrayOfAddFeatureAccessQuantityBatchResultFeatureAccessGrant> getFeatureAccessGrants() {
        return featureAccessGrants;
    }

    /**
     * Sets the value of the featureAccessGrants property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfAddFeatureAccessQuantityBatchResultFeatureAccessGrant }{@code >}
     *     
     */
    public void setFeatureAccessGrants(JAXBElement<ArrayOfAddFeatureAccessQuantityBatchResultFeatureAccessGrant> value) {
        this.featureAccessGrants = value;
    }

}
