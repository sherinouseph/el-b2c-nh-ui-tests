
package com.englishtown.commerceclient.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for CorporateMember complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CorporateMember">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Corporate_id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="DivisionCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Division_id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="External_id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Member_id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="UpdateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="CorporateCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CorporateName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="InputCorporateCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CorporateMember", namespace = "EFSchools.Englishtown.Commerce.Client.Members", propOrder = {
    "corporateId",
    "divisionCode",
    "divisionId",
    "externalId",
    "memberId",
    "updateTime",
    "corporateCode",
    "corporateName",
    "inputCorporateCode"
})
public class CorporateMember {

    @XmlElement(name = "Corporate_id")
    protected Integer corporateId;
    @XmlElementRef(name = "DivisionCode", namespace = "EFSchools.Englishtown.Commerce.Client.Members", type = JAXBElement.class, required = false)
    protected JAXBElement<String> divisionCode;
    @XmlElement(name = "Division_id")
    protected Integer divisionId;
    @XmlElementRef(name = "External_id", namespace = "EFSchools.Englishtown.Commerce.Client.Members", type = JAXBElement.class, required = false)
    protected JAXBElement<String> externalId;
    @XmlElement(name = "Member_id")
    protected Integer memberId;
    @XmlElementRef(name = "UpdateTime", namespace = "EFSchools.Englishtown.Commerce.Client.Members", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> updateTime;
    @XmlElementRef(name = "CorporateCode", namespace = "EFSchools.Englishtown.Commerce.Client.Members", type = JAXBElement.class, required = false)
    protected JAXBElement<String> corporateCode;
    @XmlElementRef(name = "CorporateName", namespace = "EFSchools.Englishtown.Commerce.Client.Members", type = JAXBElement.class, required = false)
    protected JAXBElement<String> corporateName;
    @XmlElementRef(name = "InputCorporateCode", namespace = "EFSchools.Englishtown.Commerce.Client.Members", type = JAXBElement.class, required = false)
    protected JAXBElement<String> inputCorporateCode;

    /**
     * Gets the value of the corporateId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCorporateId() {
        return corporateId;
    }

    /**
     * Sets the value of the corporateId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCorporateId(Integer value) {
        this.corporateId = value;
    }

    /**
     * Gets the value of the divisionCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDivisionCode() {
        return divisionCode;
    }

    /**
     * Sets the value of the divisionCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDivisionCode(JAXBElement<String> value) {
        this.divisionCode = value;
    }

    /**
     * Gets the value of the divisionId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDivisionId() {
        return divisionId;
    }

    /**
     * Sets the value of the divisionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDivisionId(Integer value) {
        this.divisionId = value;
    }

    /**
     * Gets the value of the externalId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getExternalId() {
        return externalId;
    }

    /**
     * Sets the value of the externalId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setExternalId(JAXBElement<String> value) {
        this.externalId = value;
    }

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
     * Gets the value of the updateTime property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getUpdateTime() {
        return updateTime;
    }

    /**
     * Sets the value of the updateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setUpdateTime(JAXBElement<XMLGregorianCalendar> value) {
        this.updateTime = value;
    }

    /**
     * Gets the value of the corporateCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCorporateCode() {
        return corporateCode;
    }

    /**
     * Sets the value of the corporateCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCorporateCode(JAXBElement<String> value) {
        this.corporateCode = value;
    }

    /**
     * Gets the value of the corporateName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCorporateName() {
        return corporateName;
    }

    /**
     * Sets the value of the corporateName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCorporateName(JAXBElement<String> value) {
        this.corporateName = value;
    }

    /**
     * Gets the value of the inputCorporateCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getInputCorporateCode() {
        return inputCorporateCode;
    }

    /**
     * Sets the value of the inputCorporateCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setInputCorporateCode(JAXBElement<String> value) {
        this.inputCorporateCode = value;
    }

}
