package com.englishlive.tests.newhouse.salesforce.account;
/**
 *
 *
 *
 * Nikol
 * Nov 2017
 */

import com.englishlive.tests.newhouse.salesforce.base.permission.BasePermissionTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class FrAgentPermissionTest extends BasePermissionTest {
    private static final Logger logger = LoggerFactory.getLogger(FrAgentPermissionTest.class);


    @BeforeTest
    public void setupAndLoginToSalesforce(){
        salesForceUserName = FRANCE_SALESAGENT_QA;
        noOfTabs = 10;
        noOfAppMenuItems = 6;
        testStartUrl = SALESFORCE_QA_URL;
        BASE_SALESFORCE_URL = testStartUrl;
        setThreadSafeDriver();
        openSalesForceAndlogin(salesForceUserName, SALESFORCE_PASS);
    }


    @AfterTest
    protected void testAfterClass(){
        destroyDriver();
    }

}
