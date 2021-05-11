
package com.englishtown.commerceclient.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CreateAccountParams complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CreateAccountParams">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Member" type="{EFSchools.Englishtown.Commerce.Client.Members}MemberInfo"/>
 *         &lt;element name="RedemptionCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CreationReason" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OppotunityNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreateAccountParams", namespace = "EFSchools.Englishtown.Commerce.Client.Accounts", propOrder = {
    "member",
    "redemptionCode",
    "creationReason",
    "oppotunityNumber"
})
public class CreateAccountParams {

    @XmlElement(name = "Member", required = true, nillable = true)
    protected MemberInfo member;
    @XmlElement(name = "RedemptionCode", required = true, nillable = true)
    protected String redemptionCode;
    @XmlElementRef(name = "CreationReason", namespace = "EFSchools.Englishtown.Commerce.Client.Accounts", type = JAXBElement.class, required = false)
    protected JAXBElement<String> creationReason;
    @XmlElementRef(name = "OppotunityNumber", namespace = "EFSchools.Englishtown.Commerce.Client.Accounts", type = JAXBElement.class, required = false)
    protected JAXBElement<String> oppotunityNumber;

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
     * Gets the value of the redemptionCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRedemptionCode() {
        return redemptionCode;
    }

    /**
     * Sets the value of the redemptionCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRedemptionCode(String value) {
        this.redemptionCode = value;
    }

    /**
     * Gets the value of the creationReason property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCreationReason() {
        return creationReason;
    }

    /**
     * Sets the value of the creationReason property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCreationReason(JAXBElement<String> value) {
        this.creationReason = value;
    }

    /**
     * Gets the value of the oppotunityNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOppotunityNumber() {
        return oppotunityNumber;
    }

    /**
     * Sets the value of the oppotunityNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOppotunityNumber(JAXBElement<String> value) {
        this.oppotunityNumber = value;
    }

}
