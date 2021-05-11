package com.englishtown.pages.fluencycalculator;
/**
 * General FC page - Steps 1 to 3
 *
 */

import com.englishtown.helpers.WebElementHelper;
import com.englishtown.pages.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.testng.AssertJUnit.fail;


public class FluencyCalculatorStep1Page extends BasePage {

    public static final Logger logger = LoggerFactory.getLogger(FluencyCalculatorStep1Page.class);

    @FindBy(css = ".stageBtnsCont .stageBtnInner")
    public List<WebElement> selectionList;

    public FluencyCalculatorStep1Page(WebDriver webDriver){
        super(webDriver);
    }
    public FluencyCalculatorStep1Page(WebDriver webDriver, String url) {
        super(webDriver, url);
    }
    public FluencyCalculatorStep1Page() {
        this(null, null);
    }


    public boolean simpleTest() {
        logger.info(" simpleTest()");
        boolean isWeDisplayed = false;
        try {
            if(selectionList.size() > 0 ){
                return selectionList.get(0).isDisplayed() ;
            } else {                                                                                                    //  logger.error("FAIL simpleTest  ... nextStep element not found or is not displayed");
                BasePage.failTest("FAIL simpleTest  ... element not found or is not displayed", true);                  // fail("FAIL  element not found or is not displayed ...! "+getCurrentUrl());
            }
        }catch (WebDriverException e){
            BasePage.failTest(e, "FAIL simpleTest  ... element not found or is not displayed", true);                      // fail("FAIL  element not found or is not displayed : "+ TestUtil.getException(e, getWebDriver()));
        }
        return isWeDisplayed;

    }

    @Override
    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(selectionList.get(0));
    }

    // Actions
    public FluencyCalculatorStep1Page clickSelectionList(int index){
        WebElementHelper.scrollAndClick(getWebDriver(), selectionList.get(index));
        return new FluencyCalculatorStep1Page(getWebDriver());
    }
    public FCStep4GraphPage clickSelectionListToGraph(int index){
        WebElementHelper.scrollAndClick(getWebDriver(), selectionList.get(index));
        return new FCStep4GraphPage(getWebDriver());
    }

}
