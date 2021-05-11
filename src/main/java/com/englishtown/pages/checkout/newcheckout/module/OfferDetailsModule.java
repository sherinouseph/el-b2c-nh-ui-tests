package com.englishtown.pages.checkout.newcheckout.module;
/**
 * Nikol - 08/11/2018
 * New Design 2018
 * https://englishlive.ef.com/en-gb/buy/default/member/
 * offer details including price and features
 */


import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.pages.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class OfferDetailsModule extends BasePage {
    public static final Logger logger = LoggerFactory.getLogger(OfferDetailsModule.class);
    public static final String pageUrl = "/buy/default/member/";

    protected final String offerDetailsAllCss  = ".offer-details ";   // all offer heading and features detatils
    protected final String offerCaptionCss     = offerDetailsAllCss + ".caption p";        // Learn Eng 7 days free
    public    final String offerDescriptionCss = offerDetailsAllCss + ".desc p";           // $69/months afterwards. Cancel anytime.
    protected final String offerReminderCss    = offerDetailsAllCss + ".reminder p";       // Offer expires 18 November
    public static final String offerExpandCollapseCss  = ".offer-details .switch";       // plus or minus switch to expand collapse
    // features
    protected final String offerFeatureItemsContainerCss  = offerDetailsAllCss + ".feature-item-container ";   // main component with all the features
    protected final String offerFeatureItemsListCss       = offerFeatureItemsContainerCss + "li .content";   // main component with all the features

    protected String market;
    protected String currency;


    @FindBy(css = offerDetailsAllCss)
    public WebElement offerDetailsAllWe;

    @FindBy(css = offerCaptionCss)
    public WebElement offerCaptionWe;

    @FindBy(css = offerDescriptionCss)
    public WebElement offerDescriptionWe;

    @FindBy(css = offerReminderCss)
    public WebElement offerReminderWe;

    @FindBy(css = offerExpandCollapseCss)
    public WebElement offerExpandCollapseWe;

    @FindBy(css = offerFeatureItemsListCss)
    public List<WebElement> offerFeatureItemsListWe;


    public OfferDetailsModule(WebDriver webDriver) {
        super(webDriver);
    }
    public OfferDetailsModule(WebDriver webDriver, String url) {
        super(webDriver, url);
    }
    public OfferDetailsModule(WebDriver webDriver, int waitTimeSec) {
        super(webDriver, waitTimeSec);
    }
    public OfferDetailsModule(WebDriver webDriver, int waitTimeSec, String market, String currency) {
        super(webDriver, waitTimeSec);
        this.market   = market;
        this.currency = currency;
    }

    public OfferDetailsModule() {
        this(null, null);
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }


    public boolean checkAllPageComponentsDisplayed() {
        return checkAllPageComponentsDisplayed(offerDetailsAllWe, offerCaptionWe, offerDescriptionWe, offerReminderWe,
                offerExpandCollapseWe, offerFeatureItemsListWe.get(0)); //, offerFeatureItemsListWe.get(2));
    }

    public boolean simpleTest() {
        logger.info("check is Displayed...!");
        AssertHelper.assertWebElementDisplayed(offerCaptionWe);
        return true;
    }

    @Override
    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(offerExpandCollapseWe);
    }

    public String getOfferFeatureItem(int index){
        return TestUtil.getWebElementText(offerFeatureItemsListWe.get(index));
    }

    public String getPageUrl(){
        return pageUrl;
    }


}
