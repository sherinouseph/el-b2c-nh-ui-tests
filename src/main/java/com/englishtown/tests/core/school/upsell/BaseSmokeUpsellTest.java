package com.englishtown.tests.core.school.upsell;
/**
 *
 * Go to upsell and pay
 * check summary page as well
 *
 * User: nikol.marku
 * Date: 14/02/18
 *
 *
 */
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.newhouse.school.pages.upsell.SchoolUpsellPaymentPage;
import com.englishtown.newhouse.school.pages.upsell.SchoolUpsellThankyouPage;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

// payment fail on QA for one offer .. know issue
// TODO open test
public abstract class BaseSmokeUpsellTest extends BaseUpsellTest{
    private static final Logger logger = LoggerFactory.getLogger(BaseSmokeUpsellTest.class);


    @Test(dependsOnMethods = "checkUpsellPageAllComponents")
    protected void addProduct1() {
        schoolUpsellPage.clickAddOffer(offerRowIndex);
    }

    @Test(dependsOnMethods = "addProduct1")
    protected void setPriceAndClickCheckOutNow() {
        currentTotalPrice = schoolUpsellPage.getTotalPriceDouble();
        logger.info(" currentTotalPrice ["+currentTotalPrice+"]");
        schoolUpsellPage.clickCheckoutNowBtn();
    }

    @Test(dependsOnMethods = "setPriceAndClickCheckOutNow")
    protected void checkPaymentPage() {
        if (!is_adyenPayment) {
            schoolUpsellPaymentPage = new SchoolUpsellPaymentPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
            schoolUpsellPaymentPage.getPageLoadedCondition();
            schoolUpsellPaymentPage.simpleTest();
        } else {
            schoolUpsellPaymentPage = new SchoolUpsellPaymentPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
            schoolUpsellPaymentPage.initializeAdyenStoredPaymentModules();
            schoolUpsellPaymentPage.adyenStoredPaymentModule.getPageLoadedCondition();
            schoolUpsellPaymentPage.adyenStoredPaymentModule.simpleTest();
        }
    }


    @Test(dependsOnMethods = "checkPaymentPage")
    protected void CheckBuyUpsellOfferPage() {
        if(!is_adyenPayment) {
            //Todo : upsell page does not show existing payment so only check this page untill fixed ..if ?
            schoolUpsellPaymentPage = new SchoolUpsellPaymentPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
            schoolUpsellPaymentPage.getPageLoadedCondition();
            WebElementHelper.ensureCheckBoxChecked(schoolUpsellPaymentPage.existingTC_checkbox_We);
            sleep(500);
            schoolUpsellPaymentPage.clickBuyNow();
        }else{
            schoolUpsellPaymentPage = new SchoolUpsellPaymentPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
            schoolUpsellPaymentPage.initializeAdyenStoredPaymentModules();
            schoolUpsellPaymentPage.adyenStoredPaymentModule.checkAllPageComponentsDisplayed();
            schoolUpsellPaymentPage.adyenStoredPaymentModule.clickBuyNow();
        }
        logger.info("Clicked buy now  ...!");
        sleep(1500);
    }

    @Test(dependsOnMethods = "CheckBuyUpsellOfferPage")
    protected void checkUpsellThankyouPage() {
        if(StringUtils.contains(getENVIRONMENT(), "live") && getLanguage() == "tr"){
            logger.warn("this test is not run for tr upsell as existing cc number not stored ...!");
        } else {
            logger.info("checkUpsellThankyouPage content ...!");
            schoolUpsellThankyouPage = new SchoolUpsellThankyouPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
            schoolUpsellThankyouPage.getPageLoadedCondition();
            schoolUpsellThankyouPage.simpleTest();
        }
        sleep(1000);
    }


}