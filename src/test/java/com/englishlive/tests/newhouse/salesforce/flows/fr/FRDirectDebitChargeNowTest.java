package com.englishlive.tests.newhouse.salesforce.flows.fr;
/**
 * Sherin - 06/11/2017
 * Login to sales force
 * Create the actuals through Direct Debit
 * */


import com.englishlive.tests.newhouse.salesforce.base.paymentflow.BaseDirectDebitTest;
import com.englishtown.newhouse.salesforce.pages.core.SalesForceConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class FRDirectDebitChargeNowTest extends BaseDirectDebitTest {
    private static final Logger logger = LoggerFactory.getLogger(FRDirectDebitChargeNowTest.class);


    @BeforeTest
    public void setup(){
        leadRecordType = "France";
        testStartUrl = SALESFORCE_QA_URL;
        productName       = "TEST New Payment";
        paymentMethod     = "Direct Debit";
        //paymentFrameId    = 0;
        leadMapData       = SalesForceConstants.LEAD_MAP;
        paymentMapData       = SalesForceConstants.DIRECTDEBIT_MAP_FR;
        salesForceAgentName=FRANCE_SALESAGENT_QA;
        salesForceUserName = salesForceAgentName;
        salesForceSupervisorName=FRANCE_SUPERVISOR_QA;
        isChargeNowShowAlertTwice=true;
        isAddQuality=true;
        setThreadSafeDriver();
    }


    @AfterTest
    protected void testAfterClass(){
        destroyDriver();
    }


}
