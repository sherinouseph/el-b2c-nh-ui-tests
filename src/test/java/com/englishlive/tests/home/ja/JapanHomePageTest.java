package com.englishlive.tests.home.ja;

import com.englishtown.helpers.UrlMapper;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.pages.common.HomePage;
import com.englishtown.tests.core.HomePageTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class JapanHomePageTest extends HomePageTest {
    private static final Logger logger = LoggerFactory.getLogger(JapanHomePageTest.class);

    @Value("#{applicationPropertiesList['home.jp.jp.url']}")
    private String pageUrl;

    @Override
    protected HomePage createPage() {
        TestUtil.printMethodName(logger);
        this.setMarket("jp");
        this.setLanguage("ja");
        return new HomePage(getWebDriver(), this.pageUrl);
    }


    @BeforeClass
    void setupBeforeClass(){
        setThreadSafeDriver();
    }

    @AfterClass
    protected void tearDownAfterClass(){
        destroyDriver();
    }
}
