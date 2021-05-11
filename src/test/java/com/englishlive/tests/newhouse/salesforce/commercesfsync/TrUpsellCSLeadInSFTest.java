package com.englishlive.tests.newhouse.salesforce.commercesfsync;
/**
 * Sherin - 08/01/2019
 * Create member, complete payment and update phone number via API  and after submission check if lead is present in salesforce
 *
 * Niko Notes : TODO ... destroy open windows .. cant find paymentflowtockenwe in qa
 */

import com.englishlive.tests.newhouse.salesforce.base.BaseCommerceSFSync.BaseUpsellCSLeadInSFTest;
import com.englishtown.dataprovider.bin.StudentBean;
import com.englishtown.newhouse.apicore.StaticBaseApiSpec;
import com.englishtown.newhouse.salesforce.pages.core.SalesForceConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TrUpsellCSLeadInSFTest extends BaseUpsellCSLeadInSFTest {
    private static final Logger logger = LoggerFactory.getLogger(TrUpsellCSLeadInSFTest.class);


    @BeforeTest
    public void setup() {
        setLanguageAndMarket("tr", "tr");
        leadRecordType = "Turkey";
        testStartUrl = SALESFORCE_QA_URL;
        isNewhousePayment=true;
        productName       = "TEST New Payment";
        //paymentFrameId=2;
        testStartUrl      = SALESFORCE_QA_URL;
        leadMapData       = SalesForceConstants.LEAD_MAP;
        creditCardMapData = SalesForceConstants.CREDITCARD_DISCOVER_MAP;
        cardName          = "Visa";
        salesForceAgentName=TR_SUPERVISOR_QA;
        salesForceUserName = salesForceAgentName;
        leadType="Current Students";
        leadOwner="B2C Auto Turkey Supervisor";



    }
    @AfterTest
    protected void testAfterClass(){
        destroyDriver();
    }



    @Override
    public void createLead(){
        logger.info("NO Lead creation is needed in salesforce as it uses the CS lead from OS, lead email is "+leadEmail);
        verifyLeadType(leadType);
        setLeadStatusInLeadPageAndSave(leadEmail,"Set Appt");
        setLeadOwner(leadOwner,leadRecordType);
        sleep(2000);
    }

    @Override
    public void openSalesForceAndlogin(String salesForceUserName, String password){
        logger.info("Create a CS Lead through API and open SALESFORCE");
      //create lead and open salesforce
        StudentBean studentBean = StaticBaseApiSpec.createUserNoEnrol("qa",true,"0905685865",market,language);
        leadEmail=studentBean.getUserEmail();
        setThreadSafeDriver();
        openSalesForceAndlogin(getSalesforceBase_URL(),salesForceAgentName, SALESFORCE_PASS);
        sleep(20000);
        //search for the lead in salesforce
        logger.info("Searching for lead "+leadEmail+" in salesforce");
        openUrl(getWebDriver(),getSearchByEmailurl(leadEmail));

    }






}
