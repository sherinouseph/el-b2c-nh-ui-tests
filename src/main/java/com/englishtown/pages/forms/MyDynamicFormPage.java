package com.englishtown.pages.forms;
/**
 * General EE form page
 * Date: 03/09/14    *
 *
 */
import com.englishtown.pages.core.MyBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MyDynamicFormPage extends MyBasePage {

    public static final Logger logger = LoggerFactory.getLogger(MyDynamicFormPage.class);
    public static final String pageUrl = "";
    public WebElement currWebElement;

    @FindBy(css = ".form .btn")	//@CacheLookup
    public WebElement formSubmitButton;

    @FindBy(id = "first_name")
    public WebElement firstname;

    public MyDynamicFormPage(WebDriver webDriver){
//        this.webDriver = driver;
//        PageFactory.initElements(new AjaxElementLocatorFactory(this.webDriver, defaultImplicitTimeout), this);   //PageFactory.initElements(driver, this);
        super(webDriver);
    }

    public MyDynamicFormPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }
    public MyDynamicFormPage() {
        this(null, null);
    }
    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    public boolean simpleTest() {
        logger.info(" simpleTest()");
        return formSubmitButton.isDisplayed() ;
    }
    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(formSubmitButton);
    }
    public String getPageUrl() {
        return pageUrl;
    }


}

