package com.englishlive.tests.newhouse.school.classroom;
/**
 *
 *
 *  User: sherin ouseph
 * Date: 27/03/2019
 *
 *
 */

import com.englishtown.tests.core.school.classroom.BaseBookPLAndCancelPLTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class BookCancelRefundPLTest extends BaseBookPLAndCancelPLTest {
    private static final Logger logger = LoggerFactory.getLogger(BookCancelRefundPLTest.class);

    @Value("#{applicationPropertiesList['user.bookcancelrefund']}")
    protected String testUsername;


    @BeforeClass
    protected void setup(){
        setThreadSafeDriver();
        testStartUrl = getBASEURL();
        username = testUsername;
        password = "passpass";
        isPLWithin24hrs=false;
        //selectTopicIndex = 0;
//        schoolStudentBean = new SchoolStudentBean(testUsername, "", CourseLevel.BEGINNERS_1.getCourseLevelName(),
//                Integer.parseInt(CourseLevel.BEGINNERS_1.getCourseLevelNumber()),
//                Integer.parseInt(CourseUnit.UNIT_1.getUnitNumber()),      2, 2, "tr", Language.TR,1,1,"Start","Continue","Start","");

        openUrl(getWebDriver(), testStartUrl);
    }


    @AfterClass
    protected void testAfterClass(){
        destroyDriver();
    }

}
