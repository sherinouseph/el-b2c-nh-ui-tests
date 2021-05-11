package com.englishtown.tests.core.school.course.appsandtools;
/**
 * Go to translator
 * Enter a sentence and see the results and messages
 * Input invalid words and see validation messages and suggestion words
 * swap languages,input invalid word and check validation message
 * Change translation language in settings to Russian,input invalid word and check validation messages
 * Logout and login again and check teh translation language, it should be russian
 * Check search history
 *
 * Sherin 09/04/2018
 *
 *
 */
//SLEEP COMMAND TO BE REPLACED BY EXPLICIT WAIT

import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.newhouse.school.pages.course.appsandtools.TranslatorPage;
import com.englishtown.pages.common.LoginPage;
import com.englishtown.tests.core.school.BaseSimpleLogin;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public abstract class BaseTranslatorNegativeTest extends BaseSimpleLogin {
    private static final Logger logger = LoggerFactory.getLogger(BaseTranslatorNegativeTest.class);
    public String translatorPageUrl=getBASEURL() + SCHOOL_BASE_DOMAIN +"/translator/?newcourseware=true";

    protected  String searchTxtValidationMsg="mn";
    protected  String searchTxtWordsuggestion="man";
    protected String searchTxtSentence="a lot of";


    @Test(dependsOnMethods = "checkUserIsAtSchoolHomePage")
    protected void clickOnAppsAndToolsMenu() {
        logger.info("clickOnAppsAndToolsMenu and check if main components are displayed");
        translatorPage = new TranslatorPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        openUrl(getWebDriver(),getBASEURL() + SCHOOL_BASE_DOMAIN +translatorPage.getPageUrl());
        translatorPage.getPageLoadedCondition();
        translatorPage.simpleTest();
        translatorPage.checkAllPageComponentsDisplayed();
    }

    @Test(dependsOnMethods = "clickOnAppsAndToolsMenu")
    protected void enterSentenceAndcheckResults() {
        logger.info("enterSentenceAndcheckResults");
        translatorPage.enterTextAndClickOnSearchBtn(searchTxtSentence);
        sleep(1000);
        AssertHelper.assertStringContains(findElements(By.cssSelector(".acknowledgement h2")).get(0).getText(),"No matches are available for","Validation message incorrect");
        AssertHelper.assertStringContains(findElements(By.cssSelector(".acknowledgement h2")).get(1).getText(),"Your search has returned the following results. Try limiting your search to individual words","Validation message incorrect");
        logger.info("Successfully checked idioms and derivative");

    }

    @Test(dependsOnMethods = "enterSentenceAndcheckResults")
    protected void clickOnSettingsAndChangeTranslationLang() {
        logger.info("clickOnSettingsandchangeTranslationLang");
        translatorPage.clickOnSettings();
        translatorPage.checkNoOfTranslationLanguageInSettings();
        translatorPage.checkTranslationLangInSettings("English");
        translatorPage.clickOnTranslationDDM();
        translatorPage.changeTranslationLangInSettings(2);//change to russian
    }


    @Test(dependsOnMethods = "clickOnSettingsAndChangeTranslationLang")
    protected void enterTxtAndCheckValidationMessage() {
        logger.info("enterTxtAndCheckValidationMessage");
        translatorPage.checkTranslationLang("Russian");
        click(translatorPage.searchTxtWe);
        translatorPage.enterTextAndClickOnSearchBtn(searchTxtValidationMsg);
        sleep(1000);
        AssertHelper.assertStringContains(getWebDriver().findElement(By.cssSelector(".acknowledgement h2")).getText(),"No matches are available", "Validation message incorrect");

    }

    @Test(dependsOnMethods = "enterTxtAndCheckValidationMessage")
    protected void checkSuggestionBox() {
        logger.info("checkSuggestionBox");
        translatorPage.checkWordSuggestion(searchTxtWordsuggestion);
        click(translatorPage.wordSuggestionFirstElementWe);
        translatorPage.checkHeadingText(searchTxtWordsuggestion);
    }

    @Test(dependsOnMethods = "checkSuggestionBox")
    protected void swapLanguageAndCheckValidationMessage() {
        logger.info("swapLanguageAndCheckValidationMessage");
        translatorPage.clickOnExchangeLanguageBtn();
        translatorPage.enterTextAndClickOnSearchBtn(searchTxtValidationMsg);
        translatorPage =new TranslatorPage(getWebDriver(),20);
        sleep(1000);
        AssertHelper.assertStringContains(getWebDriver().findElement(By.cssSelector(".acknowledgement h2")).getText(),"Please check your spelling or start a new search", "Validation message incorrect");
    }


    @Test(dependsOnMethods = "swapLanguageAndCheckValidationMessage")
    protected void LogOutAndLoginAgain() {
         openUrl(getWebDriver(),getBASEURL()+SCHOOL_BASE_DOMAIN+"/logout/logout.aspx");
         openUrl(getWebDriver(),testStartUrl);
        loginPage = new LoginPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        loginPage.enterCredentials(username, password);
        loginPage.clickLoginBtn(loginPage.loginBtnLatest);

    }

    @Test(dependsOnMethods = "LogOutAndLoginAgain")
    protected void goToTranslatorPageAndCheckSearchHistory() {
        translatorPage = new TranslatorPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        openUrl(getWebDriver(),getBASEURL() + SCHOOL_BASE_DOMAIN +translatorPage.getPageUrl());
        translatorPage = new TranslatorPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        translatorPage.checkSearchHistory(searchTxtWordsuggestion);

    }

    @Test(dependsOnMethods = "goToTranslatorPageAndCheckSearchHistory")
    protected void checkTranslationLanguage() {
        logger.info("checkTranslationLanguage");
        translatorPage.checkTranslationLang("Russian");

    }

}











