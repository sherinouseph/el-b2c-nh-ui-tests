
package com.englishtown.commerceclient.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for AddFeatureAccessGrantParams complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AddFeatureAccessGrantParams">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SalesOrder_id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="FeatureAccess_id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Quantity" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ActiveFrom" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="ActiveTo" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="BufferLength" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AddFeatureAccessGrantParams", namespace = "EFSchools.Englishtown.Commerce.Client.Accounts", propOrder = {
    "salesOrderId",
    "featureAccessId",
    "quantity",
    "activeFrom",
    "activeTo",
    "bufferLength"
})
public class AddFeatureAccessGrantParams {

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
    @XmlElement(name = "BufferLength")
    protected Integer bufferLength;

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

}
