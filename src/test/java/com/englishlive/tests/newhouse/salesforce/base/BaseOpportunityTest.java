package com.englishlive.tests.newhouse.salesforce.base;
/**
 * Convert lead to opportunity
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public abstract class BaseOpportunityTest extends BaseCreateLeadTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseOpportunityTest.class);


    @Test(dependsOnMethods = "createNewLead")
    protected void convertToOpportunity(){
        convertLeadToOpportunity();
        if(isAddQuality)
            addQualityAndSaveOppo();
    }

    //check if the Opportunity is created
    @Test(dependsOnMethods = "convertToOpportunity")
    protected void checkOpportunityPageTest(){

        checkOpportunityPage();
    }


}
