//package com.englishlive.tests.redirect.all.tw;
///**
// * Open a list of urls and check they are redirected
// * Use HtmlUnit driver
// */
//
//import com.englishlive.tests.basetest.htmlunit.BaseHtmlUnitDriverConfig;
//import com.englishtown.dataprovider.UrlDataProvider;
//import com.englishtown.dataprovider.bin.UrlRedirectBean;
//import com.englishtown.helpers.CookieHandler;
//import com.englishtown.helpers.UrlMapper;
//import com.englishtown.helpers.WaitTool;
//import com.englishtown.helpers.utils.TestUtil;
//import com.englishtown.pages.core.BasePage;
//import org.openqa.selenium.Cookie;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.testng.ITest;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//import java.lang.reflect.Method;
//
//import static com.englishtown.helpers.AssertHelper.myAssertThat;
//
//
//public class TWRedirectTest extends BaseHtmlUnitDriverConfig implements ITest {
//    private static final Logger logger = LoggerFactory.getLogger(TWRedirectTest.class);
//    protected static int TEST_COUNT =0;
//    protected static int TEST_ENDCOUNT =0;
//    private static int waitTime = WaitTool.SHORT_WAIT_4_ELEMENT;
//
//    @BeforeClass
//    public void setup(){
//        runTestOnHtmlUnitAndFailIfNotChrome();
//}
//
//    @Test(dataProvider = "twUrlRedirect", dataProviderClass = UrlDataProvider.class )
//    public void opentUrlCheckRedirectUrlTest(UrlRedirectBean urlRedirectBean) throws Exception{
//        TEST_COUNT++;
//        String url = getBASE_URL()+urlRedirectBean.getUrl();
//        //url = UrlMapper.mapBaseUrlToEtown(url, getBASEURL());
//        String expectedUrl = urlRedirectBean.getExpectedUrl();
//
//        logger.info("Test URL " + getBASE_URL() + urlRedirectBean.getUrl() + " redirects to ->"+urlRedirectBean.getExpectedUrl());
//        boolean isSameDomain = urlRedirectBean.isSameDomain(urlRedirectBean);
//        String tempUrl = null;
//        if(TEST_COUNT > 1) {
//            logger.info("Delete and set the cookies ctr ...!");
//            logger.info("isSameDomain : "+isSameDomain);
//            CookieHandler.deleteCookies(getHtmlUnitDriver());
//            getHtmlUnitDriver().manage().deleteCookieNamed("ctr");
//            logger.info("Cookie CTR : "+getHtmlUnitDriver().manage().getCookieNamed("ctr"));
//            sleep(300);
//            Cookie c = new Cookie("ctr", TestUtil.getCountryFromUrl(url));
//
//            if(!isSameDomain){ // need to set the cookies to the rederected domain when different domain
//                tempUrl = getBASE_URL() + urlRedirectBean.getExpectedUrl();             //tempUrl = tempUrl.split(".com/")[0]+".com/";
//                openUrl(getHtmlUnitDriver(), tempUrl);
//                CookieHandler.deleteCookies(getHtmlUnitDriver());
//                getHtmlUnitDriver().manage().deleteCookieNamed("ctr");
//            }
//            getHtmlUnitDriver().manage().addCookie(c);            /*if(!isSameDomain){ CookieHandler.deleteCookies(getWebDriver());  getWebDriver().manage().deleteCookieNamed("ctr");    getWebDriver().manage().addCookie(c);    openUrl(getWebDriver(), tempUrl );            }*/
//            getHtmlUnitDriver().navigate().refresh();
//            sleep(300);
//        }
//        logger.info("before last open URL Cookie CTR : " + getHtmlUnitDriver().manage().getCookieNamed("ctr"));
//        openUrl(getHtmlUnitDriver(), url);            //        Cookie c = new Cookie("EFID","ctr="+TestUtil.getCountryFromUrl(url) );   getWebDriver().manage().addCookie(c); getWebDriver().navigate().refresh();
//        // verify
//        boolean urlContains = BasePage.waitForUrlContains(getHtmlUnitDriver(), expectedUrl, waitTime);
//        myAssertThat(getHtmlUnitDriver(), " Failed ...!;" + TestUtil.getCurrentUrl(getHtmlUnitDriver()) + " URL does not contain : " + expectedUrl +
//                " waited for : " + waitTime, urlContains, true);
//
//        TEST_ENDCOUNT++;      // if OK should reach here
//    }
//
//    @AfterTest
//    void printTotalErrors(){
//        if(TEST_COUNT - TEST_ENDCOUNT == 0){
//            logger.info("\n\n\t\tAll test passed ...!\n\n");
//        }else {
//            logger.error("\n\n\t\tNOT all test passed ...!\n");
//            logger.error("printTotalErrors ...!   Test Run No:"+TEST_COUNT+" - Test Failure :" +(TEST_COUNT - TEST_ENDCOUNT)+"\n\n");
//        }
//        nullifyHtmlUnitDriver();
//    }
//
//    //experiment
//    //http://stackoverflow.com/questions/15220262/custom-test-method-name-in-testng-reports
//    @BeforeMethod(alwaysRun = true)
//    public void testData(Method method, Object[] testData) {
//        String testCase = "";
//        if (testData != null && testData.length > 0) {
//            UrlRedirectBean testParams = null;
//            //Check if test method has actually received required parameters
//            for (Object testParameter : testData) {
//                if (testParameter instanceof UrlRedirectBean) {
//                    testParams = (UrlRedirectBean)testParameter;
//                    break;
//                }
//            }
//            if (testParams != null) {
//                testCase = testParams.getTestName();
//            }
//        }//this.mTestCaseName = String.format("%s(%s)", method.getName(), testCase);
//        this.mTestCaseName = String.format("%s(%s)", "", testCase);
//    }
//
//    @Override
//    public String getTestName() {
//        return this.mTestCaseName;
//    }
//
//}
//
//
//
////
////    @BeforeClass
////    public void setup(){
////        //this test will always run on htmlunit
////        //setUpHtmlUnitDriver();
//////        try {
//////            String url = getBASEURL()+".englishtown.com/";
//////            logger.info("Open url : "+url);
//////            getWebDriver().get(url);
//////            Thread.sleep(100);
//////        }catch (Exception e){
//////            logger.error(TestUtil.getException(e, getWebDriver()));
//////        }
////    }
