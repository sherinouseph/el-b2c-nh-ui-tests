package com.englishtown.tests.core.common;
/**
 * Enter form data and submit
 *
 */
import com.englishtown.helpers.JavaScriptHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.tests.core.BaseTestHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public abstract class BaseEnterFormDataAndSubmit extends BaseTestHelper {
    private static final Logger logger = LoggerFactory.getLogger(BaseEnterFormDataAndSubmit.class);
    protected String fullName =  "";
    protected static String formSubmitId = "osformsubmit";//default
    protected static String experienceId = "1"; //default
    protected static String welcomeBackMemberUrlContains = "welcome-back/member";
    protected static String offerButtonCss = ".container-fluid button";
    protected static By byOfferButton = new By.ByCssSelector(offerButtonCss); // could be more than one
    protected static By submitWE = new By.ByCssSelector("#"+formSubmitId); // default ; each test should init this one

    @Test//(priority = 0)
    public void enterFormDataTest(){
        enterFormData(formDataMap);
    }

    @Test(dependsOnMethods = {"enterFormDataTest"} )
    public void submitFormTest(){
        waitForElementCondition(ExpectedConditions.elementToBeClickable(By.cssSelector(submitBtn)), getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        sleep(1000);
        WebElement we = WaitTool.findElement(getWebDriver(), By.cssSelector(submitBtn));
        click(we);
        sleep(1000);
        JavaScriptHelper.waitForPageLoaded(getWebDriver(), WaitTool.LONG_WAIT_4_ELEMENT);
    }

    // each test should override this one so it gets the page URL
    //protected abstract String getTestPageUrl() ;


}
