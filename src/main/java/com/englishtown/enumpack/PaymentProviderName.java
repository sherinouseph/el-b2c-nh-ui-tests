package com.englishtown.enumpack;

/**
 * Created by nikol.marku on 2/27/2017.
 * document.querySelectorAll('a')[1].getBoundingClientRect()
 * ClientRect {top: 0, right: 0, bottom: 0, left: 0, width: 0…}
 */

public enum PaymentProviderName {
    WORLDPAY("worldpay"),
    PAYU("payu"),
    CYBERSOURCE("cybersource"),
    PAYPAL("paypal");

    private final String payProvider;

    private PaymentProviderName(String payProvider) {
        this.payProvider = payProvider;
    }

    public String getPayProviderName(){
        return this.payProvider;
    }

}
