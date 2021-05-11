package com.englishlive.tests.redirect.all;
/**
 * Open URL wint en-aa -> non existent country code
 * check 404 page title and test
 *
 */
import com.englishtown.helpers.WaitTool;
import com.englishtown.tests.core.redirect.BaseRedirect404Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class CountryCodeNonExistentEnAaRedirectTest extends BaseRedirect404Test {
    private static final Logger logger = LoggerFactory.getLogger(CountryCodeNonExistentEnAaRedirectTest.class);
    @Value("#{applicationPropertiesList['redirect.404.en.aa.url']}")
    protected String pageUrl;


    @BeforeClass
    public void setup(){
        setThreadSafeDriver();
        failTestIfIsNotBrowser(CHROME_BROWSER_LIST, "Chrome Only Test ....!");
        this.openUrl(getWebDriver(), this.pageUrl, WaitTool.PAGELOAD_TIMEOUT_45) ;
        sleep(1000);
    }

    @AfterClass
    protected void destroyDriverAfterClass(){
        destroyDriver();
    }


}

