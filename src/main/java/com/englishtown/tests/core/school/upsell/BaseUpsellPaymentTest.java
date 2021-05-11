package com.englishtown.tests.core.school.upsell;
/**
 *
 * Go to upsell page
 * check page content
 * go pay check pay page
 * go to summary page
 * go to buy lessons may page
 * User: nikol.marku
 * Date: 14/02/18
 *
 *
 */
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.newhouse.school.pages.home.SchoolHomePage;
import com.englishtown.newhouse.school.pages.upsell.SchoolUpsellPage;
import com.englishtown.newhouse.school.pages.upsell.SchoolUpsellPaymentPage;
import com.englishtown.newhouse.school.pages.upsell.SchoolUpsellThankyouPage;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import static org.hamcrest.core.IsEqual.equalTo;


public abstract class BaseUpsellPaymentTest extends BaseUpsellTest{
    private static final Logger logger = LoggerFactory.getLogger(BaseUpsellPaymentTest.class);


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
        schoolUpsellPaymentPage.getPageLoadedCondition();
        schoolUpsellPaymentPage.simpleTest();
        if(isNewHouseUser){
            // new house users shows edit pay page .. existing payment not shown
            schoolUpsellPage.waitForSpinnerDisappear();
        } else {
            schoolUpsellPaymentPage.checkAllPageComponentsDisplayed();
            schoolUpsellPaymentPage.checkOrderLineDisplayed(0);
            schoolUpsellPaymentPage.checkYouWillBeChargedTxtContainsPrice();
        }
    }

    @Test(dependsOnMethods = "checkPaymentPage")
    protected void clickEditOrder() {
        waitForElementCondition(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".link.edit-order")), getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        waitForElementCondition(ExpectedConditions.elementToBeClickable(By.cssSelector(".link.edit-order")), getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        sleep(2000);
        schoolUpsellPaymentPage.clickEditOrder();
    }

    //TODO this should show the added products but currently reset .. to no order added
    @Test(dependsOnMethods = "clickEditOrder")
    protected void addProductsAgainClickCheckout() {
        //TODO navigate to it using billing page
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
        schoolUpsellPaymentPage.getPageLoadedCondition();
        schoolUpsellPaymentPage.simpleTest();
        if(isNewHouseUser){

        } else {
            schoolUpsellPaymentPage.checkAllPageComponentsDisplayed();
            schoolUpsellPaymentPage.checkOrderLineDisplayed(0);
        }
    }

    @Test(dependsOnMethods = "checkPaymentPageAfterEditOrder")
    protected void clickModifyCardInfo() {
        if(StringUtils.equals("live", getENVIRONMENT()) && isNewHouseUser){

        } else {
            WaitTool.waitForCondition(ExpectedConditions.elementToBeClickable(
                    By.className(SchoolUpsellPaymentPage.EDIT_CURRENT_CARD_CSS)),
                    getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
            schoolUpsellPaymentPage.clickModifyCardInfo();
        }
    }

    @Test(dependsOnMethods = "clickModifyCardInfo")
    protected void checkModifyCardPageAndEnterNewCardDetails() {
        schoolUpsellPaymentPage = new SchoolUpsellPaymentPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        schoolUpsellPaymentPage.simpleTest();
        removePaymentValidation();//remove_PaymentValidation();
        enter_PaymentDetails();
        schoolUpsellPaymentPage.enterCreditCardName();
        logger.info("Entered payment details");
    }

    @Test(dependsOnMethods = "checkModifyCardPageAndEnterNewCardDetails")
    protected void buyUpsellOffers() {
        schoolUpsellPaymentPage.clickBuyNow();
        logger.info("Clicked buy now  ...!");
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
        //old house does not show email
        if(isNewHouseUser)
            schoolUpsellThankyouPage.assertTyMessageContainsUsername(getUserEmail());
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