package com.englishlive.tests.login.negativetest;
/**
 * Created by nikol.marku on 12/30/2016.
 *
 *
 */

import com.englishtown.pages.common.LoginPage;
import com.englishtown.tests.core.login.BaseNegativeLoginTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class DeNegativeLoginTest extends BaseNegativeLoginTest {
    private static final Logger logger = LoggerFactory.getLogger(DeNegativeLoginTest.class);
    @Value("#{applicationPropertiesList['de.login.page']}")
    protected String testUrl;


    @BeforeClass
    protected void setup(){
        setThreadSafeDriver();
        userNameValidationMsg = "dresse angeben";
        passValidationMsg     = "asswort angeben";
        loginFailedMsg        = "Login fehlgeschlagen, bitte";
        openUrl(getWebDriver(), testUrl);
        sleep(2000);
        loginPage = new LoginPage(getWebDriver());
        loginPage.getPageLoadedCondition();
    }

    @AfterClass
    protected void testAfterClass(){
        destroyDriver();
    }

}