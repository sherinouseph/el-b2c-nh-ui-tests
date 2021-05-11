package com.englishtown.newhouse.salesforce.pages;
/**
 *
 */
import com.englishtown.helpers.AssertHelper;
import com.englishtown.newhouse.salesforce.pages.core.SalesForceBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;


public class AddProductPCI extends SalesForceBasePage {

    public static final Logger logger = LoggerFactory.getLogger(AddProductPCI.class);
    public static final String pageUrl = "AddProductForOpportunity?id=";
    public  Map paymentDataMap;



    @FindBy(id = "page:form:block:section:item:product")
    public WebElement productWe;

    @FindBy(id = "page:form:block:section:j_id33")
    public WebElement paymentMethodWe;

    @FindBy(id = "page:form:block:section:j_id34")
    public WebElement paymentScheduleWe;

    @FindBy(id = "page:form:block:section:j_id35")
    public WebElement numberOfInstallmentsWE;

    @FindBy(id = "page:form:block:section:j_id36")
    public WebElement discountWe;

    @FindBy(css = ".pbBottomButtons input")  //"page:form:block:j_id41:j_id42")
    public WebElement nextBtn;

    @FindBy(css = ".pbBottomButtons input")  //"page:form:j_id43:j_id58:j_id59")
    public WebElement addBtn;

    @FindBy(id = "page:form:block:section:j_id40")
    public WebElement currencyWe;

    public AddProductPCI(WebDriver webDriver, int waitTimeSec) {
        super(webDriver, waitTimeSec);
    }


    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean simpleTest() {
        logger.info(" simpleTest() ....!");
        AssertHelper.assertWebElementDisplayed(nextBtn);
        return true;
    }

    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(nextBtn);
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public void addProduct(WebDriver driver,String productName, String paymentMethod, String paymentSchedule,
                           String discount, String numberOfInstallments){
        selectProductName(driver, productName);
        selectPaymentMethod(driver, paymentMethod);
        selectNumberOfInstallments(driver, numberOfInstallments);
        selectPaymentSchedule(driver, paymentSchedule);
        selectDiscount(driver, discount);


    }


    public void selectProductName(WebDriver driver, String productName){
        selectDropdownValue(driver,productWe,productName);
    }

    public void selectPaymentMethod(WebDriver driver, String paymentMethod){
        selectDropdownValue(driver, paymentMethodWe, paymentMethod);
    }

    public void selectPaymentSchedule(WebDriver driver, String paymentSchedule){
        selectDropdownValue(driver,paymentScheduleWe, paymentSchedule);
    }

    public void selectNumberOfInstallments(WebDriver driver, String numberOfInstallments){
        selectDropdownValue(driver, numberOfInstallmentsWE, numberOfInstallments);
    }
    /**
     *  if null use default discount = 0
     * @param driver
     * @param discount
     */
    public void selectDiscount(WebDriver driver, String discount){
        if(null == discount )
            discount = "0%";
        selectDropdownValue(driver,discountWe, discount);
    }

    public void clickNext(){
        logger.info("clickNextBtn ...!");
        click(nextBtn);
        logger.info("Clicked next button ...!");
    }

    public void clickAddBtn() {
        logger.info("clickAddBtn ...!");
        click(addBtn);
        logger.info("Clicked add button ...!");
    }



}