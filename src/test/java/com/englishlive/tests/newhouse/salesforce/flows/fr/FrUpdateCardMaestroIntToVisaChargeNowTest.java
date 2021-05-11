package com.englishlive.tests.newhouse.salesforce.flows.fr;
/**
 * Sherin - 07/11/2017
 * Login to sales force
 * Create the actuals through Credit Card Maestro Int.
 */

import com.englishlive.tests.newhouse.salesforce.base.BaseChargeNowTest;
import com.englishlive.tests.newhouse.salesforce.base.paymentflow.BaseCreditCardTest;
import com.englishtown.newhouse.salesforce.pages.core.SalesForceConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FrUpdateCardMaestroIntToVisaChargeNowTest extends BaseChargeNowTest {
    private static final Logger logger = LoggerFactory.getLogger(FrUpdateCardMaestroIntToVisaChargeNowTest.class);


    @BeforeTest
    public void setup(){
        leadRecordType = "France";
        isChargeNowShowAlertTwice = true;
        testStartUrl = SALESFORCE_QA_URL;
        productName       = "EU PT 52 12m";
        paymentFrameId=0;
        testStartUrl      = SALESFORCE_QA_URL;
        leadMapData       = SalesForceConstants.LEAD_MAP;
        creditCardMapData = SalesForceConstants.CREDITCARD_MAESTROINT_MAP;
        cardName          = "Maestro Int.";
        salesForceAgentName=FRANCE_SALESAGENT_QA;
        salesForceUserName = salesForceAgentName;
        isAddQuality=true;
        setThreadSafeDriver();
    }


    @Override

    protected void getUrlsndVerifyActuals()   {
        getUrlsAndcheckActuals();
        checkPaymenStatus("In Progress");
        checkMappingstatus();
        logger.info("Member id :"+getMemberId());        //checkActivationstatus();        //getEtownOrderId();
        setUserMemberId(getMemberId());
        checkActivationstatus();
        getEtownOrderId();
        //login as admin as only admin user can see the payment flow token field
        loginAndOpenUrl(ADMIN_QA,actualUrl);
        checkFinanceDetails();
        detailCheckActualFields_Vtp();

    }


    @AfterTest
    protected void testAfterClass(){
        destroyDriver();
    }


}
