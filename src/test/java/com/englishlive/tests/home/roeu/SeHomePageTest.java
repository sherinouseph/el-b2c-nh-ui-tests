package com.englishlive.tests.home.roeu;

import com.englishtown.helpers.UrlMapper;
import com.englishtown.pages.common.HomePage;
import com.englishtown.tests.core.HomePageTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class SeHomePageTest extends HomePageTest {
    private static final Logger logger = LoggerFactory.getLogger(SeHomePageTest.class);

    @Value("#{applicationPropertiesList['home.en.se.url']}")
    private String pageUrl;

    @BeforeClass
    public void setup(){
        setThreadSafeDriver();
        this.setLanguageAndMarket("en", "se");
    }

    @Override
    protected HomePage createPage() {
        return new HomePage(getWebDriver(), this.pageUrl);
    }


    @AfterClass
    protected void tearDownAfterClass(){
        destroyDriver();
    }


}
