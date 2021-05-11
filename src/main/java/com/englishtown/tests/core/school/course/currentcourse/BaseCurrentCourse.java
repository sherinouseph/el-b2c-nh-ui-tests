package com.englishtown.tests.core.school.course.currentcourse;
/**
 * Nikol 21/03/18
 * go to current course page
 *
 *
 */


import com.englishtown.helpers.WaitTool;
import com.englishtown.newhouse.school.pages.course.currentcourse.unit.CurrentCourseUnitPage;
import com.englishtown.tests.core.school.BaseSimpleLogin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public abstract class BaseCurrentCourse extends BaseSimpleLogin {
    private static final Logger logger = LoggerFactory.getLogger(BaseCurrentCourse.class);

    @Test(dependsOnMethods = "checkUserIsAtSchoolHomePage")
    protected void goToCurrentCoursePage() {
        logger.info("goToCurrentCoursePage ");
        schoolHeaderAndFooterPage.schoolHeaderPage.goToCurrentCourse();
        sleep(5000);
        currentCourseUnitPage = new CurrentCourseUnitPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        currentCourseUnitPage.getPageLoadedCondition();

    }


}