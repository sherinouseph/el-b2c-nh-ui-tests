//package com.englishlive.tests.landing.om;
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
//public class OmOSPageTest extends BaseEEtoThankyouFormFlowTest {
//    private static final Logger logger = LoggerFactory.getLogger(OmOSPageTest.class);
//    @Value("#{applicationPropertiesList['om.os.url']}")
//    private String osPageUrl;
//
//
//    @BeforeClass
//    protected void setup(){
//       // osPageUrl = UrlMapper.mapUrlToELive(osPageUrl, getBASEURL());
//        logger.info("setup ... baseurl :" + getBASEURL() + "  page url is : " + osPageUrl);
//        this.getPage().isUrlValidForThisPage();
//        thankyou_page_url_contains ="lp/ty" ;
//        this.language="ar";
//        this.market="om";
//        formDataMap = EfConstants.omOeFormMap;
//    }
//
//    @Override
//    protected EELandingPage createPage() {
//        return new EELandingPage(this.webDriver, this.osPageUrl);
//    }
//}