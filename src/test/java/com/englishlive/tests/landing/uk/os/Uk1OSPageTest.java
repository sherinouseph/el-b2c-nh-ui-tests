//package com.englishlive.tests.landing.uk.os;
///**
// *
// */
//import com.englishtown.pages.landing.OSLandingPage;
//import com.englishlive.tests.landing.base.BaseOSPageTest;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.Test;
//
//
//public class Uk1OSPageTest extends BaseOSPageTest {
//    private static final Logger logger = LoggerFactory.getLogger(Uk1OSPageTest.class);
//
//    @Value("#{applicationPropertiesList['uk1.os.url']}")
//    private String osPageUrl;
//    //@Value("#{applicationPropertiesList['test.telephone.uk']}")
//    private String localizedTestPhoneNumber = null;
//
//    @Test(priority = 5)
//    void validate_is_FirstLastNamePersisted(){
//        isFirstLastNamePersisted( getWebDriver(), scriptGetCCName, FULL_NAME);
//    }
//
//    @Override
//    protected String getLocalizedTestPhoneNumber(){
//        return this.localizedTestPhoneNumber;
//    }
//
//    @Override
//    protected OSLandingPage createPage() {
//        formLeadTypeValue = "os";
//        return new OSLandingPage(this.webDriver, this.osPageUrl);
//    }
//}
//
//
