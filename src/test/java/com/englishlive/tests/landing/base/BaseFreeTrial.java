package com.englishlive.tests.landing.base;
//
///**
// * Created by sherin 12/09/2018
// *Test 3 flows
// *
// *n
// * 1. new_user= open  page,Enter form data and submit,check new passwordform shown,submit,check enrollment Page shown
// * 2. same users as above .. LoggedinUser/student=open Page,Enter form data ,check login page shown, submit ,enrollment Page shown
// * 3. new member only ... not payied ... user =open  page,Enter form data check Login Page shown, submit,check welcome button,check enrollment
// *
// * Added showpassword text -Sherin - 22/09/2017
// *//   RCODES :
//    SYSONLY-FRTRIAL2E98D9B9F4E64FA   (for fr)
//    SYSONLY-ROLATRIAL3227BAF6        (for mx)
// */

/**
 * NM Flow 1
 * 1. open free trial form and enter data and submit
 * 2. enter password and submit
 * 3. enroll page shown
 *
 * * NM Flow 2
 * 1. open free trial form and enter data and submit [use the same users as above]
 * 2. enter Login credentials and submit [ login page here]
 * 3. enroll page shown
 *
 * * NM Flow 3
 * 1. Create new member on member page but do not pay
 * 2. open free trial form and enter data and submit .. user the same email as above
 * 3. enter Login credentials and submit [ login page here]
 * 3. Welcome page shown should ber /fr-fr/welcome back*  not /fr-fr/buy/default/welcome back...
 */

import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.CookieHandler;
import com.englishtown.helpers.WaitTool;
import com.englishtown.pages.common.LoginPage;
import com.englishtown.tests.core.BaseTestConfig;
import com.englishtown.tests.core.BaseTestHelper;
import com.englishtown.tests.core.EfConstants;
import com.englishtown.tests.core.UniqueDataObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.util.Map;


public abstract class BaseFreeTrial extends BaseTestHelper {
    public static final Logger logger = LoggerFactory.getLogger(BaseFreeTrial.class);
    protected Map  passwordmap;
    //protected  String testurl;
    public String emailToken = new UniqueDataObject().getEmail();
    public String memberemail;
    protected String passwordFormMsgContains ;
    protected String memberPageUrl;
    protected String loginLinkCss = "nav a[href='/es-mx/login/']";
    protected  boolean showPassword=true;
    protected String passwordtypeselector="password";
    protected String loginFormMsgContains;
    protected String showPasswordTxtCss=".label .icon";//".showpassword .showpassword-icon";
    protected String welcomeBackMsgTxtCss = ".existing-user .heading .inline-text";
    protected String welcomeBackMsgContains;
    protected String urlContainsquestionnaire ="welcome";
    protected String urlContainslogin ="login";
    protected String loginMsgTxtCss = ".caption";

    protected String urlContainsenrollment ="enrollment";
    protected String passwordMsgTxtCss     = ".inline-text";
    protected String submitFormBtnCss      = ".formset-button .btn.btn-primary";
    protected String passwordsubmitBtnCss  = ".btn.btn-primary";
    protected String welcomeBackBtnCss     = ".existing-user .btn.btn-secondary";

    LoginPage loginPage ;
    static String password1 = BaseTestConfig.getPassword8();


    @Test
    void enterFrreFormDetails() {
        enterFormData(formDataMap, emailToken);
    }

    @Test(dependsOnMethods = "enterFrreFormDetails")
    void submitForm () {
        click(getWebDriver(), By.cssSelector(submitFormBtnCss));
        logger.info(("Form submitted"));
    }

    @Test(dependsOnMethods = "submitForm")
    void checkquestionnaireShown_forNewUSer (){
        assertIsUrlContaining(urlContainsquestionnaire);
    }

    @Test(dependsOnMethods ="checkquestionnaireShown_forNewUSer")
    void checkPasswordForm(){
        waitForElementCondition(ExpectedConditions.elementToBeClickable(By.name("password")), getWebDriver(), 25);
        AssertHelper.assertWebElementDisplayed(findElement(By.name("password")));
        String Welcome = getText(findElement(By.cssSelector(passwordMsgTxtCss)));
        logger.info("Password form message shown ....! " + passwordFormMsgContains);
        /*if( ! StringUtils.equals(getENVIRONMENT(), "live")){
            openUrl(getWebDriver(), TestUtil.getCurrentUrl(getWebDriver())+freeTrialRcode);
            sleep(1000);
        }*/
    }



    @Test(dependsOnMethods ="checkPasswordForm" )
    public void fillPasswordForm(){
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
        findElement(By.cssSelector(passwordsubmitBtnCss),50).click();
    }

    @Test(dependsOnMethods ="submitPasswordForm")
    void checkEnrollmentPage() {
        enrollment();
    }

