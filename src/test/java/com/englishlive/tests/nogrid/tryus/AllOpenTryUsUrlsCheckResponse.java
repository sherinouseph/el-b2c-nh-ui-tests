package com.englishlive.tests.nogrid.tryus;
/**
 * open url click to
 *
 *
 */

import com.englishtown.dataprovider.UrlDataProvider;
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.UrlMapper;
import com.englishtown.helpers.WebClientResponseHelper;
import com.englishtown.tests.core.SimpleBaseTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.core.Is.is;


public class AllOpenTryUsUrlsCheckResponse extends SimpleBaseTest { //BaseTestHelper{
    private static final Logger logger = LoggerFactory.getLogger(AllOpenTryUsUrlsCheckResponse.class);

    private String testUrl;


    @BeforeClass
    private void setup() {
    }

    @Test (dataProvider = "tryusPinkBtn", dataProviderClass = UrlDataProvider.class,threadPoolSize = 5, invocationCount = 1, timeOut = 11000 )
    public void openUrl_CheckResponse200(String desc, String url) {
        WebClientResponseHelper webClientResponseHelper = new WebClientResponseHelper();
        webClientResponseHelper.setJavaScriptEnabled(false);                    //WebClientResponseHelper.isJavaScriptEnabled = false;
        webClientResponseHelper.setThrowExceptionOnFailingStatusCode(false);    //WebClientResponseHelper.isThrowExceptionOnFailingStatusCode=false;
        testUrl = getBASE_URL()+url;
        if(testUrl.contains("englishtown")){
           // BASE_URL =BASE_URL+"www";
            testUrl = UrlMapper.mapBaseUrlToEtown(testUrl, getBASE_URL());
        }
        logger.info("Open URL and check repsponse 200 , URL :"+testUrl);
        int testResponseCode = webClientResponseHelper.getWebClientResponseCode(testUrl);      //  WebClientResponseHelper.getWebClientResponseCode(testUrl);
        logger.info("testResponseCode is ["+testResponseCode+"]");
        AssertHelper.myAssertThat(null,testUrl+ ": Response Code is not ["+200+"] ...!",testResponseCode,
                is(200), false);

    }

//    @AfterClass
//    void tearDownNikol(){
//        endTime = System.currentTimeMillis();
//        System.out.println("end Time is : " + endTime);
//        long totalTime = endTime - startTime ;
//        System.out.println("Total Time is : " + totalTime+" milliseconds  ...!");
//        NumberFormat format = new DecimalFormat("#.####");
//        System.out.println("Total Time is :"+format.format(totalTime/1000)+" Seconds ...!");
//    }


}