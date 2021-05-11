//package com.englishlive.tests.landing.de.ee;
///**
//* EE test
//*/
//
//import com.englishtown.pages.landing.EELandingPage;
//import com.englishtown.tests.core.EfConstants;
//import com.englishlive.tests.landing.base.BaseEEtoThankyouFormFlowTest;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
////TODO udate test case according to below fix
////Note test will fail until https://jira-bos.englishtown.com/browse/SAND-1963 resolved
////                           http://jira-bos.englishtown.com/browse/SAND-1996
//public class De2EEPageTest extends BaseEEtoThankyouFormFlowTest {
//    @Value("#{applicationPropertiesList['de2.ee.url']}")
//    private String eePageUrl;
//
//
//    @BeforeClass
//    protected void setup(){
//        this.getPage().isUrlValidForThisPage();
//        try{Thread.sleep(3000);}catch (Exception e){}
//        noOfWebFormElements = 6;
//        formDataMap = EfConstants.deEEFormMap;
//        thankyou_page_url_contains = "de/lp";
//    }
//
//    @Override
//    protected EELandingPage createPage() {
//        return new EELandingPage(this.webDriver, this.eePageUrl);
//    }
//
//}