package com.englishtown.newhouse.salesforce.pages;
/**
 *
 */
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.newhouse.salesforce.pages.core.SalesForceBasePage;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class NewLeadSalesForcePage extends SalesForceBasePage {

    public static final Logger logger = LoggerFactory.getLogger(NewLeadSalesForcePage.class);
    public static final String pageUrl = "00Q/e?retURL";



    @FindBy(id = "lea3")
    public WebElement companyId;

//    @FindBy(id = "00N40000001QNVc")
//    public WebElement aptdateWe;

     @FindBy(css=".dateFormat a[href*='00N40000001QNVc']")
     public WebElement aptdateWe;

    @FindBy(name = "00N30000000k5UY")
    public WebElement partnerWe;

    @FindBy(name = "00N9000000DHYiV")
    public WebElement countryWe;


    public NewLeadSalesForcePage(WebDriver webDriver, int waitTimeSec) {
        super(webDriver, waitTimeSec);
    }


    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean simpleTest() {
        logger.info(" simpleTest() ....!");
        AssertHelper.assertWebElementDisplayed(companyId);
        return true;
    }

    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(companyId);
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public void saveLead(){

        List  <WebElement>  leadSaveBtnList = WebElementHelper.safeFindListOfElementsPresent(getWebDriver(), By.name("save"),10);
        leadSaveBtnList.get(0).click();


    }

    public void selectCountry(String country) {
        Select select = new Select(countryWe);
        String currentSelectedValue = select.getFirstSelectedOption().getText();
        logger.info("currentSelectedValue ["+currentSelectedValue+"]");

        if ((null != countryWe && StringUtils.contains(currentSelectedValue ,"--None--"))) {
           countryWe.sendKeys(country);
           logger.info("Country Selected " + country);
        } else
            logger.info("Country Selected already ...!");
    }





      public void Dropdown(String name,String Value)   {
        WebElement we = getWebDriver().findElement(By.name(name));
        we.sendKeys(Value);
    }


}