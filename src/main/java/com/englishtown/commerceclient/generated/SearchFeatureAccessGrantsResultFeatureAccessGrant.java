
package com.englishtown.commerceclient.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for SearchFeatureAccessGrantsResult_FeatureAccessGrant complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SearchFeatureAccessGrantsResult_FeatureAccessGrant">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GrantId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="FeatureAccessId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="FeatureId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="MemberId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="OrderId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Quantity" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="ActiveFrom" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="ActiveTo" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="BufferLength" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="RemainLength" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="SalesOrderItem_id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SearchFeatureAccessGrantsResult_FeatureAccessGrant", namespace = "EFSchools.Englishtown.Commerce.Client.Accounts", propOrder = {
    "grantId",
    "featureAccessId",
    "featureId",
    "memberId",
    "orderId",
    "quantity",
    "activeFrom",
    "activeTo",
    "bufferLength",
    "remainLength",
    "salesOrderItemId"
})
public class SearchFeatureAccessGrantsResultFeatureAccessGrant {

    @XmlElement(name = "GrantId")
    protected Integer grantId;
    @XmlElement(name = "FeatureAccessId")
    protected Integer featureAccessId;
    @XmlElement(name = "FeatureId")
    protected Integer featureId;
    @XmlElement(name = "MemberId")
    protected Integer memberId;
    @XmlElement(name = "OrderId")
    protected Integer orderId;
    @XmlElement(name = "Quantity")
    protected Integer quantity;
    @XmlElement(name = "ActiveFrom")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar activeFrom;
    @XmlElement(name = "ActiveTo")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar activeTo;
    @XmlElement(name = "BufferLength")
    protected Integer bufferLength;
    @XmlElement(name = "RemainLength")
    protected Integer remainLength;
    @XmlElement(name = "SalesOrderItem_id")
    protected Integer salesOrderItemId;

    /**
     * Gets the value of the grantId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getGrantId() {
        return grantId;
    }

    /**
     * Sets the value of the grantId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setGrantId(Integer value) {
        this.grantId = value;
    }

    /**
     * Gets the value of the featureAccessId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFeatureAccessId() {
        return featureAccessId;
    }

    /**
     * Sets the value of the featureAccessId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFeatureAccessId(Integer value) {
        this.featureAccessId = value;
    }

    /**
     * Gets the value of the featureId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFeatureId() {
        return featureId;
    }

    /**
     * Sets the value of the featureId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFeatureId(Integer value) {
        this.featureId = value;
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
     * Gets the value of the orderId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getOrderId() {
        return orderId;
    }

    /**
     * Sets the value of the orderId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setOrderId(Integer value) {
        this.orderId = value;
    }

    /**
     * Gets the value of the quantity property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * Sets the value of the quantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setQuantity(Integer value) {
        this.quantity = value;
    }

    /**
     * Gets the value of the activeFrom property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getActiveFrom() {
        return activeFrom;
    }

    /**
     * Sets the value of the activeFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setActiveFrom(XMLGregorianCalendar value) {
        this.activeFrom = value;
    }

    /**
     * Gets the value of the activeTo property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getActiveTo() {
        return activeTo;
    }

    /**
     * Sets the value of the activeTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setActiveTo(XMLGregorianCalendar value) {
        this.activeTo = value;
    }

    /**
     * Gets the value of the bufferLength property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBufferLength() {
        return bufferLength;
    }

    /**
     * Sets the value of the bufferLength property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBufferLength(Integer value) {
        this.bufferLength = value;
    }

    /**
     * Gets the value of the remainLength property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRemainLength() {
        return remainLength;
    }

    /**
     * Sets the value of the remainLength property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRemainLength(Integer value) {
        this.remainLength = value;
    }

    /**
     * Gets the value of the salesOrderItemId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSalesOrderItemId() {
        return salesOrderItemId;
    }

    /**
     * Sets the value of the salesOrderItemId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSalesOrderItemId(Integer value) {
        this.salesOrderItemId = value;
    }

}
