package com.englishlive.tests.newhouse.salesforce.base.paymentflow;
/**
 * Click on Take Payment button
 * Enter the credit card details according to different card types
 * Check the Payment message and check the oppo stage value
 */

import com.englishlive.tests.newhouse.salesforce.base.BaseAddProductTest;
import com.englishtown.helpers.WebDriverWindowHelper;
import com.englishtown.newhouse.salesforce.pages.OppoSalesForcePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public abstract class BaseCreditCardTest extends BaseAddProductTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseCreditCardTest.class);


    @Test(dependsOnMethods = "verifyProductTest")
    protected void clickOnTakePaymentTest() {
        logger.info("clickOnTakePaymentTest");
        clickOnTakePayment();
        logger.info("Switch to window");
        WebDriverWindowHelper.switchToWindow(getWebDriver(),1);
        logger.info("Switched to payment window successfully");
    }

    @Test(dependsOnMethods = "clickOnTakePaymentTest")
    protected void enterPaymentDetailsAndPay(){
        logger.info("enterPaymentDetailsAndPay");
        sleep(10000);
        refresh(getWebDriver());
        enterPaymentDetails(creditCardMapData, cardName);
        clickPayAndClose();
    }

    @Test(dependsOnMethods = "enterPaymentDetailsAndPay")
    protected void checkStageValue(){
        logger.info("checkStageValue");
        WebDriverWindowHelper.switchToWindow(getWebDriver(),0);
        logger.info("switch back to parent window successfully");
        opportunityStageCheck(opportunityStageWon);
    }

    @Test(dependsOnMethods ="checkStageValue" )
    protected void getUrlsndVerifyActuals()   {
        logger.info("getUrlsndVerifyActuals");
        getUrlsAndcheckActuals();
        checkPaymenStatus("In Progress");
        sleep(10000);
        checkMappingstatus();
        if(isNewhousePayment){
            logger.info("Ef id :" + getEfId());        //checkActivationstatus();        //getEtownOrderId();
            setEfId(getEfId());
        }else {
            logger.info("Member id :" + getMemberId());        //checkActivationstatus();        //getEtownOrderId();
            setUserMemberId(getMemberId());
        }
        checkActivationstatus();
        getEtownOrderId();
        //login as admin as only admin user can see the payment flow token field
        loginAndOpenUrl(ADMIN_QA,actualUrl);
        checkFinanceDetails();
    }


}
