package com.englishlive.tests.landing.base;
/**
 * Use this test for the flow with 3 steps
 * 1. Open URL and Enter EE form details
 * 2. Click Submit - another form is shown
 * 3. Click Submit again
 * 4. Thanky page shown - verify that
 * 5. Check State object
 *
 */
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.pages.core.BasePage;
import com.englishtown.tests.core.BaseEELandingPageTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import static com.englishtown.helpers.AssertHelper.myAssertThat;


public abstract class BaseEEtoProfileThenThankyouFormFlowTest extends BaseEELandingPageTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseEEtoProfileThenThankyouFormFlowTest.class);

    @Test
    protected void enterEeFormdata(){
         this.enterFormData(formDataMap);
        try{Thread.sleep(1000);}catch (Exception e){}
    }
                                                                          //    @Test (dependsOnMethods = { "enterEeFormdata" })  protected void verifyTheNumberOfFormElement(){   assertNoOfFormElements(getWebDriver(), By.cssSelector(this.allformElementSelector), this.noOfWebFormElements);    }
    @Test(dependsOnMethods = { "enterEeFormdata" })
    public void submitEeFormTest(){
        this.getPage().getForm().submit();
        // TODO think of replacing the above        String clickKey = "email";        getWebDriver().findElement(By.id(clickKey)).submit();
        try{Thread.sleep(2000);}catch (Exception e){}
    }

    @Test(dependsOnMethods = { "submitEeFormTest" })
    public void waitForTextOnEmailFieldAndsubmitFormAgainTest(){
        WaitTool.waitForCondition(ExpectedConditions.visibilityOf( findElement(By.id(submitElementId))),
                getWebDriver(), WaitTool.DEFAULT_WAIT_4_ELEMENT);
        WaitTool.waitForTextPresent(getWebDriver(), By.id(weEmailId), weEmailContainingText, WaitTool.DEFAULT_IMPLICIT_WAIT, true);
        // select age again
        selectByValue(getWebDriver(), findElement(By.id("age")), "25-30");
        try{Thread.sleep(500);}catch (Exception e){}
        WebElement we = WebElementHelper.safeFindDisplayedAndEnabled(this.getWebDriver(), By.id(submitElementId), WaitTool.DEFAULT_IMPLICIT_WAIT) ;
        WebElementHelper.click(we);
    }

    @Test(dependsOnMethods ={"waitForTextOnEmailFieldAndsubmitFormAgainTest"})
    protected void verifyAtThankyouPage(){
        //assertThat("FAILED ..URL :!"+getWebDriver().getCurrentUrl()+" DOES NOT Contains :" + thankyou_page_url_contains+        " Time waited : "+WaitTool.DEFAULT_WAIT_4_ELEMENT, BasePage.waitForUrlContains(this.getWebDriver(),thankyou_page_url_contains ,WaitTool.DEFAULT_WAIT_4_ELEMENT), is(true) )  ;
        myAssertThat(getWebDriver(), "FAILED ..URL :!" + getWebDriver().getCurrentUrl() +
                        " DOES NOT Contains :" + thankyou_page_url_contains +" Time waited : " + WaitTool.DEFAULT_WAIT_4_ELEMENT,
                BasePage.waitForUrlContains(this.getWebDriver(), thankyou_page_url_contains, WaitTool.DEFAULT_WAIT_4_ELEMENT), true)  ;
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

//    @Override
//    public  void verifyLanguage(){}
//    @Override
//    public  void verifyMarket(){}

}
