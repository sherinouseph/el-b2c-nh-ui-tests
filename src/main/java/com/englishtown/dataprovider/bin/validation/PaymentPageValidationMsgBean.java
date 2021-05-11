package com.englishtown.dataprovider.bin.validation;
/**
 * Nikol 2018
 * PaymentPage validation message for the form
 *
 */

import com.englishtown.dataprovider.bin.CountryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PaymentPageValidationMsgBean {
    private static final Logger logger = LoggerFactory.getLogger(CountryBean.class);


    protected String cardnumber_validationMsg   = "test should set this up";

    protected String name_validationMsg         = "test should set this up";

    protected String month_validationMsg        = "test should set this up";

    protected String year_validationMsg         = "test should set this up";

    protected String code_validationMsg         = "test should set this up";

    protected String termAndCondition_validationMsg = "test should set this up";

    protected String paymentRejected_MSg = "test should set this up";
    protected String expiryDateValidationMsg = "test should set this up";
    protected String orderFailureMsg = "test should set this up";


    public PaymentPageValidationMsgBean(String cardnumber_validationMsg,
                                        String expiryDate_validationMsg,String code_validationMsg,String paymentRejected_MSg ) {
        this.cardnumber_validationMsg = cardnumber_validationMsg;
        this.code_validationMsg = code_validationMsg;
        this.paymentRejected_MSg=paymentRejected_MSg;
        this.expiryDateValidationMsg=expiryDate_validationMsg;
        logger.info(this.toString());
    }

    public PaymentPageValidationMsgBean(String cardnumber_validationMsg, String name_validationMsg,
                                        String month_validationMsg, String year_validationMsg,
                                        String code_validationMsg, String termAndCondition_validationMsg) {
        this.cardnumber_validationMsg = cardnumber_validationMsg;
        this.name_validationMsg = name_validationMsg;
        this.month_validationMsg = month_validationMsg;
        this.year_validationMsg = year_validationMsg;
        this.code_validationMsg = code_validationMsg;
        this.termAndCondition_validationMsg = termAndCondition_validationMsg;
        logger.info(this.toString());
    }



    public PaymentPageValidationMsgBean(String orderFailureMsg) {
        this.orderFailureMsg = orderFailureMsg;
    }

    public PaymentPageValidationMsgBean() {
        //empty
    }



    public String toString() {
        String sFormat = "%1$-25s %2$-25s";
        String s = "\n";
        s = s + String.format(sFormat,  "\ncardnumber_validationMsg :", cardnumber_validationMsg );
        s = s + String.format(sFormat,  "\nname_validationMsg :", name_validationMsg) ;
        s = s + String.format(sFormat,  "\nmonth_validationMsg :", month_validationMsg) ;
        s = s + String.format(sFormat,  "\nyear_validationMsg :", year_validationMsg) ;
        s = s + String.format(sFormat,  "\ncode_validationMsg :", code_validationMsg );
        s = s + String.format(sFormat,  "\ntermAndCondition_validationMsg :", termAndCondition_validationMsg) ;
        return s;
    }


    public String getCardnumber_validationMsg() {
        return cardnumber_validationMsg;
    }

    public void setCardnumber_validationMsg(String cardnumber_validationMsg) {
        this.cardnumber_validationMsg = cardnumber_validationMsg;
    }

    public String getName_validationMsg() {
        return name_validationMsg;
    }

    public void setName_validationMsg(String name_validationMsg) {
        this.name_validationMsg = name_validationMsg;
    }

    public String getMonth_validationMsg() {
        return month_validationMsg;
    }

    public void setMonth_validationMsg(String month_validationMsg) {
        this.month_validationMsg = month_validationMsg;
    }

    public String getYear_validationMsg() {
        return year_validationMsg;
    }

    public void setYear_validationMsg(String year_validationMsg) {
        this.year_validationMsg = year_validationMsg;
    }

    public String getCode_validationMsg() {
        return code_validationMsg;
    }

    public void setCode_validationMsg(String code_validationMsg) {
        this.code_validationMsg = code_validationMsg;
    }

    public String getTermAndCondition_validationMsg() {
        return termAndCondition_validationMsg;
    }

    public void setTermAndCondition_validationMsg(String termAndCondition_validationMsg) {
        this.termAndCondition_validationMsg = termAndCondition_validationMsg;
    }
    public String getPaymentRejected_MSg() {
        return paymentRejected_MSg;
    }

    public void setPaymentRejected_MSg(String paymentRejected_MSg) {
        this.paymentRejected_MSg = paymentRejected_MSg;
    }

    public String getExpiryDateValidationMsg() {
        return expiryDateValidationMsg;
    }

    public void setExpiryDateValidationMsg(String expiryDateValidationMsg) {
        this.expiryDateValidationMsg = expiryDateValidationMsg;
    }

    public String getOrderFailureMsg() {
        return orderFailureMsg;
    }

    public void setOrderFailureMsg(String orderFailureMsg) {
        this.orderFailureMsg = orderFailureMsg;
    }



}
