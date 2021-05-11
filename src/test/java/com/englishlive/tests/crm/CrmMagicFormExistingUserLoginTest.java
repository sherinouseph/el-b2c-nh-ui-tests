package com.englishlive.tests.crm;
/**
 * Created by nikol.marku on 25-May-17.
 *  https://jira.eflabs.io/browse/SAND-3943
 *
 */

import com.englishlive.tests.crm.core.BaseCrmMagicForm;
import com.englishtown.helpers.WaitTool;
import com.englishtown.pages.common.ForgottenPassPage;
import com.englishtown.pages.common.LoginPage;
import com.englishtown.tests.core.ISharedConfiguration;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class CrmMagicFormExistingUserLoginTest extends BaseCrmMagicForm {
    private static final Logger logger = LoggerFactory.getLogger(CrmMagicFormExistingUserLoginTest.class);


    @BeforeClass
    protected void setupOpenCrmUrl()  {
        testStartUrl = getBASEURL()+crmMagicFormExistingUser;
        setThreadSafeDriver();
        openUrl(getWebDriver(), testStartUrl );
    }

    @Test
    void loginExistingUserCheckSchoolAvatar(){
        loginPage = new LoginPage(getWebDriver());
        loginPage.enterCredentials(USER, PASS);
        //"Submit Login form"
        click(By.cssSelector(crmLoginBtnCss));
        //then: "I am at school and User avatar is shown"
        WaitTool.waitForElementVisibleAndClickable(By.cssSelector(schoolWaitForWeCss), getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
    }

    @AfterClass
    protected void testAfterClass(){
        destroyDriver();
    }

}
