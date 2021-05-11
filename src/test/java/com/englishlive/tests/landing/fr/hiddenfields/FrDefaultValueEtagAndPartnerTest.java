//package com.englishlive.tests.landing.fr.hiddenfields;
//
//import com.englishtown.pages.landing.OSLandingPage;
//import com.englishlive.tests.landing.base.BaseDefaultValueEtangAndParnerTest;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
///**
// * Test default value for ptn and etag
// * etag=""; partner="None"
// * Date: 04/09/14  *
// */
//public class FrDefaultValueEtagAndPartnerTest extends BaseDefaultValueEtangAndParnerTest {
//    @Value("#{applicationPropertiesList['fr1.os.url']}")
//    private String osPageUrl;
//
//    @BeforeClass
//    void openPage(){
//        openPageAndValidate(osformsubmitId);
//    }
//
//    @Override
//    protected OSLandingPage createPage() {
//        return new OSLandingPage(this.webDriver, this.osPageUrl);
//    }
//
//}
