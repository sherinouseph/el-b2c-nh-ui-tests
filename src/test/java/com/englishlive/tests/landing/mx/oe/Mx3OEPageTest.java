//package com.englishlive.tests.landing.mx.oe;
//
//import com.englishtown.pages.landing.OELandingPage;
//import com.englishtown.tests.core.EfConstants;
//import com.englishlive.tests.landing.base.BaseOEPageTest;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
//public class Mx3OEPageTest extends BaseOEPageTest {
//    private static final Logger logger = LoggerFactory.getLogger(Mx3OEPageTest.class);
//
//    @Value("#{applicationPropertiesList['mx3.oe.url']}")
//    private String oePageUrl;
//
//    @BeforeClass
//    protected void setup(){
////        oePageUrl = UrlMapper.mapUrlToELive(oePageUrl, getBASEURL());
////        logger.info("setup ... baseurl :" + getBASEURL() + "  page url is : " + oePageUrl);
//        this.getPage().isUrlValidForThisPage();
//        noOfWebFormElements = 10;
//        formDataMap = EfConstants.mxOEFormMapWithPhoneType;
//    }
//    @Override
//    protected OELandingPage createPage() {
//        return new OELandingPage(this.webDriver, this.oePageUrl);
//    }
//
//
//}
