//package com.englishlive.tests.redirect.all;
///**
// *
// * Run only on Mobile browser and chrome simulator
// */
//
//import com.englishlive.tests.basetest.BaseMobileRedirectTest;
//import com.englishtown.driver.MyBrowserType;
//import com.englishtown.helpers.WaitTool;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeSuite;
//
//
//public class ELiveSamsungS4SimulatorMobileRedirectTest extends BaseMobileRedirectTest {
//    private static final Logger logger = LoggerFactory.getLogger(ELiveSamsungS4SimulatorMobileRedirectTest.class);
//
//    private static int waitTime = WaitTool.DEFAULT_WAIT_4_ELEMENT;
//
//    @BeforeSuite
//    private void setupBroserType() {
//        browserType = MyBrowserType.CHROME_EMULATOR_GALAXY_S4;
//        logger.info("browserType set to : "+browserType);
//    }
//
//    @AfterTest
//    void printTotalErrors(){
//        if(TEST_COUNT.get() - TEST_ENDCOUNT.get() == 0){
//            logger.info("\n\n\t\tAll [{}] test passed ...!\n\n", TEST_COUNT);
//        }else {
//            logger.error("\n\n\t\tNOT all test passed ...!\n");
//            logger.error("printTotalErrors ...!   Test Run No:"+TEST_COUNT.get()+" - Test Failure :" +(TEST_COUNT.get() - TEST_ENDCOUNT.get())+"\n\n");
//        }
//    }
//
//}