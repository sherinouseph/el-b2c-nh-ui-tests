package com.englishtown.tests.core.school.useraccount.translation;
/**
 * Change Language
 * User: nikol.marku
 * Date: 9/04/18
 *
 * 1. login
 * 2. get current language
 * 2.a change Language (if current language is PT change it to EN of if EN change it to PT
 * 3. Check translation for:
 *                          1. [myPage{Menus-header/footer, content}]
 *                          2. Current Course Page check
 *                          3. Book PL page
 *                          4. Translator page
 *
 *
 *
 * //
 *
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public abstract class BaseChangeLangAndCheckLangTest extends BaseLanguageTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseChangeLangAndCheckLangTest.class);


    @Test (dependsOnMethods = "checkMyPage")
    public void getCurrentLanguageTest(){
        getCurrentLanguage();
    }

    @Test (dependsOnMethods = "getCurrentLanguageTest")
    public void changeLanguageTest(){
        changeCurrentLanguage();
    }

    @Test (dependsOnMethods = "changeLanguageTest")
    public void  checkMyPageHeaderMenuTranslationsTest(){
        checkMyPageHeaderMenuTranslations();
    }

    @Test(dependsOnMethods = "changeLanguageTest")
    public void checkMyPageFooterMenuTranslationsTest(){
        checkMyPageFooterMenuTranslations();
    }

    @Test(dependsOnMethods = "checkMyPageFooterMenuTranslationsTest")
    public void checkMyPageContentTranslationsTest(){
        checkMyPageContentTranslations();
    }

    @Test(dependsOnMethods = "checkMyPageContentTranslationsTest")
    public void goToCurrentCoursePageAndCheckTranslationsTest(){
        goToCurrentCoursePageAndCheckTranslations();
    }

    @Test(dependsOnMethods = "goToCurrentCoursePageAndCheckTranslationsTest")
    public void goToBookPlPageCheckTranslationsTest(){
        goToBookPlPageCheckTranslations();
    }

    @Test(dependsOnMethods = "goToCurrentCoursePageAndCheckTranslationsTest")
    public void goToTranslatorCheckTranslationsTest(){
        goToTranslatorCheckTranslations();
    }



}
