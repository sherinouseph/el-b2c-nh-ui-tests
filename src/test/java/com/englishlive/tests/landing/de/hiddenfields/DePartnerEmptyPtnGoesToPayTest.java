//package com.englishlive.tests.landing.de.hiddenfields;
///**
//* Hidden field test for : ptn
//*/
//import com.englishtown.helpers.UrlMapper;
//import com.englishtown.pages.landing.OSLandingPage;
//import com.englishlive.tests.landing.base.BasePartnerEmptyPtnGoesToPayTest;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//
//
//public class DePartnerEmptyPtnGoesToPayTest extends BasePartnerEmptyPtnGoesToPayTest {
//    private static final Logger logger = LoggerFactory.getLogger(DePartnerEmptyPtnGoesToPayTest.class);
//    @Value("#{applicationPropertiesList['de1.os.url.ptn.empty']}")
//    private String osPageUrl;
//    @Value("#{applicationPropertiesList['test.telephone.de']}")
//    protected String localizedTestPhoneNumber ;
//
//    @Override
//    protected String getLocalizedTestPhoneNumber(){
//        return localizedTestPhoneNumber;
//    }
//
//    @Override
//    protected OSLandingPage createPage() {
//        //osPageUrl = UrlMapper.mapUrlToELive(osPageUrl, getBASEURL());
//        return new OSLandingPage(this.webDriver, this.osPageUrl);
//    }
//
//
//
//}
