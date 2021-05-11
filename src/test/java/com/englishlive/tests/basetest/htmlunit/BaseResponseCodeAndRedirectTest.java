package com.englishlive.tests.basetest.htmlunit;

/**
 * Created by nikol.marku on 30/06/2016.
 *
 * Check response code and URL is redirected
 *
 */
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WebClientResponseHelper;
import com.englishtown.tests.core.SimpleBaseTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.Is.is;



public abstract class BaseResponseCodeAndRedirectTest extends SimpleBaseTest{ //extends BaseHtmlUnitDriverConfig{
    private static final Logger logger = LoggerFactory.getLogger(BaseResponseCodeTest.class);

    protected int expectedResponseCode ;      //  = 301; // test set this up
    protected int responseCode;               //  current response code
    protected String urlRedirectedContains ;  // = "/englishcenters.ef.com/xxxxx";


    @Test
    public void checkResponseCode() {
        AssertHelper.assertThat("Response Code is not ["+expectedResponseCode+"] ...!", responseCode, is(expectedResponseCode));
    }

    // there are few redirects before to get here ... and test will fails as it will get only the first url redirect
    // and if you set it to follow response code will be 404 ... and not the first 301 one
//    @Test (dependsOnMethods = "checkResponseCode" )
//    public void urlRedirectedContains() {
//        // need to open url again with isRedirectEnabled = true to get last redirect
//        WebClientResponseHelper.getHttpURLConnectionResponseCode(testUrl, true);
//        logger.info("currentUrl : "+WebClientResponseHelper.currentUrl);
//        AssertHelper.assertThat("URL is not redirected to the expected URL ...!",
//                WebClientResponseHelper.currentUrl, containsString(urlRedirectedContains));
//    }

}
