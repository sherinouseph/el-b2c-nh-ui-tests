package com.englishtown.tests.checkout.common.validation;
/**
 * open member page
 * Click submit
 * Check validation page
 *
 */

import com.englishtown.dataprovider.bin.validation.MemberPageValidationMsgBean;
import com.englishtown.dataprovider.bin.validation.PaymentPageValidationMsgBean;
import com.englishtown.helpers.*;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.pages.core.BasePage;
import com.englishtown.tests.core.BaseTestHelper;
import com.englishtown.tests.core.EfConstants;
import com.englishtown.tests.core.UniqueDataObject;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.StringContains.containsString;
import static org.hamcrest.text.IsEmptyString.isEmptyOrNullString;


public abstract class BaseCheckoutNegativeTest extends BaseTestHelper {
    private static final Logger logger = LoggerFactory.getLogger(BaseCheckoutNegativeTest.class);

    protected String FULL_NAME_VALIDATION_MSG = "test should set this up";
    protected String submitBtnCss                    = ".bs3 .btn.btn-primary";
    protected WebElement webElement                 = null;
    /**
     * Validation msg ... test should set this up
     */
    protected String errorMessageContains           = "Bitte"; // Vornamen eingeben";
    //
    public MemberPageValidationMsgBean memberPageValidationMsgBean;
    public PaymentPageValidationMsgBean paymentPageValidationMsgBean;

    //----------------------------------------------------------------------------------------------------------
    protected String ddErrorBankCodeContains   = "BIC erforderlich"; //"BLZ erforderlich";
    protected String ccErrorCardNumberContains = "Kartennummer erforderlich";

    protected String memberInvalidErrMsgBaseCss = "form .form-group-";
    protected String invalidErrMsgFirstNameCss  = memberInvalidErrMsgBaseCss + "firstname .tooltip";
    protected String invalidErrMsgLastNameCss   = memberInvalidErrMsgBaseCss + "lastname .tooltip";
    protected String invalidErrMsgEmailCss      = memberInvalidErrMsgBaseCss + "email .tooltip";    //and inuse error message
    protected String invalidErrMsgPassCss       = memberInvalidErrMsgBaseCss + "password .tooltip";
    protected String invalidErrMsgTandCsCss     = memberInvalidErrMsgBaseCss + "toc .tooltip";
    protected String emailInUseMsgCss           = "form .message.alert";
    protected String loginLinkInErrorMsg           = "form .message.alert a";
    //pay
    protected String invalidErrMsgCardNumberCss  = memberInvalidErrMsgBaseCss + "CreditCardNumber .tooltip";
    protected String invalidErrMsgNameCss        = memberInvalidErrMsgBaseCss + "CreditCardName .tooltip";
    protected String invalidErrMsgMonthCss       = memberInvalidErrMsgBaseCss + "ExpirationMonth .tooltip";
    protected String invalidErrMsgYearCss        = memberInvalidErrMsgBaseCss + "ExpirationYear .tooltip";
    protected String invalidErrMsgCodeCss        = memberInvalidErrMsgBaseCss + "CardVerificationCode .tooltip";
    protected String invalidErrMsgPayAuthCss     = memberInvalidErrMsgBaseCss + "CCAuthorized .tooltip";

    //--------------------------------------------------------------------------------------------------------

    protected String paymentFormUrlContains     = "buy/default/payment";
    //pay
    protected String payDdWeCss  = ".tab-0 "+submitBtnCss;
    protected String submitPayPage  = ".btn.btn-primary";
    protected String submitDDbuttonSelector = "#form_tabctrl_tab-0_button";
    protected String submitCCbuttonSelector = ".tab-1 button"; //"#form_tabctrl_tab-1_button";
    protected String formErrorSelector = ".tooltip-inner";

    protected boolean isSendKeyBackSpace = false;

    /**
     * submitBtnCss
     */
    public void submitMemberPage(){
        submit(submitBtnCss);
    }

    public void submitPaymentPage(){
        submit(paymentSubmitBtnCss);
    }

    public void submit(String cssSelector){
        logger.info("submit ....![{}]", cssSelector);
        webElement = WaitTool.waitForElementClickable(getWebDriver(), By.cssSelector(cssSelector), WaitTool.DEFAULT_WAIT_4_ELEMENT);
        JavaScriptHelper.scrollWebElementToView(getWebDriver(), webElement, ElementScreenPosition.BUTTON, 10);
        sleep(300);        //JavaScriptHelper.highlightElement(webElement, getWebDriver());
        WebElementHelper.focusOnElementUsingSendKeyOrAction(webElement, getWebDriver());
        click(webElement);
        logger.info("Clicked on submit ....![{}]", cssSelector);
    }

