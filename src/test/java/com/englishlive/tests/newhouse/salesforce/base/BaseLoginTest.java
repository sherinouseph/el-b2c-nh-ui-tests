package com.englishlive.tests.newhouse.salesforce.base;
/**
 * Login to sales force
 */

import com.englishtown.helpers.WaitTool;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public abstract class BaseLoginTest extends BaseSalesforceTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseLoginTest.class);

    protected String LIVE_DIALOG_CSS = "tryLexDialog";


    @Test
    protected void login(){
        openSalesForceAndlogin(salesForceUserName, SALESFORCE_PASS);
        sleep(3000);
//        if(SALESFORCE_ENV.contains("Live")) {
//            waitForElementCondition(ExpectedConditions.elementToBeClickable(
//                    By.id("tryLexDialogX")), getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
//            sleep(3000);
//            currWebElement = findElement(By.id("tryLexDialogX"), WaitTool.DEFAULT_WAIT_4_ELEMENT);
//            click(currWebElement);
//        }
    }

}
