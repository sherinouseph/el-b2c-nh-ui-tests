package com.englishtown.pages.checkout.newcheckout;
/**
 * General members form page
 * Date: 26/08/14
 * Base offer page - extended by   https://www.englishtown.fr/buy/welcome-back/alumni/
 *
 */

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


public class BaseOfferPage extends BasePage {

    public static final Logger logger = LoggerFactory.getLogger(BaseOfferPage.class);

    public WebElement currWebElement;
    // locators
    public static final String offersSelecotr = "button"; //CSS  offer button list[*+at least one] -.columnsControl .row .parsys button .btn.btn-primary btn

    @FindBy(css = offersSelecotr)	//@CacheLookup
    public List<WebElement> weOfferButtons;


    public BaseOfferPage(WebDriver webDriver){
        super(webDriver);
    }
    public BaseOfferPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }
    public BaseOfferPage() {
        this(null, null);
    }
    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean simpleTest() {
        boolean isTestPassed = false;
        logger.info(" simpleTest()");
        if(weOfferButtons != null){
            try {
                isTestPassed = weOfferButtons.get(0).isDisplayed();
            }catch (WebDriverException e){
                BasePage.failTest(e, "FAIL simpleTest ...! nextStep element is not displayed", true);
            }
        } else {                                                                                                        //logger.error("FAIL simpleTest  ... nextStep element not found or is not displayed");
            BasePage.failTest("FAIL simpleTest ...! nextStep element not found or is not displayed", true);                   //fail("FAIL  nextStep element not found or is not displayed");
            return false;
        }
        return isTestPassed;
    }
    @Override
    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(weOfferButtons.get(0));
    }



}
