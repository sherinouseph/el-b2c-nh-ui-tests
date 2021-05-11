package com.englishtown.tests.core.school.upsell;
/**
 *
 * Go to upsell page
 * add products and check upsell payment page
 * edit order and check upsell payment page
 * click on modify cc details for adyen
 * add new payment card details and buy product
 * check upsell ty page
 * User: sherin Ouseph
 * Date: 06/11/2019
 *
 *
 */
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.newhouse.school.pages.home.SchoolHomePage;
import com.englishtown.newhouse.school.pages.upsell.SchoolUpsellPage;
import com.englishtown.newhouse.school.pages.upsell.SchoolUpsellPaymentPage;
import com.englishtown.newhouse.school.pages.upsell.SchoolUpsellThankyouPage;
import com.englishtown.pages.checkout.newcheckout.CheckoutPaymentPage;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import static org.hamcrest.core.IsEqual.equalTo;


public abstract class BaseAdyenUpsellPaymentTest extends BaseUpsellTest{
    private static final Logger logger = LoggerFactory.getLogger(BaseAdyenUpsellPaymentTest.class);


    @Test(dependsOnMethods = "checkUpsellPageAllComponents")
    protected void addProduct1() {
        schoolUpsellPage.clickAddOffer(offerRowIndex);
    }

    @Test(dependsOnMethods = "checkUpsellPageAllComponents")
    protected void addProduct2() {
        schoolUpsellPage.clickAddOffer(otherOfferRowIndex);
    }

    @Test(dependsOnMethods = "addProduct2")
    protected void setPriceAndclickCheckOutNow() {
        currentTotalPrice = schoolUpsellPage.getTotalPriceDouble();
        logger.info(" currentTotalPrice ["+currentTotalPrice+"]");
        schoolUpsellPage.clickCheckoutNowBtn();
    }

    @Test(dependsOnMethods = "setPriceAndclickCheckOutNow")
    protected void checkPaymentPage() {
        schoolUpsellPaymentPage = new SchoolUpsellPaymentPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        schoolUpsellPaymentPage.checkOrderLineDisplayed(0);
        schoolUpsellPaymentPage.checkYouWillBeChargedTxtContainsPrice();
        schoolUpsellPaymentPage.initializeAdyenStoredPaymentModules();
        schoolUpsellPaymentPage.adyenStoredPaymentModule.simpleTest();
        schoolUpsellPaymentPage.adyenStoredPaymentModule.checkAllPageComponentsDisplayed();
    }

    @Test(dependsOnMethods = "checkPaymentPage")
    protected void clickEditOrder() {
        schoolUpsellPaymentPage = new SchoolUpsellPaymentPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        waitForElementCondition(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".link.edit-order")), getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        waitForElementCondition(ExpectedConditions.elementToBeClickable(By.cssSelector(".link.edit-order")), getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        sleep(2000);
        schoolUpsellPaymentPage.clickEditOrder();
    }

    @Test(dependsOnMethods = "clickEditOrder")
    protected void addProductsAgainClickCheckout() {
        schoolUpsellPage = new SchoolUpsellPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        schoolUpsellPage.waitForSpinnerDisappear();
        schoolUpsellPage.getPageLoadedCondition();
        schoolUpsellPage.simpleTest();
        schoolUpsellPage.clickAddOffer(offerRowIndex);
        schoolUpsellPage.clickAddOffer(otherOfferRowIndex);
        sleep(2000);
        currentTotalPrice = schoolUpsellPage.getTotalPriceDouble();
        schoolUpsellPage.clickCheckoutNowBtn();
    }

    @Test(dependsOnMethods = "addProductsAgainClickCheckout")
    protected void checkPaymentPageAfterEditOrder() {
        schoolUpsellPaymentPage = new SchoolUpsellPaymentPage(getWebDriver(), WaitTool.PAGELOAD_TIMEOUT_45);
        schoolUpsellPage.waitForSpinnerDisappear();
        schoolUpsellPaymentPage.checkOrderLineDisplayed(0);
        schoolUpsellPaymentPage.initializeAdyenStoredPaymentModules();
        schoolUpsellPaymentPage.adyenStoredPaymentModule.simpleTest();
        schoolUpsellPaymentPage.adyenStoredPaymentModule.checkAllPageComponentsDisplayed();
    }

