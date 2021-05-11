
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
 *         &lt;element name="GetMemberByEmailOrUserNameResult" type="{EFSchools.Englishtown.Commerce.Client.Members}MemberInfo" minOccurs="0"/>
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
    "getMemberByEmailOrUserNameResult"
})
@XmlRootElement(name = "GetMemberByEmailOrUserNameResponse")
public class GetMemberByEmailOrUserNameResponse {

    @XmlElementRef(name = "GetMemberByEmailOrUserNameResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<MemberInfo> getMemberByEmailOrUserNameResult;

    /**
     * Gets the value of the getMemberByEmailOrUserNameResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link MemberInfo }{@code >}
     *     
     */
    public JAXBElement<MemberInfo> getGetMemberByEmailOrUserNameResult() {
        return getMemberByEmailOrUserNameResult;
    }

    /**
     * Sets the value of the getMemberByEmailOrUserNameResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link MemberInfo }{@code >}
     *     
     */
    public void setGetMemberByEmailOrUserNameResult(JAXBElement<MemberInfo> value) {
        this.getMemberByEmailOrUserNameResult = value;
    }

}
