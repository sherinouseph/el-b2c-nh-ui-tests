package com.englishtown.newhouse.school.pages.account;
/**
 * Nikol - 2020
 *
 * School lite page
 */


import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.MyWebDriverAction;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WebElementHelper;
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

import static com.englishtown.tests.core.BaseTestHelper.refresh;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.core.IsNot.not;

public class ProfilePage extends BaseAccountSettingPage {
    public static final Logger logger = LoggerFactory.getLogger(ProfilePage.class);
    public static final String pageUrl = "/account/personal-details";

    public static final String SAVE_CHANGES_POPUP_CSS     = "div[class*='messageBox_']";   // $('div[class*="messageBox_"]').text()  //"Changed saved"
    public static final String CHANGE_SAVED_MSG = "Changed saved";
    public static final String[] FIELDS_LIST_PARENT_CSS   = {".name-given",".name-family",".phone-mobile"};
    public static final String VALIDATION_MSG_REQUIRED    = "is required";
    public static final String VALIDATION_MSG_ALLOWED     = "alphabets are allowed";
    public static final String VALIDATION_MSG_VALID_PHONE = "enter a valid phone";


    @FindBy(css =".ui.grid a[href$='privacy-policy/']" )//".ui.grid a[href$='/online/privacy.aspx']"
    public WebElement privacyPolicyLinkWe;

    @FindBy(css = ".name-given input")
    public WebElement firstNameWe;

    @FindBy(css = ".name-family input")
    public WebElement lastNameWe;

    @FindBy(css = ".email input")
    public WebElement emailWe;

    @FindBy(css = ".password input")
    public WebElement passwordWe;

    @FindBy(css = "span[class^='reset-button_'] span")
    public WebElement updatePassLinkWe;

    @FindBy(css = ".phone-mobile input")
    public WebElement mobilePhoneWe;

    @FindBy(css = SAVE_CHANGES_POPUP_CSS)
    public WebElement savedPopupWe;

    @FindBy(css = ".red.pointing")
    public List<WebElement> validationMessageListWe;   //Only alphabets are allowed OR is required


    public ProfilePage(WebDriver webDriver, int waitTimeSec) {
        super(webDriver, waitTimeSec);
    }

    public ProfilePage(WebDriver webDriver, String url) {
        super(webDriver, url);
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
        WaitTool.waitForElementVisible(getWebDriver(), By.cssSelector(".phone-mobile input"), WaitTool.LONG_WAIT_4_ELEMENT);
        return ExpectedConditions.visibilityOf(mobilePhoneWe);
    }

    public void checkPersonalDetails(String firstname, String lastName, String email, String mobTel){
        logger.info("checkPersonalDetails");
        AssertHelper.assertStringContains(TestUtil.getWebElementText(firstNameWe),firstname,"First name incorrect");
        AssertHelper.assertStringContains(TestUtil.getWebElementText(lastNameWe),lastName,"Last name incorrect");
        AssertHelper.assertStringContains(TestUtil.getWebElementText(emailWe), email,"Email incorrect");
        AssertHelper.assertThat("Password is empty OR null ...! ", TestUtil.getWebElementText(passwordWe), not(isEmptyOrNullString()));
        AssertHelper.assertStringContains(TestUtil.getWebElementText(mobilePhoneWe), mobTel,"Telephone incorrect");
    }

    public void checkPersonalDetailsNotEmptyOrNull(){
        logger.info("checkPersonalDetailsNotEmptyOrNull ...!");
        AssertHelper.assertThat("firstname is empty OR null ...! ",
                TestUtil.getWebElementText(firstNameWe), not(isEmptyOrNullString()));
        AssertHelper.assertThat("Last name is empty OR null ...! ",
                TestUtil.getWebElementText(lastNameWe), not(isEmptyOrNullString()));
        WaitTool.waitFor(getWebDriver(), ExpectedConditions.visibilityOf(passwordWe), 40);
        AssertHelper.assertThat("Pass is empty OR null ...! ",
                TestUtil.getAttributeValue(getWebDriver(), passwordWe, "value" ), not(isEmptyOrNullString()));
        AssertHelper.assertThat("Email is empty OR null ...! ",
                TestUtil.getWebElementText(emailWe), not(isEmptyOrNullString()));
        AssertHelper.assertThat("Phone number is empty OR null ...! ",
                TestUtil.getWebElementText(mobilePhoneWe), not(isEmptyOrNullString()));
    }

    @Override
    public boolean checkAllPageComponentsDisplayed(){
        logger.info("checkAllPageComponents [ ..]...!");
        //WaitTool.waitForElementVisible(getWebDriver(), By.cssSelector(".ui.grid a[href$='privacy-policy']"), WaitTool.LONG_WAIT_4_ELEMENT);
        checkAllPageComponentsDisplayed(
                privacyPolicyLinkWe, firstNameWe, lastNameWe, emailWe, passwordWe, mobilePhoneWe
        );
        return true;
    }

    @Override
    public String getPageUrl(){
        return pageUrl;
    }

    public SchoolStudentBean getSchoolStudentBean(){
        SchoolStudentBean studentBean = new SchoolStudentBean();
        studentBean.setFirstName(TestUtil.getWebElementText(firstNameWe));
        studentBean.setLastName(TestUtil.getWebElementText(lastNameWe));
        studentBean.setUserEmail(TestUtil.getWebElementText(emailWe));
        studentBean.setMobilePhone(TestUtil.getWebElementText(mobilePhoneWe));

        if(null == studentBean) {
            logger.error("Can't get Student bean data from page ....!");
            failTest("Can't get Student bean data from page ....!");
        }
        return studentBean;
    }

    public void waitForPopupTxtSaved(){
        WaitTool.waitForCondition( ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(SAVE_CHANGES_POPUP_CSS),
                CHANGE_SAVED_MSG),getWebDriver(),15);
        logger.info("Web element text contains [{}] .... !", CHANGE_SAVED_MSG);
    }

    public void changePassword(String currentPwd,String newPwd){
        logger.info("changePassword");
        //TODO ONCE DEV MAKE THIS WORK
    }

    public void checkValidationMessage(int index, String message){
        logger.info("checkValidationMessage is ["+message+"] for index [{}]", index);

        if(null == validationMessageListWe || validationMessageListWe.isEmpty())
            failTest("Cant get validation message web element ... !");

        AssertHelper.assertStringContains(TestUtil.getWebElementText(validationMessageListWe.get(index)), message,
                "Not the Expected validation message ...!");
    }

    public void updateField_checkSavedMsgShown_fieldUpdatedToNewValue(WebElement updateFieldWe, String updateTo){
        WebElementHelper.clearAndsendKeys(getWebDriver(),updateFieldWe,updateTo,false);
        // MyWebDriverAction.clearAndSetText(getWebDriver(), updateFieldWe, updateTo);
        click(passwordWe);
        waitForPopupTxtSaved();
        sleep(3000);
        refresh(getWebDriver());
        sleep(8000);
        WaitTool.waitForElementVisible(getWebDriver(), By.cssSelector(".name-given input"), WaitTool.LONG_WAIT_4_ELEMENT);
        AssertHelper.assertStringContains(TestUtil.getWebElementText(updateFieldWe), updateTo,
                "Not the Expected field value ...!");
    }

}