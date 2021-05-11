package com.englishtown.newhouse.school.pages.classroom;
/**
 *Sherin 22/10/2020
 * book English fluency test class
 */

import com.englishtown.enumpack.ClassTopic;
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WaitToolConfig;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.newhouse.school.pages.classroom.modules.BookPlSummaryModule;
import com.englishtown.newhouse.school.pages.classroom.modules.SelectTimeModule;
import com.englishtown.newhouse.school.pages.classroom.modules.TopicCardModule;
import com.englishtown.newhouse.school.pages.core.BaseSchoolPage;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.util.List;


public class BookEFTVPage extends BaseSchoolPage {

    public static final Logger logger = LoggerFactory.getLogger(BookEFTVPage.class);
    public static final String pageUrl = "evc/pl?type=EFT&icid=School.FluencyClass.2019"; //"/campus/class-booking/index";   //"/campus/class-booking/index?type=School.BookPL.2012#step=0";

    public static final String [] BOOK_STEPS = {"1\nSelect a topic","2\n Pick a time"};

    public TopicCardModule topicCardModule;
    public SelectTimeModule selectTimeModule;
    public BookPlSummaryModule bookPlSummaryModule;


    @FindBy(className = "plb-header-title")
    public WebElement plbHeaderWE;          // EFTV

    @FindBy(className = "plb-header-description")
    public WebElement plbHeaderDescriptionWE;

    @FindBy(className = "plb-glyphicon-calendar")
    public WebElement plbCalendarIconWeWE;

    @FindBy(css = ".statusbar-selected-text")
    public WebElement topicWe;

    @FindBy(css = ".statusbar-title")
    public WebElement topicHeaderWe;

    @FindBy(css = ".plb-glyphicon-tick")
    public WebElement topictickMarkWe;
    //



    //--------------------------------------------------------------------------------------

    public BookEFTVPage(WebDriver webDriver){
        super(webDriver);
        initializeModules();
    }

    public void initializeModules(){
        topicCardModule     = new TopicCardModule(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        selectTimeModule    = new SelectTimeModule(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        bookPlSummaryModule = new BookPlSummaryModule(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT );
    }

    public BookEFTVPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }
    public BookEFTVPage(WebDriver webDriver, int waitTimeSec) {
        super(webDriver, waitTimeSec);
        initializeModules();
    }
    public BookEFTVPage() {
        this(null, null);
    }



    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(plbHeaderWE);
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public boolean simpleTest() {
        logger.info("simpleTest Assert Main element displayed ...!");
        WaitTool.waitForElementClickable_fluentWait(getWebDriver(),plbHeaderWE, WaitToolConfig.LONG_WAIT_4_ELEMENT,1000);
        AssertHelper.assertComponentsDisplayed(plbHeaderWE );
        return true;
    }

    public void verifyTopicDisplayed(String eftvTopic) {
        logger.info("verifyTopicDisplayed ...!");
        AssertHelper.assertStringContains(TestUtil.getWebElementText(topicWe), eftvTopic, "EFTV topic not displayed");

    }
    @Override
    public boolean checkAllPageComponentsDisplayed() {
            logger.info("checkAllPageComponents ...!");
            checkAllPageComponentsDisplayed(plbHeaderWE, plbCalendarIconWeWE,plbHeaderDescriptionWE,topicWe,topicHeaderWe,topictickMarkWe);
            return true;
    }





}
