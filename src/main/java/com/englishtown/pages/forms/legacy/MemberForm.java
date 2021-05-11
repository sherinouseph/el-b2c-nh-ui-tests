package com.englishtown.pages.forms.legacy;

import com.englishtown.driver.BaseRemoteWebDriver;
import com.englishtown.helpers.JavaScriptHelper;
import com.englishtown.helpers.MyWebDriverAction;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.pages.core.BasePage;
import com.englishtown.pages.forms.BaseForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.testng.Assert.fail;

public class MemberForm extends BaseForm {

    private static final Logger logger = LoggerFactory.getLogger(MemberForm.class);

    protected WebElementHelper<MemberForm> firstName;
    protected WebElementHelper<MemberForm> lastName;
    protected WebElementHelper<MemberForm> emailAddress;
    protected WebElementHelper<MemberForm> password;
    protected WebElementHelper<MemberForm> confirmPassword;
    protected WebElementHelper<MemberForm> emailEnglish;
    protected WebElementHelper<MemberForm> telephone;
    protected WebElementHelper<MemberForm> submitButton;

    // TODO add other elemEnts - age , telephone- etc REFACTOR
    public MemberForm(WebDriver webDriver) {
        super(webDriver);
        //logger.info("\n\n  MemberForm after super  "+webDriver.manage().getCookies().toString()+"\n\n");
        this.firstName = this.createHelper(By.name("FirstName"));
        this.lastName = this.createHelper(By.name("LastName"));
        this.emailAddress = this.createHelper(By.name("Email"));
        this.password = this.createHelper(By.name("InputPassword"));
        this.confirmPassword = this.createHelper(By.name("confirmPassword"));
        this.emailEnglish = this.createHelper(By.name("EmailEnglish"));
        this.telephone = this.createHelper(By.name("Telephone"));
        this.submitButton = this.createHelper(By.id("submit"));
    }

    public WebElementHelper<MemberForm> getFirstName() {
        return firstName;
    }

    public WebElementHelper<MemberForm> getLastName() {
        return lastName;
    }

    public WebElementHelper<MemberForm> getEmailAddress() {
        return emailAddress;
    }

    public WebElementHelper<MemberForm> getPassword() {
        return password;
    }

    public WebElementHelper<MemberForm> getConfirmPassword() {
        return confirmPassword;
    }

    public WebElementHelper<MemberForm> getEmailEnglish() {
        return emailEnglish;
    }

    public WebElementHelper<MemberForm> getTelephone() {
        return telephone;
    }


    @Override
    public void submit() {
        try{
            this.submitButton.setAutoScroll(true);
            Thread.sleep(100);
            if(BaseRemoteWebDriver.currentDeviceName !=null) {
                if (BaseRemoteWebDriver.currentDeviceName.toLowerCase().contains("nexus")) {
                    logger.info("Nexus device Scroll set to true");
                    JavaScriptHelper.highlightElement(this.submitButton.getWebElement(), webDriver);
                    MyWebDriverAction.moveToElementAndClick(webDriver, this.submitButton.getWebElement());
                }
            }else {
                logger.info(" Scroll set to true");
                this.submitButton.setAutoScroll(true);
                this.submitButton.getWebElement().click();
            }
        }catch (Exception e){
            BasePage.failTest(e, "MemberForm.submit() Failed to click ...!", true);
        }
    }

    @Override
    protected By getFormLocator() {
        return By.id("memberform");
    }
}
