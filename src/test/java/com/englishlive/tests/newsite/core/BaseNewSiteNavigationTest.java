package com.englishlive.tests.newsite.core;
/**
 * Created by nikol.marku on 8/5/2016.
 * New website base navigation test
 *
 *
 *
 */
import com.englishtown.pages.common.NewHomePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public abstract class BaseNewSiteNavigationTest extends BaseNewSite {
    private static final Logger logger = LoggerFactory.getLogger(BaseNewSiteNavigationTest.class);


    @Test
    void simpleTestHomePage(){
        newHomePage = new NewHomePage(getWebDriver());
        newHomePage.simpleTest();
    }


}
