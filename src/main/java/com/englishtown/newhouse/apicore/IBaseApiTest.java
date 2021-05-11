package com.englishtown.newhouse.apicore;

import com.englishtown.newhouse.apicore.bean.KeyValue;

/**
 * Created by nikol.marku on 02-Oct-17.
 */



public interface IBaseApiTest {

    /**
     * api base host/url
     */
    public static final String BASE_QA_URL   = "https://qa-englishlive.ef.com/1/"; //https://qa-b2c.eflabs.io/1/";
    public static final String BASE_LIVE_URL = "https://englishlive.ef.com/1/";
    public static final String BASE_STG_URL  = "https://stg-englishlive.ef.com/1/";
    public static final String BASE_UAT_URL  = "https://uat-englishlive.ef.com/1/";

    /**
     * Base urls for each gateway
     * Only commerce gateway is open to public
     */
    final String COMMERCE_GATEWAY_BASE_URL  = "api/commerce-gateway/";


    String TESTDATA_FOLDER = "/src/test/java/com/englishlive/tests/newhouse/apitest/testsuite/testdata/json/";
    // files
    String CYBERSOURCE_VISA_JSON = "CybersourceVisa.json";
    String CYBERSOURCE_AMEX_JSON = "CybersourceAmex.json";
    String CYBERSOURCE_MASTERCARD_JSON = "CybersourceMasterCard.json";
    //String CYBERSOURCE_MAESTRO_JSON = "CybersourceVisa.json";
    String PAYPAL_JSON           = "PayPal.json";
    String PAYU_JSON             = "PayU.json";
    String WORLDPAY_JSON         = "WorldPay.json";
    String PAYMENTTECH_JSON      = "PaymentTech.json";
    String COMMERSEAPI_JSON ="BuyWithCreditCardCommerceApi.json";
    String DEFAULT_PASS = "12345678";

    /**
     * Use this to initialise Test data
     * Request body and headers
     * Request file
     * Specification setup
     */
    void setupTestBeanDataAndSpec();


    //requestSpecBuilder.addHeader("Accept", "application/json, text/javascript, */*; q=0.01");
    /*        requestSpecBuilder.addHeader("Origin", "https://efid.vagrant.f8");
        requestSpecBuilder.addHeader("Content-Type", "application/x-www-form-urlencoded");
        requestSpecBuilder.addHeader("Accept-Encoding", "gzip, deflate, br");

     */

    KeyValue keyValueHeaderAccept                   = new KeyValue("Accept",            "application/json, text/javascript, */*; q=0.01");
    KeyValue keyValueHeaderOriginEfid               = new KeyValue("Origin",            "https://efid.vagrant.f8");
    KeyValue keyValueHeaderContentTypeUrlencoded    = new KeyValue("Content-Type",      "application/x-www-form-urlencoded");
    KeyValue keyValueHeadert                        = new KeyValue("Accept-Encoding",   "gzip, deflate, br");
    //KeyValue keyValueHeader                         = new KeyValue("Accept", "application/json, text/javascript, */*; q=0.01");

}
