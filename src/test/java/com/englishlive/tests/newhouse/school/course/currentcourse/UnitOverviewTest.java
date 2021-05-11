package com.englishlive.tests.newhouse.school.course.currentcourse;
/**
 *
 * User: nikol.marku
 * Date: 09/09/14
 *
 * old user auto_unitoverview@qp1.org sid/mid  1025977	11409150
 */
import com.englishtown.newhouse.school.beanandenum.CourseCodeNumber;
import com.englishtown.newhouse.school.beanandenum.SchoolStudentBean;
import com.englishtown.tests.core.school.course.currentcourse.BaseUnitOverviewTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class UnitOverviewTest extends BaseUnitOverviewTest {
    private static final Logger logger = LoggerFactory.getLogger(UnitOverviewTest.class);

    @Value("#{applicationPropertiesList['user.unitoverview']}")
    protected String testUsername;


    @BeforeClass
    protected void setup(){
        setThreadSafeDriver();
        testStartUrl = getBASEURL();
        username = testUsername;
        password = "passpass";
        openUrl(getWebDriver(), testStartUrl);
        refresh(getWebDriver());
        schoolStudentBean = new SchoolStudentBean();
        schoolStudentBean.setUnitNumber(1);
        schoolStudentBean.setLevelNumber(1);
        schoolStudentBean.setLessonNumber(1);
        schoolStudentBean.setStepNumber(1);
//        schoolStudentBean.setNoOfCompletedLessons(0);
//        schoolStudentBean.setNoOfCompletedSteps(0);
        courseCodeNumber=CourseCodeNumber.GENERAL_ENGLISH;
//        schoolStudentBean.setStep1Status("start");
//        schoolStudentBean.setStep2Status("start");
//        schoolStudentBean.setStep3Status("start");
    }


    @AfterClass
    protected void testAfterClass(){
        destroyDriver();
    }

}
