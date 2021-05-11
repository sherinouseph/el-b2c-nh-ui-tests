package com.englishtown.newhouse.school.pages.friends;
/**
 * Sherin
 *This page has the selectors and functions for search tab and search by name/email tab
 *
 */

import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.helpers.utils.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class FindNewFriendsPage extends FriendsPage {

    public static final Logger logger = LoggerFactory.getLogger(FindNewFriendsPage.class);
    public static final String pageUrl = "/chat/friends/#/chat/friends/search/advanced";


    public static final String FINDNEWFRIENDS_BASE_CSS        = "div[class^='search_']";
    public static final String FINDNEWFRIENDS_SEARCHTABS_CSS     = FINDNEWFRIENDS_BASE_CSS +" [class^='indicator_']";
    public static final String FINDNEWFRIENDS_INPUT_TEXT_CSS     = FINDNEWFRIENDS_BASE_CSS +" [class^='input-field_']";
    public static final String FINDNEWFRIENDS_DROPDOWN__CSS     = FINDNEWFRIENDS_BASE_CSS +" [class^='select-field_']";

    //todo find button css use [class^="tab tab_"][class*="active_"] button[class*="filled-blue_"] to find active find button [search page content]
    //div[class^='search_']  [class^='row'] button
    public static final String FINDNEWFRIENDS_ALLBUTTONS__CSS     = FINDNEWFRIENDS_BASE_CSS + " [class^='row'] button";
    public static final String FINDNEWFRIENDS_LOOKINGFOR__CSS     = FINDNEWFRIENDS_BASE_CSS + " [class*='radio-button_']";
    public static final String FINDNEWFRIENDS_ONLINEONLYCHECKBOX__CSS ="[class^='checked_'] [class^='label_']";





    @FindBy(css = FINDNEWFRIENDS_SEARCHTABS_CSS)
    public List<WebElement> searchTabsWe;


    @FindBy(css = FINDNEWFRIENDS_INPUT_TEXT_CSS)
    public List<WebElement> searchBarNameOrEmailWe;

   //searchTab elements

    @FindBy(css = FINDNEWFRIENDS_ALLBUTTONS__CSS)
    public List<WebElement> englishLevelsListWe;

    @FindBy(css =FINDNEWFRIENDS_LOOKINGFOR__CSS)
    public List<WebElement> lookingForListWe;

    @FindBy(css = FINDNEWFRIENDS_INPUT_TEXT_CSS)
    public List<WebElement> ageListWe;

    @FindBy(css = FINDNEWFRIENDS_DROPDOWN__CSS)
    public  List<WebElement> dropdownListWe;//can;t find a selector to distinguish between three ddms living in,native language and industry.hence using list for them.will check with nikol later if there is a beter way

    @FindBy(css = FINDNEWFRIENDS_ONLINEONLYCHECKBOX__CSS)
    public WebElement onlineOnlycheckboxWe;

    @FindBy(css = FINDNEWFRIENDS_ALLBUTTONS__CSS)
    public List<WebElement> findNewFriendsBtnWe;




    public FindNewFriendsPage(WebDriver webDriver){
        super(webDriver);
    }

    public FindNewFriendsPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }
    public FindNewFriendsPage(WebDriver webDriver, int waitSec){
        super(webDriver, waitSec);
    }

    public FindNewFriendsPage() {
        this(null, null);
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Override
    public boolean checkAllPageComponentsDisplayed() {
        checkAllPageComponentsDisplayed(englishLevelsListWe.get(0),findNewFriendsBtnWe.get(3),searchTabsWe.get(1),searchTabsWe.get(0));
        return false;
    }
    public boolean simpleTest() {
        logger.info("simpleTest on my find new friends page..!");
        AssertHelper.assertWebElementDisplayed(findNewFriendsBtnWe.get(3));

        return true;
    }

    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(searchBarNameOrEmailWe.get(3));
    }

    public String getPageUrl() {
        return pageUrl;
    }



    public void clickOnFindNewFriendsBtn_Search(){
        logger.info("clickOnFindNewFriendsBtn");
        click(findNewFriendsBtnWe.get(3));
     }

    public void clickOnFindNewFriendsBtn_SearchEmailName(){
        logger.info("clickOnFindNewFriendsBtn");
        WaitTool.waitForCondition(ExpectedConditions.elementToBeClickable(findNewFriendsBtnWe.get(4)), getWebDriver(), 15);
        click(findNewFriendsBtnWe.get(4));
        sleep(1000);
    }

     public void searchByName(String name){
         logger.info("searchByName "+name);
         WebElementHelper.clearAndsendKeys(getWebDriver(), searchBarNameOrEmailWe.get(2),name,false);
     }

    public void searchByEmail(String email){
        logger.info("searchByName "+email);
        WebElementHelper.clearAndsendKeys(getWebDriver(), searchBarNameOrEmailWe.get(2),email,false);
        sleep(1000);
    }

    public void clickOnSearchNameOrEmailTab(){
        logger.info("clickOnSearchNameOrEmailTab");
        click(searchTabsWe.get(1));
    }

    public void clickOnSearchTab(){
        logger.info("clickOnSearchTab");
        click(searchTabsWe.get(0));
    }
////////////////////////////////////////////////////////////////////////////////////
    //Search Tab with filters - methods are written below

    public void selectEnglishLevel(int englishLevel){
        logger.info("selectEnglishLevel");
        click(englishLevelsListWe.get(englishLevel));//0 = Beginner,1=Intermediate,2=Advanced
    }

    public void selectLookingForList(int index){
        logger.info("selectLookingForList");
        click(lookingForListWe.get(index));//0 = Male,1=Female,2=Everyone
    }

    public void enterAgeFrom(String ageFrom){
        logger.info("enterAgeFrom");
       WebElementHelper.clearAndsendKeys(getWebDriver(),ageListWe.get(0),ageFrom,false);
    }

    public void enterAgeTo(String ageTo){
        logger.info("enterAgeFrom");
        WebElementHelper.clearAndsendKeys(getWebDriver(),ageListWe.get(1),ageTo,false);
    }

    public void selectLivingIn(String livingIn){
        logger.info("selectLivingIn");
        WebElementHelper.selectByValue(getWebDriver(),dropdownListWe.get(0),livingIn);
    }
    public void selectNativeLanguage(String nativeLang){
        logger.info("selectNativeLanguage");
        WebElementHelper.selectByValue(getWebDriver(),dropdownListWe.get(1),nativeLang);
    }

    public void selectIndustry(String industry){
        logger.info("selectIndustry");
        WebElementHelper.selectByValue(getWebDriver(),dropdownListWe.get(2),industry);
    }

    public void clickOnOnlineOnlycheckbox(){
        logger.info("clickOnOnlineOnlycheckbox");
        click(onlineOnlycheckboxWe);
    }




    public void filterThroughAllfields(int englishLevel,int lookingFor,String ageFrom,String ageTo,String livingIn,String nativeLang,String industry){
        logger.info("filterThroughAllfields");
        click(englishLevelsListWe,englishLevel);
        click(lookingForListWe,lookingFor);
        WebElementHelper.clearAndsendKeys(getWebDriver(),ageListWe.get(0),ageFrom,false);
        WebElementHelper.clearAndsendKeys(getWebDriver(),ageListWe.get(1),ageTo,false);
        WebElementHelper.selectByVisibilityText(getWebDriver(),dropdownListWe.get(0),livingIn);
        WebElementHelper.selectByVisibilityText(getWebDriver(),dropdownListWe.get(1),nativeLang);
        WebElementHelper.selectByVisibilityText(getWebDriver(),dropdownListWe.get(2),industry);
    }

}
