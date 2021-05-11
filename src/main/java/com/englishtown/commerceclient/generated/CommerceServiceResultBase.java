
package com.englishtown.commerceclient.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CommerceServiceResultBase complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CommerceServiceResultBase">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="IsSucceed" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Error" type="{EFSchools.Englishtown.Commerce.Client}CommerceServiceErrorResult" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CommerceServiceResultBase", namespace = "EFSchools.Englishtown.Commerce.Client", propOrder = {
    "isSucceed",
    "error"
})
@XmlSeeAlso({
    AddFeatureAccessGrantResult.class,
    GetAllFeatureAccessGrantsWithFilterResult.class,
    GetActiveMemberWithFeatureResult.class,
    UpdateFeatureAccessGrantBatchResult.class,
    GetMemberProductLineResult.class,
    AddFeatureAccessQuantityBatchResult.class,
    UpdateFeatureAccessGrantResult.class,
    SearchFeatureAccessGrantsResult.class,
    GetBatchSubscriptionsResult.class
})
public class CommerceServiceResultBase {

    @XmlElement(name = "IsSucceed")
    protected Boolean isSucceed;
    @XmlElementRef(name = "Error", namespace = "EFSchools.Englishtown.Commerce.Client", type = JAXBElement.class, required = false)
    protected JAXBElement<CommerceServiceErrorResult> error;

    /**
     * Gets the value of the isSucceed property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsSucceed() {
        return isSucceed;
    }

    /**
     * Sets the value of the isSucceed property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsSucceed(Boolean value) {
        this.isSucceed = value;
    }

    /**
     * Gets the value of the error property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link CommerceServiceErrorResult }{@code >}
     *     
     */
    public JAXBElement<CommerceServiceErrorResult> getError() {
        return error;
    }

    /**
     * Sets the value of the error property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link CommerceServiceErrorResult }{@code >}
     *     
     */
    public void setError(JAXBElement<CommerceServiceErrorResult> value) {
        this.error = value;
    }

}
