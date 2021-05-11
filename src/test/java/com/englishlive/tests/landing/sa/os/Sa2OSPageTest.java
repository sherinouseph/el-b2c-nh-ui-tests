//package com.englishlive.tests.landing.sa.os;
//
//import com.englishtown.pages.landing.OSLandingPage;
//import com.englishlive.tests.landing.base.BaseOSPageTest;
//import org.springframework.beans.factory.annotation.Value;
//
//public class Sa2OSPageTest extends BaseOSPageTest {
//    @Value("#{applicationPropertiesList['sa2.os.url']}")
//    private String osPageUrl;
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
