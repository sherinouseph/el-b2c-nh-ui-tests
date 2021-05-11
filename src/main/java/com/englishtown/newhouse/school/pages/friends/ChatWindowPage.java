package com.englishtown.newhouse.school.pages.friends;
/**
 * Sherin
 * Main chat window where you can chat to your friend,accept,decline friend request
 *
 */

import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.helpers.utils.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class ChatWindowPage extends FriendsPage {

    public static final Logger logger = LoggerFactory.getLogger(ChatWindowPage.class);
    public static final String pageUrl = "/chat/friends/#/chat/friends/user/";    // course-> my course

    public static final String CHATWINDOW_FRIENDREQUEST_BASE_CSS  = "div[class^='friend-request_']";
    public static final String CHATWINDOW_BASE_CSS                = "div[class^='conversation_']";
    public static final String CHATWINDOW_FULLNAME__CSS           = CHATWINDOW_BASE_CSS + " [class^='contact-name_']";
    public static final String CHATWINDOW_PROFILEPIC__CSS         = CHATWINDOW_BASE_CSS + " [class^='avatar_']";
    public static final String CHATWINDOW_BECOME_FRIEND__CSS      = CHATWINDOW_FRIENDREQUEST_BASE_CSS + " [class^='add']";

    public static final String CHATWINDOW_MESSAGE_BODY_CSS        = CHATWINDOW_BASE_CSS + " [class^='message-body_']";
    public static final String CHATWINDOW_SEND_ICON__CSS          = CHATWINDOW_BASE_CSS + " [class^='icon send']";
    public static final String CHATWINDOW_TEXT_AREA_CSS           = CHATWINDOW_BASE_CSS + " [class^='input-box_'] [class^='input-field_']";
    public static final String CHATWINDOW_DISABLED_TEXT_AREA_CSS           = CHATWINDOW_BASE_CSS + " [class*='disabled'] [class^='input-field_']";

    //Invitee ... User 2 ... is invited by user on ... user 2 click on a pending request
    public static final String ACCEPT_REQUEST_CSS  = CHATWINDOW_FRIENDREQUEST_BASE_CSS + " [class^='accept_']";
    public static final String DECLINE_REQUEST_CSS = CHATWINDOW_FRIENDREQUEST_BASE_CSS + " [class^='decline_']";


    @FindBy(css = ACCEPT_REQUEST_CSS)
    public WebElement acceptRequestWe;

    @FindBy(css = DECLINE_REQUEST_CSS)
    public WebElement declineRequestWe;


    @FindBy(css = CHATWINDOW_FULLNAME__CSS)
    public WebElement chatWindowUserFullNameWe;


    @FindBy(css = CHATWINDOW_PROFILEPIC__CSS)
    public WebElement chatWindoProfilePicWe;


    @FindBy(css = CHATWINDOW_FRIENDREQUEST_BASE_CSS)
    public WebElement chatAreaMessageTxtWe;


    @FindBy(css = CHATWINDOW_BECOME_FRIEND__CSS)//add friend and cancel req same selectors
    public WebElement cancelReqLinkWe;


    @FindBy(css = CHATWINDOW_TEXT_AREA_CSS)
    public WebElement chatBoxWe;


    @FindBy(css = CHATWINDOW_SEND_ICON__CSS)
    public WebElement sendMsgArrowWe;

    @FindBy(css = CHATWINDOW_DISABLED_TEXT_AREA_CSS)
    public WebElement disabledChatBoxWe;


    @FindBy(css = CHATWINDOW_MESSAGE_BODY_CSS)
    public List<WebElement> sendMessagesWe;


    public ChatWindowPage(WebDriver webDriver){
        super(webDriver);
    }

    public ChatWindowPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }
    public ChatWindowPage(WebDriver webDriver, int waitSec){
        super(webDriver, waitSec);
    }

    public ChatWindowPage() {
        this(null, null);
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Override
    public boolean checkAllPageComponentsDisplayed() {
        checkAllPageComponentsDisplayed(chatWindowUserFullNameWe,chatWindoProfilePicWe,chatAreaMessageTxtWe);
        return false;
    }



    public boolean simpleTest() {
        logger.info("simpleTest on Recent Chat Page..!");
        AssertHelper.assertWebElementDisplayed(chatWindowUserFullNameWe);
        return true;
    }

    public void sendMessage(String message) {
        logger.info("Send Message.!");
        WebElementHelper.clearAndsendKeys(getWebDriver(),chatBoxWe,message,false);
        click(sendMsgArrowWe);
    }

    public void clickOnCancelRequestLink(){
        logger.info("clickOnCancelRequestLink");
        click(cancelReqLinkWe);
    }
    //same WebElement
    public void clickOnBecomeFriedLink(){
        logger.info("clickOnCancelRequestLink");
        click(cancelReqLinkWe);
    }

    // received request
    public void clickOnAcceptRequest(){
        logger.info("clickOnAcceptRequest");
        click(acceptRequestWe);
    }

    // received request
    public void clickOnDeclineRequest(){
        logger.info("clickOnDeclineRequest");
        click(declineRequestWe);
    }

    public void assertUserName(String userName){
        logger.info("assertUserName");
        AssertHelper.assertStringContains(TestUtil.getWebElementText(chatWindowUserFullNameWe),userName,"UserName does not match - recent chat");
    }



    public void checkLatestMessage(String message){
        logger.info("checkLatestMessage");
        AssertHelper.assertStringContains(TestUtil.getWebElementText(sendMessagesWe.get(sendMessagesWe.size()-1)),message,"Message does not match");

    }
    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(chatWindowUserFullNameWe);
    }

    public String getPageUrl() {
        return pageUrl;
    }




}
