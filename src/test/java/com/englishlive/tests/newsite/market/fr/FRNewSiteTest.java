package com.englishlive.tests.newsite.market.fr;
/**
 * Created by Sherin Ouseph on 19/09/2017
 * New website base test
 *
 */
import com.englishlive.tests.newsite.core.BaseNewSiteDesktopNavigation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class FRNewSiteTest extends BaseNewSiteDesktopNavigation {
    private static final Logger logger = LoggerFactory.getLogger(FRNewSiteTest.class);

    @Value("#{applicationPropertiesList['home.page.fr']}")
    protected String testUrl;


    @BeforeClass
    protected void setup(){
        setThreadSafeDriver();
        openUrl(getWebDriver(), testUrl);
    }

    @AfterClass
    protected void testAfterClass(){
        destroyDriver();
    }

}
