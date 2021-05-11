package com.englishtown.newhouse.school.pages.account;
/**
 * Update payment page
 * Nikol
 * March 2018
 *
 *
 */

import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WaitToolConfig;
import com.englishtown.helpers.utils.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedHashMap;
import java.util.Map;

public class UpdatePaymentPage extends BaseAccountSettingPage {

    public static final Logger logger = LoggerFactory.getLogger(UpdatePaymentPage.class);
    public static final String pageUrl = "payment/update";

    public final String CARD_NO_CSS  = "CreditCardNumber";  //id
    public final String UPDATE_PAYMENT_BTN_CSS   = ".btn.btn-primary  ";  //id


    @FindBy(css = ".caption")
    public WebElement updateCardTitleWe;

    @FindBy(className = CARD_NO_CSS)
    public WebElement creditCardNo;

    @FindBy(css = ".horn--nav a")
    public WebElement myAccountLinkWe;

    @FindBy(css = ".horn--secure .icon")
    public WebElement secureLockWe;

    @FindBy(css = UPDATE_PAYMENT_BTN_CSS)
    public WebElement updatePaymentBtnWe;


    public UpdatePaymentPage(WebDriver webDriver){
        super(webDriver);
    }

    public UpdatePaymentPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }

    public UpdatePaymentPage(WebDriver webDriver, int waitTimeSec) {
        super(webDriver, waitTimeSec);
    }

    public UpdatePaymentPage() {
        this(null, null);
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean simpleTest() {
        logger.info("view details link should be displayed...!");
        AssertHelper.assertWebElementDisplayed(updatePaymentBtnWe);
        return true;
    }

    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(updatePaymentBtnWe);
    }

    @Override
    public boolean checkAllPageComponentsDisplayed() {
        WaitTool.waitForCondition(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(UPDATE_PAYMENT_BTN_CSS)),
                                                                     getWebDriver(), WaitToolConfig.MED_WAIT_4_ELEMENT);
        checkAllPageComponentsDisplayed( myAccountLinkWe, updatePaymentBtnWe,updateCardTitleWe,secureLockWe);
        return false;
    }


    /**
     * Action
     *
     */

    public void enterNewPaymentDetails(){
        TestUtil.enterFormData(getWebDriver(), UPDATE_CC_CARD);
    }

    public void clickonUpdatePaymentBtn(){
        logger.info("clickonUpdatePaymentBtn...!");
        click(updatePaymentBtnWe);
    }




    // ON THE SCHOOL
    public static final Map<String, String> UPDATE_CC_CARD = new LinkedHashMap<>();
    static {
        Long currNanoTime = System.nanoTime();
        UPDATE_CC_CARD.put("CreditCardName",     "Test UpdatePayment");  // UPDATE THIS DYNAMICALLY
        UPDATE_CC_CARD.put("ExpirationMonth",      "selectMeSelectOpt&true&5");
        UPDATE_CC_CARD.put("ExpirationYear",       "selectMeSelectOpt&true&2022"); //TODO get the year dynamically
        UPDATE_CC_CARD.put("CardVerificationCode", "123");
        UPDATE_CC_CARD.put("CCAuthorized",         "selectMeChk_true");
    }


}
