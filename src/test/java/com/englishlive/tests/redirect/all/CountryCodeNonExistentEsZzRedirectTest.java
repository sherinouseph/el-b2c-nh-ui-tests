package com.englishlive.tests.redirect.all;
/**
 *
 *
 */
import com.englishtown.tests.core.redirect.BaseRedirect404Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class CountryCodeNonExistentEsZzRedirectTest extends BaseRedirect404Test {
    private static final Logger logger = LoggerFactory.getLogger(CountryCodeNonExistentEsZzRedirectTest.class);
    @Value("#{applicationPropertiesList['redirect.404.es.zz.url']}")
    protected String pageUrl;


    @BeforeClass
    public void setup(){
        setThreadSafeDriver();
        failTestIfIsNotBrowser(CHROME_BROWSER_LIST, "Chrome Only Test ....!");
        this.openUrl(getWebDriver(), this.pageUrl, -1 ) ;
        sleep(1000);
    }

    @AfterClass
    protected void destroyDriverAfterClass(){
        destroyDriver();
    }


}

