//package com.englishtown.tests.landing.fr.os;
///**
// * Hidden field test for : crt, lng,
// * User: nikol.marku
// * Date: 01/09/14 .
// */
//// removed as no bugs found by this test and there is one for IT and DE
//import com.englishtown.pages.landing.OSLandingPage;
//import com.englishtown.tests.landing.base.BaseSendTagOnUrlTest;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//
//public class FrSendTagOnUrlTest extends BaseSendTagOnUrlTest {
//    @Value("#{applicationPropertiesList['fr1.os.url']}")
//    private String osPageUrl;
//    //private String tag ="?etag=" ;
//
//    @BeforeClass
//    void openPage(){
//       openPageSendTagUrl(tag, itagValue, osformsubmitId);
//    }
//
//    @Test
//    void testEtagHiddenFieldTest(){
//        checkOsHiddenFildTest(itagId, itagValue, 5);
//    }
//
//    @Override
//    protected OSLandingPage createPage() {
//        return new OSLandingPage(this.webDriver, this.osPageUrl);
//    }
//
//
//}
