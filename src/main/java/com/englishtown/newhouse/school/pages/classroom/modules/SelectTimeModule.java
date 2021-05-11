package com.englishtown.newhouse.school.pages.classroom.modules;
/**
 * Nikol Jan 2018
 * Topic section shows plb topic cards in 2 columns
 * model one and reuse
 *
 */
import com.englishtown.helpers.*;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.newhouse.school.pages.core.BaseSchoolPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class SelectTimeModule extends BaseSchoolPage {

    public static final Logger logger = LoggerFactory.getLogger(SelectTimeModule.class);
    public static final String pageUrl = "/campus/class-booking/index?type=School.BookPL.2012#step=0";

    public final String timeSectionCss        = "plb-time";
    public final String currentTimeZoneCss    = "plb-timezone-current";
    public final String timeTabsListCss       = ".plb-time-tabs li";
    public final String mainTimePickerCss     = "plb-time-picker-main";
    public final String timePickerMainLeadCss = "plb-time-picker-main-lead";
    public final String timeSlotDayAndDateListCss = "plb-time-timeslots-lead";
    public final String timeSlotsAvailableListCss = ".plb-time-timeslots li";
    public final String teacherCardsListCss = " #spacificTeacher .swiper-wrapper>div";


    @FindBy(className = timeSectionCss)
    public WebElement timeSectionWe;

    @FindBy(className = currentTimeZoneCss)
    public WebElement currentTimeZoneWe;

    // 0 for all available tab and 1 for Specific teacher and this is active by default
    @FindBy(css = timeTabsListCss)
    public List<WebElement> timeTabsListWe;

    /**
     * Teacher cards
     * 3 teachers are shown fist one selected by default
     * time for that teacher is shown so students can book
     */
    @FindBy(css = teacherCardsListCss)
    public List<WebElement> teacherCardsListWe;    // click to select a teacher or see time


    /**
     * Book a time section
     */
    @FindBy(className = mainTimePickerCss)
    public WebElement mainTimePickerSectionWe;

    @FindBy(className = timePickerMainLeadCss)
    public WebElement timePickerMainLeadWe; // shows the name of the teacher on top of select time section

    @FindBy(className = timeSlotDayAndDateListCss)
    public List<WebElement> timeSlotDayAndDateListWe;   // day and date available e.g SATURDAY 10 FEBRUARY

    @FindBy(css = timeSlotsAvailableListCss)
    public List<WebElement> timeSlotsAvailableListWe;    // on mouse over select is shown .. shows time

    /**
     * Search for teacher
     */
    @FindBy(className = "plb-search-input")
    public WebElement searchForTeacherTxtWe;

    @FindBy(className = "plb-search-button")
    public WebElement searchIconBtnWe;           // search happen as you type and is shown underneath

    @FindBy(className = "plb-search-no-record-message")
    public WebElement teacherNotExistingMsgWe;

//teacher Profile

    @FindBy(css = ".teacher-active .teacher-card-name")
    public WebElement teacherCardNameWe;//teacher-profile-intro

    @FindBy(css = ".teacher-active .teacher-card-avatar")
    public WebElement teacherProfileImageWe;

    @FindBy(css = ".teacher-active .teacher-profile-intro")
    public WebElement teacherProfileSelfIntroWe;//teacher-profile-intro

    @FindBy(css = "teacher-profile-detail")
    public WebElement teacherProfileDetailWe;

    @FindBy(css = ".teacher-active .teacher-profile-interest")
    public WebElement teacherProfilePersonalInterestWe;

    @FindBy(css = ".teacher-active .teacher-profile-button")
    public WebElement teacherProfileShowLessBtnWe;


    //teacher searchbox

//    @FindBy(css = ".plb-input.plb-search-input")
//    public WebElement searchTeacherBoxWe;

    @FindBy(css = ".plb-search-result-item-shown")//
    public List<WebElement> teacherResultWe;



    // on search result is shown underneath all matches including not available
    @FindBy(css = ".plb-search-result-list .plb-search-result-profile")
    public List<WebElement> teacherSearchResultAllListWe;

    //plb-search-result-item status-Available plb-search-result-item-shown
    @FindBy(css = ".plb-search-result-item.status-Available")
    public List<WebElement> resultAvailableTeacherListWe;

    //plb-search-result-item status-NotAvailableAtAll plb-search-result-item-shown
    @FindBy(css = ".plb-search-result-item.status-NotAvailableAtAll")
    public List<WebElement> resultNotAvailableTeacherListWe;

    @FindBy(css = ".plb-glyphicon-arrow-right")
    public WebElement rightTimeArrowWe;

    @FindBy(css = ".plb-time-date.plb-time-date-enable.swiper-slide-visible")
    public List<WebElement> dateSlotsWe;




    ///-------------------------------------------------------------------------------------

    public SelectTimeModule(WebDriver webDriver){
        super(webDriver);
    }

    public SelectTimeModule(WebDriver webDriver, String url) {
        super(webDriver, url);
    }

    public SelectTimeModule(WebDriver webDriver, int timeoutSeconds) {
        super(webDriver, timeoutSeconds);
    }

    public SelectTimeModule() {
        this(null, null);
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(mainTimePickerSectionWe);
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public boolean simpleTest() {
        logger.info("simpleTest Assert Main element displayed ...!");
        WaitTool.waitForElementClickable_fluentWait(getWebDriver(),mainTimePickerSectionWe, WaitToolConfig.LONG_WAIT_4_ELEMENT,1000);
        AssertHelper.assertComponentsDisplayed(mainTimePickerSectionWe);
        return true;
    }

    @Override
    public boolean checkAllPageComponentsDisplayed() {
        logger.info("checkAllPageComponents ...!");
        checkAllPageComponentsDisplayed( mainTimePickerSectionWe);
        return true;
    }

    //--------------------------------------------------------------------------------------
    /**
     *
     *
     */
    public void selectTeacherCard(int index){
        logger.info("click to selectTeacherCard ...!");
        click(teacherCardsListWe.get(index));
    }


    public void selectTimeSlot(int index){
        logger.info("selectTimeSlot ...! index:"+index);
        click(timeSlotsAvailableListWe.get(index));
    }



    public void searchForTeacherInSearchBox(String teacherName){
        logger.info("searchForTeacher "+teacherName);
        WebElementHelper.clearAndsendKeys(getWebDriver(),searchForTeacherTxtWe,teacherName,false);

    }

    public String getTeacherNotExistingMessage() {
        logger.info("get the Message after searching for teacher");
        return TestUtil.getWebElementText(teacherNotExistingMsgWe);
    }



    public void selectTeacherFromResults(){
        logger.info("selectTeacherFromResults");
        WaitTool.waitForElementVisible(getWebDriver(), By.className("plb-search-result-profile"),25);
        click(WaitTool.findElement(getWebDriver(), By.className("plb-search-result-profile")));
        //JavaScriptHelper.click(getWebDriver(),".plb-search-result-profile");
        sleep(1000);
    }
    public boolean foundTeacher(){
        logger.info("foundTeacher ...!");
        boolean result = false;

        if(null != teacherSearchResultAllListWe && !teacherSearchResultAllListWe.isEmpty())
            result = true;

        return result;
    }

    public boolean foundActiveTeacher(){
        logger.info("foundActiveTeacher ...!");
        boolean result = false;

        if(null != resultAvailableTeacherListWe && !resultAvailableTeacherListWe.isEmpty()) {
            result = true;
            logger.info("Active Teacher found ...!");
        }

        return result;
    }

    public boolean foundNotActiveTeacher(){
        logger.info("foundNotActiveTeacher ...!");
        boolean result = false;

        if(null != resultNotAvailableTeacherListWe && !resultNotAvailableTeacherListWe.isEmpty()) {
            result = true;
            logger.info("Teacher Not active Found ...!");
        }

        return result;
    }

    //teacher profile

    public void checkAllcomponentTeacherProfile(String teacherName){
        logger.info("checkAllcomponentTeacherProfile");
        WaitTool.waitForElementClickable_fluentWait(getWebDriver(),teacherProfilePersonalInterestWe, WaitToolConfig.LONG_WAIT_4_ELEMENT,1000);
        checkAllPageComponentsDisplayed(teacherProfilePersonalInterestWe,teacherProfileShowLessBtnWe,teacherProfileSelfIntroWe,teacherCardNameWe,teacherProfileImageWe);

    }

    public void clickOnShowLessBtnWe(){
        logger.info("clickOnShowLessBtnWe");
        click(teacherProfileShowLessBtnWe);

    }


}
