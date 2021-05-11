
package com.englishtown.commerceclient.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UpdateFeatureAccessGrantBatchResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UpdateFeatureAccessGrantBatchResult">
 *   &lt;complexContent>
 *     &lt;extension base="{EFSchools.Englishtown.Commerce.Client}CommerceServiceResultBase">
 *       &lt;sequence>
 *         &lt;element name="FailedFeatureAccessGrantIds" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfint" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UpdateFeatureAccessGrantBatchResult", namespace = "EFSchools.Englishtown.Commerce.Client.Accounts", propOrder = {
    "failedFeatureAccessGrantIds"
})
public class UpdateFeatureAccessGrantBatchResult
    extends CommerceServiceResultBase
{

    @XmlElementRef(name = "FailedFeatureAccessGrantIds", namespace = "EFSchools.Englishtown.Commerce.Client.Accounts", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfint> failedFeatureAccessGrantIds;

    /**
     * Gets the value of the failedFeatureAccessGrantIds property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfint }{@code >}
     *     
     */
    public JAXBElement<ArrayOfint> getFailedFeatureAccessGrantIds() {
        return failedFeatureAccessGrantIds;
    }

    /**
     * Sets the value of the failedFeatureAccessGrantIds property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfint }{@code >}
     *     
     */
    public void setFailedFeatureAccessGrantIds(JAXBElement<ArrayOfint> value) {
        this.failedFeatureAccessGrantIds = value;
    }

}
