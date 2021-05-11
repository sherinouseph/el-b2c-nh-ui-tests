package com.englishlive.tests.home.de;


import com.englishtown.pages.common.HomePage;
import com.englishtown.tests.core.HomePageTest;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class GermanHomePageTest extends HomePageTest {
    @Value("#{applicationPropertiesList['home.de.de.url']}")
    private String pageUrl;

    @BeforeClass
    void setupBeforeClass(){
        setThreadSafeDriver();
        setLanguageAndMarket("de","de");
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
