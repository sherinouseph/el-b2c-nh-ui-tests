//package com.englishlive.tests.redirect;
//
///**
//* Open a list of URLs check Response code 200 301 302
//*/
//
//import com.englishlive.tests.basetest.htmlunit.BaseHtmlUnitDriverConfig;
//import com.englishlive.tests.smoke.SmokeDataProvider;
//import com.englishtown.helpers.WebClientResponseHelper;
//import com.englishtown.pages.core.BasePage;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.testng.annotations.Test;
//// Vahid Pourahmary   not really… need ..?
//public class OpenUrlCheckResponseCodeTest extends BaseHtmlUnitDriverConfig {
//    private static final Logger logger = LoggerFactory.getLogger(OpenUrlCheckResponseCodeTest.class);
//    protected int expectedResponse = 200;
//
//    @Test(dataProvider = "301Urls", dataProviderClass = SmokeDataProvider.class,threadPoolSize = 10, invocationCount = 1, timeOut = 11000 )
//    void openUrlCheckResponseCode_200or301or302(String code, String pageUrl){
//        int testResponseCode = -1; //local
//        pageUrl = getBASE_URL()+pageUrl;
//        //  logger.info("Check response code for URL ["+pageUrl+"]");
//        WebClientResponseHelper webClientResponseHelper = new WebClientResponseHelper();
//        testResponseCode = webClientResponseHelper.getHttpURLConnectionResponseCode(pageUrl);    //WebClientResponseHelper.getHttpURLConnectionResponseCode(pageUrl);
//
//        if(testResponseCode == -1){
//            BasePage.failTest(" No response code received from request for url : "+pageUrl);
//        }else {
//            if(testResponseCode ==200 || testResponseCode ==301 || testResponseCode ==302){
//                logger.info(" Response code OK, it is one of => [200, 301, 302] : url : "+pageUrl);
//            }else{
//                BasePage.failTest(responseCode +" -> Response code is not in this list => [200, 301, 302] : url : "+pageUrl);
//            }
//        }           //        if(testResponseCode == -1){ BasePage.failTest(" No response code received from get request for url : "+pageUrl); }else { AssertHelper.assertThat("Response code is not the expected one ...!", testResponseCode, is(expectedResponse));   }
//    }
//
//
//}
//
//
