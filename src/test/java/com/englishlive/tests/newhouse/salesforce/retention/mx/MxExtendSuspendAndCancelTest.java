package com.englishlive.tests.newhouse.salesforce.retention.mx;
/**
 * Sherin - 07/11/2017
 * MxExtendSuspendAndCancelTest
 * Test flow-Extend->Suspend->cancel Suspend->suspend->resume->cancel
 */

import com.englishlive.tests.newhouse.salesforce.base.retention.BaseRetentionCyberSourcePCITest;
import com.englishtown.enumpack.PaymentProviderName;
import com.englishtown.newhouse.salesforce.enumpack.RetentionRecordType;
import com.englishtown.newhouse.salesforce.enumpack.RetentionStatus;
import com.englishtown.newhouse.salesforce.pages.RetentionPage;
import com.englishtown.newhouse.salesforce.pages.core.SalesForceConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class MxExtendSuspendAndCancelTest extends BaseRetentionCyberSourcePCITest {
    private static final Logger logger = LoggerFactory.getLogger(MxExtendSuspendAndCancelTest.class);


    @BeforeTest
    public void setup(){
        leadRecordType = "Mexico";
        isPCI=true;
        testStartUrl = SALESFORCE_QA_URL;
        //paymentFrameId = 2;
        productName       = "TEST New Payment";
        paymentProviderName = PaymentProviderName.CYBERSOURCE;
        testStartUrl      = SALESFORCE_QA_URL;
        leadMapData       = SalesForceConstants.LEAD_MAP_PCI;
        creditCardMapData = SalesForceConstants.CREDITCARD_VISA_MAP;
        paymentSchedule   = "Installments-Manual-No Deposit";
        cardName          = "Visa";
        retentionRecordType= RetentionRecordType.MEXICO.getRetentionRecordType();
       // retentionType= RetentionType.SUSPEND.getRetentionType();
        retentionStatus= RetentionStatus.PENDINGAPPROVAL.getRetentionStatus();
        retentionOwner="Evan Mexico";
        salesForceAgentName = MX_SUPERVISOR_QA;
        RetentionPage.isEnterInfoForPayment=false;
        salesForceUserName  = salesForceAgentName;
        salesForceSupervisorName=ADMIN_QA;
        salesForceFinanceManager=MX_FINANCE_MANAGER_QA;
        setThreadSafeDriver();
    }

    @Override
    protected void clickOnTakePaymentTest() {
        oppoUrl = getWebDriver().getCurrentUrl();
        openCurrentOpportunityPageUrl(salesForceAgentName);
        clickOnTakePayment();
    }
    @AfterTest
    protected void testAfterClass(){

        destroyDriver();
    }


}
