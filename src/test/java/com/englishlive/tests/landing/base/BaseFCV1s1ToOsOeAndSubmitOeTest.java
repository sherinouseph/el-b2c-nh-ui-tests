//package com.englishtown.tests.landing.base;
///**
// *
// */
//import com.englishtown.helpers.WaitTool;
//import com.englishtown.pages.core.BasePage;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.testng.annotations.Test;
//import static com.englishtown.helpers.AssertHelper.myAssertThat;
//
//
//public  abstract class BaseFCV1s1ToOsOeAndSubmitOeTest extends BaseFCV1s1ToOsOeFormsTest {
//    private static final Logger logger = LoggerFactory.getLogger(BaseFCV1s1ToOsOeAndSubmitOeTest.class);
//
//    public static String thankyou_page_url_contains="";
//
//    @Test (priority = 10, dependsOnMethods = { "selectOptionStep3" })
//    void enterOEformDataAndSubmit(){
//        enterFormDataAll(formDataMap);
//        fcLpOEv1s2Page.osformsubmitBtn.click();
//        try{Thread.sleep(stepWait);}catch (Exception e) {}
//    }
//    @Test(dependsOnMethods = {"enterOEformDataAndSubmit"})
//    protected void verifyAtThankyouPage(){
//        //assertThat("Failed .. url does not contains " + thankyou_page_url_contains, BasePage.waitForUrlContains(this.getWebDriver(), thankyou_page_url_contains, 15), Is.is(true)) ;
//        myAssertThat(getWebDriver(), "Failed .. url does not contains " + thankyou_page_url_contains,
//                BasePage.waitForUrlContains(this.getWebDriver(), thankyou_page_url_contains, WaitTool.DEFAULT_WAIT_4_ELEMENT), true) ;
//    }
//
//
//}
//
