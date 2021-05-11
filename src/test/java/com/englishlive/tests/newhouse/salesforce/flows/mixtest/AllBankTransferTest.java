//package com.englishlive.tests.newhouse.salesforce.flows.mixtest;
///**
// * temp test
// * payment not working UK
// *
// */
//
//import com.englishlive.tests.newhouse.salesforce.base.paymentflow.BaseBankTransferTest;
//import com.englishtown.newhouse.salesforce.pages.core.SalesForceConstants;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//
//public class AllBankTransferTest extends BaseBankTransferTest {
//    private static final Logger logger = LoggerFactory.getLogger(AllBankTransferTest.class);
//
//
//    @BeforeTest
//    public void setup(){
//        leadRecordType = "Sp";
//        testStartUrl = SALESFORCE_QA_URL;
//       // paymentFrameId=0;
//        productName       = "EU PT 52 12m";
//        testStartUrl      = SALESFORCE_QA_URL;
//        paymentMethod     = "Bank Transfer";
//        leadMapData       = SalesForceConstants.LEAD_MAP;
//        setThreadSafeDriver();
//        salesForceAgentName      = ADMIN_QA;
//        salesForceSupervisorName = ADMIN_QA;
//        salesForceUserName       = salesForceAgentName;
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
//        destroyDriver();
//    }
//
//
//
//}
