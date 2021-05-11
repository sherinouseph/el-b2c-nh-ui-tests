package com.englishtown.tests.core.school.classroom;
/**
 *  Book English fluency Test
 *  Go to book english fluency test page
 *  Verify main components in the page
 *  Select time slot available after one week
 *  Book a fluency class
 *  Go to My bookings and check the fields there
 *  click on Cancel link and cancel the private class booked
 *  Check if Mybooking page shows Book a PL button
 *

 */
import com.englishtown.enumpack.modules.TopicCardDetails;
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.JavaScriptHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WaitToolConfig;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.newhouse.school.pages.classroom.BookEFTVPage;
import com.englishtown.newhouse.school.pages.classroom.BookPrivateLessonPage;
import com.englishtown.newhouse.school.pages.classroom.CurrentBookingsPage;
import com.englishtown.newhouse.school.pages.home.SchoolHomePage;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public abstract class BaseBookPLAndCancelEFTVTest extends BaseClassroomTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseBookPLAndCancelEFTVTest.class);
    protected  int  index=0;
    protected boolean isPLWithin24hrs=false;




    @Test (dependsOnMethods = "checkUserIsAtSchoolHomePage")
    public void goToBookEFTVPage(){
        initSchoolHeaderAndFooter();
        sleep(5000);
        schoolHeaderAndFooterPage.schoolHeaderPage.goToBookEFTV();
        bookEFTVPage = new BookEFTVPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        bookEFTVPage.simpleTest();
        bookEFTVPage.checkAllPageComponentsDisplayed();
        bookEFTVPage.verifyTopicDisplayed("English Fluency Test");
    }

     @Test (dependsOnMethods = "goToBookEFTVPage")
    private void checkTopicAndSelectTime(){
        logger.info("checkTopicAndSelectTime ...");
         bookEFTVPage.selectTimeModule.simpleTest();
        if(!isPLWithin24hrs)
            click(bookEFTVPage.selectTimeModule.dateSlotsWe.get(2));
        bookEFTVPage=new BookEFTVPage(getWebDriver(),WaitTool.MED_WAIT_4_ELEMENT);
        WaitTool.waitForElementClickable_fluentWait(getWebDriver(),bookEFTVPage.selectTimeModule.timeSlotsAvailableListWe.get(selectTimeSlotIndex),WaitToolConfig.LONG_WAIT_4_ELEMENT,1000);
        click(bookEFTVPage.selectTimeModule.timeSlotsAvailableListWe.get(selectTimeSlotIndex));
    }

    @Test (dependsOnMethods = "checkTopicAndSelectTime")
    private void clickOnBookPL(){
        logger.info("clickOnBookPL ...");
        bookEFTVPage = new BookEFTVPage(getWebDriver());
        WaitTool.waitForElementClickable_fluentWait(getWebDriver(),bookEFTVPage.bookPlSummaryModule.bookThisClassBtnWe,WaitToolConfig.MED_WAIT_4_ELEMENT25,1000);
        bookEFTVPage.bookPlSummaryModule.checkAllPageComponentsDisplayedEFTV();
        click( bookEFTVPage.bookPlSummaryModule.bookThisClassBtnWe);
        logger.info("clicked on book PL button successfully");
    }

    @Test (dependsOnMethods = "clickOnBookPL")
    private void checkIfUserIsInMyBookingsPage(){
        logger.info("checkIfUSerIsInMyBookingsPage ...");
        currentBookingsPage = new CurrentBookingsPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
       WaitTool.waitForElementVisible_fluentWait(getWebDriver(),currentBookingsPage.getCancelThisClassLinkWe(index),WaitTool.LONG_WAIT_4_ELEMENT,1000);
        currentBookingsPage.getPageLoadedCondition();
        currentBookingsPage.checkAllComponentsWhenbookingIsDone(index);
       // AssertHelper.assertWebElementDisplayed(currentBookingsPage.getClassNotOpenWe(index));
    }

     @Test (dependsOnMethods = "checkIfUserIsInMyBookingsPage")
    private void clickOnCancel(){
        currentBookingsPage.clickOnCancelLink(index);
        logger.info("check if Dont cancel Lesson Link is displayed ...");
        currentBookingsPage = new CurrentBookingsPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        currentBookingsPage.checkDontCancelLinkIsDisplayed(index);
        currentBookingsPage.checkCancellationMessage(index);
        logger.info("click on confirm cancel link");
        currentBookingsPage.clickOnCancelConfirmLink(index);
    }

    @Test (dependsOnMethods = "clickOnCancel")
    private void verifyCancellation(){
        logger.info("verifyCancellation - check if book a lesson button is displayed in my bookings page");
        currentBookingsPage = new CurrentBookingsPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        currentBookingsPage.simpleTest();
        currentBookingsPage.isBookALessonBtnShown();


    }


}



