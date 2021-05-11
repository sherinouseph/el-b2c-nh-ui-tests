package com.englishtown.tests.core.login.flows;

import com.englishtown.pages.common.ForgottenPassPage;
import com.englishtown.pages.common.LoginPage;
import com.englishtown.tests.core.BaseTestHelper;
import org.testng.annotations.Test;

/**
 * Created by nikol.marku on 12/29/2016.
 * Forgotten password full test
 * Open login page and click forgotten pass linl
 * submit emty, invalid, blank , username, emails ... check validation msg/or ty page
 *
 */
public abstract class BaseForgotenPassTest extends BaseTestHelper {
    protected LoginPage loginPage;
    protected ForgottenPassPage forgottenPassPage;
    protected String testUsername = "anythingWillDo@nik.nik";
    protected String successfulMsg = "testCaseShouldInitThs";
    protected String userNameValidationMSg = "testCaseShouldInitThs";

    @Test
    public void submitWithoutEnteringAnyDetailsCheckValidationMessage(){
        forgottenPassPage.submit();
        sleep(1000);
        forgottenPassPage.assertValidationMessage();
    }

    @Test (dependsOnMethods = "submitWithoutEnteringAnyDetailsCheckValidationMessage")
    public void submitWithAnyDetailsEnteredCheckValidationMessage(){
        forgottenPassPage.enterEmailOrUserName(testUsername);
        forgottenPassPage.submit();
        sleep(3000);
        forgottenPassPage = new ForgottenPassPage(getWebDriver());
        forgottenPassPage.assertThankyouMessage(successfulMsg);
    }



}
