package com.englishtown.pages.forms;

import com.englishtown.driver.BaseRemoteWebDriver;
import com.englishtown.helpers.JavaScriptHelper;
import com.englishtown.helpers.MyWebDriverAction;
import com.englishtown.helpers.WebElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OSForm extends BaseForm {
    private static final Logger log = LoggerFactory.getLogger(OSForm.class);
    private WebElementHelper<OSForm> submitButton;
    private WebElementHelper<OSForm> firstName;
    private WebElementHelper<OSForm> lastName;
    private WebElementHelper<OSForm> emailAddress;
    private WebElementHelper<OSForm> phoneNumber;
    private WebElementHelper<OSForm> password;
    private WebElementHelper<OSForm> confirmPassword;
    private WebElementHelper<OSForm> emailEnglish; //emailEnglish
    private WebElementHelper<OSForm> termsAcceptance;

    public boolean isMyPasswordSelector = true;

    public OSForm(WebDriver webDriver) {
        super(webDriver);
        this.submitButton = this.createHelper(By.cssSelector("[id*=submit] , [class*=submit-nikol-] , button[type=submit]"));//, By.id("osformsubmit") ); //a[id*="submit"]  "a#submit")     form a[id*='submit'] WaitTool.findElement(webDriver, By.cssSelector("[id*=submit] , [class*=submit-nikol-]") );    //
        this.firstName = this.createHelper(By.name("firstname"));
        this.lastName = this.createHelper(By.name("lastname"));
        this.emailAddress = this.createHelper(By.name("email"));
        this.phoneNumber = this.createHelper(By.name("telephone"));
        if(isMyPasswordSelector) {
            this.password = this.createHelper(By.name("mypassword"));
        } else {
            this.password = this.createHelper(By.name("password"));
        }
        this.emailEnglish = this.createHelper(By.cssSelector("form input[type=checkbox]"));  //(By.name("englishemail"));   //emailenglish           englishemail
    }

    public WebElementHelper<OSForm> getPassword() {
        if(isMyPasswordSelector) {
            return this.password = this.createHelper(By.name("mypassword"));
        } else {
            return this.password = this.createHelper(By.name("password"));
        }
        //return password;
    }

    public WebElementHelper<OSForm> getEmailAddress() {
        return emailAddress;
    }

    public WebElementHelper<OSForm> getPhoneNumber() {
        return phoneNumber;
    }

    public WebElementHelper<OSForm> getEmailEnglish() {
        return emailEnglish;
    }

    public WebElementHelper<OSForm> getFirstName() {
        return firstName;
    }

    public WebElementHelper<OSForm> getLastName() {
        return lastName;
    }

    @Override
    public void submit() {
        logger.info("EEform.submit() : click sumbitBtn ....!");
        if(BaseRemoteWebDriver.currentDeviceName !=null && "NexusOne".contains(BaseRemoteWebDriver.currentDeviceName)) { // nexus issue  Element is not clickable at point (884, 178).
            JavaScriptHelper.highlightElement(this.submitButton.getWebElement(), webDriver);
            MyWebDriverAction.moveToElementAndClick(webDriver, this.submitButton.getWebElement());
        } else {
            this.submitButton.getWebElement().click();
        }
    }

    @Override
    protected By getFormLocator() {
        return By.tagName("form");
    }

}
