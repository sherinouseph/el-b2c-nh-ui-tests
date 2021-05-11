//package com.englishlive.tests.login;
///**
// * Login an existing user
// * User: nikol.marku
// * Date: 25/04/17
// *
// *
// */
//import com.englishtown.helpers.JavaScriptHelper;
//import com.englishtown.helpers.WaitTool;
//import com.englishtown.pages.landing.OSLandingPage;
//import com.englishtown.tests.core.login.BaseLoginHelper;
//
//import org.openqa.selenium.By;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//  //RU not with us any more
//
//public class RuLoginToSchoolTest extends BaseLoginHelper {
//    private static final Logger logger = LoggerFactory.getLogger(RuLoginToSchoolTest.class);
//    @Value("#{applicationPropertiesList['ru.ru.login.url']}")
//    protected String osPageUrl;
//    @Value("#{applicationPropertiesList['user.all']}")
//    protected String testUsername;
//
//
//    @BeforeClass
//    protected void setup(){
//        setThreadSafeDriver();
//        isPopupShown=false;
//        emailId    = "UserName";
//        passwordId = "Password";
//        submitBtn  = ".btn.btn-secondary.btn-block";
//        this.getPage().isUrlValidForThisPage();
//        username = testUsername;
//    }
//
//
//    @Test
//    public void enterUserCredentialsTest(){
//        JavaScriptHelper.waitForPageLoaded(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
//        enterUserCredentials(this.username, this.passwordId, emailCss, passwordCss);
//    }
//
//    @Test( dependsOnMethods = { "enterUserCredentialsTest" })
//    public void clickLoginTest(){
//        clickLogin(getWebDriver(), By.cssSelector(submitBtn));
//        try{Thread.sleep(1000);}catch (Exception e){}
//    }
//
//
//    @Test( dependsOnMethods = { "clickLoginTest" })
//    public void userIsAtScoolPageTest(){
//        isIsAtSchool();
//    }
//
//
//
//
//    @Override
//    protected OSLandingPage createPage() {
//        return new OSLandingPage(getWebDriver(), this.osPageUrl);
//    }
//
//    @AfterClass
//    protected void testAfterClass(){
//        destroyDriver();
//    }
//
//}
