package com.englishlive.tests.newhouse.salesforce.flows.Us;
/**
 * Sherin - 06/11/2017
 * Create actuals through WorldPay Visa
 *not usedd by many users.hence commenting this test -
 */

import com.englishlive.tests.newhouse.salesforce.base.paymentflow.BaseWorldPayPCITest;
import com.englishtown.enumpack.PaymentProviderName;
import com.englishtown.newhouse.salesforce.pages.core.SalesForceConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class USPciWorldPayVisaTest extends BaseWorldPayPCITest {
    private static final Logger logger = LoggerFactory.getLogger(USPciWorldPayVisaTest.class);


    @BeforeTest
    public void setup(){
        leadRecordType = "US";
        isPCI          =true;
        testStartUrl = SALESFORCE_QA_URL;
        //paymentFrameId = 0;
        productName       = "US Private 12PL 12 Month";
        paymentProviderName = PaymentProviderName.WORLDPAY;
        testStartUrl      = SALESFORCE_QA_URL;
        leadMapData       = SalesForceConstants.LEAD_MAP_PCI;
        paymentMapData = SalesForceConstants.WORLDPAY_VISA_MAP;
        paymentSchedule   = "Installments-Manual-No Deposit";
        opportunityStageWon = "Closed Won";
        cardName          = "Visa";
        setThreadSafeDriver();
    }

    @AfterTest
    protected void testAfterClass(){
        destroyDriver();
    }




}
