package com.englishlive.tests.landing.base;
/**
 *
 */

import com.englishtown.driver.BaseRemoteWebDriver;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.pages.core.BasePage;
import com.englishtown.tests.core.BaseOTLandingPageTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import static com.englishtown.helpers.AssertHelper.myAssertThat;
import static org.hamcrest.core.Is.is;


//TODO - refactor to OT form
public abstract class BaseOTPageTest extends BaseOTLandingPageTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseOTPageTest.class);

    public String clickKey = "email";

    @Test//(timeOut = TESTCASE_TIMEOUT_MED)
    protected void enterOTFormdata(){
        this.enterFormData(formDataMap);
        if(BaseRemoteWebDriver.is_MacSafari || BaseRemoteWebDriver.isBrowser("safari") || "11".equals(BaseRemoteWebDriver.browserVersion)){
            Select select = new Select(getWebDriver().findElement(By.name("age"))); //WebElementHelper.safeFindDisplayedAndEnabled(getWebDriver(), By.name("age"), WaitTool.DEFAULT_WAIT_4_ELEMENT)) ;//
            select.selectByValue("21-25");
        } else {
            currWebElement = getWebDriver().findElement(By.name("age"));
            WebElementHelper.selectOptinUsingDownArrowKey(currWebElement,5, Keys.ARROW_DOWN);
        }
    }
                                                                                                                        //    @Test (dependsOnMethods = { "enterOTFormdata" })//    protected void verifyTheNumberOfFormElement(){//        assertNoOfFormElements(getWebDriver(), By.cssSelector(this.allformElementSelector), this.noOfWebFormElements);//    }
    @Test(dependsOnMethods = { "enterOTFormdata" })
    public void isEventIdZeroOnOTform(){
        //assertThat("Failed : isEventIdZeroOnOTform TEST ...!", getHidenFieldById("eventId", 5), is("0"));
        myAssertThat(getWebDriver(), "Failed : isEventIdZeroOnOTform TEST ...!", getHidenFieldByName("eventId", 5), is("0"), true);
    }

    @Test(dependsOnMethods = { "enterOTFormdata" }) //timeOut = TESTCASE_TIMEOUT_SHORT)
    public void submitOTFormTest(){
        //this.getPage().getForm().submit(); // expensive TODO think of replacing
        getWebDriver().findElement(By.name(clickKey)).submit();
        try{Thread.sleep(1000);}catch (Exception e){}
    }

    @Test(dependsOnMethods = {"submitOTFormTest"})//, timeOut = TESTCASE_TIMEOUT_SHORT)
    protected void verifyAtThankyouEnglishTest(){
        //assertThat("Failed .. url does not contains " + thankyou_page_url_contains,BasePage.waitForUrlContains(this.getWebDriver(), thankyou_page_url_contains, 15), is(true) ) ;
        myAssertThat(getWebDriver(), "Failed .. url does not contains " + thankyou_page_url_contains,
                BasePage.waitForUrlContains(this.getWebDriver(), thankyou_page_url_contains, 15), is(true), true) ;
        try{Thread.sleep(1000);}catch (Exception e){}
    }
    @Test(dependsOnMethods = {"verifyAtThankyouEnglishTest"})//, timeOut = TESTCASE_TIMEOUT_MED)
    protected void verifyStateObjectEvents(){
        assertThankyouPageStateObjectLpOeTrackingEvents();
    }
    @Test(dependsOnMethods = { "verifyStateObjectEvents" })//, timeOut = TESTCASE_TIMEOUT_SHORT)
    protected void verifyStateObjectLeadId(){                             // logger.info("SAND-1887  need to bee fixed for this test to pass");
        assertThankyouPageStateObjectLpOeLeadId() ;                        //This will fail until SAND-1887 is fixed
    }
    /*
    @Test(dependsOnMethods = { "verifyStateObjectLeadId" })//, timeOut = TESTCASE_TIMEOUT_SHORT)
    public void isTrackingEfEducationFirstOtPage(){
        logger.info(" running TEST : BaseOEPageTest.isTrackingEfEducationFirst() ");
        //assertTrue(isTrackingEfEducationFirst(JS_TRACKING_EF, getWebDriver(),CONTAINS_TRACKING_SERVER,getDefaultJsScriptTimeout() ), "FAILED, result does not contains :"+CONTAINS_TRACKING_SERVER);
        myAssertThat(getWebDriver(), "FAILED ...!, result does not contains :" + CONTAINS_TRACKING_SERVER,
                isTrackingEfEducationFirst(JS_TRACKING_EF, getWebDriver(), CONTAINS_TRACKING_SERVER, WaitTool.JS_SCRIPT_DEFAULT_TIMEOUT),true);
    }*/

    @Test (dependsOnMethods = { "verifyStateObjectLeadId" })
    void isLeadType(){
        logger.info("Check lead type is ["+formLeadTypeValue+"]");
        assertStateObjectElementValue(formLeadTypeKey,formLeadTypeValue, false);   // there is type as well ==
    }

}
