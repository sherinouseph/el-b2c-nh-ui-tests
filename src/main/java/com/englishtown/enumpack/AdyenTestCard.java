package com.englishtown.enumpack;
/**
 * /QA/3D secure
 *

 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum AdyenTestCard {

    VISA                    ("Visa", "4917610000000000","03/30","737"),
    MASTERCARD              ("MC", "5454545454545454","03/30","737"),
    AMEX                    ("Amex", "371449635398431","03/30","737"),
    DISCOVER                ("Discover", "6011111111111117","03/30","737"),
    DINERS                   ("Diners", "30569309025904","03/30","737");


    private static final Logger logger = LoggerFactory.getLogger(AdyenTestCard.class);


    private final String cardShortName;
    private final String cardNumber;
    private final String expiryDate;
    private final String cvv;


    AdyenTestCard(String cardShortName, String cardNumber,String expiryDate,String cvv) {

        this.cardShortName = cardShortName;
        this.cardNumber    = cardNumber;
        this.expiryDate=expiryDate;
        this.cvv=cvv;

    }



    public String getCardShortName() {
        return cardShortName;
    }

    public String getCardNumber() {
        return cardNumber;
    }


    public String getExpiryDate() {
        return expiryDate;
    }

    public String getCvv() {
        return cvv;
    }
}

