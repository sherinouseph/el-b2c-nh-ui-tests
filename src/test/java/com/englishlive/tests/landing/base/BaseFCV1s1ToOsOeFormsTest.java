//package com.englishtown.tests.landing.base;
///**
// *
// */
//import com.englishtown.pages.fluencycalculator.FCLpOEv1s2Page;
//import com.englishtown.pages.fluencycalculator.FCStep4GraphPage;
//import com.englishtown.pages.fluencycalculator.FluencyCalculatorStartPage;
//import com.englishtown.pages.fluencycalculator.FluencyCalculatorStep1Page;
//import com.englishtown.tests.core.BaseLandingPageTest;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.testng.annotations.Test;
//import static com.englishtown.helpers.AssertHelper.myAssertThat;
//// page changed
//
//public  abstract class BaseFCV1s1ToOsOeFormsTest extends BaseLandingPageTest {
//    private static final Logger logger = LoggerFactory.getLogger(BaseFCV1s1ToOsOeFormsTest.class);
//    //---- GEN pages
//    public int optionIndex = 0;
//    public String ptnValue = "FACE";
//    public String sessionPtnKey = "session.partner_code";
//    public FluencyCalculatorStartPage fluencyCalculatorStartPage = null;
//    public FluencyCalculatorStep1Page fluencyCalculatorStep1Page = null;
//    public FCStep4GraphPage fcStep4GraphPage   = null;
//    public FCLpOEv1s2Page fcLpOEv1s2Page       = null;
//
//
//    @Test (priority = 1)
//    public void clickStartFluencyCalculatorTest(){
//        fluencyCalculatorStartPage = new FluencyCalculatorStartPage(getWebDriver());
//        fluencyCalculatorStartPage.simpleTest();
//        //logger.info(" 2 " + fluencyCalculatorStartPage.startFc.toString().split("->")[1] );
//        fluencyCalculatorStep1Page = fluencyCalculatorStartPage.clickStart();
//        sleep(2000);
//    }
//    @Test (priority = 2 , dependsOnMethods = { "clickStartFluencyCalculatorTest" })
//    void isFluencyCalculatorStep1Test(){
//        myAssertThat(getWebDriver(), "Fluencey Calculator step 1 simpleTest(selectionList.size() > 0) FAILED ",
//                fluencyCalculatorStep1Page.simpleTest(), true);
//    }
//    @Test (priority = 3, dependsOnMethods = { "isFluencyCalculatorStep1Test" })
//    void selectOptionStep1(){
//        fluencyCalculatorStep1Page = fluencyCalculatorStep1Page.clickSelectionList(optionIndex);
//        try{Thread.sleep(stepWait);}catch (Exception e) {}
//    }
//    @Test (priority = 4, dependsOnMethods = { "selectOptionStep1" })
//    void checkStateObjectPTN(){
//        assertStateObjectElementValue(sessionPtnKey,ptnValue,true);
//    }
//    @Test (priority = 5, dependsOnMethods = { "checkStateObjectPTN" })
//    void selectOptionStep2(){
//        myAssertThat(getWebDriver(), "Fluency Calculator step 2 simpleTest FAILED ", fluencyCalculatorStep1Page.simpleTest(), true);
//        fluencyCalculatorStep1Page = fluencyCalculatorStep1Page.clickSelectionList(optionIndex);
//        try{Thread.sleep(stepWait);}catch (Exception e) {}
//    }
//    @Test (priority = 6, dependsOnMethods = { "selectOptionStep2" })
//      void selectOptionStep3(){
//        myAssertThat(getWebDriver(), "Fluency Calculator step 3 simpleTest FAILED ", fluencyCalculatorStep1Page.simpleTest(), true);
//        fcStep4GraphPage = fluencyCalculatorStep1Page.clickSelectionListToGraph(optionIndex);
//        try{Thread.sleep(stepWait);}catch (Exception e) {}
//    }
//    @Test (priority = 7, dependsOnMethods = { "selectOptionStep3" })
//    void checkOEformAndOSFormLink(){
//        myAssertThat(getWebDriver(), "Fluency Calculator step 3 simpleTest FAILED ", fcStep4GraphPage.simpleTest(), true);
//        fcLpOEv1s2Page = fcStep4GraphPage.clickStartToday();
//        try{Thread.sleep(stepWait);}catch (Exception e) {}
//    }
//
//
//    @Override
//    public void verifyLanguage(){ logger.warn("verifyLanguage() -> this test is not run ");  }
//    @Override
//    public void verifyMarket(){  logger.warn("verifyMarket() -> this test is not run ");   }
//
//
//}
//
