package com.englishtown.tests.core.login.flows;

import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.mail.ReadMail;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.newhouse.school.pages.home.SchoolHeaderAndFooterPage;
import com.englishtown.newhouse.school.pages.home.SchoolHeaderPage;
import com.englishtown.pages.common.ForgottenPassPage;
import com.englishtown.pages.common.LoginPage;
import com.englishtown.pages.common.NewHouseChangePassPage;
import com.englishtown.pages.common.NewHouseForgottenPassPage;
import com.englishtown.tests.core.BaseTest;
import com.englishtown.tests.core.BaseTestHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

/**
 * Created by nikol.marku on 12/12/2018.
 * Forgotten password full test
 * Open login page and click forgotten pass link
 * submit empty, invalid, check message
 * enter any username, emails ... check validation msg/or ty page
 * enter valid username
 * check emails and get URL to reset pass
 * open reset pass page and reset password
 * Not tested :> Reuse reset pass urls [this is valid for 24 hours ..]
 *
 */
public abstract class BaseNhForgotenPassTest extends BaseTestHelper {
    private static final Logger logger = LoggerFactory.getLogger(BaseNhForgotenPassTest.class);
    protected LoginPage loginPage;
    protected ForgottenPassPage forgottenPassPage;
    protected NewHouseForgottenPassPage newHouseforgottenPassPage;
    protected NewHouseChangePassPage newHouseChangePassPage;
    protected String testUsername = "anythingWillDo@nik.nik";
    protected String successfulMsg = "testCaseShouldInitThs";
    protected String userNameValidationMSg = "testCaseShouldInitThs";
    protected String thankYouSubmitEmailMsg = "Thank you";
    protected int findEmailsFromDateTime = -300; /// use emails from last 10 mins when search for emails no older
    protected int waitToFindEmailSec = 155;
    protected int WAIT_60 = 60;
    protected int WAIT_100 = 100;
    protected int WAIT_200 = 200;
    protected String newPass;
    public String eLiveLogoCss  = "logo";
    public String schoolLogoCss = "ue-logo";

    /* @Test
    public void testEmail(){
        String resetPassUrl = ReadMail.getForgetPassUrlFromMail(ReadMail.getMail(ReadMail.PASS_RESET_EMAIL_SUBJECT,
                ReadMail.G_HOST, ReadMail.G_USERNAME, ReadMail.C, getENVIRONMENT(), 1,
                findEmailsFromDateTime));
        logger.info("url [{}] ...", resetPassUrl);
    }*/

    @Test
    public void submitWithoutEnteringAnyDetailsCheckValidationMessage(){
        forgottenPassPage.submit();
        sleep(1000);
        forgottenPassPage.assertValidationMessage();
    }


    @Test (dependsOnMethods = "submitWithoutEnteringAnyDetailsCheckValidationMessage")
    public void submitWith_ValidEmailCheckValidationMessage(){
        forgottenPassPage.enterEmailOrUserName(testUsername);
        forgottenPassPage.submit();
        sleep(500);

        WaitTool.waitForCondition(ExpectedConditions.elementToBeClickable(By.cssSelector(" .the.message p")),
                getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        forgottenPassPage = new ForgottenPassPage(getWebDriver(), 25);
        forgottenPassPage.assertThankyouMessage(successfulMsg);
    }

    // changed not needed @Test (dependsOnMethods = "submitWith_ValidEmailCheckValidationMessage")
    public void enterEmailOnNewForgetPassPageCheckThankyouMsg(){
        newHouseforgottenPassPage = new NewHouseForgottenPassPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        newHouseforgottenPassPage.getPageLoadedCondition();
        newHouseforgottenPassPage.simpleTest();
        newHouseforgottenPassPage.enterEmail(testUsername);
        sleep(300);
        newHouseforgottenPassPage.submit();
        sleep(3000);
        newHouseforgottenPassPage = new NewHouseForgottenPassPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        newHouseforgottenPassPage.checkThankyouMsg(thankYouSubmitEmailMsg);
    }

    //@Test (dependsOnMethods = "enterEmailOnNewForgetPassPageCheckThankyouMsg")
    @Test (dependsOnMethods = "submitWith_ValidEmailCheckValidationMessage")
    public void getResetPasswordURLfromEmailAndChangePass(){
        destroyDriver();
        sleep(100000);
        String resetPassUrl = ReadMail.getForgetPassUrlFromMail(ReadMail.getMail(ReadMail.PASS_RESET_EMAIL_SUBJECT,
                ReadMail.G_HOST, ReadMail.G_USERNAME, ReadMail.C, getENVIRONMENT(), WAIT_200,
                findEmailsFromDateTime));

        if(!TestUtil.validateUrl(resetPassUrl))
            BaseTest.failTest("Url is not valid ["+ resetPassUrl +"]");

        setThreadSafeDriver();
        openUrl(getWebDriver(), resetPassUrl);
        newHouseChangePassPage = new NewHouseChangePassPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        newHouseChangePassPage.getPageLoadedCondition();
        newHouseChangePassPage.simpleTest();
        newPass = TestUtil.generateRandomStringNumber(4, 4);
        newHouseChangePassPage.enterPasswords(newPass);
        newHouseChangePassPage.submit();
        sleep(1000);
    }

    @Test (dependsOnMethods = "getResetPasswordURLfromEmailAndChangePass")
    public void checkUserIsLogedinToSchool(){
        waitForUrlContains(getWebDriver(), "1/campus/mypage/home", WaitTool.MED_WAIT_4_ELEMENT);
    }

    @Test(dependsOnMethods = "checkUserIsLogedinToSchool")
    protected void logoutAndCheckUserOutOfSchoolTest(){
        SchoolHeaderPage schoolHeaderPage = new SchoolHeaderPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        schoolHeaderPage.getPageLoadedCondition();
        schoolHeaderPage.goToMyAccountAndLogout();
        // assert logout
        waitForElementCondition(ExpectedConditions.invisibilityOfElementLocated(By.className(schoolLogoCss)),
                getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        waitForElementCondition(ExpectedConditions.elementToBeClickable(By.className(eLiveLogoCss)),
                getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
    }

    @Test(dependsOnMethods = "logoutAndCheckUserOutOfSchoolTest")
    protected void enterUserCredentialsAndLoginToSchool(){
        logger.info("enterUserCredentialsAndLogin  ...!");
        loginPage = new LoginPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        loginPage.getPageLoadedCondition();
        loginPage.simpleTest();
        loginPage.enterCredentials(testUsername, newPass);
        loginPage.clickLoginBtn(loginPage.loginBtnLatest);
    }

    @Test(dependsOnMethods = "enterUserCredentialsAndLoginToSchool")
    protected void checkUserIsAtSchoolHomePage(){
        logger.info("checkUserIsAtSchoolHomePage  ...!" + "1/campus/mypage/home");
        waitForUrlContains(getWebDriver(), "1/campus/mypage/home", WaitTool.MED_WAIT_4_ELEMENT);
        schoolHeaderAndFooterPage = new SchoolHeaderAndFooterPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        schoolHeaderAndFooterPage.getPageLoadedCondition();
        schoolHeaderAndFooterPage.simpleTest();
    }

}





/**
 // Getting  a UrlValidator
UrlValidator defaultValidator = new UrlValidator();
        return defaultValidator.isValid(url);



        try {
                new URL(url).toURI();
                return true;
                }
                catch (URISyntaxException exception) {
                return false;
                }

                catch (MalformedURLException exception) {
                return false;
                }
 */