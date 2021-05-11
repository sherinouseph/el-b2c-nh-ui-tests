package com.englishtown.tests.core.login;
/**
 * Base login test cases
 *
 */
import com.englishtown.driver.BaseRemoteWebDriver;
import com.englishtown.helpers.JavaScriptHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.tests.core.BaseTest;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public abstract class BaseLoginTest extends BaseLoginHelper {
    private static final Logger logger = LoggerFactory.getLogger(BaseLoginTest.class);
    private static String waitForElement = "close";
    protected static String popupSelector = ".modal-dialog" ; //.modal.in
    public String relativePageUrl = "forgotten-password/";
    public static final String USERNAME_VALIDATION_MSG = "your email or user name";
    public static final String SUCCESSFUL_MSG = "check the email ";


    @Test
    public void checkStateObjectBeforeLogin(){
        if(!BaseRemoteWebDriver.isBrowser("safari")) {
            assertStateObjectElementValue("page.is_new_session", "true", true);
            assertStateObjectElementValue("session.is_returning", "false", true);
        }
        if(isPopupShown){            // need to click to remove pop up            //click(getWebDriver(), By.cssSelector(".pagination-left .cq-dd-image") ); //this.click( getWebDriver().findElement( By.cssSelector(".pagination-left .cq-dd-image")) );
            waitForElementAndclickAtXY(By.cssSelector(popupSelector), 6, 6);
            //sleep(500);
            logger.info(" POP up should be closed ...!");
        }
    }

    @Test( dependsOnMethods = { "checkStateObjectBeforeLogin" })
    public void clickLoginLinkCheckPageOpen() {
        boolean isFrTest=false;
        /*if(this.getPage().getUrl() !=null && this.getPage().getUrl().contains("n.fr") ){
            isFrTest=true;
            waitForElementAndclickAtXY(By.className(waitForElement), 7, 7);                         //IE 11 //ie11 waitForElementCondition(ExpectedConditions.presenceOfElementLocated(By.className(waitForElement)), getWebDriver(), WaitTool.SHORT_WAIT_4_ELEMENT); // clickAtWindow(getWebDriver(), 1,1);
        }*/
        if(this.getPage().getUrl() !=null && this.getPage().getUrl().contains("pt-br") )
            clickAtWindow(getWebDriver(), 7, 7);

        BaseTest.sleep(2000);
        clickLoginLink(loginLinkCss);

        /*if(isFrTest ){
            waitForElementAndclickAtXY(By.className(waitForElement), 5, 5);                         //IE 11 //ie11 waitForElementCondition(ExpectedConditions.presenceOfElementLocated(By.className(waitForElement)), getWebDriver(), WaitTool.SHORT_WAIT_4_ELEMENT); // clickAtWindow(getWebDriver(), 1,1);
        }  */                                                                                                             //waitForElementCondition(ExpectedConditions.visibilityOf(getWebDriver().findElement(By.id(emailId))), getWebDriver(), WaitTool.DEFAULT_WAIT_4_ELEMENT);
        WaitTool.safeFindDisplayedAndEnabled(getWebDriver(), By.cssSelector(emailCss), WaitTool.DEFAULT_WAIT_4_ELEMENT);          //waitForElementVisibleAndClickableCondition(By.id(emailId), getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);

    }

    @Test( dependsOnMethods = { "clickLoginLinkCheckPageOpen" })
    public void enterUserCredentialsTest(){
        JavaScriptHelper.waitForPageLoaded(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        enterUserCredentials(this.username, this.passwordId, emailCss, passwordCss);
    }

    @Test( dependsOnMethods = { "enterUserCredentialsTest" })
    public void clickLoginTest(){
        clickLogin(getWebDriver(), By.cssSelector(submitBtn));
        try{Thread.sleep(1000);}catch (Exception e){}
    }
//    @Test(dependsOnMethods = { "clickLoginTest" })
//    void checkStateObject(){
//        if(getWebDriver().getCurrentUrl().contains(".de/")) {
//            logger.warn(" DE login page Does not have State object so ingnoring this test ...!");
//        } else {
//            sleep(3000);
//            assertUserLogedInStateObjectElementsDe();
//        }
//    }

    @Test( dependsOnMethods = { "clickLoginTest" })
    public void userIsAtScoolPageTest(){
        isIsAtSchool();
    }


}


