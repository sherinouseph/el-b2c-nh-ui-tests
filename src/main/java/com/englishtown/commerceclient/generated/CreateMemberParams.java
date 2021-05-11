
package com.englishtown.commerceclient.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CreateMemberParams complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CreateMemberParams">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Member" type="{EFSchools.Englishtown.Commerce.Client.Members}MemberInfo"/>
 *         &lt;element name="CorporateMember" type="{EFSchools.Englishtown.Commerce.Client.Members}CorporateMember" minOccurs="0"/>
 *         &lt;element name="IsNeedEmailValidation" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="IsCorporateMember" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="IsOverwriteExistingMember" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="MemberOverwriteOptions" type="{EFSchools.Englishtown.Commerce.Client.Members}MemberOverwriteOptions" minOccurs="0"/>
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
@XmlType(name = "CreateMemberParams", namespace = "EFSchools.Englishtown.Commerce.Client.Members", propOrder = {
    "member",
    "corporateMember",
    "isNeedEmailValidation",
    "isCorporateMember",
    "isOverwriteExistingMember",
    "memberOverwriteOptions",
    "memberExtraInfoList"
})
public class CreateMemberParams {

    @XmlElement(name = "Member", required = true, nillable = true)
    protected MemberInfo member;
    @XmlElementRef(name = "CorporateMember", namespace = "EFSchools.Englishtown.Commerce.Client.Members", type = JAXBElement.class, required = false)
    protected JAXBElement<CorporateMember> corporateMember;
    @XmlElement(name = "IsNeedEmailValidation")
    protected Boolean isNeedEmailValidation;
    @XmlElement(name = "IsCorporateMember")
    protected Boolean isCorporateMember;
    @XmlElement(name = "IsOverwriteExistingMember")
    protected Boolean isOverwriteExistingMember;
    @XmlElementRef(name = "MemberOverwriteOptions", namespace = "EFSchools.Englishtown.Commerce.Client.Members", type = JAXBElement.class, required = false)
    protected JAXBElement<MemberOverwriteOptions> memberOverwriteOptions;
    @XmlElementRef(name = "MemberExtraInfoList", namespace = "EFSchools.Englishtown.Commerce.Client.Members", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfMemberExtraInfo> memberExtraInfoList;

    /**
     * Gets the value of the member property.
     * 
     * @return
     *     possible object is
     *     {@link MemberInfo }
     *     
     */
    public MemberInfo getMember() {
        return member;
    }

    /**
     * Sets the value of the member property.
     * 
     * @param value
     *     allowed object is
     *     {@link MemberInfo }
     *     
     */
    public void setMember(MemberInfo value) {
        this.member = value;
    }

    /**
     * Gets the value of the corporateMember property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link CorporateMember }{@code >}
     *     
     */
    public JAXBElement<CorporateMember> getCorporateMember() {
        return corporateMember;
    }

    /**
     * Sets the value of the corporateMember property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link CorporateMember }{@code >}
     *     
     */
    public void setCorporateMember(JAXBElement<CorporateMember> value) {
        this.corporateMember = value;
    }

    /**
     * Gets the value of the isNeedEmailValidation property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsNeedEmailValidation() {
        return isNeedEmailValidation;
    }

    /**
     * Sets the value of the isNeedEmailValidation property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsNeedEmailValidation(Boolean value) {
        this.isNeedEmailValidation = value;
    }

    /**
     * Gets the value of the isCorporateMember property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsCorporateMember() {
        return isCorporateMember;
    }

    /**
     * Sets the value of the isCorporateMember property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsCorporateMember(Boolean value) {
        this.isCorporateMember = value;
    }

    /**
     * Gets the value of the isOverwriteExistingMember property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsOverwriteExistingMember() {
        return isOverwriteExistingMember;
    }

    /**
     * Sets the value of the isOverwriteExistingMember property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsOverwriteExistingMember(Boolean value) {
        this.isOverwriteExistingMember = value;
    }

    /**
     * Gets the value of the memberOverwriteOptions property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link MemberOverwriteOptions }{@code >}
     *     
     */
    public JAXBElement<MemberOverwriteOptions> getMemberOverwriteOptions() {
        return memberOverwriteOptions;
    }

    /**
     * Sets the value of the memberOverwriteOptions property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link MemberOverwriteOptions }{@code >}
     *     
     */
    public void setMemberOverwriteOptions(JAXBElement<MemberOverwriteOptions> value) {
        this.memberOverwriteOptions = value;
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
