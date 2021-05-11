package com.englishtown.tests.core;
/**
 *
 */
import com.englishtown.driver.local.DriverManager;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.helpers.WaitTool;
import com.englishtown.pages.core.BasePage;
import com.englishtown.pages.core.EnglishtownStateObject;
import com.englishtown.pages.core.Page;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.remote.server.DriverFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static com.englishtown.helpers.AssertHelper.myAssertThat;
import static com.englishtown.helpers.CaseInsensitiveSubstringMatcher.containsIgnoringCase;
import static org.apache.commons.lang.StringUtils.isNotEmpty;
import static org.hamcrest.text.IsEqualIgnoringCase.equalToIgnoringCase;


public abstract class PageTest<TPage extends Page> extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(PageTest.class);
//    protected String market, language;

    private static final Pattern LOCALIZED_URL_PARSER =
            Pattern.compile(".*englishtown.([a-z]{3})/([a-z]{2})-([a-z]{2})/.*");
    private static final Pattern TLD_LOCALIZED_URL_PARSER =
            Pattern.compile(".*englishtown.([a-z]{2})/([a-z]{2})-([a-z]{2})/.*");
    private static final Pattern TLD_URL_PARSER =
            Pattern.compile(".*englishtown.([a-z]{2})/.*");
    // domain with 2 parts   http://www.englishtown.co.jp/ja-jp/    e.g. co.uk co.jp
    private static final Pattern DD_URL_PARSER =
            Pattern.compile(".*englishtown.([a-z]{2}).([a-z]{2})/([a-z]{2})-([a-z]{2})/.*");
    // domain with 2 parts   http://www.englishtown.co.jp    e.g. co.uk co.jp
    private static final Pattern TOWPART_URL_PARSER = Pattern.compile(".*englishtown.([a-z]{2}).([a-z]{2}).*");
    //new domain http://englishlive.ef.com/es-co/
    private static final Pattern ROLA_URL_PARSER = Pattern.compile(".*englishlive.([a-z]{2}).([a-z]{3})/([a-z]{2})-([a-z]{2})/");


   private TPage page;

    /**
     * Simulates a delay in user input.
     * {Use this to wait for background events to complete in the page.}
     * @param delay delay time in seconds
     *              NOte: this sleep for 16 seconds if 1 is entered - implicit wait
     */
    protected void wait(int delay) {
        TestUtil.printMethodName(logger);
        WaitTool.waitForNonExistentId(getWebDriver(), null, delay);
    }

   protected abstract TPage createPage();

//    protected String getMarket() {
//        TestUtil.printMethodName(logger);
//        return this.market;
//    }
//
//    protected String getLanguage() {
//        TestUtil.printMethodName(logger);
//        return this.language;
//    }
//    protected void setLanguage(String language) {
//        logger.info("setLanguage : "+language);
//        this.language = language;
//    }
//    protected void setMarket(String market) {
//        logger.info("setLanguage : "+market);
//        this.market = market;
//    }

    public TPage getPage() {
        if (this.page == null) {
            this.page = this.createPage();
           // calculateSiteLocale();
        }
        return this.page;
    }

    /***
     * calculate local from URL,
     * Preferred to set this up on the test as it is a predefined condition
     * Otherwise url should have market
     */
    //TODO remove this -- market and language should be set on testcase use setTestLanguageAndMarket(str str);
    private void calculateSiteLocale() {
        TestUtil.printMethodName(logger);
        String url = this.page.getUrl();

        if(StringUtils.equals(getMarket(), "notinit") ) {
            if(isNotEmpty(url)) {
                Matcher localizedUrlMatcher = LOCALIZED_URL_PARSER.matcher(url);
                if (localizedUrlMatcher.find()) {
                    this.language = localizedUrlMatcher.group(2);
                    this.market = localizedUrlMatcher.group(3);
                    return;
                }

                Matcher tldLocalizedUrlMatcher = TLD_LOCALIZED_URL_PARSER.matcher(url);
                if (tldLocalizedUrlMatcher.find()) {
                    this.language = tldLocalizedUrlMatcher.group(2);
                    this.market = tldLocalizedUrlMatcher.group(3);
                    return;
                }

                Matcher tldUrlMatcher = TLD_URL_PARSER.matcher(url);
                if (tldUrlMatcher.find()) {
                    this.market = tldUrlMatcher.group(1);
                    this.language = this.market;
                    return;
                }

                Matcher ddUrlMatcher = DD_URL_PARSER.matcher(url);
                if (ddUrlMatcher.find()) {
                    this.language = ddUrlMatcher.group(3);
                    this.market = ddUrlMatcher.group(4);
                    return;
                }
                Matcher rolaUrlMatcher = ROLA_URL_PARSER.matcher(url);
                if (rolaUrlMatcher.find()) {
                    this.language = rolaUrlMatcher.group(3);
                    this.market = rolaUrlMatcher.group(4);
                    return;
                }
            }
        }
    }

