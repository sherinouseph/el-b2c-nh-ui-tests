package com.englishtown.newhouse.school.pages.classroom;
/**
 * Nikol Feb 2018
 * Classroom ==> conversation class GL
 *
 * Three main views :
 * 1. countdown view ....
 * 2. Enter Class view for first 10 mins
 * 3. Wait for class to open 16 mins
 *
 * Spec:
 * Enter class is active for first 10 mins
 * Class open in countdown shown 16 mins before class open [enterclass is inactive]
 * Class not open [no countdown]
 */
import com.englishtown.enumpack.ClassroomStatus;
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.newhouse.school.pages.core.BaseSchoolPage;
import org.apache.commons.lang.StringUtils;
import org.eclipse.jetty.util.StringUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class ConversationClassPage extends BaseSchoolPage {

    public static final Logger logger = LoggerFactory.getLogger(ConversationClassPage.class);
    public static final String pageUrl = "/evc/mybookings?icid=School.MyBookings.2012";

    public final String classScheduleDropdownCss   = "dropdown";  // class
    public final String scheduleDaysListCss        = ".dropdown-menu .evc-all-class-list-date";
    public final String scheduleTitleListCss       = ".dropdown-menu .evc-all-class-list-title em";
    public final String downloadPreparationMaterialCss  = ".evc-topic-preview-link a";
    public final String topicImageId         = "topic_image";
    public final String todaysTopicCss       = "evc-topic-title";  //classname
    public final String classroomStatusListCss  = "evc-classroom-status";  //closed, openin, is open,is booked
    public final String countDownMainCss     = ")"; // 00 | 01 | 55
    public final String classStatusMessageListCss = ".evc-hook-class-status-message span";
    public final String enterClassButtonCss       = ".evc-hook-enterclass .evc-btn";   // classname  ".evc-hook-enterclass button";   // classname
    public final String availableClassesTxtCss    = "evc-ui-widget-creditinfo-count";  // available .... : 20
    public final String buyMoreLinkCss            = "evc-ui-widget-creditinfo-buy-link";

    /**
     * show class schedule
     */
    @FindBy(className = classScheduleDropdownCss)
    public WebElement classScheduleDropdownWe;   // on click shows popup

    /**
     * List of days shown [Mon - Sun]
     */
    @FindBy(css = scheduleDaysListCss)
    public List<WebElement> scheduleDaysListWe;

    /**
     * List of Title shown per each day [Mon - Sun]
     */
    @FindBy(css = scheduleTitleListCss)
    public List<WebElement> scheduleTitleListWe;

    /**
     * content  section
     *
     */
    @FindBy(id = topicImageId)
    public WebElement topicImageWe;

    @FindBy(className = todaysTopicCss)
    public WebElement todaysTopicTxtWe;

    /**
     * Shown during countdown
     */
    @FindBy(className = classStatusMessageListCss)
    public WebElement classStatusMessageLisWE;

    /**
     * evc-class-status-description evc-class-status-closetime-within
     * [0] No class is scheduled at this time, but you may come back within one hour for the next class.
     * evc-class-status-description evc-class-status-closetime-morethan
     * [1] No class is scheduled at this time, but you may come back <span></span> hour(s) for the next class.
     * class="evc-class-status-description evc-class-status-preopen"
     * [2] You can enter the class when the countdown ends. Please wait.     [this is the countdown time]
     * evc-class-status-description evc-class-status-opening
     * [3] You can enter during the first 10 minutes of the class.
     */
    @FindBy(className = countDownMainCss)
    public WebElement countDownMainWe;

    /**
     * Classroom status
     * CLASS IS CLOSED
     * CLASS OPENS IN
     * CLASS IS OPEN
     * Your class is booked
     */
    @FindBy(css = classroomStatusListCss)
    public List<WebElement> classroomStatusListWe;  // to check this

    /**
     * Active for first 10 mins of the class start
     * this button can be enabled or disabled disabled="disabled"
     */
    @FindBy(css = enterClassButtonCss)
    public WebElement enterClassButtonWe;

    @FindBy(className = availableClassesTxtCss)
    public WebElement availableClassesTxtWe;

    @FindBy(className = buyMoreLinkCss)
    public WebElement buyMoreLinkWe;


    /**
     * download pdf link
     */
    @FindBy(css = downloadPreparationMaterialCss)
    public WebElement downloadPreparationMaterialWe;


    //--------------------------------------------------------------------------------------
    public void checkClassStatus_TODO(ClassroomStatus status){
        logger.info("Not implementd yer");
        // user ClassroomStatus enum
        //TODO classroomStatusListWe   style="display: inline;"
        // Option 1find the list element that is visible ... and get text

    }


    public void checkClassScheduleDaysAndTitleSize_isSeven(){
        logger.info("checkClassScheduleDaysAndTilte ...!");
        AssertHelper.assertElementSizeEqual(getWebDriver(),scheduleDaysListWe, 7 );
        AssertHelper.assertElementSizeEqual(getWebDriver(),scheduleTitleListWe, 7 );
    }

    /**
     *
     * @return true or false
     */
    public boolean isEnterClassButtonEnabled(){
        return WebElementHelper.isElementEnabled(enterClassButtonWe);
    }

    /**
     * Click enter class button
     */
    public void enterClass(){
        logger.info("click enter Class button ...!");
        click(enterClassButtonWe);
    }

    /**
     *
     * @param numberOfAvailableClasses
     */
    public void checkNunberOfAvailableClasses(String numberOfAvailableClasses){
        logger.info("checkNunberOfAvailableClasses ...! should be [{}]", numberOfAvailableClasses);
        String currentClasses = TestUtil.getWebElementText(availableClassesTxtWe);
        if(StringUtil.isBlank(currentClasses))
            failTest("Can't get Number of classes available ...!");

        AssertHelper.assertThat("Not the expected number of Available Classes ...!",
                StringUtils.equals(numberOfAvailableClasses, currentClasses.trim()));

    }

    /**
     * Download pdf
     */
    public void clickDownloadPreparation(){
        logger.info("clickDownloadPreparation ...!");
        click(enterClassButtonWe);
    }
    ///-------------------------------------------------------------------------------------

    public ConversationClassPage(WebDriver webDriver){
        super(webDriver);
    }
    public ConversationClassPage(WebDriver webDriver, int timeOutSec){
        super(webDriver, timeOutSec);
    }
    public ConversationClassPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }
    public ConversationClassPage() {
        this(null, null);
    }
    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(classScheduleDropdownWe);
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public boolean simpleTest() {
        logger.info("simpleTest Assert Main element displayed ...!");
        AssertHelper.assertComponentsDisplayed(classScheduleDropdownWe);
        WaitTool.waitForCondition(ExpectedConditions.visibilityOf(downloadPreparationMaterialWe), getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        AssertHelper.assertComponentsDisplayed(downloadPreparationMaterialWe);
        return true;
    }

    @Override
    public boolean checkAllPageComponentsDisplayed() {
        logger.info("checkAllPageComponents ...!");
        WaitTool.waitForCondition(ExpectedConditions.visibilityOf(buyMoreLinkWe), getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        checkAllPageComponentsDisplayed(classScheduleDropdownWe, topicImageWe, todaysTopicTxtWe,
               availableClassesTxtWe);//downloadPreparationMaterialWe
        return true;
    }

}
