package com.englishlive.tests.newhouse.salesforce.recurring;
/**
 *Sherin - 01/12/2017
 * Italy recurring
 */

import com.englishlive.tests.newhouse.salesforce.base.recurring.BaseRecurringTest;
import com.englishtown.newhouse.salesforce.pages.core.SalesForceConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class FrRecurringTest extends BaseRecurringTest {
    private static final Logger logger = LoggerFactory.getLogger(FrRecurringTest.class);


    @BeforeTest
    public void setup(){
        leadRecordType = "France";
        isChargeNowShowAlertTwice = true;
        testStartUrl = SALESFORCE_QA_URL;
        productName       = "EU PT 4 1m Recurring";
        //paymentFrameId=2;
        testStartUrl      = SALESFORCE_QA_URL;
        leadMapData       = SalesForceConstants.LEAD_MAP;
        creditCardMapData = SalesForceConstants.CREDITCARD_VISA_MAP;
        cardName          = "Visa";
        salesForceAgentName=FRANCE_SALESAGENT_QA;
        salesForceUserName = salesForceAgentName;
        salesForceSupervisorName=FRANCE_SUPERVISOR_QA;
        isAddQuality=true;
        setThreadSafeDriver();
    }


    @AfterTest
    protected void testAfterClass(){
        destroyDriver();
    }


}
