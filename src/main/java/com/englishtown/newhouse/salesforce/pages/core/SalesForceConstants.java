package com.englishtown.newhouse.salesforce.pages.core;

import com.englishtown.helpers.utils.TestUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;


public class SalesForceConstants {
    private static final Logger logger = LoggerFactory.getLogger(SalesForceConstants.class);
    public static AtomicLong alCurrTime;
    public static Long currTime;
    //public static String randomStrInt;
    public static final String TEST_MAIL_START_TOKEN = "auto_"; //TEST_MAIL_START_TOKEN+currTime+TEST_MAIL_endTOCKEN+"@qp1.org"
    public static final String TEST_MAIL_END_TOKEN = "_xdelx";



    public Long getCurrTime() {
        return currTime;
    }

    public static synchronized void setCurrTime(Long currTime) {
        setCurrTimeSafe(currTime);
        SalesForceConstants.currTime = currTime;
    }

    public static void setCurrTimeSafe(Long currTime) {
        if (SalesForceConstants.currTime == currTime) {
            SalesForceConstants.currTime = System.currentTimeMillis();
        }
    }

    public static void dumpMap(Map mp) {
        Iterator it = mp.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pairs = (Map.Entry) it.next();
            System.out.println(pairs.getKey() + "\t = " + pairs.getValue());
        }
    }


    public static final Map<String, String> LEAD_MAP = new LinkedHashMap<>();
    static {
        LEAD_MAP.put("lea3", "CompanyTest" + TestUtil.generateRandomString("R", 3));
        LEAD_MAP.put("name_firstlea2", "firstname" + TestUtil.generateRandomString("R", 3));
        LEAD_MAP.put("name_lastlea2", "Lastname" + TestUtil.generateRandomString("R", 3));
        //LEAD_MAP.put("lea11", TEST_MAIL_START_TOKEN+currTime+"_"+randomStrInt+"_"+TEST_MAIL_END_TOKEN+"@qp1.org");
        LEAD_MAP.put("lea8", "123456689");
        LEAD_MAP.put( "name_salutationlea2", "selectMeSelectOpt&true&Mr.");
        LEAD_MAP.put("lea13", "selectMeSelectOpt&true&Set Appt");

    }

    public static final Map<String, String> TW_LEAD_MAP = new LinkedHashMap<>();
    static {
        TW_LEAD_MAP.put("lea3", "CompanyTest" + TestUtil.generateRandomString("R", 3));
        TW_LEAD_MAP.put("name_firstlea2", "firstname" + TestUtil.generateRandomString("R", 3));
        TW_LEAD_MAP.put("name_lastlea2", "Lastname" + TestUtil.generateRandomString("R", 3));
        //LEAD_MAP.put("lea11", TEST_MAIL_START_TOKEN+currTime+"_"+randomStrInt+"_"+TEST_MAIL_END_TOKEN+"@qp1.org");
        TW_LEAD_MAP.put("lea8", "123456689");
        TW_LEAD_MAP.put( "name_salutationlea2", "selectMeSelectOpt&true&Mr.");
        TW_LEAD_MAP.put("lea13", "selectMeSelectOpt&true&Set Appt");
        TW_LEAD_MAP.put("00N30000000k5UY", "selectMeSelectOpt&true&EFST");

    }


    public static final Map<String, String> LEAD_MAP_PCI = new LinkedHashMap<>();
    static {
        LEAD_MAP_PCI.put("lea3", "CompanyTest" + TestUtil.generateRandomString("R", 3));
        LEAD_MAP_PCI.put( "name_salutationlea2", "selectMeSelectOpt&true&Mr.");
        LEAD_MAP_PCI.put("name_firstlea2", "firstname" + TestUtil.generateRandomString("R", 3));
        LEAD_MAP_PCI.put("name_lastlea2", "Lastname" + TestUtil.generateRandomString("R", 3));
        //LEAD_MAP.put("lea11", TEST_MAIL_START_TOKEN+currTime+"_"+randomStrInt+"_"+TEST_MAIL_END_TOKEN+"@qp1.org");
        LEAD_MAP_PCI.put("lea8", "123456689");
        LEAD_MAP_PCI.put("lea13", "selectMeSelectOpt&true&Set Appt");
        LEAD_MAP_PCI.put("00N30000000k5UY", "selectMeSelectOpt&true&EFST");
    }

    public static final Map<String, String> CREDITCARD_VISA_MAP = new LinkedHashMap<>();
    static {
        CREDITCARD_VISA_MAP.put("card_number", "4111111111111111");
        CREDITCARD_VISA_MAP.put("card_cvn","123");
        CREDITCARD_VISA_MAP.put("card_expiry_month", "selectMeSelectOpt&true&05");
        CREDITCARD_VISA_MAP.put("card_expiry_year", "selectMeSelectOpt&true&2021"); //TODO get the year dynamically
    }
    public static final Map<String, String> CREDITCARD_MASTERCARD_MAP = new LinkedHashMap<>();
    static {
        CREDITCARD_MASTERCARD_MAP.put("card_number", "5555555555554444");
        CREDITCARD_MASTERCARD_MAP.put("card_cvn","123");
        CREDITCARD_MASTERCARD_MAP.put("card_expiry_month", "selectMeSelectOpt&true&05");
        CREDITCARD_MASTERCARD_MAP.put("card_expiry_year", "selectMeSelectOpt&true&2021"); //TODO get the year dynamically
    }

    public static final Map<String, String> CREDITCARD_AMEX_MAP = new LinkedHashMap<>();
    static {
        CREDITCARD_AMEX_MAP.put("card_number", "378282246310005");
        CREDITCARD_AMEX_MAP.put("card_cvn","1234");
        CREDITCARD_AMEX_MAP.put("card_expiry_month", "selectMeSelectOpt&true&05");
        CREDITCARD_AMEX_MAP.put("card_expiry_year", "selectMeSelectOpt&true&2021"); //TODO get the year dynamically
    }
    public static final Map<String, String> CREDITCARD_DISCOVER_MAP = new LinkedHashMap<>();
    static {
        CREDITCARD_DISCOVER_MAP.put("card_number", "6011111111111117");
        CREDITCARD_DISCOVER_MAP.put("card_cvn","123");
        CREDITCARD_DISCOVER_MAP.put("card_expiry_month", "selectMeSelectOpt&true&05");
        CREDITCARD_DISCOVER_MAP.put("card_expiry_year", "selectMeSelectOpt&true&2021"); //TODO get the year dynamically
    }

    public static final Map<String, String> CREDITCARD_MAESTROINT_MAP = new LinkedHashMap<>();
    static {
        CREDITCARD_MAESTROINT_MAP.put("card_number", "50339619890917 ");
        CREDITCARD_MAESTROINT_MAP.put("card_cvn","123");
        CREDITCARD_MAESTROINT_MAP.put("card_expiry_month", "selectMeSelectOpt&true&05");
        CREDITCARD_MAESTROINT_MAP.put("card_expiry_year", "selectMeSelectOpt&true&2021"); //TODO get the year dynamically
    }

    public static final Map<String, String> CREDITCARD_DINER_MAP = new LinkedHashMap<>();
    static {
        CREDITCARD_DINER_MAP.put("card_number", "38000000000006 ");
        CREDITCARD_DINER_MAP.put("card_cvn","123");
        CREDITCARD_DINER_MAP.put("card_expiry_month", "selectMeSelectOpt&true&05");
        CREDITCARD_DINER_MAP.put("card_expiry_year", "selectMeSelectOpt&true&2021"); //TODO get the year dynamically
    }

    public static final Map<String, String> DIRECTDEBIT_MAP_FR = new LinkedHashMap<>();
    static {
        DIRECTDEBIT_MAP_FR.put("euddBankAccountBuilder.holder", "00123456789");
        DIRECTDEBIT_MAP_FR.put("euddBankAccountBuilder.iban","FR7610011000200012345678934");
        DIRECTDEBIT_MAP_FR.put("euddBankAccountBuilder.bic", "PSSTFRPPCNE");

    }

    public static final Map<String, String> DIRECTDEBIT_MAP_DE = new LinkedHashMap<>();
    static {
        DIRECTDEBIT_MAP_DE.put("euddBankAccountBuilder.holder", "1111111116 ");
        DIRECTDEBIT_MAP_DE.put("euddBankAccountBuilder.iban","DE75100100101111111116");
        DIRECTDEBIT_MAP_DE.put("euddBankAccountBuilder.bic", "PBNKDEFF100");

    }

    /**
     * Card name and the css selector id for that card
     */
    public static final Map<String, String> CARD_TYPE_MAP = new LinkedHashMap<>();
    static {
        CARD_TYPE_MAP.put("Visa", "card_type_001");
        CARD_TYPE_MAP.put("Mastercard", "card_type_002");
        CARD_TYPE_MAP.put("Amex","card_type_003");
        CARD_TYPE_MAP.put("Diners", "card_type_005");
        CARD_TYPE_MAP.put("Discover","card_type_004");
        CARD_TYPE_MAP.put("Maestro Int.","card_type_042");
    }

    public static final Map<String, String> WORLDPAY_CARD_TYPE_MAP = new LinkedHashMap<>();
    static {
        WORLDPAY_CARD_TYPE_MAP.put("Visa", "op-DPChoose-VISA^SSL");
        WORLDPAY_CARD_TYPE_MAP.put("Mastercard", "op-DPChoose-ECMC^SSL");
        WORLDPAY_CARD_TYPE_MAP.put("Amex","op-DPChoose-AMEX^SSL");
        WORLDPAY_CARD_TYPE_MAP.put("Diners", "op-DPChoose-DINERS^SSL");
        WORLDPAY_CARD_TYPE_MAP.put("JCB","op-DPChoose-JCB^SSL");
        WORLDPAY_CARD_TYPE_MAP.put("Maestro ","op-DPChoose-MAESTRO^SSL");
    }
    //looks like selectors have changed when they removed it from the frame
