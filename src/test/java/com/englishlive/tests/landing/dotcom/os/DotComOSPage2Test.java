//package com.englishtown.tests.landing.dotcom.os;
//
//import com.englishtown.pages.landing.OSLandingPage;
//import com.englishtown.tests.landing.base.BaseOSPageTest;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
//// US  - NOT trafic - Removed
//public class DotComOSPage2Test extends BaseOSPageTest {
//    private static final Logger logger = LoggerFactory.getLogger(DotComOSPage2Test.class);
//   @Value("#{applicationPropertiesList['eu.en.os.url2']}")
//   private String osPageUrl;
//   @Value("#{applicationPropertiesList['test.telephone.com']}")
//   private String localizedTestPhoneNumber;
//
//    @Override
//    protected String getLocalizedTestPhoneNumber(){
//        return localizedTestPhoneNumber;
//    }
//
//   @Override
//   public void verifyLanguage() {}
//
//   @Override
//   public void verifyMarket() {}
//
//   @Override
//   protected OSLandingPage createPage() {
//       this.verifyLanguage();
//       return new OSLandingPage(this.webDriver, this.osPageUrl);
//   }
//
//}
//
