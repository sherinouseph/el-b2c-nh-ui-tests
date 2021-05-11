package com.englishlive.tests.basetest.htmlunit;
/**
 * Use this if header need to be set for the request
 */

import com.englishtown.driver.MyBrowserType;
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WebClientResponseHelper;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.pages.core.BasePage;
import com.englishtown.tests.core.SimpleHtmlUnitBaseTest;
import com.gargoylesoftware.htmlunit.WebClient;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.core.Is.is;


public abstract class BaseHtmlUnitDriverConfig extends SimpleHtmlUnitBaseTest{                                           //SimpleBaseTest .. BaseTest{
    protected static final Logger logger = LoggerFactory.getLogger(BaseHtmlUnitDriverConfig.class);
   //Defaults
    protected String HEADER_NAME = "X-IPCountryCode";
    protected String HEADER_VALUE = "ar";
    protected String URL_CONTAINS = "es-wws";
    //protected static WebDriver htmlUnitDriver;
    protected static boolean logPageSource = false;
    public static String failMsg = "Chrome browser only test ....!\n\t\t\tThis test run only on HTML unit so it take less time to complete ...!";
    public static String[] runTestOnThisBrowserList = {"chrome"};
    public String responseCode = null; //404
    public int testResponseCode = -1;
    public final int RESPONSE_CODE_200 = 200;
    protected String htmlUnitTestUrl ;

    public static final String[] CHROME_BROWSER_LIST = {"chrome"};
    public static final String[] CHROME_HTMLUNIT_BROWSER_LIST = {"chrome", "htmlunit"};
    public static final String[] CHROME_FF_BROWSER_LIST = {"chrome", "firefox"};
    public static final String[] CHROME_FF_IE_SAFARY_BROWSER_LIST = {"chrome", "firefox", "ie", "safari"};

    protected WebClientResponseHelper webClientResponseHelper;

    public void setUpHtmlUnitDriverWithHeader(){
        logger.info("setUpHtmlUnitDriver ...!");
        try{
            // add header
            //////htmlUnitDriver = createHtmlUnitDriverWithHeader(htmlUnitDriver, HEADER_NAME, HEADER_VALUE);
            htmlUnitDriver = createHtmlUnitDriverWithHeader(htmlUnitDriver, HEADER_NAME, HEADER_VALUE);
            setBrowserName("htmlunit");
            //setWebDriver(htmlUnitDriver);
            WaitTool.setPageLoadTimeOut(htmlUnitDriver, WaitTool.PAGELOAD_TIMEOUT_45);  //WaitTool.setImplicitWaitToDefault(htmlUnitDriver);
        }catch (Exception e){
            logger.error(TestUtil.getException(e, htmlUnitDriver));
            BasePage.failTest(e, " setUpHtmlUnitDriver Exception ...!");
        }
    }

    public void setUpHtmlUnitDriver(){
        logger.info("setUpHtmlUnitDriver ...!");
        try{
            htmlUnitDriver = createHtmlUnitDriver(htmlUnitDriver);
            setBrowserName("htmlunit");
            //setWebDriver(htmlUnitDriver);
            WaitTool.setPageLoadTimeOut(htmlUnitDriver, WaitTool.PAGELOAD_TIMEOUT_45);
        }catch (Exception e){
            logger.error(TestUtil.getException(e, htmlUnitDriver));
            BasePage.failTest(e, " setUpHtmlUnitDriver Exception ...!");
        }
    }

    public void nullifyHtmlUnitDriver(){
        htmlUnitDriver = null;
    }


