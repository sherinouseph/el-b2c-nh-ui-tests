//package com.englishlive.tests.landing.fi;
//
//import com.englishtown.helpers.UrlMapper;
//import com.englishtown.pages.landing.EELandingPage;
//import com.englishtown.tests.core.EfConstants;
//import com.englishlive.tests.landing.base.BaseEEtoThankyouFormFlowTest;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
//public class FiOSPageTest extends BaseEEtoThankyouFormFlowTest {
//    private static final Logger logger = LoggerFactory.getLogger(FiOSPageTest.class);
//    @Value("#{applicationPropertiesList['fi.os.url']}")
//    private String osPageUrl;
//
//
//    @BeforeClass
//    protected void setup(){
//       // osPageUrl = UrlMapper.mapUrlToELive(osPageUrl, getBASEURL());
//        logger.info("setup ... baseurl :" + getBASEURL() + "  page url is : " + osPageUrl);
//        this.getPage().isUrlValidForThisPage();
//        thankyou_page_url_contains ="lp/ty" ;
//        this.language="en";
//        this.market="fi";
//        formDataMap = EfConstants.deOeFormMap;
//    }
//
//    @Override
//    protected EELandingPage createPage() {
//        return new EELandingPage(this.webDriver, this.osPageUrl);
//    }
//}