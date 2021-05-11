package com.englishlive.tests.newhouse.school.upsell.tr;
///**
// * Add products and buy
// *
// * User: nikol.marku
// * Date: 05/02/18
// *
// *auto_upsell@qp1.org
// *
// * TODO: open upsell page from account page
// */
//
//
//import com.englishtown.helpers.WaitTool;
//import com.englishtown.tests.core.school.upsell.BaseSmokeUpsellTest;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//
//import java.util.Locale;
//
//
//public class TRSmokeUpsellTest extends BaseSmokeUpsellTest {
//    private static final Logger logger = LoggerFactory.getLogger(TRSmokeUpsellTest.class);
//    @Value("#{applicationPropertiesList['tr.tr.login.url']}")
//    protected String testUrl;
//    @Value("#{applicationPropertiesList['testuser.tr.smokeupsell3']}")
//    protected String testUsername;
//
//
//    @BeforeClass
//    protected void setup(){
//        setThreadSafeDriver();
//        password = "passpass";
//        setLanguageAndMarket("tr", "tr");
//        Locale locale = new Locale("tr", "tr");
//        testStartUrl = testUrl;
//        username = testUsername;
//        setUserEmail(testUsername);
//
//        upsellUrl ="englishlive.ef.com/"+getLanguage()+"-"+getMarket()+"/buy/upsell/upsell";
//        //initialTotalPrice = 0.00;
//        //currencySymbol = getCurrencySymbol(locale);
//        logger.info("initialTotalPrice ["+initialTotalPrice+"] ; currencySymbol ["+currencySymbol+"] ...!");
//        openUrl(getWebDriver(), testStartUrl);
//    }
//
//    @Override
//    protected void checkUserIsAtSchoolHomePage(){
//        logger.info("Override checkUserIsAtSchoolHomePage  check URL not contains login .... as user might not be in this page ...!");
//        waitForUrlNotContaining(getWebDriver(), "login", WaitTool.MED_WAIT_4_ELEMENT);
//        sleep(1000);
//    }
//
//    @AfterClass
//    protected void testAfterClass(){
//        destroyDriver();
//    }
//
//}
//
///**
// * Add products and buy
// *
// * User: nikol.marku
// * Date: 05/02/18
// *
// *auto_upsell@qp1.org
// *
// * TODO: open upsell page from account page
// */
//
//
//import com.englishtown.helpers.WaitTool;
//import com.englishtown.tests.core.school.upsell.BaseSmokeUpsellTest;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//
//import java.util.Locale;
//
//
//public class TRSmokeUpsellTest extends BaseSmokeUpsellTest {
//    private static final Logger logger = LoggerFactory.getLogger(TRSmokeUpsellTest.class);
//    @Value("#{applicationPropertiesList['tr.tr.login.url']}")
//    protected String testUrl;
//    @Value("#{applicationPropertiesList['testuser.tr.smokeupsell3']}")
//    protected String testUsername;
//
//
//    @BeforeClass
//    protected void setup(){
//        setThreadSafeDriver();
//        password = "passpass";
//        setLanguageAndMarket("tr", "tr");
//        Locale locale = new Locale("tr", "tr");
//        testStartUrl = testUrl;
//        username = testUsername;
//        setUserEmail(testUsername);
//
//        upsellUrl ="englishlive.ef.com/"+getLanguage()+"-"+getMarket()+"/buy/upsell-nh/upsell";
//        //initialTotalPrice = 0.00;
//        //currencySymbol = getCurrencySymbol(locale);
//        logger.info("initialTotalPrice ["+initialTotalPrice+"] ; currencySymbol ["+currencySymbol+"] ...!");
//        openUrl(getWebDriver(), testStartUrl);
//    }
//
//    @Override
//    protected void checkUserIsAtSchoolHomePage(){
//        logger.info("Override checkUserIsAtSchoolHomePage  check URL not contains login .... as user might not be in this page ...!");
//        waitForUrlNotContaining(getWebDriver(), "login", WaitTool.MED_WAIT_4_ELEMENT);
//        sleep(1000);
//    }
//
//    @AfterClass
//    protected void testAfterClass(){
//        destroyDriver();
//    }
//
//}
//
