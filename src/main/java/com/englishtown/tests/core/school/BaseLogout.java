package com.englishtown.tests.core.school;
/**
 * Log user out .. once logged in
 * User: nikol.marku
 * Date: 30/01/18
 *
 *
 */


import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.newhouse.school.pages.home.SchoolHeaderPage;
import com.englishtown.pages.common.LoginPage;
import com.englishtown.pages.schoollite.EfIdLoginPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;


public abstract class BaseLogout extends BaseSimpleLogin {
    private static final Logger logger = LoggerFactory.getLogger(BaseLogout.class);

    public String eLiveLogoCss  = "logo";
    public String schoolLogoCss = "ue-logo";


    @Test(dependsOnMethods = "checkUserIsAtSchoolHomePage")
    protected void logoutAndCheckUserOutOfSchoolTest(){
        logger.info("checkUserIsAtSchoolHomePage  ...!"+waitForUrlContains);
        SchoolHeaderPage schoolHeaderPage = new SchoolHeaderPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        schoolHeaderPage.simpleTest();
        schoolHeaderPage.goToMyAccountAndLogout();
        waitForUrlContains(getWebDriver(),"login", WaitTool.MED_WAIT_4_ELEMENT25);
        AssertHelper.assertUrlContains(TestUtil.getCurrentUrl(getWebDriver()),"login","User not in login page");
        // assert logout
//        loginPage =new LoginPage(getWebDriver(), WaitTool.LONG_WAIT_4_ELEMENT);
//        loginPage.checkLoginBtnDisplayed();

//        efIdLoginPage = new EfIdLoginPage(getWebDriver(), WaitTool.LONG_WAIT_4_ELEMENT);
//        efIdLoginPage.getPageLoadedCondition();
       // efIdLoginPage.checkLoginBtnDisplayed();
    }



}
