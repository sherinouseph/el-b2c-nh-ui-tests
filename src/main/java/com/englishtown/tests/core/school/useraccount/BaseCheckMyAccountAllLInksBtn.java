package com.englishtown.tests.core.school.useraccount;
/**
 *
 * User: nikol.marku
 * Date: 06/02/18
 *
 * 1. Click on all links and buttons and check next page/popup open *
 *
 *
 */
import com.englishtown.helpers.WaitTool;
import com.englishtown.newhouse.school.pages.account.BillingPage;
import com.englishtown.newhouse.school.pages.account.MyAccountPage;
import com.englishtown.newhouse.school.pages.account.PersonalDetailsPage;
import com.englishtown.newhouse.school.pages.account.PrivacySettingPage;
import com.englishtown.newhouse.school.pages.support.HelpCenterPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;



public abstract class BaseCheckMyAccountAllLInksBtn extends BaseAccountSettingsTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseCheckMyAccountAllLInksBtn.class);

    protected int subscriptionFeatureNumber = 3; // default


    @Test (dependsOnMethods = "goToMyAccountPage")
    public void clickViewDetailsLinkCheckBillingPage(){
        openPageUrl(myAccountPage);
        myAccountPage.waitForAccountPageSpinnerDisappear(WaitTool.MED_WAIT_4_ELEMENT);
        myAccountPage = new MyAccountPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        myAccountPage.getPageLoadedCondition();
        myAccountPage.clickViewDetailsLink();
        myAccountPage.waitForAccountPageSpinnerDisappear(WaitTool.MED_WAIT_4_ELEMENT);
        billingPage = new BillingPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        billingPage.getPageLoadedCondition();
    }

    @Test (dependsOnMethods = "goToMyAccountPage")
    public void clickExploreYourUpgradeCheckBillingPage(){
        openPageUrl(myAccountPage);
        myAccountPage.waitForAccountPageSpinnerDisappear(WaitTool.MED_WAIT_4_ELEMENT);
        waitForUrlContains(getWebDriver(), "dashboard", WaitTool.MED_WAIT_4_ELEMENT);
        myAccountPage = new MyAccountPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        myAccountPage.getPageLoadedCondition();
        myAccountPage.clickExploreUpgradeOptionLink();
        myAccountPage.waitForAccountPageSpinnerDisappear(WaitTool.MED_WAIT_4_ELEMENT);
        billingPage = new BillingPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        billingPage.getPageLoadedCondition();
        sleep(1000);
    }

    @Test (dependsOnMethods = "goToMyAccountPage")
    public void clickViewBillingAndFeature(){
        openPageUrl(myAccountPage);
        WaitTool.acceptAlert(getWebDriver(), WaitTool.DEFAULT_WAIT_4_ELEMENT);
        myAccountPage.waitForAccountPageSpinnerDisappear(WaitTool.MED_WAIT_4_ELEMENT);
        myAccountPage = new MyAccountPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        myAccountPage.clickViewDetailsLink();
        myAccountPage.waitForAccountPageSpinnerDisappear(WaitTool.DEFAULT_WAIT_4_ELEMENT);
        billingPage = new BillingPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        billingPage.getPageLoadedCondition();
    }

    @Test (dependsOnMethods = "goToMyAccountPage")
    public void clickUpdateProfileLink(){
        openPageUrl(myAccountPage);
        WaitTool.acceptAlert(getWebDriver(), WaitTool.DEFAULT_WAIT_4_ELEMENT);
        myAccountPage.waitForAccountPageSpinnerDisappear(WaitTool.MED_WAIT_4_ELEMENT);
        myAccountPage = new MyAccountPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        myAccountPage.getPageLoadedCondition();
        myAccountPage.clickOnUpdateProfileLink();
        //click(myAccountPage.updateProfileLinkWe);
       myAccountPage.waitForAccountPageSpinnerDisappear(WaitTool.DEFAULT_WAIT_4_ELEMENT);
        personalDetailsPage = new PersonalDetailsPage(getWebDriver());
        personalDetailsPage.getPageLoadedCondition();
    }




    @Test (dependsOnMethods = "clickUpdateProfileLink")
    public void clickOnHelpCentre(){
        openPageUrl(myAccountPage);
        myAccountPage.waitForAccountPageSpinnerDisappear(WaitTool.MED_WAIT_4_ELEMENT);
        myAccountPage = new MyAccountPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        myAccountPage.clickOnLiveHelpLink();
        myAccountPage.waitForAccountPageSpinnerDisappear(WaitTool.MED_WAIT_4_ELEMENT);
        helpCenterPage = new HelpCenterPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        helpCenterPage.simpleTest();
    }


}



/***
 @Test (dependsOnMethods = "goToMyAccountPage")
 public void checkReferAFriendLink(){
 openPageUrl(myAccountPage);
 myAccountPage = new MyAccountPage(getWebDriver());
 myAccountPage.getPageLoadedCondition();
 referAFriendPage = new ReferAFriendPage(getWebDriver());
 referAFriendPage.simpleTest();
 }

 @Test (dependsOnMethods = "checkReferAFriendLink")
 public void checkReferAFriendBtn(){
 openPageUrl(myAccountPage);    //backward(getWebDriver());
 sleep(1000);       //        JavaScriptHelper.waitForPageLoaded(getWebDriver(), 25);
 myAccountPage = new MyAccountPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
 myAccountPage.getPageLoadedCondition();;
 referAFriendPage = new ReferAFriendPage(getWebDriver());
 referAFriendPage.getPageLoadedCondition();
 referAFriendPage.simpleTest();
 }

 // this is not working as click goes to  https://englishlive.ef.com/customerservice/dashboard
 //    @Test (dependsOnMethods = "goToMyAccountPage")
 //    public void goToLiveHelp(){
 //        openPageUrl(myAccountPage);
 //        sleep(2000);
 //        myAccountPage = new MyAccountPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
 //        myAccountPage.getPageLoadedCondition();
 //        myAccountPage.clickLiveHelpBtn();
 //        emailUsPage = new EmailUsPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
 //        emailUsPage.getPageLoadedCondition();
 //        emailUsPage.simpleTest();
 //    }
 @Test (dependsOnMethods = "goToMyAccountPage")
 public void goToUpdatePayment(){
 openPageUrl(myAccountPage);
 sleep(1000);
 myAccountPage = new MyAccountPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
 myAccountPage.getPageLoadedCondition();
 //myAccountPage.clickUpdatePaymentBtn();
 sleep(1000);
 logger.info("Popup should be shown ... here ..");
 myAccountPage =  new MyAccountPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
 //myAccountPage.isUpdatePaymentPopupShown();
 }


 ***/