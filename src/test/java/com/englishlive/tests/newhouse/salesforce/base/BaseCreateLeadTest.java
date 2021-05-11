package com.englishlive.tests.newhouse.salesforce.base;
/**
 * Fill the New Lead form
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public abstract class BaseCreateLeadTest extends BaseLoginTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseCreateLeadTest.class);
    public String leadOwner;


    @Test(dependsOnMethods = "login")
    protected void createNewLead(){
      createLead();
        userEmail=leadEmail;

    }


    @AfterTest
    protected void testAfterClass(){
        destroyDriver();
    }


}
