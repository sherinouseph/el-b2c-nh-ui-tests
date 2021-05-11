package com.englishlive.tests.basetest.htmlunit;
/**
 * Use this if header need to be set for the request
 */

import com.englishtown.dataprovider.bin.UrlRedirectBean;
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.CookieHandler;
import com.englishtown.helpers.TestEnvironment;
import com.englishtown.helpers.UrlMapper;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.pages.core.BasePage;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.UnableToSetCookieException;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicInteger;

import static com.englishtown.helpers.AssertHelper.myAssertThat;
import static com.englishtown.helpers.CaseInsensitiveSubstringMatcher.containsIgnoringCase;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.core.Is.is;


public abstract class BaseHtmlUnitDriverTest extends BaseHtmlUnitDriverConfig {
    protected static final Logger logger = LoggerFactory.getLogger(BaseHtmlUnitDriverTest.class);
    protected static int RESPONSE_CODE_LESSTHAN = 400;
    protected AtomicInteger TEST_COUNT    = new AtomicInteger(0);
//    /**
//     * USE : htmlUnitDriver
//     */
//    @Test
//    public void openUrlAndCheckRedirectTest(){
//        boolean urlContains = BasePage.waitForUrlContains(getHtmlUnitDriver(), URL_CONTAINS, 15);
//        logger.info("Current URL :" + getHtmlUnitDriver().getCurrentUrl());
//        if(logPageSource) logger.info( getHtmlUnitDriver().getPageSource());
//        myAssertThat(getHtmlUnitDriver(), " Failed ...!; URL does not contain : "+URL_CONTAINS, getHtmlUnitDriver().getCurrentUrl(), containsString(URL_CONTAINS), true);
//    }


    /**
     * Open URL and check it is redirected to the correct URL
     * Ready for parallel run
     * Note: no cookies setup up delete ... ThreadLocal should be used to isolate the instance ....
     * @param urlRedirectBean
     * @param driver  = HtmlUnit driver [or any ....]
     * @throws Exception
     *
     */
    public void openUrlCheckIsRedirected(WebDriver driver, UrlRedirectBean urlRedirectBean, int waitTime, boolean isUrlMapper){
        String url = getBASE_URL()+urlRedirectBean.getUrl();
        if(isUrlMapper){
            url = UrlMapper.mapBaseUrlToEtown(url, getBASE_URL());
        }
        String expectedUrl = urlRedirectBean.getExpectedUrl();

        logger.info("ORI..Test URL " + url + " redirects to ->" + expectedUrl);
        logger.info("Test URL " + getBASE_URL() + urlRedirectBean.getUrl() + " redirects to ->"+urlRedirectBean.getExpectedUrl());

        openUrl(driver, url);
        boolean urlContains = BasePage.waitForUrlContains(driver, expectedUrl, waitTime);
        myAssertThat(driver, " Failed ...!;" + TestUtil.getCurrentUrl(driver) + " URL does not contain : " + expectedUrl +
               " ; test Open URL : "+url+ " - waited for : " + waitTime, urlContains, true);
        sleep(300);
    }

    public void openUrlCheckIsRedirectedWithClearCookies(WebDriver driver, UrlRedirectBean urlRedirectBean, int waitTime){
        String url = getBASE_URL()+urlRedirectBean.getUrl();
        if(url.contains("englishlive.ef.com")) {
            // do nothing
        }
        if(url.contains("englishlive.com/")) {
            if(TestUtil.isEnvironment(getENVIRONMENT(), TestEnvironment.QA))
                url = url.replace("https://qa-", "http://qa.");
            if(TestUtil.isEnvironment(getENVIRONMENT(), TestEnvironment.Live))
                url = url.replace("https", "http");
        }
        else if(!StringUtils.contains(url, "englishlive.ef.com/")){
            url = UrlMapper.mapBaseUrlToEtown(url, getBASE_URL());
        }
       // if(StringUtils.contains(url, "pt-br"))   url = url.replace("https","http");          // not https yet so remove s

        String expectedUrl = urlRedirectBean.getExpectedUrl();

        logger.info("ORI..Test URL " + url + " redirects to ->" + expectedUrl);
        logger.info("Test URL " + getBASE_URL() + urlRedirectBean.getUrl() + " redirects to ->"+urlRedirectBean.getExpectedUrl());

        boolean isSameDomain = urlRedirectBean.isSameDomain(urlRedirectBean);
        String tempUrl = null;

        if(TEST_COUNT.get() > 1) {
            logger.info("Delete and set the cookies ctr ...!  ; isSameDomain :"+isSameDomain);
            CookieHandler.deleteCookies(driver);
            driver.manage().deleteCookieNamed("ctr");

            Cookie c = new Cookie("ctr", TestUtil.getCountryFromUrl(url));

            if(!isSameDomain){
                tempUrl = getBASE_URL() + urlRedirectBean.getExpectedUrl();
                openUrl(driver, tempUrl);
                CookieHandler.deleteCookies(driver);
                driver.manage().deleteCookieNamed("ctr");
            }

            try{
                driver.manage().addCookie(c);
            }catch (UnableToSetCookieException ce){
                logger.error("Could not add cookie ...! ["+tempUrl+"]; "+ce.getMessage());
            }
            driver.navigate().refresh();
            sleep(500);
        }

         openUrl(driver, url);
         sleep(1000);

        myAssertThat(driver, "["+url+"] URL does not contain expectedUrl ...!",   TestUtil.getCurrentUrl(driver), containsIgnoringCase(expectedUrl),  true);
        //boolean urlContains = BasePage.waitForUrlContains(driver, expectedUrl, waitTime);
        // myAssertThat(driver, "URL does not contain :" + expectedUrl +";\nCurrent URL :"+ TestUtil.getCurrentUrl(driver)+"\nTest Start URL: "+url+ " waited for : " + waitTime, urlContains, true);
        sleep(300);
    }


    public static void assertLessThan(String url, int responseCode, int responseCodeLessThan){
        logger.info("URL ["+url+"] testResponseCode ["+responseCode+"] <(lessThan) ["+responseCodeLessThan+"]");
        AssertHelper.assertThat("URL ["+url+"] Response Code is not less than ["+responseCodeLessThan+"] ...!",responseCode, lessThan(responseCodeLessThan));
    }

    public static void assertMoreThan(String url, int responseCode, int responseCodeLessThan){
        logger.info("URL ["+url+"] testResponseCode ["+responseCode+"] <(lessThan) ["+responseCodeLessThan+"]");
        AssertHelper.assertThat("URL ["+url+"] Response Code is not less than ["+responseCodeLessThan+"] ...!",responseCode, greaterThan(responseCodeLessThan));
    }

    public static void assertEqual(String url, int responseCode, int responseCodeShouldBe){
        logger.info("URL ["+url+"] testResponseCode ["+responseCode+"] <(lessThan) ["+responseCodeShouldBe+"]");
        AssertHelper.assertThat("URL ["+url+"] Response Code is not ["+responseCodeShouldBe+"] ...!",responseCode, is(responseCodeShouldBe));
    }
}
