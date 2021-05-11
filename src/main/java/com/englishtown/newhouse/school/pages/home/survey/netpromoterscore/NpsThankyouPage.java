package com.englishtown.newhouse.school.pages.home.survey.netpromoterscore;
/**
 * Nikol Nov 2018
 *
 *
 * Have to select 1
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


public class NpsThankyouPage extends BaseNetPromoteScorePage {
    public static final Logger logger = LoggerFactory.getLogger(BaseNetPromoteScorePage.class);
    //public static final String pageUrl = "/1/campus/core/surveywidget/gateway?token=MzczODQ4NzY=&surveyId=90&source=Mypage";
    // .success-message    .icon-success
    //
    protected static final String SUCCESS_MESSAGE_SECTION_CSS = ".success-message"; //.success-message h5
    protected final String SUCCESS_ICON_CSS            = SUCCESS_MESSAGE_SECTION_CSS + " .icon-success";
    protected final String SUCCESS_TEXT_CSS            = SUCCESS_MESSAGE_SECTION_CSS + " h5";
    public static final String UNDERSTAND_BTN_CSS      = SUCCESS_MESSAGE_SECTION_CSS + " button";

    @FindBy(css = SUCCESS_MESSAGE_SECTION_CSS)
    public WebElement successSectionWe;

    @FindBy(css = SUCCESS_ICON_CSS)
    public WebElement successIconWe;

    @FindBy(css = SUCCESS_TEXT_CSS)
    public WebElement successTextWe;

    @FindBy(css = UNDERSTAND_BTN_CSS)
    public WebElement understandBtnWe;


    public NpsThankyouPage(WebDriver webDriver){
        super(webDriver);
    }
    public NpsThankyouPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }
    public NpsThankyouPage(WebDriver webDriver, int waitSec) {
        super(webDriver, waitSec);
    }
    public NpsThankyouPage() {
        this(null, null);
    }
    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(understandBtnWe);
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public boolean simpleTest() {
        super.simpleTest();
        logger.info("simpleTest Assert Main element displayed ...!");
        AssertHelper.assertComponentsDisplayed(understandBtnWe);
        return true;
    }

    @Override
    public boolean checkAllPageComponentsDisplayed() {
        logger.info("checkAllPageComponents ...!");
        checkAllPageComponentsDisplayed(understandBtnWe, successSectionWe, successIconWe, successTextWe, understandBtnWe);
        return true;
    }

    public void clickOn_I_understand(){
        click(understandBtnWe);
    }



}