    /**
     *  Wait for Element Visible and then get text
     *  Assert text not empty or null
     *
     */
    public void assert_WebElementVisibleAndTextIsNotEmptyOrNullString(By webElementSelector,int waitTime){
        webElement = WaitTool.waitForElementVisible(getWebDriver(), webElementSelector, waitTime, WaitTool.DEFAULT_POLL_SLEEP);

        if(webElement == null)
            BasePage.failTest("Web Element (using selector ["+webElementSelector+"] )" +
                " is Null ...! \n Current URL :"+ TestUtil.getCurrentUrl(getWebDriver()));

        AssertHelper.myAssertThat(getWebDriver(), "Web element Text is Null or empty : ",
                getText(webElement), not(isEmptyOrNullString()), false);
    }

    public void enterBlank_OnAllFieldCheckFirstNameValidationShown(){
        enterFormData(EfConstants.ukMembersFormMap_blank);
        webElement = WaitTool.waitForElementClickable(getWebDriver(), By.cssSelector(submitBtnCss), WaitTool.DEFAULT_WAIT_4_ELEMENT);
        JavaScriptHelper.scrollWebElementToView(getWebDriver(), webElement, ElementScreenPosition.BUTTON, 10);
        click(webElement);// removes msg on grid so do it twice
        click(webElement);
        webElement = findElement(By.cssSelector(invalidErrMsgFirstNameCss));
        AssertHelper.myAssertThat(getWebDriver(),
                " Failed ...!; First Name error message does not contains the expected text : ",
                getText(webElement), containsString(memberPageValidationMsgBean.getFirstName_validationMsg()), false);

    }

    public void enterBlank_OnCreditCardCheckValidationShown(){
        webElement = WaitTool.waitForElementClickable(getWebDriver(), By.name("CreditCardNumber"), WaitTool.DEFAULT_WAIT_4_ELEMENT);
        JavaScriptHelper.scrollWebElementToView(getWebDriver(), webElement, ElementScreenPosition.BUTTON, 10);
        click(webElement);// removes msg on grid so do it twice
        click(webElement);
        webElement = findElement(By.cssSelector(invalidErrMsgFirstNameCss));
        AssertHelper.myAssertThat(getWebDriver(),
                " Failed ...!; First Name error message does not contains the expected text : ",
                getText(webElement), containsString(memberPageValidationMsgBean.getFirstName_validationMsg()), false);

    }
    /**
     * Member
     */
    public void isSecondName_ErrorMessageShown(){
        enterDataOnFirstElementClickSubmitCheckErrMsg(memberPageValidationMsgBean.getLastName_validationMsg(),
                By.name("firstname"), By.cssSelector(submitBtnCss), By.cssSelector(invalidErrMsgLastNameCss));
    }

    public void isEmail_ErrorMessageShown(){
        enterDataOnFirstElementClickSubmitCheckErrMsg(memberPageValidationMsgBean.getEmail_validationMsg(),
                By.name("lastname"), By.cssSelector(submitBtnCss), By.cssSelector(invalidErrMsgEmailCss));
    }

    public void isPassword_ErrorMessageShown(){
        enterDataOnFirstElementClickSubmitCheckErrMsg(memberPageValidationMsgBean.getPassword_validationMsg(),
                By.name("email"), By.cssSelector(submitBtnCss), By.cssSelector(invalidErrMsgPassCss));
    }

    public void isTermAndCondition_ErrorMessageShown(){
        enterDataOnFirstElementClickSubmitCheckErrMsg(memberPageValidationMsgBean.getTermAndCondition_validationMsg(),
                By.name("password"), By.cssSelector(submitBtnCss), By.cssSelector(invalidErrMsgTandCsCss));
    }

    /**
     * Payment
     * tooltip-inner
     */
    public void isCcCard_ErrorMessageShown(){
        webElement = findElement(By.cssSelector(invalidErrMsgCardNumberCss));
        AssertHelper.myAssertThat(getWebDriver(),
                "Message does not contains the expected text ...!",
                getText(webElement), containsString(paymentPageValidationMsgBean.getCardnumber_validationMsg()), false);
    }