    @Test(dependsOnMethods = "checkEnrollmentPage")
    void openFreeFormPageReuseSameEmailAndSubmit() {
        sleep(1000);
        CookieHandler.deleteCookies(getWebDriver());
        sleep(2000);
        //openUrl(getWebDriver(), testStartUrl.replace("?", "login?"));
        logger.info("Checking the flow for Student " +testStartUrl);
        openUrl(getWebDriver(),testStartUrl);
        sleep(1000);
        refresh(getWebDriver());
        sleep(2000);
        waitForElementCondition(ExpectedConditions.elementToBeClickable(By.name("first_name")), getWebDriver(), 35);
        enterFormData(formDataMap, emailToken);
        click(getWebDriver(), By.cssSelector(submitFormBtnCss));
    }

    @Test(dependsOnMethods = "openFreeFormPageReuseSameEmailAndSubmit")
    void enterLoginCredentialsAndSubmit() {
        loginPage();
        loginPage = new LoginPage(getWebDriver());
        loginPage.enterCredentialsAndClickLogin(emailToken, password1);
    }
    @Test(dependsOnMethods = "enterLoginCredentialsAndSubmit")
    void checkEnrollmentPageshown () {
        logger.info("Checking if Enrollment Page is Shown");
        enrollment();

    }

    @Test(dependsOnMethods = "checkEnrollmentPageshown")
    void createNewMemberFillTrialForm() {
        createMemberUser();
        sleep(1000);
        CookieHandler.deleteCookies(getWebDriver());
        sleep(1000);
        //openUrl(getWebDriver(), testStartUrl.replace("?", "login?"));
        logger.info("Checking the flow for Student  " +testStartUrl);
        openUrl(getWebDriver(),testStartUrl);
        sleep(1000);
        refresh(getWebDriver());
        sleep(2000);
        enterFormData(formDataMap, memberemail);
        click(getWebDriver(), By.cssSelector(submitFormBtnCss));
    }

    @Test(dependsOnMethods = "createNewMemberFillTrialForm")
    void loginAndSubmit_NewMember() {
        loginPage = new LoginPage(getWebDriver());
        loginPage.enterCredentialsAndClickLogin(memberemail, password1);
    }

    @Test(dependsOnMethods = "loginAndSubmit_NewMember")
    void checkWelcomeBack_shown() {
        logger.info("Checking if Welcome Back Page is Shown");
        welcomeBack(); // should not be https://englishlive.ef.com/en-gb/buy/welcome-back/member/
        logger.info("Checking if Enrollment Page is Shown");
        enrollment();
    }

    void enterFormData(Map formData, String email){
        enterFormData(formData);
        getWebDriver().findElement(By.name("email")).clear();
        getWebDriver().findElement(By.name("email")).sendKeys(email);
        logger.info("Email Id " +email);
    }

    void enrollment() {
        sleep(2000);
        assertIsUrlContaining(urlContainsenrollment);
    }

    void loginPage() {
        assertIsUrlContaining(urlContainslogin);
        AssertHelper.assertWebElementDisplayed(findElement(By.name("UserName")));
        String LoginMsg = getText(findElement(By.cssSelector(loginMsgTxtCss)));
        logger.info(getWebDriver().getCurrentUrl()+ " Login message is " + loginFormMsgContains);
    }

    void welcomeBack() {
        //TODO check the URL is the correct one then check page ... should be fr-fr/welcome...? login
        WaitTool.waitForElementVisible(getWebDriver(),By.cssSelector(welcomeBackBtnCss),25);
        AssertHelper.assertWebElementDisplayed(findElement(By.cssSelector(welcomeBackBtnCss)));
        String welcomeBackMsg = getText(findElement(By.cssSelector(welcomeBackMsgTxtCss)));
        logger.info("Welcome Back  message shown ....! " + welcomeBackMsgContains);
        click(getWebDriver(), By.cssSelector(welcomeBackBtnCss));


    }

    void clickshowPassword(){
        waitForElementCondition(ExpectedConditions.elementToBeClickable(By.cssSelector(showPasswordTxtCss)), getWebDriver(), 25);
        click(getWebDriver(), By.cssSelector(showPasswordTxtCss));
        WebElement passwordField=findElement(By.name(passwordtypeselector));
        AssertHelper.assertStringContains(passwordField.getAttribute("type"),"text","Type should be text");
        logger.info("Password type is "+passwordField.getAttribute("type"));
    }

    void clickOnshowPasswordAgain(){
        waitForElementCondition(ExpectedConditions.elementToBeClickable(By.cssSelector(showPasswordTxtCss)), getWebDriver(), 25);
        click(getWebDriver(), By.cssSelector(showPasswordTxtCss));
        WebElement passwordField=findElement(By.name(passwordtypeselector));
        AssertHelper.assertStringContains(passwordField.getAttribute("type"),"password","Type should be password when I click on the show password icon second time");
        logger.info("Password type is "+passwordField.getAttribute("type"));
    }

    void createMemberUser(){
        CookieHandler.deleteCookies(getWebDriver());
        getWebDriver().get(memberPageUrl);
        enterFormData(EfConstants.ukMembersFormMap_new); //_MEMBER_FORM);
        WebElement emailId = getWebDriver().findElement(By.name("email"));
        memberemail = new UniqueDataObject().getEmail();
        emailId.clear();
        emailId.sendKeys(memberemail);
        logger.info("Email Id" +memberemail);
        emailId.submit();
    }


}
