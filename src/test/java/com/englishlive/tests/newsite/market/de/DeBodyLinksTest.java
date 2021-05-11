package com.englishlive.tests.newsite.market.de;

import com.englishtown.tests.core.common.BaseBodyLinksTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
//SAND-4675-Sherin - check the main links for any reference to aem.eflabs.io or eflabs.io
//Make sure all the links in homepage,how it works page points to format englishlive.ef.com/xx-xx/

public class DeBodyLinksTest extends BaseBodyLinksTest {
    private static final Logger logger = LoggerFactory.getLogger(DeBodyLinksTest.class);

   @Value("#{applicationPropertiesList['home.page.de.de']}")
    public String testUrl;

    @BeforeClass
    void setupBeforeClass(){
        setThreadSafeDriver();
        testStartUrl = testUrl;
        testUrl = testUrl+"?ctr=de";
        openUrl(getWebDriver(), testUrl);
    }


    @AfterClass
    protected void tearDownAfterClass(){
      destroyDriver();
    }
}
