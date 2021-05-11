package com.englishlive.tests.redirect.https.core;

/**
 * https://jira-bos.englishtown.com/browse/SAND-3271
 *
 */
import com.englishtown.dataprovider.HttpsRedirectDataProvider;
import com.englishtown.dataprovider.bin.TestResponseBean;
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.TestEnvironment;
import com.englishtown.helpers.WebClientResponseHelper;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.pages.core.BasePage;
import com.englishtown.tests.core.BaseTestHelper;
import com.englishtown.tests.core.SimpleBaseTest;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.core.Is.is;


public abstract class BaseHttps extends SimpleBaseTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseHttps.class);

    protected long startTime;
    protected long endTime;


    @BeforeTest
    public void setUp() {
        logger.info("setUp beforeTest ...!");
        startTime = System.currentTimeMillis();
        logger.info("Start Time is : " + startTime);
    }

    @Test(dataProvider = "httpsRedirect", dataProviderClass = HttpsRedirectDataProvider.class)//, threadPoolSize = 8, invocationCount = 1, timeOut = 25000)
    void checkUrlResponseIs_301__https(TestResponseBean testResponseBean) {
        String errorString = "Error:500:[";
                                                                                                                        //testResponseBean.setUrlRedirectTo(getBASE_URL()+testResponseBean.getUrl());
        String baseUrl = getBASE_URL().replace("https","http");
        String testUrl = baseUrl+testResponseBean.getUrl();
        String expectedUrl = testResponseBean.getUrlRedirectTo();
        if(StringUtils.contains(testUrl, "emailenglish.net") || StringUtils.contains(testUrl, "efenglishtown.com")
                                                             || StringUtils.contains(testUrl, "englishtown.com") ) {
            //if live ENV then url should have http://wwww. so need to add www.
            if(TestUtil.isEnvironment(getENVIRONMENT(), TestEnvironment.Live) ){
                testUrl = testUrl.replace("://", "://www.");
            }
            // if QA url should be qa. not qa-
            if(TestUtil.isEnvironment(getENVIRONMENT(), TestEnvironment.QA) ){
                testUrl = testUrl.replace("//qa-", "//qa.");
                String tmpUrlExpected = testResponseBean.getUrlRedirectTo();
                if (tmpUrlExpected.contains("//www.")) {
                    tmpUrlExpected = tmpUrlExpected.replace("//www.","//");
                }
                tmpUrlExpected = tmpUrlExpected.replace("https://","https://qa.");
                testResponseBean.setUrlRedirectTo(tmpUrlExpected);
            }
            logger.info("URL mapped to current environment ["+getENVIRONMENT()+"]; is now ["+testUrl+"]");
        }
        testResponseBean.setUrl(testUrl);

        WebClientResponseHelper webClientResponseHelper = new WebClientResponseHelper();
        //WebClientResponseHelper.getTestResponseBean...*
        testResponseBean = webClientResponseHelper.getTestResponseBean(testResponseBean,
                                                        testResponseBean.getCountryFromLangAndCtr(), true, errorString); //TestUtil.getCountryFromUrl(testUrl),
        if (testResponseBean == null) {
            BasePage.failTest(" [-NULL-] No response Object received from get request for url : " + testResponseBean.getUrl());
        } else {
            AssertHelper.assertThat("Response code is not the expected one ...!", testResponseBean.getResponseCode(),
                    is(testResponseBean.getExpectedResponseCode()));
            if(TestUtil.isEnvironment(getENVIRONMENT(), TestEnvironment.QA)) {
                String qaUrl = BaseTestHelper.changeLiveUrlToQaUrl(testResponseBean.getUrlRedirectTo(), getENVIRONMENT());
                testResponseBean.setUrlRedirectTo(qaUrl);
            }
            AssertHelper.assertThat("Current URL is not starting with HTTPS ...! ", testResponseBean.getCurrentUrl(), startsWith("https"));
            AssertHelper.assertThat("Current URL is not the expected URL ...! ", testResponseBean.getCurrentUrl(), containsString(testResponseBean.getUrlRedirectTo()));
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

