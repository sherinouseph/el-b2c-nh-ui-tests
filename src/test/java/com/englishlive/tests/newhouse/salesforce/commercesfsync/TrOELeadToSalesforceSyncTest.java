package com.englishlive.tests.newhouse.salesforce.commercesfsync;
/**
 * Sherin - 19/09/2018
 * TR open OE landing page and after submission check if lead is present in salesforce
 */

import com.englishlive.tests.newhouse.salesforce.base.BaseCommerceSFSync.BaseOELandingPageToSalesforceTest;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static com.englishtown.tests.core.EfConstants.deOeFormMap;
import static com.englishtown.tests.core.EfConstants.esOeFormMap;
import static com.englishtown.tests.core.EfConstants.trOeToSFFormMap;

public class TrOELeadToSalesforceSyncTest extends BaseOELandingPageToSalesforceTest {
    private static final Logger logger = LoggerFactory.getLogger(TrOELeadToSalesforceSyncTest.class);




    @BeforeTest
    public void setup(){
        isStoreData = true;
       // SALESFORCE_ENV="Live";
        leadRecordType = "Turkey";
        market=leadRecordType+"..OE Lead to SF";//this data is used just to log the username to qa_users.log
        isNewhousePayment=true;
       // oeLandingPageUrl="https://qa-englishlive.ef.com/es-es/lp/oe/form-testing2";
        testStartUrl = oeLandingPageUrl;
        salesForceAgentName=TR_AGENT_QA;
        if(SALESFORCE_ENV=="Live")
            testStartUrl= StringUtils.replace(oeLandingPageUrl,"qa-","");
        salesForceUserName = salesForceAgentName;
        setThreadSafeDriver();
        formDataMap=trOeToSFFormMap;//trOeToSFFormMap;
        leadType="Online Enquiry";
    }


    @AfterTest
    protected void testAfterClass(){
        destroyDriver();
    }



}
