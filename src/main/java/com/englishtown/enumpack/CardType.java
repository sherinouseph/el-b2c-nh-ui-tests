package com.englishtown.enumpack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum CardType {

    VISA("Visa"),
    MASTERCARD("MasterCard"),
    MAESTRO("Maestro"),
    AMEX("Amex"),
    DISCOVER("Discover"),
    DINE("Dine"),
    BLEUE("Bleue"),
    JCB("JCB"),
    PAYPAL("PayPal"),
    CASHU("CashU"),
    DIRECTDEBIT("DirectDebit"),
    BANKTRANSFER("BankTransfer"),
    SEPA("Sepa"),
    VISA_WEBPAY("VisaWebpay");

    private final String cardType;

    private CardType(String gridEnv) {
        this.cardType = gridEnv;
    }

    public String getCardType(){
        return this.cardType;
    }

    private static final Logger logger = LoggerFactory.getLogger(CardType.class);

}
