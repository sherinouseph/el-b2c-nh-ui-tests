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


public class AddProductVirtualPayment extends SalesForceBasePage {

    public static final Logger logger = LoggerFactory.getLogger(AddProductVirtualPayment.class);
    public static final String pageUrl = "VirtualTerminalPayAddProduct?id";



    @FindBy(name = "page:form:block:section:item:product")
    public WebElement productDD;
    @FindBy(id = "page:form:block:section:sec1:firstInstallmentAmount")
    public WebElement collectedAmountVtpWe;

    @FindBy(name = "page:form:block:section:j_id33")
    public WebElement paymentMethodDD;

    @FindBy(name ="page:form:block:j_id46:j_id47")
    public WebElement nextBtn;

    @FindBy(name = "page:form:j_id48:j_id73:j_id74")
    public WebElement addBtn;





    public AddProductVirtualPayment(WebDriver webDriver, int waitTimeSec) {
        super(webDriver, waitTimeSec);
    }


    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean simpleTest() {
        logger.info(" simpleTest() ....!");
        AssertHelper.assertUrlContains(getCurrentUrl(),pageUrl,"not in Add Product Page");
        return true;
    }

    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(nextBtn);

    }

    public String getPageUrl() {
        return pageUrl;
    }


    public void addProductNewPayment(WebDriver driver, String productName, String paymentMethod) {
       selectDropdownValue(driver, productDD, productName);
       selectDropdownValue(driver, paymentMethodDD, paymentMethod);

    }
    
    public void clickAddBtn()
    {
        click(addBtn);
    }




}