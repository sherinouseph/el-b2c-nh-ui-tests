package com.englishlive.tests.redirect.redirectslashhtml.br;
/**
 *
 *
 */
import com.englishtown.pages.landing.OSLandingPage;
import com.englishtown.tests.core.redirect.BaseRedirectURLTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BrURLendWithHtmlRedirectTest extends BaseRedirectURLTest {
    private static final Logger logger = LoggerFactory.getLogger(BrURLendWithHtmlRedirectTest.class);
    @Value("#{applicationPropertiesList['redirect.br.endsWitHtml.url']}")
    protected String pageUrl ;


    @BeforeClass
    public void setup(){
        setThreadSafeDriver();
        urlEndsWith = "sobre-nos/";
        this.openUrl(getWebDriver(), this.pageUrl, -1) ;
        sleep(1000);
    }


    protected OSLandingPage createPage() {
        return new OSLandingPage(getWebDriver(), this.pageUrl);
    }

    @AfterClass
    protected void destroyDriverAfterClass(){
        destroyDriver();
    }


}

