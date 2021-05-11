package com.englishtown.tests.core.school.useraccount.translation;
/**
 * Change Language
 * User: nikol.marku
 * Date: 9/04/18
 *
 * All translation test extends this
 *
 */

import com.englishtown.enumpack.Language;
import com.englishtown.helpers.WaitTool;
import com.englishtown.newhouse.school.beanandenum.bean.TranslatorTestDataFactory;
import com.englishtown.newhouse.school.pages.classroom.BookPrivateLessonPage;
import com.englishtown.newhouse.school.pages.course.appsandtools.TranslatorPage;
import com.englishtown.newhouse.school.pages.course.currentcourse.unit.CurrentCourseUnitPage;
import com.englishtown.newhouse.school.pages.home.SchoolHeaderAndFooterPage;
import com.englishtown.newhouse.school.pages.home.SchoolHomePage;
import com.englishtown.tests.core.school.BaseSchoolHomePageTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public abstract class BaseLanguageTest extends BaseSchoolHomePageTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseLanguageTest.class);

    protected TranslatorTestDataFactory translatorTestDataFactory;
    protected Language currentLang;
    protected int currentLangIndex;  // the selected lang index on change lang popup

    //Note ... sherin advices if you swap lang css changes .... probably reverse ..
    protected static final String TRANSLATOR_FROM_LANG_CSS = "#sourceLang #partnerCultureCode";
    protected static final String TRANSLATOR_TO_LANG_CSS   = "#targetLang #defaultCultureCode";
    protected static final String TRANSLATOR_FROMTO_LIST_CSS = ".Select-value";


    public void getCurrentLanguage(){
        logger.info("getCurrentLanguage ...!");
        schoolHomePage = new SchoolHomePage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        schoolHomePage.getPageLoadedCondition();
        schoolHomePage.simpleTest();
        sleep(2000);
        String selectedLangTemp = schoolHeaderAndFooterPage.schoolFooterPage.getSelectedLanguage();
        logger.info("Current Language is [{}]", selectedLangTemp);
        currentLang = Language.fromNameString(selectedLangTemp);
        schoolStudentBean.setLang(currentLang);
        translatorTestDataFactory = new TranslatorTestDataFactory(currentLang);
        currentLangIndex = getLanguageIndex(currentLang);
    }

    public void changeCurrentLanguage(){
        logger.info("changeCurrentLanguage ...!");
        schoolHeaderAndFooterPage = new SchoolHeaderAndFooterPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        schoolHeaderAndFooterPage.getPageLoadedCondition();
        schoolHeaderAndFooterPage.schoolFooterPage.selectLanguage(getChangeToLangIndex(currentLangIndex));
        sleep(2000);
        schoolHomePage = new SchoolHomePage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        schoolHomePage.getPageLoadedCondition();
        // use switch if more the 2
        if(currentLangIndex == 0)   //so current lang is in need to change it to TR
            translatorTestDataFactory = new TranslatorTestDataFactory(Language.TR);
        if(currentLangIndex == 14)
            translatorTestDataFactory = new TranslatorTestDataFactory(Language.EN);

    }


    public void  checkMyPageHeaderMenuTranslations(){
        logger.info("checkMyPageHeaderMenuTranslations for the current setting ...! Lang :"+schoolStudentBean.getLang());

        for(int i=0; i < translatorTestDataFactory.getFooterMainMenu().size(); i++) {
            assertWebElementText(schoolHeaderAndFooterPage.schoolHeaderPage.getMainMenuWe(i),
                    translatorTestDataFactory.getHeaderMainMenu().get(i));
        }
    }


    public void checkMyPageFooterMenuTranslations(){
        logger.info("checkMyPageFooterMenuTranslations for the current setting ...! Lang :"+schoolStudentBean.getLang());

        if(schoolHeaderAndFooterPage.schoolFooterPage.footerLinksListWe != null &&
                schoolHeaderAndFooterPage.schoolFooterPage.footerLinksListWe.size() > 0){
            for(int i=0; i < translatorTestDataFactory.getFooterMainMenu().size(); i++) {
                    assertWebElementText(schoolHeaderAndFooterPage.schoolFooterPage.footerLinksListWe.get(i),
                            translatorTestDataFactory.getFooterMainMenu().get(i));
            }
        } else
            failTest("schoolHeaderAndFooterPage.schoolFooterPage.footerLinksListWe is NULL or empty  ...! User is not logged in ...!");



    }


    public void checkMyPageContentTranslations(){
        logger.info("checkMyPageContentTranslations For current levels and book pl msg ...!");
        assertWebElementText(schoolHomePage.privateLessonSectionMsgWe, translatorTestDataFactory.getMyPageBookPLmsg());
        assertWebElementText(schoolHomePage.currentLevelNameWe, translatorTestDataFactory.getMyPageCurrentLevel());
    }


    public void goToCurrentCoursePageAndCheckTranslations(){
        logger.info("goToCurrentCoursePageAndCheckTranslations ...! ");
        currentCourseUnitPage = new CurrentCourseUnitPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        openPageUrl(currentCourseUnitPage);
        currentCourseUnitPage = new CurrentCourseUnitPage(getWebDriver());
        currentCourseUnitPage.getPageLoadedCondition();
        currentCourseUnitPage.checkLessonName(translatorTestDataFactory.getCoursePageLessonHeading());
    }


    public void goToBookPlPageCheckTranslations(){
        logger.info("goToBookPlPageCheckTranslations ...! ");
        bookPrivateLessonPage = new BookPrivateLessonPage(getWebDriver());
        openPageUrl(bookPrivateLessonPage);
        bookPrivateLessonPage = new BookPrivateLessonPage(getWebDriver());
        bookPrivateLessonPage.getPageLoadedCondition();
        bookPrivateLessonPage.simpleTest();
        assertWebElementText(bookPrivateLessonPage.plbHeaderWE, translatorTestDataFactory.getBookPlHeading());
    }


    public void goToTranslatorCheckTranslations(){
        logger.info("goToTranslatorCheckTranslations from to language ...!");
        translatorPage = new TranslatorPage(getWebDriver());
        openPageUrl(translatorPage);
        translatorPage = new TranslatorPage(getWebDriver());
        translatorPage.getPageLoadedCondition();

        WebElement fromLangWe = findElements(By.cssSelector(TRANSLATOR_FROMTO_LIST_CSS)).get(0);
        WebElement toLangWe   = findElements(By.cssSelector(TRANSLATOR_FROMTO_LIST_CSS)).get(1);        //WebElement fromLangWe = findElement(By.cssSelector(TRANSLATOR_FROM_LANG_CSS));        WebElement toLangWe = findElement(By.cssSelector(TRANSLATOR_TO_LANG_CSS));
        // todo shows always EN assertWebElementText(fromLangWe, translatorTestDataFactory.getTranslatorPageFromLang());
        // todo this shows as english and should be local i think assertWebElementText(toLangWe, translatorTestDataFactory.getTranslatorPageFromLang());
        // TODO language is missing in new house for TR  translatorTestDataFactory.getTranslatorPageToLang());  https://jira.eflabs.io/browse/SAND-6571
    }


    /**
     * return the index of Language in the change lang selection popup
     * @param lang
     * @return
     */
    protected int getLanguageIndex(Language lang){
        logger.info("get change to this language index .. if EN then index = 0 if PT = 1 ...!");
        int index = 0; // EN

        switch (lang){
            case EN :
                return 0;
            //case PT:
                //return 1;
            case TR:
                return 14;

            default: logger.error("Cant find Language [{}] mach in the enum ....!", lang);
        }
        failTest("Cant find language index ...! "+lang);
        return -1;
    }

    /**
     * Change to the other language      *
     * If current lang index is 0 return 1 and if is 1 return zero
     *
     * @param currentLangIndex
     * @return
     */
    protected int getChangeToLangIndex(int currentLangIndex){
        logger.info("getChangeToLangIndex...![{}]", currentLangIndex);

        switch (currentLangIndex){
            //case 1 :
                //return 0;
            case 14:
                return 0;
            case 0:
                return 14;

            default: logger.error("Cant find currentLangIndex [{}] ....!", currentLangIndex);
        }

        failTest("Cant find currentLangIndex index in the list [{}]...! "+currentLangIndex);
        return -1;
    }


}
