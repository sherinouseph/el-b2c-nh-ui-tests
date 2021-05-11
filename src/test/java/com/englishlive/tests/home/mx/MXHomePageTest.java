package com.englishlive.tests.home.mx;

import com.englishtown.helpers.UrlMapper;
import com.englishtown.pages.common.HomePage;
import com.englishtown.tests.core.HomePageTest;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class MXHomePageTest extends HomePageTest {

    @Value("#{applicationPropertiesList['page.home.es.mx.url']}")
    private String pageUrl;

    @Override
    protected HomePage createPage() {
        return new HomePage(getWebDriver(), this.pageUrl);
    }


    @BeforeClass
    void setupBeforeClass(){
        setThreadSafeDriver();
        setLanguageAndMarket("es","mx");
    }

    @AfterClass
    protected void tearDownAfterClass(){
        destroyDriver();
    }
}
