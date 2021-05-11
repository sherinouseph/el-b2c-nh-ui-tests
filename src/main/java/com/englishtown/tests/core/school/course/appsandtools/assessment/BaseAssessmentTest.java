package com.englishtown.tests.core.school.course.appsandtools.assessment;
/**
 * Nikol Feb 2019
 *
 * Go to apps and tools and start placement test
 * Click start on test page and check correct url open
 *
 * Note: These pages are not properly build as all css are random chars
 *
 *
 */

import com.englishtown.helpers.WaitTool;
import com.englishtown.newhouse.school.pages.course.appsandtools.AppsAndToolsPage;
import com.englishtown.newhouse.school.pages.appstools.assessmenttest.StartAssessmentTestPage;
import com.englishtown.tests.core.school.BaseSimpleLogin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public abstract class BaseAssessmentTest extends BaseSimpleLogin {
    private static final Logger logger = LoggerFactory.getLogger(BaseAssessmentTest.class);



    @Test(dependsOnMethods = "checkUserIsAtSchoolHomePage")
    protected void clickOnAppsAndToolsMenu() {
        logger.info("clickOnAppsAndToolsMenu ....!");
        initSchoolHeaderAndFooter();
        schoolHeaderAndFooterPage.schoolHeaderPage.goToAppsAndTools();

        appsAndToolsPage = new AppsAndToolsPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        appsAndToolsPage.getPageLoadedCondition();
        appsAndToolsPage.simpleTest();
    }


    @Test(dependsOnMethods = "clickOnAppsAndToolsMenu")
    protected void gotToStartAssesmentTestPage() {
        logger.info("gotToStartTestPage ....!");
        appsAndToolsPage.goToAssessmentTest();
        startPlacementTestPage = new StartAssessmentTestPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        //startPlacementTestPage.getPageLoadedCondition();
        //startPlacementTestPage.simpleTest();
        waitForUrlEndsWithTxt(getWebDriver(), startPlacementTestPage.getPageUrl(), WaitTool.MED_WAIT_4_ELEMENT);
    }


}











