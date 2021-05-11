package com.englishlive.tests.landing.sa;
/**
 *updated expected image src to cotnain only "meast-hero" to make the test run on live and QA
 */

import com.englishtown.tests.core.BaseTestHelper;
import com.englishtown.tests.core.common.BaseCheckBackgroundImageScrTest;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;



public class SaCheckBackgroundImageTest extends BaseCheckBackgroundImageScrTest {
    @Value("#{applicationPropertiesList['home.ar.sa.url']}")
    private String testUrl;


    @BeforeClass
    protected void setupBeforeClass(){
        setThreadSafeDriver();
        expectedImageSrc = "home-hero";//https://et2.ef-cdn.com/dam/englishtown/new-website-2016/meast-hero-1920x450.jpg?v=AVulbqHK" ;
        openUrl(getWebDriver(), testUrl);
    }

    @AfterClass
    protected void teardownAfterClass(){
        destroyDriver();
    }


}
