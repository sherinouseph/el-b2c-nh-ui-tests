package com.englishlive.tests.landing.base;
/**
 *
 */
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.pages.core.BasePage;
import com.englishtown.tests.core.BaseOELandingPageTest;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import java.util.Map;
import static com.englishtown.helpers.AssertHelper.myAssertThat;


public abstract class BaseOEPageToSurveyTest extends BaseOELandingPageTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseOEPageToSurveyTest.class);
    protected Map formDataMap;


    @Test
    protected void enterOeFormdata(){
        TestUtil.printMethodName(logger, 2);
        if(isPopupShown){            // need to click to remove pop up
            waitForElementAndclickAtXY(By.className("popup-offer-and-form-content"), 1, 1);
            //WaitTool.waitForElementVisible(getWebDriver(), By.className("popup-offer-and-form-content"), 15);            clickAtWindow(getWebDriver(), 5, 5);
            sleep(1000);
            logger.info(" POP up should be closed ...!");
        }

        this.enterFormData(this.formDataMap);
    }
                  //    @Test (dependsOnMethods = { "enterOeFormdata" }) protected void verifyTheNumberOfFormElement(){ assertNoOfFormElements(getWebDriver(), By.cssSelector(this.allformElementSelector), this.noOfWebFormElements);}

    @Test(dependsOnMethods = { "enterOeFormdata" })
    protected void submitOeFormTest(){
        //this.getPage().getForm().submit();
        click(WaitTool.findElements(getWebDriver(), By.cssSelector(".formset .btn.btn-primary")).get(0));
    }

    @Test(dependsOnMethods = { "submitOeFormTest" })
    protected void verifyAtThankyouPage(){
        AssertHelper.assertWebElementDisplayed(findElement(By.cssSelector(tyMessageCss)));
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
    /* no more window.s
    @Test(dependsOnMethods = { "verifyStateObjectLeadId" })
    public void isTrackingEfEducationFirstOEpage(){
        logger.info(" running TEST : BaseOEPageTest.isTrackingEfEducationFirst() ");
        //TODO assertThat
        //assertTrue(isTrackingEfEducationFirst(JS_TRACKING_EF, getWebDriver(),CONTAINS_TRACKING_SERVER, getDefaultJsScriptTimeout() ), "FAILED, result does not contains :"+CONTAINS_TRACKING_SERVER);
        myAssertThat(getWebDriver(), "FAILED, result does not contains :" + CONTAINS_TRACKING_SERVER,
                isTrackingEfEducationFirst(JS_TRACKING_EF, getWebDriver(), CONTAINS_TRACKING_SERVER, WaitTool.JS_SCRIPT_DEFAULT_TIMEOUT), true);
    }*/

//    // survey
    public static String NO_ANSWER_SELECTOR1 = ".entry .answer[data-code='0']";
    public static String NO_ANSWER_SELECTOR2 = ".entry .answer[data-code='domestic-creditcard']";
    public static String NO_ANSWER_SELECTOR3 = ".entry .answer[data-code='personal']";
    public static String THANKS_SELECTOR4    =".thank-you";

    @Test(dependsOnMethods = { "verifyStateObjectLeadId" })
    void isSurveyStep1() {
        currWebElement = WebElementHelper.safeFindElement(getWebDriver(), By.cssSelector(NO_ANSWER_SELECTOR1));
        currWebElement.click();
        sleep(1000);
    }
    @Test(dependsOnMethods = { "isSurveyStep1" })
    void isSurveyStep2() {
        currWebElement = WebElementHelper.safeFindElement(getWebDriver(), By.cssSelector(NO_ANSWER_SELECTOR2));
        currWebElement.click();
        sleep(1000);
    }
    @Test(dependsOnMethods = { "isSurveyStep1" })
    void isSurveyStep3() {
        currWebElement = WebElementHelper.safeFindElement(getWebDriver(), By.cssSelector(NO_ANSWER_SELECTOR3));
        currWebElement.click();
        sleep(1000);
    }
    @Test(dependsOnMethods = { "isSurveyStep2" })
    void isSurveyThankyouStep4() {
        currWebElement = WebElementHelper.safeFindElement(getWebDriver(), By.cssSelector(THANKS_SELECTOR4));
        currWebElement.click();// this will fail if element not there
        sleep(1000);
    }

    //TODO
//    @Test(dependsOnMethods = { "verifyStateObject" })
//    protected void verifyFormValuesArePersisted(){
//
//    }

//    @Override
//    public  void verifyLanguage(){ logger.info("This test is SET to not run in this case @override does nothing ...!");    }
//    @Override
//    public  void verifyMarket(){logger.info("This test is SET to not run in this case @override does nothing ...!");}

}
