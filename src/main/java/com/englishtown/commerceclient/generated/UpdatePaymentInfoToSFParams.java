
package com.englishtown.commerceclient.generated;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for UpdatePaymentInfoToSFParams complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UpdatePaymentInfoToSFParams">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SalesOrder_id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="Amount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="CurrencyCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PaymentType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PaymentTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="CCNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CCExpriation" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CCType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DDAccountName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DDAccountNumberMasked" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DDBankName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DDBankTransitNumberMasked" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlType(name = "UpdatePaymentInfoToSFParams", namespace = "EFSchools.Englishtown.Commerce.Client.Accounts", propOrder = {
    "salesOrderId",
    "amount",
    "currencyCode",
    "paymentType",
    "paymentTime",
    "ccNumber",
    "ccExpriation",
    "ccType",
    "ddAccountName",
    "ddAccountNumberMasked",
    "ddBankName",
    "ddBankTransitNumberMasked",
    "isSuccess",
    "failedReason"
})
public class UpdatePaymentInfoToSFParams {

    @XmlElement(name = "SalesOrder_id")
    protected long salesOrderId;
    @XmlElement(name = "Amount", required = true)
    protected BigDecimal amount;
    @XmlElement(name = "CurrencyCode", required = true, nillable = true)
    protected String currencyCode;
    @XmlElement(name = "PaymentType", required = true, nillable = true)
    protected String paymentType;
    @XmlElement(name = "PaymentTime", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar paymentTime;
    @XmlElement(name = "CCNumber", required = true, nillable = true)
    protected String ccNumber;
    @XmlElement(name = "CCExpriation", required = true, nillable = true)
    protected String ccExpriation;
    @XmlElement(name = "CCType", required = true, nillable = true)
    protected String ccType;
    @XmlElement(name = "DDAccountName", required = true, nillable = true)
    protected String ddAccountName;
    @XmlElement(name = "DDAccountNumberMasked", required = true, nillable = true)
    protected String ddAccountNumberMasked;
    @XmlElement(name = "DDBankName", required = true, nillable = true)
    protected String ddBankName;
    @XmlElement(name = "DDBankTransitNumberMasked", required = true, nillable = true)
    protected String ddBankTransitNumberMasked;
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
     * Gets the value of the ccNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCCNumber() {
        return ccNumber;
    }

    /**
     * Sets the value of the ccNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCCNumber(String value) {
        this.ccNumber = value;
    }

    /**
     * Gets the value of the ccExpriation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCCExpriation() {
        return ccExpriation;
    }

    /**
     * Sets the value of the ccExpriation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCCExpriation(String value) {
        this.ccExpriation = value;
    }

    /**
     * Gets the value of the ccType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCCType() {
        return ccType;
    }

    /**
     * Sets the value of the ccType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCCType(String value) {
        this.ccType = value;
    }

    /**
     * Gets the value of the ddAccountName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDDAccountName() {
        return ddAccountName;
    }

    /**
     * Sets the value of the ddAccountName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDDAccountName(String value) {
        this.ddAccountName = value;
    }

    /**
     * Gets the value of the ddAccountNumberMasked property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDDAccountNumberMasked() {
        return ddAccountNumberMasked;
    }

    /**
     * Sets the value of the ddAccountNumberMasked property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDDAccountNumberMasked(String value) {
        this.ddAccountNumberMasked = value;
    }

    /**
     * Gets the value of the ddBankName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDDBankName() {
        return ddBankName;
    }

    /**
     * Sets the value of the ddBankName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDDBankName(String value) {
        this.ddBankName = value;
    }

    /**
     * Gets the value of the ddBankTransitNumberMasked property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDDBankTransitNumberMasked() {
        return ddBankTransitNumberMasked;
    }

    /**
     * Sets the value of the ddBankTransitNumberMasked property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDDBankTransitNumberMasked(String value) {
        this.ddBankTransitNumberMasked = value;
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
