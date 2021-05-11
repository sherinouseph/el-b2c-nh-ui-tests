package com.englishlive.tests.newhouse.salesforce.flows.De;
/**
 * Sherin - 06/11/2017
 * Login to sales force
 *Derenewal test is already doing the payment using discover.so no need to run this separately
  **/

import com.englishlive.tests.newhouse.salesforce.base.BaseChargeNowTest;
import com.englishlive.tests.newhouse.salesforce.base.paymentflow.BaseCreditCardTest;
import com.englishtown.newhouse.salesforce.pages.core.SalesForceConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DeDiscoverTest extends BaseCreditCardTest {
    private static final Logger logger = LoggerFactory.getLogger(DeDiscoverTest.class);


    @BeforeTest
    public void setup(){
        leadRecordType = "Germany";
        testStartUrl = SALESFORCE_QA_URL;
        productName       = "TEST New Payment";
        isAddQuality=true;
        //paymentFrameId=2;
        testStartUrl      = SALESFORCE_QA_URL;
        leadMapData       = SalesForceConstants.LEAD_MAP;
        creditCardMapData = SalesForceConstants.CREDITCARD_DISCOVER_MAP;
        cardName          = "Discover";
        salesForceAgentName=GERMANY_SUPERVISOR_QA;
        salesForceUserName = salesForceAgentName;
        salesForceSupervisorName=GERMANY_SUPERVISOR_QA;
        setThreadSafeDriver();
    }



    @AfterTest
    protected void testAfterClass(){
        destroyDriver();
    }


}