    @Test(dependsOnMethods = "checkPaymentPageAfterEditOrder")
    protected void clickModifyCardInfo() {
                  WaitTool.waitForCondition(ExpectedConditions.elementToBeClickable(
                    By.className("add-new-card")),
                    getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
            schoolUpsellPaymentPage.adyenStoredPaymentModule.clickModifyCardInfo();

    }

    @Test(dependsOnMethods = "clickModifyCardInfo")
    protected void checkModifyCardPageAndEnterNewCardDetails() {
        schoolUpsellPaymentPage = new SchoolUpsellPaymentPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        schoolUpsellPaymentPage.initializeAdyenStoredPaymentModules();
        CheckoutPaymentPage checkoutPaymentPage=new CheckoutPaymentPage(getWebDriver(),true);
        sleep(5000);
        //checkoutPaymentPage.adyenPaymentModule.checkAllPageComponentsDisplayed();
        checkoutPaymentPage.adyenPaymentModule.enterCardDetails(adyenTestCard.getCardNumber(),adyenTestCard.getExpiryDate(),adyenTestCard.getCvv());
        logger.info("Entered payment details");
    }

    @Test(dependsOnMethods = "checkModifyCardPageAndEnterNewCardDetails")
    protected void buyUpsellOffers() {
        click(By.cssSelector(".chckt-button"));
        logger.info("Clicked pay now  ...!");
        sleep(1000);
        if(is_adyen3DSecure)
            enter3DSecurePassAnd_Submit("password");
    }

    @Test(dependsOnMethods = "buyUpsellOffers")
    protected void checkUpsellThankyouPage() {
        logger.info("checkUpsellThankyouPage content ...!");
        schoolUpsellThankyouPage = new SchoolUpsellThankyouPage(getWebDriver(), WaitTool.PAGELOAD_TIMEOUT_45);
        schoolUpsellThankyouPage.getPageLoadedCondition();
        schoolUpsellThankyouPage.checkAllPageComponentsDisplayed();
        int numberOfRows = schoolUpsellThankyouPage.getTotalOrderLines();
        for(int i=0; i < numberOfRows; i++) {
            logger.info("Checking order summary Order line [{}]", i);
            schoolUpsellThankyouPage.checkOrderLineDisplayed(i);
        }
    }


    @Test(dependsOnMethods = "buyUpsellOffers")
    protected void checkTotalPrice() {
        logger.info("checkTotalPrice ...!");
        schoolUpsellThankyouPage = new SchoolUpsellThankyouPage(getWebDriver(), WaitTool.PAGELOAD_TIMEOUT_45);
        schoolUpsellThankyouPage.getPageLoadedCondition();
        prevCurrentTotalPrice = currentTotalPrice;
        currentTotalPrice = schoolUpsellThankyouPage.getTotalPriceDouble();
        logger.info("prevCurrentTotalPrice ["+prevCurrentTotalPrice+"]; should be smaller than currentTotalPrice ["+currentTotalPrice+"]");
        AssertHelper.assertThat("Upsell page total is not equal to summary page total ...!",
                currentTotalPrice, equalTo(prevCurrentTotalPrice));
    }

    @Test(dependsOnMethods = "buyUpsellOffers")
    protected void checkTYmessage_containsTheLogedInUserName() {
        logger.info("checkTYmessage_containsTheLogedInUserName ...!");
        schoolUpsellThankyouPage = new SchoolUpsellThankyouPage(getWebDriver(), WaitTool.PAGELOAD_TIMEOUT_45);
        schoolUpsellThankyouPage.getPageLoadedCondition();

    }

    @Test(dependsOnMethods = "checkTotalPrice")
    protected void clickBookLessonNow() {
        logger.warn(".goes to my page  ... clickBookLessonNow ...!");
        schoolUpsellThankyouPage.clickBookYourLesson();
        sleep(1000);
        schoolHomePage = new SchoolHomePage(getWebDriver(), WaitTool.PAGELOAD_TIMEOUT_45);
        schoolHomePage.getPageLoadedCondition();
        schoolHomePage.simpleTest();
    }


}