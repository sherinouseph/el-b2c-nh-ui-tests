package com.englishtown.newhouse.salesforce.pages;
/**
 *
 */
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WebDriverWindowHelper;
import com.englishtown.newhouse.salesforce.pages.core.SalesForceBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;



public class PaymentSalesForcePage extends SalesForceBasePage {

    public static final Logger logger = LoggerFactory.getLogger(PaymentSalesForcePage.class);
    public static final String pageUrl = "VirtualTerminalPayment?id=";
    public  Map paymentDataMap;


    // id = card_type_001 to 6
    @FindBy(css = "#card_type_selection input")
    public List<WebElement> cardTypeListWe;

    @FindBy(name = "page:form:block:j_id27:j_id28")
    public WebElement closeBtn;

    @FindBy(name = "commit")
    public WebElement payBtn;

    @FindBy(id = "submitButton")
    public WebElement submitBtn;

//    @FindBy(name="op-PMMakePayment")
//    public WebElement continue1Btn;

    @FindBy(id="submitButton")
    public WebElement makePaymentBtn;

    @FindBy(name="continue")
    public WebElement continue2Btn;




    public PaymentSalesForcePage(WebDriver webDriver, int waitTimeSec) {
        super(webDriver, waitTimeSec);
    }


    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean simpleTest() {
        logger.info(" simpleTest() ....!");
       // AssertHelper.assertWebElementDisplayed(closeBtn);
        return true;
    }

    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(closeBtn);
    }

    public String getPageUrl() {
        return pageUrl;
    }

  public void switchToPaymentFrame(int paymentFrameId) {
      logger.info("switchToPaymentFrame ...! id :"+paymentFrameId);
      getWebDriver().switchTo().frame(paymentFrameId);
      logger.info("successfully entered to the Payment frame id : "+paymentFrameId);

  }

  // TODO use state objec for this
  public  void selectCardType(String cardTypeId)  {
        WebElement cardTypeWe = WaitTool.waitForElementVisible(getWebDriver(), By.id(cardTypeId), 100, 1000);
        AssertHelper.assertWebElementDisplayed(cardTypeWe);
        click(cardTypeWe);
  }

  public  void selectCardTypeWorldPay(String cardType)  {
        WebElement cardTypeWe = WaitTool.waitForElementVisible(getWebDriver(), By.name(cardType), 65, 1000);
        AssertHelper.assertWebElementDisplayed(cardTypeWe);
        click(cardTypeWe);
   }


}