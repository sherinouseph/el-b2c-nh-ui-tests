package com.englishtown.newhouse.school.pages.support.newhouse.component;
/**
 * Nikol Jul 2018
 * New house Email us
 * https://englishlive.ef.com/1/support/
 *
 *
 */

import com.englishtown.helpers.*;
import com.englishtown.newhouse.school.pages.core.BaseSchoolPage;
import com.englishtown.tests.core.BaseTestHelper;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class EmailPage extends BaseSchoolPage {
    public static final Logger logger = LoggerFactory.getLogger(EmailPage.class);
    public static final String pageUrl = "/1/support/";


    @FindBy(name = "email")
    public WebElement emailTxtWe;

    @FindBy(className = "Select-arrow") //"Select-placeholder" cant focus ) try Select-control "Select-arrow"  // only one show at te time ... once selected not shown any more .. changed to select value
    public WebElement reasonWe;

    @FindBy(name = "message")
    public WebElement messageWe;

    ////     css ??/ dear God forgive me
    @FindBy(css = "form div span span font font")
    public List<WebElement> submitBtnListWe;  // third is send email best user submit on any other element

    //Your e-mail has reached us.
    @FindBy(className = "message")
    public List<WebElement> tyEmailMessageListWe; // is the second element that contains Your e-mail has reached us.
    //---------------------------------------------------------------------------------------------------------------
    public EmailPage(WebDriver webDriver, int waitSec){
        super(webDriver, waitSec);
    }
    public EmailPage(WebDriver webDriver){
        super(webDriver);
    }
    public EmailPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }
    public EmailPage() {
        this(null, null);
    }
    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    //---------------------------------------------------------------------------------------------------------------

    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(emailTxtWe);
    }

    public boolean simpleTest() {
        logger.info("check emailTxtWe is displayed...!");
        AssertHelper.assertWebElementDisplayed(emailTxtWe);
        return true;
    }

    @Override
    public boolean checkAllPageComponentsDisplayed() {
        checkAllPageComponentsDisplayed(emailTxtWe, messageWe, reasonWe);//, submitBtnListWe.get(2));
        return false;
    }

    public void enterEmailUsDataAndSend(String email, String category, String subCategory, String msg){
        typeEmail(email);
        typeCategory(category );
        sleep(1000);
        typeCategory(subCategory );
        sleep(1000);
        typeMessage(msg);
        sleep(600);
        clickSendEmail();
    }

    public void typeEmail(String email){
        JavaScriptHelper.scrollToXY(getWebDriver(), 600, 0);
        sendKey(getWebDriver(), emailTxtWe, email, true);
    }

    public void typeCategory(String reason){
        click(reasonWe);
        sleep(500);        //Point arrow = reasonWe.getLocation();        JavaScriptHelper.clickAtWindowXY(webDriver, arrow.getX()-30, arrow.y-30);        //WebElementHelper.seleselectOptinUsingDownArrowKey(reasonWe, 20, Keys.ARROW_DOWN);
        WebElementHelper.selectOptinUsingDownArrowKey(reasonWe, 1, Keys.ENTER);
        sleep(500);
        //sendKey(getWebDriver(), reasonWe, reason, true);
    }
    /*
    public void typeSubCategory(String reason){
        sendKey(getWebDriver(), reasonWe, reason, false);
    }*/

    public void typeMessage(String msg){
        sendKey(getWebDriver(), messageWe, msg, false);
    }

    public void clickSendEmail(){
        click(submitBtnListWe.get(2));
    }

    public void checkEmailSent(){
        logger.info("checkEmailSent");
        if(null != tyEmailMessageListWe && tyEmailMessageListWe.size() > 0) {
            // init page for this
            WaitTool.waitForCondition(ExpectedConditions.visibilityOf(tyEmailMessageListWe.get(1)), getWebDriver(),
                    WaitTool.MED_WAIT_4_ELEMENT25);
            AssertHelper.assertWebElementDisplayed(tyEmailMessageListWe.get(1));
            AssertHelper.assertWebElementTextContains("has reached", tyEmailMessageListWe.get(1));
        }else
            failTest("Cant get web element for email thank you message ....!");

    }

    //TODO search

    public String getPageUrl() {
        return pageUrl;
    }

}


//todo 2 select item
//@FindBy(css = ".Select-value")    // 21 reason to contact
//public List<WebElement> reasonListWe;
//    @FindBy(css = "textarea[name='message']")//    public WebElement messageWe;
//TODO search