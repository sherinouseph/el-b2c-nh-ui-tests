//package com.englishlive.tests.newhouse.apitest.testsuite.unit.archive.commerce;
///**
// * Test PayU
// *
// *
// */
//
//import com.englishtown.enumpack.PaymentFlowStatus;
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
//// FAIL Jan 2018
//
///**
// {
//     "code": "Error_PaymentGatewayReject",
//     "message": "Failed to create token.property: identificationNumber, message: size must be between 4 and 20\n"
// }
// */
//
//public class PayURestApiSpec extends BasePaymentGatewayApiSpec {
//    public static final Logger logger = LoggerFactory.getLogger(PayURestApiSpec.class);
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
//        jsonFileName        = PAYU_JSON;
//        expectedGatewayType = "PayU";
//        expectedResponseCtr = "BR";
//        reqBean = RestUtil.getExtraInfoReqBeanFromJsonFile(getTestDataFile(jsonFileName));
//        initSpecCommerceApi(reqBean);
//        initResponseSpecCommerceApi(ContentType.JSON, expectedResponseCode, PaymentFlowStatus.SUCCESS,
//                expectedResponseCtr, expectedGatewayType, reqBean.getAmount());
//
//    }
//
//
//}