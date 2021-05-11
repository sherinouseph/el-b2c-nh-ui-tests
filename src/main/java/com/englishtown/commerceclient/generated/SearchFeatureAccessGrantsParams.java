
package com.englishtown.commerceclient.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for SearchFeatureAccessGrantsParams complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SearchFeatureAccessGrantsParams">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FeatureAccessIds" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfint" minOccurs="0"/>
 *         &lt;element name="PartnerCodes" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfstring" minOccurs="0"/>
 *         &lt;element name="ExpireAfter" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="ExpireBefore" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="StartGrantId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="MaxRecordCount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SearchFeatureAccessGrantsParams", namespace = "EFSchools.Englishtown.Commerce.Client.Accounts", propOrder = {
    "featureAccessIds",
    "partnerCodes",
    "expireAfter",
    "expireBefore",
    "startGrantId",
    "maxRecordCount"
})
public class SearchFeatureAccessGrantsParams {

    @XmlElementRef(name = "FeatureAccessIds", namespace = "EFSchools.Englishtown.Commerce.Client.Accounts", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfint> featureAccessIds;
    @XmlElementRef(name = "PartnerCodes", namespace = "EFSchools.Englishtown.Commerce.Client.Accounts", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfstring> partnerCodes;
    @XmlElementRef(name = "ExpireAfter", namespace = "EFSchools.Englishtown.Commerce.Client.Accounts", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> expireAfter;
    @XmlElementRef(name = "ExpireBefore", namespace = "EFSchools.Englishtown.Commerce.Client.Accounts", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> expireBefore;
    @XmlElement(name = "StartGrantId")
    protected Integer startGrantId;
    @XmlElement(name = "MaxRecordCount")
    protected Integer maxRecordCount;

    /**
     * Gets the value of the featureAccessIds property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfint }{@code >}
     *     
     */
    public JAXBElement<ArrayOfint> getFeatureAccessIds() {
        return featureAccessIds;
    }

    /**
     * Sets the value of the featureAccessIds property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfint }{@code >}
     *     
     */
    public void setFeatureAccessIds(JAXBElement<ArrayOfint> value) {
        this.featureAccessIds = value;
    }

    /**
     * Gets the value of the partnerCodes property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public JAXBElement<ArrayOfstring> getPartnerCodes() {
        return partnerCodes;
    }

    /**
     * Sets the value of the partnerCodes property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public void setPartnerCodes(JAXBElement<ArrayOfstring> value) {
        this.partnerCodes = value;
    }

    /**
     * Gets the value of the expireAfter property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getExpireAfter() {
        return expireAfter;
    }

    /**
     * Sets the value of the expireAfter property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setExpireAfter(JAXBElement<XMLGregorianCalendar> value) {
        this.expireAfter = value;
    }

    /**
     * Gets the value of the expireBefore property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getExpireBefore() {
        return expireBefore;
    }

    /**
     * Sets the value of the expireBefore property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setExpireBefore(JAXBElement<XMLGregorianCalendar> value) {
        this.expireBefore = value;
    }

    /**
     * Gets the value of the startGrantId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getStartGrantId() {
        return startGrantId;
    }

    /**
     * Sets the value of the startGrantId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setStartGrantId(Integer value) {
        this.startGrantId = value;
    }

    /**
     * Gets the value of the maxRecordCount property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxRecordCount() {
        return maxRecordCount;
    }

    /**
     * Sets the value of the maxRecordCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxRecordCount(Integer value) {
        this.maxRecordCount = value;
    }

}
