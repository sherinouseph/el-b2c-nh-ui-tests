package com.englishlive.tests.basetest.htmlunit;
/**
 * Created by nikol.marku on 16/02/2016.
 * Base test to check the response code
 *
 */

import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WebClientResponseHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


import static org.hamcrest.core.Is.is;


public abstract class BaseResponseCodeTest extends BaseHtmlUnitDriverTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseResponseCodeTest.class);

    protected WebClientResponseHelper webClientResponseHelper;

    /**
     * use WebClient
     */
    @Test
    public void openUrl_CheckResponse200() {
        webClientResponseHelper = new WebClientResponseHelper();
        webClientResponseHelper.setJavaScriptEnabled(false); //    WebClientResponseHelper.isJavaScriptEnabled = false;
        webClientResponseHelper.setThrowExceptionOnFailingStatusCode(false);        //WebClientResponseHelper.isThrowExceptionOnFailingStatusCode=false;
        testResponseCode = webClientResponseHelper.getWebClientResponseCode(htmlUnitTestUrl) ;         //WebClientResponseHelper.getWebClientResponseCode(htmlUnitTestUrl);
        webClientResponseHelper = null;
        logger.info("testResponseCode is ["+testResponseCode+"]");
        AssertHelper.myAssertThat(getHtmlUnitDriver(), "Response Code is not ["+RESPONSE_CODE_200+"] ...!",testResponseCode,
                                                                                          is(RESPONSE_CODE_200), false);
    }

}

