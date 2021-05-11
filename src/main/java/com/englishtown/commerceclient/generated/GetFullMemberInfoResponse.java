
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
 *         &lt;element name="GetFullMemberInfoResult" type="{EFSchools.Englishtown.Commerce.Client.Members}MemberInfo" minOccurs="0"/>
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
    "getFullMemberInfoResult"
})
@XmlRootElement(name = "GetFullMemberInfoResponse")
public class GetFullMemberInfoResponse {

    @XmlElementRef(name = "GetFullMemberInfoResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<MemberInfo> getFullMemberInfoResult;

    /**
     * Gets the value of the getFullMemberInfoResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link MemberInfo }{@code >}
     *     
     */
    public JAXBElement<MemberInfo> getGetFullMemberInfoResult() {
        return getFullMemberInfoResult;
    }

    /**
     * Sets the value of the getFullMemberInfoResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link MemberInfo }{@code >}
     *     
     */
    public void setGetFullMemberInfoResult(JAXBElement<MemberInfo> value) {
        this.getFullMemberInfoResult = value;
    }

}
