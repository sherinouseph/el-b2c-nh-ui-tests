package com.englishtown.newhouse.school.pages.classroom;
/**
 * Nikol Feb 2018
 * Classroom ==> current bookings
 *
 * TODO : check Date, min, video lesson, img, teacher name on booked class section
 */
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WaitToolConfig;
import com.englishtown.helpers.WebElementHelper;
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


public class CurrentBookingsPage extends BaseSchoolPage {

    public static final Logger logger = LoggerFactory.getLogger(CurrentBookingsPage.class);
    public static final String pageUrl = "/evc/mybookings?icid=School.MyBookings.2012";

    public final String currentBookingTitleCss   = ".evc-mybookings-title h4";
    public final String bookALessonCss           = ".evc-btn.btn-primary"; //.evc-nobookings-btn a
    public final String listOfClassesBookedCss   = ".evc-mybookings-list .evc-classinfo";
    public final String cancelLessonCss          = "evc-classinfo-cancellesson";
    public final String classOpenBtnCss          = "evc-hook-enterclass";  // btn when class is open  classname
    public final String classNotOpenBtnCss       = "evc-hook-classnotopen"; // btn when class not open
    public final String cancelBookedLessonBtnCss       = "evc-classinfo-confirmcancel";
    public final String dontCancelBookedLessonBtnCss   = "evc-classinfo-dontcancel";
    public final String cancelDialogTxtWe   = "evc-classinfo-canceldialog-text";




    /**
     * page heading
     */
    @FindBy(css = currentBookingTitleCss)
    public WebElement currentBookingTitleWe;

    /**
     * PL
     * Shown if there are no class booked
     * if clicked goes to book a PL page
     */
    @FindBy(css = bookALessonCss)
    public WebElement bookALessonWe;

    /**
     * If there are/is Classes booked list will have one or more elements
     *
     */
    @FindBy(css = listOfClassesBookedCss)
    public List<WebElement> listOfClassesBookedWe;


   @FindBy(css = ".evc-topicandtime h4")
    public  List<WebElement> bookedPLTopicWe;

    @FindBy(css = ".evc-topicandtime p")
    public  List<WebElement> bookedPLTimeWe;

    @FindBy(css = ".evc-classpreference-teacher")
    public  List<WebElement> teacherNameWe;

    @FindBy(css = ".evc-classpreference-classtype")
    public  List<WebElement> classTypeWe;

    @FindBy(css = ".evc-classinfo-classstatus")
    public  List<WebElement> classStatusWe;

    @FindBy(css = ".evc-classinfo-img-wrap")
    public  List<WebElement> classImageWe;

    //--------------------------------------------------------------------------------------

    public void isBookALessonBtnShown(){
        logger.info("isBookALessonBtnShown ...! Only when there are no bookings");
      WaitTool.waitForElementClickable_fluentWait(getWebDriver(),bookALessonWe, WaitToolConfig.LONG_WAIT_4_ELEMENT,1000);
      AssertHelper.assertWebElementDisplayed(bookALessonWe);
    }

    public WebElement getCancelThisClassLinkWe(int index) {
        WebElement webElement = WebElementHelper.safeFindElement(listOfClassesBookedWe.get(index), By.className(cancelLessonCss));

        if(null == webElement)
            failTest("Cant find cancel link for Web Element ...! index:"+index);

        return webElement;
    }

    public WebElement getClassOpenWe(int index) {
        WebElement webElement = WebElementHelper.safeFindElement(listOfClassesBookedWe.get(index), By.className(classOpenBtnCss));

        if(null == webElement)
            failTest("Cant find classOpenBtnCss Web Element ...! index:"+index+" CSS :"+classOpenBtnCss);

        return webElement;
    }

    public WebElement getCancellationMessage(int index) {
        WebElement webElement = WebElementHelper.safeFindElement(listOfClassesBookedWe.get(index), By.className(classOpenBtnCss));

        if(null == webElement)
            failTest("Cant find classOpenBtnCss Web Element ...! index:"+index+" CSS :"+classOpenBtnCss);

        return webElement;
    }

    public WebElement getClassNotOpenWe(int index) {
        WebElement webElement = WebElementHelper.safeFindElement(listOfClassesBookedWe.get(index), By.className(classNotOpenBtnCss));

        if(null == webElement)
            failTest("Cant find classNotOpenBtnCss Web Element ...! index:"+index+" CSS :"+classNotOpenBtnCss);

        return webElement;
    }

    public WebElement getNoDontCancelBookingBtnWe(int index) {
        WebElement webElement = WebElementHelper.safeFindElement(listOfClassesBookedWe.get(index), By.className(dontCancelBookedLessonBtnCss));

        if(null == webElement)
            failTest("Cant find dontCancelBookedLessonBtnCss Web Element ...! index:"+index+" CSS :"+dontCancelBookedLessonBtnCss);

        return webElement;
    }

