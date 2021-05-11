package com.englishtown.tests.checkout.common.core;
/**
 * New checkout
 * Cancel student subscription ; when user login
 * using members page then checkout page is shown
 *
 */

import com.englishtown.commerceclient.ActionResult;
import com.englishtown.commerceclient.Environment;
import com.englishtown.commerceclient.Wrapper;
import com.englishtown.helpers.CookieHandler;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.pages.core.BasePage;
import com.englishtown.tests.core.login.BaseLoginHelperImp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.util.List;

import static com.englishtown.helpers.AssertHelper.myAssertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;


public abstract class BaseCCpayReturningStudentWithOfferId extends NewCcBaseCheckoutFlowTest {
    private static final Logger logger = LoggerFactory.getLogger( BaseCCpayReturningStudentWithOfferId.class);

    public static boolean isDeTest = false;
    public static String offerNotValidLinkCss            = ".message p a";
    public static final String offerNotValidMessageCss   = "form .message p";
    public static final String existingTcCheckBoxId      = "existing-tc";
    public static String offerNotValidMessageText  = "current offer is not available for you";
    public static final String returnThankyouUrlContains = "buy/return/thankyou/";

    public static String offerNotValid   = ".alert-danger";
    public static String rmLoginSelector = "#buttons_richtext a";
    public static String confirPayBtnId  = "buttons_columnscontrol_column1_button";
    private static String waitForElement = "close";          //popup - fr je sui jeu

    @Test(dependsOnMethods = {"setMemberIdAndMarket_check_memberId_NotNullTest"})
    public void deleteUserCookies(){
        CookieHandler.deleteCookies(getWebDriver());
    }

    @Test(dependsOnMethods = { "deleteUserCookies" })
    public void openMemberPageClickLogin(){
      // getWebDriver().close();
       // sleep(1000);
        if(getWebDriver().getCurrentUrl().contains(".fr")) {                                 //TODO clean this mess up - this is dirty   //is French open url for connection //
            String[] tempUrl= getWebDriver().getCurrentUrl().split("/");
            String frLoginUrl = tempUrl[0]+"//"+tempUrl[2]+"/connexion/";
            getWebDriver().get(frLoginUrl);
            sleep(1000);
        } else {
            getWebDriver().get(this.memberPageUrl);
            sleep(1000);
            logger.info("intMemberPage , Click login link ...");
            initMemberPage();
            scrollToWeAndClick(getWebDriver(), memberPage.firstname, 0, 300);
            click(memberPage.rmLogin);
        }
        sleep(3000);
    }

    @Test(dependsOnMethods = { "openMemberPageClickLogin" })
    public void endUserSubscription(){
       logger.info("endUserSubscription for Environment is : "+getENVIRONMENT());
       if(memberId.isEmpty() || memberId ==null){
           BasePage.failTest("MemberID is Empty/null ...! cant cancel subscription .. memberId: '"+memberId+"'", true);
       }
       if(getENVIRONMENT() ==null || getENVIRONMENT().isEmpty()){
           BasePage.failTest("getENVIRONMENT is Empty/Null ...! cant cancel subscription . ENV is :'"+getENVIRONMENT()+"'", true);
       }
       try{
           Wrapper      client = new Wrapper(Environment.getCurrentEnvironment(getENVIRONMENT()));
           ActionResult result = client.cancelSubscriptionForMember(Integer.parseInt(memberId));
           //assertThat("Failed to cancel subscription ...", result.getSucceed(), is(true));
           myAssertThat(getWebDriver(), "Failed to cancel subscription ...", result.getSucceed(), true);
       } catch (Exception e) {
            BasePage.failTest(e, "Cancel Subscrition failed ...!");
       }
    }

