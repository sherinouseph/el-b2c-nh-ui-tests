package com.englishtown.newhouse.school.pages.course.appsandtools.grammarlab.modules;
/**
 *
 * Nikol Apr 2018
 * /1/apps-and-tools/grammarlab/
 * on this page there is a list of Topics [Title, pic, descript, no of lessons, get started]
 * model one and reuse
 *
 */

import com.englishtown.enumpack.modules.GrammarLabTopic;
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.helpers.utils.TestUtil;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.englishtown.helpers.CaseInsensitiveSubstringMatcher.containsIgnoringCase;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.text.IsEmptyString.isEmptyOrNullString;


public class GrammarLabTopicModulePage extends GrammarCardBaseModulePage {

    public static final Logger logger = LoggerFactory.getLogger(GrammarLabTopicModulePage.class);
   // public static final String pageUrl = "/1/apps-and-tools/grammarlab/";

//    public final String TOPIC_CSS = "grammarlab";    // class  main Parent
//    public final String TOPICLIST_CSS = ".grammarlab [class^='card_']"; //list of topics  has card_
    //--------------------------------------------------------------------------------------
    /**
     * A topic card contains 5 main components. For each element in topicCardListWe
     * 1. Title
     * 2. image
     * 3. Desc
     * 4. No of Lessons
     * 5. GetStarted btn
     */
//    public final String titleCss               = "[class^='title_']";   // topic subject
//    public final String imageCss               = "[class^='img_']";
    public final String descriptionCss         = "[class^='description_']";   // user the present test in ppt
    public final String numberOfLessonsCss     = "[class^='lesson-count_']"; // 5 Lessons
//    public final String getStartedBtnCss       = "[class^='button_']";



//    @FindBy(className = TOPIC_CSS)
//    public WebElement topicWe;
//
//    @FindBy(css = TOPICLIST_CSS)
//    public List<WebElement> topicCardListWe;  // all topic are inside this


    /**
     *
     * @return we from the list of WEs
     */
//    public WebElement getCard(int cardTopicIndex){
//        return topicCardListWe.get(cardTopicIndex);
//    }
//
//    public int getNumberOfCards(){
//        return topicCardListWe.size();
//    }

    /**
     * Find elements on the parent element
     *
     * @param cardTopicIndex
     * @param topicCardDetails
     * @return WebElement
     *
     * TODO : this is not test
     */
    public WebElement getCardElement(int cardTopicIndex, GrammarLabTopic topicCardDetails){
        WebElement webElement = null;

        switch (topicCardDetails){

            case TITLE:
                logger.info("Case [{}]", topicCardDetails);
                webElement = WebElementHelper.safeFindElement(topicCardListWe.get(cardTopicIndex), By.cssSelector(titleCss));
                break;

            case IMAGE:
                logger.info("Case [{}]", topicCardDetails);
                webElement = WebElementHelper.safeFindElement(topicCardListWe.get(cardTopicIndex), By.cssSelector(imageCss));
                break;

            case DESC:
                logger.info("Case [{}]", topicCardDetails);
                webElement = WebElementHelper.safeFindElement(topicCardListWe.get(cardTopicIndex), By.cssSelector(descriptionCss));
                break;

            case LESSON_COUNT:
                logger.info("Case [{}]", topicCardDetails);
                webElement = WebElementHelper.safeFindElement(topicCardListWe.get(cardTopicIndex), By.cssSelector(numberOfLessonsCss));
                break;

            case BTN:
                logger.info("Case [{}]", topicCardDetails);
                webElement = WebElementHelper.safeFindElement(topicCardListWe.get(cardTopicIndex), By.cssSelector(getStartedBtnCss));
                break;

            default:
                logger.error("Cant find this element [{}]", topicCardDetails);
        }

        if(null == webElement)
            failTest("Cant find Web Element ...! for :"+topicCardDetails);

        return webElement;
    }

    @Override
    public void checkAllCardsElementsDisplayed(int cardTopicIndex){
        for(GrammarLabTopic card : GrammarLabTopic.values()){
            logger.info("Checking topic card Element [{}] ..!", card);
            AssertHelper.assertWebElementDisplayed(getCardElement(cardTopicIndex, card));
        }
    }


    public int getTopicIndexBySubject(String subject){
        logger.info("getTopicIndexBySubject [{}]", subject);
        int index = -1;
        String currentSubject = "-1";
        WebElement subjectWe = null;

        if(null != topicCardListWe && topicCardListWe.size() > 0 ) {
            int size = topicCardListWe.size();

            for(int i=0; i > size; i++){
                subjectWe = getCardElement(i, GrammarLabTopic.TITLE);
                currentSubject = TestUtil.getWebElementText(subjectWe);

                if(StringUtils.isNotBlank(currentSubject)){
                    if(StringUtils.equalsIgnoreCase(currentSubject.trim(), subject)){
                        logger.info("Found subject match for [{}] on index["+i+"]", subject);
                        index = i;
                        break;
                    }
                }else {
                    failTest("[currentSubject / subjectWe] is EMPTY OR NULL ....!");
                }
                //break out of the lop
                if(index > -1) break;
            }
        }else
           failTest("Topic list is EMPTY OR NULL ....!");

        return index;
    }

    ///-------------------------------------------------------------------------------------

    public GrammarLabTopicModulePage(WebDriver webDriver){
        super(webDriver);
    }
    public GrammarLabTopicModulePage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }
    public GrammarLabTopicModulePage(WebDriver webDriver, int timeoutSec) {
        super(webDriver, timeoutSec);
    }
    public GrammarLabTopicModulePage() {
        this(null, null);
    }
    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(topicCardListWe.get(0));
    }

    public String getPageUrl() {
        return pageUrl;
    }

//    public boolean simpleTest() {
//        logger.info("simpleTest Assert Main element displayed ...!");
//        AssertHelper.assertComponentsDisplayed(topicWe);
//        AssertHelper.assertComponentsDisplayed(topicCardListWe.get(0));
//        return true;
//    }

    public void checkNumberOfTopicCards(int numberOfTopics){
        logger.info("checkNumberOfTopicCards [{}] ...!", numberOfTopics);
        AssertHelper.assertElementSizeEqual(getWebDriver(), topicCardListWe, numberOfTopics);
    }

    public void checkNumberOfLessonsPerTopic(int topicNumberIndex, int numberOfLesson){
        logger.info("checkNumberOfLessonsPerTopic topicNumberIndex [{}], numberOfLesson :"+numberOfLesson, topicNumberIndex);
        WebElement nuOfLessonsWe = getCardElement(topicNumberIndex, GrammarLabTopic.LESSON_COUNT);
        AssertHelper.myAssertThat(getWebDriver(), "Is not the expected text ...!",
                TestUtil.getWebElementText(nuOfLessonsWe), containsIgnoringCase(String.valueOf(numberOfLesson)), false);
    }

    public void checkTopicDescriptionContainsText(int topicNumberIndex){
        logger.info("checkNumberOfLessonsPerTopic topicNumberIndex [{}], ...!", topicNumberIndex);
        String currentNoOfTopics = TestUtil.getWebElementText(getCardElement(topicNumberIndex, GrammarLabTopic.DESC));
        AssertHelper.myAssertThat(getWebDriver(), "Is NULL or Empty...!",
                currentNoOfTopics, not(isEmptyOrNullString() ), false);
    }


    @Override
    public boolean checkAllPageComponentsDisplayed() {
        logger.info("checkAllPageComponents ...!");
        checkAllCardsElementsDisplayed(0);
        return true;
    }

}
