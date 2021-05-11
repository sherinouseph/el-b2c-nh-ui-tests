
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
 *         &lt;element name="member" type="{EFSchools.Englishtown.Commerce.Client.Members}MemberInfo" minOccurs="0"/>
 *         &lt;element name="sourceModuleCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "member",
    "sourceModuleCode"
})
@XmlRootElement(name = "CreateAccount")
public class CreateAccount {

    @XmlElementRef(name = "member", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<MemberInfo> member;
    @XmlElementRef(name = "sourceModuleCode", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> sourceModuleCode;

    /**
     * Gets the value of the member property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link MemberInfo }{@code >}
     *     
     */
    public JAXBElement<MemberInfo> getMember() {
        return member;
    }

    /**
     * Sets the value of the member property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link MemberInfo }{@code >}
     *     
     */
    public void setMember(JAXBElement<MemberInfo> value) {
        this.member = value;
    }

    /**
     * Gets the value of the sourceModuleCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSourceModuleCode() {
        return sourceModuleCode;
    }

    /**
     * Sets the value of the sourceModuleCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSourceModuleCode(JAXBElement<String> value) {
        this.sourceModuleCode = value;
    }

}
