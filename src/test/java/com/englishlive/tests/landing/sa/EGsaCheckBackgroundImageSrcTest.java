package com.englishlive.tests.landing.sa;
/**
 * EG
 * updated the expectedimage to contain only "meast-consolidation" to run the test on live and QA
 *
 */


import com.englishtown.tests.core.common.BaseCheckBackgroundImageScrTest;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class EGsaCheckBackgroundImageSrcTest extends BaseCheckBackgroundImageScrTest {
    @Value("#{applicationPropertiesList['home.ar.sa.eg.url']}")
    private String testUrl;


    @BeforeClass
    protected void setupBeforeClass(){
        setThreadSafeDriver();
        expectedImageSrc = "meast-consolidation";//"https://et2.ef-cdn.com/dam/englishtown/new-website-2016/meast-consolidation-image.jpg?v=AVx+TGv+" ;
        openUrl(getWebDriver(), testUrl);
    }

    @AfterClass
    protected void teardownAfterClass(){
        destroyDriver();
    }


}
