package com.englishlive.tests.home.it;


import com.englishtown.pages.common.HomePage;
import com.englishtown.tests.core.HomePageTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class ItalianHomePageTest extends HomePageTest {
    private static final Logger logger = LoggerFactory.getLogger(ItalianHomePageTest.class);

    @Value("#{applicationPropertiesList['home.it.it.url']}")
    private String pageUrl;


    @Override
    protected HomePage createPage() {
        return new HomePage(getWebDriver(), this.pageUrl);
    }


    @BeforeClass
    void setupBeforeClass(){
        setThreadSafeDriver();
        setLanguageAndMarket("it","it");
    }

    @AfterClass
    protected void tearDownAfterClass(){
        destroyDriver();
    }

}
