//package com.englishlive.tests.newhouse.apitest.testsuite.unit.archive.commerce;
///**
// * Test PaymentTech direct debit / SEPA
// *https://jira.eflabs.io/browse/SAND-4713
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
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
///// NOTE: not working yet Dec 2017 : (412) Precondition Failed. on the response
//
//public class PaymentTechRestApiTest extends BasePaymentGatewayApiSpec {
//    public static final Logger logger = LoggerFactory.getLogger(PaymentTechRestApiTest.class);
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
//        logger.info("Setup PAYMENTTECH test data amount 11.99");
//        /*setupTestBeanDataAndSpec(PAYMENTTECH_JSON, GatewayType.PAYMENTTECH, "UK",
//                null, expectedResponseCode, expectedIsSucceed, expectedError, 11.99f);*/
//
//        jsonFileName        = PAYMENTTECH_JSON;
//        expectedGatewayType = "Paymentech";
//        expectedResponseCtr = "FR";
//        reqBean = RestUtil.getExtraInfoReqBeanFromJsonFile(getTestDataFile(jsonFileName));//payTechReqBean);
//
//        initSpecCommercePayTecApi(reqBean); //payTechReqBean);
//        //initResponseSpecPayTechApi(ContentType.JSON, expectedResponseCode, expectedIsSucceed, expectedError, expectedResponseCtr, expectedGatewayType, payTechReqBean.getAmount());
//        initResponseSpecCommerceApi(ContentType.JSON, expectedResponseCode, PaymentFlowStatus.SUCCESS,
//                                     expectedResponseCtr, expectedGatewayType, reqBean.getAmount());
//       //(ContentType contentType, int expectedResponseCode , PaymentFlowStatus flowStatus, String expectedResponseCtr, String expectedGatewayType, float amount)
//
//    }
//
//
//}
