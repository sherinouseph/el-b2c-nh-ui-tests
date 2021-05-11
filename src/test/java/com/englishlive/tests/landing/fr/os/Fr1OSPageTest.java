//package com.englishtown.tests.landing.fr.os;
//
//import com.englishtown.pages.landing.OSLandingPage;
//import com.englishtown.tests.landing.base.BaseOSPageTest;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//// url changed open PP
//public class Fr1OSPageTest extends BaseOSPageTest {
//    private static final Logger logger = LoggerFactory.getLogger(Fr1OSPageTest.class);
//    @Value("#{applicationPropertiesList['fr1.os.url']}")
//    private String osPageUrl;
//    @Value("#{applicationPropertiesList['test.telephone.fr']}")
//    private String localizedTestPhoneNumber;
//
//    @Override
//    protected String getLocalizedTestPhoneNumber(){
//        return localizedTestPhoneNumber;
//    }
//
//    @Override
//    protected OSLandingPage createPage() {
//        return new OSLandingPage(this.webDriver, this.osPageUrl);
//    }
//
//}
//
