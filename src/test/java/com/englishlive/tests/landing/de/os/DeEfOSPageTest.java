//package com.englishlive.tests.landing.de.os;
//
//import com.englishlive.tests.landing.base.BaseOSPageTest;
//import com.englishtown.pages.landing.OSLandingPage;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;

//  // note there are 2 experiences here

//public class DeEfOSPageTest extends BaseOSPageTest {
//    private static final Logger logger = LoggerFactory.getLogger(DeEfOSPageTest.class);
//    @Value("#{applicationPropertiesList['de.os.url']}")
//    private String osPageUrl;
//    @Value("#{applicationPropertiesList['test.telephone.de']}")
//    private String localizedTestPhoneNumber;
//
//
//    @BeforeClass
//    protected void setupBeforeClass(){
//        setThreadSafeDriver();
//    }
//
//
//    @Override
//    protected String getLocalizedTestPhoneNumber(){
//        return localizedTestPhoneNumber;
//    }
//
//    @Override
//    protected OSLandingPage createPage() {
//        isEnsureCheckedEmailEnglish = false;
//        submitBtn = ".bs3 .btn-primary-blue";
//        formLeadTypeValue = "os";
//        return new OSLandingPage(getWebDriver(), this.osPageUrl);
//    }
//
//    @AfterClass
//    protected void testAfterClass(){
//        destroyDriver();
//    }
//}
//
//
//
//
