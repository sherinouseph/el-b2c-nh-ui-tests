//package com.englishlive.tests.newhouse.salesforce.retention.meast;
///**
// * Sherin - 07/11/2017
// * Test flow-Extend->Suspend->cancel Suspend->suspend->resume->cancel
// */
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
//public class OmanExtendSuspendAndCancelTest extends BaseRetentionCreditCardVtpTest {
//    private static final Logger logger = LoggerFactory.getLogger(OmanExtendSuspendAndCancelTest.class);
//
//
//    @BeforeTest
//    public void setup(){
//        leadRecordType = "MEAST";
//        testStartUrl   = SALESFORCE_QA_URL;
//        paymentFrameId = 0;  // 0 for evan france
//        productName       = "TEST New Payment";
//        leadMapData       = SalesForceConstants.LEAD_MAP;
//        creditCardMapData = SalesForceConstants.CREDITCARD_MASTERCARD_MAP;
//        leadCountry       ="Oman";
//        cardName          = "Mastercard";
//        opportunityStageValueWeCss ="#opp11_ileinner";
//        retentionRecordType= RetentionRecordType.EUROPE.getRetentionRecordType();
//        retentionType= RetentionType.SUSPEND.getRetentionType();
//        retentionStatus= RetentionStatus.PENDINGAPPROVAL.getRetentionStatus();
//        retentionOwner=ADMIN_QA_USERNAME;
//        salesForceAgentName = MEAST_SALESAGENT_QA;
//        salesForceUserName  = salesForceAgentName;
//        salesForceSupervisorName=ADMIN_QA;
//        setThreadSafeDriver();
//    }
//
//
//    @AfterTest
//    protected void testAfterClass(){
//        destroyDriver();
//    }
//
//
//}
