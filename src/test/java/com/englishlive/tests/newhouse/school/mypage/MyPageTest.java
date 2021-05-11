package com.englishlive.tests.newhouse.school.mypage;
/**
 * Login an existing user click on all the links/buttons on my page
 * User: nikol.marku
 * Date: 27/03/18
 *
 *
 */
  //

import com.englishtown.enumpack.CourseLevel;
import com.englishtown.enumpack.CourseUnit;
import com.englishtown.tests.core.school.mypage.BaseMyPageNavigationTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class MyPageTest extends BaseMyPageNavigationTest {
    private static final Logger logger = LoggerFactory.getLogger(MyPageTest.class);
    @Value("#{applicationPropertiesList['user.checkmypage.navigation']}")
    protected String testUsername;


    @BeforeClass
    protected void setup(){
        username = testUsername;
        plLeftMsg = "3 private classes left";
        courseLevel = CourseLevel.BEGINNERS_1;
        courseUnit = CourseUnit.UNIT_1;
        courseLevel = CourseLevel.BEGINNERS_1;
        testStartUrl = getBASEURL();
        setThreadSafeDriver();
        openUrl(getWebDriver(), testStartUrl);
    }

    @AfterClass
    protected void testAfterClass(){
        destroyDriver();
    }

}
