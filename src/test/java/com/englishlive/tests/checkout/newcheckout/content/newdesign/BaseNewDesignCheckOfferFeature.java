package com.englishlive.tests.checkout.newcheckout.content.newdesign;
/**
 * Created by nikol.marku on Nov-18.
 * https://jira.eflabs.io/browse/SAND-6120
 *
 * 1. open member page with offer id
 * 2. expand
 * 3. check offer price , private classes group classes, desc
 *
 *
 */

import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WaitToolConfig;
import com.englishtown.helpers.bean.OfferFeature;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.pages.checkout.newcheckout.module.OfferDetailsModule;
import com.englishtown.tests.core.BaseTestHelper;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.text.IsEmptyString.isEmptyOrNullString;


public abstract class BaseNewDesignCheckOfferFeature extends BaseTestHelper {

    private static final Logger logger = LoggerFactory.getLogger(BaseNewDesignCheckOfferFeature.class);

    protected OfferDetailsModule offerDetailsModule;

    protected OfferFeature offerFeature;

    protected static final String BASE_START_URL = "englishlive.ef.com/";

    protected static final String END_TEST_URL   = "/buy/default/member/?offerid=";



    @Test
    void openMemberPageWithOfferAndGetPriceAndOfferFeatures(){
        offerFeature.print();
        testStartUrl = getBASEURL()+BASE_START_URL+offerFeature.getMarket()+END_TEST_URL+offerFeature.getId();
        openUrl( getWebDriver(), testStartUrl);
        WaitTool.waitForElementVisibleAndClickable(By.name("firstname"), getWebDriver(), 20);

        waitForElementCondition(ExpectedConditions.elementToBeClickable(
                By.cssSelector(offerDetailsModule.offerExpandCollapseCss)), getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        offerDetailsModule = new OfferDetailsModule(getWebDriver(),
                WaitTool.MED_WAIT_4_ELEMENT, offerFeature.getMarket().split("-")[1], offerFeature.getCurrency() );
        offerDetailsModule.getPageLoadedCondition();
        sleep(1000);
        click(offerDetailsModule.offerExpandCollapseWe);
        sleep(1000);

        offerDetailsModule.getPageLoadedCondition();
        offerDetailsModule.simpleTest();
    }

    @Test(dependsOnMethods = "openMemberPageWithOfferAndGetPriceAndOfferFeatures")
    void checkOfferNotEmptyHeadingCaption(){
        AssertHelper.assertThat("Offer Heading Caption is empty or null ...!",
                TestUtil.getWebElementText(offerDetailsModule.offerCaptionWe), not(isEmptyOrNullString()) );
    }

    @Test(dependsOnMethods = "openMemberPageWithOfferAndGetPriceAndOfferFeatures")
    void checkOfferDescriptionPrice(){
        /*if(StringUtils.containsIgnoreCase(offerFeature.getMarket(), "tr")){   //tr new house
            List<WebElement> webElements = findElements(By.cssSelector(offerDetailsModule.offerDescriptionCss), 25);
            AssertHelper.assertThat("Offer description Price is not the expected one  ...!",
                    TestUtil.getWebElementText(webElements.get(0)), containsString(offerFeature.getDescription()));
        }else {*/
            AssertHelper.assertThat("Offer description Price is not the expected one  ...!",
                    TestUtil.getWebElementText(offerDetailsModule.offerDescriptionWe), containsString(offerFeature.getDescription()));
        //}
    }

    @Test(dependsOnMethods = "openMemberPageWithOfferAndGetPriceAndOfferFeatures")
    void checkOfferNotEmptyReminder(){
        AssertHelper.assertThat("checkOfferNotEmptyReminder is empty or null ...!",
                TestUtil.getWebElementText(offerDetailsModule.offerReminderWe), not(isEmptyOrNullString()) );
    }

    @Test(dependsOnMethods = "openMemberPageWithOfferAndGetPriceAndOfferFeatures")
    void checkOfferGroupClasses(){
        if( ! StringUtils.equalsIgnoreCase(offerFeature.getGroupClasses(), "none")) {
            AssertHelper.assertThat("checkOfferGroupClasses does not contains expected text ...!",
                    TestUtil.webElementContainText(offerDetailsModule.offerFeatureItemsListWe,
                            offerFeature.getGroupClasses()), is(true));
        }else
            logger.info("This offer does not suppose to have GLs ....!");
    }

    @Test(dependsOnMethods = "openMemberPageWithOfferAndGetPriceAndOfferFeatures")
    void checkOfferPrivateClasses(){
        if( ! StringUtils.equalsIgnoreCase(offerFeature.getPrivateClasses(), "none")){
            AssertHelper.assertThat("Private classes are not the expected one ...!",
                    TestUtil.getWebElementText(offerDetailsModule.offerDescriptionWe), containsString(offerFeature.getDescription()) );
        }else
            logger.info("This offer does not suppose to have PLs ....!");
    }

    @Test(dependsOnMethods = "openMemberPageWithOfferAndGetPriceAndOfferFeatures")
    void checkNumberOf_OfferFeatures(){
        AssertHelper.assertElementSizeMoreThanOrEqual(getWebDriver(),offerDetailsModule.offerFeatureItemsListWe, 5);
    }

    @Test(dependsOnMethods = "checkOfferPrivateClasses")
    void collapseOffer(){
        click(offerDetailsModule.offerExpandCollapseWe);
        sleep(2000);
        offerDetailsModule = new OfferDetailsModule(getWebDriver(),
                WaitTool.MED_WAIT_4_ELEMENT, offerFeature.getMarket().split("-")[1], offerFeature.getCurrency() );
        WaitTool.waitForCondition(ExpectedConditions.invisibilityOf(offerDetailsModule.offerFeatureItemsListWe.get(0)),
                getWebDriver(), WaitToolConfig.SHORT_WAIT_4_ELEMENT);
        AssertHelper.assertWebElementNotDisplayed(offerDetailsModule.offerFeatureItemsListWe.get(0));
    }

}




/***
 *


 //for(int i=0; i < offerDetailsModule.offerFeatureItemsListWe.size(); i++) {logger.info("\t "+offerDetailsModule.getOfferFeatureItem(i));     }
 //logger.info("\t "+offerDetailsModule.offerDetailsAllWe.getText());
 //sleep(25000);
 //logger.info("currentPrice    :"+currentPrice );
 //logger.info("offerFeatureAll :"+currentOfferFeatureList );



 if(offerFeature.isNoDiscountOffer()){
 WebElement priceWe = findElement(By.cssSelector(offerFeature.getOfferPriceNoDiscountCss()));
 currentPrice = getText(priceWe);
 }else {
 List<WebElement> currentPriceWeList = WaitTool.findElements(getWebDriver(),
 By.cssSelector(offerFeature.getOfferPriceWithDiscountCss()));
 try {
 if(StringUtils.contains(getTestStartUrl(), "ar-sa")){
 priceWeId = 3;
 }
 currentPrice = getText(currentPriceWeList.get(priceWeId));
 } catch (Exception e) {
 failTest("Can not get offer price ...! for :" + testStartUrl + "\n\t\t" + e.getMessage());
 }
 }
 if(StringUtils.isBlank(currentPrice))
 failTest("Can not get offer price ...! for :" + testStartUrl );

 List<WebElement> currentOfferFeaturesWeList = WaitTool.findElements(getWebDriver(),
 By.cssSelector(offerFeature.getOfferFeaturesListCss()));

 for(int i=0; i < currentOfferFeaturesWeList.size(); i++) {                                                       //offerFeatureAllStr = offerFeatureAllStr+"\n"+getText(currentOfferFeaturesWeList.get(i));
 currentOfferFeatureList.add(getText(currentOfferFeaturesWeList.get(i))) ;
 }

 @Test(dependsOnMethods = "openMemberPageWithOfferAndGetPriceAndOfferFeatures")
 protected void isExpectedPrice(){  //CurrencyAnd
 String expectedPrice = offerFeature.getPriceFirstMonth();   // offerFeature.getCurrency()+
 AssertHelper.assertThat(testStartUrl+" > Price is not the expected one ....! ",currentPrice , containsString(expectedPrice) );
 }

 @Test(dependsOnMethods = "openMemberPageWithOfferAndGetPriceAndOfferFeatures")
 protected void hasExpectedFeaturesGroupClass(){//assertThat(collection, hasItem("cd"));
 AssertHelper.assertThat(testStartUrl + " > Offer features are not the expected one ....!",currentOfferFeatureList,
 hasItem(offerFeature.getGroupClasses()));
 }

 @Test(dependsOnMethods = "openMemberPageWithOfferAndGetPriceAndOfferFeatures")
 protected void hasExpectedFeaturePrivateClass(){
 if(StringUtils.isBlank(offerFeature.getPrivateClasses())){
 logger.info("This offer has no feature Private Classes to check for ...!");
 }else {
 AssertHelper.assertThat(testStartUrl + " > Offer features getPrivateClasses is not the expected one ....!", currentOfferFeatureList,
 hasItem(offerFeature.getPrivateClasses()));
 }
 }
 *
 */
