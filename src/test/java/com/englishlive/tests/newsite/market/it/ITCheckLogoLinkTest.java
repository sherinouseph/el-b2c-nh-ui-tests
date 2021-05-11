package com.englishlive.tests.newsite.market.it;
/**
 * Created by nikol.marku on 8/5/2016.
 * New website base test
 *
 */

import com.englishlive.tests.newsite.core.BaseCheckLogoLinkTest;
import com.englishtown.driver.BaseRemoteWebDriver;
import com.englishtown.driver.MyBrowserType;
import com.englishtown.pages.common.NewHomePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class ITCheckLogoLinkTest extends BaseCheckLogoLinkTest {
    private static final Logger logger = LoggerFactory.getLogger(ITCheckLogoLinkTest.class);

    @Value("#{applicationPropertiesList['new.home.page.it']}")
    protected String testUrl;


    @BeforeClass
    protected void setup(){
        setThreadSafeDriver();
        // edge issue with getting log href value unstable ...
        failTestIfIsNotBrowser(CHROME_FF_IE_SAFARY_BROWSER_LIST, "Chrome Only Test ....!");
        testStartUrl = testUrl;
        openUrl(getWebDriver(), testUrl);
        if(isBrowser(MyBrowserType.EDGE))
            sleep(3000);
        newHomePage = new NewHomePage(getWebDriver());
    }

    @AfterClass
    protected void testAfterClass(){
        destroyDriver();
    }

}
