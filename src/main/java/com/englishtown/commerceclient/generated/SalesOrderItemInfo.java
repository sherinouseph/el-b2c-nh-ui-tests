
package com.englishtown.commerceclient.generated;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <summary>
 * 
 *                         </summary>
 * 
 * <p>Java class for SalesOrderItemInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SalesOrderItemInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SalesOrder_id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="Member_id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="DateEntered" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="StatusCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SystemCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="OrderDescriptionBlurbID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Price" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Currency" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NextBillingDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="ExpiryDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="IsRecurring" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="SalesOrderItem_id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="OfferItemType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PaymentType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LastBillingDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="LastBillingPrice" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="NextBillingPrice" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="LastBillingCurrency" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NextBillingCurrency" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SalesOrderItemInfo", namespace = "EFSchools.Englishtown.Commerce.Client.Orders", propOrder = {
    "salesOrderId",
    "memberId",
    "dateEntered",
    "statusCode",
    "systemCode",
    "orderDescriptionBlurbID",
    "price",
    "currency",
    "nextBillingDate",
    "expiryDate",
    "isRecurring",
    "salesOrderItemId",
    "offerItemType",
    "paymentType",
    "lastBillingDate",
    "lastBillingPrice",
    "nextBillingPrice",
    "lastBillingCurrency",
    "nextBillingCurrency"
})
public class SalesOrderItemInfo {

