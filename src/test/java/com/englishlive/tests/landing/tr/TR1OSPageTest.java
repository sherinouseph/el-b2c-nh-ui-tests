//package com.englishlive.tests.landing.tr;
///**
// * Turkey
// */
//import com.englishtown.pages.landing.OSLandingPage;
//import com.englishlive.tests.landing.base.BaseOSPageTest;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//
//
//public class TR1OSPageTest extends BaseOSPageTest {
//    private static final Logger logger = LoggerFactory.getLogger(TR1OSPageTest.class);
//
//    @Value("#{applicationPropertiesList['tr1.os.url']}")
//    private String osPageUrl;
//    @Value("#{applicationPropertiesList['test.telephone.uk']}")
//    private String localizedTestPhoneNumber;
//
//    @Override
//    protected String getLocalizedTestPhoneNumber(){
//        return this.localizedTestPhoneNumber;
//    }
//
//    @Override
//    protected OSLandingPage createPage() {
//        return new OSLandingPage(this.webDriver, this.osPageUrl);
//    }
//
//}
//
//
