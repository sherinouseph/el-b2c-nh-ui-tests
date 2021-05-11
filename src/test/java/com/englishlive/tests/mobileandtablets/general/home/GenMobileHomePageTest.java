package com.englishlive.tests.mobileandtablets.general.home;
/**
 *
 */

import com.englishtown.tests.core.mobile.core.BaseMobileHomePageTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public abstract class GenMobileHomePageTest extends BaseMobileHomePageTest {
    private static final Logger logger = LoggerFactory.getLogger(GenMobileHomePageTest.class);
    @Value("#{applicationPropertiesList['home.ar.sa.mobile.url']}")
    private String pageUrl;
    //test does the setup
    @BeforeClass
    public void setup(){
        //setupMobileSimulator();
        openUrl(getWebDriver(), pageUrl);
    }

    @Test
    public void isMobileUrl(){
        assertIsUrlContaining("mobile");
    }
}
