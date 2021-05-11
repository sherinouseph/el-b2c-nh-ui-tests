package com.englishlive.tests.newhouse.salesforce.flows.tr;
/**
 * Sherin - 07/11/2017
 * Login to sales force
 * Create the actuals through Credit Card Maestro Int.
 */

import com.englishlive.tests.newhouse.salesforce.base.BaseChargeNowTest;
import com.englishtown.newhouse.salesforce.pages.core.SalesForceConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TrUpdateCardMaestroIntToVisaChargeNowTest extends BaseChargeNowTest {
    private static final Logger logger = LoggerFactory.getLogger(TrUpdateCardMaestroIntToVisaChargeNowTest.class);


    @BeforeTest
    public void setup(){
        leadRecordType = "Turkey";
        isChargeNowShowAlertTwice = true;
        testStartUrl = SALESFORCE_QA_URL;
        productName       = "EU PT 52 12m";
        paymentFrameId=0;
        testStartUrl      = SALESFORCE_QA_URL;
        leadMapData       = SalesForceConstants.LEAD_MAP;
        creditCardMapData = SalesForceConstants.CREDITCARD_MAESTROINT_MAP;
        cardName          = "Maestro Int.";
        salesForceAgentName=TR_AGENT_QA;
        salesForceUserName = salesForceAgentName;
        salesForceSupervisorName=TR_SUPERVISOR_QA;
        setThreadSafeDriver();
        isNewhousePayment=true;
    }


    @Override

    protected void getUrlsndVerifyActuals()   {
        getUrlsAndcheckActuals();
        checkPaymenStatus("In Progress");
        sleep(5000);
        checkMappingstatus();
        checkActivationstatus();
        getEtownOrderId();
        //login as admin as only admin user can see the payment flow token field
        loginAndOpenUrl(ADMIN_QA,actualUrl);
        checkFinanceDetails();
        logger.info("Ef id :"+getEfId());        //checkActivationstatus();        //getEtownOrderId();
        setEfId(getEfId());
        detailCheckActualFields_Vtp();

    }


    @AfterTest
    protected void testAfterClass(){
        destroyDriver();
    }


}
