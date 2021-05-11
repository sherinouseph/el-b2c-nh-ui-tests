//package com.englishtown.tests.landing.it.fc;
///**
// * Complete FC steps
// * Enter OE form details
// * check thankyou page
// */
//import com.englishtown.pages.landing.OSLandingPage;
//import com.englishtown.tests.core.EfConstants;
//import com.englishtown.tests.landing.base.BaseFCV1s1ToOsOeAndSubmitOeTest;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
//
//public class ItFCv1s1ToOeThankyouTest extends BaseFCV1s1ToOsOeAndSubmitOeTest {
//    private static final Logger logger = LoggerFactory.getLogger(ItFCv1s1ToOeThankyouTest.class);
//    @Value("#{applicationPropertiesList['it1.fc.url']}")
//    private String fcPageUrl;
//    @Value("#{applicationPropertiesList['test.telephone.it']}")
//    private String localizedTestPhoneNumber;
//
//    @BeforeClass
//    public void setup(){
//        logger.info("setup url: " + fcPageUrl);
//        formDataMap = EfConstants.itFCoeFormMap;
//        thankyou_page_url_contains = "lp/ty/fluency-calculator";
//        optionIndex = 0; // first selection
//        this.getPage().loadPage();
//        try{Thread.sleep(2000);}catch (Exception e) {}
//    }
//
//    @Override
//    protected String getLocalizedTestPhoneNumber(){
//        return localizedTestPhoneNumber;
//    }
//
//    @Override
//    protected OSLandingPage createPage() {
//        return new OSLandingPage(this.webDriver, this.fcPageUrl);
//    }
//
//}
//
