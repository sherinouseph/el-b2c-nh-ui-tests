//package com.englishlive.tests.landing.br.os;
//
//import com.englishlive.tests.landing.base.BaseOEPageTest;
//import com.englishtown.helpers.UrlMapper;
//import com.englishtown.helpers.utils.TestUtil;
//import com.englishtown.pages.landing.OELandingPage;
//import com.englishtown.tests.core.EfConstants;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
////todo fix after 404 error not shown
// // test shows inline msg now and state object is broken
//public class BrOSformUseOEPageTest extends BaseOEPageTest {
//  private static final Logger logger = LoggerFactory.getLogger(BrOSformUseOEPageTest.class);
//
//  @Value("#{applicationPropertiesList['br.os2.url']}")
//  private String oePageUrl;
//  @Value("#{applicationPropertiesList['test.telephone.br']}")
//  private String localizedTestPhoneNumber;
//
//
//  @BeforeClass
//  protected void setup(){
//      formLeadTypeValue = "oe";
//      thankyou_page_url_contains = "planos-e-precos-dos-cursos-de-ingles";
//      TestUtil.printMethodName(logger, 2);
//      if(getENVIRONMENT().contains("qa")) {
//          oePageUrl = oePageUrl.replace("qa-", "qa"); //http://qa-.englishtown.com.br/lp/oe/jul14_pt_123/
//      }else {
//          oePageUrl = UrlMapper.mapBaseUrlToEtown(oePageUrl, getBASEURL());
//      }
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
