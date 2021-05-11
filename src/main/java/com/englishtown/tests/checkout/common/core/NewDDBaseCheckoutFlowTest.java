package com.englishtown.tests.checkout.common.core;
/**
 * New checkout
 * Base
 */

import com.englishtown.helpers.WebElementHelper;
import com.englishtown.pages.core.BasePage;
import com.englishtown.tests.core.EfConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.util.Map;

public abstract class NewDDBaseCheckoutFlowTest extends NewBaseCheckoutFlow{
    private static final Logger logger = LoggerFactory.getLogger(NewDDBaseCheckoutFlowTest.class);
    // set this up per test case
    //default
    protected static int    ddTabId = 0;
    protected static String agreeTcWe = "toc";
    //protected static String payDdWeId = "form_tabctrl_tab-0_button";
    //DD DE
    protected static String BANK_CODE = "12345";
    protected static String ACC_NO    = "12345";
    protected static String ACC_NAME  = "Test";


    @Test(dependsOnMethods = {"clickTab"})
    public void enterDDdata_and_submit() {
        enter_DDformData(ddPayInfoMap);
        failTestPerEnvironment("live", " Fail DD test on live at submit DD form page ...!");
        submitDD(By.id(payDdWeId));
        try{Thread.sleep(2000);  }catch(Exception e){e.printStackTrace();}
    }
    

    @Test(dependsOnMethods = { "enterDDdata_and_submit" })
    public void check_ThankyouPage(){
        checkPaymentThankyouPage();
    }

    //TODO activate this when   order.items.item_id is added to the new check out
    @Test(dependsOnMethods = { "check_ThankyouPage" })
    public void testThankyouPageStateObject(){
        assertThankyouPageStateObjectElementsNewCheckout();        //LAST TEST 18/12/14 fail
    }

    @Test(dependsOnMethods = { "testThankyouPageStateObject" })
    void clickStartLearning(){
        click_StartLearning();
        try{Thread.sleep(3000);  }catch(Exception e){e.printStackTrace();}
    }

    @Test(dependsOnMethods = { "clickStartLearning" })
    public void checkEnrolmentPage() {
        check_EnrolmentPage(); try{Thread.sleep(2000);  }catch(Exception e){e.printStackTrace();}
    }

    /**
     * Enter and submit methods for DD
     */
    public void enter_DDformData(Map ddMap) {
        try{
            enterFormData(ddMap);
        }catch(WebDriverException e){
            BasePage.failTest(e,"enter_DDdetails  FAIL ...!", true);                                                    //fail("enter_DDdetails  FAIL" + TestUtil.getExceptionFirstLine(e));
        }
    }
    public void submitDD(By selector){
        logger.info(" submitDD ...! selector : "+selector);
        WebElementHelper.safeFindAndClick(getWebDriver(), selector);
        try{Thread.sleep(3000);}catch (Exception e){}
    }

}


//    @Test
//    public void openMembers_page_enterDetails(){
//        init_MembersPageAndEnterDetails(this.formDataMap);
//         try{Thread.sleep(1000);  }catch(Exception e){e.printStackTrace();}
//    }
//
//    @Test(dependsOnMethods = { "openMembers_page_enterDetails" })
//    public void submitMemberFormAndClickTabId() {
//        submit_MembersForm();
//        try{Thread.sleep(3000);  }catch(Exception e){}
//        WebElementHelper.clickOnTabId(getWebDriver(), By.cssSelector(tabsListWe), ddTabId);
//    }
