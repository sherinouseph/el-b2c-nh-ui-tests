package com.englishlive.tests.newhouse.school.prodtests;
/**
 * sherin.ouseph 05/10/2020
 *
 *
 *
 *
 */

import com.englishtown.driver.MyBrowserType;
import com.englishtown.driver.local.WebDriverFactory;
import com.englishtown.newhouse.school.beanandenum.CourseCodeNumber;
import com.englishtown.newhouse.school.beanandenum.SchoolStudentBean;
import com.englishtown.tests.core.school.BaseSchoolSmokeTest;
import org.openqa.selenium.JavascriptExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class SmokeTestProd extends BaseSchoolSmokeTest
{
    private static final Logger logger = LoggerFactory.getLogger(SmokeTestProd.class);

    @Value("#{applicationPropertiesList['user.productionsmoketests']}")
    protected String testUsername;

    @BeforeClass
    public void setup(){
        username=testUsername;
        plLeftMsg = "24 private classes left";
        password="SQo720$81mt!";
        testStartUrl = getBASEURL();
        setThreadSafeDriver();
        openUrl(getWebDriver(), testStartUrl);
        schoolStudentBean = new SchoolStudentBean();
        courseCodeNumber = CourseCodeNumber.GENERAL_ENGLISH;
        schoolStudentBean.setUnitNumber(1);
        schoolStudentBean.setLessonNumber(1);
        schoolStudentBean.setStepNumber(1);
        schoolStudentBean.setNoOfCompletedLessons(0);
        schoolStudentBean.setNoOfCompletedSteps(0);
        schoolStudentBean.setStep1Status("continue");
        schoolStudentBean.setStep2Status("start");
        schoolStudentBean.setStep3Status("start");
        schoolStudentUpdatedBean = new SchoolStudentBean();
        schoolStudentUpdatedBean.setFirstName("Testfirstname");
        schoolStudentUpdatedBean2 = new SchoolStudentBean();
        schoolStudentUpdatedBean2.setFirstName("firstnameupdate");
        if(WebDriverFactory.browserName=="IE") {
            JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
            js.executeScript("document.execCommand(\"ClearAuthenticationCache\");");
        }
    }


    @AfterClass
    protected void testAfterClass(){
        destroyDriver();
    }


}
