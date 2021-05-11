package com.englishlive.tests.newsite.core;
/**
 * Created by nikol.marku on 8/5/2016.
 * New website navigation for mobile
 * check home page and go to price and  how it works page
 *
 */
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.JavaScriptHelper;
import com.englishtown.helpers.WebElementHelper;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.util.List;


public abstract class BaseNewSiteMobTabNavigation extends BaseNewSiteNavigationTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseNewSiteMobTabNavigation.class);


    @Test(dependsOnMethods = "simpleTestHomePage")        //(priority = 6)
    void checkAllTryUsAreVisibleHomePage(){
        if(newHomePage.tryUsList.isEmpty()) {
            failTest("Can't get web element; is empty ...! ");
        }
        List<WebElement> tryUsWebElements = JavaScriptHelper.jQuery_getVisibleElements(
                WebElementHelper.getElementLocator(newHomePage.tryUsList.get(0)), getWebDriver(), 3, true);
        AssertHelper.assertThat("Mobile page should show 2 visible try us buttons", tryUsWebElements.size() == 2);
    }

    @Test(dependsOnMethods = "checkAllTryUsAreVisibleHomePage")
    void navigateToMobilePagesHomePriceHowitWorks(){
        for(int i=0; i < 3; i++) {
            clickMobilePageMenuItem(i);
            sleep(3000);
        }
    }

}
