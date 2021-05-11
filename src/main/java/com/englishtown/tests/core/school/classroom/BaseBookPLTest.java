package com.englishtown.tests.core.school.classroom;
/**
 *  TC-49194:Book a Private Class
 *  1. Check topic contend and Select topic
 *  2. Select Time
 *  3. Check Summary page
 *  4. click on Edit time and search for a teacher does not exist
 *  5. Search for an Active teacher and select that teacher
 *  6. check teacher profile
 *  TODO: [Do not book as we need a test teacher to book with]
 *  TODO: create another test for more testing this page ... extended test
 *
 * User: nikol.marku
 * Date: 02/02/18
 *
 *
 */
import com.englishtown.enumpack.modules.TopicCardDetails;
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.MyWebDriverAction;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.newhouse.school.pages.classroom.BookPrivateLessonPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public abstract class BaseBookPLTest extends BaseClassroomTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseBookPLTest.class);
    protected String teacherName="test should init this";
    protected String teacherNotExistingMsg="Üzgünüz, hiçbir";





    @Test (dependsOnMethods = "checkUserIsAtSchoolHomePage")
    public void goToBookPrivateClassPage(){
        initSchoolHeaderAndFooter();
        schoolHeaderAndFooterPage.schoolHeaderPage.goToBookPrivateClass();
        bookPrivateLessonPage = new BookPrivateLessonPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        bookPrivateLessonPage.getPageLoadedCondition();
        bookPrivateLessonPage.simpleTest();
    }

    @Test (dependsOnMethods = "goToBookPrivateClassPage")
    private void checkSelectTopicSectionShown(){
        AssertHelper.assertThat("User page is not at step 1 ; Select a topic is not active step ..!",
                bookPrivateLessonPage.isActiveStep("1"));
        bookPrivateLessonPage.checkSelectTopicSection();
    }

    @Test (dependsOnMethods = "checkSelectTopicSectionShown")
    private void checkTopicCardAllDetails(){
        logger.info("checkTopicCardAllDetails all topic card details ...");
        bookPrivateLessonPage.topicCardModule.checkAllTopicCardsElementsDisplayed(selectTopicIndex, false);
    }

    @Test (dependsOnMethods = "checkTopicCardAllDetails")
    private void selectTopicCard_checkTimeStepActive(){
        logger.info("selectTopicCard_checkTimeStepActive ...");
        click(bookPrivateLessonPage.topicCardModule.getCardElement(selectTopicIndex, TopicCardDetails.SELECT));
        logger.info("checkSelectTimeShown  ...");
        bookPrivateLessonPage = new BookPrivateLessonPage(getWebDriver());
        bookPrivateLessonPage.getPageLoadedCondition();
        waitForElementCondition(ExpectedConditions.elementToBeClickable(bookPrivateLessonPage.activeStepWe), getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        AssertHelper.assertThat("SelectTime should be active and is not ....!",
                bookPrivateLessonPage.isActiveStep("2") );
    }

    /**
     *  TODO add test to ensure selected default teacher should have available time according to the spec 
     */

//    @Test (dependsOnMethods = "selectTopicCard_checkTimeStepActive")
//    private void clickSelectAllAvailableTime(){
//        logger.info("clickSelectAllAvailableTime ...");
//        click(findElements(By.cssSelector(".plb-time-tabs li"), 35).get(0));
//        bookPrivateLessonPage = new BookPrivateLessonPage(getWebDriver());
//        bookPrivateLessonPage.getPageLoadedCondition();
//    }

    @Test (dependsOnMethods = "selectTopicCard_checkTimeStepActive")
    private void selectATime(){
        logger.info("selectATime ...");
        bookPrivateLessonPage.selectTimeModule.simpleTest();
        bookPrivateLessonPage = new BookPrivateLessonPage(getWebDriver(),WaitTool.MED_WAIT_4_ELEMENT);
        WaitTool.waitForElementClickable_fluentWait(getWebDriver(),bookPrivateLessonPage.selectTimeModule.timeSlotsAvailableListWe.get(selectTimeSlotIndex),WaitTool.LONG_WAIT_4_ELEMENT,1000);
        MyWebDriverAction.mouseOver(getWebDriver(), findElement(By.className("statusbar-edit")));
        click(bookPrivateLessonPage.selectTimeModule.timeSlotsAvailableListWe.get(selectTimeSlotIndex));
    }

    @Test (dependsOnMethods = "selectATime")
    private void bookingSummaryPageShown(){
        logger.info("bookingSummaryPageShown ...");
        bookPrivateLessonPage = new BookPrivateLessonPage(getWebDriver());
        bookPrivateLessonPage.bookPlSummaryModule.checkAllPageComponentsDisplayed();
    }

    @Test (dependsOnMethods = "bookingSummaryPageShown")
    private void checkClickToBookIsClickable(){
        logger.info("checkClickToBookIsClickable ...");
        bookPrivateLessonPage = new BookPrivateLessonPage(getWebDriver());
        waitForElementCondition(ExpectedConditions.elementToBeClickable(
                bookPrivateLessonPage.bookPlSummaryModule.bookThisClassBtnWe), getWebDriver(),  WaitTool.MED_WAIT_4_ELEMENT25);
        logger.info("Book this class should be clickable by now ...");

    }

    // TODO ... should we do the search for teachers before selecting pl booking ...
    // Note ...
    @Test (dependsOnMethods = "checkClickToBookIsClickable")
    private void clickOnEditTimeAndSearchTEacher_NotExists() {
        logger.info("clickOnEditTimeAndSearchTEacher_NotExists ...");
        bookPrivateLessonPage.bookPlSummaryModule.clickEditTime(1);
        sleep(1000);
        logger.info("click on specific teacher ...");
        click(findElements(By.cssSelector(".plb-time-tabs li"), 35).get(1));
        bookPrivateLessonPage = new BookPrivateLessonPage(getWebDriver(), 35);
        bookPrivateLessonPage.getPageLoadedCondition();
        bookPrivateLessonPage.selectTimeModule.searchForTeacherInSearchBox("TeacherNotExisting");
        bookPrivateLessonPage = new BookPrivateLessonPage(getWebDriver(), 25);
        AssertHelper.assertStringContains( bookPrivateLessonPage.selectTimeModule.getTeacherNotExistingMessage(),teacherNotExistingMsg,"Message is wrong or not displayed");
        sleep(1000);
    }


    @Test (dependsOnMethods = "clickOnEditTimeAndSearchTEacher_NotExists")
    private void searchForAnActiveTeacherAndSelectTeacher() {
        logger.info("searchforAnActiveTeacher ...");
        bookPrivateLessonPage.selectTimeModule.searchForTeacherInSearchBox(teacherName);
        sleep(1000);
        bookPrivateLessonPage = new BookPrivateLessonPage(getWebDriver(), 25);
        bookPrivateLessonPage.selectTimeModule.selectTeacherFromResults();
        sleep(7000);
        AssertHelper.assertStringContains(TestUtil.getWebElementText(findElement(By.cssSelector(".teacher-active .teacher-card-name"))),teacherName,"searched Teacher is not selected");

    }

    @Test (dependsOnMethods = "searchForAnActiveTeacherAndSelectTeacher")
    private void mouseOverTeacherCardNameAndCheckProfile() {
        logger.info("mouseOverTeacherCardNameAndCheckProfile ...");
        MyWebDriverAction.mouseOver(getWebDriver(),findElement(By.cssSelector(".teacher-card-panel.teacher-available.teacher-active")));
        bookPrivateLessonPage = new BookPrivateLessonPage(getWebDriver(), 25);
        bookPrivateLessonPage.selectTimeModule.checkAllcomponentTeacherProfile(teacherName);
    }

    @Test (dependsOnMethods = "mouseOverTeacherCardNameAndCheckProfile")
    private void clickOnShowLessBtnAndCheckIfProfileDisappears() {
        logger.info("clickOnShowLessBtnandCheckIfProfileDisappears ...");
        bookPrivateLessonPage.selectTimeModule.clickOnShowLessBtnWe();
        bookPrivateLessonPage = new BookPrivateLessonPage(getWebDriver(), 25);
        AssertHelper.assertWebElementNotDisplayed(bookPrivateLessonPage.selectTimeModule.teacherProfileShowLessBtnWe);
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
