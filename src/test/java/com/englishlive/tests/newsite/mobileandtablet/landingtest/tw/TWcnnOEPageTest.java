//package com.englishlive.tests.newsite.mobileandtablet.landingtest.tw;
//
//import com.englishlive.tests.landing.tw.oe.BaseTWOEPageTest;
//import com.englishtown.driver.BaseRemoteWebDriver;
//import com.englishtown.pages.landing.OELandingPage;
//import com.englishtown.tests.core.EfConstants;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//
//public class TWcnnOEPageTest extends BaseTWOEPageTest {
//    private static final Logger logger = LoggerFactory.getLogger(TWcnnOEPageTest.class);
//
//    @Value("#{applicationPropertiesList['tw.oe.cnn.url']}")
//    private String oePageUrl;
//   /// Decided not to use this as might change
//    // note form data
//  //#mobile [name="first_name"]
//  //.tw_zh_lp_oe_cnn-2016-07-01_jcr-content_footerPar_spacer_spacercontent_columnscontrol_column0_spacer_spacercontent_spacer-0 [name="first_name"]'
//
//    @BeforeClass
//    protected void setup(){
//        setThreadSafeDriver();
//        isUseCssEnterFormData = true;
//        this.getPage().isUrlValidForThisPage();
//        formLeadTypeValue = "oe";
//        thankyou_page_url_contains ="lp/ty" ;
//        noOfWebFormElements = 9;
//        if(BaseRemoteWebDriver.isMobileDevice) {
//            formDataMap = EfConstants.twOE1FormMapMobileCss;
//        } else
//            formDataMap = EfConstants.twOE1FormMapDesktopCss;
//    }
//
//    @Override
//    protected OELandingPage createPage() {
//        return new OELandingPage(getWebDriver(), this.oePageUrl);
//    }
//
//
//    @AfterClass
//    protected void teardownAfterClass(){
//        destroyDriver();
//    }
//
//}
//
