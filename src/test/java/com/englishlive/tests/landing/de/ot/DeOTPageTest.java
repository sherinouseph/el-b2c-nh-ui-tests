//package com.englishlive.tests.landing.de.ot;
///**
//* EE test
//*/
//
//import com.englishtown.pages.landing.EELandingPage;
//import com.englishtown.tests.core.EfConstants;
//import com.englishlive.tests.landing.base.BaseOTPageTest;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
////url is under TnTarget
//public class DeOTPageTest extends BaseOTPageTest {
//    @Value("#{applicationPropertiesList['de.ot.url']}")
//    private String otPageUrl;
//
//
//    @BeforeClass
//    protected void setup(){
//        this.getPage().isUrlValidForThisPage();
//        try{Thread.sleep(300);}catch (Exception e){}
//        noOfWebFormElements = 8;
//        formDataMap = EfConstants.deOTFormMap;
//        thankyou_page_url_contains = "englisch-test";
//    }
//
//    @Override
//    protected EELandingPage createPage() {
//        return new EELandingPage(this.webDriver, this.otPageUrl);
//    }
//
//}