//package com.englishlive.tests.landing.es.os;
///**
// *
// */
//import com.englishtown.helpers.UrlMapper;
//import com.englishtown.pages.landing.OSLandingPage;
//import com.englishlive.tests.landing.base.BaseOSPageTest;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//
//
//public class ES1OSPageTest extends BaseOSPageTest {
//    private static final Logger logger = LoggerFactory.getLogger(ES1OSPageTest.class);
//
//    @Value("#{applicationPropertiesList['es1.os.url']}")
//    private String osPageUrl;
//    @Value("#{applicationPropertiesList['test.telephone.uk']}")
//    private String localizedTestPhoneNumber;
//
//
//    @Override
//    protected String getLocalizedTestPhoneNumber(){
//        return this.localizedTestPhoneNumber;
//    }
//
//    @Override
//    protected OSLandingPage createPage() {
//        //osPageUrl = UrlMapper.mapUrlToELive(osPageUrl, getBASEURL());
//        formLeadTypeValue = "os";
//        return new OSLandingPage(this.webDriver, this.osPageUrl);
//    }
//}
//
//
