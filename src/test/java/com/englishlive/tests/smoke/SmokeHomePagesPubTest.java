//package com.englishlive.tests.smoke;
//
///**
//* Smoke test for Home pages  :  DE, FR, IT, JA, GB
//* pub1 and pub2
//*/
//
//import com.englishtown.tests.core.SmokeBaseTest;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.Test;
//
//public class SmokeHomePagesPubTest extends SmokeBaseTest {
//
//   private static final Logger logger = LoggerFactory.getLogger(SmokeHomePagesPubTest.class);
//
//   @Value("#{applicationPropertiesList['base.url.site']}")
//   protected String publisher;
//
//   public SmokeHomePagesPubTest(String pageUrl){
//        super(pageUrl);
//   }
//
//   @Test(dataProvider = "testUrlsPub", dataProviderClass = SmokeDataProvider.class )
//   public void openHomePageCheckMainComponentTest(String country, String pageUrl) throws Exception{
//       //to run on cq6 ...  pageUrl = pageUrl.replace("englishlive.ef", ".englishtown");
//       openHomePageCheckMainComponent( country,  pageUrl, firstNameId) ;
//   }
//
//}
//
//
