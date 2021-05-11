//package com.englishlive.tests.landing.de.hiddenfields;
///**
//* Hidden field test for : crt, lng,
//* User: nikol.marku
//* Date: 01/09/14 .
// *
//*/
//import com.englishtown.pages.landing.OSLandingPage;
//import com.englishlive.tests.landing.base.BasePartnerTest;
//import org.springframework.beans.factory.annotation.Value;
//
//
//public class DePartnerTest extends BasePartnerTest {
//    @Value("#{applicationPropertiesList['de1.os.url.ptn']}")
//    private String osPageUrl;
//    @Value("#{applicationPropertiesList['de1.os.url.ptn.empty']}")
//    private String osPageUrlEmptyPtn;
//
//    @Override
//    protected OSLandingPage createPage() {
//        return new OSLandingPage(this.webDriver, this.osPageUrl);
//    }
//
//
//
//}
