package com.englishlive.tests.checkout.newcheckout.content;
/**
 * Created by nikol.marku on 10-Jul-17.
 * https://jira.eflabs.io/browse/SAND-4255
 * open member page and check offer price , private classes group classes
 *
 * When I open member page
     I should see the correct :
     <> offer price [after the discount including money sign [£ $ E] e.g £30 ]
     <> private classes
     <> group classes
 *
 */

import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.bean.OfferFeature;
import com.englishtown.tests.core.BaseTestHelper;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.hamcrest.core.IsCollectionContaining.hasItems;


public abstract class BaseCheckOfferFeature extends BaseTestHelper {

    private static final Logger logger = LoggerFactory.getLogger(BaseCheckOfferFeature.class);

    protected String currentPrice;

    protected List<String> currentOfferFeatureList = new ArrayList<>();

    protected OfferFeature offerFeature;

    protected int priceWeId = 1; // 2 for SA

    protected static final String BASE_START_URL = "englishlive.ef.com/";

    protected static final String END_TEST_URL   = "/buy/default/member/?offerid=";


    @Test
    void openMemberPageWithOfferAndGetPriceAndOfferFeatures(){
        offerFeature.print();
        testStartUrl = getBASEURL()+BASE_START_URL+offerFeature.getMarket()+END_TEST_URL+offerFeature.getId();
        openUrl( getWebDriver(), testStartUrl);

        WaitTool.waitForElementVisibleAndClickable(By.name("firstname"), getWebDriver(), 20);

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

        logger.info("currentPrice    :"+currentPrice );
        logger.info("offerFeatureAll :"+currentOfferFeatureList );
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



}
