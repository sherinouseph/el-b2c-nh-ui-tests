package com.englishlive.tests.newhouse.salesforce.flows.mx;
/**
 * Sherin - 06/11/2017
 * Create the Actuals through PayU
 */


import com.englishlive.tests.newhouse.salesforce.base.paymentflow.BasePayUPCITest;
import com.englishtown.enumpack.PaymentProviderName;
import com.englishtown.newhouse.salesforce.pages.core.SalesForceConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class MxPayUVisaTest extends BasePayUPCITest{
    private static final Logger logger = LoggerFactory.getLogger(MxPayUVisaTest.class);


    @BeforeTest
    public void setup(){
        leadRecordType       = "Mexico";
        testStartUrl          = SALESFORCE_QA_URL;
       // paymentFrameId = 2;
        productName           = "MX Private 24PL.12 Month";
        paymentProviderName    = PaymentProviderName.PAYU;
        testStartUrl            = SALESFORCE_QA_URL;
        leadMapData             = SalesForceConstants.LEAD_MAP_PCI;
        paymentMapData          = SalesForceConstants.PAYU_MAP;
        paymentSchedule         = "Installments-Manual-No Deposit";
        isPCI                   =true;
        salesForceAgentName      =MX_SALESAGENT_QA;//stefano to create mexico user password.after that i will use the real mexico agent
        salesForceUserName        = salesForceAgentName;
        salesForceSupervisorName  =MX_SUPERVISOR_QA;
        setThreadSafeDriver();
    }

    @Override

    protected void verifyActuals() {
        getUrlsAndcheckActuals();
        checkFinanceDetails();
    }

    @AfterTest
    protected void testAfterClass(){
        destroyDriver();
    }




}
