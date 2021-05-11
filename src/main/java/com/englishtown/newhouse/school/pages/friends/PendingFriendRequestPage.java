//package com.englishtown.newhouse.school.pages.friends;
///**
// * Sherin
// *
// *
// */
//
//import com.englishtown.helpers.AssertHelper;
//import com.englishtown.helpers.WebElementHelper;
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
//public class PendingFriendRequestPage extends FriendsPage {
//
//    public static final Logger logger = LoggerFactory.getLogger(PendingFriendRequestPage.class);
//    public static final String pageUrl = "/chat/friends/#/chat/friends/user/";    // course-> my course
//
//
//
//
//
//    @FindBy(className = "_3mn2-LkFHM")
//    public WebElement userNamePendingFriendRequestWe;
//
//    @FindBy(className = "_1xc159KPNx")
//    public WebElement profilePicPendingFriendReqWe;
//
//
//    @FindBy(className = "_28urOP_MAa")
//    public WebElement chatAreaMsgPendingFriendReqWe;
//
//
//    @FindBy(className = "_1qxbSXgv_n")
//    public WebElement cancelReqLinkWe;
//
//
//    @FindBy(className = "_33p6kv3Lzo")
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
//    public PendingFriendRequestPage(WebDriver webDriver){
//        super(webDriver);
//    }
//
//    public PendingFriendRequestPage(WebDriver webDriver, String url) {
//        super(webDriver, url);
//    }
//    public PendingFriendRequestPage(WebDriver webDriver, int waitSec){
//        super(webDriver, waitSec);
//    }
//
//    public PendingFriendRequestPage() {
//        this(null, null);
//    }
//
//    public void setWebDriver(WebDriver webDriver) {
//        this.webDriver = webDriver;
//    }
//
//    @Override
//    public boolean checkAllPageComponentsDisplayed() {
//        checkAllPageComponentsDisplayed(userNamePendingFriendRequestWe,profilePicPendingFriendReqWe,chatAreaMsgPendingFriendReqWe);
//        return false;
//    }
//
//
//
//    public boolean simpleTest() {
//        logger.info("simpleTest on Recent Chat Page..!");
//        AssertHelper.assertWebElementDisplayed(userNamePendingFriendRequestWe);
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
//
//    public void clickOnCancelRequestLink(){
//        logger.info("clickOnCancelRequestLink");
//        click(cancelReqLinkWe);
//    }
//    public ExpectedCondition getPageLoadedCondition() {
//        return ExpectedConditions.visibilityOf(userNamePendingFriendRequestWe);
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
