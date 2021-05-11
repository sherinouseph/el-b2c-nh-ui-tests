package com.englishlive.tests.newhouse.school.course.changecourse;
/**
 * Change the levels within a course GE
 * 1)
 *
 *
 * Sherin
 *
 * mid=11408855 sid=y
 */
import com.englishtown.newhouse.school.beanandenum.CourseCodeNumber;
import com.englishtown.newhouse.school.beanandenum.EnabledCourses;
import com.englishtown.newhouse.school.beanandenum.GeneralEnglishCourseLevels;
import com.englishtown.newhouse.school.beanandenum.SchoolStudentBean;
import com.englishtown.tests.core.school.course.changecourse.BaseChangeLevel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class ChangeLevelGETest extends BaseChangeLevel {
    private static final Logger logger = LoggerFactory.getLogger(ChangeLevelGETest.class);

        @Value("#{applicationPropertiesList['user.change.course.content']}")
        protected String testUsername;


    @BeforeClass
    protected void setup(){
        setThreadSafeDriver();
        testStartUrl = getBASEURL();
        username = testUsername;
        password = "passpass";
        openUrl(getWebDriver(), testStartUrl);
        courseCodeNumber=CourseCodeNumber.GENERAL_ENGLISH;
        generalEnglishCourseLevels= GeneralEnglishCourseLevels.ELEMENTARY_6;
        enabledCourses= EnabledCourses.SPIN_TRUE_TOEFLTOEIC_TRUE;
    }


    @AfterClass
    protected void testAfterClass(){
        destroyDriver();
    }

}
