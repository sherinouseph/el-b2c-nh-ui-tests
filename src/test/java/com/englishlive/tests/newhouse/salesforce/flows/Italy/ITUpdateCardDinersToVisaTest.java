//package com.englishlive.tests.newhouse.salesforce.flows.Italy;
///**
// * Sherin - 06/11/2017
// * Login to sales force
// * Create the actuals through Credit card Diners
// *
// *commeting this test because update card for france is performing this test
// * TODO: probably use existing actual to update the card details instead of doing all the other tests
// */
//
//import com.englishlive.tests.newhouse.salesforce.base.BaseChargeNowTest;
//import com.englishlive.tests.newhouse.salesforce.base.BaseUpdateCardTest;
//import com.englishtown.newhouse.salesforce.pages.core.SalesForceConstants;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//
//public class ITUpdateCardDinersToVisaTest extends BaseChargeNowTest {
//    private static final Logger logger = LoggerFactory.getLogger(ITUpdateCardDinersToVisaTest.class);
//
//
//    @BeforeTest
//    public void setup(){
//        leadRecordType = "Italy";
//        testStartUrl = SALESFORCE_QA_URL;
//        productName       = "TEST New Payment";
//        paymentFrameId=0;
//        testStartUrl      = SALESFORCE_QA_URL;
//        leadMapData       = SalesForceConstants.LEAD_MAP;
//        creditCardMapData = SalesForceConstants.CREDITCARD_DINER_MAP;
//        cardName          = "Diners";
//        salesForceAgentName=ITALY_SALESAGENT_QA;
//        salesForceUserName = salesForceAgentName;
//        setThreadSafeDriver();
//        salesForceSupervisorName=ITALY_SUPERVISOR_QA;
//    }
//
//   @Override
//   protected void getUrlsndVerifyActuals() {
//    getUrlsAndcheckActuals();
//   }
//
//    @AfterTest
//    protected void testAfterClass(){
//        destroyDriver();
//    }
//
//
//}
