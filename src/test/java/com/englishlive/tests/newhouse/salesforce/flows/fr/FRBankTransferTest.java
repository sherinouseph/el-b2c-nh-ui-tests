//package com.englishlive.tests.newhouse.salesforce.flows.fr;
///**
// * Sherin - 04/11/2017
// * Login to sales force
// * Create the actuals through Bank Transfer
// */
//
//import com.englishlive.tests.newhouse.salesforce.base.paymentflow.BaseBankTransferTest;
//import com.englishtown.newhouse.salesforce.pages.core.SalesForceConstants;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//commenting this one because frlogintoschool test already used bank transfer ,so should cover this test
//public class FRBankTransferTest extends BaseBankTransferTest {
//    private static final Logger logger = LoggerFactory.getLogger(FRBankTransferTest.class);
//
//
//    @BeforeTest
//    public void setup(){
//        leadRecordType = "France";
//        testStartUrl = SALESFORCE_QA_URL;
//       // paymentFrameId=0;
//        productName       = "EU PT 52 12m";
//        testStartUrl      = SALESFORCE_QA_URL;
//        paymentMethod     = "Bank Transfer";
//        leadMapData       = SalesForceConstants.LEAD_MAP;
//        setThreadSafeDriver();
//        salesForceAgentName=FRANCE_SALESAGENT_QA;
//        salesForceSupervisorName=FRANCE_SUPERVISOR_QA;
//        salesForceUserName = salesForceAgentName;
//    }
//
//   @Override
//   protected void clickOnTakePaymentTest() {
//        oppoUrl=getWebDriver().getCurrentUrl();
//        openSalesForceAndlogin(salesForceSupervisorName,SALESFORCE_PASS);
//        openUrl(getWebDriver(),oppoUrl);
//        clickOnTakePayment();
//  }
//    @AfterTest
//    protected void testAfterClass(){
//
//        destroyDriver();
//    }
//
//
//
//}
