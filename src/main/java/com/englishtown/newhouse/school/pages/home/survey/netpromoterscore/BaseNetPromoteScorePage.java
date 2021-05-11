package com.englishtown.newhouse.school.pages.home.survey.netpromoterscore;
/**
 * Nikol Nov 2018
 *
 * old house https://qa-englishlive.ef.com/campus/core/surveywidget/gateway?token=MzczODQ4NzY=&surveyId=90&source=Mypage
 * newhouse: https://qa-englishlive.ef.com/1/campus/core/surveywidget/gateway?token=MzczODQ4NzY=&surveyId=90&source=Mypage
 *
 *
 *
 */

import com.englishtown.helpers.AssertHelper;
import com.englishtown.newhouse.school.pages.core.BaseSchoolPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public abstract class BaseNetPromoteScorePage extends BaseSchoolPage {

    public static final Logger logger = LoggerFactory.getLogger(NpsStep1Page.class);
    public static final String pageUrl = "/1/campus/core/surveywidget/gateway?token=MzczODQ4NzY=&surveyId=90&source=Mypage";

    public static final String IFRAME_CSS = "iframe";//".fancybox-iframe";
    protected final String LOGO_CSS = ".logo-content img";
    protected final String CLOSE_IFRAME_CSS = ".fancybox-item.fancybox-close";
    //.fancybox-iframe


    @FindBy(css = IFRAME_CSS)
    public WebElement iframeWe;

    @FindBy(css = LOGO_CSS)
    public WebElement logoWe;

    @FindBy(css = CLOSE_IFRAME_CSS)
    public WebElement closeSurveyWe;


    public BaseNetPromoteScorePage(WebDriver webDriver){
        super(webDriver);
    }
    public BaseNetPromoteScorePage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }
    public BaseNetPromoteScorePage(WebDriver webDriver, int waitSec) {
        super(webDriver, waitSec);
    }
    public BaseNetPromoteScorePage() {
        this(null, null);
    }
    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(logoWe);
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public boolean simpleTest() {
        logger.info("simpleTest Assert Main element displayed ...!");
        AssertHelper.assertComponentsDisplayed(logoWe );
        return true;
    }

    @Override
    public boolean checkAllPageComponentsDisplayed() {
        logger.info("checkAllPageComponents ...!");
        checkAllPageComponentsDisplayed(logoWe, closeSurveyWe);
        return true;
    }


}