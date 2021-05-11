package com.englishtown.pages.forms;
/**
 * Email english form
 * Date: 04/09/14
 *
 */

import com.englishtown.driver.BaseRemoteWebDriver;
import com.englishtown.helpers.JavaScriptHelper;
import com.englishtown.helpers.MyWebDriverAction;
import com.englishtown.helpers.WaitTool;
import com.englishtown.pages.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class EEForm extends BaseForm {
    private static final Logger log = LoggerFactory.getLogger(EEForm.class);
    //
    public WebElement submitBtn;    //@FindBy(css = ".form .btn")
    public WebElement firstName;    //(id = "first_name")
    protected static String waitForWe = "[id*=submit],[class*=submit]";

    public EEForm(WebDriver webDriver) {
        super(webDriver);
        //if(WaitTool.waitForElementVisible(webDriver, By.cssSelector(waitForWe), 15, WaitTool.DEFAULT_POLL_SLEEP)!= null) {
        if(WaitTool.safeFindDisplayedAndEnabled(webDriver, By.cssSelector(waitForWe),WaitTool.DEFAULT_WAIT_4_ELEMENT)!= null) {         //waitForElementVisible(webDriver.findElement(By.cssSelector("[id*=submit],[class*=submit]")), 10); //[class*=submit]
            this.submitBtn = webDriver.findElement(By.cssSelector(waitForWe));                                           //"[id*=submit]"));
            this.firstName = webDriver.findElement(By.cssSelector("[name^=first]"));                                       //name("first_name"));
        } else {
            log.error(" EEForm : Element is not found : NULL returned : [{}] :" , waitForWe);
        }
    }

    public WebElement getFirstName() {        return firstName;        }
    public WebElement getSubmitBtn() {        return submitBtn;        }

    @Override
    public void submit() {
        logger.info("EEform.submit() : click sumbitBtn ....!");

        if(BaseRemoteWebDriver.currentDeviceName !=null && "NexusOne".contains(BaseRemoteWebDriver.currentDeviceName)) {
            JavaScriptHelper.highlightElement(submitBtn, webDriver);
            MyWebDriverAction.moveToElementAndClick(webDriver, submitBtn);
        } else if(BaseRemoteWebDriver.isBrowserAndVersion("explore", "10")){
            logger.info(" Use Action Click for IE10 ...!");
            MyWebDriverAction.actionClick(webDriver, this.submitBtn);
        }
        else {
            this.submitBtn.click();
        }
    }

    @Override
    protected By getFormLocator() {
        return By.tagName("form");
    }



}
