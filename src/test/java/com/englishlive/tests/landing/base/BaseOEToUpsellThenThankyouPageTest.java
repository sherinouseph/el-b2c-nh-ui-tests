package com.englishlive.tests.landing.base;
/**
 *
 */
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.pages.core.BasePage;
import com.englishtown.tests.core.BaseOELandingPageTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import java.util.Map;

import static com.englishtown.helpers.AssertHelper.myAssertThat;
import static org.hamcrest.Matchers.is;


public abstract class BaseOEToUpsellThenThankyouPageTest extends BaseOELandingPageTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseOEToUpsellThenThankyouPageTest.class);
    protected Map formDataMap;
    public static String osformsubmitId="osformsubmit";

    @Test
    protected void enterOeFormdata(){
        TestUtil.printMethodName(logger, 2);
        this.enterFormData(this.formDataMap);
    }
    @Test(dependsOnMethods = { "enterOeFormdata" })
    protected void submitOeFormTest(){
        this.getPage().getForm().submit();
        sleep(2000);
    }
    // upsell page
    @Test(dependsOnMethods = { "submitOeFormTest" })
    protected void verifyAtUpsellPage(){
        //assertThat("Failed Test : verifyAtUPsellPage. urls does not contain the expected text 'upsell...!' ", BasePage.waitForUrlContains(this.getWebDriver(), "upsell", 10), is(true));
        myAssertThat(getWebDriver(), "Failed Test : verifyAtUPsellPage. urls does not contain the expected text 'upsell...!' ",
                BasePage.waitForUrlContains(this.getWebDriver(), "upsell", 10), true);
    }

    @Test(dependsOnMethods = { "verifyAtUpsellPage" })
    protected void submitUpsellPage() {
        //this.waitForExpectedCondition(ExpectedConditions.visibilityOf( getWebDriver().findElement(By.id(osformsubmitId))), 15, 1);
        WaitTool.waitForCondition( ExpectedConditions.visibilityOf(getWebDriver().findElement(By.id(osformsubmitId))),
                                                             getWebDriver(), WaitTool.DEFAULT_WAIT_4_ELEMENT);
        WebElement we = WebElementHelper.safeFindElement(this.getWebDriver(), By.id(osformsubmitId));
        if (we != null) {
            we.click();
        } else {
            logger.error(" NoSuchElementException [{}] id !", osformsubmitId);
            BasePage.failTest(" NoSuchElementException osformsubmit ! " + osformsubmitId, true);              //fail(" NoSuchElementException : osformsubmitId !");

        }
    }

    @Test(dependsOnMethods = { "submitUpsellPage" })
    protected void verifyAtThankyouPage(){
        final int waitTime = WaitTool.DEFAULT_WAIT_4_ELEMENT;
        myAssertThat(getWebDriver(),
                "Failed Url does not contain the expected text ...!'" + this.thankyou_page_url_contains + "', Waited for :"
                        + waitTime + " seconds; ", BasePage.waitForUrlContains(this.getWebDriver(), this.thankyou_page_url_contains, waitTime), is(true), true);
//        assertThat("Failed Test : verifyAtThankyouPage. urls does not contain the expected text 'thankyou or custom ...!' Waited for :" + waitTime,
//                BasePage.waitForUrlContains(this.getWebDriver(), this.thankyou_page_url_contains, waitTime), is(true));
    }
    @Test(dependsOnMethods = { "verifyAtThankyouPage" })
    protected void verifyThankyouPageStateObjectEvents(){
        assertThankyouPageStateObjectLpOeTrackingEvents();
    }
    @Test(dependsOnMethods = { "verifyThankyouPageStateObjectEvents" })
    protected void verifyStateObjectLeadId(){
        //logger.info("SAND-1887  need to bee fixed for this test to pass");
        assertThankyouPageStateObjectLpOeLeadId() ;  //This will fail until SAND-1887 is fixed
    }
    /*
    @Test(dependsOnMethods = { "verifyStateObjectLeadId" })
    public void isTrackingEfEducationFirstOEpage(){
        logger.info(" running TEST : BaseOEPageTest.isTrackingEfEducationFirst() ");
        //assertTrue(isTrackingEfEducationFirst(JS_TRACKING_EF, getWebDriver(),CONTAINS_TRACKING_SERVER, getDefaultJsScriptTimeout() ), "FAILED, result does not contains :"+CONTAINS_TRACKING_SERVER);
        myAssertThat(getWebDriver(), "FAILED, result does not contains :" + CONTAINS_TRACKING_SERVER,
                isTrackingEfEducationFirst(JS_TRACKING_EF, getWebDriver(),CONTAINS_TRACKING_SERVER,
                        WaitTool.JS_SCRIPT_DEFAULT_TIMEOUT), true);
    }
*/

    //TODO
//    @Test(dependsOnMethods = { "verifyStateObject" })
//    protected void verifyFormValuesArePersisted(){
//
//    }

//    @Override
//    public  void verifyLanguage(){}
//    @Override
//    public  void verifyMarket(){}

}
