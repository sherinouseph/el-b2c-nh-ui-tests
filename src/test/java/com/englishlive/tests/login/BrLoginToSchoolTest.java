//package com.englishlive.tests.login;
///**
// * Login an existing user
// *
// * Niko: BR is running 2 homepages ... so remove test and BR should test this
// */
//
//import com.englishtown.pages.landing.OSLandingPage;
//import com.englishtown.tests.core.login.BaseLoginTest;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//
//
//public class BrLoginToSchoolTest extends BaseLoginTest {
//    private static final Logger logger = LoggerFactory.getLogger(BrLoginToSchoolTest.class);
//    @Value("#{applicationPropertiesList['home.page.br']}")
//    protected String osPageUrl;
//    @Value("#{applicationPropertiesList['user.all']}")
//    protected String testUsername;
//
//    protected String firstNameId ="first_name";
//
//    @BeforeClass
//    protected void setup(){
//        setThreadSafeDriver();
//        this.getPage().isUrlValidForThisPage();
//        username = testUsername;
//        setSubmitBtn("input[type=submit]");
//        popupSelector = ".modal.in";
//        isPopupShown=true;
//    }
//
//
//    @Override
//    protected OSLandingPage createPage() {
//        return new OSLandingPage(getWebDriver(), this.osPageUrl);
//    }
//
//    @AfterClass
//    protected void testAfterClass(){
//        destroyDriver();
//    }
//
//
//
//}
