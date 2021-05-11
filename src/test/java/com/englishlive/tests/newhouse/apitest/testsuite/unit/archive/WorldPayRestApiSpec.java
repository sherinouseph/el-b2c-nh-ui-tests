//package com.englishlive.tests.newhouse.apitest.testsuite.unit.archive.commerce;
///**
// * Test worldpay
// *
// * Test will check :
// .statusCode(expectedResponseCode)
// .contentType(expectedContentType)
// .body("IsSucceed",equalTo(expectedIsSucceed))
// .body("Error",equalTo(expectedError))
// .body("ExtraInfo.country",equalTo(expectedResponseCtr))
// .body("FlowUniqueCode",not(isEmptyOrNullString()))
// .body("RefNumber",not(isEmptyOrNullString()))
// .body("GatewayUniqueCode",not(isEmptyOrNullString()))
// .body("GatewayType",equalTo(expectedGatewayType));
// *
// */
//
//import com.englishtown.enumpack.PaymentFlowStatus;
//import com.englishtown.newhouse.apicore.BasePaymentGatewayApiSpec;
//import com.englishtown.newhouse.apicore.RestUtil;
//import io.restassured.http.ContentType;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.testng.annotations.*;
//
//
//// fail Jan 2017
//
///**
// *
// {
// "code": "Error_System",
// "message": "The remote server returned an error: (401) Unauthorized."
// }
// */
//
//
//public class WorldPayRestApiSpec extends BasePaymentGatewayApiSpec {
//    public static final Logger logger = LoggerFactory.getLogger(WorldPayRestApiSpec.class);
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
//    /**
//     * Each test should set this up
//     * Defaults  expectedContentType = "JSON"; expectedResponseCode=200 isSucceed=true expectedError=null;
//     */
//    @Override
//    public void setupTestBeanDataAndSpec() {
//        jsonFileName        = WORLDPAY_JSON;
//        expectedGatewayType = "Worldpay";
//        expectedResponseCtr = "FR";
//        reqBean = RestUtil.getExtraInfoReqBeanFromJsonFile(getTestDataFile(jsonFileName));
//        initSpecCommerceApi(reqBean);
//        initResponseSpecCommerceApi(ContentType.JSON, expectedResponseCode, PaymentFlowStatus.SUCCESS,
//                expectedResponseCtr, expectedGatewayType, reqBean.getAmount());
//
//    }
//
//
//}