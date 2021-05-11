package com.englishlive.tests.home.all;

/**
 *
 * Open page and check cookie for englishtown ctr=xx
 *
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.BeforeClass;


public class AllMainMarketCheckCookieCtrValueTest extends BaseCtrCookieValueTest {
    private static final Logger logger = LoggerFactory.getLogger(AllMainMarketCheckCookieCtrValueTest.class);
    @Value("#{applicationPropertiesList['mx.ef.url']}")
    private String pageUrl;


    @BeforeClass
    public void setupOpenURL(){
        countryCtr = "mx"; // only for mx.ef.url
        efEtownUrl = pageUrl+"?ctr="+countryCtr;
    }


}
