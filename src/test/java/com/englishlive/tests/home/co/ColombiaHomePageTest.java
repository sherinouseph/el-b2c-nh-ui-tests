package com.englishlive.tests.home.co;

import com.englishtown.driver.BaseRemoteWebDriver;
import com.englishtown.helpers.UrlMapper;
import com.englishtown.pages.common.HomePage;
import com.englishtown.tests.core.HomePageTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class ColombiaHomePageTest extends HomePageTest {
    private static final Logger logger = LoggerFactory.getLogger(ColombiaHomePageTest.class);

    @Value("#{applicationPropertiesList['home.es.co.url']}")
    private String pageUrl;

    @BeforeClass
    private void setup(){
        setThreadSafeDriver();
        setLanguageAndMarket("es","co");
        if(getBASEURL().contains("http://webus")) {
            pageUrl = pageUrl.replace("englishlive.ef.com", ".englishtown.com");
        }
        logger.info("setup ... baseurl :"+getBASEURL()+"  page url is : "+pageUrl);
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
