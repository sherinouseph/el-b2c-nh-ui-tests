package com.englishtown.tests.core.school.course.appsandtools.grammarlab;
/**
 * Nikol May 2018
 *
 * 1. Goto Apps and tools and click grammar lab
 * 2. Check Grammarlab page shows topics and topic number
 *
 *
 *
 * todo: BREADCRUMB TEST
 *
 */

import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WebDriverWindowHelper;
import com.englishtown.newhouse.school.pages.course.appsandtools.grammarlab.GrammarlabPage;
import com.englishtown.tests.core.school.BaseSimpleLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public abstract class BaseGrammarLabTest extends BaseSimpleLogin {
    private static final Logger logger = LoggerFactory.getLogger(BaseGrammarLabTest.class);

    protected int topicIndex  = 0;  // check and click
    protected int lessonIndex = 0;
    protected int numberOfTopics = 15;
    protected int numberOfLessonsPerTopic = 5;  // 5 Lessons
    protected String topicSubjectToSelect = "Present"; // this is the first one

    @Test(dependsOnMethods = "checkUserIsAtSchoolHomePage")
    protected void goToAppsAndToolsAndClickGrammarLabLink() {
        logger.info("goToAppsAndToolsAndClickGrammarLabLInk ...! ");
        initSchoolHeaderAndFooter();
        schoolHeaderAndFooterPage.schoolHeaderPage.goToAppsAndTools();
        initAppsAndToolsPage();
        appsAndToolsPage.goToGrammarLab();
    }

    @Test(dependsOnMethods = "goToAppsAndToolsAndClickGrammarLabLink")
    protected void checkGrammarLabPageAndListOfTopics() {
        logger.info("checkGrammarLabPage");
        initGrammarLabPage();
        grammarlabPage.grammarLabTopicModulePage.checkNumberOfTopicCards(numberOfTopics);
    }

    @Test(dependsOnMethods = "checkGrammarLabPageAndListOfTopics")
    protected void checkFirstTopicAllContent() {
        logger.info("checkFirstTopicAllContent ....!");
        grammarlabPage.grammarLabTopicModulePage.checkAllCardsElementsDisplayed(topicIndex);
    }

    @Test(dependsOnMethods = "checkFirstTopicAllContent")
    protected void checkNumberOfTopicsLabel() {
        logger.info("checkNumberOfTopics [{}] ...!", numberOfTopics);
        grammarlabPage.checkNumberOfTopics(numberOfTopics);
    }

    @Test(dependsOnMethods = "checkFirstTopicAllContent")
    protected void checkNumberOfTopicsCardsShown() {
        logger.info("checkNumberOfTopicsCardsShown ....!");
        grammarlabPage.grammarLabTopicModulePage.checkNumberOfTopicCards(numberOfTopics);
    }

    @Test(dependsOnMethods = "checkFirstTopicAllContent")
    protected void checkNumberOfLessonsPerTopic() {
        logger.info("checkNumberOfLessonsPerTopic ....!");
        grammarlabPage.grammarLabTopicModulePage.checkNumberOfLessonsPerTopic(topicIndex, numberOfLessonsPerTopic);
    }

    @Test(dependsOnMethods = "checkFirstTopicAllContent")
    protected void checkDescriptionPerTopicNotEmptyNull() {
        logger.info("checkNumberOfLessonsPerTopic ....!");
        grammarlabPage.grammarLabTopicModulePage.checkTopicDescriptionContainsText(topicIndex);
    }

    // go to lessons
    @Test(dependsOnMethods = "checkNumberOfTopicsLabel")
    protected void clickGetStartedOnTopic() {
        logger.info("clickGetStartedOnTopic [{}] ...!", topicIndex);
        grammarlabPage.clickGetStartedOnTopic(topicIndex);
    }

    @Test(dependsOnMethods = "clickGetStartedOnTopic")
    protected void checkLessonContentCard(){
        logger.info("checkLessonContentCard [{}] ...!", topicIndex);
        grammarlabPage = new GrammarlabPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        grammarlabPage.assertStringContainsNumber(numberOfLessonsPerTopic);
        grammarlabPage.grammarLabTopicLessonModulePage.checkAllCardsElementsDisplayed(lessonIndex);
    }

    @Test(dependsOnMethods = "checkLessonContentCard")
    protected void clickStartLesson(){
        logger.info("clickStartLesson [{}] ...!", lessonIndex);
        grammarlabPage.clickGetStartedOnLesson(lessonIndex);
        sleep(3000);

    }


    @Test(dependsOnMethods = "clickStartLesson")
    protected void clickNextTrooperJsApp(){
        logger.info("clickNextAndCloseLessonTrooperJsApp ...!");
        waitForElementCondition(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div iframe")), getWebDriver(), WaitTool.PAGELOAD_TIMEOUT_45);

        WebDriverWindowHelper.switchToFrameByFrameWebElement(getWebDriver(), By.cssSelector("div iframe"));

        String iframeCss = ".ets-btn.ets-btn-fn-next.ets-show";
        waitForElementCondition(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(iframeCss)), getWebDriver(), WaitTool.PAGELOAD_TIMEOUT_45);
        waitForElementCondition(ExpectedConditions.elementToBeClickable(By.cssSelector(iframeCss)), getWebDriver(), WaitTool.PAGELOAD_TIMEOUT_45);
        sleep(1000);
        //dirty app, as driver cant click even though it thinks we is clickable
        try {
            waitForElementVisibleAndClick(iframeCss, WaitTool.PAGELOAD_TIMEOUT_45);
        }catch (Exception e){
            logger.error(e.getMessage());
        }// try again
        sleep(2000);
        waitForElementVisibleAndClick(iframeCss, WaitTool.PAGELOAD_TIMEOUT_45);

        // TODO click Close
       //waitForElementVisibleAndClick("#btn-close", WaitTool.PAGELOAD_TIMEOUT_45);
        //WebDriverWindowHelper.switchToDefaultContent(getWebDriver());
        //grammarlabPage = new GrammarlabPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        //grammarlabPage.grammarLabTopicLessonModulePage.simpleTest();
    }
}











