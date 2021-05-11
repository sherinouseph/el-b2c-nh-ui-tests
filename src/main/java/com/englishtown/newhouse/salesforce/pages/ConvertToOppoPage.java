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


public class ConvertToOppoPage extends SalesForceBasePage {

    public static final Logger logger = LoggerFactory.getLogger(ConvertToOppoPage.class);
    public static final String pageUrl = "00QO00000";


    @FindBy(name = "convert_new")
    public WebElement convertBtn;



    public ConvertToOppoPage(WebDriver webDriver, int waitTimeSec) {
        super(webDriver, waitTimeSec);
    }


    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean simpleTest() {
        logger.info(" simpleTest() ....!");
        AssertHelper.assertWebElementDisplayed(convertBtn);
        return true;
    }

    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(convertBtn);
    }

    public String getPageUrl() {
        return pageUrl;
    }



    public void clickConvertBtn(){
        click(convertBtn);
    }

  }