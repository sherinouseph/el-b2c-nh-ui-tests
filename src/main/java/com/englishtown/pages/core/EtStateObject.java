package com.englishtown.pages.core;

import java.util.List;

/**
 * Create state object instance values used to test on defferent steps
 * Date: 26/09/14
 * Time: 13:43
 *
 */
public class EtStateObject {
     // checkout payment
    protected String id;
    protected String paymentOfferId;
    protected String firstName;
    protected String lastName;
    protected String username;
    protected String currency;
    protected String price;
    protected String memberId;
    protected String memberType;
    protected List payTrackingEvents ;
    //thankyou
    protected String orderId ;
    protected String orderAmount;
    protected String itemId;
    protected String itemType;
    protected List thankyouPayTrackingEvents ;
    // Logged in    //     memberId;username; same as the above

    public EtStateObject(String id) {
        this.id=id;
    }

    public EtStateObject(String id, String paymentOfferId, String firstName, String lastName, String username, String currency,
                         String price, String memberId, String memberType, List payTrackingEvents, String orderId,
                         String orderAmount, String itemId, String itemType, List thankyouPayTrackingEvents) {
        this.id=id;
        this.paymentOfferId = paymentOfferId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.currency = currency;
        this.price = price;
        this.memberId = memberId;
        this.memberType = memberType;
        this.payTrackingEvents = payTrackingEvents;
        this.orderId = orderId;
        this.orderAmount = orderAmount;
        this.itemId = itemId;
        this.itemType = itemType;
        this.thankyouPayTrackingEvents = thankyouPayTrackingEvents;
    }


    //------------------------------------------------------------------------------------------------------------------
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getPaymentOfferId() {
        return paymentOfferId;
    }

    public void setPaymentOfferId(String paymentOfferId) {
        this.paymentOfferId = paymentOfferId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List getThankyouPayTrackingEvents() {
        return thankyouPayTrackingEvents;
    }

    public void setThankyouPayTrackingEvents(List thankyouPayTrackingEvents) {
        this.thankyouPayTrackingEvents = thankyouPayTrackingEvents;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    public List getPayTrackingEvents() {
        return payTrackingEvents;
    }

    public void setPayTrackingEvents(List payTrackingEvents) {
        this.payTrackingEvents = payTrackingEvents;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(String orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }



}
