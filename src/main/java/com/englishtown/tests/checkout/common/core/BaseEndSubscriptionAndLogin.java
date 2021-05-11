package com.englishtown.tests.checkout.common.core;
/**
 * New checkout  -steps -
 * Delete cookies
 * openMemberPageClickLogin
 * endUserSubscription
 * enterUserCredentialsAndClickLogin [thre offers should be shown in this page]
 *
 *
 *
 */

import com.englishtown.commerceclient.ActionResult;
import com.englishtown.commerceclient.Environment;
import com.englishtown.commerceclient.Wrapper;
import com.englishtown.helpers.CookieHandler;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.pages.checkout.newcheckout.BaseAlumniOfferPage;
import com.englishtown.pages.core.BasePage;
import com.englishtown.tests.core.login.BaseLoginHelperImp;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import static com.englishtown.helpers.AssertHelper.myAssertThat;
import static org.hamcrest.Matchers.is;


public abstract class BaseEndSubscriptionAndLogin extends NewCcBaseCheckoutFlowTest {
    private static final Logger logger = LoggerFactory.getLogger( BaseEndSubscriptionAndLogin.class);

    public static boolean isDeTest = false;
    public static String offerNotValidLinkCss            = ".message p a";
    public static final String offerNotValidMessageCss   = "form .message p";
    public static final String existingTcCheckBoxId      = "existing-tc";
    public static String offerNotValidMessageText  = "current offer is not available for you";
    public static final String returnThankyouUrlContains = "buy/return/thankyou/";

    public static String offerNotValid   = ".alert-danger";
    public static String rmLoginSelector = "#buttons_richtext a";
    public static String confirPayBtnId  = "buttons_columnscontrol_column1_button";
    protected static String waitForElement = "close";          //popup - fr je sui jeu
   // pages
    protected BaseAlumniOfferPage baseOfferPage = null;
    protected int numberOfOffers = 1;  //number off offers shown when user login

    @Test(dependsOnMethods = {"setMemberIdAndMarket_check_memberId_NotNullTest"})
    public void deleteUserCookies(){
        CookieHandler.deleteCookies(getWebDriver());
    }

// TODO refactor openMemberPageClickLogin method - used on many places
    @Test(dependsOnMethods = { "deleteUserCookies" })
    public void OpenLoginPage(){
        String[] tempUrl;
        String loginUrl;
        String currentUrl = TestUtil.getCurrentUrl(getWebDriver());
        //TODO rethink this FR if after 25 Nov elive release
        if (currentUrl.contains(".fr") || currentUrl.contains("fr-fr")) {                                 //TODO clean this mess up - this is dirty   //is French open url for connection //
            tempUrl = getWebDriver().getCurrentUrl().split("/");
            if(currentUrl.contains("fr-fr") ){
                loginUrl = tempUrl[0] + "//" + tempUrl[2] + "/fr-fr/connexion/";
            }else {
                loginUrl = tempUrl[0] + "//" + tempUrl[2] + "/connexion/";
            }
//        if(getWebDriver().getCurrentUrl().contains(".fr")) {                                 //TODO clean this mess up - this is dirty   //is French open url for connection //
//            String[] tempUrl= getWebDriver().getCurrentUrl().split("/");
//            String frLoginUrl = tempUrl[0]+"//"+tempUrl[2]+"/connexion/";
            logger.info("Open fr URL frLoginUrl :"+loginUrl);
            getWebDriver().get(loginUrl);
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

    @Test(dependsOnMethods = { "OpenLoginPage" })
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
           myAssertThat(getWebDriver(), "Failed to cancel subscription ...", result.getSucceed(), true);
       } catch (Exception e) {
           e.printStackTrace();
            BasePage.failTest(e, "Cancel Subscrition failed ...!");
       }
    }

    @Test(dependsOnMethods = { "endUserSubscription" })
    public void enterUserCredentialsAndClickLogin(){
       /* if(TestUtil.getCurrentUrl(getWebDriver()).contains("n.fr") ){
            waitForElementAndclickAtXY(By.className(waitForElement), 1, 1);
        }*/
        WaitTool.waitForElementVisibleAndClickable(By.id("email"), getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        BaseLoginHelperImp loginHelperImp = new BaseLoginHelperImp();
        loginHelperImp.enterUserCredentials(getWebDriver(), getUserEmail(),"pass",loginHelperImp.getEmailCss(), loginHelperImp.getPasswordCss());
        loginHelperImp.clickLogin(getWebDriver(), By.cssSelector(getSubmitBtn()) );
        sleep(500);
    }

    @Test(dependsOnMethods = { "enterUserCredentialsAndClickLogin" })
    public void isOfferPageWithNumberOfOffers(){
        baseOfferPage = new BaseAlumniOfferPage(getWebDriver());
        baseOfferPage.simpleTest();
        baseOfferPage.isNoOfOffersShownEqualOrMore(numberOfOffers, WaitTool.DEFAULT_WAIT_4_ELEMENT);
    }// new Class extend this one - click on one of the offers and pay again


}