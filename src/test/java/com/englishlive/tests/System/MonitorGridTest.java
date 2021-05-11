//package com.englishlive.tests.System;
//
//import com.englishtown.helpers.AssertHelper;
//import com.englishtown.helpers.WebClientResponseHelper;
//import com.englishtown.tests.core.SimpleBaseTest;
//import com.gargoylesoftware.htmlunit.WebClient;
//import com.gargoylesoftware.htmlunit.WebClientOptions;
//import com.gargoylesoftware.htmlunit.WebResponse;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.testng.annotations.Test;
//
//import java.io.IOException;

//import java.time.LocalDateTime;
//
//import static org.hamcrest.core.Is.is;
//
///**
// * Created by nikol.marku on 06-Jul-17.
// */
//public class MonitorGridTest extends SimpleBaseTest{
//    private static final Logger logger = LoggerFactory.getLogger(MonitorGridTest.class);
//
//    private String url = "http://10.162.85.203:4444/grid/console";
//    private int delay = 6000;  //1 min
//
//
//    @Test
//    void monitorTCgrid200(){
//        testUrl = url;
//        int testResponseCode = 0;
//        WebClientResponseHelper webClientResponseHelper;
//
//        for(int i=1; i< 3; i++) {
//            sleep(2*delay);
//            logger.info("Time :" + LocalDateTime.now());
//
//            try {
//               /* webClientResponseHelper = new WebClientResponseHelper();
//                webClientResponseHelper.setJavaScriptEnabled(false);
//                webClientResponseHelper.setThrowExceptionOnFailingStatusCode(false);*/
//                logger.info("Open URL and check response 200 , URL :" + testUrl);
//                WebClient client = new WebClient();
//                testResponseCode = getResponseCode(client, testUrl); //testResponseCode = webClientResponseHelper.getWebClientResponseCode(testUrl);
//                webClientResponseHelper = new WebClientResponseHelper();
//                webClientResponseHelper.setJavaScriptEnabled(false);
//                webClientResponseHelper.setThrowExceptionOnFailingStatusCode(false);
//                logger.info("Open URL and check response 200 , URL :" + testUrl);
//                testResponseCode = webClientResponseHelper.getWebClientResponseCode(testUrl);
//                webClientResponseHelper = null;
//                logger.info("testResponseCode is [" + testResponseCode + "]");
//                AssertHelper.myAssertThat(null, testUrl + ": Response Code is not [" + 200 + "] ...!", testResponseCode,
//                        is(200), false);
//
//            }catch (Exception e){
//                webClientResponseHelper = null;
//                logger.error("Test Failed; Response is :"+testResponseCode+" ERROR :"+e.getMessage());
//            }
//        }
//
//    }
//

//    /**
//     * Get response code Using WebClient
//     * @param client
//     * @param url
//     * @return response code or -1
//     */
//    public int getResponseCode(WebClient client, String url){
//        int requestResponseCode = -1;
//        WebResponse webResponse = null;
//        try {
//            webResponse  = client.getPage(url).getWebResponse();
//            if(webResponse == null){
//                logger.info("Web response is NULL ...! will try again");
//                webResponse = client.getPage(url).getWebResponse();
//            }
//            requestResponseCode = webResponse.getStatusCode();
//            logger.info("["+url+"] Response Code  is :["+requestResponseCode+"]");
//
//        } catch (IOException e) {
//            //e.printStackTrace();
//            logger.error("IOException   Can't get response content ... IOException ...!"+e.getMessage());
//        }
//        catch (Exception e) {
//            // e.printStackTrace();
//            logger.error("Exception    Can't get response content ... Exception ...!"+e.getMessage());
//        }
//        return requestResponseCode;
//    }
//
//
//
//

//
//    /*@AfterClass
//    protected void testAfterClass(){
//        destroyDriver();
//    }*/

//
//}
