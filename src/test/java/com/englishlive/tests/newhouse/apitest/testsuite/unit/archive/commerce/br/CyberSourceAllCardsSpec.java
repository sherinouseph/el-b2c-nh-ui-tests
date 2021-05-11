//package com.englishlive.tests.newhouse.apitest.testsuite.unit.archive.commerce.br;
///**
// * Test Cybersource all cards with 11.99
// * and Amex with 11.99 and 0 amount
// *
// VISA_QA                 ("001","Visa", "4111111111111111"),
// VISA_LIVE               ("001","Visa", "4222222222222222 "),
// MASTERCARD_1            ("002","MC", "5555555555554444"),
// MASTERCARD_2            ("002","MC", "2221000000000009"),
// AMEX                    ("003","Amex", "378282246310005"),
// DISCOVER                ("004","Disc", "6011111111111117"),
// DINE                    ("005","Dine", "38000000000006"),
// JCB                     ("007","Jcb", "3566111111111113"),
// MAESTRO_UKDOM           ("024","MaestroUKDomestic", "6759411100000008"),              // no issue num required
// MAESTRO_UKDOM_1DIGITREQ ("024","MaestroUKDomestic1", "6759560045005727054"), // REQUIRES one digit issue number
// MAESTRO_UKDOM_2DIGITREQ ("024","MaestroUKDomestic2", "5641821111166669"),    // REQUIRES tow digit issue number
// MAESTRO_INT_1           ("024","MaestroInt1", "50339619890917"),
// MAESTRO_INT_2           ("024","MaestroInt2", "586824160825533338");
// *
// *
// */
//
//import com.englishtown.enumpack.GatewayType;
//import com.englishtown.enumpack.PaymentFlowStatus;
//import com.englishtown.enumpack.TestCard;
//import com.englishtown.newhouse.apicore.BasePaymentGatewayApiSpec;
//import com.englishtown.newhouse.apicore.dataprovider.ApiDataProvider;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import static io.restassured.RestAssured.given;
//
//
//public class CyberSourceAllCardsSpec extends BasePaymentGatewayApiSpec  {
//    public static final Logger logger = LoggerFactory.getLogger(CyberSourceAllCardsSpec.class);
//
//
//    @BeforeClass
//    protected void setupBeforeClass(){
//        logger.info("@ Before Class ...!");
//        setupTestBeanDataAndSpec();
//    }
//
//    /**
//     * @testRestApi ***
//     * inherited test check Amex card so will add the rest of the tests below
//     *
//     */
//
//    @Test(dataProvider = "allTestCards", dataProviderClass = ApiDataProvider.class, threadPoolSize = 13, invocationCount = 1, timeOut = 120000 )
//    void TestAllCards(TestCard testCard){
//        logger.info("\n\n\t\tTestAllCards...!-> ["+testCard+"] <-!\n\n" );
//        setupTestBeanDataAndSpec(CYBERSOURCE_VISA_JSON, GatewayType.CYBERSOURCE, "BR",
//                testCard, expectedResponseCode, PaymentFlowStatus.SUCCESS, 11.99f);
//
//        defaultPostSpec();
//    }
//
//
//    @AfterClass
//    protected void teardownAfterClass(){
//        logger.info("@ After Class ...!");
//    }
//
//
//    /**
//     * Each test should set this up
//     * Defaults  expectedContentType = "JSON"; expectedResponseCode=200 isSucceed=true expectedError=null;
//     */
//    @Override
//    public void setupTestBeanDataAndSpec() {
//        logger.info("Setup Cybersource Amex test data amount 0");
//        setupTestBeanDataAndSpec(CYBERSOURCE_VISA_JSON, GatewayType.CYBERSOURCE, "BR",
//                TestCard.AMEX, expectedResponseCode, PaymentFlowStatus.SUCCESS, 0f);
//    }
//
//
//
//}
//
//
//
//
//
//
//
///**
// *
// *
// *
// @Test
// public void testCyberSourceMasterCard1(){
// logger.info("Setup CyberSourceMasterCard 1...!");
// setupTestBeanDataAndSpec(CYBERSOURCE_VISA_JSON, GatewayType.CYBERSOURCE, "BR",
// TestCard.MASTERCARD_1, expectedResponseCode, expectedIsSucceed, expectedError, 0.0f);
//
// defaultPostSpec();
// }
//
// @Test
// public void testCyberSourceMasterCard2(){
// logger.info("Setup CyberSourceMasterCard 2 ...!");
// setupTestBeanDataAndSpec(CYBERSOURCE_VISA_JSON, GatewayType.CYBERSOURCE, "BR",
// TestCard.MASTERCARD_2, expectedResponseCode, expectedIsSucceed, expectedError, 0.0f);
// defaultPostSpec();
// }
//
// @Test
// public void testCyberSourceVisaQA(){
// logger.info("Setup testCyberSourceVisaQA  ...!");
// setupTestBeanDataAndSpec(CYBERSOURCE_VISA_JSON, GatewayType.CYBERSOURCE, "BR",
// TestCard.VISA_QA, expectedResponseCode, expectedIsSucceed, expectedError, 0.0f);
//
// defaultPostSpec();
// }
//
// @Test
// public void testCyberSourceDine(){
// logger.info("Setup testCyberSourceDine  ...!");
// setupTestBeanDataAndSpec(CYBERSOURCE_VISA_JSON, GatewayType.CYBERSOURCE, "BR",
// TestCard.DINE, expectedResponseCode, expectedIsSucceed, expectedError, 0.0f);
//
// defaultPostSpec();
// }
//*/
//
//// load base test data from file
//        /*jsonFileName        = CYBERSOURCE_VISA_JSON;
//        expectedGatewayType = "Cybersource";
//        expectedResponseCtr = "BR";
//        reqBean = RestUtil.getExtraInfoReqBeanFromJsonFile(getTestDataFile(jsonFileName));
//        // set test specific data
//        reqBean.extraInfo.setCcCardType(TestCard.AMEX.getCardCode());
//        reqBean.extraInfo.setCcNumber(TestCard.AMEX.getCardNumber()) ;
//
//        initSpecCommerceApi(reqBean);
//        initResponseSpecBuyWithCardCommerceApi(ContentType.JSON, expectedResponseCode, expectedIsSucceed, expectedError,
//                expectedResponseCtr, expectedGatewayType, reqBean.getAmount());*/
