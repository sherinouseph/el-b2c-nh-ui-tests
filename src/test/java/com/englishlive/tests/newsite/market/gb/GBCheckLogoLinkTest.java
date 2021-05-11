//package com.englishlive.tests.newsite.market.gb;
///**
// * Created by nikol.marku on 8/5/2016.
// * New website base test
// *
// */
//
//import com.englishlive.tests.newsite.core.BaseCheckLogoLinkTest;
//import com.englishtown.pages.common.NewHomePage;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
//
//public class GBCheckLogoLinkTest extends BaseCheckLogoLinkTest {
//    private static final Logger logger = LoggerFactory.getLogger(GBCheckLogoLinkTest.class);
//
//    @Value("#{applicationPropertiesList['new.home.page.gb']}")
//    protected String testUrl;
//
//
//    @BeforeClass
//    protected void setup(){
//        testStartUrl = testUrl;
//        openUrl(getWebDriver(), testUrl);
//        newHomePage = new NewHomePage(getWebDriver());
//    }
//
//
//}