    @Test(dependsOnMethods = { "endUserSubscription" })
    public void enterUserCredentialsAndClickLogin(){
        // TODO remove this when open on same window
        //safeSwitchToWindow(getWebDriver(),1);
        //sleep(1000);
        if(TestUtil.getCurrentUrl(getWebDriver()).contains("n.fr") ){
            waitForElementAndclickAtXY(By.className(waitForElement), 1, 1);
        }
        WaitTool.waitForElementVisibleAndClickable(By.id("email"), getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        BaseLoginHelperImp loginHelperImp = new BaseLoginHelperImp();
        loginHelperImp.enterUserCredentials(getWebDriver(), getUserEmail(),"pass",loginHelperImp.getEmailCss(), loginHelperImp.getPasswordId());
        loginHelperImp.clickLogin(getWebDriver(), By.cssSelector(loginHelperImp.getSubmitBtn()) );
        sleep(2000);
    }

    @Test(dependsOnMethods = { "enterUserCredentialsAndClickLogin" })
    public void checkConfirPayButtonIsDisabledAndOfferNotValidLinkIsDisplayed(){
        clickCreditCardTab(getWebDriver(), "de/buy", By.linkText("Credit Card"));
        sleep(1000);
        if(isDeTest){
            WebElement we = getFirstElementVisible(getWebDriver(), By.cssSelector(offerNotValid));
        }  else {
            waitForElementCondition(ExpectedConditions.visibilityOf(getWebDriver().findElement(
                                      By.cssSelector(offerNotValidLinkCss))), getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
            currWebElement = WebElementHelper.safeFindElement(getWebDriver(), By.cssSelector(offerNotValidLinkCss));
            //assertThat(" Offer not available element is not displayed ....!", currWebElement.isDisplayed(), is(true));
            myAssertThat(getWebDriver(), " Offer not available element is not displayed ....!", currWebElement.isDisplayed(), true);
        }
        WebElement confirmPayWe = WebElementHelper.safeFindElement(getWebDriver(), By.id(this.confirPayBtnId));
        logger.info("::::::getAtt '" + confirmPayWe.getAttribute("disabled"));
        //assertThat("Confirm button is Enabled, it should Not be ...!", confirmPayWe.isEnabled(), is(false));
        myAssertThat(getWebDriver(), "Confirm button is Enabled, it should Not be ...!", confirmPayWe.isEnabled(), is(false), false);
    }

    //to do Refactor - get string from list - we
    @Test(dependsOnMethods = { "checkConfirPayButtonIsDisabledAndOfferNotValidLinkIsDisplayed" })
    public void checkMessageShownOfferNotValid(){
        List<WebElement> offerNotValidWe = (List<WebElement> )getWebDriver().findElements(By.cssSelector(offerNotValidMessageCss));
        String elementText="";
        int count=0;
        for(WebElement pElement : offerNotValidWe ){
                elementText = elementText+", "+pElement.getText();
            count++;
        }
        logger.info("elementText is : "+elementText);
        //assertThat("FAILED - Offer not valid message does not contains :'", elementText, containsString(offerNotValidMessageText));
        myAssertThat(getWebDriver(), "FAILED - Offer not valid message does not contains :'" + offerNotValidMessageText,
                elementText, containsString(offerNotValidMessageText), true);
    }

    @Test(dependsOnMethods = { "checkMessageShownOfferNotValid" })
    public void clickOfferNotValidLink(){
        if(isDeTest){
            currWebElement = getFirstElementVisible(getWebDriver(), By.cssSelector(offerNotValidLinkCss));
        } else {
            currWebElement = WebElementHelper.safeFindDisplayedAndEnabled(getWebDriver(), By.cssSelector(offerNotValidLinkCss), 1);
        }
        WebElementHelper.scrollAndClick(getWebDriver(), currWebElement);        //currWebElement.click();
        sleep(1000);
        waitForElementCondition( ExpectedConditions.visibilityOf(getWebDriver().findElement(
                                                                By.id(confirPayBtnId))), getWebDriver(), 25);
    }

    @Test(dependsOnMethods = { "clickOfferNotValidLink" })
    public void agreeTCAndClickConfirmPay(){
        WebElement agreeTcWe ;
        if(isDeTest){
            agreeTcWe =  WebElementHelper.safeFindDisplayedAndEnabled(getWebDriver(), By.id(existingTcCheckBoxId), 1);
        } else {
            agreeTcWe =  WebElementHelper.safeFindDisplayedAndEnabled(getWebDriver(), By.id(existingTcCheckBoxId), 1);
        }
        WebElement weConfigPayBtn = WebElementHelper.safeFindElement(getWebDriver(), By.id(confirPayBtnId));
        //assertThat("confirPayBtnId button is Enabled.! it should no be :",weConfirPayBtn.isEnabled(), is(true));
        myAssertThat(getWebDriver(), "Failed, confirPayBtnId button is Enabled and it should not be :", weConfigPayBtn.isEnabled(), true);
        agreeTcWe.click();
        sleep(300);
        //assertThat("confirPayBtnId button is Enabled.! it should no be :", weConfirPayBtn.isEnabled(), is(true));
        myAssertThat(getWebDriver(), "Failed, confirPayBtnId button is Enabled and it should not be :", weConfigPayBtn.isEnabled(), true);
        weConfigPayBtn.click();
        sleep(3000);
    }

    @Test(dependsOnMethods = { "agreeTCAndClickConfirmPay" })
    public void checkReturntThankyouURL(){
        //assertThat(" Failed, URL does not contains :'" + returnThankyouUrlContains + "' ", verifyUrlContains(returnThankyouUrlContains, 15), is(true));
        myAssertThat(getWebDriver(), " Failed, URL does not contains :'" + returnThankyouUrlContains + "' ",
                verifyUrlContains(returnThankyouUrlContains, 15), true);
        sleep(300);
    }



}