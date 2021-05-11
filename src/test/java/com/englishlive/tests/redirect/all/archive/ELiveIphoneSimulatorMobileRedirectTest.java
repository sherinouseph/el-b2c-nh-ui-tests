//package com.englishlive.tests.redirect.all;
///**
// * when using mobile browser/device urls are redirected to mobile page
// * Run only on Mobile browser and chrome simulator
// */
//
//import com.englishtown.dataprovider.UrlDataProvider;
//import com.englishtown.dataprovider.bin.UrlRedirectBean;
//import com.englishtown.driver.BaseRemoteWebDriver;
//import com.englishtown.driver.mobile.ChromeSimulatoriPhone6WebDriver;
//import com.englishtown.helpers.CookieHandler;
//import com.englishtown.helpers.utils.TestUtil;
//import com.englishtown.helpers.WaitTool;
//import com.englishtown.pages.core.BasePage;
//import com.englishlive.tests.basetest.htmlunit.BaseHtmlUnitDriverConfig;
//import org.openqa.selenium.WebDriver;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import static com.englishtown.helpers.AssertHelper.myAssertThat;
//
//public class ELiveIphoneSimulatorMobileRedirectTest extends BaseHtmlUnitDriverConfig {
//    private static final Logger logger = LoggerFactory.getLogger(ELiveIphoneSimulatorMobileRedirectTest.class);
//    protected static int TEST_COUNT =0;
//    protected static int TEST_ENDCOUNT =0;
//    private static int waitTime = WaitTool.DEFAULT_WAIT_4_ELEMENT;
//
//    @BeforeClass
//    private void setup(){
//        if(BaseRemoteWebDriver.isBrowser("chrome")  ) {
//            try {
//                WebDriver iphoneSimulatorDriver = new ChromeSimulatoriPhone6WebDriver(); //ChromeSimulatorSamsungGalaxyS4WebDriver
//                setWebDriver(iphoneSimulatorDriver);
//            } catch (Exception e) {
//                logger.error(" Mobile driver not chreated : " + TestUtil.getException(e));
//            }
//        }else if (BaseRemoteWebDriver.isMobileTestOnly){
//            // run test no need to update driver
//        }
//        else {
//            BasePage.failTest("This test should run only on Mobile device [iphone, galaxy, etc ...!] and simulators -- chrome");
//        }
//    }
//
//    @Test(dataProvider = "eLiveAllMobileUrlRedirect", dataProviderClass = UrlDataProvider.class )
//    public void opentUrlCheckRedirectUrlTest(UrlRedirectBean urlRedirectBean) throws Exception{
//        TEST_COUNT++;
//        String url = getBASEURL()+urlRedirectBean.getUrl();
//        String expectedUrl = urlRedirectBean.getExpectedUrl();
//
//        logger.info("Test URL " + getBASEURL() + urlRedirectBean.getUrl() + " redirects to -> "+ urlRedirectBean.getExpectedUrl());
//        //
//        openUrl(getWebDriver(), url);
//        sleep(1000);
//        // verify
//        boolean urlContains = BasePage.waitForUrlContains(getWebDriver(), expectedUrl, waitTime);
//        myAssertThat(getWebDriver(), " Failed ...!;" + TestUtil.getCurrentUrl(getWebDriver()) + " URL does not contain : " + expectedUrl +
//                " waited for : " + waitTime + " >>> NOTE: run only on Mobile ...!", urlContains, true);
//
//        TEST_ENDCOUNT++;      // if OK should reach here
//    }
//    @AfterMethod
//    private void deleteCookies(){
//        logger.info("AfterMethod delete cookies ...!");
//        CookieHandler.deleteCookies(getWebDriver());
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
