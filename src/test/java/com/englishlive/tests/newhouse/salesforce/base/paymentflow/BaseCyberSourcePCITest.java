package com.englishlive.tests.newhouse.salesforce.base.paymentflow;
/**
 * Click on Take Payment button
 * select the payment provider
 * enter the credit card details
 * Check the oppo stage value
 */

import com.englishlive.tests.newhouse.salesforce.base.BaseApprovalTest;
import com.englishtown.helpers.WebDriverWindowHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public abstract class BaseCyberSourcePCITest extends BaseApprovalTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseCyberSourcePCITest.class);



    @Test(dependsOnMethods = "approveProductAsSupperAdminTest")
    protected void clickOnTakePaymentTest() {

        clickOnTakePayment();
    }
    @Test(dependsOnMethods = "clickOnTakePaymentTest")
    protected void selectPaymentProviderAndContinueTest() {
        logger.info("selectPaymentProviderAndContinueTest");
        logger.info("Switch to payemnt window");
        WebDriverWindowHelper.switchToWindow(getWebDriver(),1);
        logger.info("successfully Switched to payemnt window");
        selectPaymentProviderAndContinue(paymentProviderName.getPayProviderName());
        sleep(2000);
    }

    @Test(dependsOnMethods = "selectPaymentProviderAndContinueTest")
    protected void enterPaymentDetailsAndPay(){
        //switchToPaymentIFrame();
        enterPaymentDetails(creditCardMapData, cardName);
        clickPayAndClose();
        logger.info("Switch back to payment window");
        WebDriverWindowHelper.switchToWindow(getWebDriver(),0);
        logger.info("successfully Switched back to parent window");
    }

    @Test(dependsOnMethods = "enterPaymentDetailsAndPay")
    public void checkOpportunityWon() {
        opportunityStageCheck(opportunityStageWon);
    }

    @Test(dependsOnMethods ="checkOpportunityWon" )
    public void verifyActuals() {
        getUrlsAndcheckActuals();
    }


}
