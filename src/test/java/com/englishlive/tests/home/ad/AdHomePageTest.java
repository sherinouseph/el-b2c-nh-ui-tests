package com.englishlive.tests.home.ad;

import com.englishtown.helpers.UrlMapper;
import com.englishtown.pages.common.HomePage;
import com.englishtown.tests.core.HomePageTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class AdHomePageTest extends HomePageTest {
    private static final Logger logger = LoggerFactory.getLogger(AdHomePageTest.class);

    @Value("#{applicationPropertiesList['home.en.ad.url']}")
    private String pageUrl;

    @BeforeClass
    private void setup(){
        setThreadSafeDriver();
        logger.info("setup ... baseurl :"+getBASEURL()+"  page url is : "+pageUrl);
        this.setLanguageAndMarket("en","ad");
    }

    @Override
    protected HomePage createPage() {                          //System.out.println("ColombiaHomePageTest delete allcookies - createPage : " + this.pageUrl);           //logger.info("ColombiaHomePageTest deleteAllCookies");        //getWebDriver().manage().deleteAllCookies() ;
        return new HomePage(getWebDriver(), this.pageUrl);
    }


    @AfterClass
    protected void testAfterClass(){
        destroyDriver();
    }
    

}
