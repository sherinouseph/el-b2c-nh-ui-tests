package com.englishlive.tests.newhouse.salesforce.base;
/**
 * Login to School from Salesforce
 * check terms and conditions page
 * Accept terms and conditions and click start learning
 * Check enrollment page
 * enroll the user and check if the user reach the school page
 */

import com.englishlive.tests.newhouse.salesforce.base.paymentflow.BaseBankTransferTest;
import com.englishlive.tests.newhouse.salesforce.base.paymentflow.BaseCreditCardTest;
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.JavaScriptHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WebDriverWindowHelper;
import com.englishtown.helpers.reader.ReadWriteToFile;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.pages.checkout.newcheckout.PaymentThankyouPage;
import com.englishtown.pages.common.LoginPage;
import com.englishtown.pages.common.school.EnrolmentPage;
import com.englishtown.pages.common.school.enrolmentui.EnglishLevelPage;
import com.englishtown.pages.common.school.enrolmentui.MotivationPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.Test;

public abstract class BaseLogInToSchool extends BaseBankTransferTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseLogInToSchool.class);
    protected LoginPage loginPage;
    protected String testurlSFToSchool="https://qa-englishlive.ef.com/fr-fr/connexion/?ctr=fr";




    @Test(dependsOnMethods = "checkActuals")
    public void loginUsingLeadEmail(){
        logger.info("loginUsingLeadEmail");
        logger.info(testurlSFToSchool);
        openUrl(getWebDriver(),testurlSFToSchool,35);
        loginPage = new LoginPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        loginPage.getPageLoadedCondition();
        loginPage.simpleTest();
        if(!isPCI)
            password="English";
        loginPage.enterCredentials(leadEmail, password);
        loginPage.clickLoginBtn(loginPage.loginBtnLatest);
    }

    @Test(dependsOnMethods = "loginUsingLeadEmail")
    public void checkTermsAndConditionsPageTest(){
        logger.info("checkTermsAndConditionsPage");
        sleep(2000);
        checkTermsAndConditionsPage();

    }
    @Test(dependsOnMethods = "checkTermsAndConditionsPageTest")
    public void AcceptTermsAndconditons() {
        logger.info("AcceptTermsAndconditons");
        if (isNewhousePayment) {
            click(getWebDriver(), By.name("toc"));
            click(By.cssSelector("button[id*='accept']"));
        } else {
            WebDriverWindowHelper.switchToWindow(getWebDriver(), 0);
            click(getWebDriver(), By.id("CCAuthorized"));
            click(getWebDriver(), By.cssSelector(".et_btn a"));
        }
        waitForUrlContains(getWebDriver(),"enrollment",30);

        AssertHelper.assertUrlContains(TestUtil.getCurrentUrl(getWebDriver()), "enrollment", "enrollment url incorrect");
    }
    @Test(dependsOnMethods = { "AcceptTermsAndconditons" })
    public void enrolStudentToSchool(){
        logger.info("enrolStudentToSchool");
        if(isNewHouseEnroll)
            enrolStudentCheckAtSchoolNewHouse(1,1);
        else
            enrolStudentCheckAtSchoolOldHouse(1, 1);

        //enrolStudentCheckAtSchool();
    }

    /***
     *
     */

    public void checkTermsAndConditionsPage() {
        if(isNewhousePayment){
            JavaScriptHelper.scrollToXY(getWebDriver(),0,5000);
            WaitTool.waitForElementVisible(getWebDriver(),By.name("toc"),35,20);
            AssertHelper.assertWebElementDisplayed(getWebDriver(),By.name("toc"));
            AssertHelper.assertUrlContains(TestUtil.getCurrentUrl(getWebDriver()),"terms-and-conditions","Terms-and-conditions url incorrect");
        }else{
            AssertHelper.assertUrlContains(TestUtil.getCurrentUrl(getWebDriver()),"welcome","url incorrect");
            click(getWebDriver(), By.cssSelector(".et_fieldset a"));
            logger.info("Switch to Terms and conditons window");
            WebDriverWindowHelper.switchToWindow(getWebDriver(),1);
            AssertHelper.assertUrlContains(TestUtil.getCurrentUrl(getWebDriver()),"tc","url incorrect");
            AssertHelper.assertWebElementDisplayed(getWebDriver(),By.cssSelector("#termsintro h2"));
            getWebDriver().close();
        }


    }



    public void enrolStudentCheckAtSchool() {
        EnrolmentPage enrolmentPage = new EnrolmentPage(getWebDriver());
        enrolmentPage.startEnrolment();
        // Step 1
        enrolmentPage.simpleTest();
        enrolmentPage.checkUrlEnrolmentPageUrlStepNo("1");
        enrolmentPage.selectImproveEnglishFor(0);
        // Step 2
        sleep(2000);
        enrolmentPage = new EnrolmentPage(getWebDriver());
        enrolmentPage.waitStepLoaded(By.cssSelector(enrolmentPage.stepBackCss));
        enrolmentPage.checkUrlEnrolmentPageUrlStepNo("2");
        enrolmentPage.selectEnglishLevel(1);
        // Step 3
        sleep(2000);
        enrolmentPage.checkUrlEnrolmentPageUrlStepNo("3");
        enrolmentPage = new EnrolmentPage(getWebDriver());
        enrolmentPage.clickStartLearning();
        sleep(2000);
        enrolmentPage.checkStudentIsAtSchoolCampus();
        logger.info("user is in school page");
    }

    public void enrolStudentCheckAtSchoolOldHouse(int motivationId, int levelId) {
        EnrolmentPage enrolmentPage = new EnrolmentPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        enrolmentPage.startEnrolment();
        // Step 1
        enrolmentPage.simpleTest();
        enrolmentPage.checkUrlEnrolmentPageUrlStepNo("1");
        enrolmentPage.selectImproveEnglishFor(motivationId);
        // Step 2
        sleep(2000);
        enrolmentPage = new EnrolmentPage(getWebDriver());
        enrolmentPage.waitStepLoaded(By.cssSelector(enrolmentPage.stepBackCss));
        enrolmentPage.checkUrlEnrolmentPageUrlStepNo("2");
        enrolmentPage.selectEnglishLevel(levelId);
        // Step 3
        sleep(5000);
        enrolmentPage.checkUrlEnrolmentPageUrlStepNo("3");
        enrolmentPage = new EnrolmentPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        JavaScriptHelper.waitForPageLoaded(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        enrolmentPage.getPageLoadedCondition();
        //enrolmentPage.simpleTest();
        enrolmentPage.clickStartLearning();
        sleep(5000);
        //clickSavebtnInTimeZonePopUp();
        //enrolmentPage.checkStudentIsAtSchoolCampus();
    }

    public void enrolStudentCheckAtSchoolNewHouse(int motivationId, int levelId) {
        click(By.tagName("button"));
        MotivationPage motivationPage = new MotivationPage(getWebDriver());
        //enrolmentPage.checkUrlEnrolmentPageUrlStepNo("1");
        motivationPage.clickToSelectMotivation(motivationId);
        // Step 2
        sleep(2000);
        EnglishLevelPage englishLevelPage = new EnglishLevelPage(getWebDriver());
        //enrolmentPage.waitStepLoaded(By.cssSelector(enrolmentPage.stepBackCss));
        // enrolmentPage.checkUrlEnrolmentPageUrlStepNo("2");
        englishLevelPage.selectEnglishLevel(levelId);
        englishLevelPage.clickStartLearning();
        sleep(5000);
        waitForUrlContains(getWebDriver(), "campus", 55);
        AssertHelper.assertUrlContains(getWebDriver().getCurrentUrl(),"campus","Not the expected URL ...!");
        //clickSavebtnInTimeZonePopUp();
    }


}
