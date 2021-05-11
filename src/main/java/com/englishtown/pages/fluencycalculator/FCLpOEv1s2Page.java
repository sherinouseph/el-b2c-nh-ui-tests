package com.englishtown.pages.fluencycalculator;
/**
 * http://www.englishtown.it/lp/oe/fluency-calculator-v1-s2/
 *  2 option for the user one is OE form and
 *  a link for OS-> checkout
 *  same page as : www.englishtown.it/lp/fc/fluency-calculator-v1-s2.html
 *  Only the first one ptn=face and second one ptn=pkge
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


public class FCLpOEv1s2Page extends BasePage {

    public static final Logger logger = LoggerFactory.getLogger(FCLpOEv1s2Page.class);

    @FindBy(css = ".linkbutton-component a.btn")            //(css = "a .btn")   //"section a.btn"
    public WebElement checkoutLink;        // OS users left page link

    @FindBy(id = "osformsubmit")
    public WebElement osformsubmitBtn;
    
    public FCLpOEv1s2Page(WebDriver webDriver){      //        this.webDriver = driver;//        PageFactory.initElements(new AjaxElementLocatorFactory(this.webDriver, defaultImplicitTimeout), this); //AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(this.webDriver, js_timeout_med);
        super(webDriver);
    }
    public FCLpOEv1s2Page(WebDriver webDriver, String url) {
        super(webDriver, url);
    }
    public FCLpOEv1s2Page() {
        this(null, null);
    }
    //public void setWebDriver(WebDriver webDriver) {    this.webDriver = webDriver;   }

    public boolean simpleTest() {
        logger.info(" simpleTest()");
        if(checkoutLink != null ){
            return checkoutLink.isDisplayed() ;
        } else {                                                                                                          //logger.error("FAIL simpleTest  ... nextStep element not found or is not displayed");
            BasePage.failTest("FAIL simpleTest  ... nextStep element not found or is not displayed", true);             //fail("FAIL  nextStep element not found or is not displayed");
            return false;
        }
    }

    public void clickCheckout(){
        WebElementHelper.click(checkoutLink);
    }

    @Override
    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(osformsubmitBtn);
    }


}
