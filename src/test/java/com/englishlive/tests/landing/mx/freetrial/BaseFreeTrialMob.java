package com.englishlive.tests.landing.mx.freetrial;
//
///**
// * Created by sherin 12/09/2018
// *Test 3 flows for Mobile
// *
// *n
// * 1. new_user= open  page,Enter form data and submit,check new passwordform shown,submit,check Thank you Page shown
// * 2. NotLoggedinUSer=open  page,Enter form data ,check Login Page shown, submit,check Thank You Page
// * 3. LoggedinUser=open Page,Enter form data check Welcome Back Page shown, submit ,Thank you shown
// *
// 23/10/2017 - separate flow for mobile is valid only for new user.hence commenting out rest of the flow.
//   RCODES :
//    SYSONLY-FRTRIAL2E98D9B9F4E64FA   (for fr)
//    SYSONLY-ROLATRIAL3227BAF6        (for mx)
// */

import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.CookieHandler;
import com.englishtown.helpers.WebDriverWindowHelper;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.pages.common.CookiePage;
import com.englishtown.pages.common.LoginPage;
import com.englishtown.tests.core.BaseTestConfig;
import com.englishtown.tests.core.BaseTestHelper;
import com.englishtown.tests.core.EfConstants;
import com.englishtown.tests.core.UniqueDataObject;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.util.Map;

import static org.hamcrest.Matchers.containsString;


public abstract class BaseFreeTrialMob extends BaseTestHelper {
    public static final Logger logger = LoggerFactory.getLogger(BaseFreeTrialMob.class);
    protected Map  passwordmap;
    protected String memberPageUrl;
    public String memberemail;
    protected  boolean showPassword=true;
    protected String urlContainsenrollment ="enrollment";
    protected String passwordtypeselector="password";
    public String emailToken = new UniqueDataObject().getEmail();
    protected String passwordFormMsgContains ;
    protected String showPasswordTxtCss=".showpassword .showpassword-icon";
    protected String thankYouMsgContains;
    protected String loginFormMsgContains;
    protected String urlContainsItunes = "itunes";
    protected String google="google";
    protected String welcomeBackMsgTxtCss = ".existing-user .heading .inline-text";
    protected String anderoidStoreCss= ".app-store .app-store-ctas .android a";//".existing-user .app-store-ctas .android";
    protected String iphoneStoreCss  = ".app-store .app-store-ctas .iphone img"; //".app-store .app-store-ctas .iphone";
    protected String appStoreUrlCss = ".app-store .iphone a"; // link to upstore https://itunes.apple.com/mx/app/ef-english-live-for-iphone/id961304373?mt=8
    protected String appStoreAppId = "id961304373";    // at the end of the url above
    protected String googleStoreUrlCss = ".app-store .android a";
    protected String googlePlayId = "com.ef.core.engage.englishtown";
    protected String welcomeBackMsgContains ;
    protected String urlContainsquestionnaire ="welcome";
    protected String urlContainslogin ="login";
    protected String loginMsgTxtCss = ".caption";
    protected String thankYouMsgTxtCss = ".app-store .heading .inline-text";
     protected String passwordMsgTxtCss = ".inline-text";
    protected String submitFormBtnCss  = ".btn.btn-primary";
    protected String passwordsubmitBtnCss  = ".btn.btn-secondary";
    protected String welcomeBackMsgCss  = ".existing-user .heading'";
    LoginPage loginPage ;
    static String password1= BaseTestConfig.getPassword8();


    @Test
    void enterFormDetails() {
        enterFormData1();
    }

    @Test(dependsOnMethods = "enterFormDetails")
    void submitForm () {
        sleep(500);
        click(getWebDriver(), By.cssSelector(submitFormBtnCss));
        logger.info(("Form submitted"));
    }

    @Test(dependsOnMethods = "submitForm")
    void checkquestionnaireShown_forNewUSer (){
        assertIsUrlContaining(urlContainsquestionnaire);
    }

