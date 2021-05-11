package com.englishtown.pages.forms;

import com.englishtown.helpers.WebElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
//import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(locations = {"/applicationContext-test.xml"})
public abstract class BaseForm extends AbstractTestNGSpringContextTests {
    protected WebDriver webDriver;
    private WebElementHelper form;
//    public boolean isSpecialSubmit = false; // test
//    public boolean isUseFormEmailToSubmit = false;
//    public boolean isDifferentButton = false;
//    public String isSpecialCssSubmitButton = "Test-should-init-this";
//    public String cssSubmitBt = "TestCase-should-init-this and ~BaseTest set isSpecialCssSubmitButton to this ";

    protected BaseForm(WebDriver webDriver) {
        this.webDriver = webDriver;

    }

    public WebElement getForm() {
        if(this.form == null) {
            //this.form = WebElementHelper.safeFindElement(this.webDriver, this.getFormLocator());
            this.form = new WebElementHelper<BaseForm>(this, webDriver,
                    WebElementHelper.safeFindElement(this.webDriver, By.tagName("body")),
                    this.getFormLocator());
        }
        return this.form.getWebElement();
    }

    public abstract void submit();
    public void submitForm(WebElement we){
        we.click();
    }
    protected abstract By getFormLocator();

    protected <T> WebElementHelper<T> createHelper(By... selectors) {
        return new WebElementHelper<T>((T)this, this.webDriver, this.getForm(), selectors);
    }
//    // TODO : remove this from here all wait should be on basepage or on new class WaitTool
    public void waitForElementVisible(WebElement elementToWaitFor, Integer waitTimeInSeconds) {
        logger.info("waitForElementVisible() - element :" + elementToWaitFor + " waitTime : " + waitTimeInSeconds);
        if (waitTimeInSeconds == null) {
            waitTimeInSeconds =  10 ;
        }
        WebDriverWait wait = new WebDriverWait(webDriver, waitTimeInSeconds);
        wait.until(ExpectedConditions.visibilityOf(elementToWaitFor));  //return wait.until(ExpectedConditions.visibilityOf(elementToWaitFor));
        logger.info("waitForElementVisible()  : OK ");
    }
}
