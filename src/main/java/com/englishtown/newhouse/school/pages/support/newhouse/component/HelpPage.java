package com.englishtown.newhouse.school.pages.support.newhouse.component;
/**
 * Nikol Jul 2018
 * New house
 * https://englishlive.ef.com/1/support/
 *
 * Contains :
 * 1. Help
 * 2. Email us
 *
 */

import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.newhouse.school.pages.core.BaseSchoolPage;
import org.codehaus.groovy.transform.trait.Traits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class HelpPage extends BaseSchoolPage {
    public static final Logger logger = LoggerFactory.getLogger(HelpPage.class);
    public static final String pageUrl = "/1/support/";


    public static final String NO_RESULT_FOUND_MSG = "No search results were found";

    @FindBy(name = "searchStr")
    public WebElement searchTxtWe;

    @FindBy(css = ".faqEntries > div")                  // first page
    public List<WebElement> faqEntriesListWe;

    @FindBy(css = ".pagination > li")                   // to get the active one user li[class=active]
    public List<WebElement> faqPaginationListWe;

    @FindBy(css = "div video")                          // /Juno/15/88/85/v/158885/B2C_How_to_TK_v2.mp4
    public List<WebElement> introductionVideosListWe;

    @FindBy(css = "div object")                         // https://www.youtube.com/embed/6XhUaHgydnk?rel=0&controls=0&showinfo=0&wmode=opaque
    public List<WebElement> getYoutubeVideoListWe;

    @FindBy(className = "notFound")                   // same as faqEntriesListWe.get(0)
    public WebElement noSearchResultWe;

    //--------------------------------------------------------------------------------------

    public HelpPage(WebDriver webDriver, int waitSec){
        super(webDriver, waitSec);
    }
    public HelpPage(WebDriver webDriver){
        super(webDriver);
    }
    public HelpPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }
    public HelpPage() {
        this(null, null);
    }
    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(searchTxtWe);
    }

    //--------------------------------------------------------------------------------------

    @Override
    public boolean checkAllPageComponentsDisplayed() {
        checkAllPageComponentsDisplayed(searchTxtWe, getSearchBtnWe(), faqEntriesListWe.get(0),introductionVideosListWe.get(0),
                getYoutubeVideoListWe.get(0));
        return false;
    }

    public boolean simpleTest() {
        logger.info("check searchbar is displayed...!");
        AssertHelper.assertWebElementDisplayed(searchTxtWe);
        return true;
    }

    public void cleanSearchText(){
        searchTxtWe.clear();
    }

    public void enterSearchText(String searchFor){
        sendKey(getWebDriver(), searchTxtWe, searchFor,false);
    }

    public void clickSearchBtn(){
        logger.info("clickSearchBtn");
        click(getSearchBtnWe());
    }

    public void assertNoSearchResults(){
        logger.info("assertNoSearchResults by checking WE displayed [noSearchResultWe] ");
        AssertHelper.assertWebElementDisplayed(noSearchResultWe);
    }

    public void assertThereAreSearchResults(int noOfElementsMoreThanOrEqual){
        logger.info("assertThreAreSearchResults by checking WE size [noSearchResultWe] ");
        AssertHelper.assertElementSizeMoreThanOrEqual(getWebDriver(), faqEntriesListWe, noOfElementsMoreThanOrEqual);
    }

    /**
     * Use find parent of search txt then find search btn
     */
    public WebElement getSearchBtnWe(){
        logger.info("getSearchBtnWe");
        WebElement searchTxtParentWe = searchTxtWe.findElement(By.xpath(".."));
        WebElement searchBtnWe = searchTxtParentWe.findElement(By.cssSelector("span span"));
        return searchBtnWe;
    }

    public String getPageUrl() {
        return pageUrl;
    }

}





/**
 WebElement myElement = driver
 .findElement(By.id("myDiv"));
 WebElement parent = (WebElement) ((JavascriptExecutor) driver)
 .executeScript(
 "return arguments[0].parentNode;", myElement);
 JavaCopy
 WebElement myElement = driver.findElement(By.id("myDiv"));
 WebElement parent = myElement.findElement(By.xpath(".."));
 JavaCopy
 But what if the parent of the parent is required?

 The JavaScript would be

 return arguments[0].parentNode.parentNode;
 JavaScriptCopy
 and the XPath will be

 By.xpath("../..")
 */
