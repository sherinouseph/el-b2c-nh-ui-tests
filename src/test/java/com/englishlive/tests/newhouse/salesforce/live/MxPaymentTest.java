//package com.englishlive.tests.newhouse.salesforce.live;
///**
// * Sherin - 14/12/2017
// * Test to check if the payment forms are shown
// */
//
//
//import com.englishlive.tests.newhouse.salesforce.base.BasePciLivePaymentTest;
//import com.englishtown.enumpack.PaymentProviderName;
//import com.englishtown.newhouse.salesforce.pages.core.SalesForceConstants;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//
//
//public class MxPaymentTest extends BasePciLivePaymentTest {
//    private static final Logger logger = LoggerFactory.getLogger(MxPaymentTest.class);
//
//
//    @BeforeTest
//    public void setup(){
//        leadRecordType       = "Mexico";
//        SALESFORCE_ENV="Live";
//       // paymentFrameId = 2;
//        productName           = "MX Private 24PL.12 Month";
//        paymentProviderName    = PaymentProviderName.PAYU;
//        leadMapData             = SalesForceConstants.LEAD_MAP_PCI;
//        paymentMapData          = SalesForceConstants.PAYU_MAP;
//        paymentSchedule         = "Installments-Manual-No Deposit";
//        isPCI                   =true;
//        salesForceAgentName      ="evan.sun@ef.com";//MX_SALESAGENT_QA;//stefano to create mexico user password.after that i will use the real mexico agent
//        salesForceUserName        = salesForceAgentName;
//        salesForceSupervisorName  =salesForceAgentName;
//        setThreadSafeDriver();
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
//
//
//}
