
package com.englishtown.commerceclient.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MemberExtraInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MemberExtraInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ExtraInfo_id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="ExtraInfoValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MemberExtraInfo", namespace = "EFSchools.Englishtown.Commerce.Client.Members", propOrder = {
    "extraInfoId",
    "extraInfoValue"
})
public class MemberExtraInfo {

    @XmlElement(name = "ExtraInfo_id")
    protected Integer extraInfoId;
    @XmlElementRef(name = "ExtraInfoValue", namespace = "EFSchools.Englishtown.Commerce.Client.Members", type = JAXBElement.class, required = false)
    protected JAXBElement<String> extraInfoValue;

    /**
     * Gets the value of the extraInfoId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getExtraInfoId() {
        return extraInfoId;
    }

    /**
     * Sets the value of the extraInfoId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setExtraInfoId(Integer value) {
        this.extraInfoId = value;
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
