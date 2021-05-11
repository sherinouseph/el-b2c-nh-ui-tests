//package com.englishlive.tests.newsite.mobileandtablet.navigation;
///**
// *
// *
// */
//import com.englishlive.tests.newsite.core.BaseMobileNavigation;
//import org.apache.commons.lang.StringUtils;
//import org.openqa.selenium.By;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//
//// Note this redirect to mobile page
//// nov 2017 Now only these 3 guys are still with mobile redirection logic:        /fr-fr/        /zh-tw/        /ja-jp/
//
//public class FRMobileNavigationTest extends BaseMobileNavigation {
//    private static final Logger logger = LoggerFactory.getLogger(FRMobileNavigationTest.class);
//    @Value("#{applicationPropertiesList['home.fr.fr.url']}")
//    protected String testUrl;
//
//
//    @BeforeClass
//    public void setupOpenHomePage(){
//        homePageUrl = removeCtrParamFromHomePageUrl(testUrl);
//        setThreadSafeDriver();//MyBrowserType.CHROME_EMULATOR_GALAXY_S5, 25);
//        setNavigationPagesUrls("formations-et-tarifs", "apprendre-l-anglais-en-ligne", "connexion" );
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
