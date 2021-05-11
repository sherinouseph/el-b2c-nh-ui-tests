//package com.englishtown.tests.landing.base;
///*
// * Click on link that open checkout page
// */
//import com.englishtown.helpers.WaitTool;
//import com.englishtown.pages.core.BasePage;
//import org.openqa.selenium.By;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.testng.annotations.Test;
//import static com.englishtown.helpers.AssertHelper.myAssertThat;
//
//
//public  abstract class BaseFCV1s1ToOsOeAndClickOSlinkToCheckoutPageTest extends BaseFCV1s1ToOsOeFormsTest {
//    private static final Logger logger = LoggerFactory.getLogger(BaseFCV1s1ToOsOeAndClickOSlinkToCheckoutPageTest.class);
//
//    public static String checkoutUrlContains="buy/default/member";
//
//    @Test (priority = 10, dependsOnMethods = { "selectOptionStep3" })
//    void clickOSCheckoutLink(){
//        fcLpOEv1s2Page.clickCheckout(); //checkoutLink.click();
//        try{Thread.sleep(stepWait);}catch (Exception e) {}
//    }
//    @Test(dependsOnMethods = {"clickOSCheckoutLink"})
//    protected void verifyCheckoutPage(){
//        currWebElement =findElement( By.id("firstname"));
//        myAssertThat(getWebDriver(), "verifyCheckoutPage Failed, element is not displayed ...!", currWebElement.isDisplayed(), true);
//        myAssertThat(getWebDriver(), "Failed .. url does not contains " + checkoutUrlContains,
//                BasePage.waitForUrlContains(this.getWebDriver(), checkoutUrlContains, WaitTool.SHORT_WAIT_4_ELEMENT), true) ;
//    }
//
//
//}
//
