package com.englishtown.newhouse.school.pages.course.appsandtools;
/**
 * Sherin
 *
 *
 */

import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.newhouse.school.pages.core.BaseSchoolPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class TranslatorPage extends BaseSchoolPage {

    public static final Logger logger = LoggerFactory.getLogger(TranslatorPage.class);
    public static final String pageUrl = "/1/apps-and-tools/translator/"; //"/translator/?newcourseware=true";    // course-> my course





    @FindBy(css = "#header h1")
    public WebElement transltorHeadingWe;

    @FindBy(id = "searchText")
    public WebElement searchTxtWe;

    @FindBy(id = "searchBtn")
    public WebElement searchBtnWe;

    @FindBy(id = "settingsToggle")
    public WebElement settingsWe;

    @FindBy(css = "#targetLang .dropdownToggle")
    public WebElement targetLangWe;

    @FindBy(css = "#exchangeLang")
    public WebElement exchangeLangWe;

    @FindBy(css = "#aside h2")
    public WebElement searchHistorHeadingyWe;


    @FindBy(css = "#history a")
    public List<WebElement> searchHistoryListWe;

    @FindBy(css = "#targetLang a")
    public List<WebElement> targetLangListWe;

    @FindBy(css = ".wordsuggestion_div td")
    public List<WebElement> wordSuggestionWe;

    @FindBy(css = ".wordsuggestion_div  tr:first-child  td:nth-child(1) a")
    public WebElement wordSuggestionFirstElementWe;

    //settings

    @FindBy(id = "selectedLanguage")
    public WebElement translationLangWe;

    @FindBy(css = "#languageOptions a")
    public List <WebElement> settingsTranslationLangListWe;

    //searchresults section

    @FindBy(css = ".bigheadword .root .hw")
    public WebElement resultHeadingWe;

    @FindBy(className = "audio")
    public WebElement resultHeadingAudioWe;

    @FindBy(css = ".guidewordblock .hw")
    public WebElement resultSubHeadingWe;

    @FindBy(className = "guidewordtranslation")
    public WebElement guideTranslatedWordWe;

    @FindBy(className = "pronunciation")
    public List<WebElement> pronounciationWe;

    @FindBy(className = "partofspeech")
    public WebElement nounWe;

    @FindBy(css = ".senseblock .def")
    public List<WebElement> senseBlockWe;

    @FindBy(className = "eg")
    public List<WebElement> exampleBlockWe;

    @FindBy(css = ".senseblock .audioplaceholder")
    public List<WebElement> audioExampleBlockWe;

   //Language Hint
    @FindBy(css = ".title.languagehint a")
    public WebElement languageHintWe;

    @FindBy(className = "notepaneltitle")
    public WebElement languageHintTitleWe;

    public String languageTitleTxt="USAGE";

    //idioms
    @FindBy(css = "#idiomgroup  a")
    public WebElement idiomWe;

    @FindBy(css = ".idiomblock .phrase")
    public List<WebElement> idiomBlockListWe;

    @FindBy(css = ".idiomblock .def")
    public List<WebElement> idiomBlockExampleListWe;


  //Derivative

    @FindBy(css = "#runongroup  a")
    public WebElement derivativeWe;

    @FindBy(css = "#runonblock .w")
    public List<WebElement> derivativeBlockWe;

    @FindBy(css = "#runonblock .w")
    public List<WebElement> derivativeExampleWe;

    //phrasal verb
    //Derivative

    @FindBy(css = "#phrasalverbgroup  a")
    public WebElement phrasalVerbWe;

    @FindBy(css = ".phrasalverbblock .phrase")
    public List<WebElement> phrasalVerbBlockWe;

    @FindBy(css = ".phrasalverbblock .def")
    public List<WebElement> phrasalVerbDefWe;

    @FindBy(css = ".phrasalverbblock .eg")
    public List<WebElement> phrasalVerbExampleWe;

    //autocomplete

    @FindBy(css = "#autocomplete_div li")
    public List<WebElement> autoCompletList;

   //related words


    @FindBy(css = "#related h2")
    public WebElement relatedWordsHeadingWe;

    @FindBy(css = "#related .rightlist li")
    public List<WebElement> relatedWordsListWe;



    public TranslatorPage(WebDriver webDriver){
        super(webDriver);
    }

    public TranslatorPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }
    public TranslatorPage(WebDriver webDriver, int waitSec){
        super(webDriver, waitSec);
    }

    public TranslatorPage() {
        this(null, null);
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Override
    public boolean checkAllPageComponentsDisplayed() {
        checkAllPageComponentsDisplayed(transltorHeadingWe,searchBtnWe,settingsWe,searchHistorHeadingyWe,searchTxtWe);
        return false;
    }

    public boolean checkSearchResultsComponents() {
        logger.info("checkSearchResultsComponents");
        checkAllPageComponentsDisplayed(resultHeadingWe,resultHeadingAudioWe,resultSubHeadingWe,resultHeadingAudioWe,pronounciationWe.get(0),pronounciationWe.get(1),exampleBlockWe.get(0),senseBlockWe.get(0),audioExampleBlockWe.get(0));
        return false;
    }


    public void clickOnSettings(){
        logger.info("clickOnSettings");
        click(settingsWe);
     }

    public void clickOnSearchBtn(){
        logger.info("clickOnSearchBtn");
        click(searchBtnWe);
    }

    public void checkWordSuggestion(String suggestedWord){
        logger.info("checkWordSuggestion");
        AssertHelper.assertElementSizeMoreThanOrEqual(getWebDriver(),wordSuggestionWe,2);
        AssertHelper.assertStringContains(wordSuggestionFirstElementWe.getText(),suggestedWord,"Suggested word incorrect");
    }

    public void clickOnExchangeLanguageBtn(){
        logger.info("clickOnExchangeLanguageBtn");
        click(exchangeLangWe);
    }
    public void changeTranslationLangInSettings(int langIndex){
        logger.info("clickOnSettings");
        click(settingsTranslationLangListWe,langIndex);
    }

    public void clickOnTranslationDDM(){
        logger.info("clickOnTranslationDDM");
        click(translationLangWe);
    }

    public void changeTranslationLangToEnglish() {
        logger.info("changeTranslationLangTOEnglish");
        clickOnSettings();
        clickOnTranslationDDM();changeTranslationLangInSettings(1);//change to English
    }

    public void checkTranslationLangInSettings(String transLang){
        logger.info("checkTranslationLangInSettings");
        AssertHelper.assertStringContains(TestUtil.getWebElementText(translationLangWe),transLang,"Translation Language in settings is not correct");
    }

    public void enterTextAndClickOnSearchBtn(String searchTxt){
        logger.info("Enter text ");
        WebElementHelper.clearAndsendKeys(getWebDriver(),searchTxtWe,searchTxt,false);
        logger.info("clickonSearchBtnWe");
        click(searchBtnWe);
    }

    public void checkAcknowledgementTxt(String searchTxt){
        logger.info("Enter text ");
        AssertHelper.assertStringContains(getWebDriver().findElement(By.cssSelector(".acknowledgement h2")).getText(),
                searchTxt, " message incorrect");
    }
    public void checkTranslationLang(String translationLang){
        logger.info("checkTranslationLang");
        AssertHelper.assertStringContains((getWebDriver().findElement(By.cssSelector("#targetLang strong")).getText()),translationLang,"Translation Language incorrect");

    }

    public void clickOnLanguageHint(){
        logger.info("clickOnLanguageHint");
        click(languageHintWe);
    }

    public void clickOnidiom(){
        logger.info("clickOnidiom");
        click(idiomWe);
    }

    public void clickOnDerivative(){
        logger.info("clickOnDerivative");
        click(derivativeWe);
    }

    public void clickOnPhrasalVerb(){
        logger.info("clickOnPhrasalVerb");
        click(phrasalVerbWe);
    }



    public void checkLanguageHint(){
        logger.info("checkLanguageHint");
        checkAllPageComponentsDisplayed(languageHintTitleWe,languageHintWe);
        AssertHelper.assertStringContains(languageHintTitleWe.getText(),languageTitleTxt,"Language hint title incorrect");
    }


    public void checkIdioms(){
        logger.info("checkIdioms");
        checkAllPageComponentsDisplayed(idiomWe,idiomBlockExampleListWe.get(0),idiomBlockListWe.get(0));
       // AssertHelper.assertStringContains(languageHintTitleWe.getText(),languageTitleTxt,"Language hint title incorrect");
    }


    public void checkDerivative(){
        logger.info("checkDerivative");
        checkAllPageComponentsDisplayed(derivativeWe,derivativeBlockWe.get(0),derivativeExampleWe.get(0));
        // AssertHelper.assertStringContains(languageHintTitleWe.getText(),languageTitleTxt,"Language hint title incorrect");
    }

    public void checkPhrasalVerbs(){
        logger.info("checkPhrasalVerbs");
        checkAllPageComponentsDisplayed(phrasalVerbWe,phrasalVerbBlockWe.get(0),phrasalVerbDefWe.get(0),phrasalVerbExampleWe.get(0));
        //AssertHelper.assertStringContains(languageHintTitleWe.getText(),languageTitleTxt,"Language hint title incorrect");
    }

    public void checkAutoComplete(String txt){
        logger.info("checkAutoComplete");
       AssertHelper.assertElementSizeMoreThanOrEqual(getWebDriver(),autoCompletList,5);
       //AssertHelper.assertStringContains(autoCompletList.get(0).getText(),txt,"autom complete suggestion word incorrect");
    }

    public void checkSourceLang(String sourceLang){
        logger.info("checkTranslationLang");
        AssertHelper.assertStringContains((getWebDriver().findElement(By.cssSelector("#sourceLang strong")).getText()),sourceLang,"SourceLanguage incorrect");
    }

    public void checkNoOfTranslationLanguageInSettings(){
        logger.info("checkNoOfTranslationLanguage ");
        AssertHelper.assertElementSizeMoreThanOrEqual(getWebDriver(),settingsTranslationLangListWe,12);
    }
    public void checkRelatedWords(String searchTxt){
        logger.info("checkRelatedWords of"+searchTxt);
        AssertHelper.assertWebElementDisplayed(relatedWordsHeadingWe);
        AssertHelper.assertElementSizeMoreThanOrEqual(getWebDriver(),relatedWordsListWe,9);
        AssertHelper.assertStringContains(relatedWordsListWe.get(0).getText(),searchTxt,"Related word first data in the list is incorrect");

    }

    public void clickOnTargetLanguage(){
        logger.info("clickOnTranslationLanguage ");
        click(targetLangWe);
    }

    public void checkNoOfTranslationLanguage(){
        logger.info("checkNoOfTranslationLanguage ");
        AssertHelper.assertElementSizeMoreThanOrEqual(getWebDriver(),targetLangListWe,12);
    }

    public void checkHeadingText(String headingTxt){
        logger.info("checkHeadingText ");
        AssertHelper.assertStringContains(resultHeadingWe.getText(),headingTxt,"Heading is incorrect");
    }


    public void checkTextInResults(String heading,String subheading, String senseBlock,String exampleBlock){
         logger.info("checkTextInResults");
         AssertHelper.assertStringContains(resultHeadingWe.getText(),heading,"Heading is incorrect");
         AssertHelper.assertStringContains(resultSubHeadingWe.getText(),subheading,"Sub Heading is incorrect");
         AssertHelper.assertStringContains(senseBlockWe.get(0).getText(),senseBlock,"Sense block - first sentence incorrect");
         AssertHelper.assertStringContains(exampleBlockWe.get(0).getText(),exampleBlock,"first Example word  is incorrect");
    }

    public void checkGuideWordTranslation(String translatedWord){
        logger.info("checkGuideWordTranslation");
        AssertHelper.assertStringContains(guideTranslatedWordWe.getText(),translatedWord,"Translated word incorrect");
    }

    public void checkSearchHistory(String word){
        logger.info("checkSearchHistory");
        AssertHelper.assertStringContains(searchHistoryListWe.get(0).getText(),word,"Word is not present in search history");
    }



//this is in settings
//    public void clickOnTranslationDDM(){
//        logger.info("clickOnTranslationDDM");
//       click(tra)
//    }

    public boolean simpleTest() {
        logger.info("simpleTest Assert Main Navigation and userNotification element displayed ...!");
        AssertHelper.assertWebElementDisplayed(transltorHeadingWe);

        return true;
    }

    public ExpectedCondition getPageLoadedCondition() {
        //return ExpectedConditions.visibilityOf(transltorHeadingWe);
        return ExpectedConditions.visibilityOf(searchTxtWe);
    }

    public String getPageUrl() {
        return pageUrl;
    }




}
