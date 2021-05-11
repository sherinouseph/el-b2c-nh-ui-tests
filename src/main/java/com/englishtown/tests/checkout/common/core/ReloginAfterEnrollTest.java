package com.englishtown.tests.checkout.common.core;
/**
 *
 * Nikol Jul 2018
 *
 * 1. After user enrolled ... Logout and login
 * 2. check user at home page ... to make sure enrollment has saved
 *
 * https://jira.eflabs.io/browse/SAND-5748
 *
 */

import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.CookieHandler;
import com.englishtown.helpers.JavaScriptHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.newhouse.school.pages.home.SchoolHeaderAndFooterPage;
import com.englishtown.newhouse.school.pages.home.SchoolHomePage;
import com.englishtown.pages.common.LoginPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public abstract class ReloginAfterEnrollTest extends CheckEnrolmentTest{
    private static final Logger logger = LoggerFactory.getLogger(ReloginAfterEnrollTest.class);

    protected String homePageEndsWith = "";  // after logout ... e.g .com/en-gb/

    @Test(dependsOnMethods = { "enrolStudentToSchool" })
    public void deleteTheCookies() {
        CookieHandler.deleteCookies(getWebDriver());
        sleep(1000);        //clickAtWindow(getWebDriver(), 7, 7);//.mypage-icon-arrow-right        /*schoolHeaderAndFooterPage = new SchoolHeaderAndFooterPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);        schoolHeaderAndFooterPage.getPageLoadedCondition();        schoolHeaderAndFooterPage.schoolHeaderPage.goToMyAccountAndLogout();        waitForUrlEndsWithTxt(getWebDriver(), homePageEndsWith, WaitTool.MED_WAIT_4_ELEMENT25);*/
    }

    @Test(dependsOnMethods = { "deleteTheCookies" })
    public void openLoginUrlAndLogin() {
        logger.info("openLoginUrlAndLogin  ...!");
        String loginUrl = getBASEURL() + "englishlive.ef.com/" + getLanguage()+"-"+getMarket()+"/login" ;
        openUrl(getWebDriver(), loginUrl);
        JavaScriptHelper.waitForPageLoaded(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        logger.info("enterUserCredentialsAndLogin  ...!");
        loginPage = new LoginPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        loginPage.getPageLoadedCondition();
        loginPage.simpleTest();
        loginPage.enterCredentials(getUserEmail(), password);
        loginPage.clickLoginBtn(loginPage.loginBtnLatest);
    }

    @Test(dependsOnMethods = { "openLoginUrlAndLogin" })
    void checkUserIsAtSchoolHomepage(){
        logger.info("checkUserIsAtSchoolHomePage  ...!");
        waitForUrlContains(getWebDriver(), "campus", 55);
        AssertHelper.assertUrlContains(getWebDriver().getCurrentUrl(),"ampus/mypage/home","Not the expected URL ...!");
        clickSavebtnInTimeZonePopUp();
        schoolHeaderAndFooterPage = new SchoolHeaderAndFooterPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        schoolHeaderAndFooterPage.getPageLoadedCondition();
        schoolHeaderAndFooterPage.simpleTest();
        schoolHomePage = new SchoolHomePage(getWebDriver());
    }



}