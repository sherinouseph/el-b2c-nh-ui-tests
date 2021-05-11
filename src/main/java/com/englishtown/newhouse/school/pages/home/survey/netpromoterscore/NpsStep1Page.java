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

import java.util.List;


public class NpsStep1Page extends BaseNetPromoteScorePage {
    public static final Logger logger = LoggerFactory.getLogger(BaseNetPromoteScorePage.class);
    //public static final String pageUrl = "/1/campus/core/surveywidget/gateway?token=MzczODQ4NzY=&surveyId=90&source=Mypage";

    protected final String ACTIVE_QUESTIONS_CSS = ".question-list .active";
    protected final String LABELS_list_CSS = ACTIVE_QUESTIONS_CSS + " font font";
    // radio-buttons
    protected final String RADIO_BUTTONS_CSS = ACTIVE_QUESTIONS_CSS + " .radio-buttons";
    protected final String RADIO_BUTTONS_LIST_CSS = RADIO_BUTTONS_CSS + " li";


    @FindBy(css = ACTIVE_QUESTIONS_CSS)          // main section with the questions
    public WebElement activeQuestionSectionWe;

    @FindBy(css = LABELS_list_CSS)               // heading is index 1 .. 2 not possible, 3 high
    public List<WebElement> labelsListWe;

    @FindBy(css = RADIO_BUTTONS_CSS)
    public WebElement radioButtonsSectionWe;

    @FindBy(css = RADIO_BUTTONS_LIST_CSS)
    public List<WebElement> selectionListWe;




    public NpsStep1Page(WebDriver webDriver){
        super(webDriver);
    }
    public NpsStep1Page(WebDriver webDriver, String url) {
        super(webDriver, url);
    }
    public NpsStep1Page(WebDriver webDriver, int waitSec) {
        super(webDriver, waitSec);
    }
    public NpsStep1Page() {
        this(null, null);
    }
    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(radioButtonsSectionWe);
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public boolean simpleTest() {
        super.simpleTest();
        logger.info("simpleTest Assert Main element displayed ...!");
        AssertHelper.assertComponentsDisplayed(radioButtonsSectionWe);
        return true;
    }

    @Override
    public boolean checkAllPageComponentsDisplayed() {
        logger.info("checkAllPageComponents ...!");
        checkAllPageComponentsDisplayed(activeQuestionSectionWe, labelsListWe.get(1), labelsListWe.get(2),
                labelsListWe.get(3), selectionListWe.get(10) );
        return true;
    }

    public void clickOnIndex(int index){
        click(selectionListWe.get(index));
    }



}