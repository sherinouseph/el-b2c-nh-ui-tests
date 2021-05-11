package com.englishlive.tests.newhouse.salesforce.renewal;
/**
 * MX renewal flow
 *Sherin - 27/11/2017
 *
 *
 *
 */

import com.englishlive.tests.newhouse.salesforce.base.renewal.BaseRenewalPCITest;
import com.englishtown.enumpack.PaymentProviderName;
import com.englishtown.newhouse.salesforce.pages.core.SalesForceConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class MxRenewalTest extends BaseRenewalPCITest{
    private static final Logger logger = LoggerFactory.getLogger(MxRenewalTest.class);


    @BeforeTest
    public void setup(){
        leadRecordType = "Mexico";
        testStartUrl = SALESFORCE_QA_URL;
        //paymentFrameId = 2;
        productName       = "TEST New Payment";
        paymentProviderName = PaymentProviderName.CYBERSOURCE;
        leadMapData       = SalesForceConstants.LEAD_MAP_PCI;
        creditCardMapData = SalesForceConstants.CREDITCARD_MASTERCARD_MAP;
        paymentSchedule   = "Installments-Manual-No Deposit";
        cardName          = "Mastercard";
        isPCI             =true;
        salesForceAgentName      =MX_SUPERVISOR_QA;
        salesForceUserName        = salesForceAgentName;
        salesForceSupervisorName  =ADMIN_QA;
        setThreadSafeDriver();
    }

    @Override
    protected void clickOnTakePaymentTest() {
        oppoUrl=getWebDriver().getCurrentUrl();
        openCurrentOpportunityPageUrl(salesForceAgentName);
        clickOnTakePayment();
    }
    @AfterTest
    protected void testAfterClass(){
        destroyDriver();
    }




}
