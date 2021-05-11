//package com.englishtown.tests.core.landingpages;
//
//import com.englishtown.helpers.AssertHelper;
//import com.englishtown.helpers.JavaScriptHelper;
//import com.englishtown.helpers.WaitTool;
//import com.englishtown.pages.core.BasePage;
//import com.englishtown.tests.core.BaseTestHelper;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.testng.annotations.Test;
//
//import static com.englishtown.helpers.AssertHelper.myAssertThat;
//import static org.hamcrest.CoreMatchers.equalTo;
//import static org.hamcrest.Matchers.is;
//
///**
// * 2017
// * Nikol
// *
// * Base Class for all LP test or any test that enter data and submit form
// *
// */
//public abstract class BaseEnterFormDataAndSubmit extends BaseTestHelper {
//    private static final Logger logger = LoggerFactory.getLogger(BaseTestHelper.class);
//
///**
// * Note : There are issues when 2 test ar run together the second test does not run submit form but verifyTY page
// */
//
////    @Test
////    protected void enterFormDataTest() {
////        if (isPopupShown) {            // need to click to remove pop up            //click(getWebDriver(), By.cssSelector(".pagination-left .cq-dd-image") ); //this.click( getWebDriver().findElement( By.cssSelector(".pagination-left .cq-dd-image")) );
////            waitForElementAndclickAtXY(By.className("modal-dialog"), 5, 5);
////            sleep(500);// clickAtWindow(getWebDriver(), 1, 1);            sleep(1000);
////            logger.info(" POP up should be closed ...!");
////        }
////        if (isUseCssEnterFormData) {
////            enterFormDataCss(formDataMap);
////        } else
////            enterFormData(formDataMap);
////    }                                                                                                                        //    @Test (dependsOnMethods = { "enterOeFormdata" }) protected void verifyTheNumberOfFormElement(){ assertNoOfFormElements(getWebDriver(), By.cssSelector(this.allformElementSelector), this.noOfWebFormElements);}
////
////    @Test(dependsOnMethods = {"enterFormDataTest"})
////    protected void submitForm() {
////        logger.info("Call click to submit form ....!");
////        click(By.cssSelector(submitBtn));
////    }
//
//
////    public static void isFirstLastNamePersisted(WebDriver webDriver, String scriptGetCCName, String equalTo){
////        String fullName =  JavaScriptHelper.executeJavaScript(scriptGetCCName, webDriver, WaitTool.DEFAULT_WAIT_4_ELEMENT);
////        logger.info("validate_is_FirstLastNamePersisted() ...fullName is :" + fullName);
////        if(fullName!=null) {
////            AssertHelper.myAssertThat(webDriver, "FAILED...!, Name not persisted ", fullName, equalTo(equalTo), true); // assertThat("FAILED...!, Name not persisted ", fullName, equalTo(equalTo));
////        } else {
////            BasePage.failTest(" fullName is null ...!", true);
////        }
////
////    }
//
//}