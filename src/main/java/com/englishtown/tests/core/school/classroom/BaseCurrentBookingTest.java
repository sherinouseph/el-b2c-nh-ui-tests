package com.englishtown.tests.core.school.classroom;
/**
 *
 * User: nikol.marku
 * Date: 06/02/18
 *
 * 1. go to current booking page for a user without booking
 * 2. click book lesson button goes to booking page
 *
 */

import com.englishtown.helpers.WaitTool;
import com.englishtown.newhouse.school.pages.classroom.BookPrivateLessonPage;
import com.englishtown.newhouse.school.pages.classroom.CurrentBookingsPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import static org.hamcrest.core.Is.is;


public abstract class BaseCurrentBookingTest extends BaseClassroomTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseCurrentBookingTest.class);

    @Test (dependsOnMethods = "checkUserIsAtSchoolHomePage")
    public void goToCurrentBookingPage(){
        initSchoolHeaderAndFooter();
        schoolHeaderAndFooterPage.schoolHeaderPage.goToCurrentBooking();
        currentBookingsPage = new CurrentBookingsPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        currentBookingsPage.getPageLoadedCondition();
        currentBookingsPage.simpleTest();
    }

    @Test (dependsOnMethods = "goToCurrentBookingPage")
    public void isBookAlessonButtonShownForUserWithoutBooking(){
        currentBookingsPage.isBookALessonBtnShown();
    }

    @Test (dependsOnMethods = "isBookAlessonButtonShownForUserWithoutBooking")
    public void clickBookALessonCheckPLpage(){
        click(currentBookingsPage.bookALessonWe);
        bookPrivateLessonPage = new BookPrivateLessonPage(getWebDriver(),WaitTool.MED_WAIT_4_ELEMENT);
        sleep(2000);
        bookPrivateLessonPage.simpleTest();
    }





}