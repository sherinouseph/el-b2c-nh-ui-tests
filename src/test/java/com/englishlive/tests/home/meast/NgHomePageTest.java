package com.englishlive.tests.home.meast;

import com.englishtown.helpers.UrlMapper;
import com.englishtown.pages.common.HomePage;
import com.englishtown.tests.core.HomePageTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class NgHomePageTest extends HomePageTest {
    private static final Logger logger = LoggerFactory.getLogger(NgHomePageTest.class);

    @Value("#{applicationPropertiesList['home.en.ng.url']}")
    private String pageUrl;

    @BeforeClass
    public void setup(){
        setThreadSafeDriver();
        this.setLanguageAndMarket("en", "ng");
    }

    @Override
    protected HomePage createPage() {
        //pageUrl = UrlMapper.mapUrlToELive(pageUrl, getBASEURL());
        return new HomePage(getWebDriver(), this.pageUrl);
    }




    @AfterClass
    protected void tearDownAfterClass(){
        destroyDriver();
    }


}
