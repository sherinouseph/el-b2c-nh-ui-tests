package com.englishtown.tests.core.school.course.progressandtest;
/**
 * Level certificate
 * Sherin - 16/04/2018
 * go to progress and test page and check for the presence of tooltip for level certifcate
 * Click on view certificate Button
 * Check for the student name, course name,certified date and level name in the certificate
 * in the progress page check the level test total score and individual scores
 * click on retake test link and assert new window url
 *
 *
 */


import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.JavaScriptHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WebDriverWindowHelper;
import com.englishtown.newhouse.school.pages.course.progressandtests.LevelCertificatePage;
import com.englishtown.newhouse.school.pages.course.progressandtests.ProgressPage;
import com.englishtown.tests.core.school.BaseSimpleLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public abstract class BaseLevelCertificateTest extends BaseSimpleLogin {
    private static final Logger logger = LoggerFactory.getLogger(BaseLevelCertificateTest.class);
    protected String certifiedDate;
    protected String levelName;
    protected String studentName;




    @Test(dependsOnMethods = "checkUserIsAtSchoolHomePage")
    protected void goToProgressPageAndChecklevelCertificateTooltip() {
        logger.info("goToProgressPageAndChecklevelCertificateTooltip");
        progressPage = new ProgressPage(getWebDriver(),WaitTool.MED_WAIT_4_ELEMENT);
        openUrl(getWebDriver(),getSCHOOL_URL()+progressPage.getPageUrl());
        progressPage.simpleTest();
        waitForElementCondition(ExpectedConditions.visibilityOf(progressPage.gotItBtnlevelCertificate),
                getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        progressPage.checkLevelcertificateTooltip();

    }

    @Test(dependsOnMethods = "goToProgressPageAndChecklevelCertificateTooltip")
    protected void clickOnviewCertificateBtn() {
        logger.info("click on view certificate button");
        //openUrl(getWebDriver(),getBASEURL()+SCHOOL_BASE_DOMAIN+progressPage.getPageUrl());
        progressPage.clickOnViewCertificateBtn();
        sleep(3000);
        logger.info("checkLevelCertificate details");
        WebDriverWindowHelper.switchToWindow(getWebDriver(), 1);
        waitForElementCondition(ExpectedConditions.elementToBeClickable(By.className("student-name")), getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
    }

    @Test(dependsOnMethods = "clickOnviewCertificateBtn")
    protected void checkLevelCertificate(){
        logger.info("checkLevelCertificate");
        levelCertificatePage = new LevelCertificatePage(getWebDriver(),30);
        levelCertificatePage.getPageLoadedCondition();
        AssertHelper.assertUrlContains(getWebDriver().getCurrentUrl(), levelCertificatePage.getPageUrl(),"Level certificate url incorrecr");
        levelCertificatePage.simpleTest();
        levelCertificatePage.checkAllPageComponentsDisplayed();
        levelCertificatePage.checkCertificateDetails(courseCodeNumber.getCourseName(),studentName, levelName, certifiedDate);
        getWebDriver().close();
    }


    @Test(dependsOnMethods = "checkLevelCertificate")
    protected void checkLevelTestScoreDetails() {
        WebDriverWindowHelper.switchToWindow(getWebDriver(), 0);
        logger.info("checkLevelTestScoreDetails");
        progressPage = new ProgressPage(getWebDriver(),WaitTool.MED_WAIT_4_ELEMENT);
        progressPage.getPageLoadedCondition();
        JavaScriptHelper.scrollToXY(getWebDriver(),0,2000);
        progressPage.checkLevelTestScore(levelTestScoresBean.getTotalScoreLevelTest(),levelTestScoresBean.getGrammarScore(),levelTestScoresBean.getVocabularyScore(),
                levelTestScoresBean.getReadingScore(),levelTestScoresBean.getListeningScore());

    }

    @Test(dependsOnMethods = "checkLevelTestScoreDetails")
    protected void clickOnRetakeTestLink() {
        logger.info("clickOnRetakeTestLink");
        progressPage.clickOnRetestLink();
        WebDriverWindowHelper.switchToWindow(getWebDriver(), 1);
        AssertHelper.assertUrlContains(getWebDriver().getCurrentUrl(),"school/leveltest?testid","Level test url incorrect");
        logger.info("successfully clicked on retake test link");

    }


    //todo level test pages POMS


}
