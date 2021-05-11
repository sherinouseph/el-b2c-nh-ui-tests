package com.englishtown.tests.core.school.classroom;
/**
 *  TC-49194:Book a Private Class
 *  1. find the total number of private class available from my page
 *  2.Go to book a private class
 *  3.select topic of PL
 *  4.Select BELIVE teacher if the test run on QA/If it runs on live, then click on available timeslot bar
 *  5. select the first timeslot available.(this test expect to select a time within 24 hours)
 *  6.Book PL
 *  7. Go to My page and check the total number of PLS available.It should be the total PL-1
 *  8.Go to My bookings and check the fields there
 *  9.click on Cancel link and cancel the private class booked
 *  10.Check if Mybooking page shows Book a PL button
 *  11. Go to My Page and check the total number of PLs avaialble. IT should be still number of PLs available-1 as we dont refund the coupon if the user cancels the class within 24 hours
 *
 *
 *
 * User: sherin.ouseph
 * Date:09/04/2019
 *
 *
 */
import com.englishtown.enumpack.modules.TopicCardDetails;
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.JavaScriptHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WaitToolConfig;
import com.englishtown.newhouse.school.pages.classroom.BookPrivateLessonPage;
import com.englishtown.newhouse.school.pages.classroom.CurrentBookingsPage;
import com.englishtown.newhouse.school.pages.home.SchoolHomePage;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public abstract class BaseBookPLAndCancelPLTest extends BaseClassroomTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseBookPLAndCancelPLTest.class);
    protected String noOfPLsAvailable;
    protected  int  index=0;
    protected boolean isPLWithin24hrs=false;
    protected String teachername="f f.BELive";



    @Test (dependsOnMethods = "checkUserIsAtSchoolHomePage")
    public void getNoOfPLSAvailableInMyPage(){
        logger.info("checkNoOfPLSAvailableInMyPage ...");
        schoolHomePage=new SchoolHomePage(getWebDriver(),WaitTool.MED_WAIT_4_ELEMENT);
        schoolHomePage.simpleTest();
        noOfPLsAvailable=schoolHomePage.getNoOfPLSLeft();
        logger.info("number of PLs available " +noOfPLsAvailable);
    }

    @Test (dependsOnMethods = "getNoOfPLSAvailableInMyPage")
    public void goToBookPrivateClassPage(){
        initSchoolHeaderAndFooter();
        schoolHeaderAndFooterPage.schoolHeaderPage.goToBookPrivateClass();
        bookPrivateLessonPage = new BookPrivateLessonPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        bookPrivateLessonPage.getPageLoadedCondition();

    }

    @Test (dependsOnMethods = "goToBookPrivateClassPage")
    private void selectTopicCard_checkTimeStepActive(){
        logger.info("selectTopicCard_checkTimeStepActive ...");
        click(bookPrivateLessonPage.topicCardModule.getCardElement(selectTopicIndex, TopicCardDetails.SELECT));
        logger.info("checkSelectTimeShown  ...");
        bookPrivateLessonPage = new BookPrivateLessonPage(getWebDriver());
        bookPrivateLessonPage.getPageLoadedCondition();
    }

    @Test (dependsOnMethods = "selectTopicCard_checkTimeStepActive")
    private void selectATeacherAndTime(){
        logger.info("selectATime ...");
        clickOnAllAvailableTimes();
        //selectTeacher(teachername);
        bookPrivateLessonPage=new BookPrivateLessonPage(getWebDriver(),25);
        bookPrivateLessonPage.selectTimeModule.simpleTest();
        if(!isPLWithin24hrs)
        click(bookPrivateLessonPage.selectTimeModule.dateSlotsWe.get(2));
        bookPrivateLessonPage=new BookPrivateLessonPage(getWebDriver(),WaitTool.MED_WAIT_4_ELEMENT);
        WaitTool.waitForElementClickable_fluentWait(getWebDriver(),bookPrivateLessonPage.selectTimeModule.timeSlotsAvailableListWe.get(selectTimeSlotIndex),WaitToolConfig.LONG_WAIT_4_ELEMENT,1000);
        click(bookPrivateLessonPage.selectTimeModule.timeSlotsAvailableListWe.get(selectTimeSlotIndex));
    }


    @Test (dependsOnMethods = "selectATeacherAndTime")
    private void clickOnBookPL(){
        logger.info("clickOnBookPL ...");
        bookPrivateLessonPage = new BookPrivateLessonPage(getWebDriver());
        WaitTool.waitForElementClickable_fluentWait(getWebDriver(),bookPrivateLessonPage.bookPlSummaryModule.bookThisClassBtnWe,WaitToolConfig.MED_WAIT_4_ELEMENT25,1000);
//        waitForElementCondition(ExpectedConditions.elementToBeClickable(
//                bookPrivateLessonPage.bookPlSummaryModule.bookThisClassBtnWe), getWebDriver(),  WaitTool.MED_WAIT_4_ELEMENT25);
        click( bookPrivateLessonPage.bookPlSummaryModule.bookThisClassBtnWe);
        logger.info("clicked on book PL button successfully");
    }

    @Test (dependsOnMethods = "clickOnBookPL")
    private void checkIfUserIsInMyBookingsPage(){
        logger.info("checkIfUSerIsInMyBookingsPage ...");
        currentBookingsPage = new CurrentBookingsPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        WaitTool.waitForElementVisible_fluentWait(getWebDriver(),currentBookingsPage.currentBookingTitleWe,WaitTool.LONG_WAIT_4_ELEMENT,1000);
       sleep(4000);

//        waitForElementCondition(ExpectedConditions.visibilityOf(
//                currentBookingsPage.getClassNotOpenWe(index)), getWebDriver(),  WaitTool.LONG_WAIT_4_ELEMENT);
       // currentBookingsPage.getPageLoadedCondition();
       // currentBookingsPage.checkAllComponentsWhenbookingIsDone(index);
       // AssertHelper.assertWebElementDisplayed(currentBookingsPage.getClassNotOpenWe(index));

    }


    @Test (dependsOnMethods = "checkIfUserIsInMyBookingsPage")
    private void checkNoOfPLsAvailable(){
        logger.info("checkNoOfPLsAvailable ...");
         click(findElement(By.className("ue-logo")));
        schoolHomePage=new SchoolHomePage(getWebDriver(),WaitTool.MED_WAIT_4_ELEMENT);
        WaitTool.waitForElementVisible_fluentWait(getWebDriver(),schoolHomePage.currentLevelNameWe,WaitTool.SHORT_WAIT_4_ELEMENT,1000);
//        waitForElementCondition(ExpectedConditions.visibilityOf(
//                schoolHomePage.currentLevelNameWe), getWebDriver(),  WaitTool.MED_WAIT_4_ELEMENT);
        logger.info("Check if PL get reduced in My Page");
        int noOfPLsLeft= Integer.valueOf(noOfPLsAvailable)-1;
        schoolHomePage.checkPLLeft(String.valueOf(noOfPLsLeft));
    }


    @Test (dependsOnMethods = "checkNoOfPLsAvailable")
    private void goToMybookingsandclickOnCancel(){
        logger.info("goToMybookingsandclickOnCancel");
        openPageUrl(currentBookingsPage);
        currentBookingsPage = new CurrentBookingsPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        currentBookingsPage.simpleTest();
        currentBookingsPage.clickOnCancelLink(index);
        logger.info("check if Dont cancel Lesson Link is displayed ...");
        currentBookingsPage = new CurrentBookingsPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        currentBookingsPage.checkDontCancelLinkIsDisplayed(index);
        currentBookingsPage.checkCancellationMessage(index);
        logger.info("click on confirm cancel link");
        currentBookingsPage.clickOnCancelConfirmLink(index);
    }

    @Test (dependsOnMethods = "goToMybookingsandclickOnCancel")
    private void verifyCancellation(){
        logger.info("verifyCancellation - check if book a lesson button is displayed in my bookings page");
        currentBookingsPage = new CurrentBookingsPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        currentBookingsPage.simpleTest();
        currentBookingsPage.isBookALessonBtnShown();
        click(findElement(By.className("ue-logo")));
        schoolHomePage=new SchoolHomePage(getWebDriver(),60);
        logger.info("Check if PL get added in My Page");
        if(!isPLWithin24hrs)
        schoolHomePage.checkPLLeft(noOfPLsAvailable);
        else{
            int noOfPLsLeft= Integer.valueOf(noOfPLsAvailable)-1;
            logger.info("number of PLS left - No refund ="+noOfPLsLeft);
            schoolHomePage.checkPLLeft(String.valueOf(noOfPLsLeft));
        }

    }
