package com.englishtown.newhouse.school.pages.upsell;
/**
 * Nikol Feb 2018
 *
 * Upsell page Pom
 *
 */

import com.englishtown.enumpack.UpsellOfferDetails;
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.newhouse.school.pages.core.BaseSchoolPage;
import com.englishtown.newhouse.school.pages.upsell.module.OfferModule;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;


public class SchoolUpsellPage extends BaseSchoolPage {

    public static final Logger logger = LoggerFactory.getLogger(SchoolUpsellPage.class);
    public static final String pageUrl = "/buy/upsell/upsell.html";

    protected OfferModule offerModule;
    private String name;
    private int quantity;
    private int price ;
    private String currency ;

    /**
     * Page components Css selectors as string
     */
    protected final String headerNeedHelpLinkCss       = "a[href$='/help.html']";  // top of page need some help?
    protected final String headerPhoneIconAndNumberCss = "phone-icon-and-number";  // class
    protected final String returnToMyAccountLinkCss    = "horn--nav";      // return to my account
    protected final String securePadlockAndTxtCss      = "horn--secure";   // class
    protected final String removeAllLinkCss            = "remove-all";     // class
    protected final String totalPriceCss               = ".total .price";  // £34.00
    protected final String checkoutNowBtnCss           = "btn-primary";    // class  active only when one offer added  disabled="disabled"
    protected final String checkoutNowBtnDisabledCss   = "."+checkoutNowBtnCss+":disabled";    // find .btn-primary:disabled button  disabled="disabled"

    /**
     * Page components  
     */
    @FindBy(css = headerNeedHelpLinkCss)
    public WebElement headerNeedHepLinkWe;

    @FindBy(className = headerPhoneIconAndNumberCss)
    public WebElement headerPhoneAndIconNumberWe;

    @FindBy(className = returnToMyAccountLinkCss)
    public WebElement returnToMyAccountLinkWe;

    @FindBy(className = securePadlockAndTxtCss)
    public WebElement securePadLockAndTxtWe;

    @FindBy(className = removeAllLinkCss)
    public WebElement removeAllLinkWe;

    @FindBy(css = totalPriceCss)
    public WebElement totalPriceWe;

    /**
     * disabled OR enabled button
     */
    @FindBy(className = checkoutNowBtnCss)
    public WebElement checkoutNowBtnWe;

    @FindBy(css = checkoutNowBtnDisabledCss)
    public WebElement checkoutNowBtnDisabledWe;


    //-------------------------------------------------------------------------------------

    /**
     * Constructors
     *
     */
    public SchoolUpsellPage(WebDriver webDriver) {
        super(webDriver);
        initializeModules();
    }

    public SchoolUpsellPage(WebDriver webDriver, int waitTimeSec) {
        super(webDriver, waitTimeSec);
        initializeModules();
    }

    public SchoolUpsellPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }

    public SchoolUpsellPage() {
        this(null, null);
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void initializeModules(){
        offerModule = new OfferModule(getWebDriver());
    }

    //-------------------------------------------------------------------------------------
    /**
     * Helper Methods 
     *
     */
    public boolean isCheckoutNowDisabled(){
        if(WaitTool.isEnabled(getWebDriver(), checkoutNowBtnWe))
            return false;

        return true;
    }

    public void assertCheckoutNowBtnIsNotEnabled(){
        AssertHelper.assertWebElementNotEnambled(getWebDriver(), checkoutNowBtnWe);
    }

    public void clickCheckoutNowBtn(){
        click(checkoutNowBtnWe);
    }

    public void clickRemoveAll(){
        click(removeAllLinkWe);
    }

    public void clickAddOffer(int offerRowIndex){
        click(offerModule.getOfferElement(offerRowIndex, UpsellOfferDetails.ADDOFFERBTN));
    }

    public void clickRemoveOffer(int offerRowIndex){
        click(offerModule.getOfferElement(offerRowIndex, UpsellOfferDetails.REMOVEOFFERBTN));
    }

    public String getTotalPrice(){
        return TestUtil.getWebElementText(totalPriceWe);
    }

    public double getTotalPriceDouble(){
        String price = TestUtil.getWebElementText(totalPriceWe);
        return TestUtil.getNumberOutOfString(price);
    }

    public BigDecimal getTotalPriceBigDecimal(){
        String price = TestUtil.getWebElementText(totalPriceWe);
        return new BigDecimal(TestUtil.getNumberOutOfString(price));
    }

    public String getProductRowName(int index){
        return TestUtil.getWebElementText(offerModule.getOfferElement(index, UpsellOfferDetails.NAME));
    }

    public int getProductRowQuantity(int index){
        String orderLineQuantity = TestUtil.getWebElementText(offerModule.getOfferElement(index, UpsellOfferDetails.QUANTITY));
        return (int)TestUtil.getNumberOutOfString(orderLineQuantity);
    }

    public int getProductRowPrice(int index){
        String orderLinePrice = TestUtil.getWebElementText(offerModule.getOfferElement(index, UpsellOfferDetails.PRICE));
        return (int)TestUtil.getNumberOutOfString(orderLinePrice);
    }

    public String getProductRowCurrency(int index){
        String price = TestUtil.getWebElementText(offerModule.getOfferElement(index, UpsellOfferDetails.PRICE));
        String currency = "";
        if(StringUtils.isNotBlank(price)) {
            currency = String.valueOf(price.trim().charAt(0));
        }else
            failTest("Cant get currency from order line ...!");
        return currency;
    }

    public void setRowContentNameQuantityPriceCurrency(int index){
        logger.info("setRowContentNameQuantityPrice ... index [{}]", index);
        name     = getProductRowName(index);
        quantity = getProductRowQuantity(index);
        price    = getProductRowPrice(index);
        currency = getProductRowCurrency(index);
        logger.info("name["+name+"]; quantity["+quantity+"]; price["+price+"]; currency["+currency+"] ..!");
    }

    /**
     * Use this for added offer or not added offer
     * 
     * @param index
     * @param isAdded
     * @param isDiscountedOffer
     */
    public void checkMainOfferRowElementsDisplayed(int index, boolean isAdded, boolean isDiscountedOffer){
        offerModule.checkMainOfferElementsDisplayed( index, isAdded, isDiscountedOffer);
    }


    //-------------------------------------------------------------------------------------

    /**
     * Base Methods for all POMs 
     *
     */
    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(removeAllLinkWe);
    }

    public boolean simpleTest() {
        logger.info("simpleTest Assert Main element displayed ...!");
        //AssertHelper.assertComponentsDisplayed(headerNeedHepLinkWe);
        AssertHelper.assertComponentsDisplayed(returnToMyAccountLinkWe);
        AssertHelper.assertComponentsDisplayed(removeAllLinkWe);
        return true;
    }

    public void waitForSpinnerDisappear(){
        WaitTool.waitForCondition( ExpectedConditions.invisibilityOfElementLocated(
                By.className("spinner")),getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
    }

    @Override
    public boolean checkAllPageComponentsDisplayed() {
        logger.info("checkAllPageComponents ...!");
        simpleTest();
        checkAllPageComponentsDisplayed(securePadLockAndTxtWe);
        offerModule.simpleTest();
        offerModule.checkMainOfferElementsDisplayed(0, false, false);
        return true;
    }

    @Override
    public String getPageUrl() {
        return pageUrl;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }


}
