package com.englishtown.pages.common.core;
/**
 * Price and package page
 *
 */

import com.englishtown.helpers.AssertHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.hamcrest.number.OrderingComparison.greaterThan;


public class PriceAndPackagekPage extends BaseHeaderAndFooterPage {

    public static final Logger logger = LoggerFactory.getLogger(PriceAndPackagekPage.class);
    public static final String pageUrl = "not int";
    public static int tryusBtnMinNo = 1;

    @FindBy(css = "button") //".btn.btn-primary")
    public List<WebElement> tryUsList;  // about 5 elements

    @FindBy(css = "button.btn-secondary")
    public WebElement consultationBtn;


    public PriceAndPackagekPage(WebDriver webDriver){
        super(webDriver);
    }
    public PriceAndPackagekPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }
    public PriceAndPackagekPage() {
        this(null, null);
    }
    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    public boolean simpleTest() {
        super.simpleTest();
        logger.info(" simpleTest() check try us button more than 2...!");
        int tryUsSize = -1;
        if(tryUsList !=null && !tryUsList.isEmpty()){
            tryUsSize = tryUsList.size();
        }
        AssertHelper.assertThat("Try uk bt should be shown more than one time ...!", tryUsSize, greaterThan(tryusBtnMinNo));
        return true;
    }
    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(tryUsList.get(0));
    }
    public String getPageUrl() {
        return pageUrl;
    }




}
