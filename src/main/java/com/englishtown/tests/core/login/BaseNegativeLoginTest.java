package com.englishtown.tests.core.login;
/**
 * Created by nikol.marku on 12/30/2016.
 * Open login page
 * click login ... username validation shown
 * Enter username and click login .... pass validation shown
 * Enter pass and login ... check cant login msg shown
 *
 */
import com.englishtown.driver.BaseRemoteWebDriver;
import com.englishtown.pages.common.LoginPage;
import com.englishtown.tests.core.BaseTestHelper;
import org.testng.annotations.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public abstract class BaseNegativeLoginTest extends BaseTestHelper {
    private static final Logger logger = LoggerFactory.getLogger(BaseNegativeLoginTest.class);
    protected LoginPage loginPage;
    protected String testUsername = "anythingWillDo@nik.nik";
    protected String testPass     = "anythingWillDo";
    protected String userNameValidationMsg;
    protected String passValidationMsg;
    protected String loginFailedMsg;

    @Test
    public void submitWithoutEnteringAnyDetailsCheckUsernameValidationMessage(){
        loginPage.login();
        loginPage.setUserNameValidationMsg(userNameValidationMsg);
        sleep(2000);
        loginPage.assertValidationMessage(loginPage.userNameValidationMsg);
    }

    @Test (dependsOnMethods = "submitWithoutEnteringAnyDetailsCheckUsernameValidationMessage")
    public void enterEmailAndSubmitCheckPassValidationMessage(){
        //executeJSscript("document.querySelectorAll('[name=UserName]').blur()", getWebDriver(), 2);
        loginPage.enterUserName(testUsername);
        click(loginPage.userName);
        sleep(2000);
        loginPage.login();
        //for edge need to click twice ... event not fired when typed on email so prev msg still there
        if(BaseRemoteWebDriver.isBrowser("edge"))
            loginPage.login();
        loginPage.setPassValidationMsg(passValidationMsg);
        sleep(3000);
        loginPage.assertValidationMessage(loginPage.passValidationMsg);
    }

    @Test (dependsOnMethods = "enterEmailAndSubmitCheckPassValidationMessage")
    public void enterWrongPassAndUsernameAndSubmitCheckPassValidationMessage(){
        loginPage.enterPassword("failme");
        loginPage.login();
        sleep(3000);
        loginPage.setLoginFailedMsg(loginFailedMsg);
        loginPage.assertLoginFailedMessage();
    }


}
