package com.englishtown.newhouse.school.pages.friends.module;
/**
 * Nikol May 2018
 *
 * Models profile details cards … big card with chant/block unfriend and user details
 * Show when you click on my profile or when you click on my friends card or on search result card
 *
 /**
 * A card contains
 * Right side:
 user full name and flag
 English Level         Beginner
 Gender
 Age
 Living in             United Kingdom
 Native language
 Industry
 Chat accessibility    All

 *Left Side:
 Avatar
 status
 Button [chat now, un friend and block]
 *
 *
 *
 */

import com.englishtown.enumpack.chat.ChatUserStatus;
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.newhouse.school.beanandenum.enums.ProfileCardDetails;
import com.englishtown.newhouse.school.pages.core.BaseSchoolPage;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class ProfileModulePage extends BaseSchoolPage {

    public static final Logger logger = LoggerFactory.getLogger(ProfileModulePage.class);
    public static final String pageUrl = "/chat/friends/";    // course-> my course
    //--------------------------------------------------------------------------------------
    public static final String PROFILE_BASE_CSS         = "div[class^='card_']";    // move to my profile page public static final String PROFILE_HEADING_CSS     = PROFILE_BASE_CSS + " [class^='title_']";    public static final String PROFILE_UPDATE_LINK_CSS = PROFILE_BASE_CSS + " a[class^='link_']";
    // right side
    public static final String PROFILE_FULLNAME_CSS     = PROFILE_BASE_CSS + " [class^='contact-name_']";
    public static final String PROFILE_FLAG_CSS         = PROFILE_FULLNAME_CSS + " [class^='flag_']";
    public static final String PROFILE_DETAILS_lIST_CSS = PROFILE_BASE_CSS + " [class^='row_'] [class*='value_']";       //6 list all user data .. level, age **// flag-icon_ class = flag_2c4TT flag-icon_1Nvev flag-icon-gb_2UliW
    // left side
    public static final String PROFILE_PIC_CSS          = PROFILE_BASE_CSS + " [class^='avatar_'] span";                 // pic : default BB text
    public static final String PROFILE_STATUS_CSS       = PROFILE_BASE_CSS + " [class^='avatar_'] div";                  // status ...if online class = status_12Ks9 online_2SYVR
    //left side actions                                                                                                   $('div[class^="card_"] [class^="button-set_"] button:last-child')
    public static final String CHATNOW_CSS              = PROFILE_BASE_CSS + " [class^='button-set_'] button:first-child";
    public static final String ADD_UN_FRIEND_CANCEL_REQ_CSS = PROFILE_BASE_CSS + " [class^='button-set_'] button:last-child";
    public static final String BLOCK_CSS                = PROFILE_BASE_CSS + " [class^='actions_'] button";


    // Left side
    @FindBy(css = PROFILE_PIC_CSS)
    public WebElement profilePicWe;

    @FindBy(css = PROFILE_STATUS_CSS)
    public WebElement profileStatusWe;   //todo add method to check if status is online or offline

    @FindBy(css = CHATNOW_CSS)
    public WebElement chatNowBtnWe;

    @FindBy(css = ADD_UN_FRIEND_CANCEL_REQ_CSS)
    public WebElement unfriendBtnWe;

    @FindBy(css = BLOCK_CSS)
    public WebElement blockBtnWe;


    /**
     * Right side
     * my profile user details [full name, level, ****]
     *
     */
    @FindBy(css = PROFILE_FULLNAME_CSS)   // Full name .... e.g BtoCSXMQCBF BtoCREDVSU include flag
    public WebElement fullNameWe;         //was userNameWe;

    @FindBy(css = PROFILE_FLAG_CSS)
    public WebElement flagWe;

    @FindBy(css = PROFILE_DETAILS_lIST_CSS)  // 0-6   level . age *
    public List<WebElement> profileDetailsListWe;


    /**
     * get user details
     * @param profileCardDetails
     * @return
     */
    public WebElement getProfileChatDetails(ProfileCardDetails profileCardDetails){
        WebElement webElement = null;
        switch (profileCardDetails){
            case ENGLISH_LEVEL:
                logger.info("Case [{}]", profileCardDetails);
                webElement = profileDetailsListWe.get(profileCardDetails.getId());
                break;

            case GENDER:
                logger.info("Case [{}]", profileCardDetails);
                webElement = profileDetailsListWe.get(profileCardDetails.getId());
                break;

            case AGE:
                logger.info("Case [{}]", profileCardDetails);
                webElement = profileDetailsListWe.get(profileCardDetails.getId());
                break;

            case LIVINGIN:
                logger.info("Case [{}]", profileCardDetails);
                webElement = profileDetailsListWe.get(profileCardDetails.getId());
                break;

            case NATIVELANGUAGE:
                logger.info("Case [{}]", profileCardDetails);
                webElement = profileDetailsListWe.get(profileCardDetails.getId());
                break;

            case INDUSTRY:
                logger.info("Case [{}]", profileCardDetails);
                webElement = profileDetailsListWe.get(profileCardDetails.getId());
                break;

            case CHAT_ACCESSIBILITY:
                logger.info("Case [{}]", profileCardDetails);
                webElement = profileDetailsListWe.get(profileCardDetails.getId());
                break;

            default:
                logger.error("Cant find this element [{}]", profileCardDetails);
                throw new InvalidArgumentException("Can't find element for :"+profileCardDetails);
        }

        if(null == webElement)
            failTest("Cant find Web Element ...! for :"+profileCardDetails);

        return webElement;
    }


    public void checkAllProfileChatDetailsDisplayed(){
        for(ProfileCardDetails cardDetails : ProfileCardDetails.values()){
            logger.info("Checking card Element [{}] ..!", cardDetails);
            AssertHelper.assertWebElementDisplayed(getProfileChatDetails(cardDetails));
        }
    }

    /**
     * check profile details data
     *
     * @param profileDetails
     * String englishLevel,String gender,String age,String livingIn,String nativeLang,String industry,String chatAccessbility
     *
     */
    public void checkProfileSettingsValues(String ...profileDetails){
        logger.info("checkProfileSettingsValues");
        int count = -1;
        for(String details : profileDetails) {
            count++;
            AssertHelper.assertStringContains(TestUtil.getWebElementText(profileDetailsListWe.get(count)),
                    details,"Not the expected value :"+details+" .. count :"+count);
        }


    }

    public void checkUserName(String chatUsername){
        logger.info("checkUserName");
        AssertHelper.assertStringContains(TestUtil.getWebElementText(fullNameWe),chatUsername,"Full Name does not match ...!");
    }

    /**
     * Get the class value
     * if class value has online then status is online else offline ..
     * TODO all other statues
     *
     * ONLINE(1), //NOT SUPPOSE TO USE [TEDDY] OFFLINE(2),   // REALLY OFFLINE IDLE(3), BUSY(4),  APPEAR_OFFLINE(5);
     * status ...if online class = status_12Ks9 online_2SYVR
     * @return  ChatUserStatus
     */
    public ChatUserStatus getStatus(){
        logger.info("get user status online or offline  ...!"); // todo not sure about the offline value

        String statusClassValue = "-1";

        statusClassValue = TestUtil.getAttributeValue(getWebDriver(), profileStatusWe, "class");
        if(StringUtils.containsIgnoreCase(statusClassValue,"online")){
            return ChatUserStatus.ONLINE;
        }else if(StringUtils.containsIgnoreCase(statusClassValue,"offline")){
            return ChatUserStatus.OFFLINE;
        }
        return ChatUserStatus.OFFLINE;
    }

    /**
     *
     * @param chatUserStatus
     * @return
     *
     * usage isUserStatusOnline(getStatus)
     */
    public boolean isUserStatusOnline(ChatUserStatus chatUserStatus){
        if(ChatUserStatus.ONLINE.equals(chatUserStatus))
            return true;
        
        return false;
    }

    public void clickOnChatNow(){
        click(chatNowBtnWe);
    }

    public void clickOnUnFriend(){
        click(unfriendBtnWe);
    }

    public void clickOnBlock(){
        click(blockBtnWe);
    }

    //same selector for add friend and unfriend
    public void clickOnAddFriend(){
        click(unfriendBtnWe);
    }

    public void clickOnCancelRequest(){
        click(unfriendBtnWe);//same selector for friend,unfriend and cancel request
    }
    
    public void clickOnUnBlock(){
        click(blockBtnWe);
    }//same selector for block and unblock


    ///-------------------------------------------------------------------------------------

    public ProfileModulePage(WebDriver webDriver){
        super(webDriver);
    }
    public ProfileModulePage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }
    public ProfileModulePage(WebDriver webDriver, int timeoutSec) {
        super(webDriver, timeoutSec);
    }
    public ProfileModulePage() {
        this(null, null);
    }
    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(fullNameWe);
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public boolean simpleTest() {
        logger.info("simpleTest Assert Main element displayed ...!");
        AssertHelper.assertComponentsDisplayed(fullNameWe );
        AssertHelper.assertComponentsDisplayed(profileDetailsListWe.get(ProfileCardDetails.ENGLISH_LEVEL.getId()));
        AssertHelper.assertComponentsDisplayed(profilePicWe);
        return true;
    }

    @Override
    public boolean checkAllPageComponentsDisplayed() {
        logger.info("checkAllPageComponents ...!");
        checkAllProfileChatDetailsDisplayed();
        checkAllPageComponentsDisplayed( profilePicWe, profileStatusWe,flagWe, fullNameWe );
        return true;
    }

    public boolean checkProfileActionsDisplayed() {
        logger.info("checkProfileActionsDisplayed, chat, unfriend, block ...!");
        checkAllPageComponentsDisplayed( chatNowBtnWe, unfriendBtnWe, blockBtnWe);
        return true;
    }

}
