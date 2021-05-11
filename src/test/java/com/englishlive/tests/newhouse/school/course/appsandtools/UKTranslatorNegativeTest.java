//package com.englishlive.tests.newhouse.school.course.appsandtools;
///**
// *Translator negative scenarios - check different error messages
// * Sherin
// *
// **/oliver thinks translator will chnage in newhouse .so its a waste of time to maintain this test for now
// */
//import com.englishtown.newhouse.school.beanandenum.SchoolStudentBean;
//import com.englishtown.tests.core.school.course.appsandtools.BaseTranslatorNegativeTest;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//
//
//public class UKTranslatorNegativeTest extends BaseTranslatorNegativeTest {
//    private static final Logger logger = LoggerFactory.getLogger(UKTranslatorNegativeTest.class);
//    @Value("#{applicationPropertiesList['uk.uk.login.url']}")
//    protected String testUrl;
//    @Value("#{applicationPropertiesList['testuser.translatorneg']}")
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
//         translatorPage.changeTranslationLangToEnglish();
//         destroyDriver();
//    }
//
//
//
//}
