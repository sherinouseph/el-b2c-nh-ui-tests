
package com.englishtown.commerceclient.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <summary>
 * 
 *                         </summary>
 * 
 * <p>Java class for AccountInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AccountInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SubscriptionInfo" type="{EFSchools.Englishtown.Commerce.Client.Subscriptions}SubscriptionInfo"/>
 *         &lt;element name="SalesOrderList" type="{EFSchools.Englishtown.Commerce.Client.Orders}ArrayOfSalesOrderItemInfo"/>
 *         &lt;element name="Member_ID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="AccountStatus" type="{EFSchools.Englishtown.Commerce.Client.Accounts}AccountStatus"/>
 *         &lt;element name="RecurringUpsellStatus" type="{EFSchools.Englishtown.Commerce.Client.Orders}RecurringUpsellStatus"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AccountInfo", namespace = "EFSchools.Englishtown.Commerce.Client.Accounts", propOrder = {
    "subscriptionInfo",
    "salesOrderList",
    "memberID",
    "accountStatus",
    "recurringUpsellStatus"
})
public class AccountInfo {

    @XmlElement(name = "SubscriptionInfo", required = true, nillable = true)
    protected SubscriptionInfo subscriptionInfo;
    @XmlElement(name = "SalesOrderList", required = true, nillable = true)
    protected ArrayOfSalesOrderItemInfo salesOrderList;
    @XmlElement(name = "Member_ID")
    protected int memberID;
    @XmlElement(name = "AccountStatus", required = true)
    protected AccountStatus accountStatus;
    @XmlElement(name = "RecurringUpsellStatus", required = true)
    protected RecurringUpsellStatus recurringUpsellStatus;

    /**
     * Gets the value of the subscriptionInfo property.
     * 
     * @return
     *     possible object is
     *     {@link SubscriptionInfo }
     *     
     */
    public SubscriptionInfo getSubscriptionInfo() {
        return subscriptionInfo;
    }

    /**
     * Sets the value of the subscriptionInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link SubscriptionInfo }
     *     
     */
    public void setSubscriptionInfo(SubscriptionInfo value) {
        this.subscriptionInfo = value;
    }

    /**
     * Gets the value of the salesOrderList property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfSalesOrderItemInfo }
     *     
     */
    public ArrayOfSalesOrderItemInfo getSalesOrderList() {
        return salesOrderList;
    }

    /**
     * Sets the value of the salesOrderList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfSalesOrderItemInfo }
     *     
     */
    public void setSalesOrderList(ArrayOfSalesOrderItemInfo value) {
        this.salesOrderList = value;
    }

    /**
     * Gets the value of the memberID property.
     * 
     */
    public int getMemberID() {
        return memberID;
    }

    /**
     * Sets the value of the memberID property.
     * 
     */
    public void setMemberID(int value) {
        this.memberID = value;
    }

    /**
     * Gets the value of the accountStatus property.
     * 
     * @return
     *     possible object is
     *     {@link AccountStatus }
     *     
     */
    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    /**
     * Sets the value of the accountStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccountStatus }
     *     
     */
    public void setAccountStatus(AccountStatus value) {
        this.accountStatus = value;
    }

    /**
     * Gets the value of the recurringUpsellStatus property.
     * 
     * @return
     *     possible object is
     *     {@link RecurringUpsellStatus }
     *     
     */
    public RecurringUpsellStatus getRecurringUpsellStatus() {
        return recurringUpsellStatus;
    }

    /**
     * Sets the value of the recurringUpsellStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link RecurringUpsellStatus }
     *     
     */
    public void setRecurringUpsellStatus(RecurringUpsellStatus value) {
        this.recurringUpsellStatus = value;
    }

}
