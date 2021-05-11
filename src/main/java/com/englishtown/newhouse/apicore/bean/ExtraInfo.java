package com.englishtown.newhouse.apicore.bean;

import org.codehaus.jackson.annotate.JsonProperty;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Set;

public class ExtraInfo {

    private final Logger logger = LoggerFactory.getLogger(ExtraInfo.class);
    // common
    @JsonProperty("country")
    private String country;
    @JsonProperty("ccFirstName")
    private String ccFirstName;
    @JsonProperty("ccLastName")
    private String ccLastName;
    @JsonProperty("ccNumber")
    private String ccNumber;
    @JsonProperty("accountType")
    private String accountType;
    @JsonProperty("ccCardVerifyNum")
    private String ccCardVerifyNum;
    @JsonProperty("ccCardType")
    private String ccCardType ;
    @JsonProperty("ccExpYear")
    private String ccExpYear;
    @JsonProperty("ccExpMonth")
    private String ccExpMonth;

    // paypal
    @JsonProperty("returnUrl")
    private String returnUrl;
    @JsonProperty("cancelUrl")
    private String cancelUrl;
    @JsonProperty("payPalConfirmUrl")
    private String payPalConfirmUrl;

    // payU
    @JsonProperty("customerName")
    private String customerName;
    @JsonProperty("cvc")
    private String cvc;
    // worldpay
    @JsonProperty("description")
    private String description;

    ExtraInfo(){
        //
    }

    public void setExtraInfoFromMap(HashMap<String, String> extraInfoMap){
        try {
            this.country = extraInfoMap.get("country");
            this.ccFirstName = extraInfoMap.get("ccFirstName");
            this.ccLastName = extraInfoMap.get("ccLastName");
            this.ccNumber = extraInfoMap.get("ccNumber");
            this.ccCardVerifyNum = extraInfoMap.get("ccCardVerifyNum");
            this.ccCardType = extraInfoMap.get("ccCardType");
            this.ccExpYear = extraInfoMap.get("ccExpYear");
            this.ccExpMonth = extraInfoMap.get("ccExpMonth");
            this.description = extraInfoMap.get("description");
            this.customerName = extraInfoMap.get("customerName");
            this.cvc = extraInfoMap.get("cvc");
        }catch (Exception e){
            logger.info("Could not set extra info :"+e.getMessage());
        }
    }

    public void setExtraInfoFromJsonObj(JSONObject extraInfoJsonObj){
        Set<String> keys = extraInfoJsonObj.keySet();

        for(int i = 0; i < extraInfoJsonObj.size(); i++){
            try{

            }catch (Exception e){
                logger.info("Could not set extra info :"+e.getMessage());
            }
        }
        try {
            this.country = (String) extraInfoJsonObj.get("country");
            this.country = (String) extraInfoJsonObj.get("ccFirstName");
            this.country = (String) extraInfoJsonObj.get("ccLastName");
            this.country = (String) extraInfoJsonObj.get("ccNumber");
            this.country = (String) extraInfoJsonObj.get("ccCardVerifyNum");
            this.country = (String) extraInfoJsonObj.get("ccCardType");
            this.country = (String) extraInfoJsonObj.get("ccExpYear");
            this.country = (String) extraInfoJsonObj.get("ccExpMonth");
            this.country = (String) extraInfoJsonObj.get("description");
        }catch (Exception e){
            logger.info("Could not set extra info :"+e.getMessage());
        }
    }

    public String toString() {
        String sFormat = "%1$-25s %2$-25s";
        String s = "\n************************** Extra Info ********************************\n";
        s = s + String.format(sFormat,  "\ncountry :", getCountry() );
        s = s + String.format(sFormat,  "\nccFirstName :", getCcFirstName()) ;
        s = s + String.format(sFormat,  "\nccLastName :", getCcLastName()) ;
        s = s + String.format(sFormat,  "\nccNumber :", getCcNumber() );
        s = s + String.format(sFormat,  "\naccountType :", getAccountType()) ;
        s = s + String.format(sFormat,  "\nccCardVerifyNum :", getCcCardVerifyNum() );
        s = s + String.format(sFormat,  "\nccExpYear :", getCcExpYear() );
        s = s + String.format(sFormat,  "\nccExpMonth :", getCcExpMonth() );
        s = s + String.format(sFormat,  "\nreturnUrl :", getReturnUrl() );
        s = s + String.format(sFormat,  "\ncancelUrl :", getCancelUrl() );
        s = s + String.format(sFormat,  "\npayPalConfirmUrl :", getPayPalConfirmUrl() );
        s = s + "\n***********************************************************************\n";
        return s;
    }



    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCcFirstName() {
        return ccFirstName;
    }

    public void setCcFirstName(String ccFirstName) {
        this.ccFirstName = ccFirstName;
    }

    public String getCcLastName() {
        return ccLastName;
    }

    public void setCcLastName(String ccLastName) {
        this.ccLastName = ccLastName;
    }

    public String getCcNumber() {
        return ccNumber;
    }

    public void setCcNumber(String ccNumber) {
        this.ccNumber = ccNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getCcCardVerifyNum() {
        return ccCardVerifyNum;
    }

    public void setCcCardVerifyNum(String ccCardVerifyNum) {
        this.ccCardVerifyNum = ccCardVerifyNum;
    }


    public String getCcCardType() {
        return ccCardType;
    }

    public void setCcCardType(String ccCardType) {
        this.ccCardType = ccCardType;
    }


    public String getCcExpYear() {
        return ccExpYear;
    }

    public void setCcExpYear(String ccExpYear) {
        this.ccExpYear = ccExpYear;
    }

    public String getCcExpMonth() {
        return ccExpMonth;
    }

    public void setCcExpMonth(String ccExpMonth) {
        this.ccExpMonth = ccExpMonth;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    public String getCancelUrl() {
        return cancelUrl;
    }

    public void setCancelUrl(String cancelUrl) {
        this.cancelUrl = cancelUrl;
    }

    public String getPayPalConfirmUrl() {
        return payPalConfirmUrl;
    }

    public void setPayPalConfirmUrl(String payPalConfirmUrl) {
        this.payPalConfirmUrl = payPalConfirmUrl;
    }


    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCvc() {
        return cvc;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}



