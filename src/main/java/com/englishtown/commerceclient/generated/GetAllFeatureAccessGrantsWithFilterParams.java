
package com.englishtown.commerceclient.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetAllFeatureAccessGrantsWithFilterParams complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetAllFeatureAccessGrantsWithFilterParams">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Member_id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="FeatureAccessFilter" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfint" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetAllFeatureAccessGrantsWithFilterParams", namespace = "EFSchools.Englishtown.Commerce.Client.Accounts", propOrder = {
    "memberId",
    "featureAccessFilter"
})
public class GetAllFeatureAccessGrantsWithFilterParams {

    @XmlElement(name = "Member_id")
    protected int memberId;
    @XmlElementRef(name = "FeatureAccessFilter", namespace = "EFSchools.Englishtown.Commerce.Client.Accounts", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfint> featureAccessFilter;

    /**
     * Gets the value of the memberId property.
     * 
     */
    public int getMemberId() {
        return memberId;
    }

    /**
     * Sets the value of the memberId property.
     * 
     */
    public void setMemberId(int value) {
        this.memberId = value;
    }

    /**
     * Gets the value of the featureAccessFilter property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfint }{@code >}
     *     
     */
    public JAXBElement<ArrayOfint> getFeatureAccessFilter() {
        return featureAccessFilter;
    }

    /**
     * Sets the value of the featureAccessFilter property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfint }{@code >}
     *     
     */
    public void setFeatureAccessFilter(JAXBElement<ArrayOfint> value) {
        this.featureAccessFilter = value;
    }

}
