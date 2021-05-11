//package com.englishlive.tests.redirect.all.br;
///**
// * Open a list of urls and check they are redirected
// * Use HtmlUnit driver
// */
//
//import com.englishlive.tests.basetest.htmlunit.BaseHtmlUnitDriverTest;
//import com.englishtown.dataprovider.UrlDataProvider;
//import com.englishtown.dataprovider.bin.UrlRedirectBean;
//import com.englishtown.driver.MyBrowserType;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.Test;
// Use Elive Redirect test .... 
//public class BrRedirectTest extends BaseHtmlUnitDriverTest {
//    private static final Logger logger = LoggerFactory.getLogger(BrRedirectTest.class);
//    private static int waitTime = 15 ;
//
//
//    @Test(dataProvider = "brELiveAllUrlRedirect", dataProviderClass = UrlDataProvider.class, threadPoolSize = 7, invocationCount = 1, timeOut = 60000 )
//    public void opentUrlCheckRedirectUrlTest(UrlRedirectBean urlRedirectBean) throws Exception{
//        try {
//            createLocalThreadDriver(MyBrowserType.HTMLUNIT, 35);
//            openUrlCheckIsRedirectedWithClearCookies(getLocalThreadDriver(), urlRedirectBean, 20);
//            increaseTestEndCount(); //TEST_ENDCOUNT = increaseCountBy(TEST_ENDCOUNT, 1);
//        }catch (Exception e){
//            logger.error("Exception : "+e.getMessage());
//            throw new Exception(e);
//        }
//        finally {
//            increaseTestCount(); //TEST_COUNT = increaseCountBy(TEST_COUNT, 1);
//            destroyLocalThreadDriver();
//        }
//    }
//
//    @AfterTest
//    void printTotalErrors(){
//        if(TEST_COUNT.get() > 0 && TEST_COUNT.get() - TEST_ENDCOUNT.get() == 0){
//            logger.info("\n\n\t\tAll test passed ...!\n\n");
//        }else {
//            logger.error("\n\n\t\tNOT all test passed ...!\n");
//            logger.error("printTotalErrors ...!   Test Run No:"+TEST_COUNT.get()+" - Test Failure :" +
//                    (TEST_COUNT.get() - TEST_ENDCOUNT.get())+"\n\n");
//        }
//    }
//
//
//}
//
//
//
//
////***********************************
///*createLocalThreadDriver(MyBrowserType.HTMLUNIT, 25); //WebDriver  driver = null;driver = createHtmlUnitDriver(); synchronized ((Object) TEST_COUNT){ TEST_COUNT++;}
//            String url = getBASE_URL()+urlRedirectBean.getUrl();
//            url = UrlMapper.mapBaseUrlToEtown(url, getBASE_URL());
//            expectedUrl = urlRedirectBean.getExpectedUrl();
//
//            logger.info("Test URL " + getBASE_URL() + urlRedirectBean.getUrl() + " redirects to ->"+urlRedirectBean.getExpectedUrl());
//            boolean isSameDomain = urlRedirectBean.isSameDomain(urlRedirectBean);
//            String tempUrl = null;
//
//            if(TEST_COUNT > 1) {
//                logger.info("Delete and set the cookies ctr ...!  ; isSameDomain :"+isSameDomain);
//
//                CookieHandler.deleteCookies(getLocalThreadDriver());
//                getLocalThreadDriver().manage().deleteCookieNamed("ctr");
//
//                logger.info("Cookie CTR : "+getLocalThreadDriver().manage().getCookieNamed("ctr"));
//                sleep(300);
//
//                Cookie c = new Cookie("ctr", TestUtil.getCountryFromUrl(url));
//
//                if(!isSameDomain){ // need to set the cookies to the redirected domain when different domain
//                    tempUrl = getBASE_URL() + urlRedirectBean.getExpectedUrl();
//                    openUrl(getLocalThreadDriver(), tempUrl);
//                    CookieHandler.deleteCookies(getLocalThreadDriver());
//                    getLocalThreadDriver().manage().deleteCookieNamed("ctr");
//                }
//                getLocalThreadDriver().manage().addCookie(c);
//                getLocalThreadDriver().navigate().refresh();
//                sleep(400);
//            }
//            logger.info("before last open URL Cookie CTR : " + getLocalThreadDriver().manage().getCookieNamed("ctr"));
//            openUrl(getLocalThreadDriver(), url);
//            sleep(400);
//            boolean urlContains = BasePage.waitForUrlContains(getLocalThreadDriver(), expectedUrl, waitTime);
//            myAssertThat(getLocalThreadDriver(), " Failed ...!; test start url :"+url+"; \nCurrent URL" + TestUtil.getCurrentUrl(getLocalThreadDriver()) + " URL does not contain : " + expectedUrl +
//                    " waited for : " + waitTime, urlContains, true);
//            sleep(300);*/
//
////    @AfterClass
////    void printTotalErrors(){
////        calculateTestEndTime();
////    }
////
////    @BeforeClass
////    public void setup(){
////        //this test will always run on htmlunit
////        //setUpHtmlUnitDriver();
//////        try {
//////            String url = getBASE_URL()+".englishtown.com/";
//////            logger.info("Open url : "+url);
//////            getHtmlUnitDriver().get(url);
//////            Thread.sleep(100);
//////        }catch (Exception e){
//////            logger.error(TestUtil.getException(e, getHtmlUnitDriver()));
//////        }
////    }
//
////    @Override
////    public String getTestName() {
////        return this.mTestCaseName;
////    }
//
//        /*WebDriver  driver = null;
//        driver = createHtmlUnitDriver();
//        //synchronized ((Object) TEST_COUNT){
//        TEST_COUNT++;
//
//        String url = getBASE_URL()+urlRedirectBean.getUrl();
//        url = UrlMapper.mapBaseUrlToEtown(url, getBASE_URL());
//        String expectedUrl = urlRedirectBean.getExpectedUrl();
//
//        logger.info("Test URL " + getBASE_URL() + urlRedirectBean.getUrl() + " redirects to ->"+urlRedirectBean.getExpectedUrl());
//        boolean isSameDomain = urlRedirectBean.isSameDomain(urlRedirectBean);
//        String tempUrl = null;
//        if(TEST_COUNT > 1) {
//            logger.info("Delete and set the cookies ctr ...!  ; isSameDomain :"+isSameDomain);
//
//            CookieHandler.deleteCookies(driver);
//            driver.manage().deleteCookieNamed("ctr");
//
//            logger.info("Cookie CTR : "+driver.manage().getCookieNamed("ctr"));
//            sleep(300);
//
//            Cookie c = new Cookie("ctr", TestUtil.getCountryFromUrl(url));
//
//            if(!isSameDomain){ // need to set the cookies to the redirected domain when different domain
//                tempUrl = getBASE_URL() + urlRedirectBean.getExpectedUrl();
//                openUrl(driver, tempUrl);
//                CookieHandler.deleteCookies(driver);
//                driver.manage().deleteCookieNamed("ctr");
//            }
//            driver.manage().addCookie(c);
//            driver.navigate().refresh();
//            sleep(400);
//        }
//        logger.info("before last open URL Cookie CTR : " + driver.manage().getCookieNamed("ctr"));
//        openUrl(driver, url);
//        sleep(400);
//        // verify
//        boolean urlContains = BasePage.waitForUrlContains(driver, expectedUrl, waitTime);
//        myAssertThat(driver, " Failed ...!;" + TestUtil.getCurrentUrl(driver) + " URL does not contain : " + expectedUrl +
//                " waited for : " + waitTime, urlContains, true);
//
////        synchronized ((Object) TEST_ENDCOUNT){
////            TEST_ENDCOUNT++;
////        }      // if OK should reach here
//        sleep(300);
//        //try{driver.quit();}catch (WebDriverException e){e.printStackTrace();};
//    }
//
//    //    //experiment
////    //http://stackoverflow.com/questions/15220262/custom-test-method-name-in-testng-reports
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
//*/