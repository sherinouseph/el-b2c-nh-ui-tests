package com.englishtown.tests.core.school.upsell;
/**
 *
 * Go to upsell page check page content
 * User: nikol.marku
 * Date: 14/02/18
 *
 *
 */
import com.englishtown.newhouse.school.pages.upsell.SchoolUpsellPage;
import com.englishtown.tests.core.school.BaseSchoolHomePageTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;



public abstract class BaseUpsellTest extends BaseSchoolHomePageTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseUpsellTest.class);

    protected String upsellUrl = ""; // test set this up "englishlive.ef.com/en-gb/buy/upsell/upsell?ctr=gb";

    protected String currencySymbol; // e.g £ $
    protected String initialTotalPriceTxt = "£0.00";
    protected String currentTotalPriceTxt;

    protected double initialTotalPrice = 0.00;
    protected double currentTotalPrice;
    protected double prevCurrentTotalPrice;

    protected int offerRowIndex      = 0;                  // add this product
    protected int otherOfferRowIndex = offerRowIndex + 3; // add this product when second product added



    @Test(dependsOnMethods = "checkMyPage")
    protected void goToUpsellPage() {
        //TODO navigate to it using billing page
        upsellUrl =  getBASEURL()+upsellUrl;
        logger.info("Open and check upsell page [{}]", upsellUrl);
        openUrl(getWebDriver(), upsellUrl);

        schoolUpsellPage = new SchoolUpsellPage(getWebDriver());
        schoolUpsellPage.waitForSpinnerDisappear();
        schoolUpsellPage.getPageLoadedCondition();
        schoolUpsellPage.simpleTest();
    }

    @Test(dependsOnMethods = "goToUpsellPage")
    protected void checkUpsellPageAllComponents() {
        schoolUpsellPage.checkAllPageComponentsDisplayed();
        schoolUpsellPage.setRowContentNameQuantityPriceCurrency(0);
    }


}
