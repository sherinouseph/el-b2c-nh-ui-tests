package com.englishlive.tests.newhouse.salesforce.flows;//package com.englishlive.tests.newhouse.salesforce.flows.Tw;
///**
// * Create the Actuals through CreditCard-Visa
// */twretention test already covering the visa test.so no need to run this
//
import com.englishlive.tests.newhouse.salesforce.base.paymentflow.BaseCreditCardTest;
import com.englishtown.newhouse.salesforce.pages.core.SalesForceConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TRVisaTest extends BaseCreditCardTest {
    private static final Logger logger = LoggerFactory.getLogger(TRVisaTest.class);


    @BeforeTest
    public void setup(){
        leadRecordType = "Turkey";
        testStartUrl = SALESFORCE_QA_URL;
        productName       = "EU PT 52 12m";
        testStartUrl      = SALESFORCE_QA_URL;
        leadMapData       = SalesForceConstants.TW_LEAD_MAP;
        creditCardMapData = SalesForceConstants.CREDITCARD_VISA_MAP;
        cardName          = "Visa";
        opportunityStageValueWeCss ="#opp11_ileinner";
        salesForceAgentName = TR_AGENT_QA;
        isNewhousePayment=true;
        salesForceUserName = salesForceAgentName;
        salesForceSupervisorName=TR_SUPERVISOR_QA;
        setThreadSafeDriver();
    }

    @Override
    protected void verifyProductTest(){
        logger.info("Product is not expected to be present in the oppo Page");
    }

    @Override
    protected void getUrlsndVerifyActuals()   {
        logger.info("getUrlsndVerifyActuals");
        getUrlsAndcheckActuals();

//        checkPaymenStatus("In Progress");
//        sleep(2000);
//        checkMappingstatus();
//        if(isNewhousePayment){
//            logger.info("Ef id :" + getEfId());        //checkActivationstatus();        //getEtownOrderId();
//            setEfId(getEfId());
//        }else {
//            logger.info("Member id :" + getMemberId());        //checkActivationstatus();        //getEtownOrderId();
//            setUserMemberId(getMemberId());
//        }
//        checkActivationstatus();
//        getEtownOrderId();
//        //login as admin as only admin user can see the payment flow token field
//        loginAndOpenUrl(ADMIN_QA,actualUrl);
//        checkFinanceDetails();
    }



    @AfterTest
    protected void testAfterClass(){
        destroyDriver();
    }


}
