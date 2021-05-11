package com.englishlive.tests.home.sa;

import com.englishtown.helpers.UrlMapper;
import com.englishtown.pages.common.HomePage;
import com.englishtown.tests.core.HomePageTest;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class ArabiaHomePageTest extends HomePageTest {
    @Value("#{applicationPropertiesList['home.ar.sa.url']}")
    private String pageUrl;

    @Override
    protected HomePage createPage() {
        if(getBASEURL().contains("http://webus")) {
            pageUrl = pageUrl.replace("englishlive.ef.com", ".englishtown.com");
        }
        return new HomePage(getWebDriver(), this.pageUrl);
    }


    @BeforeClass
    void setupBeforeClass(){
        setThreadSafeDriver();
        setLanguageAndMarket("ar","sa");
    }

    @AfterClass
    protected void tearDownAfterClass(){
        destroyDriver();
    }
}
