//package com.englishlive.tests.newhouse.salesforce.flows.mx;
///**
// *Sherin - 07/11/2017
// * Create the actuals through Credit card WorldPay - Visa
// *
// *commenting this test because worldpay is not pointed to qa
// */
//
//import com.englishlive.tests.newhouse.salesforce.base.paymentflow.BaseWorldPayPCITest;
//import com.englishtown.enumpack.PaymentProviderName;
//import com.englishtown.newhouse.salesforce.pages.core.SalesForceConstants;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//
//
//public class MxPciWorldPayVisaTest extends BaseWorldPayPCITest{
//    private static final Logger logger = LoggerFactory.getLogger(MxPciWorldPayVisaTest.class);
//
//
//    @BeforeTest
//    public void setup(){
//        leadRecordType = "Mexico";
//        testStartUrl = SALESFORCE_QA_URL;
//        //paymentFrameId = 0;
//        productName       = "MX Private 24PL.12 Month";
//        paymentProviderName = PaymentProviderName.WORLDPAY;
//        testStartUrl      = SALESFORCE_QA_URL;
//        leadMapData       = SalesForceConstants.LEAD_MAP_PCI;
//        paymentMapData = SalesForceConstants.WORLDPAY_VISA_MAP;
//        paymentSchedule   = "Installments-Manual-No Deposit";
//        cardName          = "Visa";
//        isPCI             =true;
//        opportunityStageWon = "Payment Pending";
//        setThreadSafeDriver();
//    }
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
