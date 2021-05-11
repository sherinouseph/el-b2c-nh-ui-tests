//package com.englishlive.tests.newhouse.apitest.testsuite.unit.archive.commerce.br;
///**
// * Test worldpay
// *
// *
// */
//
//import com.englishtown.newhouse.apicore.BasePaymentGatewayApiSpec;
//import com.englishtown.newhouse.apicore.RestUtil;
//import io.restassured.http.ContentType;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//
//import static io.restassured.RestAssured.given;
//
// // all added in one test
//public class CyberSourceVisaSpec extends BasePaymentGatewayApiSpec {
//    public static final Logger logger = LoggerFactory.getLogger(CyberSourceVisaSpec.class);
//
//
//    @BeforeClass
//    protected void setupBeforeClass(){
//        logger.info("@ Before Class ...!");
//        setupTestBeanDataAndSpec();
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
//        jsonFileName        = CYBERSOURCE_VISA_JSON;
//        expectedGatewayType = "Cybersource";
//        expectedResponseCtr = "BR";
//        reqBean = RestUtil.getExtraInfoReqBeanFromJsonFile(getTestDataFile(jsonFileName));
//
//        initSpecCommerceApi(reqBean);
//        initResponseSpecBuyWithCardCommerceApi(ContentType.JSON, expectedResponseCode, expectedIsSucceed, expectedError,
//                expectedResponseCtr, expectedGatewayType, reqBean.getAmount());
//
//    }
//
//
//}
