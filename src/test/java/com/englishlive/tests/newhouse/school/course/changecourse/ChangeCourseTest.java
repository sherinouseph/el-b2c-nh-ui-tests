package com.englishlive.tests.newhouse.school.course.changecourse;
/**
 * Precondition : User mast be on level 6 or above
 * 1) Login and go to change course
 * 2) Change course to Spin(correspondence) OR GE and validate course changed
 * 3) Check progress and test page course changed
 *
 *
 * Sherin
 *
 *  old user 'testchangecourse@qp1.org mid=11408854 sid=1025675
 *
 *  NM : added test description
 */
import com.englishtown.newhouse.school.beanandenum.SchoolStudentBean;
import com.englishtown.tests.core.school.course.changecourse.BaseChangeCourse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class ChangeCourseTest extends BaseChangeCourse {
    private static final Logger logger = LoggerFactory.getLogger(ChangeCourseTest.class);

    @Value("#{applicationPropertiesList['user.change.course']}")    // testuser.changecourse old user
    protected String testUsername;


    @BeforeClass
    protected void setup(){
        setThreadSafeDriver();
        testStartUrl = getBASEURL();
        username = testUsername;
        password = "passpass";
        openUrl(getWebDriver(), testStartUrl);
        refresh(getWebDriver());  // note: login page not shown sometime but shows after refresh
        schoolStudentBean = new SchoolStudentBean();
        schoolStudentBean.setUnitNumber(1);
        schoolStudentBean.setLessonNumber(1);

    }


    @AfterClass
    protected void testAfterClass(){
        destroyDriver();
    }

}