public void clickOnAllAvailableTimes(){
    WaitTool.waitForElementClickable_fluentWait(getWebDriver(),findElement(By.cssSelector("a[href='#allAvailable']")),WaitToolConfig.LONG_WAIT_4_ELEMENT,1000);
    sleep(15000);
    JavaScriptHelper.scrollToXY(getWebDriver(),0,-6000);
//    Actions actions = new Actions(getWebDriver());
//    actions.moveToElement(findElement(By.cssSelector("a[href='#allAvailable']")));
//    actions.perform();
//    sleep(8000);
    getWebDriver().findElement(By.cssSelector("a[href='#allAvailable']")).click();
    WaitTool.waitForElementClickable_fluentWait(getWebDriver(),findElement(By.cssSelector(".plb-glyphicon-arrow-right")), WaitToolConfig.LONG_WAIT_4_ELEMENT,1000);
}

    public void selectTeacher(String teachername){
        int length=findElements(By.className("teacher-card-name")).size();
        for(int i=0;i<=length;i++){
            if(StringUtils.contains(findElements(By.className("teacher-card-name")).get(i).getText(),teachername)){
                click(findElements(By.cssSelector(".operation-bar-item.button-active")).get(i));
                break;
            }
        }

        }


}





    /*@Test (dependsOnMethods = "selectTopicCard_checkTimeStepActive")
    private void clickEditCard_ExpandItAndCheckAllDetails_andSelectIt(){
        logger.info("clickEditCard_ExpandItAndCheckAllDetails_andSelectIt  ...");

        bookPrivateLessonPage = new BookPrivateLessonPage(getWebDriver());
        bookPrivateLessonPage.simpleTest();
        // note this take you back to home page not the previous step .. backward(getWebDriver());
        scrollToWeAndClick(getWebDriver(), bookPrivateLessonPage.editTopicOrTimeListWe.get(0), 0, 300);
        logger.info("Click more to expand card ...! Index : "+selectTopicIndex+1);
        click(bookPrivateLessonPage.topicCardModule.getCardElement(selectTopicIndex+1, TopicCardDetails.LEARNMORE));
        bookPrivateLessonPage.topicCardModule.checkAllCardsElementsDisplayed(selectTopicIndex, true);

        click(bookPrivateLessonPage.topicCardModule.getCardElement(selectTopicIndex, TopicCardDetails.EXPAND_SELECT_TOPIC));
    }

    @Test(dependsOnMethods = "clickEditCard_ExpandItAndCheckAllDetails_andSelectIt")
    public void checkSelectTimeIsActiveAfterCardSelectedAgain(){
        logger.info("checkSelectTimeIsActiveAfterCardSelectedAgain ...!");
        AssertHelper.assertThat("SelectTime should be active and is not ....!",
                is(bookPrivateLessonPage.isActiveStep("2")) );
    }*/
