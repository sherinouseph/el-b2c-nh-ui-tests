package com.englishtown.enumpack;

/**
 * Created by nikol.marku on 12/20/2017.
 "Worldpay"
 "Cybersource"
 "Paymentech"
 "PayU"
 "PayPal"
 *
 */

public enum GatewayType {

    CYBERSOURCE("Cybersource"),
    WORLDPAY("Worldpay"),
    PAYMENTTECH("Paymentech"),
    PAYU("PayU"),
    PAYPAL("PayPal");

    private final String gatewayType;

    private GatewayType(String gatewayType) {
        this.gatewayType = gatewayType;
    }

    public String getGatewayType(){
        return this.gatewayType;
    }

}
