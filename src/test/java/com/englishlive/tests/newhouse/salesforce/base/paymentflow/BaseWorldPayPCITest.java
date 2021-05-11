package com.englishlive.tests.newhouse.salesforce.base.paymentflow;
/**
 * Click on Take Payment button
 * Enter the Worldpay payment details
 * check the payment is successful
 * Check the Opportunity stage Value
 */

import com.englishlive.tests.newhouse.salesforce.base.BaseApprovalTest;
import com.englishtown.helpers.WebDriverWindowHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public abstract class BaseWorldPayPCITest extends BaseApprovalTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseWorldPayPCITest.class);



    @Test(dependsOnMethods = "approveProductAsSupperAdminTest")
    protected void clickOnTakePaymentTest() {
        clickOnTakePayment();
        logger.info("Switch to payemnt window");
        WebDriverWindowHelper.switchToWindow(getWebDriver(),1);
        logger.info("successfully Switched to payemnt window");
       // if(leadRecordType=="Mexico")
            selectPaymentProviderAndContinue(paymentProviderName.getPayProviderName());
    }

    @Test(dependsOnMethods = "clickOnTakePaymentTest")
    protected void enterPaymentDetailsAndPay(){
       // switchToPaymentIFrame();
        enterWorldPayPaymentDetails(paymentMapData,cardName);
        clickContinueAndCloseWorldPay();
    }

    @Test(dependsOnMethods = "enterPaymentDetailsAndPay")
    protected void checkStageValue(){
        logger.info("Switch back to payment window");
        WebDriverWindowHelper.switchToWindow(getWebDriver(),0);
        logger.info("successfully Switched back to parent window");
        opportunityStageCheck(opportunityStageWon);
    }


    @Test(dependsOnMethods ="checkStageValue" )
    protected void verifyActuals() {
        getUrlsAndcheckActuals();
    }

}
