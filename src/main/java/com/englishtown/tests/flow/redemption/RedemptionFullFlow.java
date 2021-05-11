package com.englishtown.tests.flow.redemption;
/**
 * Created by nikol.marku on 29/10/2015.
 1. Open url : e.g: https://qa-englishlive.ef.com/en-us/buy/redemption/index/?rcode=grd&autosubmit=false
 2. submit form  - member page is shown [ state object Form , Order, Session.Order have redemptionCode]  test session.order.redemptionCode = grd
 3. Enter member details and create account
 4. TY page shown /buy/redemption/thankyou/   with enter to school button
 *
 */

import com.englishtown.helpers.WebElementHelper;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public abstract class RedemptionFullFlow extends RedemptionAutoSubmitFlow {
    private static final Logger logger = LoggerFactory.getLogger(RedemptionFullFlow.class);

    @Test(priority = 0)
    public void isRedemptionCodeTextField_prepopulated(){
        isRedemptionCodePrepopulatedFromUrlParams(getWebDriver());
    }

    @Test (priority = 1 ) //,dependsOnMethods = { "isRedemptionCodeTextField_prepopulated" })
    public void submitRedeemForm() {
        WebElementHelper.safeFindAndClick(getWebDriver(), By.cssSelector(submitRCcss));
        sleep(3000);
    }

}
