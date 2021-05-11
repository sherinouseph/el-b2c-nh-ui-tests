//package com.englishlive.tests.landing.br.oe;
//
//import com.englishtown.helpers.utils.TestUtil;
//import com.englishtown.pages.landing.OELandingPage;
//import com.englishtown.tests.core.EfConstants;
//import com.englishlive.tests.landing.base.BaseOEToUpsellThenThankyouPageTest;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
////todo fix after 404 error not shown
//public class BrOE2PageTest extends BaseOEToUpsellThenThankyouPageTest {
//  private static final Logger logger = LoggerFactory.getLogger(BrOE2PageTest.class);
//
//  @Value("#{applicationPropertiesList['br.oe2.url']}")
//  private String oePageUrl;
//  @Value("#{applicationPropertiesList['test.telephone.br']}")
//  private String localizedTestPhoneNumber;
//
//
//  @BeforeClass
//  protected void setup(){
//      TestUtil.printMethodName(logger, 2);
//      this.getPage().isUrlValidForThisPage();
//      noOfWebFormElements = 7;
//      formDataMap = EfConstants.brOEFormMap;
//  }
//
//  @Override
//  protected OELandingPage createPage() {
//      return new OELandingPage(this.webDriver, this.oePageUrl);
//  }
//
//}
