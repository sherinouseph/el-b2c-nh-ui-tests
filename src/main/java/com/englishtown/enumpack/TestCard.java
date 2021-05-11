package com.englishtown.enumpack;
/**
 * UAT/QA/STG
 * TEST CARDS
 *
 * LIVE
 1.	Put testing as first name or @qp1.org as suffix of email
 2.	Put debug=ccval=false as query string in Payment page.
 3.	Put 4222222222222222 as card number

 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum TestCard {

    VISA_QA                 ("001","Visa", "4111111111111111"),
    VISA_LIVE               ("001","Visa", "4222222222222222 "),
    MASTERCARD_1            ("002","MC", "5555555555554444"),
    MASTERCARD_2            ("002","MC", "2221000000000009"),
    AMEX                    ("003","Amex", "378282246310005"),
    DISCOVER                ("004","Disc", "6011111111111117"),
    DINE                    ("005","Dine", "38000000000006"),
    JCB                     ("007","Jcb", "3566111111111113"),
    MAESTRO_UKDOM           ("024","MaestroUKDomestic", "6759411100000008"),              // no issue num required
    MAESTRO_UKDOM_1DIGITREQ ("024","MaestroUKDomestic1", "6759560045005727054"), // REQUIRES one digit issue number
    MAESTRO_UKDOM_2DIGITREQ ("024","MaestroUKDomestic2", "5641821111166669"),    // REQUIRES tow digit issue number
    MAESTRO_INT_1           ("024","MaestroInt1", "50339619890917"),
    MAESTRO_INT_2           ("024","MaestroInt2", "586824160825533338"),
    DD_CardType             ("xxx","ED", "xxxxxxxx");   // ON DD pay get tocken returns  "GatewayCardType": "ED",
    //LASER                   ("na","Laser", "6304985028090561515"),
    /*SOLO_NOISSUENUM         ("na","Solo", "6334589898000001"),    // no issue number required
    SOLO_1ISSUENUM          ("na","Solo", "676782009988007706"),   // REQUIRES one digit issue number
    SOLO_2ISSUENUM          ("na","Solo", "6334971111111114"),     // REQUIRES tow digit issue number
    UATP                    ("na","Uatp", "135412345678911");*/
    /*DELTA("031","Delta", "CCNUM"),
    ELEC("033","Elec", "CCNUM");
    DANK("034","Dank", "CCNUM"),
    ECMC("014","Ecmc", "CCNUM"),
    VISA("021","Jal", "CCNUM"),
    VISA("006","Blan", "CCNUM"),
    BLEUE("036","Bleue", "CCNUM"),
    VISA("037","Casi", "CCNUM"),
    VISA("042","MAES", "CCNUM"),
    VISA("043","Sant", "CCNUM"),
    VISA("050","Hiper", "CCNUM"),
    VISA("054","Elo", "CCNUM");*/

    private static final Logger logger = LoggerFactory.getLogger(TestCard.class);

    private final String cardCode;
    private final String cardShortName;
    private final String cardNumber;


    TestCard(String cardCode, String cardShortName, String cardNumber) {
        this.cardCode      = cardCode;
        this.cardShortName = cardShortName;
        this.cardNumber    = cardNumber;
    }

    public String getCardCode() {
        return cardCode;
    }

    public String getCardShortName() {
        return cardShortName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    @Override
    public String toString(){
        String s = "";
        s = s+this.cardShortName+" - "+this.cardCode+" - "+this.cardNumber;
        return s;
    }

}


/**********************************************
 *
 *
 _cardTypeMapping.Add("001", "Visa");
 _cardTypeMapping.Add("002", "MC");
 _cardTypeMapping.Add("003", "Amex");
 _cardTypeMapping.Add("004", "Disc");
 _cardTypeMapping.Add("005", "Dine");
 _cardTypeMapping.Add("006", "Blan");
 _cardTypeMapping.Add("007", "Jcb");
 _cardTypeMapping.Add("014", "Ecmc");
 _cardTypeMapping.Add("021", "Jal");
 _cardTypeMapping.Add("024", "MaestroUKDomestic");
 _cardTypeMapping.Add("031", "Delta");
 _cardTypeMapping.Add("033", "Elec");
 _cardTypeMapping.Add("034", "Dank");
 _cardTypeMapping.Add("036", "Bleue");
 _cardTypeMapping.Add("037", "Casi");
 _cardTypeMapping.Add("042", "MAES");
 _cardTypeMapping.Add("043", "Sant");
 _cardTypeMapping.Add("050", "Hiper");
 _cardTypeMapping.Add("054", "Elo");

 ------------------------------------------------------------------------------------------
 Credit Card Testing Card
 Skip to end of metadata
 •	Created by Unknown User (kai.feng), last modified by Sini shao on Jul 05, 2017
 Go to start of metadata
 UAT/QA/STG

 Dine
 38000000000006
 American Express
 3782 8224 6310 005
 Discover
 6011 1111 1111 1117
 JCB
 3566 1111 1111 1113
 Laser
 6304 9850 2809 0561 515
 Maestro (International)
 5033 9619 8909 17
 5868 2416 0825 5333 38
 Maestro (UK Domestic)
 Issue number not required: 6759 4111 0000 0008
 One-digit issue number required: 6759 5600 4500 5727 054
 Two-digit issue number required: 5641 8211 1116 6669
 MasterCard
 5555 5555 5555 4444
 2221000000000009
 Solo
 Issue number not required: 6334 5898 9800 0001
 One-digit issue number required: 6767 8200 9988 0077 06
 Two-digit issue number required: 6334 9711 1111 1114
 UATP
 1354 1234 5678 911
 VISA
 4111 1111 1111 1111

 LIVE
 1.	Put testing as first name or @qp1.org as suffix of email
 2.	Put debug=ccval=false as query string in Payment page.
 3.	Put 4222222222222222 as card number

 --

 *
 */
