package com.englishlive.tests.newhouse.salesforce.base.BaseCommerceSFSync;
/**
 *
 * Through API - create member, finish payment and add phone number
 *  * open salesforce
 * Check for the lead "Current student "in salesforce
 * Open the lead,convert to opportunity,and then to actual and verify the actual fields
 *
 */

import com.englishlive.tests.newhouse.salesforce.base.BaseAddProductTest;
import com.englishlive.tests.newhouse.salesforce.base.BaseSalesforceTest;
import com.englishlive.tests.newhouse.salesforce.base.renewal.BaseRenewalTest;
import com.englishtown.dataprovider.bin.StudentBean;
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WebDriverWindowHelper;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.newhouse.apicore.BaseApiSpec;
import com.englishtown.pages.common.LoginPage;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalToIgnoringCase;

public abstract class BaseUpsellCSLeadInSFTest extends BaseAddProductTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseUpsellCSLeadInSFTest.class);
    protected LoginPage loginPage;
    protected  String salesType="New";




    @Test(dependsOnMethods = "verifyProductTest")
    protected void clickOnTakePaymentAndAcceptAlertTest() {
        logger.info("clickOnTakePaymentTest");
        clickOnTakePayment();
        alertAccept(20);

    }

    @Test(dependsOnMethods = "clickOnTakePaymentAndAcceptAlertTest")
    protected void enterPaymentDetailsAndPay(){
        logger.info("enterPaymentDetailsAndPay");
        sleep(1000);
        addCardInfoForRenewal_Upsell();
    }

    @Test(dependsOnMethods = "enterPaymentDetailsAndPay")
    protected void checkStageValue(){
        logger.info("checkStageValue");
       // WebDriverWindowHelper.switchToWindow(getWebDriver(),0);
        logger.info("switch back to parent window successfully");
        opportunityStageCheck(opportunityStageWon);
    }

    @Test(dependsOnMethods ="checkStageValue" )
    protected void getUrlsndVerifyActuals()   {
        logger.info("getUrlsndVerifyActuals");
        getUrlsAndcheckActuals();
        checkPaymenStatus("In Progress");
        sleep(4000);
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
        //loginAndOpenUrl(ADMIN_QA,actualUrl);
        //checkFinanceDetails();
    }


}