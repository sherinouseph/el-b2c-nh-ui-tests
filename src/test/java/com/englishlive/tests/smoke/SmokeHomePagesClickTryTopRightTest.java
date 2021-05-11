//package com.englishlive.tests.smoke;
//
///**
//* Smoke test for Home pages  :  DE, FR, IT, JA, GB , BR Mx
//* pub1 and pub2
//*/
//// test not need as auther can do any thing
//import com.englishtown.tests.core.SmokeBaseTest;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.Test;
//
//public class SmokeHomePagesClickTryTopRightTest extends SmokeBaseTest {
//
//   private static final Logger logger = LoggerFactory.getLogger(SmokeHomePagesClickTryTopRightTest.class);
//
//   @Value("#{applicationPropertiesList['base.url.site']}")
//   protected String publisher;
//
//
//   public SmokeHomePagesClickTryTopRightTest(String pageUrl){
//       super(pageUrl); //this.pageUrl=pageUrl;
//   }
//
//   @Test(dataProvider = "testUrls", dataProviderClass = SmokeDataProvider.class )
//   public void openHomePage_ClickTryTopRight_WaitForUrlChange(String country, String pageUrl) throws Exception{
//        openHomePageClickBtnCheckUrlChanged(country, pageUrl, this.tryUsBtn);
//
//   }
//
//}