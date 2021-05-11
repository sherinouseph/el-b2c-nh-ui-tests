// Content targeting
// package com.englishtown.tests.landing.de.oe;
//
//import com.englishtown.pages.landing.OELandingPage;
//import com.englishtown.tests.responsivecore.EfConstants;
//import com.englishtown.tests.landing.base.BaseOEPageTest;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
//public class DeOEPageTest extends BaseOEPageTest {
//    private static final Logger logger = LoggerFactory.getLogger(DeOEPageTest.class);
//
//    @Value("#{applicationPropertiesList['de.oe.url']}")
//    private String oePageUrl;
//    @Value("#{applicationPropertiesList['test.telephone.de']}")
//    private String localizedTestPhoneNumber;
//
//    @BeforeClass
//    protected void setup(){
//        this.getPage().isUrlValidForThisPage();
//        thankyou_page_url_contains ="thank-you" ;
//        noOfWebFormElements = 8;
//        formDataMap = EfConstants.deOeFormMap;
//    }
//
//    @Override
//    protected String getLocalizedTestPhoneNumber(){
//        return localizedTestPhoneNumber;
//    }
//
//    @Override
//    protected OELandingPage createPage() {
//        return new OELandingPage(this.webDriver, this.oePageUrl);
//    }
//
//}