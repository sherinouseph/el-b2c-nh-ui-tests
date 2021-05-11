//package com.englishlive.tests.landing.rola.co.oe;
//
//import com.englishtown.pages.landing.OELandingPage;
//import com.englishtown.tests.core.EfConstants;
//import com.englishlive.tests.landing.base.BaseOEPageToSurveyTest;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
////TODO move to new site test
//public class CoHomeOEtoSurveyConpleteTest extends BaseOEPageToSurveyTest {
//    private static final Logger logger = LoggerFactory.getLogger(CoHomeOEtoSurveyConpleteTest.class);
//
//    @Value("#{applicationPropertiesList['co.url']}")
//    private String oePageUrl ;
//
//
//    @BeforeClass
//    protected void setup(){
//        isPopupShown=true;
//        logger.info("setup ... baseurl :" + getBASEURL() + "  page url is : " + oePageUrl);
//        this.getPage().isUrlValidForThisPage();
//        thankyou_page_url_contains ="lp/ty" ;
//        noOfWebFormElements = 9;
//        formDataMap = EfConstants.CoOeFormMap;
//    }
//
//    @Override
//    protected OELandingPage createPage() {
//        return new OELandingPage(this.webDriver, this.oePageUrl);
//    }
//
//
//}
