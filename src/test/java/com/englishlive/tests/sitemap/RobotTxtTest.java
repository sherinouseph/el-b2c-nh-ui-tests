package com.englishlive.tests.sitemap;
/**
 *
 *
 */

import com.englishlive.tests.basetest.htmlunit.BaseHtmlUnitDriverConfig;
import com.englishtown.dataprovider.RobotTxtDataProvider;
import com.englishtown.helpers.UrlMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class RobotTxtTest extends BaseHtmlUnitDriverConfig {
    private static final Logger logger = LoggerFactory.getLogger(RobotTxtTest.class);
    @Value("#{applicationPropertiesList['sitemap.fr.fr.url']}")
    private String testUrl;


    @BeforeClass
    private void setup() {
        //setUpHtmlUnitDriver(); //runTestOnHtmlUnitAndFailIfNotChrome();
        htmlUnitTestUrl = testUrl;
    }

    @Test (dataProvider = "robotTxtAllUrl", dataProviderClass = RobotTxtDataProvider.class )
    public void openUrl_CheckResponse(String country, String url) {
        int expectedResponseCode = 200;
        if(url.contains("englishtown")) {
            url = UrlMapper.mapEliveBaseUrlToEtownBaseUrl(BASE_URL) + url;
        }else {
            url = BASE_URL + url;
        }
        logger.info("Test Response for URL ["+url+"] ; is :"+expectedResponseCode);
        openUrlCheckResponseCode( expectedResponseCode, url);
    }


//    @AfterTest
//    public synchronized void testTearDown(){
//        logger.info(" AfterTest tearDown...!") ;
//        //CookieHandler.setCookies(getHtmlUnitDriver(),getBrowserName(getHtmlUnitDriver()) , "");// null
//        //tearDown();
//    }

}