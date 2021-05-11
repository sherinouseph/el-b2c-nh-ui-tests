package com.englishtown.tests.checkout.common.core;
/**
 * New checkout
 * Cancel student subscription and when user login
 * using members page then checkout page is shown
 */

import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.pages.checkout.newcheckout.DynamicMemberPage;
import com.englishtown.tests.checkout.common.StandardCheckoutFlowTest;
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


public abstract class BaseMemberToLogin extends StandardCheckoutFlowTest {
    private static final Logger logger = LoggerFactory.getLogger( BaseMemberToLogin.class);

    public static boolean isDeTest = false;
//    to baseTest  - public static final String MEMBERID_KEY              = "user.member_id";
    public static String offerNotValidLinkCss            = ".message p a"; // ".message p a";
    public static final String offerNotValidMessageCss   = "form .message p";
    public static final String existingTcCheckBoxId      = "existing-tc";
    public static final String offerNotValidMessageText  = "current offer is not available for you"; //"Unser System zeigt an, dass Sie "; //"current offer is not available for you";
    //Unser System zeigt an, dass Sie bereits einen aktiven Zugang bei EF Englishtown besitzen. Sie kÃ¶nnen daher aktuell keinen weiteren Kurs erwerben.   Klicken Sie hier um zur Schule zu gelangen
    public static final String returnThankyouUrlContains = "buy/return/thankyou/";

    public static String offerNotValid             = ".alert-danger";
    public static String rmLoginSelector           = "#buttons_richtext a";
    public static String confirPayBtnId            = "buttons_columnscontrol_column1_button";

    public static String USER = "test12345et1428673982771@qp1.org";


    @Test//(dependsOnMethods = { "endUserSubscription" })
    public void openMemberPageClickLogin() {
        getWebDriver().get(this.memberPageUrl);
        logger.info("intMemberPage , Click login link ...");
        memberPage = new DynamicMemberPage(getWebDriver());
        scrollToWeAndClick(getWebDriver(), memberPage.firstname, 0, 300);
        memberPage.rmLogin.click();
        sleep(2000);
    }


