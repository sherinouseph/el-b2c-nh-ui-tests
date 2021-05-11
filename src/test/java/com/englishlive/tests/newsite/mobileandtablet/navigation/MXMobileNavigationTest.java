package com.englishlive.tests.newsite.mobileandtablet.navigation;
/**
 *
 *
 */
import com.englishlive.tests.newsite.core.BaseMobileNavigation;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class MXMobileNavigationTest extends BaseMobileNavigation {
    private static final Logger logger = LoggerFactory.getLogger(MXMobileNavigationTest.class);
    @Value("#{applicationPropertiesList['home.page.mx']}")
    protected String testUrl;


    @BeforeClass
    public void setupOpenHomePage(){
        homePageUrl = removeCtrParamFromHomePageUrl(testUrl);
        setThreadSafeDriver();//MyBrowserType.CHROME_EMULATOR_GALAXY_S5, 25);
        setNavigationPagesUrls("free-consultation", "como-aprender-ingles", "ingresar-escuela" );
        openUrl(getWebDriver(), testUrl, -1 ) ;
        sleep(1000);
        waitForElementCondition(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".menu a")), getWebDriver(), 30);
        sleep(1000);
    }



    @AfterClass
    protected void teardownAfterClass(){
        destroyDriver();
    }





}

