//package com.englishlive.tests.newhouse.salesforce.flows.mx;
///**
// * Mx PCI flow Amex
// *
// * Nikol  2
// *
// * Create the actuals through Credit card - cybersource-Amex
// *
// */
//
//import com.englishlive.tests.newhouse.salesforce.base.BaseMapStudentTest;
//import com.englishtown.enumpack.PaymentProviderName;
//import com.englishtown.newhouse.salesforce.pages.core.SalesForceConstants;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//
//
//public class MxPciCyberSourceAmexMapActivateTest extends BaseMapStudentTest{
//    private static final Logger logger = LoggerFactory.getLogger(MxPciCyberSourceAmexMapActivateTest.class);
//
//
//    @BeforeTest
//    public void setup(){
//        leadRecordType = "Mexico";
//        testStartUrl = SALESFORCE_QA_URL;
//        //paymentFrameId = 2;
//        productName       = "TEST New Payment";
//        paymentProviderName = PaymentProviderName.CYBERSOURCE;
//        testStartUrl      = SALESFORCE_QA_URL;
//        leadMapData       = SalesForceConstants.LEAD_MAP_PCI;
//        creditCardMapData = SalesForceConstants.CREDITCARD_AMEX_MAP;
//        paymentSchedule   = "Installments-Manual-No Deposit";
//        cardName          = "Amex";
//        isPCI             =true;
//        salesForceAgentName      =MX_SUPERVISOR_QA;
//        salesForceUserName        = salesForceAgentName;
//        salesForceSupervisorName  =ADMIN_QA;
//        setThreadSafeDriver();
//    }
//
//    @Override
//    protected void clickOnTakePaymentTest() {
//        oppoUrl=getWebDriver().getCurrentUrl();
//        openCurrentOpportunityPageUrl(salesForceAgentName);
//        clickOnTakePayment();
//    }
//    @AfterTest
//    protected void testAfterClass(){
//        destroyDriver();
//    }
//
//
//
//
//}
