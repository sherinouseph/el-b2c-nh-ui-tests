//package com.englishlive.tests.mobileandtablets.engage;
//
//import com.englishlive.tests.responsive.UsSubmitButtonShownTest;
//import com.englishtown.driver.BaseRemoteWebDriver;
//import com.englishtown.helpers.AssertHelper;
//import com.englishtown.helpers.WaitTool;
//import com.englishtown.helpers.WebElementHelper;
//import com.englishtown.tests.core.BaseTestHelper;
//import com.englishtown.tests.core.EfConstants;
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import java.util.concurrent.TimeUnit;
//
///**
// * Created by nikol.marku on 1/13/2017.
// * https://jira-bos.englishtown.com/browse/SAND-3312
// * full flow
// * 0.  User share facebook post
// * 0.1 install app and start it
// * 1.  Member page shown
// * 2.  Enter details and Submit form
// * 3.  TY page show with start lesson button
// * 4.  click start lesson .. user go to school
// *
// * Test cover steps 1 to 3 as this should be a mobile test but it is to complex so simplified
// *  NOTE: BEN said no more support for this
// */
//public class EngageMemberFormToTyTest extends BaseTestHelper{
//    private static final Logger logger = LoggerFactory.getLogger(UsSubmitButtonShownTest.class);
//    @Value("#{applicationPropertiesList['buy.mobile.member']}")
//    protected String testUrl ;
//
//    protected String submitMemberFormCss = ".form .bs3 button"; //"form_spacer-1512194259_spacercontent_button";
//    protected String gotoLessonBtnCss    = ".btn-primary";
//    protected String tyUrlContains = "es-mx/buy/mobile/thankyou/";
//
//
//    @BeforeClass
//    public void setupOpensUrl() {
//        setThreadSafeDriver();
//        formDataMap = EfConstants.mxMembersFormMap;
//        this.openUrl(getWebDriver(), testUrl, -1);
//        if(BaseRemoteWebDriver.isBrowser("edge"))
//            sleep(3000);
//    }
//
//    @Test
//    public void  enterMemberDetails(){
//        logger.info("start enterMemberDetails ....!");
//        WaitTool.waitForCondition( ExpectedConditions.invisibilityOfElementLocated(
//                By.cssSelector(memberSpinnerCss)),getWebDriver(), 25);
//        WaitTool.waitForElementClickable(getWebDriver(),By.name("firstname"), 20);
//        enterFormData(formDataMap);
//        currWebElement = getWebDriver().findElement(By.name("telephone"));
//        WebElementHelper.sendKeyWithWait(currWebElement,"2222220000", 100);
//    }
//
//    @Test(dependsOnMethods = { "enterMemberDetails" })
//    public void submitMemberForm() {
//        currWebElement = getWebDriver().findElement(By.cssSelector(submitMemberFormCss));//.click();        //clickAtWindow(getWebDriver(),currWebElement.getLocation().getX(), currWebElement.getLocation().getY() );
//        WebElementHelper.click(findElement(By.cssSelector(submitMemberFormCss)));
//        if(BaseRemoteWebDriver.isBrowser("edge"))
//            sleep(3000);
//    }
//
//    @Test(dependsOnMethods = { "submitMemberForm" })
//    public void checkThankyouPageUrlAndStartLessonButton() {
//        assertIsUrlContaining(tyUrlContains);
//        WaitTool.waitForElementClickable(getWebDriver(), By.cssSelector(gotoLessonBtnCss), 20);
//        currWebElement = findElement(By.cssSelector(gotoLessonBtnCss));
//        //.WebDriverException: Element is obscured
//        if(BaseRemoteWebDriver.isBrowser("edge")) {
//            ((JavascriptExecutor) getWebDriver()).executeScript("arguments[0].click()", currWebElement);
//        }else
//            currWebElement.click();      //WebElementHelper.safeFindAndClick(getWebDriver(), By.cssSelector(gotoLessonBtnCss)); // this is start School
//        sleep(2000);
//    }
//
//    @AfterClass
//    protected void testAfterClass(){
//        destroyDriver();
//    }
//
//
//}
