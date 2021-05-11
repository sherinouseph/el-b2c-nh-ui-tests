package com.englishtown.tests.core.school.survey;
/**
 *  * User: nikol.marku
 *  * Date: 22/11/18
 *
 * Login an existing user, submit survey
 * Logout and Login and check home page
 *
 *
 *  TODO: set up user survey if you can using api call
 *
 *  ref: https://www.fileformat.info/tip/java/date2millis.htm
 *
 */

import com.englishtown.helpers.*;
import com.englishtown.newhouse.apicore.StaticBaseApiSpec;
import com.englishtown.newhouse.school.pages.home.SchoolHeaderAndFooterPage;
import com.englishtown.newhouse.school.pages.home.survey.netpromoterscore.NpsStep1Page;
import com.englishtown.newhouse.school.pages.home.survey.netpromoterscore.NpsStep2Page;
import com.englishtown.newhouse.school.pages.home.survey.netpromoterscore.NpsThankyouPage;
import com.englishtown.pages.common.LoginPage;
import com.englishtown.tests.core.school.BaseSimpleLogin;
import io.restassured.response.Response;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;



public abstract class BaseNpsNewHouseTest extends BaseSimpleLogin {
    private static final Logger logger = LoggerFactory.getLogger(BaseNpsNewHouseTest.class);


    protected NpsStep1Page npsStep1Page;
    protected NpsStep2Page npsStep2Page;
    protected NpsThankyouPage npsThankyouPage;
    protected int stepOneSelectionIndex = 5;

    protected String surveyKey88;
    protected String surveyKey90;
    protected String surveyKey88StartDate;
    protected String surveyKey88EndDate;
    protected String surveyKey90StartDate;
    protected String surveyKey90EndDate;

    public Response studentSurveyResponse;
    public Response updatedStudentSurveyResponse;


    @Test(dependsOnMethods = "checkUserIsAtSchoolHomePage")
    protected void switchToSurveyIFrame() {
        WebDriverWindowHelper.switchToDefaultContent(getWebDriver());
        WebDriverWindowHelper.switchToFrameByFrameId(getWebDriver(), 0, 25);
        sleep(1000);
    }

    @Test(dependsOnMethods = "switchToSurveyIFrame")
    protected void surveyStep_1_HowLikelyToRecommend() {
        npsStep1Page = new NpsStep1Page(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        npsStep1Page = new NpsStep1Page(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        npsStep1Page.getPageLoadedCondition();
        npsStep1Page.simpleTest();
        npsStep1Page.clickOnIndex(stepOneSelectionIndex);
    }

    @Test(dependsOnMethods = "surveyStep_1_HowLikelyToRecommend")
    protected void surveyStep_2_negativeAspect() {
        selectSurveyOptions();
    }

    @Test(dependsOnMethods = "surveyStep_2_negativeAspect")
    protected void surveyStep_3_positiveAspect() {
        selectSurveyOptions();
    }

    @Test(dependsOnMethods = "surveyStep_3_positiveAspect")
    protected void surveyStep_4_thankyou_clickOn_I_understand() {
        npsThankyouPage = new NpsThankyouPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        npsThankyouPage.getPageLoadedCondition();
        npsThankyouPage.simpleTest();
        sleep(1000);
        npsThankyouPage.clickOn_I_understand();
        sleep(3000);
        
        WaitTool.waitForCondition(
                ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(NpsThankyouPage.UNDERSTAND_BTN_CSS)),getWebDriver(), 25);
        // user at shcool
        schoolHeaderAndFooterPage = new SchoolHeaderAndFooterPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        schoolHeaderAndFooterPage.getPageLoadedCondition();
        schoolHeaderAndFooterPage.simpleTest();
    }

    @Test(dependsOnMethods = "surveyStep_4_thankyou_clickOn_I_understand")
    public void deleteTheCookies() {
        CookieHandler.deleteCookies(getWebDriver());
        sleep(1000);        //clickAtWindow(getWebDriver(), 7, 7);//.mypage-icon-arrow-right        /*schoolHeaderAndFooterPage = new SchoolHeaderAndFooterPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);        schoolHeaderAndFooterPage.getPageLoadedCondition();        schoolHeaderAndFooterPage.schoolHeaderPage.goToMyAccountAndLogout();        waitForUrlEndsWithTxt(getWebDriver(), homePageEndsWith, WaitTool.MED_WAIT_4_ELEMENT25);*/
    }

    @Test(dependsOnMethods = "deleteTheCookies")
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
        waitForUrlContains(getWebDriver(), "campus", 35);
        AssertHelper.assertUrlContains(getWebDriver().getCurrentUrl(),"ampus/mypage/home","Not the expected URL ...!");
        clickSavebtnInTimeZonePopUp();
        schoolHeaderAndFooterPage = new SchoolHeaderAndFooterPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        schoolHeaderAndFooterPage.getPageLoadedCondition();
        schoolHeaderAndFooterPage.simpleTest();
    }

