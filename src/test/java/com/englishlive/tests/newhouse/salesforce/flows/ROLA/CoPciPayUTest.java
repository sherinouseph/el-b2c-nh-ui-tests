//package com.englishlive.tests.newhouse.salesforce.flows.ROLA;
///**
// *
// *Sherin - 07/11/2017
// * Create the actuals through Credit card WorldPay Visa
// *
// */
//
////Minlin to comeback whether I have to run the test for Amex-PayU
//
//import com.englishlive.tests.newhouse.salesforce.base.BaseMapStudentTest;
//import com.englishlive.tests.newhouse.salesforce.base.paymentflow.BasePayUPCITest;
//import com.englishtown.enumpack.PaymentProviderName;
//import com.englishtown.helpers.WebElementHelper;
//import com.englishtown.newhouse.salesforce.pages.AddProductPCI;
//import com.englishtown.newhouse.salesforce.pages.core.SalesForceConstants;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//
//
//public class CoPciPayUTest extends BasePayUPCITest {
//    private static final Logger logger = LoggerFactory.getLogger(CoPciPayUTest.class);
//
//
//    @BeforeTest
//    public void setup(){
//        leadRecordType = "Rola";
//        testStartUrl = SALESFORCE_QA_URL;
//        //paymentFrameId = 0;
//        productName       = "TEST New Payment";
//        paymentProviderName = PaymentProviderName.PAYU;
//        testStartUrl      = SALESFORCE_QA_URL;
//        leadMapData       = SalesForceConstants.LEAD_MAP_PCI;
//        paymentMapData = SalesForceConstants.PAYU_MAP;
//        paymentSchedule   = "Installments-Manual-No Deposit";
//        cardName          = "Visa";
//        isPCI             =true;
//        leadCountry       ="Columbia";
//        setThreadSafeDriver();
//        salesForceAgentName      =ROLA_SALESAGENT_QA;
//        salesForceUserName        = salesForceAgentName;
//        salesForceSupervisorName  =ROLA_SUPERVISOR_QA;
//    }
//
//    @Override
//    protected void selectProductPCI(){
//        addProductPCI = new AddProductPCI(getWebDriver(), SALESFORCE_WAIT_MED);
//        addProductPCI.addProduct(getWebDriver(), productName, paymentMethod, paymentSchedule, discount, numberOfInstallments);
//        WebElementHelper.sendKeys(getWebDriver(),addProductPCI.currencyWe,"COD",true);
//        addProductPCI.clickNext();
//        addProductPCI.clickAddBtn();
//
//    }
//
//
//    @AfterTest
//    protected void testAfterClass(){
//
//        //destroyDriver();
//    }
//
//
//
//
//}