    /*******************************************************************************************************************
     * Add header to Webdriver request
     * e.g : "X-IPCountryCode","ar"
     * By default JavaScript exceptions will crash your tests. If you wish to ignore JavaScript exceptions use this:
     * view sourceprint?
     * 1.     webClient().setThrowExceptionOnScriptError(false);
     *
     */
    protected WebDriver createHtmlUnitDriverWithHeader(WebDriver webDriver, final String headerName, final String headerValue){
        webDriver = new HtmlUnitDriver(){
            @Override protected WebClient modifyWebClient( WebClient webClient){
                WebClient answer=super.modifyWebClient(webClient);
                answer.addRequestHeader(headerName, headerValue);
                //answer.addRequestHeader("X-GeoIP-Enabled", "true");
                return answer;
            }
        };
        return webDriver;
    }
    protected WebDriver createHtmlUnitDriverWithHeaders(WebDriver webDriver, String... headerNameValues){
        webDriver = new HtmlUnitDriver(){
            @Override protected WebClient modifyWebClient( WebClient webClient){
                WebClient answer=super.modifyWebClient(webClient);                //answer.getOptions().setRedirectEnabled(true);  answer.getOptions().setGeolocationEnabled(true); answer.getOptions().setThrowExceptionOnScriptError(false);
                answer.getCache().setMaxSize(0);
                answer.getOptions().setThrowExceptionOnFailingStatusCode(false);
                answer.getOptions().setThrowExceptionOnScriptError(false);
                answer.getOptions().setRedirectEnabled(true);


                for(String headerNameValue : headerNameValues ){
                    try{
                        logger.info(" Add headerNameValues ["+headerNameValue+"]");
                        String headerName  = headerNameValue.split(":")[0];
                        String headerValue = headerNameValue.split(":")[1];
                        answer.addRequestHeader(headerName, headerValue);
                    }catch (Exception e){
                        logger.error(" createHtmlUnitDriverWithHeaders : "+e.getMessage());
                    }
                }
                return answer;
            }
        };
        return webDriver;
    }
// TODO
    protected WebClient createWebClientWithHeaders( String... headerNameValues){
        WebClient webClient = new WebClient(){
            protected WebClient modifyWebClient( WebClient webClient){
                   //answer.getOptions().setRedirectEnabled(true);  answer.getOptions().setGeolocationEnabled(true); answer.getOptions().setThrowExceptionOnScriptError(false);
                webClient.getCache().setMaxSize(0);
                webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
                webClient.getOptions().setRedirectEnabled(true);


                for(String headerNameValue : headerNameValues ){
                    try{
                        logger.info(" Add headerNameValues ["+headerNameValue+"]");
                        String headerName  = headerNameValue.split(":")[0];
                        String headerValue = headerNameValue.split(":")[1];
                        webClient.addRequestHeader(headerName, headerValue);
                    }catch (Exception e){
                        logger.error(" createHtmlUnitDriverWithHeaders : "+e.getMessage());
                    }
                }
                return webClient;
            }
        };
        return webClient;
    }
    /**
     * NO header set
     */
    protected WebDriver createHtmlUnitDriver(WebDriver webDriver){
        logger.info("createHtmlUnitDriver  NO header ...!");
        webDriver = createLocalThreadDriver(MyBrowserType.HTMLUNIT, 25) ; //new HtmlUnitDriver();
        return webDriver;
    }

    /**
     * Local driver
     * @return
     */
    protected WebDriver createHtmlUnitDriver( ){
        logger.info("createHtmlUnitDriver  NO header ...!");
        return createLocalThreadDriver(MyBrowserType.HTMLUNIT, 25) ;
    }

    public void runTestOnHtmlUnitAndFailIfNotChrome(){
        logger.info(failMsg);
        failTestIfIsNotBrowser(getBrowserName(),runTestOnThisBrowserList, failMsg);
        setUpHtmlUnitDriver();
    }


    /**
     *  Use Web client
     * @param expectedResponseCode
     * @param url
     */
    public void openUrlCheckResponseCode(int expectedResponseCode, String url) {
        webClientResponseHelper = new WebClientResponseHelper();
        webClientResponseHelper.setJavaScriptEnabled(false);
        webClientResponseHelper.setThrowExceptionOnFailingStatusCode(false);
        int responseCode  = webClientResponseHelper.getWebClientResponseCode(url) ;          // WebClientResponseHelper.isJavaScriptEnabled = false;        WebClientResponseHelper.isThrowExceptionOnFailingStatusCode=false;        int responseCode =  WebClientResponseHelper.getWebClientResponseCode(url);
        webClientResponseHelper = null;
        logger.info("testResponseCode is ["+responseCode+"]");
        AssertHelper.myAssertThat( null, "Response Code is not ["+expectedResponseCode+"] ...!; URL ["+url+"]", responseCode,
                is(expectedResponseCode), false);
    }




}
