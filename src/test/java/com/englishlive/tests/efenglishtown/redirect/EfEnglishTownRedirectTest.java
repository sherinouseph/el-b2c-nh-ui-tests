//package com.englishlive.tests.efenglishtown.redirect;
///**
// * Open a list of urls and check they are redirected
// * Use HtmlUnit driver
// *
// * SAND-2668
// *
// * // NM not needed anymore as we dont use Englishtown no more
// */
//
//import com.englishlive.tests.basetest.htmlunit.BaseHtmlUnitDriverTest;
//import com.englishtown.dataprovider.UrlDataProvider;
//import com.englishtown.dataprovider.bin.UrlRedirectBean;
//import com.englishtown.driver.MyBrowserType;
//import com.englishtown.helpers.WaitTool;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.Test;
//
//
//public class EfEnglishTownRedirectTest extends BaseHtmlUnitDriverTest{ // implements ITest {
//    private static final Logger logger = LoggerFactory.getLogger(EfEnglishTownRedirectTest.class);
//    private static int waitTime = WaitTool.SHORT_WAIT_4_ELEMENT;
//
//
//    @Test(dataProvider = "efEnglishtownRedirectData", dataProviderClass = UrlDataProvider.class,threadPoolSize = 4, invocationCount = 1, timeOut = 87000 )
//    public void opentUrlCheckRedirectUrlTest(UrlRedirectBean urlRedirectBean) throws Exception{
//        logger.info("Open URL  ["+urlRedirectBean.getUrl()+"] should redirect to ["+urlRedirectBean.getExpectedUrl()+"]");
//        try {
//            createLocalThreadDriver(MyBrowserType.CHROME_HEADLESS, 25);
//            openUrlCheckIsRedirected(getLocalThreadDriver(), urlRedirectBean, 20, true);
//        }catch (
//                Exception e){ throw new Exception(e);
//        }
//        finally {
//            destroyLocalThreadDriver();
//        }
//    }
//
//    @AfterTest
//    void printTotalErrors(){
//        if(TEST_COUNT.get() - TEST_ENDCOUNT.get() == 0){
//            logger.info("\n\n\t\tAll test passed ...!\n\n");
//        }else {
//            logger.error("\n\n\t\tNOT all test passed ...!\n");
//            logger.error("printTotalErrors ...!   Test Run No:"+TEST_COUNT.get()+" - Test Failure :" +(TEST_COUNT.get() - TEST_ENDCOUNT.get())+"\n\n");
//        }
//    }
//
//
//}
//
//
//
//
//
//
//
//
//
//
//
//
///*
//    @BeforeClass
//    public void setup(){
//        runTestOnThisEnvironmentOnly("live", "Live only test ...!");
//        setUpHtmlUnitDriver(); //runTestOnHtmlUnitAndFailIfNotChrome();
//    }*/
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
//
// /*sleep(1000);
//        synchronized ((Integer)TEST_COUNT){ TEST_COUNT++;}
//        String url = getBASE_URL()+urlRedirectBean.getUrl();
//        url = UrlMapper.mapBaseUrlToEtown(url, getBASE_URL());
//        String expectedUrl = urlRedirectBean.getExpectedUrl();
//
//        logger.info("Test URL " + getBASE_URL() + urlRedirectBean.getUrl() + " redirects to ->" + urlRedirectBean.getExpectedUrl());
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
//            if(!isSameDomain){
//                //tempUrl = UrlMapper.mapBaseUrlToELive(getBASEURL()) + urlRedirectBean.getExpectedUrl();
//                tempUrl =UrlMapper.mapBaseUrlToEtown(urlRedirectBean.getExpectedUrl(), getBASE_URL());
//                openUrl(getHtmlUnitDriver(), tempUrl);
//                CookieHandler.deleteCookies(getHtmlUnitDriver());
//                getHtmlUnitDriver().manage().deleteCookieNamed("ctr");
//            }
//            getHtmlUnitDriver().manage().addCookie(c);
//            getHtmlUnitDriver().navigate().refresh();
//            sleep(300);
//        }
//        logger.info("before last open URL Cookie CTR : " + getHtmlUnitDriver().manage().getCookieNamed("ctr"));
//        openUrl(getHtmlUnitDriver(), url);
//
//        boolean urlContains = BasePage.waitForUrlContains(getHtmlUnitDriver(), expectedUrl, waitTime);
//        myAssertThat(getHtmlUnitDriver(), " Failed ...!;" + TestUtil.getCurrentUrl(getHtmlUnitDriver()) + " URL does not contain : " + expectedUrl +
//                " waited for : " + waitTime, urlContains, true);
//
//        synchronized ((Integer)TEST_ENDCOUNT){TEST_ENDCOUNT++;}
//        */
//
//
////    @BeforeMethod(alwaysRun = true)
////    public void testData(Method method, Object[] testData) {
////        String testCase = "";
////        if (testData != null && testData.length > 0) {
////            UrlRedirectBean testParams = null;
////            //Check if test method has actually received required parameters
////            for (Object testParameter : testData) {
////                if (testParameter instanceof UrlRedirectBean) {
////                    testParams = (UrlRedirectBean)testParameter;
////                    break;
////                }
////            }
////            if (testParams != null) {
////                testCase = testParams.getTestName();
////            }
////        }//this.mTestCaseName = String.format("%s(%s)", method.getName(), testCase);
////        this.mTestCaseName = String.format("%s(%s)", "", testCase);
////    }
//
//
////    @Override
////    public String getTestName() {
////        return this.mTestCaseName;
////    }