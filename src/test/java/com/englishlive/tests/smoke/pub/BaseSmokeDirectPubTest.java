package com.englishlive.tests.smoke.pub;

/**
 * Smoke test for Home pages  :  DE, FR, IT, JA, GB
 * pub1 and pub2
 */

import com.englishlive.tests.smoke.SmokeDataProvider;
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WebClientResponseHelper;
import com.englishtown.pages.core.BasePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import static org.hamcrest.core.Is.is;

public abstract class BaseSmokeDirectPubTest {

    private static final Logger logger = LoggerFactory.getLogger(BaseSmokeDirectPubTest.class);
    //protected int testResponseCode = -1;
    protected boolean isPub3 = false;
    protected boolean isPub4 = false; // set this to true to run on pub 4
    protected boolean isQA2 = false;

    protected long startTime;
    protected long endTime;

    @BeforeTest  // 1* runs before class annotation
    public void setUp() {
        logger.info("setUp beforeTest ...!");
        startTime = System.currentTimeMillis();
        logger.info("Start Time is : " + startTime);
    }

    @Test(dataProvider = "Pub3TestUrls", dataProviderClass = SmokeDataProvider.class, threadPoolSize = 8, invocationCount = 1, timeOut = 25000)
    void checkPubResponseCode(String country, String pageUrl) {
        int testResponseCode = -1;
        if (isPub3) {
            logger.info("Test pub 3 url [{}]", pageUrl);   //["+pageUrl+"]"
        } else if (isPub4) {
            logger.info("Test pub 4 url [{}]", pageUrl);
            pageUrl = pageUrl.replace("10.162.82.101", "10.162.66.101");
        } else if (isQA2) {
            logger.info("Test QA2 url [{}]", pageUrl);
            pageUrl = pageUrl.replace("etcqpub3", "etcqqa2");
        }
        logger.info("Check Country [" + country + "] response code for URL [" + pageUrl + "]");
        String errorString = "Error:500:[";

        WebClientResponseHelper webClientResponseHelper = new WebClientResponseHelper();

        testResponseCode = webClientResponseHelper.getHttpURLConnectionResponseCodeFailIfContentError500(pageUrl, false, errorString);                          //WebClientResponseHelper.getHttpURLConnectionResponseCodeFailIfContentError500(pageUrl, false, errorString); //getHttpURLConnectionResponseCode(pageUrl, false);

        if (testResponseCode == -1) {
            BasePage.failTest(" No response code received from get request for url : " + pageUrl);
        } else {
            AssertHelper.assertThat("["+testResponseCode+"] ; Response code is not 200 ...! URL ["+pageUrl+"]", testResponseCode, is(200));
            /*if(testResponseCode ==200 || testResponseCode ==301 || testResponseCode ==302){
                logger.info("["+testResponseCode+"] Response code OK, it is one of => [200, 301, 302] : url :"+pageUrl);
            }else{
                BasePage.failTest("["+testResponseCode+"] Response code is not in this list => [200, 301, 302] : url : "+pageUrl);
            }*/
        }
    }

    @AfterTest
    public void tearDown() {
        logger.info("tearDown AfterTest ...!");
        calculateTestEndTime();
    }

    //dupe at simpleTest
    protected void calculateTestEndTime() {
        endTime = System.currentTimeMillis();
        logger.info("end Time is : " + endTime);
        float totalTime = endTime - startTime;
        logger.info("Total Time is : " + totalTime + " milliseconds  ...!");
        NumberFormat format = new DecimalFormat("#.####");
        logger.info("Total Time is :" + format.format(totalTime / 1000) + " Seconds ...!");
    }

}


