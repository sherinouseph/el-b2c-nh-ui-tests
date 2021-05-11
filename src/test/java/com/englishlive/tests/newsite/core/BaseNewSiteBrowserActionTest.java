package com.englishlive.tests.newsite.core;
/**
 * Created by nikol.marku on 8/5/2016.
 * New website base test browser action
 * Go to price page
 * refresh
 * go back [home page shown]
 * go forward [price page shown]
 *
 */
import com.englishtown.pages.common.NewHomePage;
import com.englishtown.pages.common.core.PriceAndPackagekPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


//TODO add assert for each test

public abstract class BaseNewSiteBrowserActionTest extends BaseNewSite{
    private static final Logger logger = LoggerFactory.getLogger(BaseNewSiteBrowserActionTest.class);

    @Test
    void gotoPricePage(){
        newHomePage = new NewHomePage(getWebDriver());
        newHomePage.simpleTest();
        click(newHomePage.topMenuList.get(2) );
        sleep(2000);
    }

    @Test (dependsOnMethods = "gotoPricePage")
    void testBrowserRefreshButton(){
        priceAndPackagekPage = new PriceAndPackagekPage(getWebDriver());
        priceAndPackagekPage.simpleTest();
        refresh(getWebDriver());
        sleep(3000);
        priceAndPackagekPage = new PriceAndPackagekPage(getWebDriver());
        priceAndPackagekPage.simpleTest();
    }

    @Test (dependsOnMethods = "testBrowserRefreshButton")
    void testBrowserBackButton(){
        backward(getWebDriver());
        sleep(3000);
        newHomePage = new NewHomePage(getWebDriver());
        newHomePage.simpleTest();
        //newHomePage.assertTryusBtnShownInTheMidleContent();
        newHomePage.assertHowItWorksLinkInTheMiddleContent();//change it to check how it works link in the middle content
    }

    @Test (dependsOnMethods = "testBrowserBackButton")
    void testBrowserForwardButton(){
        forward(getWebDriver());
        sleep(3000);
        newHomePage = new NewHomePage(getWebDriver());
        newHomePage.simpleTest();
    }


}
