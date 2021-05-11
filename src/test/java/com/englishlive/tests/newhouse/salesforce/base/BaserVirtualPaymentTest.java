package com.englishlive.tests.newhouse.salesforce.base;
/**
 * Login to sales force
 */

import com.englishtown.newhouse.salesforce.pages.core.SalesForceConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public abstract class BaserVirtualPaymentTest extends BaseSalesforceTest{
    private static final Logger logger = LoggerFactory.getLogger(BaserVirtualPaymentTest.class);


    @Test
    protected void login(){
        openSalesForceAndlogin(ADMIN_QA, SALESFORCE_PASS);
    }

    // Create lead as Super Admin
    @Test(dependsOnMethods = "login")
    protected void createNewLeadTest(){
        createLead();

    }
    //convert Lead to Opportunity
    @Test(dependsOnMethods = "createNewLeadTest")
    protected void convertToOpportunityTest(){
        convertLeadToOpportunity();
    }

    //check if the Opportunity is created
    @Test(dependsOnMethods = "convertToOpportunityTest")
    protected void checkOpportunityPageTest(){
        checkOpportunityPage();
    }

    @Test(dependsOnMethods = "checkOpportunityPageTest")
    protected void addProductTest(){
        clickAddProductBtn();
        selectProductVTP();
    }

    @Test(dependsOnMethods = "addProductTest")
    protected void verifyProductTest(){
       verifyProduct();
    }

    @Test(dependsOnMethods = "verifyProductTest")
    protected void clickOnTakePaymentTest() {
        clickOnTakePayment();
        switchToPaymentIFrame();
    }

    @Test(dependsOnMethods = "clickOnTakePaymentTest")
    protected void enterPaymentDetailsAndPay(){
        enterPaymentDetails(creditCardMapData, cardName);
        clickPayAndClose();
    }

    @Test(dependsOnMethods = "enterPaymentDetailsAndPay")
    protected void checkStageValue(){
        opportunityStageCheck(opportunityStageWon);
    }


}
