package com.englishtown.newhouse.salesforce.pages;
/**
 * Bank Transfer Page details
 */
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.newhouse.salesforce.pages.core.SalesForceBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class BankTransfer extends SalesForceBasePage {

    public static final Logger logger = LoggerFactory.getLogger(BankTransfer.class);
    public static final String pageUrl = "TakeOfflinePayment?id=006O0";


    @FindBy(id = "page:form:block1:j_id31:j_id33")
    public WebElement firstInstallmentWe;

    @FindBy(css=".dateFormat a")
    public WebElement collectedDateLinkWe;

    @FindBy(id="page:form:j_id35:j_id51:j_id53")
    public WebElement collectedDateWe;

    @FindBy(id="page:form:j_id35:j_id51:j_id55")
    public WebElement amountCollectedWe;

    @FindBy(name="page:form:j_id35:j_id51:j_id54")
    public WebElement accountHolderNameWe;

    @FindBy(id = "page:form:j_id35:j_id67:j_id68")
    public WebElement createActualsBtn;

    public String installAmount;



    public BankTransfer(WebDriver webDriver, int waitTimeSec) {
        super(webDriver, waitTimeSec);
    }


    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean simpleTest() {
        logger.info(" simpleTest() ....!");
        AssertHelper.assertWebElementDisplayed(accountHolderNameWe);
        AssertHelper.assertWebElementDisplayed(createActualsBtn);
        return true;
    }


    public String getPageUrl() {
        return pageUrl;
    }


    public String getInstallAmount() {
        String installAmount = firstInstallmentWe.getAttribute("value");
        logger.info("Installation Amount is " +installAmount);
        return installAmount;
    }

    public void enterBankTransferPaymentDetails(String accountholdername){
        //click(collectedDateLinkWe);
        logger.info("Entering account holder name and amount collected");

        sendKey(getWebDriver(), accountHolderNameWe, accountholdername,false);
        sendKey(getWebDriver(), amountCollectedWe, getInstallAmount(),false);
        logger.info(getInstallAmount());
        logger.info("Successfully entered account holder name,Amount collected and Collected Date");

    }

    public void clickCreateActualBtn(){
        click((createActualsBtn));
    }

}