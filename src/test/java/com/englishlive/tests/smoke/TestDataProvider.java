//package com.englishtown.tests.smoke;
//
///**
//* test usage of dataprovider
//* pub1 and pub2
//*/
//
//import com.englishtown.tests.responsivecore.SmokeBaseTest;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.Test;
//
//
//public class TestDataProvider extends SmokeBaseTest {
//   private static final Logger logger = LoggerFactory.getLogger(TestDataProvider.class);
//
//
//    @Value("#{applicationPropertiesList['base.url.site']}")
//    protected String publisher;
//
//    public TestDataProvider(String pageUrl){
//        super(pageUrl);
//    }
//
//   @Test(dataProvider = "smokeTestBeanTryClickMiddle", dataProviderClass = SmokeDataProvider.class )
//   public void testDPtest(SmokeTestBean testBean) throws Exception {
//       logger.info("............. smoke it id : " + testBean.getId());
//       openHomePageCheckMainComponent(testBean.getCountry(), testBean.getUrl(), testBean.getSelector()) ;
//       try{Thread.sleep(1000);}catch (Exception e){}
//
//   }
//
//
//}
//
