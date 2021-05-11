package com.englishlive.tests.home.en;

import com.englishtown.helpers.UrlMapper;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.pages.common.HomePage;
import com.englishtown.tests.core.HomePageTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class EnglishHomePageTest extends HomePageTest {
    private static final Logger logger = LoggerFactory.getLogger(EnglishHomePageTest.class);

    @Value("#{applicationPropertiesList['home.en.en.url']}")
    private String pageUrl;

    @Override
    protected HomePage createPage() {
        TestUtil.printMethodName(logger);
        if(getBASEURL().contains("http://webus")) {
            pageUrl = pageUrl.replace("englishlive.ef.com", ".englishtown.com");
        }

        return new HomePage(getWebDriver(), this.pageUrl);
    }


    @BeforeClass
    void setupBeforeClass(){
        setThreadSafeDriver();
        setLanguageAndMarket("en","gb");
    }

    @AfterClass
    protected void tearDownAfterClass(){
        destroyDriver();
    }
}