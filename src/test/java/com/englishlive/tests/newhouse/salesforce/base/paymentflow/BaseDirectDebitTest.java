package com.englishlive.tests.newhouse.salesforce.base.paymentflow;
/**
 * click on Take Payment button
 * Enter the Debitcard payment details
 * Check oppo stage value
 */

import com.englishlive.tests.newhouse.salesforce.base.BaseAddProductTest;
import com.englishtown.helpers.WebDriverWindowHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public abstract class BaseDirectDebitTest extends BaseAddProductTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseDirectDebitTest.class);


    @Test(dependsOnMethods = "verifyProductTest")
    protected void clickOnTakePaymentTest() {
        clickOnTakePayment();
        logger.info("Switch to payment window");
        WebDriverWindowHelper.switchToWindow(getWebDriver(),1);
        logger.info("successfully switched to payment window");
    }

    @Test(dependsOnMethods = "clickOnTakePaymentTest")
    protected void enterPaymentDetailsAndPay(){
        enterFormData(paymentMapData);
        clickSubmitAndClose();
    }

    @Test(dependsOnMethods = "enterPaymentDetailsAndPay")
    protected void checkStageValue(){
        WebDriverWindowHelper.switchToWindow(getWebDriver(),0);
        logger.info("successfully switched back to parent window");
        opportunityStageCheck(opportunityStageWon);
    }

    @Test(dependsOnMethods ="checkStageValue" )
    protected void verifyActuals()
    {
        getUrlsAndcheckActuals();
        checkMappingstatus();
        getMemberId();
        checkActivationstatus();
        getEtownOrderId();
        loginAndOpenUrl(ADMIN_QA,actualUrl);
        checkFinanceDetails();

//        if(salesForceUserName==ADMIN_QA) {
//            checkMappingstatus();
//            getMemberId();
//            checkActivationstatus();
//        }
//           logger.info("Logged in as france user.so no mapping status is present.");
//            getEtownOrderId();
//            getMemberId();
    }
//
//    @Test(dependsOnMethods ="verifyActuals" )
//    public void loginAsSupervisorAndGoToActual() {

//        logger.info("Login as supervisor and go to Actual Page");
//        actualUrl = getWebDriver().getCurrentUrl();
//        openCurrentActualPageUrl(salesForceSupervisorName);
    //}
    @Test(dependsOnMethods ="verifyActuals" )
    public void clickonPaymentRecord(){
        logger.info("Click on the payment record in Actual Page");
        clickOnPaymentRecord(2);//click on index one as you are actually clicking on the 2nd payment record
    }

    @Test(dependsOnMethods ="clickonPaymentRecord" )
    public void chargeNowTest(){
        logger.info("chargeNowTest");
        checkChargeNowFunction();
    }

}
