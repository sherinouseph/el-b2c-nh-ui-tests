
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
 *         &lt;element name="GetReferralsByMember_idResult" type="{EFSchools.Englishtown.Commerce.Client.Members}ArrayOfReferralInfo" minOccurs="0"/>
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
    "getReferralsByMemberIdResult"
})
@XmlRootElement(name = "GetReferralsByMember_idResponse")
public class GetReferralsByMemberIdResponse {

    @XmlElementRef(name = "GetReferralsByMember_idResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfReferralInfo> getReferralsByMemberIdResult;

    /**
     * Gets the value of the getReferralsByMemberIdResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfReferralInfo }{@code >}
     *     
     */
    public JAXBElement<ArrayOfReferralInfo> getGetReferralsByMemberIdResult() {
        return getReferralsByMemberIdResult;
    }

    /**
     * Sets the value of the getReferralsByMemberIdResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfReferralInfo }{@code >}
     *     
     */
    public void setGetReferralsByMemberIdResult(JAXBElement<ArrayOfReferralInfo> value) {
        this.getReferralsByMemberIdResult = value;
    }

}
