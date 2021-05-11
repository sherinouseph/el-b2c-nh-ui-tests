//package com.englishlive.tests.landing.rola.co.oe;
//
//import com.englishtown.helpers.UrlMapper;
//import com.englishtown.pages.landing.OELandingPage;
//import com.englishtown.tests.core.EfConstants;
//import com.englishlive.tests.landing.base.BaseOEPageToSurveyTest;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
//public class Co1OEtoSurveyConpleteTest extends BaseOEPageToSurveyTest {
//    private static final Logger logger = LoggerFactory.getLogger(Co1OEtoSurveyConpleteTest.class);
//
//    @Value("#{applicationPropertiesList['co.oe.sur.url']}")
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
