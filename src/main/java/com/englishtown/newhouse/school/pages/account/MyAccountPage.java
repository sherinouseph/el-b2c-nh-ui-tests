package com.englishtown.newhouse.school.pages.account;
/**
 * Sherin - 02/09/2020
 * Your account page page object
 *
 */


import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WaitToolConfig;
import com.englishtown.helpers.utils.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.text.IsEmptyString.isEmptyOrNullString;

;


public class MyAccountPage extends BaseAccountSettingPage {
    public static final Logger logger = LoggerFactory.getLogger(MyAccountPage.class);


    public static final String pageUrl = "/account/dashboard";  //"/customerservice/dashboard";
    public static final String LAST_BILL_REGEX = "Son fatura: ₺[0-9]{1,3},[0-9]{2} ödeme tarihi 20[1-9]{2}-[0-9]{2}-[0-9]{2}";
    public static final String NEXT_BILL_REGEX = "Sıradaki fatura: ₺[0-9]{1,3},[0-9]{2} planlanan ödeme tarihi 20[1-9]{2}-[0-9]{2}-[0-9]{2}";

    public final String LIVE_HELP_BTN_CSS = "input.btn-block";




    /**
     * subscription features  [GL, PL TOEIC , ge **]
     */
     @FindBy(css = "a[href='/account/billing-and-features']")
     public List <WebElement > viewBillingsAndFeaturesWe;

     @FindBy(css = ".ui.grid a[href='/account/personal-details']")
     public WebElement updateProfileDetailsWe;

     @FindBy(css = "div[class*='dashboard-email']") // ".panel-dashboard p:first-child span")
     public WebElement userNameWe;

     @FindBy(css = "[class*='grants-and-credits_']")
     public WebElement offerDescriptionWe;

     @FindBy(css = "a[href$='/redirect?destination=upsell']")
     public WebElement exploreUpgradeOptionsLinkWe;


     @FindBy(css =".ui.grid a[href*='redirect?destination=help']")
     public WebElement liveHelpLinkWe;


    @FindBy(css = "[class^='line_']")      // Last / next bill
    public List<WebElement> billTxtWe;

  @FindBy(css = "[class$='dashboard-payment-method']")      // Last / next bill
  public WebElement paymentMethodWe;




    public MyAccountPage(WebDriver webDriver){
        super(webDriver);
    }
    public MyAccountPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }
    public MyAccountPage(WebDriver webDriver, int waitTimeSec) {
        super(webDriver, waitTimeSec);
    }
    public MyAccountPage() {
        this(null, null);
    }
    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Override
    public ExpectedCondition getPageLoadedCondition() {
      WaitTool.waitForElementVisible_fluentWait(getWebDriver(),exploreUpgradeOptionsLinkWe, WaitToolConfig.LONG_WAIT_4_ELEMENT,1000);
      return ExpectedConditions.visibilityOf(exploreUpgradeOptionsLinkWe);
    }

    public boolean simpleTest() {
        logger.info("Username text should be shown with email .....!");
        WaitTool.waitForElementVisible_fluentWait(getWebDriver(),userNameWe, WaitToolConfig.LONG_WAIT_4_ELEMENT,1000);
        AssertHelper.assertWebElementDisplayed(userNameWe); //viewDetailsLinkWe);
        return true;
    }

    @Override
    public boolean checkAllPageComponentsDisplayed() {
        WaitTool.waitForCondition(ExpectedConditions.elementToBeClickable(userNameWe), getWebDriver(), WaitToolConfig.MED_WAIT_4_ELEMENT);
        checkAllPageComponentsDisplayed(viewBillingsAndFeaturesWe.get(0),viewBillingsAndFeaturesWe.get(1), updateProfileDetailsWe,exploreUpgradeOptionsLinkWe,liveHelpLinkWe,billTxtWe.get(2));
        return false;
    }

    public void checkUsername(String userName){
        logger.info("checkUsername is [{}]",userName);
        AssertHelper.assertStringContains(TestUtil.getWebElementText(userNameWe),userName,"Not the expected Username ...!");
    }

    /**
     * Actions
     */
    public void clickViewDetailsLink(){
        logger.info("clickViewDetailsLink");
        click(viewBillingsAndFeaturesWe.get(0));
    }

    public void clickOnViewBillingsAndFeauresLink(){
        logger.info("clickOnViewBillingsAndFeauresLink");
      click(viewBillingsAndFeaturesWe.get(1));
    }

