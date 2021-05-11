
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
 *         &lt;element name="GetMemberEnrollmentInfoResult" type="{EFSchools.Englishtown.Commerce.Client.Members}MemberEnrollmentInfo" minOccurs="0"/>
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
    "getMemberEnrollmentInfoResult"
})
@XmlRootElement(name = "GetMemberEnrollmentInfoResponse")
public class GetMemberEnrollmentInfoResponse {

    @XmlElementRef(name = "GetMemberEnrollmentInfoResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<MemberEnrollmentInfo> getMemberEnrollmentInfoResult;

    /**
     * Gets the value of the getMemberEnrollmentInfoResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link MemberEnrollmentInfo }{@code >}
     *     
     */
    public JAXBElement<MemberEnrollmentInfo> getGetMemberEnrollmentInfoResult() {
        return getMemberEnrollmentInfoResult;
    }

    /**
     * Sets the value of the getMemberEnrollmentInfoResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link MemberEnrollmentInfo }{@code >}
     *     
     */
    public void setGetMemberEnrollmentInfoResult(JAXBElement<MemberEnrollmentInfo> value) {
        this.getMemberEnrollmentInfoResult = value;
    }

}
