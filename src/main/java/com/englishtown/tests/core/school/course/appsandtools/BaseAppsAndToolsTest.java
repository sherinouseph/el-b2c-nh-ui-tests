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
import com.englishtown.newhouse.school.pages.course.appsandtools.AppsAndToolsPage;
import com.englishtown.newhouse.school.pages.course.appsandtools.TranslatorPage;
import com.englishtown.tests.core.school.BaseSimpleLogin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public abstract class BaseAppsAndToolsTest extends BaseSimpleLogin {
    private static final Logger logger = LoggerFactory.getLogger(BaseAppsAndToolsTest.class);



    @Test(dependsOnMethods = "checkUserIsAtSchoolHomePage")
    protected void clickOnAppsAndToolsMenu() {
        initSchoolHeaderAndFooter();
        schoolHeaderAndFooterPage.schoolHeaderPage.goToAppsAndTools();
        appsAndToolsPage = new AppsAndToolsPage(getWebDriver(),WaitTool.MED_WAIT_4_ELEMENT);
        appsAndToolsPage.simpleTest();
        appsAndToolsPage.checkAllPageComponentsDisplayed();
    }

    @Test(dependsOnMethods = "clickOnAppsAndToolsMenu")
    protected void checkAllAppsAreDisplayed() {
        logger.info("checkAllAppsAreDisplayed");
        appsAndToolsPage.checkAllAppsDisplayed();
    }


    @Test(dependsOnMethods = "checkAllAppsAreDisplayed")
    protected void goToAssessmentTest() {
        logger.info("goToAssessmentTest");
        appsAndToolsPage.goToAssessmentTest();
        sleep(5000);
        AssertHelper.assertUrlContains(getWebDriver().getCurrentUrl(),"test/placementtest/","Url doesn't contain placement");
    }





}











