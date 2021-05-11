package com.englishtown.newhouse.school.pages.home.survey.netpromoterscore;
/**
 * Nikol Nov 2018
 *
 * Note: Step 2 and 3 looks the same so will reuse this for both
 *
 *   Which of the following are negative aspects of EF English Live? (Select up to two)
 *   I can select none and progress on 1 and progress .. once I select 2 then the rest is disabled
 *
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


public class NpsStep2Page extends BaseNetPromoteScorePage {
    public static final Logger logger = LoggerFactory.getLogger(BaseNetPromoteScorePage.class);
    //public static final String pageUrl = "/1/campus/core/surveywidget/gateway?token=MzczODQ4NzY=&surveyId=90&source=Mypage";


    protected final String ACTIVE_QUESTIONS_CSS = ".question-list .active";
    protected final String CHECKBOX_SECTION_CSS = ACTIVE_QUESTIONS_CSS + " .checkbox-list";
    protected final String NEXT_BUTTON_CSS = CHECKBOX_SECTION_CSS + " button";
    // radio-buttons
    protected final String CHECKBOX_LIST_CSS = CHECKBOX_SECTION_CSS + " .checkbox label";


    @FindBy(css = CHECKBOX_SECTION_CSS)
    public WebElement checkboxSectionWe;

    @FindBy(css = CHECKBOX_LIST_CSS)
    public List<WebElement> checkboxListWe;

    @FindBy(css = NEXT_BUTTON_CSS)
    public WebElement nextButtonWe;


    public NpsStep2Page(WebDriver webDriver){
        super(webDriver);
    }
    public NpsStep2Page(WebDriver webDriver, String url) {
        super(webDriver, url);
    }
    public NpsStep2Page(WebDriver webDriver, int waitSec) {
        super(webDriver, waitSec);
    }
    public NpsStep2Page() {
        this(null, null);
    }
    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(checkboxSectionWe);
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public boolean simpleTest() {
        logger.info("simpleTest Assert Main element displayed ...!");
        AssertHelper.assertComponentsDisplayed(checkboxSectionWe);
        return true;
    }

    @Override
    public boolean checkAllPageComponentsDisplayed() {
        logger.info("checkAllPageComponents ...!");
        checkAllPageComponentsDisplayed(checkboxSectionWe, nextButtonWe, checkboxListWe.get(1), checkboxListWe.get(4),
                checkboxListWe.get(6));
        return true;
    }

    public void clickOnIndex(int index){
        click(checkboxListWe.get(index));
    }



}