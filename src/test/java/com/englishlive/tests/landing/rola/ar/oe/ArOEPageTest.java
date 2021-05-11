//package com.englishlive.tests.landing.rola.ar.oe;
//
//import com.englishtown.helpers.utils.TestUtil;
//import com.englishtown.helpers.UrlMapper;
//import com.englishtown.pages.landing.OELandingPage;
//import com.englishtown.tests.core.EfConstants;
//import com.englishlive.tests.landing.base.BaseOEPageTest;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
//
//public class ArOEPageTest extends BaseOEPageTest {
//  private static final Logger logger = LoggerFactory.getLogger(ArOEPageTest.class);
//
//  @Value("#{applicationPropertiesList['ar.base.oe.url']}")
//  private String oePageUrl;
//  @Value("#{applicationPropertiesList['test.telephone.br']}")
//  private String localizedTestPhoneNumber;
//
//
//  @BeforeClass
//  protected void setup(){
//      formLeadTypeValue = "oe";
//      TestUtil.printMethodName(logger, 2);
//      isPopupShown=true;
//      //oePageUrl = UrlMapper.mapUrlToELive(oePageUrl, getBASEURL());
//      logger.info("setup ... baseurl :" + getBASEURL() + "  page url is : " + oePageUrl);
//      this.thankyou_page_url_contains = "latam-ty";
//      this.getPage().isUrlValidForThisPage();
//      noOfWebFormElements = 7;
//      formDataMap = EfConstants.arOEFormMap;
//  }
//
//  @Override
//  protected OELandingPage createPage() {
//      return new OELandingPage(this.webDriver, this.oePageUrl);
//  }
//
//}
