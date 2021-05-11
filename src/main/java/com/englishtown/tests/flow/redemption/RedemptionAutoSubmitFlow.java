package com.englishtown.tests.flow.redemption;
/**
 *
  Open url and form is autosubmited
   member page is shown [ state object Form , Order, Session.Order have redemptionCode]  test session.order.redemptionCode = grd
  Enter member details and create account
  TY page shown /buy/redemption/thankyou/   with enter to school button
 *
 */


import com.englishtown.driver.MyBrowserType;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WaitToolConfig;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.tests.core.EfConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import static com.englishtown.helpers.AssertHelper.myAssertThat;


public abstract class RedemptionAutoSubmitFlow extends BaseRedemptionFlow {
    private static final Logger logger = LoggerFactory.getLogger(RedemptionAutoSubmitFlow.class);


    @Test (priority = 3)
    public void isSessionOrderRedemptionCode() {
        WaitTool.waitForCondition( ExpectedConditions.invisibilityOfElementLocated(
                By.cssSelector(memberSpinnerCss)),getWebDriver(), WaitToolConfig.MED_WAIT_4_ELEMENT25);
        assertStateObjectElementValue(sessionOrderRcodeKey, redemptionCode, true );
    }

    @Test (priority = 4)  //(dependsOnMethods = { "isSessionOrderRedemptionCode" })
    public void enterMemberDetailsAndSubmit() {
        enterFormData(EfConstants.ukMembersFormMap_new);
        enterEmail(getWebDriver(), true);
        WebElementHelper.safeFindAndClick(getWebDriver(), By.cssSelector(submitMemberFormCss));
        sleep(1000);
    }

    @Test (priority = 5)  //(dependsOnMethods = { "enterMemberDetailsAndSubmit" })
    public void isThankyouPage() {
        if(isBrowser(MyBrowserType.EDGE)) sleep(5000);
        myAssertThat(getWebDriver(), "Is not Thankyou page, URL does not contains :'" + thankyouPageUrlContains + "' ",
                verifyUrlContains(thankyouPageUrlContains,  WaitTool.MED_WAIT_4_ELEMENT25), true);
    }

    @Test(priority = 6)
    public void isCheckoutFlowTypeRedemptionAtThankyouPage() {
        checkFlowType(checkoutFlowType, isTestCheckoutFlowType);
    }

}
