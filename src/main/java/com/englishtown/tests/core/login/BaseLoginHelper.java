package com.englishtown.tests.core.login;
/**
 * Login helper methods ONLY
 * old login page
 */
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.pages.core.BasePage;
import com.englishtown.pages.landing.OSLandingPage;
import com.englishtown.tests.core.PageTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.AnyOf.anyOf;

// TODO replace with page object ....
public abstract class BaseLoginHelper extends PageTest<OSLandingPage> {
    private static final Logger logger = LoggerFactory.getLogger(BaseLoginHelper.class);

    protected static WebElement  currentWe;
    protected boolean isPopupShown=false; // popup shown on rola - for name changed

    // set this for each of the test
    protected static String osPageUrl;
    protected static String username;

    protected String loginLinkCss            = ".topbar.container .login-link a";

    protected String emailCss                = "input[name=UserName]";
    protected String passwordCss             = "input[name=Password]";
    protected String urlContainsIsAtSchool   = "school/course"; //currentcourse";
    protected String schoolTitleBarclassName = "titleBar";
    protected String isAtSchoolId = "MyPageManager"; //"MyCourseViewNew_content"; //"private_lessons";


    public void clickLoginLink(String cssSelector){
        currentWe = WebElementHelper.safeFindDisplayedAndEnabled(getWebDriver(), By.cssSelector(cssSelector), 15);
        click(currentWe);    //currentWe.click();  // does not work //safeFindAndClick(getWebDriver(), By.cssSelector(cssSelector));
        try{Thread.sleep(3000);}catch (Exception e){}
    }

    public void enterUserCredentials( String email, String pass, String emailCss, String passwordCss){
        logger.info("enterUserCredentials, username: '"+email+", ");
        currentWe = WebElementHelper.safeFindElement(this.getWebDriver(),By.cssSelector(emailCss) );
        currentWe.sendKeys(email);
        try{Thread.sleep(300);}catch (Exception e){}
        currentWe = WebElementHelper.safeFindElement(this.getWebDriver(), By.cssSelector(passwordCss));
        currentWe.sendKeys(pass);
        try{Thread.sleep(300);}catch (Exception e){}
    }
    public static void enterUserCredentials(WebDriver webDriver, String email, String pass, String emailCss, String passwordCss){
        logger.info("enterUserCredentials, username: '"+email+", pass : "+pass);
        currentWe = WebElementHelper.safeFindElement(webDriver,By.cssSelector(emailCss) );
        currentWe.sendKeys(email);
        try{Thread.sleep(300);}catch (Exception e){}
        currentWe = WebElementHelper.safeFindElement(webDriver,By.cssSelector(passwordCss) );
        currentWe.sendKeys(pass);
        try{Thread.sleep(300);}catch (Exception e){}
    }

    /**
     * Check if url contains one of the string
     * Fail the test if no match found - at least one
     */
    public void isIsAtSchool(){
        String [] urlContainsStrArray = {"/campus", "/community","/school"};
        logger.info("isIsAtSchool Checks if url contains :  /campus ; /community ; /school ");
        try{
            String url = getWebDriver().getCurrentUrl();
            logger.info(" Urls is : "+url);
            if (url !=null){
                AssertHelper.myAssertThat( getWebDriver(),
                     " Failed ...! ; Url '"+url+"' does not contains any of the items specified ...!"+ Arrays.toString(urlContainsStrArray),
                      url, anyOf( containsString(urlContainsStrArray[0]),containsString(urlContainsStrArray[1]),
                                  containsString(urlContainsStrArray[2])), true);
            }else {
                BasePage.failTest("isIsAtSchool Failed ...!; Url is NULL");
            }
        }catch (Exception e){
            BasePage.failTest(e,"isIsAtSchool Failed ...!; Url does not contains campus or community or school" , true);
        }
    }


    public String getEmailCss()   {
        return emailCss;
    }
    public String getPasswordCss() {
        return passwordCss;
    }
    public String getPasswordId() {
        return passwordId;
    }


}