    @Test(dependsOnMethods ="checkquestionnaireShown_forNewUSer")
    void checkPasswordForm(){
        waitForElementCondition(ExpectedConditions.elementToBeClickable(By.name("password")), getWebDriver(), 5000);
        AssertHelper.assertWebElementDisplayed(findElement(By.name("password")));
        String passMsgText = getText(findElement(By.cssSelector(passwordMsgTxtCss)));
        AssertHelper.myAssertThat(getWebDriver(), "Not the expected  msg ...!", passMsgText, containsString(passwordFormMsgContains), true);
        logger.info("Correct message shown ....! " + passwordFormMsgContains);
        //reload pass pagepage with rcode to make it work on QA
        /*if( ! StringUtils.equals(getENVIRONMENT(), "live")){
            openUrl(getWebDriver(), TestUtil.getCurrentUrl(getWebDriver())+freeTrialRcode);
            sleep(1000);
        }*/
    }

    @Test(dependsOnMethods ="checkPasswordForm" )
    void fillPasswordForm(){
        enterFormData(passwordmap);
    }
    @Test(dependsOnMethods ="fillPasswordForm" )
    void checkShowPassword() {
        if (showPassword) {
            clickshowPassword();
            clickOnshowPasswordAgain();
        }
        else
            logger.info("Show Password not enabled");
    }

    @Test(dependsOnMethods ="checkShowPassword")
    void submitPasswordForm() {
        findElement(By.cssSelector(submitFormBtnCss),50).click();
    }

    @Test(dependsOnMethods ="submitPasswordForm")
    void checkThankyouPage() {
        logger.info("Checking thank you page");
        checkThankYouPage();
    }

    @Test(dependsOnMethods = "checkThankyouPage")
    void checkAndroidOrAppleStoreUrlsContainsAppId(){
        if(is_iOStest) {
            logger.info("Running iOS test .. check appstore id is present on url ...!");
            checkUrlContainsAppId(appStoreAppId, appStoreUrlCss);
        }else {
            logger.info("Running iOS test .. check android store id is present on url ...!");
            checkUrlContainsAppId(googlePlayId, googleStoreUrlCss);
        }
    }

    void checkAppleStore(){
        WebElementHelper.click(findElement(By.cssSelector(iphoneStoreCss)));
        waitForUrlContains(getWebDriver(), urlContainsItunes, 25 );
        assertIsUrlContaining(urlContainsItunes);
   }

    void checkUrlContainsAppId(String appId, String cssSelector){
        WebElement appUrlWe = findElement(By.cssSelector(cssSelector));
        String appUrl = getAttributeValue(appUrlWe, "href");
        AssertHelper.assertThat("App id is not present in url ...!", appUrl, containsString(appId));
    }

    void checkGooglePlayStore(){
        WebElement android= findElement(By.cssSelector(anderoidStoreCss),25);
        String href = android.getAttribute("href");
        AssertHelper.assertStringContains(href,"google.com","link not present");
    }

    void enterFormData1(){
        enterFormData(formDataMap);
        getWebDriver().findElement(By.name("email")).clear();
        getWebDriver().findElement(By.name("email")).sendKeys(emailToken);
        logger.info("Email Id" +emailToken);
    }

    void checkThankYouPage() {
        findElement(By.cssSelector(thankYouMsgTxtCss),100);
        String thankYouMsg = getText(findElement(By.cssSelector(thankYouMsgTxtCss)));
        AssertHelper.myAssertThat(getWebDriver(), "Not the expected Login msg ...!", thankYouMsg, containsString(thankYouMsgContains), true);
       logger.info("Correct message shown ....! " + thankYouMsgContains);
    }
    void enrollment() {
        sleep(8000);
        assertIsUrlContaining(urlContainsenrollment);

    }

