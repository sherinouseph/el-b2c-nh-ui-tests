package com.englishlive.tests.redirect.https.core;

/**
 *
 *
 */

import com.englishtown.dataprovider.bin.TestResponseBean;
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.UrlMapper;
import com.englishtown.helpers.WebClientResponseHelper;
import com.englishtown.pages.core.BasePage;
import com.englishtown.tests.core.SimpleBaseTest;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.core.Is.is;


public abstract class BaseHttpsRedirectTest extends SimpleBaseTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseHttpsRedirectTest.class);

    protected long startTime;
    protected long endTime;


    @BeforeTest
    public void setUp() {
        logger.info("setUp beforeTest ...!");
        startTime = System.currentTimeMillis();
        logger.info("Start Time is : " + startTime);
    }

    public void checkUrlResponseIs_301_and_Https(TestResponseBean testResponseBean) {
        String errorString = "Error:500:[";
        String testUrl = "";
        WebClientResponseHelper webClientResponseHelper = new WebClientResponseHelper();

        String baseUrl = getBASE_URL().replace("https","http"); // AS WE NEED TO GO FROM HTTP TO HTTPS
        if("qa".contains(getENVIRONMENT())) {
            if(StringUtils.contains(testResponseBean.getUrl(), "www.")) {
                testResponseBean.setUrl(testResponseBean.getUrl().replace("www.", ""));
            }
            testResponseBean.setUrl(UrlMapper.mapEliveBaseUrlToEtownBaseUrl(baseUrl) +"."+ testResponseBean.getUrl());
            testResponseBean.setUrlRedirectTo(UrlMapper.mapEliveBaseUrlToEtownBaseUrl(baseUrl).replace("http:","https:") + testResponseBean.getUrlRedirectTo().replace("www.", "."));
        } else { // live url
            testResponseBean.setUrl(baseUrl+ testResponseBean.getUrl());
            testResponseBean.setUrlRedirectTo(getBASE_URL()+testResponseBean.getUrlRedirectTo());
        }
        testResponseBean.setUrl(testResponseBean.getUrl());

        testResponseBean = webClientResponseHelper.getTestResponseBean(testResponseBean,
                                                        testResponseBean.getCountryFromLangAndCtr(), true, errorString);
        if (testResponseBean == null) {
            BasePage.failTest(" [-NULL-] No response Object received from get request for url : " + testResponseBean.getUrl());
        } else {
            AssertHelper.assertThat("Response code is not the expected one ...!", testResponseBean.getResponseCode(),
                    is(testResponseBean.getExpectedResponseCode()));
            /*if("qa".contains(getENVIRONMENT())) {                String qaRedirectUrl = UrlMapper.mapELiveBaseUrlToEtownBaseUrl(baseUrl) + "." + testResponseBean.getUrlRedirectTo();                testResponseBean.setUrlRedirectTo(qaRedirectUrl);            } else {                testResponseBean.setUrlRedirectTo(getBASE_URL()+testResponseBean.getUrlRedirectTo());            }*/
            AssertHelper.assertThat("Current URL is not expected HTTPS one ...! country["+
                    testResponseBean.getCountryFromLangAndCtr()+"]", testResponseBean.getCurrentUrl(),
                    startsWith(testResponseBean.getUrlRedirectTo()));
            // /* no500BodyErros if(testResponseBean.is500ErrorOnResponseBody()) {   AssertHelper.assertThat("Page Content contains error ...!", testResponseBean.getErrorSubString(), not(containsString(errorString.toLowerCase())));  }else      logger.info("No errors in response body ...!");      }*/
        }
    }


    @AfterTest
    public void tearDown() {
        logger.info("tearDown AfterTest ...!");
        calculateTestEndTime();
    }




}



//dupe at simpleTest
    /*protected void calculateTestEndTime() {
        endTime = System.currentTimeMillis();
        logger.info("end Time is : " + endTime);
        float totalTime = endTime - startTime;
        logger.info("Total Time is : " + totalTime + " milliseconds  ...!");
        NumberFormat format = new DecimalFormat("#.####");
        logger.info("Total Time is :" + format.format(totalTime / 1000) + " Seconds ...!");
    }*/


/**
 *
 if(getENVIRONMENT().contains("qa")){
 // change url for qa from e.g https://englishlive.ef.com/de-de to https://qa-englishlive.ef.com/de-de
 String tmpExpectedUrl = testResponseBean.getUrlRedirectTo();
 tmpExpectedUrl = tmpExpectedUrl.replace("://", "://qa-");
 testResponseBean.setUrlRedirectTo(tmpExpectedUrl);
 logger.info("Is QA UrlRedirectTo is :"+testResponseBean.getUrlRedirectTo());
 }
 *
 */

