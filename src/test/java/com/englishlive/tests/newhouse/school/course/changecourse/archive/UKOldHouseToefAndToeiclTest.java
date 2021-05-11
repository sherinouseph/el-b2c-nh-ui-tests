//package com.englishlive.tests.newhouse.school.course.changecourse;
///**
// *Check if the courses are active
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
//
//public class UKOldHouseToefAndToeiclTest extends BaseToeflToeic {
//    private static final Logger logger = LoggerFactory.getLogger(UKOldHouseToefAndToeiclTest.class);
//    @Value("#{applicationPropertiesList['uk.uk.login.url']}")
//    protected String testUrl;
//    @Value("#{applicationPropertiesList['testuser.toeltoeic']}")
//    protected String testUsername;
//
//
//    @BeforeClass
//    protected void setupOpenUrl(){
//        setThreadSafeDriver();
//        testStartUrl = testUrl;
//        this.username = testUsername;
//        openUrl(getWebDriver(), testStartUrl);
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
