
package com.englishtown.commerceclient.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element name="member_id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="extraInfoType_id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="extraInfoValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "memberId",
    "extraInfoTypeId",
    "extraInfoValue"
})
@XmlRootElement(name = "UpdateMemberExtraInfo")
public class UpdateMemberExtraInfo {

    @XmlElement(name = "member_id")
    protected Integer memberId;
    @XmlElement(name = "extraInfoType_id")
    protected Integer extraInfoTypeId;
    @XmlElementRef(name = "extraInfoValue", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> extraInfoValue;

    /**
     * Gets the value of the memberId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMemberId() {
        return memberId;
    }

    /**
     * Sets the value of the memberId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMemberId(Integer value) {
        this.memberId = value;
    }

    /**
     * Gets the value of the extraInfoTypeId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getExtraInfoTypeId() {
        return extraInfoTypeId;
    }

    /**
     * Sets the value of the extraInfoTypeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setExtraInfoTypeId(Integer value) {
        this.extraInfoTypeId = value;
    }

    /**
     * Gets the value of the extraInfoValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getExtraInfoValue() {
        return extraInfoValue;
    }

    /**
     * Sets the value of the extraInfoValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setExtraInfoValue(JAXBElement<String> value) {
        this.extraInfoValue = value;
    }

}
