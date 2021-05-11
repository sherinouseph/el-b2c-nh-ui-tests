//package com.englishlive.tests.login;
//
///**
//* Smoke test for Home pages  :  DE, FR, IT, JA, GB
//Not pub1 and pub2
//*/
//
//import com.englishtown.tests.core.SmokeBaseTest;
//import com.englishlive.tests.smoke.SmokeDataProvider;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.Test;
//
//
//public class LoginPagesTest extends SmokeBaseTest {
//
//   private static final Logger logger = LoggerFactory.getLogger(LoginPagesTest.class);
//
//   @Value("#{applicationPropertiesList['base.url.site']}")
//   protected String publisher;
//
//   public LoginPagesTest(String pageUrl){
//        super(pageUrl);
//   }
//
//   @Test(dataProvider = "createLoginPageUrlsAll", dataProviderClass = SmokeDataProvider.class )
//   public void openLoginPageCheckMainComponentTest(String country, String pageUrl) throws Exception{
//       openLoginPage(country, pageUrl, "email"); ;
//   }
//
//}
//
//
