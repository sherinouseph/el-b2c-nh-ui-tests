package com.englishtown.tests.core;
/**
 * Existing student that its offer has expired, logs in
 * Welcome back page is shown
 * Created by nikol.marku on 24/04/2015.
 */
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.JavaScriptHelper;
import com.englishtown.helpers.WaitTool;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import static org.hamcrest.core.Is.is;


public class BaseWelcomeBack extends BaseTest{
    private static final Logger logger = LoggerFactory.getLogger(BaseWelcomeBack.class);

    protected String welcomeBackUrlContains = "buy/welcome-back/alumni/";

    protected String welcomeBackBtnCss = ".parsys.mainStage button";

    @Test
    void enterUserCredentialsAndLoginTest(){
        logger.info("enterUserCredentialsTest ...!");
        JavaScriptHelper.waitForPageLoaded(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        enterUserLoginCredentialsCss(getWebDriver(), this.username, this.password, emailId, passwordId);
        //enterUserLoginCredentials(getWebDriver(), this.username, this.password, emailId, passwordId);
    }

    @Test ( dependsOnMethods = { "enterUserCredentialsAndLoginTest" })
    public void isWelcomeBackURL(){
        logger.info("isWelcomeBackURL ...!");
        AssertHelper.myAssertThat(getWebDriver(), "Failed, URL '" + getWebDriver().getCurrentUrl() + "' does not contains : " + welcomeBackUrlContains,
                waitForUrlContains(this.getWebDriver(), welcomeBackUrlContains, WaitTool.DEFAULT_WAIT_4_ELEMENT),
                is(true), true) ;
    }

    @Test(dependsOnMethods = { "isWelcomeBackURL" })
    public void isCheckoutFlowTypeWellcomeBackAtWelcomeBackPage() {
        checkFlowType(checkoutFlowType, isTestCheckoutFlowType);
    }
//    @Test ( dependsOnMethods = { "isWelcomeBackURL" })  public void isWelcomeBackOfferButtonsShown(){     logger.info("isWelcomeBackOfferButtonsShown ...!");      currWebElement = WebElementHelper.safeFindElement(getWebDriver(), By.cssSelector(welcomeBackBtnCss));       AssertHelper.myAssertThat(getWebDriver(),"Failed to find offer buttons ...!", currWebElement.isDisplayed(), is(true), true) ;//    }

}
