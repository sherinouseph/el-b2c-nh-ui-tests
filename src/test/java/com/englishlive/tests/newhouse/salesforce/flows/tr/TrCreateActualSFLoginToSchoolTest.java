package com.englishlive.tests.newhouse.salesforce.flows.tr;
/**
 * Sherin - 17/09/2018
 * Login to sales force
 * Create the actuals through Bank Transfer and loginto school - newhouse
 */

import com.englishlive.tests.newhouse.salesforce.base.BaseLogInToSchool;
import com.englishtown.newhouse.salesforce.pages.core.SalesForceConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TrCreateActualSFLoginToSchoolTest extends BaseLogInToSchool {
    private static final Logger logger = LoggerFactory.getLogger(TrCreateActualSFLoginToSchoolTest.class);


    @BeforeTest
    public void setup(){
        isStoreData = true;
        leadRecordType = "Turkey";
        market=leadRecordType+"..Enrolled";//this data is used just to log the username to qa_users.log
        isNewhousePayment=true;
        testStartUrl = SALESFORCE_QA_URL;
        testurlSFToSchool="https://qa-englishlive.ef.com/tr-tr/login";
//        if(StringUtils.contains(testStartUrl,"login"))
//            testurlSFToSchool=StringUtils.replace(testurlSFToSchool,"qa-","");
       // paymentFrameId=0;
        productName       = "EU PT 52 12m";
        testStartUrl      = SALESFORCE_QA_URL;
        paymentMethod     = "Bank Transfer";
        leadMapData       = SalesForceConstants.LEAD_MAP;
        setThreadSafeDriver();
        salesForceAgentName=TR_AGENT_QA;
        salesForceSupervisorName=TR_SUPERVISOR_QA;
        salesForceUserName = salesForceAgentName;
        isNewHouseEnroll=true;
    }

   @Override
   protected void clickOnTakePaymentTest() {
        oppoUrl=getWebDriver().getCurrentUrl();
        openSalesForceAndlogin(salesForceSupervisorName,SALESFORCE_PASS);
        openUrl(getWebDriver(),oppoUrl);
        clickOnTakePayment();
  }
    @AfterTest
    protected void testAfterClass(){
        destroyDriver();
    }



}