//    public void clickChangePic(){
//        logger.info("clickChangePicAndSelectPic");
//        click(changePicWe.get(0));
//    }

    public void selectPic(){
        logger.info("selectPic ...!");
        //yet to implement select pic
    }

    public void clickExploreUpgradeOptionLink(){
        logger.info("click exploreUpgradeOptionLink  ...!");
        click(exploreUpgradeOptionsLinkWe);
    }

  public void clickOnUpdateProfileLink(){
    logger.info("click exploreUpgradeOptionLink  ...!");
    click(exploreUpgradeOptionsLinkWe);
  }

  public void clickOnLiveHelpLink(){
    logger.info("clickOnLiveHelpLink  ...!");
    click(liveHelpLinkWe);
  }
    /**
     * Check if web element is green - turned on/activated
     * so will do a find on element and if found then is true what we looking for - true or false
     *
     * list of privacy setting > contains spam class light true/false  if true then green
     *
     * @settingStatus  -- > true or false
     */
//    public boolean isPrivacySetting(boolean settingStatus, PrivacySettingMyAccountPage privacySettingItem){
//        //WebElement privacySetting = privacySettingListWe.get(privacySettingItem.getId()).findElement(By.cssSelector(".light."+Boolean.toString(settingStatus)));
//        WebElement privacySetting = privacySettingListWe.get(privacySettingItem.getId());
//
//        boolean isFoundWe = WaitTool.findElement(getWebDriver(),privacySetting,
//                By.cssSelector(".light."+Boolean.toString(settingStatus)), 5, 1000);
//
//        return isFoundWe;
//    }

    /**
     * use is status TRUE for checked ...
     *  IsShowAsOnlineByDefault    CanProfileViewableByEveryone  CanReceiveMessageFromEveryone
     * @param containsClass
     * @param isStatus     checked or not
     */
    // replace with isPrivacySetting
    /*public void checkWebElementSetting(String containsClass, boolean isStatus) {
        logger.info("checkProfileStatus");
        AssertHelper.assertThat("Not the expected Setting["+isStatus+"] for["+containsClass+"]",
                isPrivacySetting(containsClass), is(isStatus));
    }*/

    public void checkOfferDescription(){
        logger.info("checkOfferDescription");
        String offerDescription = TestUtil.getWebElementText(offerDescriptionWe);
        AssertHelper.assertThat("Offer Description is NULL or Empty...!", offerDescription, not(isEmptyOrNullString()) );      //AssertHelper.assertThat("Offer Description is NULL ...!", offerDescription, is(notNullValue()) );        AssertHelper.assertThat("Offer Description is Empty ...!", offerDescription, not(isEmptyString()) );
    }

    /**
     *
     */
    public void checkLastBill(){
        logger.info("checkLastBill");
        String lastBill = TestUtil.getWebElementText(billTxtWe.get(2));
        AssertHelper.assertThat("Last bill is NULL or Empty...!", lastBill, not(isEmptyOrNullString()) );
        //todo AssertHelper.assertThat("Last bill text is not the expected one ...!", lastBill, RegexMatcher.matchesRegex(LAST_BILL_REGEX));
    }

    public void checkNextBill() {
        logger.info("checkNextBill");
        String nextBill = TestUtil.getWebElementText(billTxtWe.get(3));
        AssertHelper.assertThat("Next Bill is NULL or Empty...! ...!", nextBill, not(isEmptyOrNullString()));
       //todo AssertHelper.assertThat("Next bill text is not the expected one ...!", nextBill, RegexMatcher.matchesRegex(NEXT_BILL_REGEX));
    }

  public void checkPaymentMethod() {
    logger.info("checkPaymentMethod");
    AssertHelper.assertWebElementDisplayed(getWebDriver().findElement(By.cssSelector("[class$='dashboard-payment-method'] img")));

  }

  @Override
  public String getPageUrl(){
    return pageUrl;
  }


}


    /** old house
     *
     *

     public boolean isUpdatePaymentPopupNotShown() {
     logger.info("isUpdatePaymentPopupNotShown ...! ");
     // WaitTool.waitForCondition(ExpectedConditions.invisibilityOfElementLocated(By.id(SUBMIT_POPUP_BTN)),
     //                                                                     getWebDriver(), WaitToolConfig.WAIT_5s);
     return true;
     }

    public boolean isUpdatePaymentPopupShown() {
        logger.info("isUpdatePaymentPopupShown ...! check submitPaymentBtnWe displayed");
        //AssertHelper.assertWebElementDisplayed(submitPaymentBtnWe);
        //AssertHelper.assertWebElementDisplayed(forgotPwdLinkWe);
        return true;
    }

 @FindBy(css = "#subscriptions .list-group-item")
 public List<WebElement> subscriptionFeatureListWe;

 public void checkUserSubscriptionFeatures(int listSizeMoreThan){
 logger.info("checkUserSubscriptionFeatures" + listSizeMoreThan);
 AssertHelper.assertElementSizeMoreThanOrEqual(getWebDriver(), subscriptionFeatureListWe, listSizeMoreThan);
 }

 public void checkUserSubscriptionItemContentNotBlank(int index){
 logger.info("checkOneUserSubscriptionContentNotBlank index:" + index);
 AssertHelper.assertThat("", TestUtil.getWebElementText(subscriptionFeatureListWe.get(index)), not(isEmptyOrNullString()) );
 }


 public void clickChangeDetailsLink(){
 logger.info("clickChangeDetailsLink");
 click(changeDetailsLinkWe);
 }
 public void clickChangePwdLink(){
 logger.info("clickchangePwdLink");
 WaitTool.waitForCondition(ExpectedConditions.elementToBeClickable(changePwdLinkWe), getWebDriver(), WaitToolConfig.MED_WAIT_4_ELEMENT25);
 click(changePwdLinkWe);
 }

 public void clickGoToBillingsLink(){
 logger.info("clickGoToBillingsLink");
 //WaitTool.waitForElementVisibleAndClickable(By.cssSelector(REFER_FRIEND_LINK_CSS), getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
 click(goTobillingLinkWe);
 }


 public void clickLiveHelpBtn(){
 logger.info("clickLiveHelpBtn");
 WaitTool.waitForElementVisibleAndClickable(By.cssSelector(LIVE_HELP_BTN_CSS), getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
 click(liveHelpBtnWe);
 }


 public void clickReferAFriendBtn(){
     logger.info("clickReferAFriendBtn");
     WaitTool.waitForElementVisibleAndClickable(By.cssSelector(REFER_FRIEND_BTN_CSS), getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
     click(referAFriendBtnWe);
     }
     public void clickReferAFriendLink(){
     logger.info("clickReferAFriendLink");
     WaitTool.waitForElementVisibleAndClickable(By.cssSelector(REFER_FRIEND_LINK_CSS), getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
     click(referAFriendLinkWe);
     }

 public void clickCancelSubscriptionIcon(){
 logger.info("clickCancelSubscriptionIcon");
 click(cancelSubscriptionIconWe);
 }

 public void clickUpdatePaymentBtn(){
 logger.info("clickUpdatePaymentBtn");
 click(updatePaymentWe);
 }


 public void clickClosePassPopupBtn(){
 logger.info("clickClosePassPopupBtn");
 click(closeIconWe);
 }

 public void clickSubmitPassOnPopup(){
 click(submitPaymentBtnWe);
 }

 public void checkPasswordValidationMsg(String msg){
 logger.info("checkPasswordValidationMsg");
 //WaitTool.waitForElementVisible(getWebDriver(), By.cssSelector(PASS_VALIDATION_CSS), WaitTool.DEFAULT_IMPLICIT_WAIT);
 AssertHelper.assertStringContains(TestUtil.getWebElementText(passwordValidationMsgWe), msg,
 "Not the expected pass validation msg ...!");
 }
 public void enterPassword_UpdatePayment(String password){
 logger.info("reEnterPassword_UpdatePayment");
 sendKey(getWebDriver(),passwordWe,password,false);
 }

 public void updatePaymentPopupHasUserName(String emailId){
 logger.info("UpdatePaymentPopupHasUserName");
 AssertHelper.assertStringContains(TestUtil.getWebElementText(updatePaymentPopupContentWe),emailId,"EmailId not present in the popup");
 }



 //public static final String PASS_VALIDATION_MSG = "Password is incorrect. Please re-enter or click on"; //CONTAINS
 /*public final String SUBMIT_POPUP_BTN  = "loginBtn";  //id
 public final String LIVE_HELP_BTN_CSS = "input.btn-block";
 public final String REFER_FRIEND_LINK_CSS = ".page-header em a";
 public final String REFER_FRIEND_BTN_CSS  = ".panel-body a[href='/school/courseservices/Referrals.aspx']";
 public final String PASS_VALIDATION_CSS   = "#loginForm .tooltip-inner";
 */
    /**
     * subscription features  [GL, PL TOEIC , ge **]
     *
    @FindBy(css = ".panel-body a[href='/customerservice/personaldetails#details']")
    public WebElement changeDetailsLinkWe;

    @FindBy(css = ".panel-body a[href='/customerservice/personaldetails#password']")
    public WebElement changePwdLinkWe;

    @FindBy(css = ".panel-dashboard p:first-child span")
    public WebElement userNameWe;
    //
    @FindBy(className = "glyphicon-remove-sign")
    public WebElement cancelSubscriptionIconWe;

    @FindBy(css = ".list-inline a[href='/customerservice/billingfeature']")
    public WebElement goTobillingLinkWe;

    @FindBy(css = REFER_FRIEND_BTN_CSS) //".panel-body a[href='/school/courseservices/Referrals.aspx']")
    public WebElement referAFriendBtnWe;

    @FindBy(css = REFER_FRIEND_LINK_CSS) //".page-header em a")
    public WebElement referAFriendLinkWe;

    @FindBy(css = LIVE_HELP_BTN_CSS)
    public WebElement liveHelpBtnWe;

    @FindBy(css = ".panel-body a[href='/customerservice/helpcenter']")
    public WebElement viewCommonQuestionLinkWe;

    @FindBy(css = "input[type='file']")
    public WebElement changePicWe;

    @FindBy(css = ".popup-button input[type='button']")
    public WebElement updatePaymentWe;

    @FindBy(css = ".panel-footer a.btn-action")
    public WebElement exploreUpgradeOptionsLinkWe;

    /**
     * update payment popup
     *
     *
    @FindBy(className = "modal-content")
    public WebElement updatePaymentPopupContentWe;

    @FindBy(css = ".login-panel>div")
    public WebElement popupMsgWe;   // contains username

    @FindBy(id = "password")
    public WebElement passwordWe;

    @FindBy(id = SUBMIT_POPUP_BTN)
    public WebElement submitPaymentBtnWe;

    @FindBy(className = "loginpanelfgtpwdlink")
    public WebElement forgotPwdLinkWe;

    @FindBy(className = "close")
    public WebElement closeIconWe;   //[x]

    @FindBy(css = PASS_VALIDATION_CSS)
    public WebElement passwordValidationMsgWe;


    String updatePaymentUrl="checkout/payment/update-cc";
*/

    // NH
