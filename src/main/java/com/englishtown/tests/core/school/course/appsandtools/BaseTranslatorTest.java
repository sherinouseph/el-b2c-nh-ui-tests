package com.englishtown.tests.core.school.course.appsandtools;
/**
 * Goto translator
 * check source and target language.By default, both should be English
 * enter different texts and check the sections idioms,language hint,derivatives and phrasal verbs
 * Check auto complete is working for noun,verb,idioms
 * check related words section
 * check English - english translations
 * check english- french traslation
 * swap the language and see if it translates from other languages to English
 *
 * Sherin 07/02/18
 *
 *
 */

import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WebDriverWindowHelper;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.newhouse.school.pages.course.appsandtools.TranslatorPage;
import com.englishtown.tests.core.school.BaseSimpleLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public abstract class BaseTranslatorTest extends BaseSimpleLogin {
    private static final Logger logger = LoggerFactory.getLogger(BaseTranslatorTest.class);
    public String translatorPageUrl=getBASEURL() + SCHOOL_BASE_DOMAIN +"/translator/?newcourseware=true";

    protected  String searchTxt="lesson";
    protected  String searchTxt1="happy";
    protected  String sentence="a lot of";
    protected String autocompleteWords[]={"AP","Write-","call","draw"};
    protected  String searchTxtRelatedWords="workshop";
    protected  String senseBlockTxt="a period of time";
    protected  String exampleBlockTxt="She gives piano lessons.";


    @Test(dependsOnMethods = "checkUserIsAtSchoolHomePage")
    protected void clickOnAppsAndToolsMenu() {
        logger.info("clickOnAppsAndToolsMenu and check if main components are displayed");
        initSchoolHeaderAndFooter();
        schoolHeaderAndFooterPage.schoolHeaderPage.goToAppsAndTools();
        //temporary test..going to change once the team finalise
        translatorPage = new TranslatorPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        openUrl(getWebDriver(),getBASEURL() + SCHOOL_BASE_DOMAIN +translatorPage.getPageUrl());
        translatorPage.getPageLoadedCondition();
        translatorPage.simpleTest();
        translatorPage.checkAllPageComponentsDisplayed();
    }

    @Test(dependsOnMethods = "clickOnAppsAndToolsMenu")
    protected void checkSourceAndTargetLanguage() {
        sleep(1000);
        logger.info("checkSourceAndTargetLanguage");
        translatorPage.checkTranslationLang("English");
        translatorPage.checkSourceLang("English");
    }


    @Test(dependsOnMethods = "checkSourceAndTargetLanguage")
    protected void enterTxtAndCheckLanguageHint() {
        logger.info("enterTxtAndCheckLanguageHint");
        translatorPage.enterTextAndClickOnSearchBtn(searchTxt1);
        translatorPage = new TranslatorPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        translatorPage.clickOnLanguageHint();
        translatorPage.checkLanguageHint();

    }

    @Test(dependsOnMethods = "enterTxtAndCheckLanguageHint")
    protected void checkIdiomsAndDerivative() {
        logger.info("checkIdioms");
        translatorPage.clickOnidiom();
        translatorPage.checkIdioms();
        translatorPage.clickOnDerivative();
        translatorPage.checkDerivative();
        logger.info("Successfully checked idioms and derivative");

    }

    @Test(dependsOnMethods = "checkIdiomsAndDerivative")
    protected void checkAutoCompleteOfWords() {
        logger.info("checkAutoComplete");
        checkAutoComplete();
        WebElementHelper.selectOptinUsingDownArrowKey(translatorPage.searchTxtWe,1, Keys.ARROW_DOWN);
        //click(translatorPage.autoCompletList.get(0));
        translatorPage.checkHeadingText("draw");//draw is the last element in the autocomplete array
    }

    @Test(dependsOnMethods = "checkAutoCompleteOfWords")
    protected void checkPhrasalVerb() {
        logger.info("checkPhrasalVerb");
        translatorPage=new TranslatorPage(getWebDriver(),20);
        translatorPage.clickOnPhrasalVerb();
        translatorPage.checkPhrasalVerbs();
    }


    @Test(dependsOnMethods = "checkPhrasalVerb")
    protected void enterTxtAndCheckResults() {
        logger.info("enterTxtAndCheckResults");
        translatorPage.enterTextAndClickOnSearchBtn(searchTxt);
        logger.info("checkResultSection");
        translatorPage = new TranslatorPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        translatorPage.checkSearchResultsComponents();
        translatorPage.checkTextInResults(searchTxt,searchTxt,senseBlockTxt,exampleBlockTxt);
    }


    @Test(dependsOnMethods = "enterTxtAndCheckResults")
    protected void checkRelatedWords() {
        logger.info("checkRelatedWords");
        translatorPage.checkRelatedWords(searchTxtRelatedWords);
    }


    @Test(dependsOnMethods = "checkRelatedWords")
    protected void changeTranslationLangAndcheckResults() {
        logger.info("changeTranslationLangAndcheckResults");
        translatorPage.clickOnTargetLanguage();
        translatorPage.checkNoOfTranslationLanguage();
        clickListWebElement(getWebDriver(),By.cssSelector("#targetLang a"),4);//change teh translation language to french
        translatorPage = new TranslatorPage(getWebDriver(),20);
        translatorPage. checkGuideWordTranslation("Leçon, cours");
    }

    @Test(dependsOnMethods = "changeTranslationLangAndcheckResults")
    protected void swapLanguageAndCheckTheResults() {
        logger.info("swapLanguageAndCheckTheResults");
        translatorPage.clickOnExchangeLanguageBtn();
        translatorPage.enterTextAndClickOnSearchBtn("Leçon");
        translatorPage=new TranslatorPage(getWebDriver(),25);
        sleep(1000);
        translatorPage.checkAcknowledgementTxt("Choose from one of the below possible translations:");
        AssertHelper.assertStringContains(getWebDriver().findElement(By.cssSelector(".othertoenresult a")).getText(),
                searchTxt, " message incorrect");

    }

    protected void checkAutoComplete() {
        for (String s : autocompleteWords) {
            logger.info("checkAutoComplete");
            translatorPage.enterTextAndClickOnSearchBtn(s);
            translatorPage.checkAutoComplete(s);

        }
    }





}











