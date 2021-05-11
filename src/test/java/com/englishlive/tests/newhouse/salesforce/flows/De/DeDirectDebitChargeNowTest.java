//package com.englishlive.tests.newhouse.salesforce.flows.De;
///**
// * Sherin - 06/11/2017
// * Login to sales force
// */
//De debit card not working currently on qa. Hence commenting this test .Fr debitcard is working .so will be running that
//
//import com.englishlive.tests.newhouse.salesforce.base.paymentflow.BaseCreditCardTest;
//import com.englishlive.tests.newhouse.salesforce.base.paymentflow.BaseDirectDebitTest;
//import com.englishtown.newhouse.salesforce.pages.core.SalesForceConstants;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//
//public class DeDirectDebitChargeNowTest extends BaseDirectDebitTest {
//    private static final Logger logger = LoggerFactory.getLogger(DeDirectDebitChargeNowTest.class);
//
//
//    @BeforeTest
//    public void setup(){
//        leadRecordType = "Germany";
//        testStartUrl = SALESFORCE_QA_URL;
//        productName       = "EU PT 52 12m";
//        paymentMethod     = "Direct Debit";
//        //isChargeNowShowAlertTwice=true;
//        testStartUrl      = SALESFORCE_QA_URL;
//        leadMapData       = SalesForceConstants.LEAD_MAP;
//        paymentMapData = SalesForceConstants.DIRECTDEBIT_MAP_DE;
//        salesForceAgentName=GERMANY_SALESAGENT_QA;
//        salesForceUserName = salesForceAgentName;
//        salesForceSupervisorName=GERMANY_SUPERVISOR_QA;
//        setThreadSafeDriver();
//    }
//
//
//    @AfterTest
//    protected void testAfterClass(){
//
//       // destroyDriver();
//    }
//
//
//}
