package com.englishtown.pages.common;
/**
 * New website ... homepage , howitworks, price login, try ... etc
 * User: nikol.marku
 *  *
 */

import com.englishtown.driver.BaseRemoteWebDriver;
import com.englishtown.helpers.AssertHelper;
import com.englishtown.pages.common.core.BaseHeaderAndFooterPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.hamcrest.Matchers.greaterThan;


public class NewHomePage extends BaseHeaderAndFooterPage {
    public static final Logger logger = LoggerFactory.getLogger(NewHomePage.class);
    /**
     * Main components
     */
    @FindBy(className = "primary")
    public WebElement header;  //PC and Mob/TAB

    @FindBy(css = "nav .menu a")   // shows home(hidden), howitWroks [1], price[2]
    public List<WebElement> topMenuList;

    @FindBy(css = ".ending a")   // login[1], phone[2]".ending.col-1-2 a
    public List<WebElement> topRightMenuList;

    @FindBy(css = ".btn.btn-primary")   //try us [3] top med bottom for desktop and med and bottom for tab/mob
    public List<WebElement> tryUsList;

    @FindBy(css = ".more a")   //List of 3 links between header and footer.this includes how it works,how it works,offers links
    public List<WebElement> contentLinksList;


    public NewHomePage(WebDriver webDriver){
        super(webDriver);
    }
    public NewHomePage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }
    public NewHomePage() {
        this(null, null);
    }
    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean simpleTest() {
        super.simpleTest();
        logger.info(" simpleTest()");
        try {
            if (BaseRemoteWebDriver.getCurrentDeviceName() != null) {
                logger.info("Is mobile or tablet device ....!");
                AssertHelper.assertWebElementDisplayed(mobileMenuIcon);
            }else { // is desktop
                logger.info("Is not mobile/tablet device ....!");
                AssertHelper.assertThat("This elements should be displayed on desktop view; Size should be 2",
                        topMenuList.size(), greaterThan(2));
            }
        }catch (Exception e){
            e.printStackTrace();
            failTest("Simple test failed ...! "+e.getCause().getMessage());
        }
        return true;
    }
    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(topMenuList.get(2));
    }

    public void assertTryusBtnShownInTheMidleContent(){
        AssertHelper.assertWebElementDisplayed(tryUsList.get(0));
    }

    public void assertHowItWorksLinkInTheMiddleContent(){
        AssertHelper.assertWebElementDisplayed(contentLinksList.get(0));//update  based on the last change from Paran.Try us button is not shown in the middle content
    }

}