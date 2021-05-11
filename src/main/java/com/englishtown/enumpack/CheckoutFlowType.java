package com.englishtown.enumpack;

/**
 * Created by nikol.marku on 18/05/2016.
 * https://jira-bos.englishtown.com/browse/SAND-2967
 */
public enum CheckoutFlowType {
    DEFAULT("default"),
    RETURN("return"),
    UPSELL("upsell"),
    REDEMPTION("redemption"),
    WELCOMEBACK("welcome-back");

    String checkoutFlowType;

    CheckoutFlowType(String type){
        this.checkoutFlowType = type;
    }

    public String getCheckoutFlowType(){
        return checkoutFlowType;
    }

}
