//package com.englishlive.tests.newhouse.salesforce.flows.Tw;
///**
// * Create the Actuals through CreditCard-Visa
// */twretention test already covering the visa test.so no need to run this
//
//import com.englishlive.tests.newhouse.salesforce.base.paymentflow.BaseBankTransferTest;
//import com.englishlive.tests.newhouse.salesforce.base.paymentflow.BaseCreditCardTest;
//import com.englishtown.newhouse.salesforce.pages.core.SalesForceConstants;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//
//public class TWVisaTest extends BaseCreditCardTest {
//    private static final Logger logger = LoggerFactory.getLogger(TWVisaTest.class);
//
//
//    @BeforeTest
//    public void setup(){
//        leadRecordType = "Taiwan";
//        testStartUrl = SALESFORCE_QA_URL;
//        productName       = "TEST New Payment";
//        testStartUrl      = SALESFORCE_QA_URL;
//        leadMapData       = SalesForceConstants.TW_LEAD_MAP;
//        creditCardMapData = SalesForceConstants.CREDITCARD_VISA_MAP;
//        cardName          = "Visa";
//        opportunityStageValueWeCss ="#opp11_ileinner";
//        salesForceAgentName = TW_AGENT_QA;
//        salesForceUserName = salesForceAgentName;
//        salesForceSupervisorName=TW_SUPERVISOR_QA;
//        setThreadSafeDriver();
//    }
//
//    @Override
//    protected void verifyProductTest(){
//        logger.info("Product is not expected to be present in the oppo Page");
//    }
//
//
//
//    @AfterTest
//    protected void testAfterClass(){
//        destroyDriver();
//    }
//
//
//}
