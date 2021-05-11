//package com.englishlive.tests.newsite.mobileandtablet.navigation;
///**
// *
// *currently using specific mobile page..hence commenting this one...
// */
//import com.englishlive.tests.newsite.core.BaseMobileNavigation;
//import com.englishtown.driver.MyBrowserType;
//import org.openqa.selenium.By;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//
//
//public class SAMobileNavigationTest extends BaseMobileNavigation {
//    private static final Logger logger = LoggerFactory.getLogger(SAMobileNavigationTest.class);
//    @Value("#{applicationPropertiesList['home.page.sa']}")
//    protected String testUrl;
//
//
//    @BeforeClass
//    public void setupOpenHomePage(){
//        homePageUrl = removeCtrParamFromHomePageUrl(testUrl);
//        setThreadSafeDriver();//MyBrowserType.CHROME_EMULATOR_GALAXY_S5, 25);
//        //setThreadSafeDriver(MyBrowserType.BROWSERSTACK_IOS_IPHONE7, 25);
//        setNavigationPagesUrls("study-plans-and-prices", "learn-english-online", "login" );
//        openUrl(getWebDriver(), testUrl, -1 ) ;
//        sleep(1000);
//        waitForElementCondition(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".menu a")), getWebDriver(), 30);
//        sleep(1000);
//    }
//
//
//
//    @AfterClass
//    protected void teardownAfterClass(){
//        destroyDriver();
//    }
//
//
//
//
//
//}
//
