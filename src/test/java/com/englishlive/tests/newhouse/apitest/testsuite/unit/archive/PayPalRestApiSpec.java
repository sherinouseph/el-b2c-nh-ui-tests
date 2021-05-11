//package com.englishlive.tests.newhouse.apitest.testsuite.unit.archive.commerce;
///**
// * Test PayPal
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
//
//// FAIL Jan 2018
///*{
//  "code": "Error_PaymentGatewayReject",
//          "message": "PayPal SetExpressCheckout reject, id:6fca23eefc9c4337881e813d5a01966f"
//          }
//          {"country":"US","ccFirstName":"Fred","ccLastName":"Feng","ccNumber":"411234******4113","accountType":"CreditCard","ccCardVerifyNum":"****","ccExpYear":"2024","ccExpMonth":"2",
//          "returnUrl":"https://local.englishtown.com/checkout/member/","cancelUrl":"https://local.englishtown.com/checkout/member/",
//          "payPalConfirmUrl":"https://local.englishtown.com/checkout/member/","signature":"Signed","errors":"||code:10002|short-msg:Security error|long-msg:Security header is not valid"}
//
//          */
//public class PayPalRestApiSpec extends BasePaymentGatewayApiSpec {
//    public static final Logger logger = LoggerFactory.getLogger(PayPalRestApiSpec.class);
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
//        jsonFileName        = PAYPAL_JSON; //WORLDPAY_JSON;
//        expectedGatewayType = "PayPal";//?paypal
//        expectedResponseCtr = "US";
//        reqBean = RestUtil.getExtraInfoReqBeanFromJsonFile(getTestDataFile(jsonFileName));
//        initSpecCommerceApi(reqBean);
//        initResponseSpecCommerceApi(ContentType.JSON, expectedResponseCode, PaymentFlowStatus.SUCCESS,
//                expectedResponseCtr, expectedGatewayType, reqBean.getAmount());
//
//    }
//
//
//}
