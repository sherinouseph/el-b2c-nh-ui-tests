//package com.englishtown.newhouse.school.pages.friends;
///**
// * Sherin[nikol] May 2018
// *
// * Recent chat window part on the left of the frame
// *
// *   login as auto_chat_interaction@qp1.org
// */
//
//import com.englishtown.helpers.AssertHelper;
//import com.englishtown.helpers.WebElementHelper;
//import com.englishtown.helpers.utils.TestUtil;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.ui.ExpectedCondition;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.util.List;
//
//
//public class RecentChatPage extends FriendsPage {
//
//    public static final Logger logger = LoggerFactory.getLogger(RecentChatPage.class);
//    public static final String pageUrl = "/chat/friends/#/chat/friends/search/advanced";    // https://qa-englishlive.ef.com/chat/friends/#/chat/friends/search/advanced
//
//    public static final String PROFILE_BASE_CSS        = "div[class^='profile_']";
//
//    @FindBy(className = "_3mn2-LkFHM")
//    public WebElement userNameRecentchatWe;
//
//    @FindBy(className = "_1xc159KPNx")
//    public WebElement profilePicRecentChatWe;
//
//    @FindBy(css = "._1-1A_grgrw")
//    public List<WebElement> messagesWe;
//
//    @FindBy(className = "_28urOP_MAa")
//    public WebElement chatAreaMsgWe;
//
//    @FindBy(className = "_1qxbSXgv_n")
//    public WebElement becomeFriendLinkWe;
//
//    @FindBy(className = "_1qxbSXgv_n")
//    public WebElement cancelReqLinkWe;
//
//
//    @FindBy(css = ".LyF0pYI-YG ._33p6kv3Lzo")
//    public WebElement chatBoxWe;
//
//
//    @FindBy(className = "_2BApclyoYR")
//    public WebElement sendMsgArrowWe;
//
//
//    @FindBy(className = "_1-1A_grgrw")
//    public List<WebElement> sendMessagesWe;
//
//
//    public RecentChatPage(WebDriver webDriver){
//        super(webDriver);
//    }
//
//    public RecentChatPage(WebDriver webDriver, String url) {
//        super(webDriver, url);
//    }
//    public RecentChatPage(WebDriver webDriver, int waitSec){
//        super(webDriver, waitSec);
//    }
//
//    public RecentChatPage() {
//        this(null, null);
//    }
//
//    public void setWebDriver(WebDriver webDriver) {
//        this.webDriver = webDriver;
//    }
//
//    @Override
//    public boolean checkAllPageComponentsDisplayed() {
//        checkAllPageComponentsDisplayed(userNameRecentchatWe,profilePicRecentChatWe,chatBoxWe);
//        return false;
//    }
//
//    public boolean checkAllPageComponentsDisplayedNotFriends() {
//        checkAllPageComponentsDisplayed(userNameRecentchatWe,profilePicRecentChatWe,chatBoxWe,chatAreaMsgWe,becomeFriendLinkWe);
//        return false;
//    }
//
//
//
//    public boolean simpleTest() {
//        logger.info("simpleTest on Recent Chat Page..!");
//        AssertHelper.assertWebElementDisplayed(userNameRecentchatWe);
//        return true;
//    }
//
//
//    public void sendMessage(String message) {
//        logger.info("Send Message.!");
//        WebElementHelper.clearAndsendKeys(getWebDriver(),chatBoxWe,message,false);
//        click(sendMsgArrowWe);
//    }
//
//    public void clickOnBecomeFriendsLink(){
//        logger.info("clickOnBecomeFriendsLink");
//        click(becomeFriendLinkWe);
//    }
//
//    public void assertUserName(String userName){
//        logger.info("assertUserName");
//        AssertHelper.assertStringContains(TestUtil.getWebElementText(userNameRecentchatWe),userName,"UserName does not match - recent chat");
//    }
//
//    public void clickOnCancelRequestLink(){
//        logger.info("clickOnCancelRequestLink");
//        click(cancelReqLinkWe);
//    }
//
//    public void checkLatestMessage(String message){
//        logger.info("checkLatestMessage");
//        AssertHelper.assertStringContains(TestUtil.getWebElementText(messagesWe.get(messagesWe.size()-1)),message,"Message does not match");
//
//    }
//
//    public ExpectedCondition getPageLoadedCondition() {
//        return ExpectedConditions.visibilityOf(userNameRecentchatWe);
//    }
//
//    public String getPageUrl() {
//        return pageUrl;
//    }
//
//
//
//
//}
