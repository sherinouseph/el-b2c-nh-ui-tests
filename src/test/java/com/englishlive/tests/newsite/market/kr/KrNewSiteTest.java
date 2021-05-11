package com.englishlive.tests.newsite.market.kr;
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


public class KrNewSiteTest extends BaseNewSiteDesktopNavigation {
    private static final Logger logger = LoggerFactory.getLogger(KrNewSiteTest.class);

    @Value("#{applicationPropertiesList['home.page.kr']}")
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
