//package com.englishlive.tests.landing.it.os;
//
//import com.englishtown.pages.landing.OSLandingPage;
//import com.englishlive.tests.landing.base.BaseOSPageTest;
//import org.springframework.beans.factory.annotation.Value;
//
//public class It6OSPageTest extends BaseOSPageTest {
//    @Value("#{applicationPropertiesList['it6.os.url']}")
//    private String osPageUrl;
//    @Value("#{applicationPropertiesList['test.telephone.it']}")
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
//}
