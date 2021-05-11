package com.englishlive.tests.newhouse.salesforce.flows.Italy;
/**
 * Sherin - 05/11/2017
 * Login to sales force
 * Create the actuals through CreditCard
 */

import com.englishlive.tests.newhouse.salesforce.base.BaseFreeTrialTest;
import com.englishtown.newhouse.salesforce.pages.core.SalesForceConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class ItfreetrialTest extends BaseFreeTrialTest {
    private static final Logger logger = LoggerFactory.getLogger(ItfreetrialTest.class);


    @BeforeTest
    public void setup(){
        leadRecordType = "Italy";
        testStartUrl = SALESFORCE_QA_URL;
        productName       = "TEST New Payment - free trial";
        testStartUrl      = SALESFORCE_QA_URL;
        leadMapData       = SalesForceConstants.LEAD_MAP;
        creditCardMapData = SalesForceConstants.CREDITCARD_VISA_MAP;
        cardName          = "Visa";
        isAddQuality=true;
        salesForceAgentName=ITALY_SALESAGENT_QA;
        salesForceUserName = salesForceAgentName;
        setThreadSafeDriver();
        salesForceSupervisorName=ITALY_SUPERVISOR_QA;
    }
   @Override
   protected void getUrlsndVerifyActuals()   {
    getUrlsAndcheckActuals();


}

    @AfterTest
    protected void testAfterClass(){
        destroyDriver();
    }


}
