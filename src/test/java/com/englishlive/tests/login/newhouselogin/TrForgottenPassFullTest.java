package com.englishlive.tests.login.newhouselogin;
/**
 * Created by nikol.marku on 12/12/2018.
 *  Forgotten password full test
 *
 *  Note: if email take to long to be sent then the test will fail
 *
 *
 */
import com.englishtown.helpers.mail.ReadMail;
import com.englishtown.pages.common.LoginPage;
import com.englishtown.tests.core.login.flows.BaseNhForgotenPassTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class TrForgottenPassFullTest extends BaseNhForgotenPassTest {
    private static final Logger logger = LoggerFactory.getLogger(TrForgottenPassFullTest.class);
    @Value("#{applicationPropertiesList['tr.login.url']}")
    protected String testUrl;
    @Value("#{applicationPropertiesList['testuser.tr.forgetpass']}")
    protected String testUser;


    @BeforeClass
    protected void setup(){
        failTestPerEnvironment("live", "Run only in QA .. could run in live as well ...!" );
        ReadMail.deleteMails(ReadMail.G_HOST, ReadMail.G_USERNAME, ReadMail.C);
        setThreadSafeDriver();
        testUsername = testUser;
        openUrl(getWebDriver(), testUrl);
        sleep(1000);
        successfulMsg = "email adresinize"; //"Teşekkür ederiz";//"Vielen Dank, bitte";
        userNameValidationMSg = "Lütfen kullanıcı adınızı veya e-posta adresinizi girin";
        thankYouSubmitEmailMsg = "Thank you";
        loginPage = new LoginPage(getWebDriver());
        loginPage.getPageLoadedCondition();
        forgottenPassPage = loginPage.goToForgottenPassPage();
        sleep(3000);
        forgottenPassPage.setUSERNAME_VALIDATION_MSG(userNameValidationMSg);
    }

    @AfterClass
    protected void testAfterClass(){
        try{
            destroyDriver();
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        ReadMail.close();
    }


}


    // quick test
    /*@Test
    protected void setup(){
        failTestPerEnvironment("live", "Run only in QA .. could run in live as well ...!" );
        //ReadMail.deleteMails(ReadMail.G_HOST, ReadMail.G_USERNAME, ReadMail.C);
        //  @Test

        String resetPassUrl = ReadMail.getForgetPassUrlFromMail(ReadMail.getMail(ReadMail.PASS_RESET_EMAIL_SUBJECT,
                ReadMail.G_HOST, ReadMail.G_USERNAME, ReadMail.C, getENVIRONMENT(), 1,
                findEmailsFromDateTime));
        logger.info("url [{}] ...", resetPassUrl);
     }*/
