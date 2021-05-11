
package com.englishtown.commerceclient.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CreateHeadsetOrderParams complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CreateHeadsetOrderParams">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MemberInfo" type="{EFSchools.Englishtown.Commerce.Client.Members}MemberInfo"/>
 *         &lt;element name="GiftType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreateHeadsetOrderParams", namespace = "EFSchools.Englishtown.Commerce.Client.Headset", propOrder = {
    "memberInfo",
    "giftType"
})
public class CreateHeadsetOrderParams {

    @XmlElement(name = "MemberInfo", required = true, nillable = true)
    protected MemberInfo memberInfo;
    @XmlElementRef(name = "GiftType", namespace = "EFSchools.Englishtown.Commerce.Client.Headset", type = JAXBElement.class, required = false)
    protected JAXBElement<String> giftType;

    /**
     * Gets the value of the memberInfo property.
     * 
     * @return
     *     possible object is
     *     {@link MemberInfo }
     *     
     */
    public MemberInfo getMemberInfo() {
        return memberInfo;
    }

    /**
     * Sets the value of the memberInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link MemberInfo }
     *     
     */
    public void setMemberInfo(MemberInfo value) {
        this.memberInfo = value;
    }

    /**
     * Gets the value of the giftType property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getGiftType() {
        return giftType;
    }

    /**
     * Sets the value of the giftType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setGiftType(JAXBElement<String> value) {
        this.giftType = value;
    }

}
