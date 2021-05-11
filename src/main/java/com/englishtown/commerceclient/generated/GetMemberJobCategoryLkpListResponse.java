
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
 *         &lt;element name="GetMemberJobCategoryLkpListResult" type="{EFSchools.Englishtown.Commerce.Client.Members}ArrayOfMemberJobCategoryLkp" minOccurs="0"/>
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
    "getMemberJobCategoryLkpListResult"
})
@XmlRootElement(name = "GetMemberJobCategoryLkpListResponse")
public class GetMemberJobCategoryLkpListResponse {

    @XmlElementRef(name = "GetMemberJobCategoryLkpListResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfMemberJobCategoryLkp> getMemberJobCategoryLkpListResult;

    /**
     * Gets the value of the getMemberJobCategoryLkpListResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfMemberJobCategoryLkp }{@code >}
     *     
     */
    public JAXBElement<ArrayOfMemberJobCategoryLkp> getGetMemberJobCategoryLkpListResult() {
        return getMemberJobCategoryLkpListResult;
    }

    /**
     * Sets the value of the getMemberJobCategoryLkpListResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfMemberJobCategoryLkp }{@code >}
     *     
     */
    public void setGetMemberJobCategoryLkpListResult(JAXBElement<ArrayOfMemberJobCategoryLkp> value) {
        this.getMemberJobCategoryLkpListResult = value;
    }

}
