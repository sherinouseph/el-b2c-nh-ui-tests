package com.englishtown.newhouse.school.pages.upsell.module;
/**
 * Nikol Feb 2018
 *
 * model one and reuse
 *
 * On upsell payment summary page there are a list of  offers -- order line
 * quantity and Name ... .. price ...
 *
 * auto_692708059307743_APSAKFT859478314_xdelx@qp1.org
 *
 */
import com.englishtown.enumpack.UpsellOrderLine;
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


public class UpsellOrderLineModule extends BaseSchoolPage {

    public static final Logger logger = LoggerFactory.getLogger(UpsellOrderLineModule.class);
    public static final String pageUrl = "/buy/upsell/payment/";
    public final String orderLineCss = ".selected-offers .row";  // get a list of order lines
    public int checkAllRowDataIndex = 0; //test set this up
    //--------------------------------------------------------------------------------------
    /**
     *
     * Composite Selectors
     * 10 10 Group lesson coupons     £63.00
     */
    public final String quantityAndNameCss = ".quantity.name";   // 10 10 Group lesson coupons this is changing
    public final String descriptionCss     = "desc";             // sometime shown  40 mins
    public final String priceCss           = "cell--price";      // £63.00

    /**
     * components
     *
     */
    @FindBy(css = orderLineCss)
    public List<WebElement> orderLineListWe;

    /**
     *
     * @return we from the list of WEs
     */
    public WebElement getOrderLine(int index){
        return orderLineListWe.get(index);
    }

    public int getTotalNumberOfOffers(){
        int numberOfOffers = -1;
        if(orderLineListWe != null && !orderLineListWe.isEmpty())
            numberOfOffers = orderLineListWe.size();
        else
            failTest("Cant get the offer list Null or Empty...! "+orderLineListWe);

        return numberOfOffers;
    }

    /**
     * Find elements on the parent element
     *
     *
     * @param index
     * @param upsellOrderLine
     * @return
     */
    public WebElement getOrderLineElement(int index, UpsellOrderLine upsellOrderLine){
        WebElement webElement = null;

        switch (upsellOrderLine){

            //"TODO not implemented by karim"
            case QUANTITY:
                logger.info("Case [{}]", upsellOrderLine);
                webElement = WebElementHelper.safeFindElement(orderLineListWe.get(index), By.cssSelector(quantityAndNameCss));
                break;

            case NAME:
                logger.info("Case [{}]", upsellOrderLine);
                webElement = WebElementHelper.safeFindElement(orderLineListWe.get(index), By.cssSelector(quantityAndNameCss));
                break;

            /*case DESCRIPTION:
                logger.info("Case - this is only available for som so .. not checking [{}]", upsellOrderLine);
                //webElement = WebElementHelper.safeFindElement(orderLineListWe.get(index), By.className(descriptionCss));
                break;*/

            case PRICE:
                logger.info("Case [{}]", upsellOrderLine);
                webElement = WebElementHelper.safeFindElement(orderLineListWe.get(index), By.className(priceCss));
                break;

            default:
                logger.error("Cant find this element [{}]", upsellOrderLine);
        }

        if(null == webElement)
            failTest("Cant find Web Element ...! for :"+upsellOrderLine);

        return webElement;
    }

    //todo
    /**
     * Check on row
     * @param index
     */
    public void checkMainOrderLineElementsDisplayed(int index ){
        logger.info("checkMainOfferElementsDisplayed ..!");
        for(UpsellOrderLine lineModule : UpsellOrderLine.values()){
            logger.info("Checking topic card Element [{}] displayed ..!", lineModule);
            AssertHelper.assertWebElementDisplayed(getOrderLineElement(index, lineModule));
        }

    }

    ///-------------------------------------------------------------------------------------

    public UpsellOrderLineModule(WebDriver webDriver){
        super(webDriver);
    }
    public UpsellOrderLineModule(WebDriver webDriver, String url) {
        super(webDriver, url);
    }
    public UpsellOrderLineModule() {
        this(null, null);
    }
    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(orderLineListWe.get(0));
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public boolean simpleTest() {
        logger.info("simpleTest Assert Main element displayed ...!");
        AssertHelper.assertComponentsDisplayed(orderLineListWe.get(0) );
        return true;
    }

    /**
     * for the line only
     * @return
     */
    @Override
    public boolean checkAllPageComponentsDisplayed() {
        logger.info("checkAllPageComponents ...!");
        checkMainOrderLineElementsDisplayed(checkAllRowDataIndex);
        return true;
    }


    public int getCheckAllRowDataIndex() {
        return checkAllRowDataIndex;
    }

    public void setCheckAllRowDataIndex(int checkAllRowDataIndex) {
        this.checkAllRowDataIndex = checkAllRowDataIndex;
    }

}
