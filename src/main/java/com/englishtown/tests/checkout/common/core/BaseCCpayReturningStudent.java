package com.englishtown.tests.checkout.common.core;
/**
 *
 *
 * 1. User Checkout
 * 2. Delete cookies ->
 * 3. openMemberPageClickLogin ->
 * 4. endUserSubscription ->  * Cancel student subscription ;
 * 5. enterUserCredentialsAndClickLogin
 * 6. offers is shown ...
 * 7. select an offer
 * 8. Edit CC details and pay
 * 9. check TY page
 * 10. Repeat step 2 and 3 and 4 and 5 and 6 and 7
 * 11. Click Submit and check Terms and Conditions msg show
 * 12. Click to check the T&C
 * 13. And submit
 *
 */
import com.englishtown.commerceclient.ActionResult;
import com.englishtown.commerceclient.Environment;
import com.englishtown.commerceclient.Wrapper;
import com.englishtown.enumpack.CheckoutFlowType;
import com.englishtown.helpers.*;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.pages.common.LoginPage;
import com.englishtown.pages.core.BasePage;
import com.englishtown.services.MyHttpClient;
import com.englishtown.tests.core.login.BaseLoginHelperImp;
import com.englishtown.tests.core.BaseTestConfig;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import static com.englishtown.helpers.AssertHelper.assertWebElementDisplayed;
import static com.englishtown.helpers.AssertHelper.myAssertThat;
import static com.englishtown.helpers.CaseInsensitiveSubstringMatcher.containsIgnoringCase;


public abstract class BaseCCpayReturningStudent extends NewCcBaseCheckoutFlowTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseCCpayReturningStudent.class);

    public static boolean isDeTest = false;
    public static String offerNotValidLinkCss = ".message p a";
    public static final String offerNotValidMessageCss = "form .message p";
    public static final String existingTcCheckBoxId = "existing-tc";
    public static String offerNotValidMessageText = "current offer is not available for you";
    public static final String returnThankyouUrlContains = "buy/return/thankyou/";
