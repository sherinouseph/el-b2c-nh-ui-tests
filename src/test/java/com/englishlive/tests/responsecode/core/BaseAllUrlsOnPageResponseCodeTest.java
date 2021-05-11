package com.englishlive.tests.responsecode.core;
/**
 * Created by nikol.marku on 13/07/2016.
 * Get all the urls on a page and check response code less than 400
 */

import com.englishlive.tests.basetest.htmlunit.BaseHtmlUnitDriverTest;
import com.englishtown.helpers.WebClientResponseHelper;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.pages.core.BasePage;
import com.englishtown.tests.core.BaseTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import java.util.*;


public abstract class BaseAllUrlsOnPageResponseCodeTest extends BaseHtmlUnitDriverTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseAllUrlsOnPageResponseCodeTest.class);

    List<String> failedUrlList = new ArrayList<>();

    @Test(dataProvider = "getAllPageValidUrls")//, threadPoolSize = 10, invocationCount = 1, timeOut = 30000 )
    public void isResponseCodeLessThan400(String url) {
        //setup exclusions
        List<String> excludeUrlContainsList = Arrays.asList("/blog/","facebook.com","twitter.com","instagram.com","google.com");
        boolean isMatch = excludeUrlContainsList.stream().anyMatch(tmpMatch -> url.contains(tmpMatch) );
        WebClientResponseHelper webClientResponseHelper = new WebClientResponseHelper();

        try {
            setupWebClient(webClientResponseHelper);

            if(isMatch){
                logger.warn(" Ignore URLs containing any item of:"+excludeUrlContainsList.toString()+"\n\t >>>  Ignored URL :"+url);
            }else {

                testResponseCode = webClientResponseHelper.getWebClientResponseCode(url); //WebClientResponseHelper.getWebClientResponseCode(url);
                assertLessThan(url, testResponseCode, RESPONSE_CODE_LESSTHAN);
            }
            increaseTestEndCount();
        }catch (Exception | AssertionError e){
            failedUrlList.add(url+" - responseCode:"+testResponseCode);
            //logger.error("Exception : "+e.getMessage());
            BaseTest.failTest("Failed : "+e.getMessage());

        }
        finally {
            logger.info("Print failed URLs : "+failedUrlList);
            increaseTestCount();
            destroyLocalThreadDriver();
        }
    }

    @AfterSuite
    void printTotalErrors(){
        if(TEST_COUNT.get() > 0 && TEST_COUNT.get() - TEST_ENDCOUNT.get() == 0){
            logger.info("\n\n\t\tAll test passed ...!\n\n");
        }else {
            logger.error("\n\n\t\tNOT all test passed ...!\n");
            logger.error("printTotalErrors ...!   Test Run No:"+ TEST_COUNT.get() +" - Test Failure :" +
                    (TEST_COUNT.get() - TEST_ENDCOUNT.get())+"\n\n");
        }
        logger.info("Print failed URLs : "+failedUrlList);
    }


    @org.testng.annotations.DataProvider(name = "getAllPageValidUrls")//, parallel = true)
    public static Object[][] getAllPageValidUrls() {
        logger.info("UrlDataProvider ... getAllPageUrls ...!");
        Set<String> urlSet = new HashSet();
        Object[][] urlsObj = null;
        urlSet = TestUtil.getAllUrls(getLocalThreadDriver(), null, null);

        if(!urlSet.isEmpty()) {
            urlsObj = new Object[urlSet.size()][1];
            int count = 0;
            for (String url : urlSet) {
                urlsObj[count][0] = url;
                count++;
            }
        } else {
            BasePage.failTest(" Could not get any URLs from the webpage ...!");
        }

        return urlsObj;
    }

    /*public static void setupWebClient(){
        WebClientResponseHelper.isJavaScriptEnabled = false;
        WebClientResponseHelper.isThrowExceptionOnFailingStatusCode = false;
        WebClientResponseHelper.isRedirectEnabled = true;
        WebClientResponseHelper.isGetResponseAsString = false;
        WebClientResponseHelper.isPrintContentOnFailingStatusCode = false;
    }*/

    // todo constructor setup
    public static void setupWebClient(WebClientResponseHelper webClientResponseHelper){
        webClientResponseHelper.setJavaScriptEnabled(false);
        webClientResponseHelper.setThrowExceptionOnFailingStatusCode(false);
        webClientResponseHelper.setRedirectEnabled(true);
        webClientResponseHelper.setIsGetResponseAsString(false);
        webClientResponseHelper.setPrintContentOnFailingStatusCode(false);
    }
}
