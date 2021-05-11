package com.englishtown.tests.checkout.common.core;
/**
 * New checkout  -steps -
 * url: https://www.englishtown.fr/buy/return/payment/?offerid=31331
 * Click modify and pay for the offer;
 * check thankyou page
 *
 */

import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WebElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import static com.englishtown.helpers.AssertHelper.myAssertThat;
import static org.hamcrest.Matchers.is;


public abstract class SelectOfferAndPayAlumni extends BaseEndSubscriptionAndLogin {
    private static final Logger logger = LoggerFactory.getLogger( SelectOfferAndPayAlumni.class);

    protected int offerId = 0; //first offer
    protected String modifyCardDetailsCss = ".active .functional a";
    String confirPayBtnCss = ".column0 button";

    @Test(dependsOnMethods = {"isOfferPageWithNumberOfOffers"})
    public void clickOnOfferAndWaitForModifyOfferLinkToBeClickable(){
        click(baseOfferPage.weOfferButtons.get(offerId));                          // payment page shown - need to click to edit CC details
        sleep(3000); // TestUtil.takeScreenshot(getWebDriver(), "c:/", "Temp/", "test");//takeScreenshot(getWebDriver());
        waitForElementCondition(ExpectedConditions.elementToBeClickable(By.cssSelector(modifyCardDetailsCss)),getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);   //currWebElement = findElement(By.cssSelector(modifyCardDetailsCss));
    }
//    @Test(dependsOnMethods = {"clickOnOffer"})
//    public void clickModifyDetailsLink(){
//        click(currWebElement);
//    }

    @Test(dependsOnMethods = { "clickOnOfferAndWaitForModifyOfferLinkToBeClickable" })
    public void agreeTCAndClickConfirmPay(){
        WebElement agreeTcWe ;
        if(isDeTest){
            agreeTcWe =  WebElementHelper.safeFindDisplayedAndEnabled(getWebDriver(), By.id(existingTcCheckBoxId), 10);
        } else {
            agreeTcWe =  WebElementHelper.safeFindDisplayedAndEnabled(getWebDriver(), By.id(existingTcCheckBoxId), 10);
        }
        WebElement weConfigPayBtn = WebElementHelper.safeFindElement(getWebDriver(), By.cssSelector(confirPayBtnCss)); // btn btn-primary btn-lg pull-left
        agreeTcWe.click();
        sleep(500);
        weConfigPayBtn.click();
    }

    @Test(dependsOnMethods = { "agreeTCAndClickConfirmPay" })
    public void checkReturntThankyouURL(){
        myAssertThat(getWebDriver(), " Failed, URL does not contains :'" + returnThankyouUrlContains + "' ",
                verifyUrlContains(returnThankyouUrlContains, WaitTool.MED_WAIT_4_ELEMENT25), true);
    }



}