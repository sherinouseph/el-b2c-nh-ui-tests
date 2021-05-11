package com.englishlive.tests.landing.base;

import com.englishtown.helpers.WebDriverWindowHelper;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.helpers.WaitTool;
import com.englishtown.pages.core.BasePage;
import com.englishtown.tests.core.BaseOELandingPageTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.remote.RemoteWebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.util.Map;

import static com.englishtown.helpers.AssertHelper.myAssertThat;
import static org.hamcrest.Matchers.is;


public abstract class BaseOEPageTest extends BaseOELandingPageTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseOEPageTest.class);
    protected Map formDataMap;
    protected boolean isMoveMouseTop = false;


    @Test
    protected void enterOeFormdata(){

        if (isMoveMouseTop) {
            logger.info("Move to element phone ... 3  3 ...");
            sleep(2000);
            Actions action = new Actions(getWebDriver());// To click on the element    builder.moveToElement(element, X, Y).click().build().perform();        action.moveByOffset(1,1); //.moveToElement(element).click().perform();
            WebElement we = getWebDriver().findElement(By.cssSelector(".icon.icon-phone"));
            action.moveToElement(we, 3, 3).build().perform();
            sleep(3000);
            clickAtWindow(getWebDriver(), 1, 1);
        }
        if(isPopupShown){            // need to click to remove pop up            //click(getWebDriver(), By.cssSelector(".pagination-left .cq-dd-image") ); //this.click( getWebDriver().findElement( By.cssSelector(".pagination-left .cq-dd-image")) );
            waitForElementAndclickAtXY(By.className("modal-dialog"), 5, 5);
            sleep(1000);
            clickAtWindow(getWebDriver(),1,1);
            sleep(1000);
            logger.info(" POP up should be closed ...!");
        }
        if(isUseCssEnterFormData){
            this.enterFormDataCss(formDataMap);
        }else
            this.enterFormData(formDataMap);
    }                                                                                                                        //    @Test (dependsOnMethods = { "enterOeFormdata" }) protected void verifyTheNumberOfFormElement(){ assertNoOfFormElements(getWebDriver(), By.cssSelector(this.allformElementSelector), this.noOfWebFormElements);}

    @Test(dependsOnMethods = { "enterOeFormdata" })
    protected void submitOeFormTest(){
        this.getPage().getForm().submit();
    }

    @Test(dependsOnMethods = { "submitOeFormTest" })
    protected void verifyAtThankyouPage(){
        myAssertThat(getWebDriver(),
                "Failed Test : verifyAtThankyouPage. urls does not contain the expected text 'thankyou or custom ...!' ",
                BasePage.waitForUrlContains(this.getWebDriver(),
                        this.thankyou_page_url_contains, 25), is(true), true);                                         //        assertThat("Failed Test : verifyAtThankyouPage. urls does not contain the expected text 'thankyou or custom ...!' ",  BasePage.waitForUrlContains(this.getWebDriver(),//                        this.thankyou_page_url_contains, 15), is(true));
    }

    @Test(dependsOnMethods = { "verifyAtThankyouPage" })
    protected void verifyThankyouPageStateObjectEvents(){
        assertThankyouPageStateObjectLpOeTrackingEvents();
    }
    @Test(dependsOnMethods = { "verifyThankyouPageStateObjectEvents" })
    protected void verifyStateObjectLeadId(){
        assertThankyouPageStateObjectLpOeLeadId() ;
    }

    @Test (dependsOnMethods = { "verifyThankyouPageStateObjectEvents" })
    public void isLeadType(){
        logger.info("Check lead type is ["+formLeadTypeValue+"]");
        assertStateObjectElementValue(formLeadTypeKey,formLeadTypeValue, false);   // there is type as well ==
    }
    /* no more window.s
    @Test(dependsOnMethods = { "isLeadType" })
    public void isTrackingEfEducationFirstOEpage(){
        logger.info(" running TEST : BaseOEPageTest.isTrackingEfEducationFirst() ");
        //assertTrue(isTrackingEfEducationFirst(JS_TRACKING_EF, getWebDriver(),CONTAINS_TRACKING_SERVER,getDefaultJsScriptTimeout() ), "FAILED, result does not contains :"+CONTAINS_TRACKING_SERVER);
        myAssertThat(getWebDriver(), "FAILED, result does not contains :" + CONTAINS_TRACKING_SERVER,
                isTrackingEfEducationFirst(JS_TRACKING_EF, getWebDriver(), CONTAINS_TRACKING_SERVER,
                        WaitTool.JS_SCRIPT_DEFAULT_TIMEOUT), true);
    }*/

//    // survey
//    public static String NO_ANSWER_SELECTOR = ".entry .answer[data-code='0']";
//
//    @Test(dependsOnMethods = { "verifyStateObjectLeadId" })
//         void isSurveyShown() {
//        currWebElement = WebElementHelper.safeFindElement(getWebDriver(), By.cssSelector(NO_ANSWER_SELECTOR));
//        currWebElement.click();
//        sleep(5000);
//    }
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
