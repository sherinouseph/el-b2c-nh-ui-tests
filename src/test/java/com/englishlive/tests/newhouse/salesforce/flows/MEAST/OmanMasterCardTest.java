package com.englishlive.tests.newhouse.salesforce.flows.MEAST;
/**
 * Sherin - 05/11/2017
 * Login to sales force
 * Create the actuals through CreditCard
 */

import com.englishlive.tests.newhouse.salesforce.base.paymentflow.BaseCreditCardTest;
import com.englishtown.newhouse.salesforce.pages.core.SalesForceConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OmanMasterCardTest extends BaseCreditCardTest {
    private static final Logger logger = LoggerFactory.getLogger(OmanMasterCardTest.class);


    @BeforeTest
    public void setup(){
        leadRecordType = "MEAST";
        productName       = "EU PT 52 12m";
        leadCountry       ="Oman";
        testStartUrl      = SALESFORCE_QA_URL;
        leadMapData       = SalesForceConstants.LEAD_MAP;
        creditCardMapData = SalesForceConstants.CREDITCARD_MASTERCARD_MAP;
        cardName          = "Mastercard";
        salesForceAgentName = MEAST_SALESAGENT_QA;
        salesForceUserName  = salesForceAgentName;
        setThreadSafeDriver();
    }
   @Override
   protected void getUrlsndVerifyActuals()   {
    getUrlsAndcheckActuals();
    checkPaymenStatus("In Progress");
    checkMappingstatus();
    logger.info("Member id :"+getMemberId());        //checkActivationstatus();        //getEtownOrderId();
    setUserMemberId(getMemberId());
    //checkActivationstatus();
    getEtownOrderId();
    //login as admin as only admin user can see the payment flow token field
    loginAndOpenUrl(ADMIN_QA, actualUrl);
    checkFinanceDetails();
    detailCheckActualFields_Vtp();

}

    @AfterTest
    protected void testAfterClass(){
        destroyDriver();
    }


}
