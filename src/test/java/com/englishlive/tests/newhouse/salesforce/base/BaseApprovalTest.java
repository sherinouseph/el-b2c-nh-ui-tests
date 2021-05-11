package com.englishlive.tests.newhouse.salesforce.base;
/**
 * Approve the product as super Admin
 * Check if the oppo stage value is Opportunity approved
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public abstract class BaseApprovalTest extends BaseAddProductTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseApprovalTest.class);


    @Test(dependsOnMethods = "verifyProductTest")
    protected void approveProductAsSupperAdminTest(){
        if(salesForceUserName == ADMIN_QA)
        approveProductAsSupperAdmin();
        else
        approveProductAsSupervisor();
        opportunityStageCheck(opportunityStageApproved);
    }


}
