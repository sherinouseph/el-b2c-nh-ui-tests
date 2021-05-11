package com.englishlive.tests.newhouse.salesforce.base;
/**
 * Sherin - 06/11/2017
 * Check if the payment frames are shown for worldpay,payu and cybersource
 */


import com.englishtown.enumpack.PaymentProviderName;
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.newhouse.salesforce.pages.PaymentSalesForcePage;
import com.englishtown.newhouse.salesforce.pages.core.SalesForceConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public abstract class BasePciLivePaymentTest extends BaseApprovalTest{
    private static final Logger logger = LoggerFactory.getLogger(BasePciLivePaymentTest.class);


    @Test(dependsOnMethods = "approveProductAsSupperAdminTest")
    protected void clickOnTakePaymentTest() {
        oppoUrl=getWebDriver().getCurrentUrl();
        openCurrentOpportunityPageUrl(salesForceAgentName);
        clickOnTakePayment();
    }
    @Test(dependsOnMethods = "clickOnTakePaymentTest")
    protected void selectPaymentProvidersAndVerify() {
        selectPaymentProviderAndContinue(paymentProviderName.getPayProviderName());
        verifyPAYULiveTestCard();
        paymentFrameId=2;
        paymentProviderName=PaymentProviderName.CYBERSOURCE;
        creditCardMapData = SalesForceConstants.CREDITCARD_VISA_MAP;
        cardName          = "Visa";
        clickOnTakePayment();
        selectPaymentProviderAndContinue(paymentProviderName.getPayProviderName());
        verifyCyberSourceLiveTestCard();
        paymentProviderName=PaymentProviderName.WORLDPAY;
        paymentMapData = SalesForceConstants.WORLDPAY_VISA_MAP;
        cardName          = "Visa";
        clickOnTakePayment();
        selectPaymentProviderAndContinue(paymentProviderName.getPayProviderName());
        verifyWorldPayLiveTestCard();
    }

    protected void verifyPAYULiveTestCard() {
        switchToPaymentIFrame();
        logger.info("verify PayU Card");
        WebElement payUBtn = findElement(By.cssSelector("button[type='submit']"));
        switchToParentFrame(getWebDriver());
        click(payment.closeBtn);
        logger.info("PAYU frame displayed correctly");
    }

    protected void verifyWorldPayLiveTestCard() {
        switchToParentFrame(getWebDriver());
        switchToPaymentIFrame();
        logger.info("verifyWorldPayLiveTestCard");
       // paymentFrameId=1;
        payment = new PaymentSalesForcePage(getWebDriver(), SALESFORCE_WAIT_MED);
        payment.selectCardTypeWorldPay(TestUtil.getMapKeyValue(SalesForceConstants.WORLDPAY_CARD_TYPE_MAP, cardName));
        switchToParentFrame(getWebDriver());
        click(payment.closeBtn);
        logger.info("WORLDPAY frame displayed correctly");
    }

    protected void verifyCyberSourceLiveTestCard() {
        switchToParentFrame(getWebDriver());
        switchToPaymentIFrame();
        logger.info("verifyCyberSourceLiveTestCard");
        payment = new PaymentSalesForcePage(getWebDriver(), 20);
        sleep(2000);
        AssertHelper.assertWebElementDisplayed(payment.payBtn);
        //payment.selectCardType(TestUtil.getMapKeyValue(SalesForceConstants.CARD_TYPE_MAP, cardName));
        switchToParentFrame(getWebDriver());
        click(payment.closeBtn);
        logger.info("CyberSource frame displayed correctly");
    }

}
