package com.englishlive.tests.newhouse.salesforce.base;
/**
 * Mx PCI flow visa
 *
 * Nikol  2
 *
 */

import com.englishtown.newhouse.salesforce.pages.core.SalesForceConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public abstract class BasePciTest extends BaseSalesforceTest{
    private static final Logger logger = LoggerFactory.getLogger(BasePciTest.class);



    @Test
    protected void login(){
        openSalesForceAndlogin(salesForceUserName, SALESFORCE_PASS);
    }

    // Create lead as Super Admin
    @Test(dependsOnMethods = "login")
    protected void createNewLeadTest(){
        createLead();
    }

    @Test(dependsOnMethods = "createNewLeadTest")
    protected void convertToOpportuniyTest(){
        convertLeadToOpportunity();
    }

    //check if the Opportunity is created
    @Test(dependsOnMethods = "convertToOpportuniyTest")
    protected void checkOpportunityPageTest(){
        checkOpportunityPage();
    }

    @Test(dependsOnMethods = "checkOpportunityPageTest")
    protected void addProductTest(){
        clickAddProductPCIBtn();
        selectProductPCI();
    }

    @Test(dependsOnMethods = "addProductTest")
    protected void verifyProductTest(){
        verifyProduct();
    }

    @Test(dependsOnMethods = "verifyProductTest")
    protected void approveProductAsSupperAdminTest(){
        approveProductAsSupperAdmin();
        opportunityStageCheck(opportunityStageApproved);
    }

    @Test(dependsOnMethods = "approveProductAsSupperAdminTest")
    protected void clickOnTakePaymentTest() {
        clickOnTakePayment();
    }

    @Test(dependsOnMethods = "clickOnTakePaymentTest")
    protected void selectPaymentProviderAndContinueTest() {
        selectPaymentProviderAndContinue(paymentProviderName.getPayProviderName());
    }

    @Test(dependsOnMethods = "selectPaymentProviderAndContinueTest")
    protected void enterPaymentDetailsAndPay(){
        switchToPaymentIFrame();
        enterPaymentDetails(SalesForceConstants.CREDITCARD_VISA_MAP, cardName);
        clickPayAndClose();
    }

    @Test(dependsOnMethods = "enterPaymentDetailsAndPay")
    protected void checkOpportunityWon(){
        opportunityStageCheck(opportunityStageWon);
    }


}

