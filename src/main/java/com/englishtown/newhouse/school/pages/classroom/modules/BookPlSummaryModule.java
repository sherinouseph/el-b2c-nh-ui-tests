package com.englishtown.newhouse.school.pages.classroom.modules;
/**
 * Nikol Jan 2018
 * after selecting topic and time per teacher booking summary is shown
 * topic, time, edit each of them and book button and Available lesson shown
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

import java.util.List;


public class BookPlSummaryModule extends BaseSchoolPage {

    public static final Logger logger = LoggerFactory.getLogger(BookPlSummaryModule.class);
    public static final String pageUrl = "/campus/class-booking/index?type=School.BookPL.2012#step=0";

    private final String editTimeTopicListCss  = ".statusbar-edit";
    private final String bookThisClassBtnCss  = ".plb-btn-primary .plb-review-btn-text";//.plb-review-btn .plb-btn-primary
    private final String termAndConditionCss  = ".plb-terms";
    private final String noOfPLLeftInfoCss  = ".plb-review-left-coupon";
    private final String topicNameAndTopicTimeCss  = ".statusbar-selected-text";
    private final String classDurationCss  = ".statusbar-title-class-duration";



    @FindBy(css = editTimeTopicListCss)
    public List<WebElement> editTimeTopicListWe;   // edit topic and edit time

    @FindBy(css = bookThisClassBtnCss)
    public WebElement bookThisClassBtnWe;

    @FindBy(css = termAndConditionCss)
    public WebElement termAndConditionWe;

    @FindBy(css = termAndConditionCss)
    public WebElement noOfPLLeftInfoWe;

    @FindBy(css = topicNameAndTopicTimeCss) //topic and time name
    public List<WebElement> topicNameAndTimeCssWe;

    @FindBy(css = classDurationCss)
    public WebElement classDurationWe;

    @FindBy(css = ".statusbar-title-extras")
    public List<WebElement> teacherName;


    ///-------------------------------------------------------------------------------------

    public BookPlSummaryModule(WebDriver webDriver){
        super(webDriver);
    }

    public BookPlSummaryModule(WebDriver webDriver, int timeoutSec) {
        super(webDriver, timeoutSec);
    }

    public BookPlSummaryModule(WebDriver webDriver, String url) {
        super(webDriver, url);
    }

    public BookPlSummaryModule() {
        this(null, null);
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(editTimeTopicListWe.get(0));
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public boolean simpleTest() {
        logger.info("simpleTest Assert Main element displayed ...!");
        AssertHelper.assertComponentsDisplayed(bookThisClassBtnWe);
        return true;
    }

    @Override
    public boolean checkAllPageComponentsDisplayed() {
        logger.info("checkAllPageComponents ...!");
        checkAllPageComponentsDisplayed(
                bookThisClassBtnWe, editTimeTopicListWe.get(0), editTimeTopicListWe.get(1), termAndConditionWe,noOfPLLeftInfoWe,topicNameAndTimeCssWe.get(0),topicNameAndTimeCssWe.get(1),classDurationWe,teacherName.get(1));
        return true;
    }

    public boolean checkAllPageComponentsDisplayedEFTV() {
        logger.info("checkAllPageComponents ...!");
        checkAllPageComponentsDisplayed(
                bookThisClassBtnWe, editTimeTopicListWe.get(1), termAndConditionWe,noOfPLLeftInfoWe,topicNameAndTimeCssWe.get(0),topicNameAndTimeCssWe.get(1),classDurationWe,teacherName.get(1));
        return true;
    }

    //--------------------------------------------------------------------------------------
    /**
     *
     *
     */
    public void clickEditTopic(int index){
        logger.info("clickEditTopic ...!");
        click(editTimeTopicListWe.get(index));
    }

    public void clickEditTime(int index){
        logger.info("clickEditTime ...!");
        click(editTimeTopicListWe.get(index));
    }

    public void clickBookThisClassBtn(){
        logger.info("clickBookThisClassBtn ...!");
        click(bookThisClassBtnWe);  // goes to current booking
    }


}
