//package com.englishlive.tests.landing.it.ot;
///**
//* EE test
//*/
//
//import com.englishlive.tests.landing.base.BaseOTPageTest;
//import com.englishtown.helpers.UrlMapper;
//import com.englishtown.pages.landing.EELandingPage;
//import com.englishtown.tests.core.EfConstants;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
//public class IT1OTPageTest extends BaseOTPageTest {
//    @Value("#{applicationPropertiesList['it1.ot.url']}")
//    private String otPageUrl;
//
//
//    @BeforeClass
//    protected void setup(){
//        otPageUrl = UrlMapper.mapUrlToELive(otPageUrl, getBASEURL());
//        this.getPage().isUrlValidForThisPage();
//        try{Thread.sleep(300);}catch (Exception e){}
//        noOfWebFormElements = 8;
//        formDataMap = EfConstants.itOTFormMap;
//        thankyou_page_url_contains = "lp/ty";
//    }
//
//    @Override
//    protected EELandingPage createPage() {
//        return new EELandingPage(this.webDriver, this.otPageUrl);
//    }
//
//}