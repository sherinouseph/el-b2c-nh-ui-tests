//package com.englishlive.tests.landing.br.oe;
//
//import com.englishlive.tests.landing.base.BaseOEPageTest;
//import com.englishtown.helpers.utils.TestUtil;
//import com.englishtown.pages.landing.OELandingPage;
//import com.englishtown.tests.core.EfConstants;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
//// TODO find solution .. removed as case edge test to fail crash 
//public class BrOE3PageTest extends BaseOEPageTest {
//  private static final Logger logger = LoggerFactory.getLogger(BrOE3PageTest.class);
//
//  @Value("#{applicationPropertiesList['br.oe3.url']}")
//  private String oePageUrl;
//  @Value("#{applicationPropertiesList['test.telephone.br']}")
//  private String localizedTestPhoneNumber;
//
//
//  @BeforeClass
//  protected void setup(){
//      failTestIfIsNotBrowser(CHROME_BROWSER_LIST, "Chrome Only Test ....!");
//      formLeadTypeValue = "oe";
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
