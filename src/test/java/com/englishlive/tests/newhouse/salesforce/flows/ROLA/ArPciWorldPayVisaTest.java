//package com.englishlive.tests.newhouse.salesforce.flows.ROLA;
///**
// *
// *Sherin - 07/11/2017
// * Create the actuals through Credit card WorldPay Visa
// *
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
//public class ArPciWorldPayVisaTest extends BaseWorldPayPCITest{
//    private static final Logger logger = LoggerFactory.getLogger(ArPciWorldPayVisaTest.class);
//
//
//    @BeforeTest
//    public void setup(){
//        leadRecordType = "Rola";
//        testStartUrl = SALESFORCE_QA_URL;
//        //paymentFrameId = 0;
//        productName       = "TEST New Payment";
//        paymentProviderName = PaymentProviderName.WORLDPAY;
//        testStartUrl      = SALESFORCE_QA_URL;
//        leadMapData       = SalesForceConstants.LEAD_MAP_PCI;
//        paymentMapData = SalesForceConstants.WORLDPAY_VISA_MAP;
//        paymentSchedule   = "Installments-Manual-No Deposit";
//        cardName          = "Visa";
//        isPCI             =true;
//        leadCountry       ="Argentina";
//       // opportunityStageWon = "Closed Won";
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
