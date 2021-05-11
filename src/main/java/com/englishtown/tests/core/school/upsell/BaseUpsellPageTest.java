package com.englishtown.tests.core.school.upsell;
/**
 *
 * Check upsell page add remove ... total price and offer content
 *
 * User: nikol.marku
 * Date: 15/02/18
 *
 *
 */

import com.englishtown.helpers.AssertHelper;
import com.englishtown.newhouse.school.pages.upsell.SchoolUpsellPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.number.OrderingComparison.greaterThan;
import static org.hamcrest.text.IsEmptyString.isEmptyOrNullString;


public abstract class BaseUpsellPageTest extends BaseUpsellTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseUpsellPageTest.class);


    @Test(dependsOnMethods = "checkUpsellPageAllComponents")
    protected void checkOfferNameHasContent() {
        AssertHelper.assertThat("Offer Name is null or Empty ...!",
                schoolUpsellPage.getName(), not(isEmptyOrNullString()));
    }

    @Test(dependsOnMethods = "checkUpsellPageAllComponents")
    protected void checkQuantityGreaterThanZero() {
        AssertHelper.assertThat("Offer Quantity is not the expected one ...!",
                schoolUpsellPage.getQuantity(), greaterThan(0));
    }

    @Test(dependsOnMethods = "checkUpsellPageAllComponents")
    protected void checkOfferPrice() {
        AssertHelper.assertThat("Offer Price is not the expected one ...!",
                schoolUpsellPage.getPrice(), greaterThan(0));
    }

    @Test(dependsOnMethods = "checkUpsellPageAllComponents")
    protected void checkOfferPriceCurrencySymbol() {
        AssertHelper.assertThat("Currency symbol is not the expected one ...!",
                schoolUpsellPage.getCurrency(), equalTo(currencySymbol));
    }

    @Test(dependsOnMethods = "checkUpsellPageAllComponents")
    protected void checkoutNowBtnIsNotEnabled() {
        schoolUpsellPage.assertCheckoutNowBtnIsNotEnabled();
    }

    @Test(dependsOnMethods = "checkUpsellPageAllComponents")
    protected void checkTotalPriceIsZero() {
        AssertHelper.assertStringContains(schoolUpsellPage.getTotalPrice(), initialTotalPriceTxt,
                "Total price is not the expected one ["+initialTotalPriceTxt+"] ...!");
    }

    @Test(dependsOnMethods = "checkoutNowBtnIsNotEnabled")
    protected void addProduct() {
        schoolUpsellPage.clickAddOffer(offerRowIndex);
    }

    @Test(dependsOnMethods = "addProduct")
    protected void checkProductAddedRowChangesToAdded() {
        schoolUpsellPage = new SchoolUpsellPage(getWebDriver());
        schoolUpsellPage.checkMainOfferRowElementsDisplayed(offerRowIndex, true, false);
    }

    @Test(dependsOnMethods = "checkProductAddedRowChangesToAdded")
    protected void checkProductAddedIncreaseTotal() {
        currentTotalPrice = schoolUpsellPage.getTotalPriceDouble();
        AssertHelper.assertThat("", currentTotalPrice, greaterThan(initialTotalPrice));
    }

    @Test(dependsOnMethods = "checkProductAddedIncreaseTotal")
    protected void addSecondProductCheckProductAddedAndTotal() {
        schoolUpsellPage.clickAddOffer(otherOfferRowIndex);

        schoolUpsellPage = new SchoolUpsellPage(getWebDriver());
        schoolUpsellPage.checkMainOfferRowElementsDisplayed(otherOfferRowIndex, true, false);

        prevCurrentTotalPrice = currentTotalPrice;
        currentTotalPrice = schoolUpsellPage.getTotalPriceDouble();
        logger.info("prevCurrentTotalPrice ["+prevCurrentTotalPrice+"]; should be smaller than currentTotalPrice ["+currentTotalPrice+"]");
        AssertHelper.assertThat("Price is not increased, and should be ... except offer price is 0.00 ..",
                currentTotalPrice, greaterThan(prevCurrentTotalPrice));
    }

    @Test(dependsOnMethods = "addSecondProductCheckProductAddedAndTotal")
    protected void removeSecondProductAdded() {
        schoolUpsellPage = new SchoolUpsellPage(getWebDriver());
        schoolUpsellPage.checkMainOfferRowElementsDisplayed(otherOfferRowIndex, true, false);
        schoolUpsellPage.clickRemoveOffer(otherOfferRowIndex);
        sleep(1000);
        schoolUpsellPage = new SchoolUpsellPage(getWebDriver());
        schoolUpsellPage.checkMainOfferRowElementsDisplayed(otherOfferRowIndex, false, false);
    }

    @Test(dependsOnMethods = "removeSecondProductAdded")
    protected void checkTotalDecreased() {
        prevCurrentTotalPrice = currentTotalPrice;
        currentTotalPrice = schoolUpsellPage.getTotalPriceDouble();
        logger.info("prevCurrentTotalPrice ["+prevCurrentTotalPrice+"]; should be greater than currentTotalPrice ["+currentTotalPrice+"]");
        AssertHelper.assertThat("", currentTotalPrice, lessThan(prevCurrentTotalPrice));
    }

    @Test(dependsOnMethods = "removeSecondProductAdded")
    protected void clickRemoveAll_checkTotalZero_rowAddState() {
        prevCurrentTotalPrice = currentTotalPrice;
        schoolUpsellPage.clickRemoveAll();
        sleep(1000);
        schoolUpsellPage = new SchoolUpsellPage(getWebDriver());
        currentTotalPrice = schoolUpsellPage.getTotalPriceDouble();
        logger.info("prevCurrentTotalPrice ["+prevCurrentTotalPrice+"]; currentTotalPrice ["+currentTotalPrice+"]");
        AssertHelper.assertStringContains(schoolUpsellPage.getTotalPrice(), initialTotalPriceTxt,
                "Total price is not the expected one ["+initialTotalPriceTxt+"] ...!");

        schoolUpsellPage.checkMainOfferRowElementsDisplayed(offerRowIndex, false, false);
    }



}
