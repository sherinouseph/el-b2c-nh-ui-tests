package com.englishlive.tests.newhouse.salesforce.base.paymentflow;
/**
 * Click on Take Payment button
 * Select the payment provider PAYU
 * Enter the PAYU  details
 * check the Oppo stage value
 */

import com.englishlive.tests.newhouse.salesforce.base.BaseApprovalTest;
import com.englishtown.helpers.WebDriverWindowHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public abstract class BasePayUPCITest extends BaseApprovalTest {
    private static final Logger logger = LoggerFactory.getLogger(BasePayUPCITest.class);


    @Test(dependsOnMethods = "approveProductAsSupperAdminTest")
    protected void clickOnTakePaymentTest() {
        oppoUrl=getWebDriver().getCurrentUrl();
        openCurrentOpportunityPageUrl(salesForceAgentName);
        clickOnTakePayment();
    }
    @Test(dependsOnMethods = "clickOnTakePaymentTest")
    protected void selectPaymentProviderAndContinueTest() {
        logger.info("selectPaymentProviderAndContinueTest");
        WebDriverWindowHelper.switchToWindow(getWebDriver(),1);
        logger.info("Successfully switched to payment window");
        selectPaymentProviderAndContinue(paymentProviderName.getPayProviderName());
    }

    @Test(dependsOnMethods = "selectPaymentProviderAndContinueTest")
    protected void enterPaymentDetailsAndPay(){
        sleep(1000);
        enterPayUPaymentDetailsAndPay();
        clickSubmitAndClosePayU();
    }

    @Test(dependsOnMethods = "enterPaymentDetailsAndPay")
    protected void checkOpportunityWon(){
        logger.info("Switch back to payment window");
        WebDriverWindowHelper.switchToWindow(getWebDriver(),0);
        logger.info("successfully Switched back to parent window");
        opportunityStageCheck(opportunityStageWon);
    }

    @Test(dependsOnMethods ="checkOpportunityWon" )
    protected void verifyActuals() {
        getUrlsAndcheckActuals();
    }


}
