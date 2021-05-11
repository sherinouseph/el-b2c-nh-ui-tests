package com.englishlive.tests.landing.br.oe;

import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.pages.landing.OELandingPage;
import com.englishtown.tests.core.EfConstants;
import com.englishlive.tests.landing.base.BaseOEPageTest;
import com.englishtown.tests.core.landingpages.BaseLPtoTy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BrOEaug17Test extends BaseLPtoTy{ //BaseOEPageTest {
  private static final Logger logger = LoggerFactory.getLogger(BrOEaug17Test.class);

  @Value("#{applicationPropertiesList['br.oe.aug.url']}")
  private String oePageUrl;
  @Value("#{applicationPropertiesList['test.telephone.br']}")
  private String localizedTestPhoneNumber;


  @BeforeClass
  protected void setup(){
      formLeadTypeValue = "oe";
      TestUtil.printMethodName(logger, 2);
      setThreadSafeDriver();                             // this.getPage().isUrlValidForThisPage();      noOfWebFormElements = 7;
      formDataMap = EfConstants.brOEFormMap;
      FULL_NAME = formDataMap.get("first_name")+ "";
      openUrl(getWebDriver(), oePageUrl);
  }

//  @Override
//  protected OELandingPage createPage() {
//      return new OELandingPage(this.webDriver, this.oePageUrl);
//  }

    @AfterClass
    protected void testAfterClass(){
        destroyDriver();
    }

}
