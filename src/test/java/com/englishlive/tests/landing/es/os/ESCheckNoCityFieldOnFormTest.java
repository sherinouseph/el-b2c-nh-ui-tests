package com.englishlive.tests.landing.es.os;
/**
 *
 */

import com.englishlive.tests.landing.base.BaseOSPageTest;
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.UrlMapper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.pages.core.BasePage;
import com.englishtown.pages.landing.OSLandingPage;
import com.englishtown.tests.core.BaseTest;
import com.englishtown.tests.core.BaseTestHelper;
import com.englishtown.tests.core.EfConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class ESCheckNoCityFieldOnFormTest extends BaseTestHelper {
    private static final Logger logger = LoggerFactory.getLogger(ESCheckNoCityFieldOnFormTest.class);

    @Value("#{applicationPropertiesList['es1.os.url']}")
    private String testUrl;

    @BeforeClass
    protected void setup(){
        setThreadSafeDriver();
        openUrl(getWebDriver(), testUrl);
    }

    @Test
    protected void checkCityFiledNotShownOnform(){
        logger.info("checkCityFiledNotShownOnform ...!");
        WebElement we = WaitTool.waitForElementPresent(getWebDriver(), By.id("city"), WaitTool.WAIT_5s);

        if(we !=null){
            BasePage.failTest("City field is shown of form ....! and it should not be there. Waited for seconds : "+WaitTool.WAIT_5s);
        } else {
            logger.info("No element with ID city found ...! as expected");
        }
    }


    @AfterClass
    protected void setupAfterClass(){
        destroyDriver();
    }

}


