//package com.englishlive.tests.landing.br.ee;
//
//import com.englishtown.pages.landing.EELandingPage;
//import com.englishtown.tests.core.EfConstants;
//import com.englishlive.tests.landing.base.BaseEEtoThankyouFormFlowTest;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
//public class Br1EEPageTest extends BaseEEtoThankyouFormFlowTest { //BaseOELandingPageTest
//    private static final Logger logger = LoggerFactory.getLogger(Br1EEPageTest.class);
//
//    @Value("#{applicationPropertiesList['br1.ee.url']}")
//    private String eePageUrl;
//    @Value("#{applicationPropertiesList['test.telephone.br']}")
//    private String localizedTestPhoneNumber;
//
//
//
//    @BeforeClass
//    protected void setup(){
//        this.getPage().isUrlValidForThisPage();
//        try{Thread.sleep(3000);}catch (Exception e){}
//        noOfWebFormElements = 7;
//        thankyou_page_url_contains = "thankyou";
//        formDataMap = EfConstants.brEEFormMap;
//        this.setLanguageAndMarket("pt","br");
//    }
//
//
//    protected String getLocalizedTestPhoneNumber(){
//        return localizedTestPhoneNumber;
//    }
//
//    @Override
//    protected EELandingPage createPage() {
//        return new EELandingPage(this.webDriver, this.eePageUrl);
//    }
//
//}
