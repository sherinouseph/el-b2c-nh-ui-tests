package com.englishlive.tests.newhouse.salesforce.base.recurring;
/**
 * sherin- 10/11/2017
 * renewal test - click on account,add new oppo-enter details-take payment-verify actuals created and check the sales type
 */


import com.englishlive.tests.newhouse.salesforce.base.paymentflow.BaseCreditCardTest;
import com.englishtown.helpers.JavaScriptHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.newhouse.salesforce.pages.AccountPage;
import com.englishtown.newhouse.salesforce.pages.OppoSalesForcePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public abstract class BaseRecurringTest extends BaseCreditCardTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseRecurringTest.class);


    @Test(dependsOnMethods = "getUrlsndVerifyActuals")
    public void clickOnPaymentRecord(){
        loginAndOpenUrl(salesForceSupervisorName, actualUrl);
        JavaScriptHelper.scrollToXY(getWebDriver(),0,3000);
        clickOnPaymentRecord(1);
       // WaitTool.waitForElementVisible(getWebDriver(), By.id("opp9"), 65, 1000);

    }

    @Test(dependsOnMethods = "clickOnPaymentRecord")
    public void chargePaymentAndVerifyStatus(){
        logger.info("chargePaymentAndVerifyStatus");
        checkChargeNowFunction();

    }

    @Test(dependsOnMethods = "chargePaymentAndVerifyStatus")
    public void checkNewPaymentRecordCreates(){
        logger.info("checkNewPaymentRecordCreates");
        openUrl(getWebDriver(),actualUrl);
        clickOnPaymentRecord(2);
        verifyPaymentStatus("Due");
    }


}
