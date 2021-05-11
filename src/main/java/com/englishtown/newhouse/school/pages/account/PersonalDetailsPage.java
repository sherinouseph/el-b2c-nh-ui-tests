package com.englishtown.newhouse.school.pages.account;
/**
 * Nikol - 08/10/2018
 *
 * Since there is no spec of what this page should do simple tests are performed
 */
//Personal details page object

import com.englishtown.enumpack.Gender;
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.newhouse.school.beanandenum.SchoolStudentBean;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class PersonalDetailsPage extends BaseAccountSettingPage {
    public static final Logger logger = LoggerFactory.getLogger(PersonalDetailsPage.class);
    public static final String pageUrl = "/customerservice/personaldetails";

    public static final String SAVE_CHANGES_POPUP_CSS    = ".submit-tip button.submit"; //".ui.small.segment";
    public static final String DISCARD_CHANGES_POPUP_CSS = ".submit-tip button.reset";
    public static final String SUCCESS_SAVED_MSG_CSS     = ".alert.navbar-fixed-top";  // Your changes have been successfully saved.

    public static final String VALIDATION_MSG_FNAME = "characters that are not allowed";

    @FindBy(css = "a.noticeable") //".ui [class^='pageHeading_'] a")
    public WebElement privacyPolicyLinkWe;

    @FindBy(id = "first-name")
    public WebElement firstNameWe;

    @FindBy(id = "last-name")
    public WebElement lastNameWe;

    @FindBy(id = "email")
    public WebElement emailWe;

    @FindBy(id = "language")
    public WebElement emailLangSelectWe;


    // password
    @FindBy(id = "current-password")
    public WebElement passwordWe;

    @FindBy(id = "new-password")
    public WebElement newPasswordWe;

    @FindBy(id = "new-password2")
    public WebElement confirmNewPasswordWe;

    //----------

    @FindBy(css = ".form-group .square-corner")
    public WebElement profileIconWe;

    // Profile DOB
    @FindBy(id = "month")
    public WebElement monthSelectWe;

    @FindBy(id = "day")
    public WebElement daySelectWe;

    @FindBy(id = "year")
    public WebElement yearSelectWe;

    @FindBy(id = "gender")
    public WebElement genderSelectWe;

    @FindBy(id = "nativelanguagecode")
    public WebElement nativeLanguageSelectWe;

    @FindBy(id = "industrycode")
    public WebElement industrySelectWe;

    //contact information  --------------------------------------------------
    @FindBy(id = "mobile")
    public WebElement mobilePhoneWe;

    @FindBy(id = "telephone")
    public WebElement homePhoneWe;

    @FindBy(id = "billing-address1")
    public WebElement billingAdressWe;

    @FindBy(id = "city")
    public WebElement cityWe;

    @FindBy(id = "post")
    public WebElement postalCodeWe;

    @FindBy(id = "country")
    public WebElement countrySelectWe;
    //---------------------------------------------------------------------

    // change pic
    // image

    @FindBy(css = ".form-group .square-corner img")   // src="/community/ImageHandler.ashx?id=ADMAOAA5ADAAMQA1ADkAOQA&ver=ADAA"
    public WebElement imageWe;

    @FindBy(css = ".form-group [for='avatar'] input")
    public WebElement changePicWe;

    // privacy
    @FindBy(css = "select[name='CanProfileViewableByEveryone']")       // value="Everyone"
    public WebElement canProfileViewableByEveryoneSelectWe;

    @FindBy(css = "select[name='CanReceiveMessageFromEveryone']")     // value="Only my friends"
    public WebElement canReceiveMessageFromEveryoneSelectWe;

    /*@FindBy(css = "a[href='/1/account/privacy-settings']")
    public WebElement updatePrivacySettingLinkWe;*/

    //--------------------------------------------------

    @FindBy(css = SAVE_CHANGES_POPUP_CSS)
    public WebElement savedPopupBtnWe;

    @FindBy(css = DISCARD_CHANGES_POPUP_CSS)
    public WebElement discardChangesPopupBtnWe;

    @FindBy(className = SUCCESS_SAVED_MSG_CSS)
    public WebElement successSaveMsgBarWe;

    //todo
    /*@FindBy(css = ".panel-body input[class='btn btn-default btn-block source']'")
    public WebElement liveHelpBtnWe;
    @FindBy(css = ".panel-body a[href='/customerservice/helpcenter']'")
    public WebElement viewCommonQuestionLinkWe;*/

    @FindBy(className = "tooltip-inner")
    public List<WebElement> validationMessageListWe;



    //-----------------------------------------------------

    public PersonalDetailsPage(WebDriver webDriver){
        super(webDriver);
    }

    public PersonalDetailsPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }

    public PersonalDetailsPage(WebDriver webDriver, int waitTimeSec) {
        super(webDriver, waitTimeSec);
    }

    public PersonalDetailsPage() {
        this(null, null);
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }


    public boolean simpleTest() {
        logger.info("check firstname is displayed...!");
        AssertHelper.assertWebElementDisplayed(firstNameWe);
        return true;
    }

    @Override
    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(monthSelectWe);
    }

    public void checkPersonalDetails(String firstname,String LastName, String emailAddress){
        logger.info("checkPersonalDetails");
        AssertHelper.assertStringContains(TestUtil.getWebElementText(firstNameWe),firstname,"Firstname incorrect");
        AssertHelper.assertStringContains(TestUtil.getWebElementText(lastNameWe),firstname,"Lastname incorrect");
        AssertHelper.assertStringContains(TestUtil.getWebElementText(emailWe),firstname,"Email incorrect");
    }

    @Override
    public boolean checkAllPageComponentsDisplayed(){
        logger.info("checkAllPageComponents [ ..]...!");
        //todo add all
        checkAllPageComponentsDisplayed(privacyPolicyLinkWe, firstNameWe, lastNameWe,emailWe, passwordWe, profileIconWe,
                monthSelectWe,daySelectWe,yearSelectWe,nativeLanguageSelectWe,industrySelectWe,
                mobilePhoneWe,homePhoneWe,billingAdressWe,cityWe,postalCodeWe,imageWe,changePicWe
        );
        return true;
    }

    @Override
    public String getPageUrl(){
        return pageUrl;
    }

     /**
     * TODO
     * Set current student data and the new student name
     * @param schoolStudentBean
     * @param schoolStudentUpdatedBean
     */
    public void getCurrentUserDetailsAndSetStudentBean(SchoolStudentBean schoolStudentBean, SchoolStudentBean schoolStudentUpdatedBean){
        String firstName = TestUtil.getWebElementText(firstNameWe);
        schoolStudentBean.setFirstName(TestUtil.getWebElementText(firstNameWe));
        String newName = new StringBuffer(firstName).reverse().toString();
        schoolStudentUpdatedBean.setFirstName(newName);
        schoolStudentBean.setLastName(TestUtil.getWebElementText(lastNameWe));
        schoolStudentBean.setGender(Gender.getGender(TestUtil.getWebElementText(genderSelectWe)));
        schoolStudentBean.setMobilePhone(TestUtil.getWebElementText(mobilePhoneWe));
        schoolStudentBean.setCity(TestUtil.getWebElementText(cityWe));
        //schoolStudentBean.setCountry(TestUtil.getWebElementText(countrySelectWe));

    }

    public void waitForPopupTxtSaved(){
        WaitTool.waitForCondition( ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(SUCCESS_SAVED_MSG_CSS),
                "successfully saved"),getWebDriver(),10);
        logger.info("Web element text contains Saved .... !");
    }


    public void changePassword(String currentPwd,String newPwd){
        logger.info("changePassword");
        sendKey(getWebDriver(),passwordWe, currentPwd,false);
        sendKey(getWebDriver(),newPasswordWe, newPwd,false);
        sendKey(getWebDriver(),confirmNewPasswordWe, newPwd,false);
    }

    public void clickSaveChangesPopup(){
        logger.info("clickSaveChangesPopup..!");
        click(savedPopupBtnWe);
    }

    public void clickDiscardChangesPopup(){
        logger.info("clickDiscardChangesPopup..!");
        click(discardChangesPopupBtnWe);
    }

    public void checkValidationMessage(int index, String message){
        logger.info("checkValidationMessage is ["+message+"] for index [{}]", index);

        if(null == validationMessageListWe || validationMessageListWe.isEmpty())
            failTest("Cant get validation message web element ... !");

        AssertHelper.assertStringContains(TestUtil.getWebElementText(validationMessageListWe.get(index)),message,
                "Not the Expected validation message ...!");
    }



}



