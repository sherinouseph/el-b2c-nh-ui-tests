package com.englishtown.newhouse.school.pages.support;

//sherin - 31/01/2018
//
// Help center page object  - old house

/**
 * NewHouse Help Page
 *
 * Sherin 04/09/2020
 */

import com.englishtown.helpers.AssertHelper;
import com.englishtown.newhouse.school.pages.core.BaseSchoolPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class HelpCenterPage extends BaseSchoolPage {
    public static final Logger logger  = LoggerFactory.getLogger(HelpCenterPage.class);
    public static final String pageUrl = "helpme.englishlive.ef.com"; //?icid=School.Help.2012";


    @FindBy(css = ".search-input")
    public WebElement searchBarWe;

    @FindBy(css = ".slds-button")
    public WebElement searchBtnWe;

    @FindBy(css = ".search-inputSearchButton")
    public WebElement searchBtnNewHouseWe;



    
    public HelpCenterPage(WebDriver webDriver, int waitSec){
        super(webDriver, waitSec);
    }
    public HelpCenterPage(WebDriver webDriver){
        super(webDriver);
    }
    public HelpCenterPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }
    public HelpCenterPage() {
        this(null, null);
    }
    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }


    @Override
    public boolean checkAllPageComponentsDisplayed() {
        checkAllPageComponentsDisplayed(searchBarWe,searchBtnWe);
        return false;
    }

    public boolean simpleTest() {
        logger.info("check searchbar is displayed...!");
        AssertHelper.assertWebElementDisplayed(searchBarWe);
        return true;
    }

    @Override
    public String getPageUrl() {
        return pageUrl;
    }


}
