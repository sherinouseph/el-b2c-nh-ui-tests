//package com.englishtown.tests.landing.it.fc;
///**
// * Complete FC steps
// * Click left side button that takes you to checkout
// * check checkout page
// */
//import com.englishtown.pages.landing.OSLandingPage;
//import com.englishtown.tests.core.EfConstants;
//import com.englishtown.tests.landing.base.BaseFCV1s1ToOsOeAndClickOSlinkToCheckoutPageTest;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//// page changed
//public class ItFCv1s1ToOScheckoutTest extends BaseFCV1s1ToOsOeAndClickOSlinkToCheckoutPageTest { //BaseFCV1s1ToOsOeFormsTest {
//    private static final Logger logger = LoggerFactory.getLogger(ItFCv1s1ToOScheckoutTest.class);
//    @Value("#{applicationPropertiesList['it1.fc.url']}")
//    private String fcPageUrl;
//    @Value("#{applicationPropertiesList['test.telephone.it']}")
//    private String localizedTestPhoneNumber;
//
//    @BeforeClass
//    public void setup(){
//        logger.info("setup url: " + fcPageUrl);
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
