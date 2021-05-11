//package com.englishlive.tests.hreflen;
///**
// *
// *
// */
//
//import com.englishlive.tests.basetest.htmlunit.BaseCheckHrefLenAltenate;
//import com.englishtown.helpers.WebClientResponseHelper;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
//// href removed from pages except rola
//public class DEhreflenAlternateHtmlUnitTest extends BaseCheckHrefLenAltenate  {
//    private static final Logger logger = LoggerFactory.getLogger(DEhreflenAlternateHtmlUnitTest.class);
//    @Value("#{applicationPropertiesList['home.page.de']}")
//    private String testUrl;
//
//
//    @BeforeClass
//    private void setupOpenUrl(){
//        WebClientResponseHelper.setOptions( false );
//        market = "de";
//        initChrome();
//        myWebDriver = chrome; // needs a static driver
//        openUrl(myWebDriver, testUrl);
//        sleep(3000);
//    }
//
////    @AfterTest
////    void printTotalErrors(){
////        logger.info("AfterClass printTotalErrors ...!");
////        if(TEST_COUNT - TEST_ENDCOUNT == 0){
////            logger.info("\n\n\t\tAll test passed ...!\n\n");
////        }else {
////            logger.error("\n\n\t\tNOT all test passed ...!\n");
////            logger.error("printTotalErrors ...!   Test Run No:"+TEST_COUNT+" - Test Failure :" +(TEST_COUNT - TEST_ENDCOUNT)+"\n\n");
////        }
////        logger.info(" destroyDrivers ...!");
////        destroyDriver(chrome);
////        destroyDriver(myWebDriver);
////    }
//
////    @AfterTest
////    void destroyMyWebDriver(){
////        logger.info("Kill browsers ...!");
////        if(myWebDriver != null)
////            myWebDriver.quit();
////    }
//
//}