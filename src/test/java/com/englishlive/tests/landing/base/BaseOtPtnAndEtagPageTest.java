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


//TODO - refactor to OT form
public abstract class BaseOtPtnAndEtagPageTest extends BaseOTLandingPageTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseOtPtnAndEtagPageTest.class);


    @Test
    protected void testEtagAndPartnerOnEELoandingPage(){
        assertStateObjectParnterCodeAndEtag(
                          stateObjectObjects[2] + partnerCode, stateObjectObjects[2] + etagId, partnerValue, etagValue);
    }

    @Test
    protected void enterOTFormdata(){
        this.enterFormData(formDataMap);
        if(BaseRemoteWebDriver.is_MacSafari){
            Select select = new Select(getWebDriver().findElement(By.name("age")));
            select.selectByValue("21-25");
        } else {
            currWebElement = getWebDriver().findElement(By.name("age"));
            if("11".equals(BaseRemoteWebDriver.browserVersion)){
                logger.info("IE11 action .... selectOptinUsingDownArrowKey is not working for IE11.");
                Select select = new Select(getWebDriver().findElement(By.name("age")));
                select.selectByValue("21-25");
            }
            WebElementHelper.selectOptinUsingDownArrowKey(currWebElement, 5, Keys.ARROW_DOWN);
        }
    }

//    @Test (dependsOnMethods = { "enterOTFormdata" })
//    protected void verifyTheNumberOfFormElement(){
//        assertNoOfFormElements(getWebDriver(),By.cssSelector(allformElementSelector), noOfWebFormElements);
//    }

    @Test(dependsOnMethods = { "enterOTFormdata" })
    public void submitOTFormTest(){
        this.getPage().getForm().submit();
        try{Thread.sleep(1000);}catch (Exception e){}
    }

    @Test(dependsOnMethods = {"submitOTFormTest"})
    protected void verifyAtThankyouEnglishTest(){
        myAssertThat(getWebDriver(), "Failed .. url does not contains :" + thankyou_page_url_contains,
                BasePage.waitForUrlContains(this.getWebDriver(), thankyou_page_url_contains, WaitTool.DEFAULT_WAIT_4_ELEMENT),true ); ;
    }

    @Test(dependsOnMethods = { "verifyAtThankyouEnglishTest" })
    protected void verifyStateObjectEvents(){
        assertThankyouPageStateObjectLpOeTrackingEvents();
    }

    @Test(dependsOnMethods = { "verifyStateObjectEvents" })
    protected void verifyStateObjectLeadId(){        //logger.info("SAND-1887  need to bee fixed for this test to pass");
        assertThankyouPageStateObjectLpOeLeadId() ;  //This will fail until SAND-1887 is fixed
    }

    /*
    @Test(dependsOnMethods = { "verifyStateObjectLeadId" })
    public void isTrackingEfEducationFirstOtPage(){
        logger.info(" running TEST : BaseOEPageTest.isTrackingEfEducationFirst() ");
        myAssertThat(getWebDriver(), "FAILED, result does not contains :" + CONTAINS_TRACKING_SERVER,
                isTrackingEfEducationFirst(JS_TRACKING_EF, getWebDriver(), CONTAINS_TRACKING_SERVER, WaitTool.JS_SCRIPT_DEFAULT_TIMEOUT), true);
    }*/

    @Test(dependsOnMethods = { "verifyStateObjectLeadId" })
    protected void testEtagAndPartnerOnOTtestPage(){
        assertStateObjectParnterCodeAndEtag(
                            stateObjectObjects[3] + partnerCode, stateObjectObjects[3] + etagId, partnerValue, etagValue);
    }

}
