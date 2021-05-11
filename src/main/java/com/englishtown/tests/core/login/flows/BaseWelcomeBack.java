package com.englishtown.tests.core.login.flows;
/**
 * Nikol 2018
 *
 * Login and check welcome back page
 *
 * https://jira.eflabs.io/browse/SAND-5821
 * TC-49312:Login Flows NewHouse
 * Base class for welcome back alumni and suspended
 *
 */

import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.pages.checkout.newcheckout.BaseAlumniOfferPage;
import com.englishtown.tests.core.school.BaseLogin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import static org.hamcrest.core.Is.is;


public abstract class BaseWelcomeBack extends BaseLogin {
    private static final Logger logger = LoggerFactory.getLogger(BaseWelcomeBack.class);

    protected final String WELCOME_BACK_ALUMNI    = "buy/welcome-back/alumni/";    // cancelled subscription
    protected final String WELCOME_BACK_SUSPENDED = "buy/welcome-back/suspended/"; // suspended
    protected final String WELCOME_BACK_MEMBER    = "buy/welcome-back/member/";    // not paid but a member

    protected String welcomeBackUrlContains    = "TestSetMeup";

    protected String welcomeBackBtnCss = ".parsys.mainStage button";

    protected BaseAlumniOfferPage baseAlumniOfferPage;



    @Test ( dependsOnMethods = { "enterUserCredentialsAndLoginToSchool" })
    public void isWelcomeBackURL(){
        logger.info("isWelcomeBackURL ...! [{}]", welcomeBackUrlContains);
        AssertHelper.myAssertThat(getWebDriver(), "Failed, URL '" + getWebDriver().getCurrentUrl() + "' does not contains : " + welcomeBackUrlContains,
                waitForUrlContains(this.getWebDriver(), welcomeBackUrlContains, WaitTool.DEFAULT_WAIT_4_ELEMENT),
                is(true), true) ;
    }

    @Test(dependsOnMethods = { "isWelcomeBackURL" })
    public void isCheckoutFlowTypeWellcomeBackAtWelcomeBackPage() {
        checkFlowType(checkoutFlowType, isTestCheckoutFlowType);
    }

   @Test ( dependsOnMethods = { "isWelcomeBackURL" })
   public void isWelcomeBackOfferButtonsShown() {
        logger.info("isWelcomeBackOfferButtonsShown ...!");
        baseAlumniOfferPage = new BaseAlumniOfferPage(getWebDriver());
        baseAlumniOfferPage.getPageLoadedCondition();
        baseAlumniOfferPage.simpleTest();        //currWebElement = WebElementHelper.safeFindElement(getWebDriver(), By.cssSelector(welcomeBackBtnCss));               AssertHelper.myAssertThat(getWebDriver(),"Failed to find offer buttons ...!", currWebElement.isDisplayed(), is(true), true) ;//    }
   }

}
