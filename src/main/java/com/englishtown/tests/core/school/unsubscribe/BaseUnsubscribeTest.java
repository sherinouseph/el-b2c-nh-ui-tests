package com.englishtown.tests.core.school.unsubscribe;
/**
 * Unsubscribe from all emails
 * User: nikol.marku
 * Date: 08/11/18
 *
 *  https://jira.eflabs.io/browse/SAND-5987
 */

import com.englishtown.dataprovider.bin.StudentBean;
import com.englishtown.driver.local.DriverManager;
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.newhouse.apicore.StaticBaseApiSpec;
import com.englishtown.newhouse.outsideschool.mix.NewHouseUnsubscribePage;
import com.englishtown.newhouse.school.beanandenum.bean.EmailSubscription;
import com.englishtown.newhouse.school.beanandenum.enums.Enroll;
import com.englishtown.pages.common.LoginPage;
import com.englishtown.tests.core.school.core.BaseSchoolTest;
import io.restassured.response.Response;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.is;

public abstract class BaseUnsubscribeTest extends BaseSchoolTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseUnsubscribeTest.class);
    @Value("#{applicationPropertiesList['url.unsubscribe']}")
    protected String unsubscribeBaseUrl;


    protected String loginUrl;
    protected String unsubscribeUrl;

    protected String redirectUrl = "unsubscribe";
    protected String successMsg  = "E-posta";   // TR
    protected String errorMsg    = "Lütfen";

    protected NewHouseUnsubscribePage newHouseUnsubscribePage;

    protected StudentBean studentBean;
    protected EmailSubscription emailSubscription;


    @Test
    void testSuccessUnsubscribe(){
        setThreadSafeDriver();
        openUrl(getWebDriver(), loginUrl);
        LoginPage loginPage = new LoginPage(DriverManager.getDriver(), 20);
        loginPage.getPageLoadedCondition();
        unsubscribeUrl = unsubscribeBaseUrl+studentBean.getUserEmail();
        openUrl(getWebDriver(), unsubscribeUrl);
        waitForUrlContains(getWebDriver(), redirectUrl, 15);
        newHouseUnsubscribePage = new NewHouseUnsubscribePage(getWebDriver(), 25);
        newHouseUnsubscribePage.getPageLoadedCondition();
        newHouseUnsubscribePage.checkAllPageComponentsDisplayed();
        AssertHelper.assertWebElementTextContains(successMsg, newHouseUnsubscribePage.messageWe);
    }

    @Test(dependsOnMethods = "testSuccessUnsubscribe")
    void getDataFromDB(){
        sleep(15000);
        Response response = StaticBaseApiSpec.getAllUserDataResponse(studentBean.getUserEmail(), 200, "qa");
        //response.body().jsonPath().getBoolean("emailSubscriptions.SubscribeToPartnerPromo");

        emailSubscription = new EmailSubscription();
        emailSubscription.setSubscribeToDailyLesson(response.body().jsonPath().getBoolean("emailSubscriptions.SubscribeToPartnerPromo"));
        emailSubscription.setSubscribeToDailyLesson(response.body().jsonPath().getBoolean("emailSubscriptions.SubscribeToDailyLesson"));
        emailSubscription.setSubscribeToDailyLesson(response.body().jsonPath().getBoolean("emailSubscriptions.SubscribeToMarketCampaign"));
        emailSubscription.setSubscribeToDailyLesson(response.body().jsonPath().getBoolean("emailSubscriptions.SubscribeToStudyPlanEmail"));

        logger.info(emailSubscription.toString());
    }

    @Test(dependsOnMethods = "getDataFromDB")
    void checkSubscribeToPartnerPromoFalse(){
        AssertHelper.assertThat("Should be False ...!", emailSubscription.isSubscribeToPartnerPromo(), is(false));
    }

    @Test(dependsOnMethods = "getDataFromDB")
    void checkSubscribeToDailyLessonFalse(){
        AssertHelper.assertThat("Should be False ...!", emailSubscription.isSubscribeToDailyLesson(), is(false));
    }

    @Test(dependsOnMethods = "getDataFromDB")
    void checkSubscribeToMarketCampaignFalse(){
        AssertHelper.assertThat("Should be False ...!", emailSubscription.isSubscribeToMarketCampaign(), is(false));
    }

    @Test(dependsOnMethods = "getDataFromDB")
    void checkSubscribeToStudyPlanEmailFalse(){
        AssertHelper.assertThat("Should be False ...!", emailSubscription.isSubscribeToStudyPlanEmail(), is(false));
    }
    @Test
    void testNonExistentUserUnsubscribe(){
        setThreadSafeDriver();
        openUrl(getWebDriver(), loginUrl);
        LoginPage loginPage = new LoginPage(DriverManager.getDriver(), 20);
        loginPage.getPageLoadedCondition();
        unsubscribeUrl = unsubscribeBaseUrl + "nonexistentuser@nm.com";
        openUrl(getWebDriver(), unsubscribeUrl);
        waitForUrlContains(getWebDriver(), redirectUrl, 15);
        newHouseUnsubscribePage = new NewHouseUnsubscribePage(getWebDriver(), 25);
        newHouseUnsubscribePage.getPageLoadedCondition();
        newHouseUnsubscribePage.checkAllPageComponentsDisplayed();
        WaitTool.waitForTextPresent(getWebDriver(), By.cssSelector("div[class="+NewHouseUnsubscribePage.MESSAGE_CLASSNAME+"]"),
                errorMsg, WaitTool.MED_WAIT_4_ELEMENT25, false);
        AssertHelper.assertWebElementTextContains(errorMsg, newHouseUnsubscribePage.messageWe);
    }


    @AfterMethod(alwaysRun = true)
    protected void testAfter(){
        destroyDriver();
    }


    public StudentBean getEnrolledStudentBean(StudentBean studentBean){
        studentBean.setEnroll(Enroll.INTERMEDIATE);
        studentBean = StaticBaseApiSpec.createUserWithEnroll("qa", studentBean, loginUrl);
        return studentBean;
    }


}
