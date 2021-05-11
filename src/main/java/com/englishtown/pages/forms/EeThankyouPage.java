package com.englishtown.pages.forms;

import com.englishtown.pages.core.MyBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Next page after EE members page
 * User: nikol.marku
 * Date: 04/09/14
 *
 */
public class EeThankyouPage extends MyBasePage {

    public static final Logger logger = LoggerFactory.getLogger(MyDynamicFormPage.class);
    public static final String eeMembersPageUrl = "";
    public WebElement currWebElement;

    //et-lp-osmember-submit       currWebElement = getWebDriver().findElement(By.id("et-lp-osmember-submit"));

    @FindBy(id = "firstname")   //@CacheLookup
    public WebElement firstname;
    @FindBy(id = "lastname")
    public WebElement lastname;
    @FindBy(id = "mypassword")
    public WebElement mypassword;
    @FindBy(id = "email")
    public WebElement email;
    @FindBy(css = ".form a[id*='submit']")    //[id*=submit]
    public WebElement submitBtn;

    EeThankyouPage(WebDriver webDriver){
        super(webDriver);
    }

    public EeThankyouPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }
    public EeThankyouPage() {
        this(null, null);
    }
    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    public boolean simpleTest() {
        logger.info(" simpleTest()");
        return submitBtn.isDisplayed() ;
    }
    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(submitBtn);
    }
    public String getPageUrl() {
        return eeMembersPageUrl;
    }

}
