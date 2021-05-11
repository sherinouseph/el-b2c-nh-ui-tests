//package com.englishlive.tests.landing.rola.co.oe;
//
//import com.englishlive.tests.landing.base.BaseOEPageToSurveyTest;
//import com.englishtown.helpers.UrlMapper;
//import com.englishtown.pages.landing.OELandingPage;
//import com.englishtown.tests.core.EfConstants;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
//public class Co2LPOEtoSurveyConpleteTest extends BaseOEPageToSurveyTest {
//    private static final Logger logger = LoggerFactory.getLogger(Co2LPOEtoSurveyConpleteTest.class);
//
//    @Value("#{applicationPropertiesList['co.lp.url']}")
//    private String oePageUrl ;
//
//
//    @BeforeClass
//    protected void setup(){
//        oePageUrl = UrlMapper.mapUrlToELive(oePageUrl, getBASEURL());
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
