package com.englishlive.tests.newhouse.salesforce.commercesfsync;
/**
 * Sherin - 15/01/2018
 * TR open OS landing page(enter telphone number)/submit form/finish payment/after submission of the payment form check if lead is present in salesforce
 */

import com.englishlive.tests.newhouse.salesforce.base.BaseCommerceSFSync.BaseCSLeadToSalesforceTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static com.englishtown.tests.core.EfConstants.trOsFormMap;

public class Tr_OSLPToSalesforceSyncTest extends BaseCSLeadToSalesforceTest {
    private static final Logger logger = LoggerFactory.getLogger(Tr_OSLPToSalesforceSyncTest.class);


    @BeforeTest
    public void setup(){
        isStoreData = true;
        leadRecordType = "Turkey";
        market=leadRecordType+"..OS Lead to SF";//this data is used just to log the username to qa_users.log
        isNewhousePayment=true;
        testStartUrl = osLandingPageUrl;
        salesForceAgentName=TR_AGENT_QA;
        salesForceUserName = salesForceAgentName;
        //setThreadSafeDriver();
        formDataMap=trOsFormMap;
        leadType="Current Students";
        ifLeadFromOSLP=true;
        isNewhouseTyPage = true;
        isNewhousePayment  = true;
        paymentSubmitBtnCss=".btn.btn-primary";

    }


    @AfterTest
    protected void testAfterClass(){
        destroyDriver();
    }



}
