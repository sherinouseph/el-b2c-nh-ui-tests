package com.englishtown.pages.forms;
/**
 * Email english form
 * Date: 04/09/14
 *
 */

import com.englishtown.driver.BaseRemoteWebDriver;
import com.englishtown.helpers.JavaScriptHelper;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.pages.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class OEForm extends BaseForm {
    private static final Logger log = LoggerFactory.getLogger(OEForm.class);
    //
    public WebElement submitBtn;    //@FindBy(css = ".form .btn")
    public WebElement firstName;    //(id = "first_name")
    public static String OEFormWaitForWe = "form input.btn, button[type*=submit], #osformsubmit";

    public OEForm(WebDriver webDriver) {
        super(webDriver);
        if(WaitTool.waitForElementVisible(webDriver, By.cssSelector(OEFormWaitForWe), 10, WaitTool.DEFAULT_POLL_SLEEP) != null) {          //waitForElementVisible(webDriver.findElement(By.id(waitForWe)), 15);   //.cssSelector("[id*=submit]"))
            this.submitBtn = webDriver.findElement(By.cssSelector(OEFormWaitForWe));
            this.firstName = webDriver.findElement(By.name("first_name"));
        } else {
            log.error(" EEForm : Element is not found, NULL returned : [{}] :" , OEFormWaitForWe);
        }

    }

//    public void submitOEForm(){
//        this.submitBtn.click();
//    }

    public WebElement getFirstName() {        return firstName;        }
    public WebElement getSubmitBtn() {        return submitBtn;        }

    @Override
    public void submit() {
        try {
            WebElementHelper.scrollToElementLocation(webDriver, this.submitBtn, 0, 10);
            if(BaseRemoteWebDriver.getCurrentBrowserName().contains("explore")){
                JavaScriptHelper.scrollToXY(webDriver, 0, 15);
            }
            JavaScriptHelper.scrollToXY(webDriver, 0, -35);
            Thread.sleep(1000);
            this.submitBtn.click();
        }catch (Exception e){
            BasePage.failTest(e, "Submit() Exception : "+ TestUtil.getException(e, webDriver));
        }
    }
    @Override
    protected By getFormLocator() {
        return By.tagName("form");
    }

}
