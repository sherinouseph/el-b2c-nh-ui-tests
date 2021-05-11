package com.englishtown.newhouse.school.pages.friends;
/**
 * Sherin
 *
 * This is the result page when you click on find new friends
 * If there are some results, then it will show you the friends card
 * If no results for your search, it will show you a text message with a search button
 *
 *
 */

import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.utils.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class FindNewFriendsResultPage extends FriendsPage {

    public static final Logger logger = LoggerFactory.getLogger(FindNewFriendsResultPage.class);
    public static final String pageUrl = "/chat/friends/#/chat/friends/search/results";

    public static final String FINDNEWFRIENDS_RESULTS_BASE_CSS          = "div[class^='default_']";
    public static final String FINDNEWFRIENDS_RESULT_EDIT_CSS           = FINDNEWFRIENDS_RESULTS_BASE_CSS + " [class^='edit_']";
    public static final String FINDNEWFRIENDS_RESULT_HEADING_CSS        = FINDNEWFRIENDS_RESULTS_BASE_CSS + " [class^='heading_']";
    public static final String FINDNEWFRIENDS_RESULT_COUNT_CSS          = FINDNEWFRIENDS_RESULT_HEADING_CSS + " [class^='count_']";
    public static final String FINDNEWFRIENDS_RESULT_EXPLOREHEADING_CSS = FINDNEWFRIENDS_RESULTS_BASE_CSS + " [class^='sub-heading_']";



    //find new friends- results

    @FindBy(css = FINDNEWFRIENDS_RESULT_EDIT_CSS)
    public WebElement editSearchLinkWe;

    @FindBy(css = FINDNEWFRIENDS_RESULT_HEADING_CSS)
    public WebElement resultHeadingWe;

    @FindBy(css = FINDNEWFRIENDS_RESULT_COUNT_CSS)
    public WebElement studentMatchingNoWe;

    @FindBy(css = FINDNEWFRIENDS_RESULT_EXPLOREHEADING_CSS)
    public WebElement exploreProfileTitleWe;


    //validation scenarios

    @FindBy(css = "button[class^='default_']")
    public WebElement searchNowbtnWe;

    @FindBy(css = "[class^='copy-head_']")
    public WebElement validationtxt1We;

    @FindBy(css = "[class^='copy-subhead']")
    public WebElement validationTxt2We;



    public FindNewFriendsResultPage(WebDriver webDriver)  {
        super(webDriver);
        initializeContactModule();
    }

    public FindNewFriendsResultPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }

    public FindNewFriendsResultPage(WebDriver webDriver, int waitSec){
        super(webDriver, waitSec);
        initializeContactModule();
    }

    public FindNewFriendsResultPage() {
        this(null, null);
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Override
    public boolean checkAllPageComponentsDisplayed() {
        checkAllPageComponentsDisplayed(editSearchLinkWe,resultHeadingWe,studentMatchingNoWe);
        return false;
    }
    public boolean simpleTest() {
        logger.info("simpleTest on find new friends - results page..!");
        AssertHelper.assertWebElementDisplayed(editSearchLinkWe);

        return true;
    }

    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(editSearchLinkWe);
    }

    public String getPageUrl() {
        return pageUrl;
    }




    public void checkErrorMessageForNoMatchingResults(){
        logger.info("checkErrorMessageForNoMatchingResults");
        AssertHelper.assertStringContains(TestUtil.getWebElementText(validationtxt1We),"No results","Message 1 incorrect");
        AssertHelper.assertStringContains(TestUtil.getWebElementText(validationTxt2We),"Start a new search for friends today!","Message 2 incorrect");
    }

    public void clickOnSearchnowBtn(){
        logger.info("clickOnSearchnowBtn");
        click(searchNowbtnWe);
    }

    public void clickOnEditLink(){
        logger.info("clickOnEditLink");
        click(editSearchLinkWe);
    }

}
