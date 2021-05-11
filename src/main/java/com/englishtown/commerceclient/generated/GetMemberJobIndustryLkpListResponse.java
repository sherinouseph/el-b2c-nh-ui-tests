
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
 *         &lt;element name="GetMemberJobIndustryLkpListResult" type="{EFSchools.Englishtown.Commerce.Client.Members}ArrayOfMemberJobIndustryLkp" minOccurs="0"/>
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
    "getMemberJobIndustryLkpListResult"
})
@XmlRootElement(name = "GetMemberJobIndustryLkpListResponse")
public class GetMemberJobIndustryLkpListResponse {

    @XmlElementRef(name = "GetMemberJobIndustryLkpListResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfMemberJobIndustryLkp> getMemberJobIndustryLkpListResult;

    /**
     * Gets the value of the getMemberJobIndustryLkpListResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfMemberJobIndustryLkp }{@code >}
     *     
     */
    public JAXBElement<ArrayOfMemberJobIndustryLkp> getGetMemberJobIndustryLkpListResult() {
        return getMemberJobIndustryLkpListResult;
    }

    /**
     * Sets the value of the getMemberJobIndustryLkpListResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfMemberJobIndustryLkp }{@code >}
     *     
     */
    public void setGetMemberJobIndustryLkpListResult(JAXBElement<ArrayOfMemberJobIndustryLkp> value) {
        this.getMemberJobIndustryLkpListResult = value;
    }

}
