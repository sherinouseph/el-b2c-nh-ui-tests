package com.englishlive.tests.newsite.market.it;
/**
 * IT
 *
 */
import com.englishlive.tests.newsite.core.BaseNewSiteBrowserActionTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class ITNewSiteBrowserActionTest extends BaseNewSiteBrowserActionTest{
    private static final Logger logger = LoggerFactory.getLogger(ITNewSiteBrowserActionTest.class);

    @Value("#{applicationPropertiesList['new.home.page.it']}")
    protected String testUrl;


    @BeforeClass
    protected void setup(){
        setThreadSafeDriver();
        openUrl(getWebDriver(), testUrl);
    }


    @AfterClass
    protected void teardownAfterClass(){
        destroyDriver();
    }

}
