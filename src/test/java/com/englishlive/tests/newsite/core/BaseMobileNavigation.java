package com.englishlive.tests.newsite.core;
/**
 * 1. Open home page and navigate using mobile menu and check the pages
 * 2. go to How it works page
 * 3. go to price page
 * 4. go to login page [use icon profile click]
 */
import com.englishtown.tests.core.mobile.core.BaseMobileTest;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public abstract class BaseMobileNavigation extends BaseMobileTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseMobileNavigation.class);


    @Test
    public void checkMobileHomePageTest(){
        checkMobileHomePage();
    }

    @Test(dependsOnMethods = "checkMobileHomePageTest")
    public void goToHowItWorksAndCheckPageTest(){
        goToHowItWorksAndCheckPage();
    }

    @Test(dependsOnMethods = "goToHowItWorksAndCheckPageTest")
    public void goToOfferPriceAndCheckPageTest(){
        goToOfferPriceAndCheckPage();
    }

    @Test(dependsOnMethods = "goToOfferPriceAndCheckPageTest")
    public void goToHomePageTest(){
        goToHomePage();
    }

    @Test(dependsOnMethods = "goToHomePageTest")
    public void goToLoginPageTest(){
        goToLoginPage();
    }


}

