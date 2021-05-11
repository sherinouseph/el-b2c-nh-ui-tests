package com.englishlive.tests.newsite.market.tr;
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


public class TRNewSiteTest extends BaseNewSiteDesktopNavigation {
    private static final Logger logger = LoggerFactory.getLogger(TRNewSiteTest.class);

    @Value("#{applicationPropertiesList['page.home.tr.tr.url']}")
    protected String testUrl;


    @BeforeClass
    protected void setup(){
        setThreadSafeDriver();
        openUrl(getWebDriver(), testUrl);
        isHomePagePhoneNumberPresent=false;
    }

    @AfterClass
    protected void testAfterClass(){
        destroyDriver();
    }

}
