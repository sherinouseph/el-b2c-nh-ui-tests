package com.englishlive.tests.smoke.webustest;
/**
 * Login an existing user [de]
 * User: nikol.marku
 * Date: 09/09/14
 */
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.pages.landing.OSLandingPage;
import com.englishtown.tests.core.PageTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import static com.englishtown.helpers.AssertHelper.myAssertThat;


public class DeLoginToSchoolWebusTest extends PageTest<OSLandingPage> {
    private static final Logger logger = LoggerFactory.getLogger(DeLoginToSchoolWebusTest.class);
    @Value("#{applicationPropertiesList['webus.home.page.de']}")
    private String osPageUrl;
    @Value("#{applicationPropertiesList['user.de']}")
    private String deUsername;
    WebElement currentWe;        // market: www.englishtown.de     // user:   test1410280946594@qp1.org       // pass:   password

    protected String loginLinkCss            = "a[href='/de-de/einloggen/']";     //".login-link a";
    protected String emailId                 = "UserName";
    protected String passwordId              = "Password";
    protected String urlContainsIsAtSchool   = "campus";
    protected String schoolMainNavCss = ".header-pepper-true.header-pepper-menu";
    protected String privateLessonsId        = ".btn.btn-primary";
    protected String submitBtn               = ".bs3 .btn.btn-primary" ;


    @BeforeClass
    protected void setup(){
        setThreadSafeDriver();
        this.getPage().isUrlValidForThisPage();
        this.username = deUsername;
    }

    @Test(priority = 1)
    void checkPageOpenClickLoginLink(){
        clickLoginLink(loginLinkCss);
    }
    @Test(priority = 2, dependsOnMethods = { "checkPageOpenClickLoginLink" })
    void enterUserCredentialsTest(){
        enterUserCredentials( this.username,  this.password) ;
    }
    @Test(priority = 3, dependsOnMethods = { "enterUserCredentialsTest" })
    void clickLoginTest(){
        clickLogin(getWebDriver(), By.cssSelector(submitBtn));
        try{Thread.sleep(300);}catch (Exception e){}
    }

    @Test(priority = 4, dependsOnMethods = { "clickLoginTest" })
    void userIsAtScoolPageTest(){
        WaitTool.waitForElementVisible( getWebDriver(),By.cssSelector(privateLessonsId), WaitTool.DEFAULT_WAIT_4_ELEMENT, WaitTool.DEFAULT_POLL_SLEEP ); //this.getPage().waitForElementVisible(this.getWebDriver().findElement(By.id(privateLessonsId)), 20);
        myAssertThat(getWebDriver(),"schoolTitleBarclassName not displayed, Failed ...!",
                this.getWebDriver().findElement(By.cssSelector(schoolMainNavCss)).isDisplayed(), true);
        myAssertThat(getWebDriver()," Failed URL does not contains ...." + urlContainsIsAtSchool,
                this.getWebDriver().getCurrentUrl().toString().contains(urlContainsIsAtSchool),true);
    }


    @AfterClass
    protected void destroyDriverAfterClass(){
        destroyDriver();
    }


    @Override
    protected OSLandingPage createPage() {
        return new OSLandingPage(getWebDriver(), this.osPageUrl);
    }


    protected void clickLoginLink(String cssSelector){
        this.getWebDriver().findElement(By.cssSelector(cssSelector)).isDisplayed();
        currentWe = this.getWebDriver().findElement(By.cssSelector(cssSelector));
        currentWe.click();
        try{Thread.sleep(3000);}catch (Exception e){}
    }

    protected void enterUserCredentials(String email, String pass){
        //this.getWebDriver().findElement(By.cssSelector(submitBtn)).isDisplayed();
        currentWe = WebElementHelper.safeFindElement(this.getWebDriver(),By.name(this.emailId) );
        currentWe.sendKeys(email);
        try{Thread.sleep(300);}catch (Exception e){}
        currentWe = WebElementHelper.safeFindElement(this.getWebDriver(),By.name(this.passwordId) );
        currentWe.sendKeys(pass);
        try{Thread.sleep(300);}catch (Exception e){}
    }
//    protected void clickLogin(By selector){
//        currentWe = WebElementHelper.safeFindElement(this.getWebDriver(), selector );
//        currentWe.click();
//        try{Thread.sleep(3000);}catch (Exception e){}
//    }


}
