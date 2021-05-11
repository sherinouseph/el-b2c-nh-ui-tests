package com.englishtown.newhouse.apicore;
/**
 * Created by nikol.marku on 02-Oct-17.
 * Commerce api
 * Base payment getway tests
 * http://paymentgatewayproject.vagrant.f8/swagger/#!/PaymentGateway/ApiPaymentGatewayProcessStandaloneCapturePost
 *
 *  * Test will check :
         .statusCode(expectedResponseCode)
         .contentType(expectedContentType)
         .body("IsSucceed",equalTo(expectedIsSucceed))
         .body("Error",equalTo(expectedError))
         .body("ExtraInfo.country",equalTo(expectedResponseCtr))
         .body("FlowUniqueCode",not(isEmptyOrNullString()))
         .body("RefNumber",not(isEmptyOrNullString()))
         .body("GatewayUniqueCode",not(isEmptyOrNullString()))
         .body("GatewayType",equalTo(expectedGatewayType));
         responseSpecBuilder.expectBody("Amount",is((float)amount));
         if payU only  responseSpecBuilder.expectBody("ExtraInfo.responseCode", equalTo("APPROVED"));


 _cardTypeMapping.Add("001", "Visa");
 _cardTypeMapping.Add("002", "MC");
 _cardTypeMapping.Add("003", "Amex");
 _cardTypeMapping.Add("004", "Disc");
 _cardTypeMapping.Add("005", "Dine");
 _cardTypeMapping.Add("006", "Blan");
 _cardTypeMapping.Add("007", "Jcb");
 _cardTypeMapping.Add("014", "Ecmc");
 _cardTypeMapping.Add("021", "Jal");
 _cardTypeMapping.Add("024", "MaestroUKDomestic");
 _cardTypeMapping.Add("031", "Delta");
 _cardTypeMapping.Add("033", "Elec");
 _cardTypeMapping.Add("034", "Dank");
 _cardTypeMapping.Add("036", "Bleue");
 _cardTypeMapping.Add("037", "Casi");
 _cardTypeMapping.Add("042", "MAES");
 _cardTypeMapping.Add("043", "Sant");
 _cardTypeMapping.Add("050", "Hiper");
 _cardTypeMapping.Add("054", "Elo");

 */


import com.englishtown.enumpack.GatewayType;
import com.englishtown.enumpack.PaymentFlowStatus;
import com.englishtown.enumpack.TestCard;
import com.englishtown.newhouse.apicore.bean.ExtraInfoReqBean;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.text.IsEmptyString.isEmptyOrNullString;
// paytech ... error 412
// TODO refactor ... specs could be shorter

public abstract class BasePaymentGatewayApiSpec extends BaseSpecSuite {
    public static final Logger logger = LoggerFactory.getLogger(BasePaymentGatewayApiSpec.class);



    @Test
    public void testRestApiResponseContent(){
        defaultPostSpec();
    }

    /**
     * Setup request data
     * @param myJsonObj
     */
    public void initSpecCommerceApi( Object myJsonObj){
        requestSpecBuilder    = new RequestSpecBuilder();
        responseSpecBuilder   = new ResponseSpecBuilder();
        requestSpecBuilder.setContentType(ContentType.JSON); //
        requestSpecBuilder.setBaseUri(commerceRestApi);
        requestSpecBuilder.addHeader("username", reqHeaderUsername);
        requestSpecBuilder.addHeader("hostname", reqHeaderHostname);

        requestSpecification = requestSpecBuilder
                                                .setBody(myJsonObj)
                                                .addFilter(new ResponseLoggingFilter())
                                                .addFilter(new RequestLoggingFilter())
                                                .build();
        //logger.info("\nInit Spec CommerceApi is set to :"+requestSpecBuilder);
    }

    public void initSpecCommercePayTecApi( Object myJsonObj){
        //initReqAndResponseSpecBuilder(); to run in parallel this need to be commented
        requestSpecBuilder    = new RequestSpecBuilder();
        responseSpecBuilder   = new ResponseSpecBuilder();
        requestSpecBuilder.setContentType(ContentType.JSON); //
        requestSpecBuilder.setBaseUri(commerceRestApi);
        requestSpecBuilder.addHeader("username", reqHeaderUsername);//"paymentgateway");
        requestSpecBuilder.addHeader("hostname", reqHeaderHostname);//"b2cLondonAutoTeam");
//        requestSpecBuilder.addHeader("Password", "payment123");//"b2cLondonAutoTeam");
        requestSpecification = requestSpecBuilder
                .setBody(myJsonObj)
                .addFilter(new ResponseLoggingFilter())
                .addFilter(new RequestLoggingFilter())
                .build();
        //logger.info("\nInit Spec CommerceApi is set to :"+requestSpecBuilder);
    }