    public WebElement getYesCancelBookingBtnWe(int index) {
        WebElement webElement = WebElementHelper.safeFindElement(listOfClassesBookedWe.get(index), By.className(cancelBookedLessonBtnCss));

        if(null == webElement)
            failTest("Cant find cancelBookedLessonBtnCss Web Element ...! index:"+index+" CSS :"+cancelBookedLessonBtnCss);

        return webElement;
    }




    ///-------------------------------------------------------------------------------------

    public CurrentBookingsPage(WebDriver webDriver){
        super(webDriver);
    }
    public CurrentBookingsPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }
    public CurrentBookingsPage(WebDriver webDriver, int waitTimeSec) {
        super(webDriver, waitTimeSec);
    }
    public CurrentBookingsPage() {
        this(null, null);
    }
    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public ExpectedCondition getPageLoadedCondition() {
      WaitTool.waitForElementClickable_fluentWait(getWebDriver(),currentBookingTitleWe, WaitToolConfig.LONG_WAIT_4_ELEMENT,1000);
      return ExpectedConditions.visibilityOf(currentBookingTitleWe);
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public boolean simpleTest() {
        logger.info("simpleTest Assert Main element displayed ...!");
        WaitTool.waitForElementVisible_fluentWait(getWebDriver(),currentBookingTitleWe,WaitTool.MED_WAIT_4_ELEMENT,1000);
       //WaitTool.waitForCondition(ExpectedConditions.visibilityOf(currentBookingTitleWe), getWebDriver(), 25);
//        //WaitTool.waitForCondition(ExpectedConditions.elementToBeClickable(By.cssSelector(currentBookingTitleCss)), getWebDriver(), 25);
//        AssertHelper.assertComponentsDisplayed(currentBookingTitleWe);
        return true;
    }

    @Override
    public boolean checkAllPageComponentsDisplayed() {
        logger.info("checkAllPageComponents ...!");
        checkAllPageComponentsDisplayed( currentBookingTitleWe);
        return true;
    }

    public boolean checkAllComponentsWhenbookingIsDone(int index){
        logger.info("checkAllPageComponents ...!");
        checkAllPageComponentsDisplayed( bookedPLTopicWe.get(index),bookedPLTimeWe.get(index),classImageWe.get(index),classStatusWe.get(index),
                teacherNameWe.get(index),classTypeWe.get(index));
        return true;
    }

    public void  clickOnCancelLink(int index) {
        logger.info("clickOnCancelLink ...!");
        WaitTool.waitForCondition(ExpectedConditions.visibilityOf(getCancelThisClassLinkWe(index)), getWebDriver(), 25);
        click(getCancelThisClassLinkWe(index));
    }

    public void  clickOnCancelConfirmLink(int index) {
        logger.info("clickOnCancelConfirmLink ...!");
        WaitTool.waitForCondition(ExpectedConditions.visibilityOf(getYesCancelBookingBtnWe(index)), getWebDriver(), 40);
        click(getYesCancelBookingBtnWe(index));
    }

    public void  checkDontCancelLinkIsDisplayed(int index) {
        logger.info("clickOnCancelConfirmLink ...!");
        WaitTool.waitForCondition(ExpectedConditions.visibilityOf(getNoDontCancelBookingBtnWe(index)), getWebDriver(), 25);

    }

    public void  checkCancellationMessage(int index) {
        logger.info("clickOnCancelConfirmLink ...!");
        WaitTool.waitForCondition(ExpectedConditions.visibilityOf(getNoDontCancelBookingBtnWe(index)), getWebDriver(), 25);

    }

    public String  getCancelDialogTitle(int index) {
        WebElement cancelDialogTitleWe = WebElementHelper.safeFindElement(listOfClassesBookedWe.get(index), By.cssSelector(cancelDialogTxtWe+" h5" ));

        if(null == cancelDialogTitleWe)
            failTest("Cant find getCancelDialogTitle Web Element ...! index:"+index+" CSS :"+cancelDialogTxtWe);

        return TestUtil.getWebElementText(cancelDialogTitleWe);
    }

    public String  getCancelDialogMessage(int index) {
        WebElement cancelDialogTitleWe = WebElementHelper.safeFindElement(listOfClassesBookedWe.get(index), By.cssSelector(cancelDialogTxtWe+" p" ));

        if(null == cancelDialogTitleWe)
            failTest("Cant find getCancelDialogMessage Web Element ."+cancelDialogTxtWe);

        return TestUtil.getWebElementText(cancelDialogTitleWe);
    }

    public void  checkTopicAndTimeIsDisplayed(int index) {
        logger.info("checkTopicAndTimeIsDisplayed ...!");
        AssertHelper.assertWebElementNotDisplayed(bookedPLTopicWe.get(index));
        AssertHelper.assertWebElementNotDisplayed(bookedPLTimeWe.get(index));
        //TODO check if characters are diaplyed in title and time is displayed


    }

}
