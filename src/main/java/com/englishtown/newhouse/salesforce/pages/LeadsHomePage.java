package com.englishtown.newhouse.salesforce.pages;
/**
 *
 */
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.newhouse.salesforce.pages.core.SalesForceBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LeadsHomePage extends SalesForceBasePage {

    public static final Logger logger = LoggerFactory.getLogger(LeadsHomePage.class);
    public static final String pageUrl = "00Q/o";


    @FindBy(name = "new")
    public WebElement newBtn;

    @FindBy(name = "save")
    public WebElement saveBtn;

    @FindBy(name = "edit")
    public WebElement editBtn;

    @FindBy(name = "lea13")
    public WebElement leadStatusWe;

    @FindBy(className = "pbTitle")
    public WebElement recentLeads;

    //public LeadsHomePage(WebDriver webDriver) {        super(webDriver);    }
    public LeadsHomePage(WebDriver webDriver, int waitTimeSec) {
        super(webDriver, waitTimeSec);
    }


    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean simpleTest() {
        logger.info(" simpleTest() ....!");
        AssertHelper.assertWebElementDisplayed(newBtn);
        return true;
    }

    public void setLeadStatus(String leadStatus) {
        logger.info(" setLeadStatus to "+leadStatus);
        sendKey(getWebDriver(),leadStatusWe,leadStatus,false);
    }

    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(recentLeads);
    }

    public String getPageUrl() {
        return pageUrl;
    }



    public void clickNewBtn(){
       logger.info("click on save Btn - Lead");
       click(newBtn);
    }

    public void clickSaveBtn(){
        logger.info("click on save Btn - Lead");
        click(saveBtn);
    }



}