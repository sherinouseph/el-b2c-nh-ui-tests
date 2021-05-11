//package com.englishlive.tests.newhouse.school.course.changecourse;
///**
// *
// * Sherin
// *
// *  auto_toefltoeic@qp1.org sid/mid 1025686	11408865
// */
//import com.englishtown.newhouse.school.beanandenum.SchoolStudentBean;
//import com.englishtown.tests.core.school.course.changecourse.BaseToeflToeic;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//
//// TODO - check this once school lite fixed as now shows 404 for toefl
//
//public class ToefAndToeiclTest extends BaseToeflToeic {
//    private static final Logger logger = LoggerFactory.getLogger(ToefAndToeiclTest.class);
//
//    @Value("#{applicationPropertiesList['user.toeltoeic']}")
//    protected String testUsername;
//
//
//    @BeforeClass
//    protected void setupOpenUrl(){
//        setThreadSafeDriver();
//        testStartUrl = getBASEURL();
//        password = "passpass";
//        this.username = testUsername;
//        openUrl(getWebDriver(), testStartUrl);
//        refresh(getWebDriver());
//        schoolStudentBean = new SchoolStudentBean();
//    }
//
//
//    @AfterClass
//    protected void testAfterClass(){
//        destroyDriver();
//    }
//
//}
