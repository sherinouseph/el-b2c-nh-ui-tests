package com.englishlive.tests.home.fr;

import com.englishtown.helpers.UrlMapper;
import com.englishtown.pages.common.HomePage;
import com.englishtown.tests.core.HomePageTest;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class FrenchHomePageTest extends HomePageTest {
    @Value("#{applicationPropertiesList['home.fr.fr.url']}")
    public String pageUrl;

    @Override
    protected HomePage createPage() {
        return new HomePage(getWebDriver(), this.pageUrl);
    }


    @BeforeClass
    void setupBeforeClass(){
        setThreadSafeDriver();
        setLanguageAndMarket("fr","fr");
    }

    @AfterClass
    protected void tearDownAfterClass(){
        destroyDriver();
    }
}