    @XmlElement(name = "SalesOrder_id")
    protected long salesOrderId;
    @XmlElement(name = "Member_id")
    protected int memberId;
    @XmlElement(name = "DateEntered", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateEntered;
    @XmlElement(name = "StatusCode", required = true, nillable = true)
    protected String statusCode;
    @XmlElement(name = "SystemCode", required = true, nillable = true)
    protected String systemCode;
    @XmlElement(name = "OrderDescriptionBlurbID")
    protected int orderDescriptionBlurbID;
    @XmlElement(name = "Price")
    protected BigDecimal price;
    @XmlElementRef(name = "Currency", namespace = "EFSchools.Englishtown.Commerce.Client.Orders", type = JAXBElement.class, required = false)
    protected JAXBElement<String> currency;
    @XmlElement(name = "NextBillingDate", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar nextBillingDate;
    @XmlElement(name = "ExpiryDate", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar expiryDate;
    @XmlElement(name = "IsRecurring")
    protected boolean isRecurring;
    @XmlElementRef(name = "SalesOrderItem_id", namespace = "EFSchools.Englishtown.Commerce.Client.Orders", type = JAXBElement.class, required = false)
    protected JAXBElement<Integer> salesOrderItemId;
    @XmlElementRef(name = "OfferItemType", namespace = "EFSchools.Englishtown.Commerce.Client.Orders", type = JAXBElement.class, required = false)
    protected JAXBElement<String> offerItemType;
    @XmlElementRef(name = "PaymentType", namespace = "EFSchools.Englishtown.Commerce.Client.Orders", type = JAXBElement.class, required = false)
    protected JAXBElement<String> paymentType;
    @XmlElementRef(name = "LastBillingDate", namespace = "EFSchools.Englishtown.Commerce.Client.Orders", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> lastBillingDate;
    @XmlElementRef(name = "LastBillingPrice", namespace = "EFSchools.Englishtown.Commerce.Client.Orders", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> lastBillingPrice;
    @XmlElementRef(name = "NextBillingPrice", namespace = "EFSchools.Englishtown.Commerce.Client.Orders", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> nextBillingPrice;
    @XmlElementRef(name = "LastBillingCurrency", namespace = "EFSchools.Englishtown.Commerce.Client.Orders", type = JAXBElement.class, required = false)
    protected JAXBElement<String> lastBillingCurrency;
    @XmlElementRef(name = "NextBillingCurrency", namespace = "EFSchools.Englishtown.Commerce.Client.Orders", type = JAXBElement.class, required = false)
    protected JAXBElement<String> nextBillingCurrency;

    /**
     * Gets the value of the salesOrderId property.
     * 
     */
    public long getSalesOrderId() {
        return salesOrderId;
    }

    /**
     * Sets the value of the salesOrderId property.
     * 
     */
    public void setSalesOrderId(long value) {
        this.salesOrderId = value;
    }

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
     * Gets the value of the dateEntered property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateEntered() {
        return dateEntered;
    }

    /**
     * Sets the value of the dateEntered property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateEntered(XMLGregorianCalendar value) {
        this.dateEntered = value;
    }

    /**
     * Gets the value of the statusCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusCode() {
        return statusCode;
    }

    /**
     * Sets the value of the statusCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusCode(String value) {
        this.statusCode = value;
    }

    /**
     * Gets the value of the systemCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSystemCode() {
        return systemCode;
    }

    /**
     * Sets the value of the systemCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSystemCode(String value) {
        this.systemCode = value;
    }

    /**
     * Gets the value of the orderDescriptionBlurbID property.
     * 
     */
    public int getOrderDescriptionBlurbID() {
        return orderDescriptionBlurbID;
    }

    /**
     * Sets the value of the orderDescriptionBlurbID property.
     * 
     */
    public void setOrderDescriptionBlurbID(int value) {
        this.orderDescriptionBlurbID = value;
    }

    /**
     * Gets the value of the price property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPrice(BigDecimal value) {
        this.price = value;
    }

    /**
     * Gets the value of the currency property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCurrency() {
        return currency;
    }

    /**
     * Sets the value of the currency property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCurrency(JAXBElement<String> value) {
        this.currency = value;
    }

    /**
     * Gets the value of the nextBillingDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getNextBillingDate() {
        return nextBillingDate;
    }

    /**
     * Sets the value of the nextBillingDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setNextBillingDate(XMLGregorianCalendar value) {
        this.nextBillingDate = value;
    }

    /**
     * Gets the value of the expiryDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getExpiryDate() {
        return expiryDate;
    }

    /**
     * Sets the value of the expiryDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setExpiryDate(XMLGregorianCalendar value) {
        this.expiryDate = value;
    }

    /**
     * Gets the value of the isRecurring property.
     * 
     */
    public boolean isIsRecurring() {
        return isRecurring;
    }

    /**
     * Sets the value of the isRecurring property.
     * 
     */
    public void setIsRecurring(boolean value) {
        this.isRecurring = value;
    }

    /**
     * Gets the value of the salesOrderItemId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getSalesOrderItemId() {
        return salesOrderItemId;
    }

    /**
     * Sets the value of the salesOrderItemId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setSalesOrderItemId(JAXBElement<Integer> value) {
        this.salesOrderItemId = value;
    }

    /**
     * Gets the value of the offerItemType property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOfferItemType() {
        return offerItemType;
    }

    /**
     * Sets the value of the offerItemType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOfferItemType(JAXBElement<String> value) {
        this.offerItemType = value;
    }

    /**
     * Gets the value of the paymentType property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPaymentType() {
        return paymentType;
    }

    /**
     * Sets the value of the paymentType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPaymentType(JAXBElement<String> value) {
        this.paymentType = value;
    }

    /**
     * Gets the value of the lastBillingDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getLastBillingDate() {
        return lastBillingDate;
    }

    /**
     * Sets the value of the lastBillingDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setLastBillingDate(JAXBElement<XMLGregorianCalendar> value) {
        this.lastBillingDate = value;
    }

    /**
     * Gets the value of the lastBillingPrice property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getLastBillingPrice() {
        return lastBillingPrice;
    }

    /**
     * Sets the value of the lastBillingPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setLastBillingPrice(JAXBElement<BigDecimal> value) {
        this.lastBillingPrice = value;
    }

    /**
     * Gets the value of the nextBillingPrice property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getNextBillingPrice() {
        return nextBillingPrice;
    }

    /**
     * Sets the value of the nextBillingPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setNextBillingPrice(JAXBElement<BigDecimal> value) {
        this.nextBillingPrice = value;
    }

    /**
     * Gets the value of the lastBillingCurrency property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLastBillingCurrency() {
        return lastBillingCurrency;
    }

    /**
     * Sets the value of the lastBillingCurrency property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLastBillingCurrency(JAXBElement<String> value) {
        this.lastBillingCurrency = value;
    }

    /**
     * Gets the value of the nextBillingCurrency property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getNextBillingCurrency() {
        return nextBillingCurrency;
    }

    /**
     * Sets the value of the nextBillingCurrency property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setNextBillingCurrency(JAXBElement<String> value) {
        this.nextBillingCurrency = value;
    }

}
