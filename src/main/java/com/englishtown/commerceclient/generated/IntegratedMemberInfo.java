
package com.englishtown.commerceclient.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IntegratedMemberInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IntegratedMemberInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BasicMemberInfo" type="{EFSchools.Englishtown.Commerce.Client.Members}MemberInfo" minOccurs="0"/>
 *         &lt;element name="CorporateMemberInfo" type="{EFSchools.Englishtown.Commerce.Client.Members}CorporateMember" minOccurs="0"/>
 *         &lt;element name="MemberExtraInfoList" type="{EFSchools.Englishtown.Commerce.Client.Members}ArrayOfMemberExtraInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IntegratedMemberInfo", namespace = "EFSchools.Englishtown.Commerce.Client.Members", propOrder = {
    "basicMemberInfo",
    "corporateMemberInfo",
    "memberExtraInfoList"
})
public class IntegratedMemberInfo {

    @XmlElementRef(name = "BasicMemberInfo", namespace = "EFSchools.Englishtown.Commerce.Client.Members", type = JAXBElement.class, required = false)
    protected JAXBElement<MemberInfo> basicMemberInfo;
    @XmlElementRef(name = "CorporateMemberInfo", namespace = "EFSchools.Englishtown.Commerce.Client.Members", type = JAXBElement.class, required = false)
    protected JAXBElement<CorporateMember> corporateMemberInfo;
    @XmlElementRef(name = "MemberExtraInfoList", namespace = "EFSchools.Englishtown.Commerce.Client.Members", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfMemberExtraInfo> memberExtraInfoList;

    /**
     * Gets the value of the basicMemberInfo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link MemberInfo }{@code >}
     *     
     */
    public JAXBElement<MemberInfo> getBasicMemberInfo() {
        return basicMemberInfo;
    }

    /**
     * Sets the value of the basicMemberInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link MemberInfo }{@code >}
     *     
     */
    public void setBasicMemberInfo(JAXBElement<MemberInfo> value) {
        this.basicMemberInfo = value;
    }

    /**
     * Gets the value of the corporateMemberInfo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link CorporateMember }{@code >}
     *     
     */
    public JAXBElement<CorporateMember> getCorporateMemberInfo() {
        return corporateMemberInfo;
    }

    /**
     * Sets the value of the corporateMemberInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link CorporateMember }{@code >}
     *     
     */
    public void setCorporateMemberInfo(JAXBElement<CorporateMember> value) {
        this.corporateMemberInfo = value;
    }

    /**
     * Gets the value of the memberExtraInfoList property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfMemberExtraInfo }{@code >}
     *     
     */
    public JAXBElement<ArrayOfMemberExtraInfo> getMemberExtraInfoList() {
        return memberExtraInfoList;
    }

    /**
     * Sets the value of the memberExtraInfoList property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfMemberExtraInfo }{@code >}
     *     
     */
    public void setMemberExtraInfoList(JAXBElement<ArrayOfMemberExtraInfo> value) {
        this.memberExtraInfoList = value;
    }

}
