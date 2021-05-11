package com.englishtown.pages.checkout.newcheckout;
/**
 * General members form page
 * Date: 26/08/14
 *
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


public class DynamicMemberPage extends BasePage {

    public static final Logger logger = LoggerFactory.getLogger(DynamicMemberPage.class);
    public static final String membersPageUrl = "/en-gb/buy/default/payment/";  //TODO this should be dynamic
    public WebElement currWebElement;
    // locators
    public static final String rmLoginLocator = "a[href*='returnurl']" ;   // DE and ES test ok manually   //"#button_richtext a";  //$('a[href*="returnurl"]')  $('.form span a')

    @FindBy(className = "login-link")	//@CacheLookup
    public WebElement loginLink;

    @FindBy(css = rmLoginLocator)   //buttons_richtext a   //form
    public WebElement rmLogin;            // returning student

    @FindBy(id = "firstname")
    public WebElement firstname;

    @FindBy(css =".btn.btn-primary")
    public WebElement nextStep;


    public DynamicMemberPage(WebDriver webDriver){
        super(webDriver);
    }

    public DynamicMemberPage(WebDriver webDriver, int waitTimeSec){
        super(webDriver, waitTimeSec);
    }

    public DynamicMemberPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }
    public DynamicMemberPage() {
        this(null, null);
    }
    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean simpleTest() {
        boolean isTestPassed = false;
        logger.info(" simpleTest()");
        if(nextStep != null){
            try {
                isTestPassed = nextStep.isDisplayed();
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
        return ExpectedConditions.visibilityOf(firstname);
    }
    public String getPageUrl() {
        return membersPageUrl;
    }

    public void submit(){
        logger.info("Memberpage.submit ....!");
        click(nextStep);
    }

    public WebElement getSubmitBtn(){
        return nextStep;
    }

}
