package com.englishlive.tests.newhouse.salesforce.renewal;
/**
 *Sherin - 27/11/2017
 * Germany renewal test
 */

import com.englishlive.tests.newhouse.salesforce.base.renewal.BaseRenewalTest;
import com.englishtown.newhouse.salesforce.pages.core.SalesForceConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TrRenewalTest extends BaseRenewalTest {
    private static final Logger logger = LoggerFactory.getLogger(TrRenewalTest.class);


    @BeforeTest
    public void setup(){
        leadRecordType = "Turkey";
        testStartUrl = SALESFORCE_QA_URL;
        isNewhousePayment=true;
        productName       = "TEST New Payment";
        //paymentFrameId=2;
        testStartUrl      = SALESFORCE_QA_URL;
        leadMapData       = SalesForceConstants.LEAD_MAP;
        creditCardMapData = SalesForceConstants.CREDITCARD_DISCOVER_MAP;
        cardName          = "Discover";
        salesForceAgentName=TR_SUPERVISOR_QA;
        salesForceUserName = salesForceAgentName;
        setThreadSafeDriver();
    }


    @AfterTest
    protected void testAfterClass(){

        destroyDriver();
    }


}
