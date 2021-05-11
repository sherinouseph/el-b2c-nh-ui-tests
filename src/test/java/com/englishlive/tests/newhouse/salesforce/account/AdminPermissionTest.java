package com.englishlive.tests.newhouse.salesforce.account;
/**
 *
 * Nikol
 * Nov 2017
 *
 *
 *
 */

import com.englishlive.tests.newhouse.salesforce.base.BaseSalesforceTest;
import com.englishlive.tests.newhouse.salesforce.base.permission.BasePermissionTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AdminPermissionTest extends BasePermissionTest {
    private static final Logger logger = LoggerFactory.getLogger(AdminPermissionTest.class);


    @BeforeTest
    public void setupAndLoginToSalesforce(){
        salesForceUserName = ADMIN_QA;  //"sherin.ouseph@ef.com.qa";
        noOfTabs = 10;
        noOfAppMenuItems = 10;
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
