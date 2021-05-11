//package com.englishlive.tests.landing.at;
//
//import com.englishtown.pages.landing.EELandingPage;
//import com.englishtown.tests.core.EfConstants;
//import com.englishlive.tests.landing.base.BaseEEtoThankyouFormFlowTest;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
//public class AtLpFcPageTest extends BaseEEtoThankyouFormFlowTest {
//    private static final Logger logger = LoggerFactory.getLogger(AtLpFcPageTest.class);
//    @Value("#{applicationPropertiesList['at.os.url']}")
//    private String osPageUrl;
//
//
//    @BeforeClass
//    protected void setup(){
//       // osPageUrl = UrlMapper.mapUrlToELive(osPageUrl, getBASEURL());
//        formLeadTypeValue = "fc";
//        logger.info("setup ... baseurl :" + getBASEURL() + "  page url is : " + osPageUrl);
//        this.getPage().isUrlValidForThisPage();
//        thankyou_page_url_contains ="lp/ty" ;
//        this.language="de";
//        this.market="at";
//        formDataMap = EfConstants.atOeFormMap;
//    }
//
//    @Override
//    protected EELandingPage createPage() {
//        return new EELandingPage(this.webDriver, this.osPageUrl);
//    }
//}