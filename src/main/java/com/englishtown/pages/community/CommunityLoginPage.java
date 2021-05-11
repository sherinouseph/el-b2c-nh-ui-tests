package com.englishtown.pages.community;
/**
 * Created by nikol.marku on 09/03/2016.
 * Login page for community
 *
 *  englishlive.ef.com/community/home  goes to http://englishlive.ef.com/community/Secure/Login.aspx?return=/community/home/default.aspx
 */
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.pages.core.MyBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class CommunityLoginPage extends BaseCommunityPage {
    public static final Logger logger = LoggerFactory.getLogger(CommunityLoginPage.class);
    public static final String pageUrl = "englishlive.ef.com/community/Secure/Login.aspx";


    @FindBy(id = "login_userName")
    public WebElement email;  //

    @FindBy(id = "login_password")
    public WebElement pass;

    @FindBy(id = "btnLogin")
    public WebElement loginBtn;

    @FindBy(className = "signuplink")
    public WebElement signUpLink;  // link to PnP page pricing


    public CommunityLoginPage(WebDriver webDriver){
        super(webDriver);
    }
    /*
    public CommunityHomePage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }
    public CommunityHomePage() {
        this(null, null);
    }*/
    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean simpleTest() {
        logger.info(" simpleTest()");
        return email.isDisplayed() ;
    }
    public boolean simpleTest(WebElement we) {
        logger.info(" simpleTest ...!");
        return we.isDisplayed() ;
    }
    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(email);
    }
    public String getPageUrl() {
        return pageUrl;
    }

    public CommunityHomePage login(String user, String userPass){
        WebElementHelper.sendKeys(getWebDriver(),email,user, false );
        WebElementHelper.sendKeys(getWebDriver(),pass,userPass, false );
        WebElementHelper.click(loginBtn);

        return new CommunityHomePage(getWebDriver());
    }
}
