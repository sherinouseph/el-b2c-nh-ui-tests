package com.englishtown.tests.checkout.common.core;
/**
 * New checkout
 * Base
 */

import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WebDriverWindowHelper;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.pages.core.BasePage;
import com.englishtown.tests.core.EfConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.util.Map;

import static org.testng.Assert.fail;

public abstract class PayPalBaseCheckoutFlowTest extends NewBaseCheckoutFlow {
    private static final Logger logger = LoggerFactory.getLogger(PayPalBaseCheckoutFlowTest.class);
   // set this up per test case
    protected static String tabsListWe = ".nav.nav-tabs li";
    protected static int    tabId = 1;
    protected static String confirPPWeCss = ".tab-1 .btn.btn-primary";//form_tabctrl_tab-0_button
    //pp fr
    protected static String payPalAuthorizeId = "PayPalAuthorized";
    protected static String submitToPpId = "btnLogin";//"submitLogin";
    protected static Map payPalDataMap= EfConstants.payPalFr;
    protected static String continuePayPalId = "confirmButtonTop";//"continue"; //"confirmButtonTop"; //"continue";
    protected static String payPalLoginFrameName = "injectedUl";

    protected static String testCountry ;
    public static boolean isExperience2 = false;
//    @Test
//    public void openMembers_page_enterDetails(){
//        init_MembersPageAndEnterDetails(this.formDataMap);
//         try{Thread.sleep(1000);  }catch(Exception e){e.printStackTrace();}
//    }
//
//    @Test(dependsOnMethods = { "openMembers_page_enterDetails" })
//    public void submit_members_form() {
//        submit_MembersForm();
//        try{Thread.sleep(3000);  }catch(Exception e){}
//        WebElementHelper.clickOnTabId(getWebDriver(), By.cssSelector(tabsListWe), tabId);
//        try{Thread.sleep(2000);  }catch(Exception e){}
//    }

    @Test(dependsOnMethods = {"clickTab"})
    public void agreePayPalAndClickConfirm() {
        WebElement agreeWe = WebElementHelper.safeFindElement(getWebDriver(), By.name(payPalAuthorizeId));//id to name change
        click(agreeWe);//        agreeWe.click();
        logger.info(" Clicked to accecpt T&C");
        try{Thread.sleep(200);  }catch(Exception e){}
        WebElement confirmPPbt = WebElementHelper.safeFindElement(getWebDriver(), By.cssSelector(confirPPWeCss));
        click(confirmPPbt) ;   //;confirmPPbt.click();
        try{Thread.sleep(1000);  }catch(Exception e){}
    }

    @Test(dependsOnMethods = {"agreePayPalAndClickConfirm"})
    public void ifJPclickLogin(){
        if(testCountry.contains("jp")){
            click(getWebDriver(), By.id("loadLogin"));    //WebElement we =  findElement(By.id("loadLogin")) ;
        }//id login_email    login_password privateDeviceCheckbox   submitLogin

    }
    @Test(dependsOnMethods = { "ifJPclickLogin" })
    public void enterPayPalCredetntialsAndSubmit(){
        if(testCountry.contains("jp") || testCountry.contains("fr")) {
            // no need to select frame
        } else {
                WebDriverWindowHelper.switchToFrameByName(getWebDriver(), payPalLoginFrameName);        //WebElement we = findElement(By.id("email"));        logger.info("is email displayed : "+we.isDisplayed());}
                WaitTool.waitForElementVisibleAndClickable(By.id("email"), getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        }
        failTestPerEnvironment("live", " Fail PayPal at pay pal enter credetials page ....!"); // fail for live
        enter_PPformData_New();
        //enter_PPformData(payPalDataMap);
        submitPP(By.id(submitToPpId));
        sleep(5000);

        try{Thread.sleep(5000);  }catch(Exception e){e.printStackTrace();}
    }
    @Test(dependsOnMethods = { "enterPayPalCredetntialsAndSubmit" })
    public void confirPPPayment(){
        if(getENVIRONMENT().contains("qa")) isExperience2 = true;
        if(isExperience2){
            findElement(By.id(continuePayPalId));
            WebElement we = getWebDriver().findElement(By.id(continuePayPalId));
            click(we);
        }else {
            WaitTool.waitForElementVisibleAndClickable(By.id(continuePayPalId), getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
            confirPayPalPayment(By.id(continuePayPalId));
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Test(dependsOnMethods = { "confirPPPayment" })
    public void check_ThankyouPage(){
        checkPaymentThankyouPage();
    }
    //TODO monitor this test case
    @Test(dependsOnMethods = { "check_ThankyouPage" })
    public void testThankyouPageStateObject(){
        assertThankyouPageStateObjectElementsNewCheckout();
    }


    /*******************************************************************************************************************
     * Helpers
     *
     */
    public void enter_PPformData(Map ddMap) {
        try{
            enterFormData(ddMap);
        }catch(WebDriverException e){
            BasePage.failTest(e, "enter_PPdetails  FAIL ...!", true);                                                   //fail("enter_PPdetails  FAIL " + TestUtil.getExceptionFirstLine(e));
        }
    }

    public void enter_PPformData_New() {
        try{
            sendKey(getWebDriver(),findElement(By.name("login_email")),"nikol.marku-buyer@ef.com",false);
            submitPP(By.id("btnNext"));
            enter_PPformData(payPalDataMap);

        }catch(WebDriverException e){
            BasePage.failTest(e, "enter_PPdetails  FAIL ...!", true);                                                   //fail("enter_PPdetails  FAIL " + TestUtil.getExceptionFirstLine(e));
        }
    }

    public void submitPP(By selector){
        logger.info(" submitPP ...! selector : "+selector);
        WebElementHelper.safeFindAndClick(getWebDriver(), selector);
        try{Thread.sleep(3000);}catch (Exception e) {    }
    }

    public void confirPayPalPayment(By selector){
        logger.info(" confirPayPalPayment ...! selector : "+selector);
        WebElementHelper.safeFindAndClick(getWebDriver(), selector);
        try{Thread.sleep(3000);}catch (Exception e){}
    }

}
