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


public class SelectLeadRecordType extends SalesForceBasePage {

    public static final Logger logger = LoggerFactory.getLogger(SelectLeadRecordType.class);
    public static final String pageUrl = "setup/ui/recordtypeselect.jsp?ent=Lead";


    @FindBy(id = "p3")
    public WebElement selectWe;

    @FindBy(css="Input[value*='Continue']")
    public WebElement continueBtnWe;

    public SelectLeadRecordType(WebDriver webDriver, int waitTimeSec) {
        super(webDriver, waitTimeSec);
    }


    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean simpleTest() {
        logger.info(" simpleTest() ....!");
        AssertHelper.assertWebElementDisplayed(selectWe);
        return true;
    }

    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(selectWe);
    }

    public String getPageUrl() {
        return pageUrl;
    }



    public void selectRecordTypeAndClickContinue(String recordType){
        WebElementHelper.sendKeys(getWebDriver(), selectWe, recordType, false );
        //click(continueBtnWe);
        continueBtnWe.click();
    }



}