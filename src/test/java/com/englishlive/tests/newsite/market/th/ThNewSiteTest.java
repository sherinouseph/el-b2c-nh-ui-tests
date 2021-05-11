package com.englishlive.tests.newsite.market.th;
/**
 * Created by sherin ouseph on 21/12/2016
 * New website base test
 *
 */
import com.englishlive.tests.newsite.core.BaseNewSiteDesktopNavigation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class ThNewSiteTest extends BaseNewSiteDesktopNavigation {
    private static final Logger logger = LoggerFactory.getLogger(ThNewSiteTest.class);

    @Value("#{applicationPropertiesList['home.page.th']}")
    protected String testUrl;


    @BeforeClass
    protected void setup(){
        setThreadSafeDriver();
        runTestGotoPPpage = false;
        openUrl(getWebDriver(), testUrl);
        isHomePagePhoneNumberPresent=false;
    }

    @AfterClass
    protected void teardownAfterClass(){
        destroyDriver();
    }

}
