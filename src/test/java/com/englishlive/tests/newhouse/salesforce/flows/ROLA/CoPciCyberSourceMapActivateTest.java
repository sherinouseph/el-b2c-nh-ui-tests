package com.englishlive.tests.newhouse.salesforce.flows.ROLA;
/**
 *
 *Sherin - 07/11/2017
 * Create the actuals through Credit card WorldPay Visa
 *
 */

import com.englishlive.tests.newhouse.salesforce.base.BaseMapStudentTest;
import com.englishtown.enumpack.PaymentProviderName;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.newhouse.salesforce.pages.AddProductPCI;
import com.englishtown.newhouse.salesforce.pages.core.SalesForceConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class CoPciCyberSourceMapActivateTest extends BaseMapStudentTest{
    private static final Logger logger = LoggerFactory.getLogger(CoPciCyberSourceMapActivateTest.class);


    @BeforeTest
    public void setup(){
        isStoreData=true;
        leadRecordType = "Rola";
        leadCountry       ="Columbia";
        market=leadRecordType+"_"+leadCountry+"..Not Enrolled";//this data is used just to log the username to qa_users.log
        testStartUrl = SALESFORCE_QA_URL;
        //paymentFrameId = 0;
        productName       = "TEST New Payment";
        paymentProviderName = PaymentProviderName.CYBERSOURCE;
        testStartUrl      = SALESFORCE_QA_URL;
        leadMapData         = SalesForceConstants.LEAD_MAP_PCI;
        creditCardMapData = SalesForceConstants.CREDITCARD_VISA_MAP;
        paymentSchedule   = "Installments-Manual-No Deposit";
        cardName          = "Visa";
        isPCI             =true;
        salesForceAgentName      =ROLA_SUPERVISOR_QA;
        salesForceUserName        = salesForceAgentName;
        salesForceSupervisorName  =ADMIN_QA;
        setThreadSafeDriver();
    }

    @Override
    protected void selectProductPCI(){
        addProductPCI = new AddProductPCI(getWebDriver(), SALESFORCE_WAIT_MED);
        addProductPCI.addProduct(getWebDriver(), productName, paymentMethod, paymentSchedule, discount, numberOfInstallments);
        WebElementHelper.sendKeys(getWebDriver(),addProductPCI.currencyWe,"COD",true);
        addProductPCI.clickNext();
        addProductPCI = new AddProductPCI(getWebDriver(), SALESFORCE_WAIT_MED);
        addProductPCI.clickAddBtn();

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
