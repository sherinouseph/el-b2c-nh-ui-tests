package com.englishtown.pages.fluencycalculator;
/**
 *
 *
 */

import com.englishtown.helpers.WebElementHelper;
import com.englishtown.pages.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.testng.AssertJUnit.fail;


public class FCStep4GraphPage extends BasePage {

    public static final Logger logger = LoggerFactory.getLogger(FCStep4GraphPage.class);

    @FindBy(css = ".fluencyGraph #circle0")              //".fluencyGraph #overcircle0")
    public WebElement graphCircle;
    //start today
    @FindBy(css = ".graphFooter .btn-primary")
    public WebElement startToday;

    public FCStep4GraphPage(WebDriver webDriver){
        super(webDriver);
    }
    public FCStep4GraphPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }
    public FCStep4GraphPage() {
        this(null, null);
    }
    //public void setWebDriver(WebDriver webDriver) {    this.webDriver = webDriver;   }

    public boolean simpleTest() {
        logger.info(" simpleTest()");
        if(graphCircle != null ){
            return graphCircle.isDisplayed() ;
        } else {                                                                                                        //logger.error("FAIL simpleTest  ... nextStep element not found or is not displayed");
            BasePage.failTest("FAIL simpleTest ...!. nextStep element not found or is not displayed", true);            //fail("FAIL  nextStep element not found or is not displayed");
            return false;
        }
    }

    public FCLpOEv1s2Page clickStartToday(){
        WebElementHelper.scrollAndClick(getWebDriver(), startToday);
        return new FCLpOEv1s2Page(getWebDriver());
    }
    @Override
    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(startToday);
    }

    // Actions
    public void clickStart(){
        WebElementHelper.scrollAndClick(getWebDriver(), startToday);
    }

}
