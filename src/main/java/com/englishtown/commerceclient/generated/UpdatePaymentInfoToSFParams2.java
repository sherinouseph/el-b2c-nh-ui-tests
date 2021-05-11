
package com.englishtown.commerceclient.generated;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for UpdatePaymentInfoToSFParams2 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UpdatePaymentInfoToSFParams2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SalesOrder_id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="Amount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="CurrencyCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PaymentType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PaymentMethodDetail" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PaymentTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="IsSuccess" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="FailedReason" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UpdatePaymentInfoToSFParams2", namespace = "EFSchools.Englishtown.Commerce.Client.Accounts", propOrder = {
    "salesOrderId",
    "amount",
    "currencyCode",
    "paymentType",
    "paymentMethodDetail",
    "paymentTime",
    "isSuccess",
    "failedReason"
})
public class UpdatePaymentInfoToSFParams2 {

    @XmlElement(name = "SalesOrder_id")
    protected long salesOrderId;
    @XmlElement(name = "Amount", required = true)
    protected BigDecimal amount;
    @XmlElement(name = "CurrencyCode", required = true, nillable = true)
    protected String currencyCode;
    @XmlElement(name = "PaymentType", required = true, nillable = true)
    protected String paymentType;
    @XmlElement(name = "PaymentMethodDetail", required = true, nillable = true)
    protected String paymentMethodDetail;
    @XmlElement(name = "PaymentTime", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar paymentTime;
    @XmlElement(name = "IsSuccess")
    protected boolean isSuccess;
    @XmlElement(name = "FailedReason", required = true, nillable = true)
    protected String failedReason;

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
     * Gets the value of the amount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * Sets the value of the amount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAmount(BigDecimal value) {
        this.amount = value;
    }

    /**
     * Gets the value of the currencyCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrencyCode() {
        return currencyCode;
    }

    /**
     * Sets the value of the currencyCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrencyCode(String value) {
        this.currencyCode = value;
    }

    /**
     * Gets the value of the paymentType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentType() {
        return paymentType;
    }

    /**
     * Sets the value of the paymentType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentType(String value) {
        this.paymentType = value;
    }

    /**
     * Gets the value of the paymentMethodDetail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentMethodDetail() {
        return paymentMethodDetail;
    }

    /**
     * Sets the value of the paymentMethodDetail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentMethodDetail(String value) {
        this.paymentMethodDetail = value;
    }

    /**
     * Gets the value of the paymentTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPaymentTime() {
        return paymentTime;
    }

    /**
     * Sets the value of the paymentTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPaymentTime(XMLGregorianCalendar value) {
        this.paymentTime = value;
    }

    /**
     * Gets the value of the isSuccess property.
     * 
     */
    public boolean isIsSuccess() {
        return isSuccess;
    }

    /**
     * Sets the value of the isSuccess property.
     * 
     */
    public void setIsSuccess(boolean value) {
        this.isSuccess = value;
    }

    /**
     * Gets the value of the failedReason property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFailedReason() {
        return failedReason;
    }

    /**
     * Sets the value of the failedReason property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFailedReason(String value) {
        this.failedReason = value;
    }

}
