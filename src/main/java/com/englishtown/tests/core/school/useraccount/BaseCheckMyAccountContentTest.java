package com.englishtown.tests.core.school.useraccount;
/**
 *
 * User: nikol.marku
 * Date: 06/02/18
 *
 * 1. check page elements
 *
 *
 */


import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.newhouse.school.pages.account.BillingPage;
import com.englishtown.newhouse.school.pages.account.MyAccountPage;
import com.englishtown.newhouse.school.pages.account.PersonalDetailsPage;
import com.englishtown.newhouse.school.pages.support.HelpCenterPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;


public abstract class BaseCheckMyAccountContentTest extends BaseAccountSettingsTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseCheckMyAccountContentTest.class);

    protected int subscriptionFeatureNumber = 3; // default


    @Test(dependsOnMethods = "goToMyAccountPage")
    public void checkMyAccountPageAllElements() {
        myAccountPage.checkAllPageComponentsDisplayed();
    }

    @Test(dependsOnMethods = "checkMyAccountPageAllElements")
    public void checkOfferDescriptionTest() {
        myAccountPage.checkOfferDescription();
    }

    @Test(dependsOnMethods = "checkOfferDescriptionTest")
    public void checkUserName() {
        myAccountPage.checkUsername(username);
    }

    @Test(dependsOnMethods = "checkUserName")
    public void checkBillingSection() {
        myAccountPage.checkLastBill();
        myAccountPage.checkNextBill();
        myAccountPage.checkPaymentMethod();
    }


    @Test (dependsOnMethods = "checkBillingSection")
    public void clickViewDetailsLink(){
        myAccountPage.clickViewDetailsLink();
        myAccountPage.waitForAccountPageSpinnerDisappear(WaitTool.MED_WAIT_4_ELEMENT);
        billingPage = new BillingPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        billingPage.getPageLoadedCondition();
    }

    @Test (dependsOnMethods = "clickViewDetailsLink")
    public void clickExploreYourUpgradeCheckBillingPage(){
        openPageUrl(myAccountPage);
        myAccountPage.waitForAccountPageSpinnerDisappear(WaitTool.LONG_WAIT_4_ELEMENT);
        waitForUrlContains(getWebDriver(), "dashboard", WaitTool.MED_WAIT_4_ELEMENT);
        myAccountPage = new MyAccountPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        myAccountPage.getPageLoadedCondition();
        myAccountPage.clickExploreUpgradeOptionLink();
        waitForUrlContains(getWebDriver(), "contact-us/", WaitTool.MED_WAIT_4_ELEMENT);

        AssertHelper.assertStringContains(getWebDriver().getCurrentUrl(),"contact-us","User not navigated to contact uspage");
        sleep(1000);
    }

    @Test (dependsOnMethods = "clickExploreYourUpgradeCheckBillingPage")
    public void clickViewBillingAndFeature(){
        openPageUrl(myAccountPage);
        myAccountPage.waitForAccountPageSpinnerDisappear(WaitTool.MED_WAIT_4_ELEMENT);
        myAccountPage = new MyAccountPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        myAccountPage.clickOnViewBillingsAndFeauresLink();
        myAccountPage.waitForAccountPageSpinnerDisappear(WaitTool.DEFAULT_WAIT_4_ELEMENT);
        billingPage = new BillingPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        billingPage.getPageLoadedCondition();
    }

    @Test (dependsOnMethods = "clickViewBillingAndFeature")
    public void clickUpdateProfileLink(){
        openPageUrl(myAccountPage);
        //WaitTool.acceptAlert(getWebDriver(), WaitTool.DEFAULT_WAIT_4_ELEMENT);
        myAccountPage.waitForAccountPageSpinnerDisappear(WaitTool.MED_WAIT_4_ELEMENT);
        myAccountPage = new MyAccountPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        myAccountPage.getPageLoadedCondition();
        myAccountPage.clickOnUpdateProfileLink();
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



