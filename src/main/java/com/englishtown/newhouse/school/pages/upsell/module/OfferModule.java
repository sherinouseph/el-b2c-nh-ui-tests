package com.englishtown.newhouse.school.pages.upsell.module;
/**
 * Nikol Feb 2018
 *
 * model one and reuse
 *
 * On upsell page there are a list of  products/offers
 * Name ... quantity ... price ... add button [added once clicked] .. green circle with tick ... circle with cancel (x)
 *
 */
import com.englishtown.enumpack.UpsellOfferDetails;
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.newhouse.school.pages.core.BaseSchoolPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class OfferModule extends BaseSchoolPage {

    public static final Logger logger = LoggerFactory.getLogger(OfferModule.class);
    public static final String pageUrl = "/buy/upsell/upsell/";

    public final String offerListCss = ".offers tbody tr";  // get a list of offers if added shows us {.offer.added}

    //
    //--------------------------------------------------------------------------------------
    /**
     *    offer details
     * An offer contains components. For each element in offerListWe
     * . Name - quantitiy - price - discount - button add  - button remove - circle (green)
     * ....! sometime there is a description
     *
     * Composite Selectors   ".offers tbody tr" + below css
     *
     */
    public final String nameCss                = ".name .name span.text";
    public final String nameToolTipCss         = ".name .tooltip .inner";    // get text from this
    public final String quantityCss            = ".quantity span";            // get text from the quantity "1"
    public final String priceCss               = ".price .text";             // get text from the price "£25.00"
    public final String discountCss            = ">.discount .text";         // get text from the discount  "Save 30%"
    public final String greenCircleCss         = "circle";                   // class // displayed only when user clicked added
    public final String addOfferBtnCss         = ".button-add .button";
    public final String removeOfferBtnCss      = ".button-remove";
    // .when when--added shown when user clicked add   .. before when when--not-added
    public final String addButtonWhenAddedCss       = "when--added";      //class one of this is displayed
    public final String addButtonWhen_Not_AddedCss  = "when--not-added";  //class


    /**
     * components
     *
     */

    @FindBy(css = offerListCss)
    public List<WebElement> offerListWe;


    /**
     *
     * @return we from the list of WEs
     */
    public WebElement getOffer(int offerIndex){
        return offerListWe.get(offerIndex);
    }

    public int getTotalNumberOfOffers(){
        int numberOfOffers = -1;
        if(offerListWe != null && !offerListWe.isEmpty())
            numberOfOffers = offerListWe.size();
        else
            failTest("Cant get the offer list Null or Empty...! "+offerListWe);

        return numberOfOffers;
    }

    /**
     * Find elements on the parent element
     *
     *
     * @param offerIndex
     * @param upsellOfferDetails
     * @return
     */
    public WebElement getOfferElement(int offerIndex, UpsellOfferDetails upsellOfferDetails){
        WebElement webElement = null;

        switch (upsellOfferDetails){

            case NAME:
                logger.info("Case [{}]", upsellOfferDetails);
                webElement = WebElementHelper.safeFindElement(offerListWe.get(offerIndex), By.cssSelector(nameCss));
                break;

            case NAME_TOOLTIP:
                logger.info("Case [{}]", upsellOfferDetails);
                webElement = WebElementHelper.safeFindElement(offerListWe.get(offerIndex), By.cssSelector(nameToolTipCss));
                break;

            case QUANTITY:
                logger.info("Case [{}]", upsellOfferDetails);
                webElement = WebElementHelper.safeFindElement(offerListWe.get(offerIndex), By.cssSelector(quantityCss));
                break;

            case PRICE:
                logger.info("Case [{}]", upsellOfferDetails);
                webElement = WebElementHelper.safeFindElement(offerListWe.get(offerIndex), By.cssSelector(priceCss));
                break;

            case DISCOUNT:
                logger.info("Case [{}]", upsellOfferDetails);
                webElement = WebElementHelper.safeFindElement(offerListWe.get(offerIndex), By.cssSelector(discountCss));
                break;

            case GREENCIRCLE:
                logger.info("Case [{}]", upsellOfferDetails);
                webElement = WebElementHelper.safeFindElement(offerListWe.get(offerIndex), By.className(greenCircleCss));
                break;

            case ADDOFFERBTN:
                logger.info("Case [{}]", upsellOfferDetails);
                webElement = WebElementHelper.safeFindElement(offerListWe.get(offerIndex), By.cssSelector(addOfferBtnCss));
                break;

            case REMOVEOFFERBTN:
                logger.info("Case [{}]", upsellOfferDetails);
                webElement = WebElementHelper.safeFindElement(offerListWe.get(offerIndex), By.cssSelector(removeOfferBtnCss));
                break;

            case ADDBUTTON_WHEN_ADDED:
                logger.info("Case [{}]", upsellOfferDetails);
                webElement = WebElementHelper.safeFindElement(offerListWe.get(offerIndex), By.className(addButtonWhenAddedCss));
                break;

            case ADDBUTTON_WHEN_NOT_ADDED:
                logger.info("Case [{}]", upsellOfferDetails);
                webElement = WebElementHelper.safeFindElement(offerListWe.get(offerIndex), By.className(addButtonWhen_Not_AddedCss));
                break;

            default:
                logger.error("Cant find this element [{}]", upsellOfferDetails);
        }

        if(null == webElement)
            failTest("Cant find Web Element ...! for :"+upsellOfferDetails);

        return webElement;
    }

    //todo

    /**
     * Check on row offer
     * @param index
     * @param isAdded   - user has clicked to add this offer
     * @param isDiscountedOffer for offers with quantity more than 1 a 30% discount applied
     */
    public void checkMainOfferElementsDisplayed(int index, boolean isAdded, boolean isDiscountedOffer){
        logger.info("checkMainOfferElementsDisplayed ..!");
        //shown all time
        AssertHelper.assertWebElementDisplayed(getOfferElement(index, UpsellOfferDetails.NAME));
        AssertHelper.assertWebElementDisplayed(getOfferElement(index, UpsellOfferDetails.QUANTITY));
        AssertHelper.assertWebElementDisplayed(getOfferElement(index, UpsellOfferDetails.PRICE));

        if(isDiscountedOffer)
            AssertHelper.assertWebElementDisplayed(getOfferElement(index, UpsellOfferDetails.DISCOUNT));

        if(isAdded){
            logger.info("Check added offer details, user has clicked on add button ...!");
            AssertHelper.assertWebElementDisplayed(getOfferElement(index, UpsellOfferDetails.GREENCIRCLE));
            AssertHelper.assertWebElementDisplayed(getOfferElement(index, UpsellOfferDetails.REMOVEOFFERBTN));
            AssertHelper.assertWebElementDisplayed(getOfferElement(index, UpsellOfferDetails.ADDBUTTON_WHEN_ADDED));
        }else {
            logger.info("Check offer details, user has not clicked on add ...!");
            AssertHelper.assertWebElementDisplayed(getOfferElement(index, UpsellOfferDetails.ADDBUTTON_WHEN_NOT_ADDED));
        }
    }



    ///-------------------------------------------------------------------------------------

    public OfferModule(WebDriver webDriver){
        super(webDriver);
    }
    public OfferModule(WebDriver webDriver, String url) {
        super(webDriver, url);
    }
    public OfferModule() {
        this(null, null);
    }
    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(offerListWe.get(0));
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public boolean simpleTest() {
        logger.info("simpleTest Assert Main element displayed ...!");
        AssertHelper.assertComponentsDisplayed(offerListWe.get(0) );
        //AssertHelper.assertComponentsDisplayed(topicListSectionWe, cardTopicListWe.get(0));
        return true;
    }

    @Override
    public boolean checkAllPageComponentsDisplayed() {
        logger.info("checkAllPageComponents ...!");
        //TODO checkAllPageComponentsDisplayed( topicListSectionWe);
        return true;
    }

}
