
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
 *         &lt;element name="memberEmailInfo" type="{EFSchools.Englishtown.Commerce.Client.Members}MemberEmailInfo" minOccurs="0"/>
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
    "memberEmailInfo"
})
@XmlRootElement(name = "SaveMemberEmailInfo")
public class SaveMemberEmailInfo {

    @XmlElementRef(name = "memberEmailInfo", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<MemberEmailInfo> memberEmailInfo;

    /**
     * Gets the value of the memberEmailInfo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link MemberEmailInfo }{@code >}
     *     
     */
    public JAXBElement<MemberEmailInfo> getMemberEmailInfo() {
        return memberEmailInfo;
    }

    /**
     * Sets the value of the memberEmailInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link MemberEmailInfo }{@code >}
     *     
     */
    public void setMemberEmailInfo(JAXBElement<MemberEmailInfo> value) {
        this.memberEmailInfo = value;
    }

}
