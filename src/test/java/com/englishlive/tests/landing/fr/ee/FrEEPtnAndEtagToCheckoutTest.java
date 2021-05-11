//package com.englishtown.tests.landing.fr.ee;
///**
// *flow has changed - email sent to Melody
// */
//import com.englishtown.pages.landing.EELandingPage;
//import com.englishtown.tests.core.EfConstants;
//import com.englishtown.tests.landing.base.BasePtnAndEtagEEtoMemberCheckoutTest;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
////TODO    Flow has changed
//public class FrEEPtnAndEtagToCheckoutTest extends BasePtnAndEtagEEtoMemberCheckoutTest {
//    private static final Logger logger = LoggerFactory.getLogger(FrEEPtnAndEtagToCheckoutTest.class);
//
//    @Value("#{applicationPropertiesList['fr.ee.url.ptn.etag']}")
//    private String eePageUrl;
//
//    //assertStateObjectValue("session.partner_code","Goes");
//
//
//    @BeforeClass
//    protected void setup(){
//        this.getPage().isUrlValidForThisPage();
//        try{Thread.sleep(3000);}catch (Exception e){}
//        noOfWebFormElements = 7;
//        thankyou_page_url_contains = "ty";
//        formDataMap = EfConstants.frEEFormMap;
//    }
//
//    @Override
//    protected EELandingPage createPage() {
//        return new EELandingPage(this.webDriver, this.eePageUrl);
//    }
//
//}
