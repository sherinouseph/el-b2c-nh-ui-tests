package com.englishlive.tests.landing.base;
/**
 * Use this test for the flow with 2 steps
 * 1. Open URL and Enter EE form details
 * 2. Click Submit -
 * 3. Thank you page shown - verify that
 * 4. Check State object
 *
 */
import com.englishtown.driver.BaseRemoteWebDriver;
import com.englishtown.driver.local.DriverManager;
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.pages.core.BasePage;
import com.englishtown.tests.core.BaseEELandingPageTest;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import static com.englishtown.helpers.AssertHelper.myAssertThat;


public abstract class BaseEEtoThankyouFormFlowTest extends BaseEELandingPageTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseEEtoThankyouFormFlowTest.class);
    protected boolean isEnterPhoneOneByOne = false;
    protected String phoneNO; // used to enter it one by one
    protected boolean isGetFormSubmit = true ; // set this to false if submit btn is not [[id*=submit],[class*=submit]]


    @Test
    protected void enterEeFormdata(){
        enterFormData(formDataMap);
        if(isEnterPhoneOneByOne){
            WebElementHelper.sendKeyWithWait(findElement(By.name("telephone")), phoneNO, 1000);
        }
    }
    @Test(dependsOnMethods = { "enterEeFormdata" })
    public void checkOnlyOneInputNamedFirstName() {
        AssertHelper.assertElementSizeLessThanOrEqual(getWebDriver(), By.cssSelector(inputFirstNameCss), listSize, 3); //getWebDriver()
    }

    @Test(dependsOnMethods = { "checkOnlyOneInputNamedFirstName" })
    public void submitEeFormTest(){
//        if(isGetFormSubmit) {
//            this.getPage().getForm().submit();
//        }else {
//            click(getWebDriver(), By.cssSelector(submitBtn));
//        }
        if(StringUtils.containsIgnoreCase(BaseRemoteWebDriver.getCurrentBrowserName(), "safari")){
            click(getWebDriver(), By.cssSelector(submitBtn));
        }
        click(getWebDriver(), By.cssSelector(submitBtn));
        try{Thread.sleep(1000);}catch (Exception e){}
    }

    @Test(dependsOnMethods = {"submitEeFormTest"})
    protected void verifyAtThankyouPage(){
        myAssertThat(getWebDriver(), "Failed .. url does not contains " + thankyou_page_url_contains+"; Time waited :"+WaitTool.DEFAULT_WAIT_4_ELEMENT,
                BasePage.waitForUrlContains(this.getWebDriver(), thankyou_page_url_contains, WaitTool.MED_WAIT_4_ELEMENT), true) ;
    }

    @Test(dependsOnMethods = { "verifyAtThankyouPage" })
    protected void verifyStateObjectEvents(){
        assertThankyouPageStateObjectLpOeTrackingEvents();
    }

    @Test(dependsOnMethods = { "verifyStateObjectEvents" })
    protected void verifyStateObjectLeadId(){
        assertThankyouPageStateObjectLpOeLeadId() ;  //This will fail until SAND-1887 is fixed
    }

    /* no more window.s
    @Test(dependsOnMethods = { "verifyStateObjectLeadId" })
    public void isTrackingEfEducationFirstOEpage(){
        myAssertThat(getWebDriver(), "FAILED isTrackingEfEducationFirstOEpage, result does not contains :" + CONTAINS_TRACKING_SERVER,
                isTrackingEfEducationFirst(JS_TRACKING_EF, getWebDriver(), CONTAINS_TRACKING_SERVER, WaitTool.JS_SCRIPT_DEFAULT_TIMEOUT), true);
    }*/

    @Test (dependsOnMethods = { "verifyStateObjectLeadId" })
    void isLeadType(){
        logger.info("Check lead type is ["+formLeadTypeValue+"]");
        assertStateObjectElementValue(formLeadTypeKey,formLeadTypeValue, false);   // there is type as well ==
    }


//    @Override
//    public  void verifyLanguage(){
//    }
//    @Override
//    public  void verifyMarket(){}


}
