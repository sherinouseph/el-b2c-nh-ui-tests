package com.englishtown.pages.fluencycalculator;
/**
 *
 *
 *
 *
 */
/* Create a new instance page class
   and initialise any WebElement fields in it.
   FluencyCalculatorStartPage page = PageFactory.initElements(driver, FluencyCalculatorStartPage.class);
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


public class FluencyCalculatorStartPage extends BasePage {

    public static final Logger logger = LoggerFactory.getLogger(FluencyCalculatorStartPage.class);

    //@CacheLookup
    @FindBy(className = "nextBtn")
    public WebElement startFc;

    public FluencyCalculatorStartPage(WebDriver webDriver){                                                             //        this.webDriver = driver; PageFactory.initElements(new AjaxElementLocatorFactory(this.webDriver, defaultImplicitTimeout), this);   //    PageFactory.initElements(webDriver, this);
        super(webDriver);
    }

    public FluencyCalculatorStartPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }
    public FluencyCalculatorStartPage() {
        this(null, null);
    }
    //public void setWebDriver(WebDriver webDriver) {    this.webDriver = webDriver;   }

    public boolean simpleTest() {
        logger.info(" simpleTest()");
        if(startFc != null){
            return startFc.isDisplayed() ;
        } else {                                                                                                            //  logger.error("FAIL simpleTest  ... nextStep element not found or is not displayed");
            BasePage.failTest("FAIL simpleTest  ... nextStep element not found or is not displayed", startFc, true);      //fail("FAIL  nextStep element not found or is not displayed");
            return false;
        }
    }
    @Override
    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(startFc);
    }

    public String getPageUrl() {
        return this.getWebDriver().getCurrentUrl();
    }

    public FluencyCalculatorStep1Page clickStart( ){
        WebElementHelper.scrollAndClick(getWebDriver(), startFc);
        return new FluencyCalculatorStep1Page(getWebDriver());
    }

}
