package com.englishlive.tests.newhouse.salesforce.flows.fr;
/**
 * Sherin - 16/03/2018
 * Login to sales force
 * Create the actuals through Bank Transfer and loginto school
 */

import com.englishlive.tests.newhouse.salesforce.base.BaseLogInToSchool;
import com.englishlive.tests.newhouse.salesforce.base.paymentflow.BaseBankTransferTest;
import com.englishtown.helpers.reader.ReadWriteToFile;
import com.englishtown.newhouse.salesforce.pages.core.SalesForceConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class FRLoginToSchoolTest extends BaseLogInToSchool {
    private static final Logger logger = LoggerFactory.getLogger(FRLoginToSchoolTest.class);
    @Value("#{applicationPropertiesList['fr.fr.login.url']}")
    public String testurlSFToSchool;


    @BeforeTest
    public void setup(){
        isStoreData = true;
        leadRecordType = "France";
        market=leadRecordType+"..Enrolled";//this data is used just to log the username to qa_users.log
        isStoreData = true;
        isAddQuality=true;
        testStartUrl = SALESFORCE_QA_URL;
       // paymentFrameId=0;
        productName       = "EU PT 52 12m";
        testStartUrl      = SALESFORCE_QA_URL;
        paymentMethod     = "Bank Transfer";
        leadMapData       = SalesForceConstants.LEAD_MAP;
        setThreadSafeDriver();
        salesForceAgentName=FRANCE_SALESAGENT_QA;
        salesForceSupervisorName=FRANCE_SUPERVISOR_QA;
        salesForceUserName = salesForceAgentName;
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
