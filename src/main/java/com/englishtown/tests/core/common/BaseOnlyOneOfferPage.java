package com.englishtown.tests.core.common;
/**
 *
 * This page is shown after user  sumbit form : http://www.englishtown.fr/lp/os/crm-acq-3months-1monthfree/
 * and open .../login url
 *
 * One offer is shown on the page
 *
 */

import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.pages.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;

public abstract class BaseOnlyOneOfferPage extends BaseEnterFormDataAndSubmit {
    private static final Logger logger = LoggerFactory.getLogger(BaseOnlyOneOfferPage.class);

    protected static String offerButtonCss = ".container-fluid button"; //button"; // should get only one in this case
    By byOfferButton = new By.ByCssSelector(offerButtonCss);

    @Test(priority=1,dependsOnMethods="submit")
    public void openLoginPageToAutoLoginMember(){
        String[] tempUrl= getWebDriver().getCurrentUrl().split("/");
        String frLoginUrl = tempUrl[0]+"//"+tempUrl[2]+"/login/";
        openUrl(getWebDriver(), frLoginUrl, WaitTool.MED_WAIT_4_ELEMENT);
        sleep(300);
    }

    @Test(dependsOnMethods = { "openLoginPageToAutoLoginMember" })
    public void checkWelcomeBackMemberPageURL(){
        AssertHelper.myAssertThat(getWebDriver(), "Failed ...!. is not welcome back member URL '" +
                        welcomeBackMemberUrlContains + "'; Waited for :" + WaitTool.MED_WAIT_4_ELEMENT25,
                BasePage.waitForUrlContains(this.getWebDriver(), welcomeBackMemberUrlContains, WaitTool.MED_WAIT_4_ELEMENT25), is(true), true);
    }

    @Test(dependsOnMethods = { "checkWelcomeBackMemberPageURL" })
    public void checkOnlyOneOfferShown(){
        logger.info(" \n\n DEBUG sleep .\n\n\n------");
        sleep(2000);
        List<WebElement> weOffers = WebElementHelper.getVisibleElements(getWebDriver(), byOfferButton);
        WaitTool.waitForCondition( ExpectedConditions.elementToBeClickable(byOfferButton),
                getWebDriver(), 35) ;
        failTestIfEmptyList(weOffers);
        AssertHelper.myAssertThat(getWebDriver(), " There should be only one offer NOT : " + weOffers.size(), weOffers.size() == 1, true);
        testUtil.takeScreenshot(TestUtil.generateRandomFilename("CrmCheckOnlyOneOfferShown" + this.getClass().getSimpleName() + "_"), getWebDriver(), false);
    }

    @Test(dependsOnMethods = { "checkOnlyOneOfferShown" })
    public void checkOfferId(){
        assertStateObjectElementValue("order.offer_id", getOfferId(), true);
    }

    @Test(dependsOnMethods = { "checkOfferId" })
    void checkOfferPrice(){
        logger.info(" isOfferCurrencyPersistedTest....getOfferPrice() :"+getOfferPrice());
        isOrderPriceRelatedToPcodeOnTY("order.phase0.price", getOfferPrice(), true);
    }

    @Test(dependsOnMethods = { "checkOfferPrice" })
    void clickOfferButton(){                                           // goes to payment page
        WebElement weBuyOffer = WebElementHelper.safeFindElement(getWebDriver(), byOfferButton );
        click(weBuyOffer);
        sleep(2000);
    }

    @Test(dependsOnMethods = { "clickOfferButton" })
    public void checkOfferIdAndPriceOnPaymentPage(){
        assertStateObjectElementValue("order.offer_id", getOfferId(), true);
        isOrderOfferPriceOnStateObjectSameAsOfferPrice("order.phase0.price", getOfferPrice(), false);
    }


}


//    protected String getExperienceFullUrl(String experience){
//        return this.getTestPageUrl()+"/?crmmb="+experience+"/";
//    }
//
//    @Test(dependsOnMethods = {"submit"} )
//    public void openExperiencePage(){
//        openUrl(getWebDriver(), getExperienceFullUrl(experienceId), WaitTool.DEFAULT_WAIT_4_ELEMENT);
//        sleep(305000);
//    }

//    @Test(dependsOnMethods = { "checkOfferId" })
//    void checkOfferCurrency(){
//        logger.info(" isOfferCurrencyPersistedTest.... getOfferCurrency() :"+getOfferCurrency());
//        isOrderCurrencyRelatedToPcodeOnTY("order.phase0.currency", getOfferCurrency(), true);
//    }