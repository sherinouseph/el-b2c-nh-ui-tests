package com.englishlive.tests.newhouse.salesforce.commercesfsync;
/**
 * Sherin - 08/01/2019
 * Create member, complete payment and update phone number via API  and after submission check if lead is present in salesforce
 */

import com.englishlive.tests.newhouse.salesforce.base.BaseCommerceSFSync.BaseCSLeadToSalesforceTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class TrCSLeadToSalesforceSyncTest extends BaseCSLeadToSalesforceTest {
    private static final Logger logger = LoggerFactory.getLogger(TrCSLeadToSalesforceSyncTest.class);


    @BeforeTest
    public void setup() {
        setLanguageAndMarket("tr", "tr");
        isNewhousePayment = true;
        salesForceAgentName = TR_AGENT_QA;
        salesForceUserName = salesForceAgentName;
        leadType="Current Students";

    }
    @AfterTest
    protected void testAfterClass(){
        destroyDriver();
    }



}