    /**
     * Removed  replace with initResponseSpecBuyWithCardCommerceApi
     * @param contentType
     * @param expectedResponseCode
     * @param expectedIsSucceed
     * @param expectedError
     * @param expectedResponseCtr
     * @param expectedGatewayType
     * @param amount
     *
    public void initResponseSpecPayTechApi(ContentType contentType, int expectedResponseCode ,
                                            boolean expectedIsSucceed, String expectedError, String expectedResponseCtr,
                                            String expectedGatewayType, float amount){
        logger.info("Check Response ");
        responseSpecBuilder.expectContentType(contentType); // ContentType.JSON
        responseSpecBuilder.expectStatusCode(expectedResponseCode);
        responseSpecBuilder.expectBody("IsSucceed",equalTo(expectedIsSucceed));
        responseSpecBuilder.expectBody("Error",equalTo(expectedError));
        responseSpecBuilder.expectBody("ExtraInfo.country",equalTo(expectedResponseCtr));

        if(StringUtils.equals(payTechReqBean.getGatewayType(), "Paymentech")) {
            responseSpecBuilder.expectBody("ExtraInfo.responseCode", equalTo("APPROVED"));
        }

        responseSpecBuilder.expectBody("FlowUniqueCode",not(isEmptyOrNullString()));
        responseSpecBuilder.expectBody("RefNumber",not(isEmptyOrNullString()));
        responseSpecBuilder.expectBody("GatewayUniqueCode",not(isEmptyOrNullString()));
        responseSpecBuilder.expectBody("GatewayType",equalTo(expectedGatewayType));
        responseSpecBuilder.expectBody("Amount",is((float)amount));
        //"FlowStatus": "RedirectWait",
        responseSpecBuilder.expectBody("FlowStatus", containsString("Success"));
        responseSpecification = responseSpecBuilder.build();
        //logger.info("\nInit Response Spec CommerceApi responseSpecification:"+responseSpecification.log());
    }*/



    /**
     * Check the response for the following content
     * @param contentType
     * @param expectedResponseCode
     * @param flowStatus
     * @param
     * @param expectedResponseCtr
     * @param expectedGatewayType
     */
    public void initResponseSpecCommerceApi(ContentType contentType, int expectedResponseCode ,
                                            PaymentFlowStatus flowStatus, String expectedResponseCtr,
                                            String expectedGatewayType, float amount){
        logger.info("Check Response ");
        responseSpecBuilder.expectContentType(contentType);
        responseSpecBuilder.expectStatusCode(expectedResponseCode);

        if(StringUtils.equals(reqBean.getGatewayType(), "PayU")) {
            responseSpecBuilder.expectBody("extraInfo.responseCode", equalTo("APPROVED"));
        }

        responseSpecBuilder.expectBody("extraInfo.country",equalTo(expectedResponseCtr));
        responseSpecBuilder.expectBody("flowUniqueCode",not(isEmptyOrNullString()));
        responseSpecBuilder.expectBody("refNumber",not(isEmptyOrNullString()));
        responseSpecBuilder.expectBody("gatewayUniqueCode",not(isEmptyOrNullString()));
        responseSpecBuilder.expectBody("gatewayType",equalTo(expectedGatewayType));
        responseSpecBuilder.expectBody("amount",is((float)amount));
        responseSpecBuilder.expectBody("flowStatus", containsString(flowStatus.getFlowStatus()));   //"FlowStatus": "RedirectWait", "Success"

        responseSpecification = responseSpecBuilder.build();
        //logger.info("\nInit Response Spec CommerceApi responseSpecification:"+responseSpecification.log());
    }


    /**
     * Setup test data
     * @param jsonFileName   e.g CYBERSOURCE_VISA_JSON
     */


    /***
     * Setup request bean and set request spec and response
     * @param jsonFileName
     * @param gatewayType
     * @param expectedResponseCtr
     * @param testCard
     * @param flowStatus
     * @param amount
     */
    public void setupTestBeanDataAndSpec(String jsonFileName, GatewayType gatewayType, String expectedResponseCtr,
                                         TestCard testCard, int expectedResponseCode,
                                         PaymentFlowStatus flowStatus, float amount) {
        reqBean = new ExtraInfoReqBean();
        reqBean = RestUtil.getExtraInfoReqBeanFromJsonFile(getTestDataFile(jsonFileName));
        if(null != testCard) {
            reqBean.extraInfo.setCcCardType(testCard.getCardCode());
            reqBean.extraInfo.setCcNumber(testCard.getCardNumber());
        }
        reqBean.setAmount(amount);

        initSpecCommerceApi(reqBean);
        initResponseSpecCommerceApi(ContentType.JSON, expectedResponseCode, flowStatus,
                expectedResponseCtr, gatewayType.getGatewayType(), amount);
    }


}
