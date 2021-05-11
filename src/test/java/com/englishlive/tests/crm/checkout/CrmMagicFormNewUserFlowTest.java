//package com.englishlive.tests.crm.checkout;
///**
// * Created by nikol.marku on 25-May-17.
// *  https://jira.eflabs.io/browse/SAND-3943
// *
// */
//import com.englishlive.tests.crm.core.BaseCrmMagicForm;
//import com.englishtown.helpers.WaitTool;
//import com.englishtown.pages.common.LoginPage;
//import com.englishtown.tests.core.BaseTestHelper;
//import com.englishtown.tests.core.EfConstants;
//import org.openqa.selenium.By;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//import static org.hamcrest.MatcherAssert.assertThat;
//
//   // crm monitor cover this
//public class CrmMagicFormNewUserFlowTest extends BaseCrmMagicForm {
//    private static final Logger logger = LoggerFactory.getLogger(CrmMagicFormNewUserFlowTest.class);
//
//
//    @BeforeClass
//    protected void setupOpenUrl() {
//        testStartUrl = getBASEURL() + crmMagicFormNewUser;
//        setThreadSafeDriver();
//        phase1OfferPrice="49";
//    }
//
//    @Test
//    void submitCrmMagicFormGoesToPayPage() {
//        //Crm Magic form as new user
//        openUrl(getWebDriver(), testStartUrl);                                                                                          //   WaitTool.waitForCondition( ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(memberSpinnerCss)),getDriver(), WaitTool.MED_WAIT_4_ELEMENT);
//        WaitTool.waitForElementVisibleAndClickable(By.cssSelector(waitForFormElementCss), getWebDriver(), WaitTool.DEFAULT_WAIT_4_ELEMENT);
//        //and: "Enter valid form Details"
//        enterFormData(EfConstants.CRM_MAGICFORM_MAP);
//        enterEmail(getWebDriver(), true);
//        //and: "Submit member form"
//        findElement(By.cssSelector(submitWeCss)).submit();
//    }
//
//    @Test(dependsOnMethods = "submitCrmMagicFormGoesToPayPage")
//    public void removePaymentValidation() {
//        WaitTool.waitForCondition(ExpectedConditions.invisibilityOfElementLocated(
//                By.cssSelector(memberSpinnerCss)), getWebDriver(), 25);
//        WaitTool.waitForElementVisibleAndClickable(By.cssSelector(waitForPayPageCss), getWebDriver(), WaitTool.DEFAULT_WAIT_4_ELEMENT);
//        remove_PaymentValidation();
//    }
//
//    @Test(dependsOnMethods = {"removePaymentValidation"})
//    public void enterPayFormData_and_submit() {
//        enter_PayFormDataAndSubmit();
//    }
//
//    @Test(dependsOnMethods = {"enterPayFormData_and_submit"})
//    public void check_ThankyouPage() {
//        WaitTool.waitForCondition(ExpectedConditions.invisibilityOfElementLocated(
//                By.cssSelector(memberSpinnerCss)), getWebDriver(), 25);
//        checkPaymentThankyouPage(); // url contains thankyou ..
//    }
//
//    @Test(dependsOnMethods = {"check_ThankyouPage"})
//    public void testThankyouPageStateObject() {
//        assertThankyouPageStateObjectElementsNewCheckout();
//
//    }
//
//
//    @AfterClass
//    protected void testAfterClass(){
//        destroyDriver();
//    }
//}
//
///*
//    def "3943 Login Crm Magic form as existing user and check I am at school"() {
//        when: "I open CMR magic form login page as existing user URL"
//        openUrl(crmMagicFormExistingUser );
//        loginPage = new LoginPage(getDriver());
//        loginPage.enterCredentials(USER, PASS);
//
//        and: "Submit Login form"
//        click(By.cssSelector(crmLoginBtnCss));
//
//        then: "I am at school and User avatar is shown"
//        WaitTool.waitForElementVisibleAndClickable(By.cssSelector(schoolWaitForWeCss), getDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
//    }
//
//    def "3943 Open login Crm Magic form and check forgotten pass functionality"() {
//        when: "I open CMR magic form login page as existing user"
//        openUrl(crmMagicFormExistingUser );
//
//        and: "Click forgotten pass link"
//        WaitTool.waitForElementClickable(getDriver(), By.cssSelector(forgottenPassWeCss), WaitTool.DEFAULT_IMPLICIT_WAIT)
//        click(By.cssSelector(forgottenPassWeCss));
//
//        then: "I am at forgotten pas spage"
//        ForgottenPassPage forgottenPassPage = new ForgottenPassPage(getDriver(), WaitTool.DEFAULT_IMPLICIT_WAIT);
//        forgottenPassPage.simpleTest();
//
//        when: "I enter email or username"
//        forgottenPassPage.enterEmailOrUserName("eLiveTesCrmMagict@qp1.org");
//
//        and: "Submit form "
//        click(By.cssSelector(giveMyPassBackBtnCss));
//        loginPage = new LoginPage(getDriver());
//        then: "Login form is shown and TY Message Shown"
//        findElements( By.cssSelector(forgotPassThankYouTxtWe));
//        loginPage.isUsernameDisplayed();
//        List<WebElement> tyPassListWe = findElements( By.cssSelector(forgotPassThankYouTxtWe));
//        String currentTyMsg = TestUtil.getWebElementText(tyPassListWe.get(1));
//        logger.info("Reset pass msg :"+currentTyMsg);
//        assertThat("Is not the expected Thank you message ....!",  currentTyMsg, containsIgnoringCase(forgotPassTyMessage));
//    }
//    */
//
////was before merge to parallel
////package com.englishlive.tests.crm.checkout;
/////**
//// * Created by nikol.marku on 25-May-17.
//// *  https://jira.eflabs.io/browse/SAND-3943
//// *
//// */
////import com.englishlive.tests.crm.core.BaseCrmMagicForm;
////import com.englishtown.helpers.WaitTool;
////import com.englishtown.pages.common.LoginPage;
////import com.englishtown.tests.core.BaseTestHelper;
////import com.englishtown.tests.core.EfConstants;
////import org.openqa.selenium.By;
////import org.openqa.selenium.support.ui.ExpectedConditions;
////import org.slf4j.Logger;
////import org.slf4j.LoggerFactory;
////import org.testng.annotations.BeforeClass;
////import org.testng.annotations.Test;
////import static org.hamcrest.MatcherAssert.assertThat;
////
////// 2 forms on page vahid advice remove test
////public class CrmMagicFormNewUserFlowTest extends BaseCrmMagicForm {
////    private static final Logger logger = LoggerFactory.getLogger(CrmMagicFormNewUserFlowTest.class);
////
////
////    @BeforeClass
////    protected void setupOpenUrl()  {
////        testStartUrl = getBASEURL()+crmMagicFormNewUser;
////    }
////
////    @Test
////    void submitCrmMagicFormGoesToPayPage(){
////        //Crm Magic form as new user
////        openUrl(getWebDriver(), testStartUrl );                                                                                          //   WaitTool.waitForCondition( ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(memberSpinnerCss)),getDriver(), WaitTool.MED_WAIT_4_ELEMENT);
////        WaitTool.waitForElementVisibleAndClickable(By.cssSelector(waitForFormElementCss), getWebDriver(), WaitTool.DEFAULT_WAIT_4_ELEMENT);
////        //and: "Enter valid form Details"
////        enterFormData(EfConstants.CRM_MAGICFORM_MAP);
////        //and: "Submit member form"
////        findElement(By.cssSelector(submitWeCss)).submit();
////    }
////
////    @Test(dependsOnMethods = "submitCrmMagicFormGoesToPayPage")
////    public void removePaymentValidation(){
////        WaitTool.waitForCondition( ExpectedConditions.invisibilityOfElementLocated(
////                By.cssSelector(memberSpinnerCss)),getWebDriver(), 25);
////        WaitTool.waitForElementVisibleAndClickable(By.cssSelector(waitForPayPageCss), getWebDriver(), WaitTool.DEFAULT_WAIT_4_ELEMENT);
////        remove_PaymentValidation();
////    }
////
////    @Test(dependsOnMethods = { "removePaymentValidation" })
////    public void enterPayFormData_and_submit() {
////            enter_PayFormDataAndSubmit();
////    }
////
////    @Test(dependsOnMethods = { "enterPayFormData_and_submit" })
////    public void check_ThankyouPage(){
////        WaitTool.waitForCondition( ExpectedConditions.invisibilityOfElementLocated(
////                By.cssSelector(memberSpinnerCss)),getWebDriver(), 25);
////        checkPaymentThankyouPage(); // url contains thankyou ..
////    }
////
////    @Test(dependsOnMethods = { "check_ThankyouPage" })
////    public void testThankyouPageStateObject(){
////        assertThankyouPageStateObjectElementsNewCheckout();
////
////    }
////
////
////
////
/////*
////    def "3943 Login Crm Magic form as existing user and check I am at school"() {
////        when: "I open CMR magic form login page as existing user URL"
////        openUrl(crmMagicFormExistingUser );
////        loginPage = new LoginPage(getDriver());
////        loginPage.enterCredentials(USER, PASS);
////
////        and: "Submit Login form"
////        click(By.cssSelector(crmLoginBtnCss));
////
////        then: "I am at school and User avatar is shown"
////        WaitTool.waitForElementVisibleAndClickable(By.cssSelector(schoolWaitForWeCss), getDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
////    }
////
////    def "3943 Open login Crm Magic form and check forgotten pass functionality"() {
////        when: "I open CMR magic form login page as existing user"
////        openUrl(crmMagicFormExistingUser );
////
////        and: "Click forgotten pass link"
////        WaitTool.waitForElementClickable(getDriver(), By.cssSelector(forgottenPassWeCss), WaitTool.DEFAULT_IMPLICIT_WAIT)
////        click(By.cssSelector(forgottenPassWeCss));
////
////        then: "I am at forgotten pas spage"
////        ForgottenPassPage forgottenPassPage = new ForgottenPassPage(getDriver(), WaitTool.DEFAULT_IMPLICIT_WAIT);
////        forgottenPassPage.simpleTest();
////
////        when: "I enter email or username"
////        forgottenPassPage.enterEmailOrUserName("eLiveTesCrmMagict@qp1.org");
////
////        and: "Submit form "
////        click(By.cssSelector(giveMyPassBackBtnCss));
////        loginPage = new LoginPage(getDriver());
////        then: "Login form is shown and TY Message Shown"
////        findElements( By.cssSelector(forgotPassThankYouTxtWe));
////        loginPage.isUsernameDisplayed();
////        List<WebElement> tyPassListWe = findElements( By.cssSelector(forgotPassThankYouTxtWe));
////        String currentTyMsg = TestUtil.getWebElementText(tyPassListWe.get(1));
////        logger.info("Reset pass msg :"+currentTyMsg);
////        assertThat("Is not the expected Thank you message ....!",  currentTyMsg, containsIgnoringCase(forgotPassTyMessage));
////    }
////    */
////}
//