/*********



 //@FindBy(css = "span[class='tip-message-content']")
 //public List <WebElement> tooltipMsgWe;

 //confirmation popup

 @FindBy(css = ".submit-tip .submit")
 public WebElement saveChangesBtnWe;

 @FindBy(css = ".submit-tip .reset")
 public WebElement discardChangesBtnWe;

 @FindBy(css = ".alert .row h5")
 public WebElement changesMadePopupTitleWe;

 @FindBy(css = ".alert .row em")
 public WebElement changesMadePopupMsgWe;

 @FindBy(css = ".panel-body input[class='btn btn-default btn-block source']'")
 public WebElement liveHelpBtnWe;

 @FindBy(css = ".panel-body a[href='/customerservice/helpcenter']'")
 public WebElement viewCommonQuestionLinkWe;

 @FindBy(css = "input[type='file']")
 public WebElement changePicWe;

 // validation messages shown when the wrong date is entered

 @FindBy(className = "tooltip-inner")
 public List<WebElement> validationMessageListWe;


 public void changePassword(String currentPwd,String newPwd){
 logger.info("changePassword");
 sendKey(getWebDriver(),currentPwdWe,currentPwd,false);
 sendKey(getWebDriver(),newPwdWe,newPwd,false);
 sendKey(getWebDriver(),confirmPwdWe,newPwd,false);
 }

 public void checkChangesMadePopupcontent(String ChangesMadeTitle,String ChangesmadePopupContent)
 {   logger.info("checkChangesMadePopupcontent..!");
 AssertHelper.assertStringContains(TestUtil.getWebElementText(changesMadePopupTitleWe),ChangesMadeTitle,"title wrong");
 AssertHelper.assertStringContains(TestUtil.getWebElementText(changesMadePopupMsgWe),ChangesmadePopupContent,"Content wrong");
 }

 public void clickSaveChangesPopup(){
 logger.info("clickSaveChangesPopup..!");
 click(saveChangesBtnWe);
 }

 public void clickDiscardChangesPopup(){
 logger.info("clickDiscardChangesPopup..!");
 click(discardChangesBtnWe);
 }

 public void checkTooltips(String emailtooltip,String passwordtooltip){
 logger.info("checkTooltips..!");
 AssertHelper.assertStringContains(TestUtil.getWebElementText(tooltipMsgWe.get(0)),emailtooltip,"tooltip message wrong");
 AssertHelper.assertStringContains(TestUtil.getWebElementText(tooltipMsgWe.get(1)),passwordtooltip,"tooltip message wrong");

 }

 public void checkValidationMessage(int index, String message){
 logger.info("checkValidationMessage is ["+message+"] for index [{}]", index);

 if(null == validationMessageListWe || validationMessageListWe.isEmpty())
 failTest("Cant get validation message web element ... !");

 AssertHelper.assertStringContains(TestUtil.getWebElementText(validationMessageListWe.get(index)),message,
 "Not the Expected validation message ...!");
 }



 *****/