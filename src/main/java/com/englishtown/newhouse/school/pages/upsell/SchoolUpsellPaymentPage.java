package com.englishtown.newhouse.school.pages.upsell;
/**
 * Nikol Feb 2018
 *
 * Upsell Payment page
 * auto_5692522245154_QOJECKR968248880_xdelx@qp1.org
 */

import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.newhouse.school.pages.core.BaseSchoolPage;
import com.englishtown.newhouse.school.pages.upsell.module.AdyenStoredPaymentModule;
import com.englishtown.newhouse.school.pages.upsell.module.UpsellOrderLineModule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SchoolUpsellPaymentPage extends BaseSchoolPage {

    public static final Logger logger = LoggerFactory.getLogger(SchoolUpsellPaymentPage.class);
    public static final String pageUrl = "/buy/upsell/payment/";
    public AdyenStoredPaymentModule adyenStoredPaymentModule;

    protected UpsellOrderLineModule orderLineModule;
    public static final String EDIT_CURRENT_CARD_CSS = "form-group-existing-PayUsingNewCardLink";  // CLASS NAME

    /**
     * Page components
     */
    @FindBy(css = ".total .price")
    public WebElement totalPriceWe;   // £109.00

    @FindBy(css = ".link.edit-order") //edit-order")
    public WebElement editOrderLinkWe;

    @FindBy(css = ".sub .context-aware-editor-tag-p")
    public WebElement youWillBeChargedTxtWe;          // You’ll be charged £106.00 now. Purchase is non-refundable.

    @FindBy(name = "existing-CreditCardNumber")   // input[name='existing-CreditCardNumber']"
    public WebElement existingCardTxtWe;                      // disabled

    @FindBy(className = EDIT_CURRENT_CARD_CSS)
    public WebElement editCurrentCardWe;

    @FindBy(name = "existing-tc")
    public WebElement existingTC_checkbox_We;

    @FindBy(css = ".form-group-existing-tc a")
    public WebElement tcLinkWe;  // terms and conditions

    @FindBy(className = "btn-primary")
    public WebElement buyNowWe;

  

    /**
     * Modify card
     * after click on modify
     *
     */
    @FindBy(name = "CreditCardNumber")
    public WebElement creditCardNumberTxtWe;

    @FindBy(name = "CreditCardName")
    public WebElement creditCardNameTxtWe;

    @FindBy(name = "ExpirationMonth")
    public WebElement expireMonthSelectWe;

    @FindBy(name = "ExpirationYear")
    public WebElement expireYearSelectWe;

    @FindBy(name = "CardVerificationCode")
    public WebElement verificationCodeTxtWe;

    @FindBy(name = "CCAuthorized")
    public WebElement acceptCheckBoxWe;

    //reuse same buy button to submit

    //
    //-------------------------------------------------------------------------------------
    public SchoolUpsellPaymentPage(WebDriver webDriver) {
        super(webDriver);
        initializeModules();
    }
    public SchoolUpsellPaymentPage(WebDriver webDriver, int waitTimeSec) {
        super(webDriver, waitTimeSec);
        initializeModules();
    }
    public SchoolUpsellPaymentPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }
    public SchoolUpsellPaymentPage() {
        this(null, null);
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void initializeModules(){
        orderLineModule = new UpsellOrderLineModule(getWebDriver());
    }
    //-------------------------------------------------------------------------------------
    /**
     * Helper Methods 
     *
     ********************************/
    /***
     * @param index
     *
     */
    public void checkOrderLineDisplayed(int index){
        orderLineModule.checkMainOrderLineElementsDisplayed(index);
    }

    public void checkYouWillBeChargedTxtContainsPrice(){
        AssertHelper.assertStringContainsPattern(TestUtil.getWebElementText(youWillBeChargedTxtWe), "[0-9]");
    }

    public void assertIsEditPaymentDetailsForm(){
        checkAllPageComponentsDisplayed(creditCardNumberTxtWe, creditCardNameTxtWe, expireMonthSelectWe,
                expireYearSelectWe, verificationCodeTxtWe, acceptCheckBoxWe );
    }
    //-------------------------
    public void clickEditOrder(){
        click(editOrderLinkWe);
    }

    public void clickModifyCardInfo(){
        click(editCurrentCardWe);
    }

    public void enterCreditCardName(){
        WebElementHelper.sendKeys(getWebDriver(), creditCardNameTxtWe, "Auto Upsell", false);
    }
    // Note : to enter payment details use  enter_PaymentDetails(); on the test
    public void clickBuyNow(){
        click(buyNowWe);
        logger.info("Clicked buy now");
    }

    //-------------------------------------------------------------------------------------
    /**
     * Base Methods for all POMs 
     *
     */
    public ExpectedCondition getPageLoadedCondition() {
              return ExpectedConditions.visibilityOf(buyNowWe);
    }

    public boolean simpleTest() {
        AssertHelper.assertComponentsDisplayed(buyNowWe);
        logger.info("Simple  Assert Main element displayed ...!");
        return true;
    }

    @Override
    public boolean checkAllPageComponentsDisplayed() {
        logger.info("checkAllPageComponents ...!");
        checkAllPageComponentsDisplayed(totalPriceWe, editOrderLinkWe, youWillBeChargedTxtWe, existingCardTxtWe,
                editCurrentCardWe, existingTC_checkbox_We, tcLinkWe, buyNowWe );
        orderLineModule.simpleTest();
        //orderLineModule.checkAllPageComponentsDisplayed();
        return true;
    }

    public void initializeAdyenStoredPaymentModules(){
        adyenStoredPaymentModule = new AdyenStoredPaymentModule(getWebDriver());
    }

    @Override
    public String getPageUrl() {
        return pageUrl;
    }


}