    public void isName_ErrorMessageShown() {
        WebElement nameWe  = findElement(By.name("CreditCardName"));
        nameWe.clear();
        sleep(500);
        WebElement ccNumberWe = findElement(By.name("CreditCardNumber"));

        if (StringUtils.containsIgnoreCase(getENVIRONMENT(), "live")) {
            WebElementHelper.sendKeys(getWebDriver(), ccNumberWe, "4222222222222222", false);
        } else
            WebElementHelper.sendKeys(getWebDriver(), ccNumberWe, "4111111111111111", false);

        //click(ccNumberWe);

        //click(nameWe);
        //webElement.sendKeys(Keys.TAB);
        //sleep(500);
        //webElement.sendKeys(Keys.TAB);
        //sleep(500);

        //webElement = findElement(By.name("CreditCardName"));

        webElement = findElement(By.cssSelector(invalidErrMsgNameCss));
        AssertHelper.myAssertThat(getWebDriver(),
                "Message does not contains the expected text ...!",
                getText(webElement), containsString(paymentPageValidationMsgBean.getName_validationMsg()), false);
    }

    public void isMonth_ErrorMessageShown(){
        enterDataOnFirstElementClickSubmitCheckErrMsg(paymentPageValidationMsgBean.getMonth_validationMsg(),
                By.name("CreditCardName"), By.cssSelector(submitBtnCss), By.cssSelector(invalidErrMsgMonthCss));
    }

    public void isYear_ErrorMessageShown() {
        select(By.name("ExpirationMonth"), null, "10");
        webElement = findElement(By.name("ExpirationMonth"));
        webElement.sendKeys(Keys.TAB);
        sleep(500);
        webElement.sendKeys(Keys.TAB);
        sleep(1000);

        webElement = findElement(By.cssSelector(invalidErrMsgYearCss));
        AssertHelper.myAssertThat(getWebDriver(),
                "Message does not contains the expected text ...!",
                getText(webElement), containsString(paymentPageValidationMsgBean.getYear_validationMsg()), false);
    }

    public void isCode_ErrorMessageShown() {
        select(By.name("ExpirationYear"), null, "10");
        webElement = findElement(By.name("ExpirationYear"));
        webElement.sendKeys(Keys.TAB);
        sleep(500);
        webElement.sendKeys(Keys.TAB);
        sleep(1000);

        webElement = findElement(By.cssSelector(invalidErrMsgCodeCss));
        AssertHelper.myAssertThat(getWebDriver(),
                "Message does not contains the expected text ...!",
                getText(webElement), containsString(paymentPageValidationMsgBean.getCode_validationMsg()), false);
    }

    public void isAuthorise_ErrorMessageShown(){
        webElement = findElement(By.name("CardVerificationCode"));

        WebElementHelper.sendKeys(getWebDriver(), webElement, "123", false);

        click(webElement);
        webElement.sendKeys(Keys.TAB);
        sleep(500);
        webElement.sendKeys(Keys.TAB);
        sleep(500);

        webElement = findElement(By.cssSelector(invalidErrMsgPayAuthCss));
        AssertHelper.myAssertThat(getWebDriver(),
                "Message does not contains the expected text ...!",
                getText(webElement), containsString(paymentPageValidationMsgBean.getTermAndCondition_validationMsg()), false);
    }

    /**
     *  Usage -> Enter first name and submit form, check error message on second name field
     *
     * @param errorMessageContains
     * @param firstElementToWaitFor
     * @param secondElementToWaitFor
     * @param byElementToCheckError
     */
    public void enterDataOnFirstElementClickSubmitCheckErrMsg(String errorMessageContains, By firstElementToWaitFor,  By secondElementToWaitFor, By byElementToCheckError){
        WaitTool.waitForElementVisibleAndClickable(firstElementToWaitFor, getWebDriver(), WaitTool.DEFAULT_WAIT_4_ELEMENT);

        webElement = findElement(firstElementToWaitFor);

        String firstElementToWaitForStr = firstElementToWaitFor.toString();   // should get By.name: email

        if(StringUtils.isBlank(firstElementToWaitForStr)) {
            failTest("By element is null [{" + firstElementToWaitForStr + "}]...");
        }else {
            try {
                firstElementToWaitForStr = firstElementToWaitForStr.split(":")[1].trim();
            }catch (ArrayIndexOutOfBoundsException e){
                failTest("Can't get by sellector to string  [{" + firstElementToWaitFor + "}]..."+e.getMessage());
            }
        }

        if(StringUtils.equalsIgnoreCase(firstElementToWaitForStr, "email")){
            enterEmail(getWebDriver(), false);
        } else if(StringUtils.equalsIgnoreCase(firstElementToWaitForStr, "CreditCardNumber")){
            if(StringUtils.containsIgnoreCase(getENVIRONMENT(), "live")){
                WebElementHelper.sendKeys(getWebDriver(), webElement, "4222222222222222", false);
            }else
                WebElementHelper.sendKeys(getWebDriver(), webElement, "4111111111111111", false);
        }else if(StringUtils.equalsIgnoreCase(firstElementToWaitForStr, "CreditCardName"))
            WebElementHelper.sendKeys(getWebDriver(), webElement," nikoTestFN Surname", false);
        else
            WebElementHelper.sendKeys(getWebDriver(), webElement," nikTeFN", false);

        //clear error
        sleep(500);
        click(webElement);        sleep(500);

        webElement = WaitTool.waitForElementClickable(getWebDriver(), secondElementToWaitFor, WaitTool.DEFAULT_WAIT_4_ELEMENT);
        //show error by clicking tab        //JavaScriptHelper.scrollWebElementToView(getWebDriver(), webElement, ElementScreenPosition.BUTTON, 10); sleep(500);
        click(webElement);
        sleep(500);

        webElement = findElement(byElementToCheckError);                                                                                //AssertHelper.myAssertThat(getWebDriver(), " Failed ...!; First Name error message does not contains the expected text : "+errorMessageContains,          webElement.getText(), containsString(errorMessageContains), false);
        AssertHelper.myAssertThat(getWebDriver(),
                " Failed ...!; error message does not contains the expected text : "+errorMessageContains,
                getText(webElement), containsString(errorMessageContains), false);
        sleep(500);
    }

