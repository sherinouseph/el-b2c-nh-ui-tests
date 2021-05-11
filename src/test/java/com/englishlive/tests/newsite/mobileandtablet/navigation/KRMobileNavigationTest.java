package com.englishlive.tests.newsite.mobileandtablet.navigation;
/**
 *Created by sherin Ouseph on 22/12/2017
 *
 */
import com.englishlive.tests.newsite.core.BaseMobileNavigation;
import com.englishtown.driver.MyBrowserType;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class KRMobileNavigationTest extends BaseMobileNavigation {
    private static final Logger logger = LoggerFactory.getLogger(KRMobileNavigationTest.class);
    @Value("#{applicationPropertiesList['home.page.kr']}")
    protected String testUrl;


    @BeforeClass
    public void setupOpenHomePage(){
        homePageUrl = removeCtrParamFromHomePageUrl(testUrl);
        setThreadSafeDriver(); //MyBrowserType.BROWSERSTACK_IOS_IPHONE7, 45);
        setNavigationPagesUrls("study-plans-and-prices", "learn-english-online", "login" );
        openUrl(getWebDriver(), testUrl, -1 ) ;
        sleep(1000);
        waitForElementCondition(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".menu a")), getWebDriver(), 40);
        sleep(1000);
    }



    @AfterClass
    protected void teardownAfterClass(){
        destroyDriver();
    }





}