/**
 * update payment popup
 *
 *
 @FindBy(className = "modal-content")
 public WebElement updatePaymentPopupContentWe;

 @FindBy(css = ".login-panel>div")
 public WebElement popupMsgWe;   // contains username

 @FindBy(id = "password")
 public WebElement passwordWe;

 @FindBy(id = SUBMIT_POPUP_BTN)
 public WebElement submitPaymentBtnWe;

 @FindBy(className = "loginpanelfgtpwdlink")
 public WebElement forgotPwdLinkWe;

 @FindBy(className = "close")
 public WebElement closeIconWe;   //[x]

 @FindBy(css = PASS_VALIDATION_CSS)
 public WebElement passwordValidationMsgWe;


 String updatePaymentUrl="checkout/payment/update-cc";

 /*
 @FindBy(css = ".left[class*='headerTopLeft_']")
 public WebElement offerDescriptionWe;

 @FindBy(css = ".ui.top a" )            //"#subscriptions a[href='/customerservice/billingfeature']")
 private WebElement viewDetailsLinkWe;   // goes to billing link

 @FindBy(css = ".ui.bottom a")    //".panel-footer a.btn-action")
 public WebElement exploreUpgradeOptionsLinkWe;

 @FindBy(className = "dashboard-email")    // @FindBy(css = "div[class$='dashboard-email']")     // ".panel-dashboard p:first-child span")
 public WebElement userNameWe;                                                                                           //@FindBy(css = "[class^='line_'] a")    public List<WebElement> yourAccountLinksListWe;     // 0-updateProfile, 1-billing, 2-updatePrivacy 3-viewCommnonQuestion

 @FindBy(css = "span[class*='profileLink_']")
 public WebElement updateProfileLinkWe;

 // Billing --------------------------------------------------------------------------------------------------
 @FindBy(css = "div[class$='dashboard-last-bill']")      // Last bill: 49(GBP) paid on 2018-05-22
 public WebElement lastBillTxtWe;

 @FindBy(css = "div[class$='dashboard-next-bill']")     // Next bill: 49(GBP) schedued for 2018-06-21
 public WebElement nextBillTxtWe;

 @FindBy(css = "a[href$='/1/account/billing-and-features']")
 public WebElement viewBillLinkWe;

 @FindBy(css = ".dashboard-payment-method")
 public WebElement paymentMethodWe;

 // P S ----------------------------------------------------------------------------------------------------
 //
 @FindBy(css = "span[class*='"+IsShowAsOnlineByDefault+"']")   // Display profile status online offline busy
 public WebElement isShowAsOnlineByDefaultWe;                     // green or grey ( )

 // green radio_2e2iA CanProfileViewableByEveryone checked_2p6xB
 @FindBy(css = "span[class*='"+CanProfileViewableByEveryone+"']")
 public WebElement canProfileViewableByEveryoneWe;

 @FindBy(css = "span[class*='"+CanReceiveMessageFromEveryone+"']")
 public WebElement canReceiveMessageFromEveryoneWe;

 @FindBy(css = "a[href$='/1/account/privacy-settings']")
 public WebElement updatePrivacySettingLinkWe;

 // Right side  ----------------------------------------------------------------------------------------------------
 @FindBy(css = "button[class*='browseBtn_']" )   //"input[type='file']")  .imageCropper_3caFV   src="https://qa.englishtown.com/opt-media/v2/e4db3a91-1dff-4ced-acbc-666999deec15"
 public WebElement changePicWe;

 //image on the page   imageCropper_3caFV
 @FindBy(css = ".profileBody img")
 public WebElement profileImageWe;

 // header avatar ....
 @FindBy(css = ".ue-avatar img")
 public WebElement headerProfileAvatarWe;

 //input[class^="fileInput_"]
 @FindBy(css = "input[class^='fileInput_']")
 public WebElement fileInputPictureWe;  // hidden element
 */