//    private static boolean isOpenHomePageBeforeLoginPage = false;
    public static String offerNotValid = ".alert-danger";
    public static String rmLoginSelector = "#buttons_richtext a";
    public static String confirPayBtnId = "buttons_columnscontrol_column1_button";
    private static String waitForElement = "close";          //popup - fr je sui jeu
    protected static String slectOfferCss = ".btn.btn-primary"; // offers shown on returning page  one or more
    protected static String ccAuthorizedCheckBoxCss ="existing-tc"; // "CCAuthorized"; CCAuthorized
    protected static String modifyCCdetailsLink = ".functional a"; //IT
    protected static String submitBtnCss = ".active .bs3 .btn"; //"#form_tabctrl_tab-0_columnscontrol_column0_button";
    protected static String validationMsgWeCss = ".tooltip-inner";
    protected String validationMsgContainsTxt = "accetta i Termini e Condizioni "; // contains for IT

    protected String waitForEditCCwebElementCss = "a:contains('Kreditkartendaten ändern')";
    /**
     * Pay by editing PP details
     */
    @Test(dependsOnMethods = {"setMemberIdAndMarket_check_memberId_NotNullTest"})
    public void deleteUserCookies() {
        CookieHandler.deleteCookies(getWebDriver());

    }

    @Test(dependsOnMethods = {"deleteUserCookies"})
    public void openUserLoginPage() {
        openLoginPage();
    }

    @Test(dependsOnMethods = {"openUserLoginPage"})
    public void endUserSubscription() {
        if(isNewhousePayment){
            MyHttpClient.cancelOrSuspendSubscriptionNewHouse(getENVIRONMENT(), efId, true);
        }else {
            logger.info("\t\t memberId :> " + memberId);
            end_User_Subscription();
        }
    }


    @Test(dependsOnMethods = {"endUserSubscription"})
    public void enterUserCredentialsAndClickLogin() {
        sleep(3000);
        enter_UserCredentialsAndClickLogin();
    }

    @Test(dependsOnMethods = {"enterUserCredentialsAndClickLogin"})
    public void selectAnOfferOnWelcomeBackAlumniPage(){
        select_AnOffer_OnWelcomeBackAlumniPage();
    }

    @Test(dependsOnMethods = { "selectAnOfferOnWelcomeBackAlumniPage" })
    public void isCheckoutFlowTypeReturnAtBuyAgainPage() {
        checkoutFlowType = CheckoutFlowType.RETURN ; //"return";
        checkFlowType(checkoutFlowType, isTestCheckoutFlowType);
    }

    @Test (dependsOnMethods = {"isCheckoutFlowTypeReturnAtBuyAgainPage"})
    public void clickEditCCdetails(){
        // Todo need to set this for each Returning test .. waitForElementCondition(ExpectedConditions.elementToBeClickable(By.cssSelector(waitForEditCCwebElementCss)), getWebDriver(), 25 );
        click(WebElementHelper.getVisibleElements(getWebDriver(), By.cssSelector(modifyCCdetailsLink)).get(0));//findElement(By.cssSelector(modifyCCdetailsLink)));
        sleep(1000);
        WaitTool.waitForCondition( ExpectedConditions.invisibilityOfElementLocated(
                By.cssSelector(memberSpinnerCss)),getWebDriver(), WaitTool.DEFAULT_IMPLICIT_WAIT);
        if(isDDpay) {
            waitForElementVisibleAndClick("[name='dcInfo.BankCode']", 25);
        }else
            waitForElementVisibleAndClick("[name*=CreditCardNumber]", 25);
    }

    @Test(dependsOnMethods = {"clickEditCCdetails"})
    public void removeAgainPayValidation(){
        remove_Pay_Validation();
    }

    @Test(dependsOnMethods = {"removeAgainPayValidation"})
    public void enterNewCCdetailsAndSubmit(){
        if(isDDpay)
        {enterPayFormData_and_submit();}
        else {
        WebElement ccName = findElement(By.name("CreditCardName"));
        WebElementHelper.sendKeys(getWebDriver(),ccName, "NameOn Card", false );
        sleep(500);
        enter_PayFormDataAndSubmit();}
    }

    @Test(dependsOnMethods = { "enterNewCCdetailsAndSubmit" })
    public void check_returnThankyouPage(){
        WaitTool.waitForCondition( ExpectedConditions.invisibilityOfElementLocated(
                By.cssSelector(memberSpinnerCss)),getWebDriver(),15);
        checkPaymentThankyouPage();
    }

    /**
     * now try to pay without editing pay details
     */
    @Test(dependsOnMethods = {"check_returnThankyouPage"})
    public void delete_UserCookies() {
        CookieHandler.deleteCookies(getWebDriver());
    }

    @Test(dependsOnMethods = {"delete_UserCookies"})
    public void openLoginPagePayWithExistingCC() {
       isOpenHomePageBeforeLoginPage = true;
        openLoginPage();
    }

    @Test(dependsOnMethods = {"openLoginPagePayWithExistingCC"})
    public void endUserSubscriptionAgain() {
        if(isNewhousePayment){
            MyHttpClient.cancelOrSuspendSubscriptionNewHouse(getENVIRONMENT(), efId, true);
        }else {
            logger.info("\t\t memberId :> " + memberId);
            end_User_Subscription();
        }
    }

    @Test(dependsOnMethods = {"endUserSubscriptionAgain"})
    public void enter_User_CredentialsAndClickLogin() {
        enter_UserCredentialsAndClickLogin();
    }

    @Test(dependsOnMethods = {"enter_User_CredentialsAndClickLogin"})
    public void select_AnOfferOnWelcomeBackAlumniPage(){
        select_AnOffer_OnWelcomeBackAlumniPage();
    }
    /* As this is not fixed for years now removing it
    @Test(dependsOnMethods = { "select_AnOfferOnWelcomeBackAlumniPage" })
    public void submitPaymentCheckTnCValidationMsgShown() {
        submit_PayForm_CheckTnCValidMsgShownWithTxt();
    }
    */
    @Test(dependsOnMethods = { "select_AnOfferOnWelcomeBackAlumniPage" })
    public void acceptTandCAngain() {
        acceptTermsAndConditions();
    }

    @Test(dependsOnMethods = { "acceptTandCAngain" })
    public void reReSubmitPayment() {
        //click(findElement(By.cssSelector(submitBtnCss)));
        //submit(WebElementHelper.getVisibleElements(getWebDriver(), By.name(submitBtnCss)).get(1));
        //paymentSubmitBtnCss = "div.active .bs3 .btn";
        WebElement submitElement = findElement(By.cssSelector(paymentSubmitBtnCss));
        click(submitElement);

        sleep(3000);
        if(isDDpay){ WebElementHelper.safeFindAndClick(getWebDriver(),By.cssSelector(confirm));}
        else{
            //do nothing ,proceed to next step
        }

    }

    @Test(dependsOnMethods = { "reReSubmitPayment" })
    public void check_returnThankyouPageAgain(){
        checkPaymentThankyouPage();
    }





    public void end_User_Subscription() {
        logger.info("endUserSubscription for Environment is : " + getENVIRONMENT()+" Member id is ..... : "+memberId);
        if (memberId.isEmpty() || memberId == null) {
            BasePage.failTest("MemberID is Empty/null ...! cant cancel subscription .. memberId: '" + memberId + "'", true);
        }
        if (getENVIRONMENT() == null || getENVIRONMENT().isEmpty()) {
            BasePage.failTest("getENVIRONMENT is Empty/Null ...! cant cancel subscription . ENV is :'" + getENVIRONMENT() + "'", true);
        }
        try {
            Wrapper client = new Wrapper(Environment.getCurrentEnvironment(getENVIRONMENT()));
            ActionResult result = client.cancelSubscriptionForMember(Integer.parseInt(memberId));                   //assertThat("Failed to cancel subscription ...", result.getSucceed(), is(true));
            myAssertThat(getWebDriver(), "Failed to cancel subscription ...", result.getSucceed(), true);
        } catch (Exception e) {
            e.printStackTrace();
            BasePage.failTest(e, "Cancel Subscription failed ...!");
        }
    }



    public void enter_UserCredentialsAndClickLogin() {
        if(isNewDesignLogin){
                LoginPage loginPage = new LoginPage(getWebDriver());
                loginPage.enterCredentialsAndClickLogin(getUserEmail(), this.password);
        }else {
            WaitTool.waitForElementVisibleAndClickable(By.cssSelector("input[name=UserName]"), getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
            BaseLoginHelperImp loginHelperImp = new BaseLoginHelperImp();
            BaseLoginHelperImp.enterUserCredentials(getWebDriver(), getUserEmail(), BaseTestConfig.getPassword8(), loginHelperImp.getEmailCss(), loginHelperImp.getPasswordCss());
            clickLogin(getWebDriver(), By.cssSelector(getLoginBtn()));
        }
        sleep(1000);
    }

    public void select_AnOffer_OnWelcomeBackAlumniPage(){
        sleep(3000);
        WebElement we = findElement( By.cssSelector(slectOfferCss));
        click(we);
        sleep(3000);
        clickTab();
        sleep(2000);
       // WaitTool.safeFindDisplayedAndEnabled(getWebDriver(), By.cssSelector(modifyCCdetailsLink),25 );
        WebElementHelper.getVisibleElements(getWebDriver(), By.cssSelector(modifyCCdetailsLink));
    }

    public void remove_Pay_Validation(){
        if(isDDpay){
            //not needed
        }else {
            remove_PaymentValidation();
            JavaScriptHelper.waitForPageLoaded(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
            logger.info("Go to sleep ....!");
        }
    }

    public void acceptTermsAndConditions() {
        String currentURL = TestUtil.getCurrentUrl(getWebDriver());
        /*if (StringUtils.contains(currentURL, "/de-de/")) {
            submitBtnCss = "#form_tabctrl_tab-1_button";
        } else*/

        if(StringUtils.contains(currentURL, "de-wws")) {
                submitBtnCss = "existing-CreditCardNumber";
        }//else {            submitBtnCss = slectOfferCss;       }
        if (isDDpay) {
            submitBtnCss = "existing-DebitCardAccountName";
            click(WebElementHelper.getVisibleElements(getWebDriver(), By.cssSelector("[name*=existing-tc]")).get(0));
           // waitForElementVisibleAndClick(".directdebit" + " #" + ccAuthorizedCheckBoxCss, 35);
        } else {
            click(WebElementHelper.getVisibleElements(getWebDriver(), By.cssSelector("[name*=existing-tc]")).get(0)); //waitForElementVisibleAndClick("[name*=existing-tc]", 35);
        }
    }

    public void submit_PayForm_CheckTnCValidMsgShownWithTxt() {
        if(isDDpay){
            submitBtnCss = "existing-DebitCardAccountName";}
        else{
        submitBtnCss = "existing-CreditCardNumber";} //".bs3 .btn";
        WebElement we = findElement(By.name(submitBtnCss));
        submit(we);
        sleep(1000);
        WebElement validationMsgWe = findElement(By.cssSelector(validationMsgWeCss));
        assertWebElementDisplayed(validationMsgWe);
        assertValidationMessage(validationMsgWe,  validationMsgContainsTxt);
    }

    public void assertValidationMessage(WebElement webElementWithText, String validationMsg){
        String currentValidationMsg = TestUtil.getWebElementText(webElementWithText);
        logger.info("Validation message is : "+currentValidationMsg);
        AssertHelper.myAssertThat(getWebDriver(), "Is not the expected Validation message ....!",
                currentValidationMsg, containsIgnoringCase(validationMsg), true);
    }




}

