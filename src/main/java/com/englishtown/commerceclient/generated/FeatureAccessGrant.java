
package com.englishtown.commerceclient.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <summary>
 * 
 *                         </summary>
 * 
 * <p>Java class for FeatureAccessGrant complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FeatureAccessGrant">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Member_id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="SalesOrder_id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="FeatureAccess_id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Quantity" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ActiveFrom" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="ActiveTo" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="DurationDays" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="BufferLength" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="RemainLength" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Feature_id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FeatureAccessGrant", namespace = "EFSchools.Englishtown.Commerce.Client.FeatureAccess", propOrder = {
    "memberId",
    "salesOrderId",
    "featureAccessId",
    "quantity",
    "activeFrom",
    "activeTo",
    "durationDays",
    "bufferLength",
    "remainLength",
    "featureId"
})
public class FeatureAccessGrant {

    @XmlElement(name = "Member_id")
    protected int memberId;
    @XmlElement(name = "SalesOrder_id")
    protected int salesOrderId;
    @XmlElement(name = "FeatureAccess_id")
    protected int featureAccessId;
    @XmlElement(name = "Quantity")
    protected int quantity;
    @XmlElement(name = "ActiveFrom", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar activeFrom;
    @XmlElement(name = "ActiveTo")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar activeTo;
    @XmlElement(name = "DurationDays")
    protected int durationDays;
    @XmlElement(name = "BufferLength")
    protected Integer bufferLength;
    @XmlElement(name = "RemainLength")
    protected Integer remainLength;
    @XmlElement(name = "Feature_id")
    protected Integer featureId;

    /**
     * Gets the value of the memberId property.
     * 
     */
    public int getMemberId() {
        return memberId;
    }

    /**
     * Sets the value of the memberId property.
     * 
     */
    public void setMemberId(int value) {
        this.memberId = value;
    }

    /**
     * Gets the value of the salesOrderId property.
     * 
     */
    public int getSalesOrderId() {
        return salesOrderId;
    }

    /**
     * Sets the value of the salesOrderId property.
     * 
     */
    public void setSalesOrderId(int value) {
        this.salesOrderId = value;
    }

    /**
     * Gets the value of the featureAccessId property.
     * 
     */
    public int getFeatureAccessId() {
        return featureAccessId;
    }

    /**
     * Sets the value of the featureAccessId property.
     * 
     */
    public void setFeatureAccessId(int value) {
        this.featureAccessId = value;
    }

    /**
     * Gets the value of the quantity property.
     * 
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the value of the quantity property.
     * 
     */
    public void setQuantity(int value) {
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
     * Gets the value of the durationDays property.
     * 
     */
    public int getDurationDays() {
        return durationDays;
    }

    /**
     * Sets the value of the durationDays property.
     * 
     */
    public void setDurationDays(int value) {
        this.durationDays = value;
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

}
