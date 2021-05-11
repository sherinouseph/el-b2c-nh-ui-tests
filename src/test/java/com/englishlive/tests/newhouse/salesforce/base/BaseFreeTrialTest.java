package com.englishlive.tests.newhouse.salesforce.base;
/**
 * sherin- 10/11/2017
 * renewal test - click on account,add new oppo-enter details-take payment-verify actuals created and check the sales type
 */


import com.englishlive.tests.newhouse.salesforce.base.paymentflow.BaseCreditCardTest;
import com.englishtown.helpers.JavaScriptHelper;
import com.englishtown.newhouse.salesforce.pages.ActualSalesForcePage;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public abstract class BaseFreeTrialTest extends BaseCreditCardTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseFreeTrialTest.class);

    public String amountCollected;


    @Test(dependsOnMethods = "getUrlsndVerifyActuals")
    public void getNoOfInstallmentsInActuals(){
        logger.info("getNoOfInstallgetNoOfInstallmentsInActualsments");
        getNoOfInstallments();
        logger.info("Number of installments "+noOfInstallments);

    }

    @Test(dependsOnMethods = "getNoOfInstallmentsInActuals")
    public void assertTotalNumberOfPaymentRecords(){
        logger.info("assertTotalNumberOfPaymentRecords");
        JavaScriptHelper.scrollToXY(getWebDriver(),0,3000);
        getNoOfPaymentRecords();
        if(noOfPaymentRecords==noOfInstallments)//this is a free trial product and no of payment record= no of normal insta+free trial product
            logger.info("This is a free trial product and the no of payment records are correct");
        else
            failTest("No of payment records are incorrect");

    }

    @Test(dependsOnMethods = "assertTotalNumberOfPaymentRecords")
    public void checkAmountcollectedOfFirstPaymentRecord(){
        logger.info("checkAmountcollectedOfFirstPaymentRecord");
        amountCollected=getAmountCollected(0);
        logger.info("Amount collected is "+amountCollected);
        if(StringUtils.equalsIgnoreCase(amountCollected,"0.00"))
            logger.info("Amount collected is 0 for the free trial product..This is correct");
        else
            logger.info("Amount collected incorrect");

    }







}