    public void create_Member(){
        create_Member(formDataMap);
    }

    public void create_Member(Map member){
        enterFormData(member);
        UniqueDataObject udo = new UniqueDataObject();
        setUserEmail(udo.getEmail());

        WebElement we =  findElement(By.name("email"));
        if(isSendKeyBackSpace)      // there is spaces on the email
             we.clear();           //   we.sendKeys(Keys.BACK_SPACE); we.sendKeys(Keys.BACK_SPACE);
        WebElementHelper.sendKeys(getWebDriver(), we, udo.getEmail(), false);
        we.sendKeys(Keys.TAB); we.sendKeys(Keys.TAB);        // do this twice to work

        webElement = WaitTool.waitForElementClickable(getWebDriver(), By.cssSelector(submitBtnCss), WaitTool.MED_WAIT_4_ELEMENT25);
        JavaScriptHelper.scrollWebElementToView(getWebDriver(), webElement, ElementScreenPosition.BUTTON, 10);
        click(webElement);
        assertIsPaymentForm(paymentFormUrlContains);
        sleep(300);
    }

    /**
     * Clear cookies, open member url and enter first and second name and email
     * check existing user message
     */
    public void isExistingUserEmail_ErrorMessageShown(String userEmail,boolean isNewhouseCheckout){
        CookieHandler.deleteCookies(getWebDriver());
        sleep(1000);
        openUrl(getWebDriver(), this.memberPageUrl, -1 ) ;
        sleep(1000);
        refresh(getWebDriver());
        sleep(1000);
        WaitTool.waitForCondition( ExpectedConditions.invisibilityOfElementLocated(
                By.cssSelector(memberSpinnerCss)),getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        waitForElementCondition(ExpectedConditions.elementToBeClickable(By.name("lastname")), getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        enterFormData(EfConstants.getDynamicMap("firstname", "lastname"));
        webElement = findElement(By.name("email"));
        clickAtWindow(getWebDriver(), 10, 10);
        sleep(100);
        sendKey(getWebDriver(), webElement,  userEmail, false);
        webElement.sendKeys(Keys.TAB);
        sleep(500);
        if(isNewhouseCheckout){
            //click on submit btn
            enterFormData(EfConstants.getDynamicMap("password"));
            webElement = WaitTool.waitForElementClickable(getWebDriver(), By.cssSelector(submitBtnCss), WaitTool.MED_WAIT_4_ELEMENT25);
            //JavaScriptHelper.scrollWebElementToView(getWebDriver(), webElement, ElementScreenPosition.BUTTON, 10);
            click(webElement);
            //check for error message
            waitForElementCondition(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(emailInUseMsgCss)),
                    getWebDriver(), 15);
            webElement = findElement(By.cssSelector(emailInUseMsgCss));
            AssertHelper.myAssertThat(getWebDriver(),
                    " Validation message does not contains the expected text : ",
                    getText(webElement), containsString(memberPageValidationMsgBean.getEmail_inuse_validationMsg()), false);
            sleep(500);}
        else{
            sleep(2000);
            click(webElement);
            webElement.sendKeys(Keys.TAB);
            //webElement.sendKeys(Keys.TAB);
            waitForElementCondition(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(invalidErrMsgEmailCss)),
                getWebDriver(), 15);
            webElement = findElement(By.cssSelector(invalidErrMsgEmailCss));
            AssertHelper.myAssertThat(getWebDriver(),
                " Validation message does not contains the expected text : ",
                getText(webElement), containsString(memberPageValidationMsgBean.getEmail_inuse_validationMsg()), false);
            sleep(500);
    }
    }



}

