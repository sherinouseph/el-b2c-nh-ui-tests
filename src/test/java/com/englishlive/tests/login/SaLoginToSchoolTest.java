package com.englishlive.tests.login;
/**
 * Login an existing user
 *
 */
import com.englishtown.pages.landing.OSLandingPage;
import com.englishtown.tests.core.login.BaseLoginTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class SaLoginToSchoolTest extends BaseLoginTest {
    private static final Logger logger = LoggerFactory.getLogger(SaLoginToSchoolTest.class);
    @Value("#{applicationPropertiesList['home.page.sa']}")
    protected String osPageUrl;
    @Value("#{applicationPropertiesList['user.all']}")
    protected String testUsername;


    @BeforeClass
    protected void setup(){
        setThreadSafeDriver();
        this.getPage().isUrlValidForThisPage();
        username = testUsername;
        isPopupShown=false;
        emailId    = "UserName";
        passwordId = "Password";
        submitBtn  = ".btn.btn-secondary";
        loginLinkCss = "nav a[href='/ar-sa/login/']";
        this.getPage().isUrlValidForThisPage();
        this.username = testUsername;
    }


    @AfterClass
    protected void testAfterClass(){
        destroyDriver();
    }


    @Override
    protected OSLandingPage createPage() {
        return new OSLandingPage(getWebDriver(), this.osPageUrl);
    }




}
