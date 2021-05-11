//package com.englishlive.tests.landing.rola.cl.os;
//
//import com.englishtown.pages.landing.OELandingPage;
//import com.englishtown.tests.core.EfConstants;
//import com.englishlive.tests.landing.base.BaseOEPageToSurveyTest;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
////TODO move this to newsite tests  // tracking . events not working new site
//public class CLOEtoSurveyConpleteTest extends BaseOEPageToSurveyTest {
//    private static final Logger logger = LoggerFactory.getLogger(CLOEtoSurveyConpleteTest.class);
//
//    @Value("#{applicationPropertiesList['cl.os.sur.url']}")
//    private String osPageUrl ;
//
//
//    @BeforeClass
//    protected void setup(){
//       // osPageUrl = UrlMapper.mapUrlToELive(osPageUrl, getBASEURL());
//        isPopupShown=true;
//        logger.info("setup ... baseurl :" + getBASEURL() + "  page url is : " + osPageUrl);
//        this.getPage().isUrlValidForThisPage();
//        thankyou_page_url_contains ="lp/ty" ;
//        formDataMap = EfConstants.clOEFormMap;
//    }
//
//    @Override
//    protected OELandingPage createPage() {
//        return new OELandingPage(this.webDriver, this.osPageUrl);
//    }
//
//
//}
