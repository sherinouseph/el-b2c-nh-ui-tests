package com.englishlive.tests.newsite.market.tw;
/**
 * Created by nikol.marku on 8/5/2016.
 * New website base test
 *
 */
import com.englishlive.tests.newsite.core.BaseNewSiteDesktopNavigation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class TWNewSiteTest extends BaseNewSiteDesktopNavigation {
    private static final Logger logger = LoggerFactory.getLogger(TWNewSiteTest.class);

    @Value("#{applicationPropertiesList['home.page.tw']}")
    protected String testUrl;


    @BeforeClass
    protected void setup(){
        setThreadSafeDriver();
        runTestGotoPPpage = false;
        openUrl(getWebDriver(), testUrl);
    }

    @AfterClass
    protected void teardownAfterClass(){
        destroyDriver();
    }

}
