package com.englishtown.newhouse.school.pages.classroom.modules;
/**
 * Nikol Jan 2018
 * Topic section shows plb topic cards in 2 columns
 * model one and reuse
 *
 */
import com.englishtown.enumpack.modules.TopicCardDetails;
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WebElementHelper;
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


public class TopicCardModule extends BaseSchoolPage {

    public static final Logger logger = LoggerFactory.getLogger(TopicCardModule.class);
    public static final String pageUrl = "/campus/class-booking/index?type=School.BookPL.2012#step=0";

    public final String topicListCss = "plb-topic-list";
    //card details for one card
    public final String titleCss               = ".title h3";
    public final String imageCss               = ".image img";
    public final String learnMoreCss           = ".plb-card-action .action-learn-more";
    public final String selectTopicCss         = ".plb-card-action .action-select-topic";
    public final String expandedCardDetailsCss = ".plb-card-details p";
    public final String expandSelectTopicCss   = ".plb-card-action-expanded .action-select-topic";


    @FindBy(className = topicListCss)
    public WebElement topicListSectionWe;   // all topic cards are inside this

    @FindBy(css = ".plb-card-list li")
    public List<WebElement> cardTopicListWe;



    public TopicCardModule(WebDriver webDriver){
        super(webDriver);
    }

    public TopicCardModule(WebDriver webDriver, String url) {
        super(webDriver, url);
    }

    public TopicCardModule(WebDriver webDriver, int timeoutSec) {
        super(webDriver, timeoutSec);
    }

    public TopicCardModule() {
        this(null, null);
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(topicListSectionWe);
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public boolean simpleTest() {
        logger.info("simpleTest Assert Main element displayed ...!");
        AssertHelper.assertComponentsDisplayed(topicListSectionWe );
        AssertHelper.assertComponentsDisplayed(topicListSectionWe, cardTopicListWe.get(0));
        return true;
    }

    @Override
    public boolean checkAllPageComponentsDisplayed() {
        logger.info("checkAllPageComponents ...!");
        checkAllPageComponentsDisplayed( topicListSectionWe);
        return true;
    }


    //--------------------------------------------------------------------------------------
    /**
     * A card contains 4 main components. For each element in cardTopicListWe
     * 1. Title      .title h3
     * 2. image      .image img
     * 3. learnMore  .plb-card-action.action-learn-more   [Click on this shows card details and select this topic]
     * 4. select     .plb-card-action .action-select-topic
     *  // click on learnmore
     *  6. cardDetails .plb-card-details p    ..shows msg
     *  7. select topic .plb-card-action-expanded.action-select-topic
     */

    /**
     *
     * @return we from the list of WEs
     */
    public WebElement getCard(int cardTopicIndex){
        return cardTopicListWe.get(cardTopicIndex);
    }

    public int getNumberOfCards(){
        return cardTopicListWe.size();
    }

    /**
     * Find elements on the parent element
     *
     * @param cardTopicIndex
     * @param topicCardDetails
     * @return WebElement
     *
     * TODO : this is not test
     */
    public WebElement getCardElement(int cardTopicIndex, TopicCardDetails topicCardDetails){
        WebElement webElement = null;

        switch (topicCardDetails){

            case TITLE:
                logger.info("Case [{}]", topicCardDetails);
                webElement = WebElementHelper.safeFindElement(cardTopicListWe.get(cardTopicIndex), By.cssSelector(titleCss));
                break;

            case IMAGE:
                logger.info("Case [{}]", topicCardDetails);
                webElement = WebElementHelper.safeFindElement(cardTopicListWe.get(cardTopicIndex), By.cssSelector(imageCss));
                break;

            case LEARNMORE:
                logger.info("Case [{}]", topicCardDetails);
                webElement = WebElementHelper.safeFindElement(cardTopicListWe.get(cardTopicIndex), By.cssSelector(learnMoreCss));
                break;

            case SELECT:
                logger.info("Case [{}]", topicCardDetails);
                webElement = WebElementHelper.safeFindElement(cardTopicListWe.get(cardTopicIndex), By.cssSelector(selectTopicCss));
                break;

            case EXPAND_CARD_DETAILS:
                logger.info("Case [{}]", topicCardDetails);
                webElement = WebElementHelper.safeFindElement(cardTopicListWe.get(cardTopicIndex), By.cssSelector(expandedCardDetailsCss));
                break;

            case EXPAND_SELECT_TOPIC:
                logger.info("Case [{}]", topicCardDetails);
                webElement = WebElementHelper.safeFindElement(cardTopicListWe.get(cardTopicIndex), By.cssSelector(expandSelectTopicCss));
                break;


            default:
                logger.error("Cant find this element [{}]", topicCardDetails);
        }

        if(null == webElement)
            failTest("Cant find Web Element ...! for :"+topicCardDetails);

        return webElement;
    }

    public void checkAllTopicCardsElementsDisplayed(int cardTopicIndex, boolean isExpanded){
        for(TopicCardDetails card : TopicCardDetails.values()){
            logger.info("Checking topic card Element [{}] ..!", card);
            if(isExpanded){
                logger.info("Check expanded card details ...!");
                if(card == TopicCardDetails.LEARNMORE || card == TopicCardDetails.SELECT ){
                    // those elements not present on expand status
                }else
                    AssertHelper.assertWebElementDisplayed(getCardElement(cardTopicIndex, card));

            }else {
                if(card == TopicCardDetails.EXPAND_CARD_DETAILS || card == TopicCardDetails.EXPAND_SELECT_TOPIC ){
                    // those elements not present when not expanded
                }else
                    AssertHelper.assertWebElementDisplayed(getCardElement(cardTopicIndex, card));

            }
            //TopicCardDetails.EXPAND_CARD_DETAILS){logger.info("Need to click more to expand card details .. to get this checked ...");      }else
            //AssertHelper.assertWebElementDisplayed(getCardElement(cardTopicIndex, card));
        }



    }


}
