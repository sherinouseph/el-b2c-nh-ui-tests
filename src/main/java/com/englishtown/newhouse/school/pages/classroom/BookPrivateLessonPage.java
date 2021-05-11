package com.englishtown.newhouse.school.pages.classroom;
/**
 * Nikol Jan 2018
 * Classroom ==> Book Private Class [ Shows Heading and Select topic section, view all, request topic, pic time is the next step]
 * http://englishlive.ef.com/http://englishlive.ef.com/campus/class-booking/index?type=School.BookPL.2012#step=0
 *
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

import java.util.List;


public class BookPrivateLessonPage extends BaseSchoolPage {

    public static final Logger logger = LoggerFactory.getLogger(BookPrivateLessonPage.class);
    public static final String pageUrl = "/1/evc/pl?icid=School.BookPL.2012"; //"/campus/class-booking/index";   //"/campus/class-booking/index?type=School.BookPL.2012#step=0";

    public static final String [] BOOK_STEPS = {"1\nSelect a topic","2\n Pick a time"};

    public TopicCardModule topicCardModule;
    public SelectTimeModule selectTimeModule;
    public BookPlSummaryModule bookPlSummaryModule;


    @FindBy(className = "plb-header-title")
    public WebElement plbHeaderWE;          // PRIVATE CLASS BOOKING

    @FindBy(css = "[class='statusbar enabled'] .statusbar-number-text") // ".statusbar.enabled")
    public WebElement activeStepWe;        // Select topic or pic a time : get the number to see if step 1 or 2  statusbar-number-text

    //
    @FindBy(css = ".statusbar-edit")
    public List<WebElement> editTopicOrTimeListWe;


    /**
     * Step 1
     *     Topics at 01 Beginner     VIEW ALL LEVELS  ... topics cards
     */

    @FindBy(css = ".current-level span")
    public WebElement currentLevelTxtWe;   // 01 Beginners // this is the Course level the Student is on

    @FindBy(className = "view-all-topics")
    public WebElement viewAllLevelsLinkWe;

    /**
     * Click on view all levels link shows select element with all course levels
     * [business, Toeic beg... 1 -2 3 16Upper Advanced * current level is selected
     *
     */
    @FindBy(className = "select2-selection")
    public WebElement selectCourseLevelTopicWe;          // click this to expand select Window


    @FindBy(css = "plb-select-element")
    public WebElement selectOptionsWe;                  // use this to select  // need to test it

    @FindBy(className = "select2-selection__arrow")
    public WebElement selectCourseLevelTopicArrowWe;     // this is arrow on the side of select element    // plb-select-element select2-hidden-accessible   select with options ...    // select2-results   select2-results__options



    /**
     * Topics cards section
     *
     */
    @FindBy(className = "plb-topic-list")
    public WebElement selectTopicSectionWe;

    /**
     * Request topic  [Should this be on TopicCardDetails ... need to think]
     * when user type and save the topic
     * It replaces select topic step 1
     * and pic time section shown /expanded
     * User can edit it as edit link shown
     */
    @FindBy(className = "extend-open-topic")
    public WebElement requestTopicBtnWe;

    @FindBy(className = "save-open-topic")
    public WebElement enabledRequestSaveTopicWe;

    @FindBy(css = ".save-open-topic.plb-btn-disabled")
    public WebElement disabledRequestSaveTopicWe;   // if no 4 chars or more typed

    // once the above clicked txt area shown
    @FindBy(id = "openTopic")
    public WebElement requestTopicTxtAreaWe;
    // Please enter at least 4 characters click on request topic


    @FindBy(className = "statusbar-edit")
    public WebElement topicCharsCountWe;            // 100 max to 0 users cant type more that 100 chars

    @FindBy(className = "plb-open-topic-countdown")
    public WebElement editTopicLinkWe;               // ??? not sure about this use editTopicOrTimeListWe ...
    // shown when a topic is added ... once clicked shows step 1 select topic


    //--------------------------------------------------------------------------------------

    public BookPrivateLessonPage(WebDriver webDriver){
        super(webDriver);
        initializeModules();
    }

    public void initializeModules(){
        topicCardModule     = new TopicCardModule(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        selectTimeModule    = new SelectTimeModule(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        bookPlSummaryModule = new BookPlSummaryModule(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT );
    }

    public BookPrivateLessonPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }
    public BookPrivateLessonPage(WebDriver webDriver, int waitTimeSec) {
        super(webDriver, waitTimeSec);
        initializeModules();
    }
    public BookPrivateLessonPage() {
        this(null, null);
    }

    /*public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }*/

    public ExpectedCondition getPageLoadedCondition() {
        WaitTool.waitForElementClickable_fluentWait(getWebDriver(),plbHeaderWE, WaitToolConfig.LONG_WAIT_4_ELEMENT,1000);
        return ExpectedConditions.visibilityOf(plbHeaderWE);
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public boolean simpleTest() {
        logger.info("simpleTest Assert Main element displayed ...!");
        AssertHelper.assertComponentsDisplayed(plbHeaderWE );
        return true;
    }

    @Override
    public boolean checkAllPageComponentsDisplayed() {
        logger.info("checkAllPageComponents ...!");
        checkAllPageComponentsDisplayed( plbHeaderWE);
        return true;
    }







    /**
     *
     */
    public String getActiveStep(){
        return TestUtil.getWebElementText(activeStepWe);
    }
    /**
     * 1 - Select a topic or 2 - Pick a time
     * @return
     */
    public boolean isActiveStep(String stepNumber){
        logger.info("isActiveStep ...! no :"+stepNumber);
        if(StringUtils.contains(getActiveStep(), stepNumber))
            return true;
        else
            return false;
    }

    public void checkSelectTopicSection(){
        logger.info("checkSelectTopicSection conatains cards at least 1, viewAllLevelsLinkWe and requestTopicBtnWe ...!");
        checkAllPageComponentsDisplayed(viewAllLevelsLinkWe, requestTopicBtnWe);
        topicCardModule.simpleTest();
    }

    /**
     * User must click to expand the selection window and select
     *
     * @param classTopic
     *
     */
    public void selectTopic(ClassTopic classTopic){
        logger.info("Try to select topic [{}]", classTopic.getClassTopicValue());
        click(selectCourseLevelTopicWe);
        sleep(300);
        WebElementHelper.selectByValue(getWebDriver(), selectOptionsWe, classTopic.getClassTopicValue() );
        logger.info("Topic [{}] selected ...! ", classTopic.getClassTopicValue());
    }


    public String getSelectedTopic(){
        logger.info("getSelectedTopic ...!");
        //click(selectCourseLevelTopicWe);
        sleep(300);
        String selectedTopic = TestUtil.getWebElementText(WebElementHelper.getSelectedOptionWe(selectOptionsWe));
        logger.info("Selected Topic [{}] ...! ", selectedTopic);
        return selectedTopic;
    }

    public void typeOnRequestTopic(String topic){
        sendKey(getWebDriver(), requestTopicTxtAreaWe, topic, true);
    }


}