//    public static final Map<String, String> WORLDPAY_VISA_MAP = new LinkedHashMap<>();
//    static {
//        WORLDPAY_VISA_MAP.put("cardNoInput","4111111111111111");
//        WORLDPAY_VISA_MAP.put("cardCVV", "123");
//        WORLDPAY_VISA_MAP.put("name", "Testworldpayuser");
//        WORLDPAY_VISA_MAP.put("cardExp.month", "selectMeSelectOpt&true&5");
//        WORLDPAY_VISA_MAP.put("cardExp.year", "selectMeSelectOpt&true&2018");
//    }

    public static final Map<String, String> WORLDPAY_VISA_MAP = new LinkedHashMap<>();
    static {
        WORLDPAY_VISA_MAP.put("cardNumber","4111111111111111");
        WORLDPAY_VISA_MAP.put("cardholderName", "Testworldpayuser");
        WORLDPAY_VISA_MAP.put("expiryDate.expiryMonth", "selectMeSelectOpt&true&05");
        WORLDPAY_VISA_MAP.put("expiryDate.expiryYear", "selectMeSelectOpt&true&2026");
        WORLDPAY_VISA_MAP.put("securityCode", "123");
    }

    public static final Map<String, String> WORLDPAY_JCB_MAP = new LinkedHashMap<>();
    static {
        WORLDPAY_JCB_MAP.put("cardNoInput","3566111111111113");
        WORLDPAY_JCB_MAP.put("cardCVV", "123");
        WORLDPAY_JCB_MAP.put("name", "Testworldpayuser");
        WORLDPAY_JCB_MAP.put("cardExp.month", "selectMeSelectOpt&true&5");
        WORLDPAY_JCB_MAP.put("cardExp.year", "selectMeSelectOpt&true&2026");
    }

    public static final Map<String, String> PAYU_MAP = new LinkedHashMap<>();
    static {
        PAYU_MAP.put("input[payu-content='number']","4111111111111111");
        PAYU_MAP.put("input[payu-content='exp_month", "05");
        PAYU_MAP.put("input[payu-content='exp_year", "2022");
        PAYU_MAP.put("input[payu-content='document", "TestTEST");
        PAYU_MAP.put("input[payu-content='name_card']", "APPROVED");
        PAYU_MAP.put("input[payu-content='cvc']", "845");
    }


}