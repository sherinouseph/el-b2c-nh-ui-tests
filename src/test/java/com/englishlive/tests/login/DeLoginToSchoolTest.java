package com.englishlive.tests.login;
/**
 * Login an existing user [de]
 * User: nikol.marku
 * Date: 09/09/14
 *
 *
 */
import com.englishtown.pages.landing.OSLandingPage;
import com.englishtown.tests.core.login.BaseLoginTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class DeLoginToSchoolTest extends BaseLoginTest {
    private static final Logger logger = LoggerFactory.getLogger(DeLoginToSchoolTest.class);
    @Value("#{applicationPropertiesList['home.page.de']}")
    protected String osPageUrl;
    @Value("#{applicationPropertiesList['user.all']}")
    protected String testUsername;


    @BeforeClass
    protected void setup(){
        setThreadSafeDriver();
        logger.info("props :> "+System.getProperties().toString());
        isPopupShown=false;
        emailId    = "UserName";
        passwordId = "Password";
        submitBtn  = ".button-submit"; //".bs3 .btn.btn-primary";
        loginLinkCss = "nav a[href='/de-de/einloggen/']";
        this.getPage().isUrlValidForThisPage();
        this.username = testUsername;
    }

    @Override
    protected OSLandingPage createPage() {
        return new OSLandingPage(getWebDriver(), this.osPageUrl);
    }

    @AfterClass
    protected void testAfterClass(){
        destroyDriver();
    }

}
