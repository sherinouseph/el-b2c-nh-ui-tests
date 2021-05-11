package com.englishlive.tests.newhouse.salesforce.base;
/**
 * Login to sales force
 */

import com.englishlive.tests.newhouse.salesforce.base.paymentflow.BaseCreditCardTest;
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.newhouse.salesforce.pages.ActualSalesForcePage;
import com.englishtown.newhouse.salesforce.pages.core.SalesForceConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalToIgnoringCase;

public abstract class BaseUpdateCardTest extends BaseCreditCardTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseUpdateCardTest.class);


    @Test(dependsOnMethods = "getUrlsndVerifyActuals")
    protected void clickOnUpdatePaymentBtn(){
        openUrl(getWebDriver(),actualUrl);
        logger.info("clickOnUpdatePaymentBtn");
        actualSalesForcePage=new ActualSalesForcePage(getWebDriver(),30);
        actualSalesForcePage.clickUpdatePaymentBtnVtp();
    }


    @Test(dependsOnMethods = "clickOnUpdatePaymentBtn")
    protected void enterPaymentDetailsForVisaAndPay(){
        logger.info("enterPaymentDetailsForVisaAndPay");
       // paymentFrameId=3;
        switchToPaymenWindow(1);
        logger.info("successfully switched to payment window");
        creditCardMapData = SalesForceConstants.CREDITCARD_VISA_MAP;
        cardName          = "Visa";
        refresh(getWebDriver());
        enterPaymentDetails(creditCardMapData, cardName);
        clickPayAndClose();
    }

    @Test(dependsOnMethods = "enterPaymentDetailsForVisaAndPay")
    protected void checkCardTypeInActual(){
        logger.info("checkCardTypeInActual");
        switchToPaymenWindow(0);
        logger.info("successfully switched back to parent window");
        actualSalesForcePage=new ActualSalesForcePage(getWebDriver(),30);
        sleep(5000);
        refresh(getWebDriver());
        String creditCardType = actualSalesForcePage.getCardType();
        logger.info("Credit Card type is " + creditCardType);
        AssertHelper.myAssertThat(getWebDriver(), "Card type did not update to " + cardName,creditCardType, equalToIgnoringCase(cardName), true);
        logger.info("Updated Card successfully to use " + cardName);
    }


}
