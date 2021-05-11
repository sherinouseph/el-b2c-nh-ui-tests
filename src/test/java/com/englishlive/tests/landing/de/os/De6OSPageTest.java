//package com.englishlive.tests.landing.de.os;
//
//import com.englishtown.pages.landing.OSLandingPage;
//import com.englishlive.tests.landing.base.BaseOSPageTest;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//// same as De1 test
//public class De6OSPageTest extends BaseOSPageTest {
//    @Value("#{applicationPropertiesList['de6.os.url']}")
//    private String osPageUrl;
//    @Value("#{applicationPropertiesList['test.telephone.de']}")
//    private String localizedTestPhoneNumber;
//
//    private static final Logger logger = LoggerFactory.getLogger(De6OSPageTest.class);
//
//    @Override
//    protected String getLocalizedTestPhoneNumber(){
//        return localizedTestPhoneNumber;
//    }
//    @Override
//    protected OSLandingPage createPage() {
//        return new OSLandingPage(this.webDriver, this.osPageUrl);
//    }
//}
//
//
