package com.englishlive.tests.landing.de.forgotpass;

import com.englishlive.tests.landing.core.BaseForgottenPassComponenttest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * Date: 03/11/14
 * Time: 11:03
 *
 */
public class DeSplashTempForgottenPassTest extends BaseForgottenPassComponenttest {
    private static final Logger logger = LoggerFactory.getLogger(DeSplashTempForgottenPassTest.class);

    @Value("#{applicationPropertiesList['de.forgotpasscomponent.splash']}")
    private String testURL;


    @BeforeClass
    protected void setup(){
        setThreadSafeDriver();
        logger.info("When I open URL :"+testURL);
        openUrl(getWebDriver(), testURL);
    }

    @AfterClass
    protected void testAfterClass(){
        destroyDriver();
    }


}
