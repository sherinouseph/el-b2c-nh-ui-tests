package com.englishtown.newhouse.school.pages.account;
/**
 * Nikol - 08/10/2018
 *
 */
//Billing page object

import com.englishtown.enumpack.BillingTables;
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.utils.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class BillingPage extends BaseAccountSettingPage {
    public static final Logger logger = LoggerFactory.getLogger(BillingPage.class);
    public static final String pageUrl = "/account/billing-and-features";

    //public static final String viewReceiptLink = "form[action*='/customerservice/b2c/billingfeature/DownloadReceiptByOrder\']";
    //public int tableHeadingSubscriptionId = 8;

    @FindBy(css = ".ui.large.header")
    public List<WebElement>  sectionHeadersListWe;   // subscription, pay, feature

    // there are 3 tables and this will get tables  // tr th for heading and tbody tr td for rows
    @FindBy(css = ".ui.table")
    public List<WebElement>  tableListWe;

    @FindBy(css = "[class^='upsell-promotion_'] div a")
    public WebElement addMoreBtnWe;



    public BillingPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }

    public BillingPage(WebDriver webDriver, int waitTimeSec) {
        super(webDriver, waitTimeSec);
    }

    public BillingPage() {
        this(null, null);
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Override
    public boolean checkAllPageComponentsDisplayed() {
        return checkAllPageComponentsDisplayed(sectionHeadersListWe.get(2), tableListWe.get(2), addMoreBtnWe);
    }

    public boolean simpleTest() {
        logger.info("check is Displayed...!");
        AssertHelper.assertWebElementDisplayed(sectionHeadersListWe.get(1));
        return true;
    }

    @Override
    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(sectionHeadersListWe.get(1));
    }

    public WebElement getTable(BillingTables tables){
        int index = 0; // default
        switch (tables){
            case SUBSCRIPTION:
                index = 0;
                break;
            case PAYMENT:
                index = 1;
                break;
            case SUBSCRIPTION_ITEMS:
                index = 2;
                break;
        }
        return tableListWe.get(index);
    }

    public String getTableCellText(WebElement tableWe, int cellIndex){
        return TestUtil.getWebElementText(tableWe.findElements(By.cssSelector("tbody td")).get(cellIndex));
    }

    public String getTableColumnHeadingText(WebElement tableWe, int cellIndex){
        return TestUtil.getWebElementText(tableWe.findElements(By.cssSelector("thead tr th")).get(cellIndex));
    }

    public int getTableRowNumber(WebElement parentTableWe){
        return getTableRows(parentTableWe).size();
    }
    public List<WebElement> getTableRows(WebElement parentTableWe){
        return parentTableWe.findElements(By.cssSelector("tbody tr"));
    }

    public void clickOnCancelLink(){
        //todo
    }

    public void clickOnResumeLink(){
        //todo
    }


    @Override
    public String getPageUrl(){
        return pageUrl;
    }


}