    @Test(dependsOnMethods = { "checkUserIsAtSchoolHomepage" })
    void checkSurveyNotShown(){
        logger.info("checkSurveyNotShown  ...!");
        StaticBaseApiSpec.getStudentNotification(getENVIRONMENT(), studentBean, 200);
        WebDriverWindowHelper.switchToDefaultContent(getWebDriver());
            WaitTool.waitForCondition(
                    ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("iframe")),getWebDriver(), 25);
    }

    public void setSurveyKeysAndDate(Response response){
         try {
            surveyKey88 = response.jsonPath().getString("settings.key[0]");
            surveyKey90 = response.jsonPath().getString("settings.key[1]");

            surveyKey88StartDate = response.jsonPath().getString("settings.value.startDate[0]");
            surveyKey88StartDate = response.jsonPath().getString("settings.value.endDate[0]");

             surveyKey90StartDate = response.jsonPath().getString("settings.value.startDate[1]");
             surveyKey90StartDate = response.jsonPath().getString("settings.value.endDate[1]");

            logger.info("surveyKey88 [" + surveyKey88 + "]  key 90 ["+surveyKey90+"]");
            if(StringUtils.isBlank(surveyKey88) || StringUtils.isBlank(surveyKey88) )
                failTest("Cant get survey keys ...!");
        } catch (Exception e) {
            logger.error("Cant get survey keys " + e.getMessage());
            failTest("Cant get survey keys ...!");
        }
    }


    public void selectSurveyOptions(){
        npsStep2Page = new NpsStep2Page(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        npsStep2Page.getPageLoadedCondition();
        npsStep2Page.simpleTest();
        click(getWebElementFromListContains(getWebDriver(), npsStep2Page.checkboxListWe, "Teachers"));
        click(getWebElementFromListContains(getWebDriver(), npsStep2Page.checkboxListWe, "Terms and Conditions"));
        //npsStep2Page.clickOnIndex(1);      npsStep2Page.clickOnIndex(2);
        sleep(500);
        click(((NpsStep2Page) npsStep2Page).nextButtonWe);
    }

}


/***

 2
 /*npsStep2Page = new NpsStep2Page(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
 npsStep2Page.getPageLoadedCondition();
 npsStep2Page.simpleTest();
 click(getWebElementFromListContains(getWebDriver(), npsStep2Page.checkboxListWe, "Teachers"));
 click(getWebElementFromListContains(getWebDriver(), npsStep2Page.checkboxListWe, "Terms and Conditions"));
 //npsStep2Page.clickOnIndex(1);      npsStep2Page.clickOnIndex(2);
 sleep(500);
 click(((NpsStep2Page) npsStep2Page).nextButtonWe);*

3
 /*npsStep2Page = new NpsStep2Page(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
 npsStep2Page.getPageLoadedCondition();
 npsStep2Page.simpleTest();
 //npsStep2Page.clickOnIndex(1);        npsStep2Page.clickOnIndex(3);
 click(getWebElementFromListContains(getWebDriver(), npsStep2Page.checkboxListWe, "Teachers"));
 click(getWebElementFromListContains(getWebDriver(), npsStep2Page.checkboxListWe, "Terms and Conditions"));

 sleep(500);
 click(((NpsStep2Page) npsStep2Page).nextButtonWe);



 ***/