package com.englishtown.newhouse.salesforce.pages;
/**
 *
 */
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WaitTool;
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

import static org.hamcrest.Matchers.equalToIgnoringCase;


public class PaymentRecordPage extends SalesForceBasePage {

    public static final Logger logger = LoggerFactory.getLogger(PaymentRecordPage.class);
    public static final String pageUrl = "a01O000000ms";


    @FindBy(name = "charge_now")
    public WebElement chargeNowBtn;

    @FindBy(id = "00N40000001Qo1y_ileinner")
    public WebElement paymentStatus;

    @FindBy(id = "Name_ileinner")
    public WebElement paymentRecord;

    @FindBy(css ="id='page_j_id2_a00O000000czMCA_00N40000001Qo1j_body'] .dataRow  td:nth-child(5)")
    public List<WebElement> amountCollectedWe;





    //public LeadsHomePage(WebDriver webDriver) {        super(webDriver);    }
    public PaymentRecordPage(WebDriver webDriver, int waitTimeSec) {
        super(webDriver, waitTimeSec);
    }


    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean simpleTest() {
        logger.info(" simpleTest() ....!");
        AssertHelper.assertWebElementDisplayed(chargeNowBtn);
        return true;
    }

     public String getPageUrl() {
        return pageUrl;
    }



    public void clickChargenowBtn(){
        click(chargeNowBtn);
        logger.info("Clicked on Charge now button");
    }

    public void verifyPaymentStatus(String Status){
        logger.info("verifyPaymentStatus in payment record page");
        WaitTool.waitForElementVisible(getWebDriver(), By.id("00N40000001Qo1y_ileinner"),20);
        AssertHelper.myAssertThat(getWebDriver(), "Payment status is incorrect",
                paymentStatus.getText(), equalToIgnoringCase(Status), true);
        logger.info(" payment record " +paymentRecord.getText()+ "  payment status is "+ paymentStatus.getText());
    }



}