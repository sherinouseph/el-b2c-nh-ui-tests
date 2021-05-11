//package com.englishlive.tests.landing.tw.oe;
//
//import com.englishlive.tests.landing.base.BaseOEPageTest;
//import com.englishtown.pages.landing.OELandingPage;
//import com.englishtown.tests.core.EfConstants;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//  // cant interact with form selenium throws timeout
//public class TW2OEPageTest extends BaseOEPageTest {
//    private static final Logger logger = LoggerFactory.getLogger(TW2OEPageTest.class);
//
//    @Value("#{applicationPropertiesList['tw.oe2.url']}")
//    private String oePageUrl;
//
//
//    @BeforeClass
//    protected void setup(){
//        this.getPage().isUrlValidForThisPage();
//        thankyou_page_url_contains ="lp/ty" ;
//        noOfWebFormElements = 9;
//        formDataMap = EfConstants.twOE1FormMap;
//    }
//
//
//    @Override
//    protected OELandingPage createPage() {
//        return new OELandingPage(this.webDriver, this.oePageUrl);
//    }
//
//
//}
//
