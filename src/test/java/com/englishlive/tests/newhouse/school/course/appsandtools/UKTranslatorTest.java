//package com.englishlive.tests.newhouse.school.course.appsandtools;
///**
// *Translator test
// * Sherin
// *
// *
// *///oliver thinks translator will change in newhouse .so its a waste of time to maintain this test for now
//// NM ... this has changed ... 30 07-18 so need new house user ... and this is turned off
//// -todo migrate
//// qa-11420225 -- FAIL
//// done on live-37618936 translator1@qp1.org
//
//import com.englishtown.newhouse.school.beanandenum.SchoolStudentBean;
//import com.englishtown.tests.core.school.course.appsandtools.BaseTranslatorTest;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//
//
//public class UKTranslatorTest extends BaseTranslatorTest {
//    private static final Logger logger = LoggerFactory.getLogger(UKTranslatorTest.class);
//    @Value("#{applicationPropertiesList['uk.uk.login.url']}")
//    protected String testUrl;
//    @Value("#{applicationPropertiesList['testuser.translator']}")
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
