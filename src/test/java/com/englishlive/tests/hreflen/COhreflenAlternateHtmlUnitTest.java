//package com.englishlive.tests.hreflen;
///**
// * NOte:
// * no more rel=alternate moved to sitemap
// *
// */
//
//import com.englishlive.tests.basetest.htmlunit.BaseCheckHrefLenAltenate;
//import com.englishtown.driver.BaseRemoteWebDriver;
//import com.englishtown.helpers.WebClientResponseHelper;
//import com.englishtown.helpers.utils.TestUtil;
//import org.openqa.selenium.remote.RemoteWebDriver;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeClass;
//
//
//public class COhreflenAlternateHtmlUnitTest extends BaseCheckHrefLenAltenate  {
//    private static final Logger logger = LoggerFactory.getLogger(COhreflenAlternateHtmlUnitTest.class);
//    @Value("#{applicationPropertiesList['home.page.co.es']}")
//    private String testUrl;
//
//
//    @BeforeClass
//    private void setupOpenUrl(){
//        WebClientResponseHelper.setOptions( false );
//        market = "co";
//        initChrome();
//        myWebDriver = chrome; // needs a static driver        logger.info("spring driver: "+((RemoteWebDriver) springProfileDriver).getCapabilities().getBrowserName());        //setBrowserName(TestUtil.getBrowserName(getSpringProfileDriver()) );
//        //failTestIfIsNotBrowser(TestUtil.getBrowserName(getSpringProfileDriver()), CHROME_HTMLUNIT_BROWSER_LIST, "Chrome Only Test ....!");
//        openUrl(myWebDriver, testUrl);
//        sleep(3000);
//    }
//
//    @AfterTest
//    void printTotalErrors(){
//        logger.info("AfterClass printTotalErrors ...!");
//        if(TEST_COUNT < 1){
//            logger.info("\n\n\tNo Test RUN ...!\n\n");
//        }else if(TEST_COUNT - TEST_ENDCOUNT == 0){
//            logger.info("\n\n\t\tAll test passed ...!\n\n");
//        }else {
//            logger.error("\n\n\t\tNOT all test passed ...!\n");
//            logger.error("printTotalErrors ...!   Test Run No:"+TEST_COUNT+" - Test Failure :" +(TEST_COUNT - TEST_ENDCOUNT)+"\n\n");
//        }
//        logger.info(" destroyDrivers ...!");
//        destroyDriver(chrome);
//        destroyDriver(myWebDriver);
//    }
//
////    @AfterTest
////    void destroyMyWebDriver(){
////        logger.info("Kill browsers ...!");
////        if(myWebDriver != null)
////            myWebDriver.quit();
////    }
//
//}