package com.englishlive.tests.login;
/**
 * Created by nikol.marku on 12/29/2016.
 * DE Forgotten password full test
 *
 *
 */
import com.englishtown.pages.common.LoginPage;
import com.englishtown.tests.core.login.flows.BaseForgotenPassTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class DeForgottenPassTest extends BaseForgotenPassTest {
    private static final Logger logger = LoggerFactory.getLogger(DeForgottenPassTest.class);
    @Value("#{applicationPropertiesList['de.login.page']}")
    protected String testUrl;


    @BeforeClass
    protected void setup(){
        setThreadSafeDriver();
        openUrl(getWebDriver(), testUrl);
        sleep(1000);
        successfulMsg = "Vielen Dank, bitte";
        userNameValidationMSg = "Bitte geben Sie";
        loginPage = new LoginPage(getWebDriver());
        loginPage.getPageLoadedCondition();
        forgottenPassPage = loginPage.goToForgottenPassPage();
        sleep(3000);
        forgottenPassPage.setUSERNAME_VALIDATION_MSG(userNameValidationMSg);
    }

    @AfterClass
    protected void testAfterClass(){
        destroyDriver();
    }

}
