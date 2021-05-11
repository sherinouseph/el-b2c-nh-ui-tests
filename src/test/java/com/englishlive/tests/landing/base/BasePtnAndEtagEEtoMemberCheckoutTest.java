package com.englishlive.tests.landing.base;
/**
 * Use this test for the flow with 2 steps
 * 1. Open URL and Enter EE form detalis
 * 2. Click Submit -
 * 3. Thankyou page shown - verify that
 * 4. Check State object
 *
 */
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.pages.core.BasePage;
import com.englishtown.tests.core.BaseEELandingPageTest;
import com.englishtown.tests.core.EfConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import static com.englishtown.helpers.AssertHelper.myAssertThat;
import static org.hamcrest.Matchers.is;


public abstract class BasePtnAndEtagEEtoMemberCheckoutTest extends BaseEELandingPageTest {
    private static final Logger logger = LoggerFactory.getLogger(BasePtnAndEtagEEtoMemberCheckoutTest.class);
    //http://www.englishtown.fr/lp/ee/emailenglish/?ptn=PTN&etag=goes

    WebElement webElement = null;
    String continueBtnCssSelector = ".linkbutton-component.section a";

    @Test//(dependsOnMethods = { "testEtagAndPartnerOnEELoandingPage" })
    protected void enterEeFormdata(){
         this.enterFormData(formDataMap);
    }

//    @Test (dependsOnMethods = { "enterEeFormdata" })
//    protected void verifyTheNumberOfFormElement(){
//        assertNoOfFormElements(getWebDriver(), By.cssSelector(this.allformElementSelector), this.noOfWebFormElements);
//    }

    @Test   (dependsOnMethods = { "enterEeFormdata" })
    protected void testEtagAndPartnerOnEELoandingPage(){
        try{Thread.sleep(2000);}catch (Exception e){}
        assertStateObjectParnterCodeAndEtag(stateObjectObjects[2] + partnerCode, stateObjectObjects[2] + etagId,
                partnerValue, etagValue);
    }

    @Test(dependsOnMethods = { "testEtagAndPartnerOnEELoandingPage" })
    protected void checkHiddedFiledPTNandEtagAtStartOfTest(){
        assertHidenFieldsParnterCodeAndEtag( partner,  etagId,  partnerValue, etagValue);
    }


    @Test(dependsOnMethods = { "checkHiddedFiledPTNandEtagAtStartOfTest" })
    public void submitEeFormTest(){
        this.getPage().getForm().submit();
        try{Thread.sleep(1000);}catch (Exception e){}
    }

    @Test(dependsOnMethods = {"submitEeFormTest"})
    protected void verifyAtThankyouPage(){
        myAssertThat(getWebDriver(), "Failed .. url does not contains " + thankyou_page_url_contains ,
                BasePage.waitForUrlContains(this.getWebDriver(), thankyou_page_url_contains, WaitTool.DEFAULT_WAIT_4_ELEMENT),true) ;
    }
    @Test(dependsOnMethods = { "verifyAtThankyouPage" })
    protected void verifyStateObjectEvents(){
        assertThankyouPageStateObjectLpOeTrackingEvents();
    }
    @Test(dependsOnMethods = { "verifyStateObjectEvents" })
    protected void verifyStateObjectLeadId(){
        //logger.info("SAND-1887  need to bee fixed for this test to pass");
        assertThankyouPageStateObjectLpOeLeadId() ;  //This will fail until SAND-1887 is fixed
    }
    /*
    @Test(dependsOnMethods = { "verifyStateObjectLeadId" })
    protected void isTrackingEfEducationFirstOEpage(){
        myAssertThat(getWebDriver(),"isTrackingEfEducationFirstOEpage FAILED ...!, result does not contains :"+CONTAINS_TRACKING_SERVER,
                isTrackingEfEducationFirst(JS_TRACKING_EF, getWebDriver(),CONTAINS_TRACKING_SERVER,
                WaitTool.JS_SCRIPT_DEFAULT_TIMEOUT), true);
    }*/

    @Test(dependsOnMethods = { "verifyStateObjectLeadId" })
    protected void testEtagAndPartnerOnEEthankyouPage(){
        assertStateObjectParnterCodeAndEtag(stateObjectObjects[0] + partner, stateObjectObjects[0] + etagId, partnerValue, etagValue);
    }

    @Test(dependsOnMethods = { "testEtagAndPartnerOnEEthankyouPage" })
    protected void clickOnContinueBtn(){
       webElement = WebElementHelper.safeFindElement(getWebDriver(), By.cssSelector(continueBtnCssSelector));
       myAssertThat(getWebDriver(), "Failed ... continue webElement is not displayed on thannky page ", webElement.isDisplayed(), true);
       webElement.click();
        try{Thread.sleep(2000);}catch (Exception e){}
    }

    @Test (dependsOnMethods = { "clickOnContinueBtn" })
    protected void isCheckoutPage(){
        myAssertThat(getWebDriver(), "Failed ....!, is not checkout page, URL DOES NOT CONTAINS '" + EfConstants.checkoutMemberUrlContains + "'",
                isPaymentUrlWithWait(EfConstants.checkoutMemberUrlContains, WaitTool.DEFAULT_WAIT_4_ELEMENT), is(true), true);              //        assertTrue(isPaymentUrlWithWait(EfConstants.checkoutMemberUrlContains), "FAILED .... IS NOT CHECKOUT PAGE, URL DOES NOT CONTAINS " + EfConstants.checkoutMemberUrlContains);
    }

    @Test(dependsOnMethods = { "isCheckoutPage" })
    protected void testEtagAndPartnerOnEEPayMemberPage(){
        assertStateObjectParnterCodeAndEtag(stateObjectObjects[3] + partnerCode, stateObjectObjects[3] + etagId, partnerValue, etagValue);
    }
// NO hidden fields
//    @Test(dependsOnMethods = { "testEtagAndPartnerOnEEPayMemberPage" })
//    protected void checkHidedFiledPTNandEtagPayMemberPageTest(){
//        assertHidenFieldsParnterCodeAndEtag( partner,  etagId,  partnerValue, etagValue);
//    }




    // click continue and check ptn and etag
//    @Override
//    public  void verifyLanguage(){
//    }
//    @Override
//    public  void verifyMarket(){}

}
