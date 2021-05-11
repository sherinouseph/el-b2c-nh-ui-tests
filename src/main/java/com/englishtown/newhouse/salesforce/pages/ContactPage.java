package com.englishtown.newhouse.salesforce.pages;
/**
 * Sherin - 10/11/2017
 * MAp Student Page
 */
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.MyWebDriverAction;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.newhouse.salesforce.pages.core.SalesForceBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ContactPage extends SalesForceBasePage {

    public static final Logger logger = LoggerFactory.getLogger(ContactPage.class);
    public static final String pageUrl = "MapStudentFromActual?id=a00O00";
    protected String passwordTxt = "password";


    @FindBy(id = "00N90000000cN0Qpage_j_id28_ileinner")
    public WebElement etownStatusWe;

    @FindBy(id = "00N90000000cN0Qpage_j_id28")
    public WebElement eTowndropdownWe;

    @FindBy(css = "#topButtonRowpage_j_id28 [name='inlineEditSave']")
    public WebElement saveWe;

    @FindBy(css = "#topButtonRowpage_j_id28 [name='edit']")
    public WebElement editWe;




    public ContactPage(WebDriver webDriver, int waitTimeSec) {
        super(webDriver, waitTimeSec);
    }


    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean simpleTest() {
        logger.info(" simpleTest() ....!");
        AssertHelper.assertWebElementDisplayed(etownStatusWe);
        return true;
    }


    public String getPageUrl() {
        return pageUrl;
    }


    public void selectETownstatus(String status) {
        logger.info("Select the etown status " + status);
        MyWebDriverAction.doubleClick(getWebDriver(), etownStatusWe);
        sleep(300);
        WebElementHelper.sendKeys(getWebDriver(), eTowndropdownWe, status, true);
        sleep(300);
        logger.info("successfully selected ETown status " +status);
    }

    public void clickSaveOnContact(){
        click(saveWe);
        logger.info("Successfully saved the contact");

    }

    

}