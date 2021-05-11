package com.englishlive.tests.newhouse.school.classroom;
/**
 *
 *
 * User: nikol.marku
 * Date: 05/02/18
 *
 *
 */
import com.englishtown.enumpack.CourseLevel;
import com.englishtown.enumpack.CourseUnit;
import com.englishtown.enumpack.Language;
import com.englishtown.newhouse.school.beanandenum.SchoolStudentBean;
import com.englishtown.tests.core.school.classroom.BaseBookPLTest;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class BookPrivateLessonPageTest extends BaseBookPLTest {
    private static final Logger logger = LoggerFactory.getLogger(BookPrivateLessonPageTest.class);

    @Value("#{applicationPropertiesList['user.bookplpage']}")
    protected String testUsername;


    @BeforeClass
    protected void setup(){
        setThreadSafeDriver();
        testStartUrl = getBASEURL();
        username = testUsername;
        password = "passpass";
        teacherNotExistingMsg="Sorry, no teachers match your search";
        //selectTopicIndex = 0;
//        schoolStudentBean = new SchoolStudentBean(testUsername, "", CourseLevel.BEGINNERS_1.getCourseLevelName(),
//                Integer.parseInt(CourseLevel.BEGINNERS_1.getCourseLevelNumber()),
//                Integer.parseInt(CourseUnit.UNIT_1.getUnitNumber()),      2, 2, "tr", Language.TR,1,1,"Start","Continue","Start","");

        openUrl(getWebDriver(), testStartUrl);

        if(StringUtils.equalsIgnoreCase(getENVIRONMENT(),"live"))
            teacherName="Brian K.";//check with Nikol on this
        else
            teacherName="f f.BELive";
    }


    @AfterClass
    protected void testAfterClass(){
        destroyDriver();
    }

}