    private static String waitForElement = "close";//popup - fr je sui jeu
    @Test(dependsOnMethods = { "openMemberPageClickLogin" })
    public void enterUserCredentialsAndClickLogin(){
        // TODO remove this when open on same window        //safeSwitchToWindow(getWebDriver(),1);
        if(TestUtil.getCurrentUrl(getWebDriver()).contains("n.fr") ){
            waitForElementAndclickAtXY(By.className(waitForElement), 1, 1);
        }
        WaitTool.waitForElementVisibleAndClickable(By.id("email"), getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        BaseLoginHelperImp loginHelperImp = new BaseLoginHelperImp();
        sleep(300);
        loginHelperImp.enterUserCredentials(getWebDriver(), USER, "pass", loginHelperImp.getEmailCss(), loginHelperImp.getPasswordId());
        loginHelperImp.clickLogin(getWebDriver(), By.cssSelector(loginHelperImp.getSubmitBtn()) );
        sleep(2000);
    }

    @Test(dependsOnMethods = { "enterUserCredentialsAndClickLogin" })
    public void checkConfirPayButtonIsDisabledAndOfferNotValidLinkIsDisplayed(){
        clickCreditCardTab(getWebDriver(), "de/buy", By.linkText(this.creditCardLinkText));         //"Credit Card"                              //       waitForElementVisibleAndClickableCondition( By.id(existingTcCheckBoxId), getWebDriver(), 20);
        sleep(3000);
        if(isDeTest){
            WebElement we = getFirstElementVisible(getWebDriver(), By.cssSelector(offerNotValid));   //, visibleElementIndex);            //waitForElementCondition( ExpectedConditions.visibilityOf(weList.get(deVisibleElementIndex)), getWebDriver(), 25);                //getWebDriver().findElement(            By.cssSelector(offerNotValidMessageCss)
        }  else {                                                                                                        //List<WebElement> offerNotValidWe = (List<WebElement> )getWebDriver().findElements(By.cssSelector(offerNotValidMessageCss) );
            waitForElementCondition(ExpectedConditions.visibilityOf(getWebDriver().findElement(
                                      By.cssSelector(offerNotValidLinkCss))), getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);                                  //WebElement agreeTcWe = WebElementHelper.safeFindElement(getWebDriver(), By.id(existingTcCheckBoxId));
            currWebElement = WebElementHelper.safeFindElement(getWebDriver(), By.cssSelector(offerNotValidLinkCss));
            //assertThat(" Offer not available element is not displayed ....!", currWebElement.isDisplayed(), is(true));
            myAssertThat(getWebDriver(), "Offer not available element is not displayed ....!", currWebElement.isDisplayed(), true);
        }
        WebElement confirmPayWe = WebElementHelper.safeFindElement(getWebDriver(), By.id(this.confirPayBtnId));
        logger.info("::::::getAtt '" + confirmPayWe.getAttribute("disabled"));
        //assertThat("Confirm button is Enabled, it should Not be ...!", confirmPayWe.isEnabled(), is(false));
        myAssertThat(getWebDriver(), "Confirm button is Enabled, it should Not be ...!", confirmPayWe.isEnabled(), is(false), true);
    }

    //to do Refactor - get string from list - we
    @Test(dependsOnMethods = { "checkConfirPayButtonIsDisabledAndOfferNotValidLinkIsDisplayed" })
    public void checkMessageShownOfferNotValid(){
        List<WebElement> offerNotValidWe = (List<WebElement> )getWebDriver().findElements(By.cssSelector(offerNotValidMessageCss));
        String elementText="";
        int count=0;
        for(WebElement pElement : offerNotValidWe ){                              //logger.info(" Element text is '"+pElement.getText()+"'");  if (count == 0 && !isDeTest){ elementText = pElement.getText(); logger.info(" elementText text is '"+elementText+"'");//            }if(count == 1 &&  isDeTest){
                elementText = elementText+", "+pElement.getText();                //logger.info(" elementText text is '"+elementText+"'");//            }
            count++;
        }
        logger.info("elementText is : "+elementText);
        //assertThat("FAILED - Offer not valid message does not contains :'", elementText, containsString(offerNotValidMessageText));
        myAssertThat(getWebDriver(), "FAILED - Offer not valid message does not contains :'", elementText, containsString(offerNotValidMessageText), true);
    }

    @Test(dependsOnMethods = { "checkMessageShownOfferNotValid" })
    public void clickOfferNotValidLink(){
        if(isDeTest){
            currWebElement = getFirstElementVisible(getWebDriver(), By.cssSelector(offerNotValidLinkCss));
        } else {
            currWebElement = WebElementHelper.safeFindDisplayedAndEnabled(getWebDriver(), By.cssSelector(offerNotValidLinkCss), 1);//getFirstElementVisible(getWebDriver(), By.cssSelector(offerNotValidLinkCss));
        }
        WebElementHelper.scrollAndClick(getWebDriver(), currWebElement);        //currWebElement.click();
        sleep(2000);
        waitForElementCondition( ExpectedConditions.visibilityOf(getWebDriver().findElement(
                                                                By.id(confirPayBtnId))), getWebDriver(), 25);
    }
// TODO is this a dupe code agreeTCAndClickConfirmPay
    @Test(dependsOnMethods = { "clickOfferNotValidLink" })
    public void agreeTCAndClickConfirmPay(){
        WebElement agreeTcWe ;
        if(isDeTest){
            agreeTcWe =  WebElementHelper.safeFindDisplayedAndEnabled(getWebDriver(), By.id(existingTcCheckBoxId), 1);  //)safeFindVisibleElement(getWebDriver(), By.id(existingTcCheckBoxId), 1);
        } else {
            agreeTcWe =  WebElementHelper.safeFindDisplayedAndEnabled(getWebDriver(), By.id(existingTcCheckBoxId), 1);
        }
        WebElement weConfirPayBtn = WebElementHelper.safeFindElement(getWebDriver(), By.id(confirPayBtnId));
        //assertThat("confirPayBtnId button is Enabled.! it should no be :",weConfirPayBtn.isEnabled(), is(true));
        myAssertThat(getWebDriver(), "confirPayBtnId button is Enabled.! it should not be ...!", weConfirPayBtn.isEnabled(), true);
        agreeTcWe.click();
        sleep(300);
        //assertThat("confirPayBtnId button is Enabled.! it should no be :", weConfirPayBtn.isEnabled(), is(true));
        myAssertThat(getWebDriver(), "confirPayBtnId button is Enabled.! it should no be :", weConfirPayBtn.isEnabled(), true);
        weConfirPayBtn.click();
        sleep(3000);
    }

    @Test(dependsOnMethods = { "agreeTCAndClickConfirmPay" })
    public void checkReturntThankyouURL(){
        //assertThat(" Failed, URL does not contains :'" + returnThankyouUrlContains + "' ", verifyUrlContains(returnThankyouUrlContains, 15), is(true));
        myAssertThat(getWebDriver(), " Failed, URL does not contains :'" + returnThankyouUrlContains + "' ", verifyUrlContains(returnThankyouUrlContains, 15), true);
        sleep(300);
    }


}