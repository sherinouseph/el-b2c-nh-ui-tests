package com.englishlive.tests.newhouse.salesforce.retention.fr;
/**
 * Sherin - 07/11/2017
 * Test flow-Extend->Suspend->cancel Suspend->suspend->resume->cancel
 */

import com.englishlive.tests.newhouse.salesforce.base.retention.BaseRetentionCreditCardVtpTest;
import com.englishtown.newhouse.salesforce.enumpack.RetentionRecordType;
import com.englishtown.newhouse.salesforce.enumpack.RetentionStatus;
import com.englishtown.newhouse.salesforce.pages.core.SalesForceConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class FrVisaExtendSuspendAndCancelTest extends BaseRetentionCreditCardVtpTest {
    private static final Logger logger = LoggerFactory.getLogger(FrVisaExtendSuspendAndCancelTest.class);


    @BeforeTest
    public void setup(){
        leadRecordType = "France";
        testStartUrl   = SALESFORCE_QA_URL;
        productName       = "TEST New Payment";
        leadMapData       = SalesForceConstants.LEAD_MAP;
        creditCardMapData = SalesForceConstants.CREDITCARD_VISA_MAP;
        cardName          = "Visa";
        opportunityStageValueWeCss ="#opp11_ileinner";
        retentionRecordType= RetentionRecordType.EUROPE.getRetentionRecordType();
       // retentionType= RetentionType.CANCELLATION.getRetentionType();
        retentionStatus= RetentionStatus.NOTRETAINED.getRetentionStatus();
        retentionOwner=ADMIN_QA_USERNAME;
        salesForceAgentName = FRANCE_SALESAGENT_QA;
        salesForceUserName  = salesForceAgentName;
        salesForceSupervisorName=ADMIN_QA;
        isAddQuality=true;
        setThreadSafeDriver();
    }

    @AfterTest
    protected void testAfterClass(){

        destroyDriver();
    }


}