//    @Test//(priority=3)
//    public void verifyMarket() throws Exception{
//        logger.info("verifyMarket should be : "+getMarket());
//        String key = "page.market";
//
//        EnglishtownStateObject etStateObj = new EnglishtownStateObject(DriverManager.getDriver()); //getWebDriver()
//        String currentMarket = etStateObj.getStateObjectKeyValue(DriverManager.getDriver(), key);
//
//        myAssertThat(DriverManager.getDriver(), "Market verification failed. - compare : " + getMarket() +
//                " With PageObject value: " + currentMarket, getMarket(), equalToIgnoringCase(currentMarket), true);
//       /* String testLanguage = getStateObjectValue("page.language", true);
//        if(testLanguage != null){
//            myAssertThat(getWebDriver(), "Language verification failed. - compare : " + this.getLanguage() +
//                            " With PageObject value: " + testLanguage,
//                    this.getLanguage().equalsIgnoreCase(testLanguage), true);
//        }else {
//            BasePage.failTest("this.getLanguage()   IS EMPTY ", true);
//        }*/
//        /*
//        try{Thread.sleep(500);}catch (Exception e) { }
//        if (isNotEmpty(this.getMarket())) {
//            EnglishtownStateObject englishtownStateObject = this.getPage().getEnglishtownStateObject(getWebDriver());
//            String testMarket = englishtownStateObject.getStateObjectValueFromMap(
//                    englishtownStateObject.getStateObjectMap(), "page.market")           ;//getStateObjectValue("page.market");
//            if (StringUtils.isEmpty(testMarket)) {
//                testMarket = englishtownStateObject.getStateObjectValueFromMap(
//                        englishtownStateObject.getStateObjectMap(), "user.market")  ;  //getStateObjectValue("user.market");
//                logger.info("testMarket: from user.market : "+testMarket);
//            } else { logger.info("testMarket: is not empty - init from StateObject page.market : "+testMarket);}
//            logger.info("englishtownStateObject "+englishtownStateObject.toString() );
//            //assertTrue(this.getMarket().equalsIgnoreCase(testMarket), "Market verification failed.! : this.market " + this.getMarket() +" - compare With PageObject value :" + testMarket);
//            myAssertThat(getWebDriver(),"Market verification failed.! : this.market " + this.getMarket() +
//                            " - compare With PageObject value :" + testMarket, this.getMarket(), containsIgnoringCase(testMarket), true );
//        }
//        else {
//            BasePage.failTest(" this.getMarket()   IS EMPTY ", true);  //            fail(" this.getMarket()   IS EMPTY ");
//        }*/
//    }
//
//    @Test//(priority=3)
//    public void verifyLanguage() {
//        logger.info("verifyLanguage should be : "+getLanguage());
//        String key = "page.language";
//
//        //EnglishtownStateObject etStateObj
//        englishtownStateObject = new EnglishtownStateObject(DriverManager.getDriver());  //DriverManager.getDriver());//getWebDriver()
//        String currentLanguage = englishtownStateObject.getStateObjectKeyValue(DriverManager.getDriver(), key);
//
//        myAssertThat(DriverManager.getDriver(), "Language verification failed. - compare : " + this.getLanguage() +
//                            " With PageObject value: " + currentLanguage, getLanguage(), equalToIgnoringCase(currentLanguage), true);
//        //verifyStateObjectLanguage();
//    }

    public void verifyStateObjectLanguage(){
        logger.info("verifyLanguage  should be : "+getLanguage());
        try{Thread.sleep(1000);}catch (Exception e) { }
        if (isNotEmpty(this.getLanguage())) {
            EnglishtownStateObject englishtownStateObject = this.getPage().getEnglishtownStateObject(getWebDriver());
            String testLanguage = englishtownStateObject.getStateObjectValueFromMap(
                    englishtownStateObject.getStateObjectMap(), "page.language"); //"page.language");

            if (StringUtils.isEmpty(testLanguage)) {
                englishtownStateObject = this.getPage().getEnglishtownStateObject(getWebDriver());
                testLanguage = englishtownStateObject.getStateObjectValueFromMap(
                        englishtownStateObject.getStateObjectMap(), "user.language");
            }//old
            if (StringUtils.isEmpty(testLanguage)) {
                testLanguage =englishtownStateObject.getStateObjectValueFromMap(
                        englishtownStateObject.getStateObjectMap(), "user.language_code");
            }
            //assertThat("Language verification failed. - compare : " + this.getLanguage() + " With PageObject value: " + testLanguage,this.getLanguage().equalsIgnoreCase(testLanguage), is(true));
            myAssertThat(getWebDriver(), "Language verification failed. - compare : " + this.getLanguage() +
                            " With PageObject value: " + testLanguage,
                    this.getLanguage().equalsIgnoreCase(testLanguage), true);
        } else {
            BasePage.failTest("this.getLanguage()   IS EMPTY ", true);                            // fail("this.getLanguage()   IS EMPTY ");
        }
    }

    /*
    @Test
    public void isTrackingEfEducationFirst(){
        logger.info(" running TEST : PageTest.isTrackingEfEducationFirst() time :"+System.currentTimeMillis());
//        assertThat("FAILED, result does not contains :"+CONTAINS_TRACKING_SERVER, isTrackingEfEducationFirst(JS_TRACKING_EF, getWebDriver(), CONTAINS_TRACKING_SERVER, getDefaultJsScriptTimeout()), is(true)) ;
        myAssertThat(getWebDriver(), "FAILED, result does not contains :"+CONTAINS_TRACKING_SERVER,
                isTrackingEfEducationFirst(JS_TRACKING_EF, getWebDriver(), CONTAINS_TRACKING_SERVER,
                        WaitTool.JS_SCRIPT_DEFAULT_TIMEOUT),true) ;

    }*/



}