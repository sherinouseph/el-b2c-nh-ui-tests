package com.englishtown.tests.core.school;



import com.englishtown.helpers.WaitTool;
import com.englishtown.pages.common.school.enrolmentui.EnglishLevelPage;
import com.englishtown.pages.common.school.enrolmentui.MotivationPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public abstract class BaseEnrollmentStartPageTest extends BaseLogin {
    private static final Logger logger = LoggerFactory.getLogger(BaseEnrollmentStartPageTest.class);

    public String startEnrolmentUrl = "enrollment"; // contains
    @Test(dependsOnMethods = "enterUserCredentialsAndLoginToSchool")
    protected void checkEnrolmentStartPageUrl(){
        logger.info("enterUserCredentialsAndLogin  ...!");
        check_EnrolmentPageUrl();
    }


    @Test(dependsOnMethods = "checkEnrolmentStartPageUrl")
    protected void checkEnrolmentStartBtn(){
        logger.info("checkEnrolmentStartBtn  ...!");
        waitForElementCondition(ExpectedConditions.elementToBeClickable(By.tagName("button")), getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        click(By.tagName("button"));
    }

    @Test(dependsOnMethods = "checkEnrolmentStartBtn")
    protected void selectMotivationAndClickBackButton(){
        MotivationPage motivationPage = new MotivationPage(getWebDriver());
        motivationPage.checkAllPageComponentsDisplayed();
        motivationPage.clickToSelectMotivation(1);
        // Step 2
        sleep(2000);
        EnglishLevelPage englishLevelPage = new EnglishLevelPage(getWebDriver());
        click(englishLevelPage.backButtonWe);
        MotivationPage motivationPage1 = new MotivationPage(getWebDriver());
        motivationPage.clickToSelectMotivation(1);
        sleep(2000);

    }

    @Test(dependsOnMethods = "selectMotivationAndClickBackButton")
    protected void selectLevelAndCheckEnrollmentFinalBtn(){
        EnglishLevelPage englishLevelPage = new EnglishLevelPage(getWebDriver());
        englishLevelPage.checkAllPageComponentsDisplayed();
        englishLevelPage.selectEnglishLevel(1);
        WaitTool.waitForCondition(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class^='final-step_'] button")), getWebDriver(),  WaitTool.MED_WAIT_4_ELEMENT);
    }


    /**
     * Helpers
     */
    public void check_EnrolmentPageUrl() {
        logger.info("check_EnrolmentPage  ...!");
        waitForUrlContains(getWebDriver(), startEnrolmentUrl, WaitTool.MED_WAIT_4_ELEMENT);
        assertIsUrlContaining(startEnrolmentUrl);
    }



}