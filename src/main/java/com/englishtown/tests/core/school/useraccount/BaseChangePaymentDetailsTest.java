package com.englishtown.tests.core.school.useraccount;
/**
 * Change payment details
 * User: nikol.marku
 * Date: 28/03/18
 *
 *
 *  Open and close pass popup; Go to change my payment details and check pages
 *  ..  Looks like we can not test this at the moment as need real card
 *  1.
 *
 *
 */

import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.newhouse.school.pages.account.MyAccountPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;



public abstract class BaseChangePaymentDetailsTest extends BaseAccountSettingsTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseChangePaymentDetailsTest.class);


    @Test (dependsOnMethods = "goToMyAccountPage")
    public void clickUpdatePaymentBtn(){
       // myAccountPage.clickUpdatePaymentBtn();
        sleep(1000);
        logger.info("Popup should be shown ... here ..");
        myAccountPage =  new MyAccountPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        //myAccountPage.isUpdatePaymentPopupShown();
    }

    @Test (dependsOnMethods = "clickUpdatePaymentBtn")
    public void closePopupAndCheckIsClosed(){
        //myAccountPage.clickClosePassPopupBtn();
        sleep(1000);
        initMyAccountPage();
        //myAccountPage.isUpdatePaymentPopupNotShown();
    }

    @Test (dependsOnMethods = "closePopupAndCheckIsClosed")
    public void clickUpdatePaymentBtnAgain(){
        //myAccountPage.clickUpdatePaymentBtn();
        sleep(1000);
        logger.info("Popup should be shown ... here ..");
        myAccountPage =  new MyAccountPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        //myAccountPage.isUpdatePaymentPopupShown();
    }


    @Test (dependsOnMethods = "clickUpdatePaymentBtnAgain")
    public void checkPopupTxtContainsUserName(){
        //myAccountPage.updatePaymentPopupHasUserName(username);
    }

    @Test (dependsOnMethods = "clickUpdatePaymentBtnAgain")
    public void checkPopupContainsForgotPassLinkWe(){
        //AssertHelper.assertWebElementDisplayed(myAccountPage.forgotPwdLinkWe);
    }

    @Test (dependsOnMethods = "checkPopupTxtContainsUserName")
    public void enterWrongPassAndCheckValidationMessage(){
        //myAccountPage.enterPassword_UpdatePayment(PASS.replace("d", "t"));
        //myAccountPage.clickSubmitPassOnPopup();
        sleep(800);
        initMyAccountPage();
        //myAccountPage.checkPasswordValidationMsg(MyAccountPage.PASS_VALIDATION_MSG);
    }

    @Test (dependsOnMethods = "enterWrongPassAndCheckValidationMessage")
    public void enterCorrectPassAndCheckEditPaymentDetailsPage(){
       // WebElementHelper.clearAndsendKeys(getWebDriver(), myAccountPage.passwordWe, PASS,false);
        //myAccountPage.clickSubmitPassOnPopup();
        sleep(2000);
        initUpdatePaymentPage();
    }
    // TODO : there is an error when clicked save//?debug=ccval=false
    // .. mail sent to vahid ... Looks like we can not test this at the moment


}
