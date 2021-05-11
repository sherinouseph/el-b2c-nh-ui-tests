package com.englishtown.tests.core.school.useraccount;
/**
 *
 * User: Sherin Ouseph
 * Date: 22/05/2019
 *
 * Set the user's current payment card number to always use 411*****
 * Go to My account and verify the current payment card last 4 digit is 1111 which is set by API
 * Go to billings and features and click on update payemnt link
 * In update payment page click on my account page and verify the user is back in billings and features page
 * click again on update payment link and check all components are displayed
 * enter payment details and click on update payemnt button
 * check if message is displayed(just the element is checking) and check if user is back in billings page
 * Go to my account page and check if card number got updated
 *
 *
 */

import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.newhouse.school.pages.account.BillingPage;
import com.englishtown.newhouse.school.pages.account.MyAccountPage;
import com.englishtown.newhouse.school.pages.account.UpdatePaymentPage;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public abstract class BaseUpdatePaymentTest extends BaseAccountSettingsTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseUpdatePaymentTest.class);
    protected String UPDATE_CC_NUMBER="4222222222222";




//    @Test (dependsOnMethods = "goToMyAccountPage")
//    public void setCurrentPaymentCard(){
//        //StaticBaseApiSpec.updateCreditCard(getENVIRONMENT(),uuid, TestCard.VISA_QA.getCardNumber(),200);
//        //sleep(3000);
//        //refresh(getWebDriver());
//        myAccountPage=new MyAccountPage(getWebDriver(),WaitTool.MED_WAIT_4_ELEMENT);
//        //todo AssertHelper.assertStringContains(myAccountPage.getLatestPaymentMethod(),TestCard.VISA_QA.getCardNumber().substring(11,14),"Latest Payment card number do not match");
//        //logger.info("Current Payment card number ends with "+myAccountPage.getLatestPaymentMethod());
//
//    }

//    @Test (dependsOnMethods = "setCurrentPaymentCard")
//    public void goToBillingsAndFeatures(){
//        myAccountPage.goToBilling();
//        billingPage = new BillingPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
////        billingPage.getPageLoadedCondition();
////        billingPage.simpleTest();
//    }


    //@Test (dependsOnMethods = "goToBillingsAndFeatures")
    @Test (dependsOnMethods = "goToMyAccountPage")
    public void clickOnUpdatePaymentLink(){
        // NM not in old house billing page any more sept 2019  billingPage.clickOnUpdatePaymentLink();
        updatePaymentPage =new UpdatePaymentPage(getWebDriver(),WaitTool.MED_WAIT_4_ELEMENT25);
        //updatePaymentPage.simpleTest();
    }

    @Test (dependsOnMethods = "clickOnUpdatePaymentLink")
    public void clickonMyAccountLink(){
       click(updatePaymentPage.myAccountLinkWe);
       AssertHelper.assertUrlContains(TestUtil.getCurrentUrl(getWebDriver()),billingPage.getPageUrl(),"User not in billing page ");
    }

    @Test (dependsOnMethods = "clickonMyAccountLink")
    public void clickOnUpdatePaymentLink_1(){
        billingPage = new BillingPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        // NM not in old house billing  billingPage.clickOnUpdatePaymentLink();
        //updatePaymentPage =new UpdatePaymentPage(getWebDriver(),WaitTool.MED_WAIT_4_ELEMENT25);
        //updatePaymentPage.checkAllPageComponentsDisplayed();
    }


    @Test (dependsOnMethods = "clickOnUpdatePaymentLink_1")
    public void enterValidPaymentDetails(){
        updatePaymentPage.enterNewPaymentDetails();
        WebElementHelper.sendKeys(getWebDriver(),findElement(By.name("CreditCardNumber")),UPDATE_CC_NUMBER,false);
        logger.info("Payment Details entered successfully");
    }


    @Test (dependsOnMethods = "enterValidPaymentDetails")
    public void clickOnUpdatePaymentBtnAndVerifyMessage(){
        updatePaymentPage.clickonUpdatePaymentBtn();//verify user is back in billings page.Once we get good selector for update payem,nt link, we should update this
        WaitTool.waitForElementVisible(getWebDriver(),By.cssSelector(".the.message"),35);
        WaitTool.waitForElementVisible(getWebDriver(), By.cssSelector("[class^='cancel-link_']"),35);
    }


    @Test (dependsOnMethods = "clickOnUpdatePaymentBtnAndVerifyMessage")
    public void verifyPaymentUpdate(){
        billingPage.goToYourAccount();
        myAccountPage=new MyAccountPage(getWebDriver(),WaitTool.MED_WAIT_4_ELEMENT);
        //todo AssertHelper.assertStringContains(myAccountPage.getLatestPaymentMethod(),UPDATE_CC_NUMBER.substring(8,12),"Latest Payment card number do not match");
        // todo logger.info("Updated Payment card ends with "+myAccountPage.getLatestPaymentMethod()+ " which is same as last 4 digits of card number "+UPDATE_CC_NUMBER.substring(8,11));
    }


}

