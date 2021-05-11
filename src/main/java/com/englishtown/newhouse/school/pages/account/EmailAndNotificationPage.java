package com.englishtown.newhouse.school.pages.account;
/**
 * Nikol - 08/10/2018
 * Email and notification page object
 *
 */

import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WaitToolConfig;
import com.englishtown.helpers.WebElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;

public class EmailAndNotificationPage extends BaseAccountSettingPage {
    public static final Logger logger = LoggerFactory.getLogger(EmailAndNotificationPage.class);
    public static final String pageUrl = "/account/notifications";

    private static final int TOGGLE_BUTTONS_MAX_SIZE = 5; // There should be 10 toggle buttons

        @FindBy(css = ".row div[class*='toggleGroup']") // .button")
    public List<WebElement> notificationSettingToggleList;

    public EmailAndNotificationPage(WebDriver webDriver){
        super(webDriver);
    }

    public EmailAndNotificationPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }

    public EmailAndNotificationPage(WebDriver webDriver, int waitTimeSec) {
        super(webDriver, waitTimeSec);
    }

    public EmailAndNotificationPage() {
        this(null, null);
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }


    @Override
    public boolean checkAllPageComponentsDisplayed() {
        checkAllPageComponentsDisplayed(
                notificationSettingToggleList.get(0), notificationSettingToggleList.get(TOGGLE_BUTTONS_MAX_SIZE-1) );
        return true;
    }

    public boolean simpleTest() {
        logger.info("check emailLanguageWe is present...!");
        AssertHelper.assertWebElementDisplayed(notificationSettingToggleList.get(0));
        return true;
    }
    public String getPageUrl() {
        return pageUrl;
    }

    @Override
    public ExpectedCondition getPageLoadedCondition() {
        WaitTool.waitForElementClickable_fluentWait(getWebDriver(),notificationSettingToggleList.get(0), WaitToolConfig.LONG_WAIT_4_ELEMENT,1000);
        return ExpectedConditions.visibilityOf(notificationSettingToggleList.get(0));
    }

    /**
     *
     * @return false if togle is off and true if togle is on
     *
     * class values : toggle true , toggle false >  false = toggle is off
     *
     * could use $('.row input[type="hidden"]')   and check value data
     */
    public void clickOnTogglesToSetOn(){
        setToggle(true);
    }

    public void clickOnTogglesToSetOff(){
        setToggle(false);
    }
    public void clickOnToggle(WebDriver wb,int index){
        click(wb.findElements(By.cssSelector(".row div[class*='toggleGroup'] .react-toggle-track")).get(index));
    }

    public void assert_toggle_status(WebElement toggleWe, boolean isToggleStatus){
        boolean currentToggleStatus = getToggleStatus(toggleWe);
        AssertHelper.assertThat("Is not The expected Toggle Status :"+isToggleStatus,
                currentToggleStatus, is(isToggleStatus));
    }

    public void assert_all_toggle_status( boolean isToggleStatus){
        for(WebElement toggleWe : notificationSettingToggleList) {
            assert_toggle_status(toggleWe, isToggleStatus);
        }
    }


    public void setToggle(boolean setTogleStatus){
        boolean currentToggleStatus = false;
        int index=0;
        for(WebElement toggleWe : notificationSettingToggleList) {
            currentToggleStatus = getToggleStatus(toggleWe);
            if(currentToggleStatus != setTogleStatus ) {
                clickOnToggle(getWebDriver(),index);
                logger.info("Clicked to change status [{}]", toggleWe);
                sleep(3000);
            }
            index++;
        }
    }

}




/****
 *
 /*@FindBy(className = "email-send-study-plan")
 public WebElement coachingEmailsToggleWe;

 @FindBy(className = "email-send-market-campaign")
 public WebElement updateAndOffersToggleWe;

 @FindBy(className = "email-send-daily-lesson")
 public WebElement dailyLessonToggleWe;

 @FindBy(className = "email-send-global-campaign")
 public WebElement updateAndOffersOtherEFToggleWe;

 // notification
 @FindBy(className = "chat-notify-new-message")
 public WebElement newChatMsgToggleWe;

 @FindBy(className = "chat-notify-friend-request")
 public WebElement friendRequestMsgToggleWe;

 @FindBy(className = "chat-notify-study-notifcation")
 public WebElement studyNotificationClassOpenToggleWe;*/
/*
 public EmailAndNotificationPage(WebDriver webDriver) {
 super(webDriver);
 }

 public EmailAndNotificationPage(WebDriver webDriver, String url) {
 super(webDriver, url);
 }

 public EmailAndNotificationPage() {
 this(null, null);
 }

 public void changeDetails(String newEmail,String emailLanguage, String phoneNumber ){
 logger.info("changeLanguage..!");
 sendKey(getWebDriver(),emailAddressWe,newEmail,false);
 sendKey(getWebDriver(),emailLanguageWe,emailLanguage,false);
 sendKey(getWebDriver(),mobilePhoneWe,phoneNumber,false);

 }

 public void toggleNotification(int notificationNumber){
 logger.info("toggleNotification..!");
 List <WebElement>toggleListWe = WebElementHelper.safeFindListOfElementsPresent(getWebDriver(), By.cssSelector(toggleSelectorValue),30);
 logger.info("check if notification is turned off..!");
 if(toggleListWe.get(notificationNumber).getAttribute("value")=="false"){
 //if notification turned off
 logger.info("Click on toggle button");
 click(notificationToggleBtnListWe.get(notificationNumber));
 logger.info("check if notification is turned on..!");
 AssertHelper.assertStringContains(toggleListWe.get(notificationNumber).getAttribute("value"),"true","Not able to switch on notification");
 logger.info("Click on toggle button again");
 click(notificationToggleBtnListWe.get(notificationNumber));
 logger.info("check if notification is turned off again..!");
 AssertHelper.assertStringContains(toggleListWe.get(notificationNumber).getAttribute("value"),"false","Not able to switch off notification");
 }else {
 //if notification is turned on
 logger.info("Click on toggle button");
 click(notificationToggleBtnListWe.get(notificationNumber));
 logger.info("check if notification is turned off..!");
 AssertHelper.assertStringContains(toggleListWe.get(notificationNumber).getAttribute("value"), "false", "Not able to switch off notification");
 logger.info("Click on toggle button again");
 click(notificationToggleBtnListWe.get(notificationNumber));
 logger.info("check if notification is turned On Again..!");
 AssertHelper.assertStringContains(toggleListWe.get(notificationNumber).getAttribute("value"), "true", "Not able to switch on notification");
 }
 }

 *
 */
