//package com.englishlive.tests.newhouse.salesforce.retention.tw;
///**
// * Sherin - 07/11/2017
// * Test flow-Extend->Suspend->cancel Suspend->suspend->resume->cancel
// */fr newpayment flow is running.hence commenting this one
//
//import com.englishlive.tests.newhouse.salesforce.base.retention.BaseRetentionCreditCardVtpTest;
//import com.englishtown.newhouse.salesforce.enumpack.RetentionRecordType;
//import com.englishtown.newhouse.salesforce.enumpack.RetentionStatus;
//import com.englishtown.newhouse.salesforce.enumpack.RetentionType;
//import com.englishtown.newhouse.salesforce.pages.core.SalesForceConstants;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//
//public class TwVisaExtendSuspendAndCancelTest extends BaseRetentionCreditCardVtpTest {
//    private static final Logger logger = LoggerFactory.getLogger(TwVisaExtendSuspendAndCancelTest.class);
//
//
//    @BeforeTest
//    public void setup(){
//        leadRecordType = "Taiwan";
//        testStartUrl   = SALESFORCE_QA_URL;
//        paymentFrameId = 0;  // 0 for evan france
//        productName       = "23388 (6888) 12M120GL12PL";
//        leadMapData       = SalesForceConstants.TW_LEAD_MAP;
//        creditCardMapData = SalesForceConstants.CREDITCARD_VISA_MAP;
//        cardName          = "Visa";
//        opportunityStageValueWeCss ="#opp11_ileinner";
//        retentionRecordType= RetentionRecordType.TAIWAN.getRetentionRecordType();
//        retentionType= RetentionType.SUSPEND.getRetentionType();
//        retentionStatus= RetentionStatus.PENDINGAPPROVAL.getRetentionStatus();
//        retentionOwner=ADMIN_QA_USERNAME;
//        salesForceAgentName = TW_AGENT_QA;
//        salesForceUserName  = salesForceAgentName;
//        salesForceSupervisorName=ADMIN_QA;
//        setThreadSafeDriver();
//    }
////    @Override
////    protected void goToAndVerifyActuals()   {
////        logger.info("\n!!!!!!!! \n\t\t  goToAndVerifyActuals test overriden \n!!!!!!!!!\n");
////        checkActuals();
////        actualUrl = getWebDriver().getCurrentUrl();
////        logger.info("actualPageUrl ["+ actualUrl+"]");
////    }
//
//    @AfterTest
//    protected void testAfterClass(){
//        destroyDriver();
//    }
//
//
//}
