package com.englishtown.tests.core.school;
/**
 * On login page
 * Login an existing user
 * no other checks ...
 *
 * User: nikol.marku
 * Date: 08/03/18
 *
 */


import com.englishtown.helpers.WaitTool;
import com.englishtown.pages.common.LoginPage;
import com.englishtown.pages.schoollite.EfIdLoginPage;
import com.englishtown.tests.core.school.core.BaseSchoolTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public abstract class BaseLogin extends BaseSchoolTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseLogin.class);


    @Test
    protected void enterUserCredentialsAndLoginToSchool(){
//        logger.info("enterUserCredentialsAndLogin  ...!");
//        loginPage = new LoginPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
//        loginPage.getPageLoadedCondition();
//        loginPage.simpleTest();
//        loginPage.enterCredentials(username, password);
//        loginPage.clickLoginBtn(loginPage.loginBtnLatest);
        //temporary use of efid login page
        logger.info("enterUserCredentialsAndLogin  ...!");
        efIdLoginPage = new EfIdLoginPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        efIdLoginPage.getPageLoadedCondition();
        efIdLoginPage.simpleTest();
        efIdLoginPage.enterCredentials(username, password);
       // sleep(1000);
        efIdLoginPage.clickLoginBtn(efIdLoginPage.loginBtn);
    }


//    @Test(dependsOnMethods = "enterUserCredentialsAndLogin")
//    protected void waitForSchoolURL(){
//        logger.info("waitForSchoolURL  ...!"+waitForUrlContains);
//        waitForUrlContains(getWebDriver(), waitForUrlContains, WaitTool.MED_WAIT_4_ELEMENT);
//    }


}
