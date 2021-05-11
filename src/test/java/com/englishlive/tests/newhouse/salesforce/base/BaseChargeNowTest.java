package com.englishlive.tests.newhouse.salesforce.base;
/**
 * Login to sales force
 */

import com.englishlive.tests.newhouse.salesforce.base.paymentflow.BaseCreditCardTest;
import com.englishtown.helpers.AssertHelper;
import com.englishtown.newhouse.salesforce.pages.ActualSalesForcePage;
import com.englishtown.newhouse.salesforce.pages.core.SalesForceConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalToIgnoringCase;

public abstract class BaseChargeNowTest extends BaseUpdateCardTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseChargeNowTest.class);


    @Test(dependsOnMethods ="checkCardTypeInActual" )
    public void loginAsSupervisorAndGoToActual() {
        logger.info("Login as supervisor and go to Actual Page");
       loginAndOpenUrl(salesForceSupervisorName,actualUrl);
    }
    @Test(dependsOnMethods ="loginAsSupervisorAndGoToActual" )
    public void clickonPaymentRecordToCharge(){
        logger.info("Click on the payment record in Actual Page");
        clickOnPaymentRecord(2);//click on index one as you are actually clicking on the 2nd payment record
    }

    @Test(dependsOnMethods ="clickonPaymentRecordToCharge" )
    public void chargeNowTest(){
        logger.info("chargeNowTest");
        checkChargeNowFunction();
    }


}
