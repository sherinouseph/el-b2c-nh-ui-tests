//package com.englishlive.tests.smoke;
///**
//* Smoke test for Home pages  :  DE, FR, IT, JA, GB , BR Mx
//* pub1 and pub2
//*/
//import com.englishtown.tests.core.SmokeBaseTest;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.Test;
//  new design this test is not needed
//
//public class SmokeHomePagesClickTryMidleTest extends SmokeBaseTest {
//   private static final Logger logger = LoggerFactory.getLogger(SmokeHomePagesClickTryMidleTest.class);
//
//   @Value("#{applicationPropertiesList['base.url.site']}")
//   protected String publisher;
//
//   public SmokeHomePagesClickTryMidleTest(String pageUrl){
//        super(pageUrl); //this.pageUrl=pageUrl;
//   }
//
//    @Test(dataProvider = "smokeTestBeanTryClickMiddle", dataProviderClass = SmokeDataProvider.class )
//    public void openHomePageClickTryMidleCarousel(SmokeTestBean testBean) throws Exception{
//        openHomePageClickBtnCheckUrlChanged(testBean.getCountry(), testBean.getUrl(), testBean.getSelector());
//    }
//
//
//}
//
