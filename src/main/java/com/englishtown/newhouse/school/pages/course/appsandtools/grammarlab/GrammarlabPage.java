package com.englishtown.newhouse.school.pages.course.appsandtools.grammarlab;
/**
 * Nikol Apr 2018
 * /1/apps-and-tools/grammarlab/
 *
 * TODO : create main page, topic and lesson modules
 * // need to replace the selectors after Oliver updates
 */

import com.englishtown.enumpack.modules.GrammarLabTopic;
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.newhouse.school.pages.core.BaseSchoolPage;
import com.englishtown.newhouse.school.pages.course.appsandtools.grammarlab.modules.GrammarLabTopicLessonModulePage;
import com.englishtown.newhouse.school.pages.course.appsandtools.grammarlab.modules.GrammarLabTopicModulePage;
import org.apache.commons.lang.StringUtils;
import org.eclipse.jetty.util.StringUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class GrammarlabPage extends BaseSchoolPage {

    public static final Logger logger = LoggerFactory.getLogger(GrammarlabPage.class);
    public static final String pageUrl = "/1/apps-and-tools/grammarlab/";

    public GrammarLabTopicModulePage grammarLabTopicModulePage;
    public GrammarLabTopicLessonModulePage grammarLabTopicLessonModulePage;

    public static final String PAGEHEADING_CSS       = "title_2DE_X";  // CLASS
    public static final String NUMBER_OF_TOPICS_CSS  = ".count-text_2_-ES span";
    public static final String BREADCRUMB_CSS        = ".grammarlab [class^='breadcrumbs_'] ";  // or use span insted [class^='active_']
    public static final String ACTIVE_BREADCRUMB_CSS = ".grammarlab [class^='breadcrumbs_'] [class^='active_']";  // or use span insted [class^='active_']

    /**
     * page heading
     */
    @FindBy(className = PAGEHEADING_CSS)
    public WebElement pageHeadingWe;

    @FindBy(css = NUMBER_OF_TOPICS_CSS)
    public WebElement numberOfTopicsWe;  //(15)

    @FindBy(css = BREADCRUMB_CSS)
    public WebElement breadCrumbWe;

    @FindBy(css = ACTIVE_BREADCRUMB_CSS)
    public WebElement ACTIVEbreadCrumbWe;

    ///-------------------------------------------------------------------------------------

    public GrammarlabPage(WebDriver webDriver){
        super(webDriver);
        initializeModules();
    }
    public GrammarlabPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }
    public GrammarlabPage(WebDriver webDriver, int waitTimeSec) {
        super(webDriver, waitTimeSec);
        initializeModules();
    }
    public GrammarlabPage() {
        this(null, null);
    }
    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(numberOfTopicsWe);
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public boolean simpleTest() {
        logger.info("simpleTest Assert Main element displayed ...!");
        WaitTool.waitForCondition(ExpectedConditions.visibilityOf(pageHeadingWe), getWebDriver(), 25);
        AssertHelper.assertComponentsDisplayed(pageHeadingWe);
        return true;
    }

    @Override
    public boolean checkAllPageComponentsDisplayed() {
        logger.info("checkAllPageComponents ...!");
        checkAllPageComponentsDisplayed( pageHeadingWe);
        checkAllPageComponentsDisplayed( numberOfTopicsWe);
        return true;
    }

    /**
     * label shown on the top of topics
     * @param matchNumber
     * @return
     */
    public boolean checkNumberOfTopics(int matchNumber){
        return assertStringContainsNumber(matchNumber);
    }

    public boolean checkNumberLessons(int matchNumber){
        return assertStringContainsNumber(matchNumber);
    }


    public boolean assertStringContainsNumber(int matchNumber){
        logger.info("assertStringContainsNumber [{}]", matchNumber);
        String currentNoOfTopics = TestUtil.getWebElementText(numberOfTopicsWe);
        if(StringUtil.isBlank(currentNoOfTopics))
            failTest("Can't get Number of topics / lessons...!");

        AssertHelper.assertThat("Not the expected number of topics / lesson ...!",
                StringUtils.contains( currentNoOfTopics, String.valueOf(matchNumber)));
        return true;
    }

    public void initializeModules(){
        grammarLabTopicModulePage = new GrammarLabTopicModulePage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        grammarLabTopicLessonModulePage = new GrammarLabTopicLessonModulePage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
    }

    /*public void initializeLessonModules(){
        grammarLabTopicLessonModulePage = new GrammarLabTopicLessonModulePage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
    }*/

    public void clickGetStartedOnTopic(int topicIndex){
        logger.info("clickGetStartedOnTopic", topicIndex);
        click(grammarLabTopicModulePage.getCardElement(topicIndex, GrammarLabTopic.BTN));
    }

    public void clickGetStartedOnLesson(int topicIndex){
        logger.info("clickGetStartedOnLesson", topicIndex);
        click(grammarLabTopicLessonModulePage.getCardElement(topicIndex, GrammarLabTopic.BTN));
    }

}
