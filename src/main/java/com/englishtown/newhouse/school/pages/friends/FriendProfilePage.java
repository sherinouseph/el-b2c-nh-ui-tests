//package com.englishtown.newhouse.school.pages.friends;
///**
// * Sherin
// *
// *
// */
//
//import com.englishtown.helpers.AssertHelper;
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
//public class FriendProfilePage extends FriendsPage {
//
//    public static final Logger logger = LoggerFactory.getLogger(FriendProfilePage.class);
//    public static final String pageUrl = "/chat/friends/#/chat/friends/user/";    // course-> my course
//
//
//
//
//    @FindBy(className = "_2mILsu-870")
//    public WebElement userNameWe;
//
//    @FindBy(css = "._2c4TTwBD_c._1Nvev69Jmf")
//    public WebElement flagWe;
//
//    @FindBy(css = "._1VA04zAaWq._1HUkLb5xse")
//    public List<WebElement> profileSettingsListValuesWe;
//
//    @FindBy(css = "._17ksO1Jl2v._1QGICjXw-Q._1rd3OaCvEl")
//    public WebElement profilePicWe;
//
//    @FindBy(css = "._2BApclyoYR._3zRKt7DTue")
//    public List<WebElement> chatNowAddFriendBtn;
//
//    @FindBy(css = "._2BApclyoYR._3zRKt7DTue")
//    public List<WebElement> cancelRequestBtnWe;
//
//    @FindBy(css = "._2BApclyoYR._3zRKt7DTue")
//    public List<WebElement> deleteFriendBtnWe;
//
//    @FindBy(css = "._3l2_vyNloZ button")
//    public WebElement blockLinkWe;
//
//    @FindBy(css = "._3l2_vyNloZ button")
//    public WebElement unblockLinkWe;
//
//    @FindBy(css = "._3XbWPcHVIq")
//    public WebElement backLinkWe;
//
//    public FriendProfilePage(WebDriver webDriver){
//        super(webDriver);
//    }
//
//    public FriendProfilePage(WebDriver webDriver, String url) {
//        super(webDriver, url);
//    }
//    public FriendProfilePage(WebDriver webDriver, int waitSec){
//        super(webDriver, waitSec);
//    }
//
//    public FriendProfilePage() {
//        this(null, null);
//    }
//
//    public void setWebDriver(WebDriver webDriver) {
//        this.webDriver = webDriver;
//    }
//
//    @Override
//    public boolean checkAllPageComponentsDisplayed() {
//        checkAllPageComponentsDisplayed(userNameWe,chatNowAddFriendBtn.get(0),blockLinkWe,chatNowAddFriendBtn.get(1),flagWe,profilePicWe,backLinkWe);
//        return false;
//    }
//
//    public boolean simpleTest() {
//        logger.info("simpleTest..!");
//        AssertHelper.assertWebElementDisplayed(userNameWe);
//
//        return true;
//    }
//
//    public ExpectedCondition getPageLoadedCondition() {
//        return ExpectedConditions.visibilityOf(userNameWe);
//    }
//
//    public String getPageUrl() {
//        return pageUrl;
//    }
//
//
//
//    public void clickOnChatNowBtn(){
//        logger.info("clickOnChatNowBtn");
//        click(chatNowAddFriendBtn.get(0));
//    }
//
//    public void clickOnAddFriendBtn(){
//        logger.info("clickOnAddFriendBtn");
//        click(chatNowAddFriendBtn.get(1));
//    }
//
//    public void clickOnCancelRequestBtn(){
//        logger.info("clickOnCancelRequestBtn");
//        click(cancelRequestBtnWe.get(1));
//    }
//
//    public void clickOnDeleteFriendBtn(){
//        logger.info("clickOnDeleteFriendBtn");
//        click(deleteFriendBtnWe.get(1));
//    }
//
//
//    public void clickOnBlockLink(){
//        logger.info("clickOnBlockLink");
//        click(blockLinkWe);
//    }
//
//    public void clickOnUnBlockLink(){
//        logger.info("clickOnUnBlockLink");
//        click(unblockLinkWe);
//    }
//
//    public void clickOnBackButton(){
//        logger.info("clickOnBackButton");
//        click(backLinkWe);
//    }
//
//
//    public void checkProfileSettingsValues(String userName,String englishLevel,String gender,String age,String livingIn,String nativeLang,String industry,String chatAccessbility){
//        logger.info("checkProfileSettingsValues");
//        AssertHelper.assertStringContains(TestUtil.getWebElementText(userNameWe),userName,"Student name wrong");
//        AssertHelper.assertStringContains(TestUtil.getWebElementText(profileSettingsListValuesWe.get(0)),englishLevel,"English Level wrong");
//        AssertHelper.assertStringContains(TestUtil.getWebElementText(profileSettingsListValuesWe.get(1)),gender,"Gender wrong");
//        AssertHelper.assertStringContains(TestUtil.getWebElementText(profileSettingsListValuesWe.get(2)),age,"Age wrong");
//        AssertHelper.assertStringContains(TestUtil.getWebElementText(profileSettingsListValuesWe.get(3)),livingIn,"Living In Value wrong");
//        AssertHelper.assertStringContains(TestUtil.getWebElementText(profileSettingsListValuesWe.get(4)),nativeLang,"Native Language wrong");
//        AssertHelper.assertStringContains(TestUtil.getWebElementText(profileSettingsListValuesWe.get(5)),industry,"Industry wrong");
//        AssertHelper.assertStringContains(TestUtil.getWebElementText(profileSettingsListValuesWe.get(6)),chatAccessbility,"chat Acessbility value wrong");
//
//    }
//}