    void loginPage() {
        assertIsUrlContaining(urlContainslogin);
        AssertHelper.assertWebElementDisplayed(findElement(By.name("UserName")));
        String LoginMsg = getText(findElement(By.cssSelector(loginMsgTxtCss)));
        AssertHelper.myAssertThat(getWebDriver(), "Not the expected Login msg ...!", LoginMsg, containsString(loginFormMsgContains), true);
        logger.info("Correct message shown ....! " + loginFormMsgContains);

    }
    void welcomeBack() {
        AssertHelper.assertWebElementDisplayed(findElement(By.cssSelector(welcomeBackMsgTxtCss)));
        String welcomeBackMsg = getText(findElement(By.cssSelector(welcomeBackMsgTxtCss)));
        AssertHelper.myAssertThat(getWebDriver(), "Not the expected  msg ...!", welcomeBackMsg, containsString(welcomeBackMsgContains), true);
       logger.info("Correct message shown ....! " + welcomeBackMsgContains);
    }
    void clickshowPassword(){
        waitForElementCondition(ExpectedConditions.elementToBeClickable(By.cssSelector(showPasswordTxtCss)), getWebDriver(), 5000);
        click(getWebDriver(), By.cssSelector(showPasswordTxtCss));
        WebElement passwordField=findElement(By.name(passwordtypeselector));
        AssertHelper.assertStringContains(passwordField.getAttribute("type"),"text","Type should be text");
        logger.info("Password type is "+passwordField.getAttribute("type"));
    }

    void clickOnshowPasswordAgain(){
        waitForElementCondition(ExpectedConditions.elementToBeClickable(By.cssSelector(showPasswordTxtCss)), getWebDriver(), 5000);
        click(getWebDriver(), By.cssSelector(showPasswordTxtCss));
        WebElement passwordField=findElement(By.name(passwordtypeselector));
        AssertHelper.assertStringContains(passwordField.getAttribute("type"),"password","Type should be password when I click on the show password icon second time");
        logger.info("Password type is "+passwordField.getAttribute("type"));
    }
    void createMemberUser(){
        CookieHandler.deleteCookies(getWebDriver());
        getWebDriver().get(memberPageUrl);
        enterFormData(EfConstants.deMembersFormMap);
        WebElement emailId = getWebDriver().findElement(By.name("email"));
        memberemail=new UniqueDataObject().getEmail();
        emailId.clear();
        emailId.sendKeys(memberemail);
        logger.info("Email Id" +memberemail);
        emailId.submit();
    }

}



//
//
//    @Test(dependsOnMethods = "checkAppStore")
//    void fillForm_forStudent() {
//        CookieHandler.deleteCookies(getWebDriver());
//        //openUrl(getWebDriver(), testStartUrl.replace("?", "login?"));
//        logger.info("Checking the flow for Student " +testStartUrl);
//        openUrl(getWebDriver(),testStartUrl);
//        enterFormData1();
//        click(getWebDriver(), By.cssSelector(submitFormBtnCss));
//
//
//    }
//
//    @Test(dependsOnMethods = "fillForm_forStudent")
//    void loginAndSubmit() {
//        loginPage();
//        loginPage = new LoginPage(getWebDriver());
//        loginPage.enterCredentialsAndClickLogin(emailToken,password1);
//    }
//    @Test(dependsOnMethods = "loginAndSubmit")
//    void checkEnrollmentPageshown () {
//        logger.info("Checking if Enrollment Page is Shown");
//        enrollment();
//
//    }
//
//    @Test(dependsOnMethods = "checkEnrollmentPageshown")
//    void fillForm_forMember() {
//        createMemberUser();
//        CookieHandler.deleteCookies(getWebDriver());
//        //openUrl(getWebDriver(), testStartUrl.replace("?", "login?"));
//        logger.info("Checking the flow for Student  " +testStartUrl);
//        openUrl(getWebDriver(),testStartUrl);
//        enterFormData1();
//        click(getWebDriver(), By.cssSelector(submitFormBtnCss));
//
//
//    }
//
//    @Test(dependsOnMethods = "checkEnrollmentPageshown")
//    void loginAndSubmit_Member() {
//        loginPage = new LoginPage(getWebDriver());
//        loginPage.enterCredentialsAndClickLogin(memberemail,password1);
//    }
//
//    @Test(dependsOnMethods = "loginAndSubmit_Member")
//    void checkWelcomeBack_shown()
//    { logger.info("Checking if Welcome Back Page is Shown");
//        welcomeBack();
//        logger.info("Checking if Enrollment Page is Shown");
//        enrollment();
//    }