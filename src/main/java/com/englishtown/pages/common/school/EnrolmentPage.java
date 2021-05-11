package com.englishtown.pages.common.school;
/**
 * On thank you page click start
 * Enrolment page shown with few steps user has to select
 * User: nikol.marku
 * Date: 03/09/14
 *
 */
import com.englishtown.enumpack.EnrollmentSteps;
import com.englishtown.helpers.*;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.newhouse.school.pages.core.BaseSchoolPage;
import com.englishtown.newhouse.school.pages.home.SchoolHomePage;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.hamcrest.core.Is.is;


public class EnrolmentPage extends BaseSchoolPage {

    public static final Logger logger = LoggerFactory.getLogger(EnrolmentPage.class);
    public static final String enrolmentPageUrl = "/enrollment";  //TODO this should be dynamic

    public final String headerLogoCss        = "ue-logo"; // class
    public final String backToTopCss         = "ue-back-totop-content"; // class
    public final String navbarListCss        = "navbar-list"; // class   motivation your level start learning
    public final String startEnrolAvatarCss  = "avatar";
    public final String startEnrolCss        = ".btn.btn-primary";
    public final String improveEnglishForCss = ".option-list label";
    public final String anotherReasonCss     = "anotherReason";   // class
    public final String continueBtnCss       = "button";   // class
    public final String stepBackCss          = ".step-back a";
    public final String levelListCss         = ".level-list li";
    public final String startLearningCss     = ".btn.btn-primary button:nth-child(1)";
    public final String levelListSelectThisLevelCss = levelListCss + ":nth-child(2) .button.bordered"; //LevelStep.level-list li description label span  ".level-list li :nth-child(2) .button.bordered"
    //
    @FindBy(className = navbarListCss)       // find li to get the text ... there are 3 Your motivation; Your level ; Start learning
    public WebElement navbartWe ;            // find .current to find the current selected step

    @FindBy(className = headerLogoCss)
    public WebElement headerLogoWe ;

    @FindBy(className = backToTopCss)
    public WebElement backToTopWe ;

    // enrolment Start should be on TY page
    @FindBy(css = startEnrolCss)
    public WebElement startEnrolWe ;

    @FindBy(className = startEnrolAvatarCss)
    public WebElement startEnrolAvatarWe ;

    // enrolment step 1 improve your english for what ?
    @FindBy(css = improveEnglishForCss)
    public List<WebElement> improveEnglishForWe ;

    @FindBy(name = anotherReasonCss)
    public WebElement anotherReasonWe ;

    @FindBy(className = continueBtnCss)
    public WebElement continueBtnWe ;

    @FindBy(css = stepBackCss)
    public WebElement stepBackWe ;  // nav

    // enrolment step 2
    @FindBy(css = levelListCss)
    public List<WebElement> levelListWe;

    @FindBy(css = levelListSelectThisLevelCss)
    public WebElement levelListSelectThisLevelWe;

    // step 3
    @FindBy(css = startLearningCss)
    public WebElement startLearningWe;


    @FindBy(className = "reason")
    public WebElement reason;  //

    @FindBy(className = "step-header")
    public WebElement stepHeader;

    public EnrolmentPage(WebDriver webDriver){
        super(webDriver);
    }

    public EnrolmentPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }

    public EnrolmentPage(WebDriver webDriver, int waitTimeSec) {
        super(webDriver, waitTimeSec);
    }

    public EnrolmentPage() {
        this(null, null);
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean simpleTest() {
        logger.info(" simpleTest() step 1 only ....!");
        logger.info(" Assert  anotherReasonCss element displayed ...!");
        AssertHelper.assertWebElementDisplayed(anotherReasonWe);
        return true;
    }

    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(anotherReasonWe);
    }

    public String getPageUrl() {
        return enrolmentPageUrl;
    }


    public void checkUrlEnrolmentPageUrlStepNo(String stepId){
        logger.info("Is isUrlEnrolmentPage Step No ["+stepId+"]");
        AssertHelper.assertUrlContains(TestUtil.getCurrentUrl(getWebDriver()), getPageUrl()+stepId, "Is not the expected Step ...!" );
    }

    public void waitStepLoaded(By bySelector){
        WaitTool.waitForCondition(ExpectedConditions.visibilityOfElementLocated(bySelector), getWebDriver(),
                WaitToolConfig.MED_WAIT_4_ELEMENT25);
    }

    // start enrolment
    public void startEnrolment(){
        WaitTool.waitForCondition(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(startEnrolCss)),
                getWebDriver(), WaitToolConfig.MED_WAIT_4_ELEMENT25);
        WaitTool.waitForCondition(ExpectedConditions.elementToBeClickable(By.cssSelector(startEnrolCss)),
                getWebDriver(), WaitToolConfig.MED_WAIT_4_ELEMENT25);
        sleep(3000);
        click(WaitTool.waitForElementVisible(getWebDriver(), By.cssSelector(startEnrolCss), 45, 1000));
        sleep(1000);
    }

    public void assertStartButtonDisplayed(){
        WaitTool.waitForCondition(ExpectedConditions.elementToBeClickable(By.cssSelector(startEnrolCss)),
                getWebDriver(), WaitToolConfig.MED_WAIT_4_ELEMENT25);
        AssertHelper.assertWebElementDisplayed(startEnrolWe);
    }

    public void assertAvatarDisplayed(){
        AssertHelper.assertWebElementDisplayed(startEnrolAvatarWe);
    }

    public void assertMotivationPageHas4Options(){
        AssertHelper.assertElementSizeEqual(getWebDriver(), improveEnglishForWe, 4);
    }

    public void assertLevelPageHas7Levels(){
        AssertHelper.assertElementSizeEqual(getWebDriver(), levelListWe, 7);
    }


    public void assertStepBackDisplayed(){
        WaitTool.waitForCondition(ExpectedConditions.elementToBeClickable(By.cssSelector(stepBackCss)),
                getWebDriver(), WaitToolConfig.MED_WAIT_4_ELEMENT25);
        AssertHelper.assertWebElementDisplayed(stepBackWe);
    }

    // nav bar
    public String getCurrentStepNavBarTxt(){
        String txt = "";
        try {
            txt = TestUtil.getWebElementText(WebElementHelper.safeFindElement(navbartWe, By.className("current")));
            logger.info("Current Step name txt [{}]", txt);
        }catch (WebDriverException e){
            failTest(e, "\nCant get Current navigation bar ...!");
        }
        return txt;
    }

    public int getCurrentStepNavBarId(){
        String stepName = getCurrentStepNavBarTxt();
        if(StringUtils.containsIgnoreCase(stepName, EnrollmentSteps.MOTIVATION.getStep())){
            return 1;
        }else if(StringUtils.containsIgnoreCase(stepName, EnrollmentSteps.LEVEL.getStep())) {
            return 2;
        }else if(StringUtils.containsIgnoreCase(stepName, EnrollmentSteps.LEARNING.getStep())) {
            return 3;
        }else {
            failTest("\nCant get Current Step ID for step name ["+stepName+"]...!" );
        }

        return -1;
    }

    public void assertCurrentNavBar(int id){
        logger.info("checkCurrentNavbar Assert is current NavBar [{}]", id);
        AssertHelper.assertThat("is not the expected Navigation bar", getCurrentStepNavBarId(), is(id) );
    }

    public void typeAnotherReason(String reason){
        logger.info("typeAnotherReason [{}] ...!", reason);
        WebElementHelper.clearAndsendKeys(getWebDriver(), anotherReasonWe, reason, false);
    }

    public void clickContinueBtn(){
        click(continueBtnWe);
    }

    public void clickBackBtn(){
        click(stepBackWe);
    }

    //step 1
    public void selectImproveEnglishFor(int optionId){
        click(improveEnglishForWe.get(optionId));
    }

    //step 2
    public void selectEnglishLevel(int optionId){
        // wait for second option
        WaitTool.waitForCondition(ExpectedConditions.elementToBeClickable(By.cssSelector(levelListCss+":nth-child(2)")), getWebDriver(), 25);
        MyWebDriverAction.mouseOver(getWebDriver(), levelListWe.get(optionId)); //1
        sleep(900);
        WaitTool.waitForCondition(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(levelListSelectThisLevelCss)), getWebDriver(), 25);

        click(WaitTool.findElement(getWebDriver(), By.cssSelector(levelListSelectThisLevelCss)));
        sleep(3000);
    }

    //step 3
    public void clickStartLearning(){
        WaitTool.waitForCondition(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(startLearningCss)), getWebDriver(), 35);
        WaitTool.waitForCondition(ExpectedConditions.elementToBeClickable(By.cssSelector(startLearningCss)), getWebDriver(), 25);
        click(WaitTool.waitForElementVisible(getWebDriver(), By.cssSelector(startLearningCss), WaitTool.DEFAULT_WAIT_4_ELEMENT, 1000));
        sleep(3000);
    }


    public void checkStudentIsAtSchoolCampus(){
        SchoolHomePage schoolHomePage = new SchoolHomePage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        schoolHomePage.getPageLoadedCondition();
        schoolHomePage.simpleTest();
    }


    /**
     * Step 0 start page
     * @return
     */
    @Override
    public boolean checkAllPageComponentsDisplayed() {
        logger.info("checkAllPageComponentsDisplayed ...!");
        checkAllPageComponentsDisplayed(startEnrolWe, headerLogoWe, backToTopWe, startEnrolAvatarWe);
        return true;
    }



}



/***
 sequential steps

 String startEnrolCss = ".btn.btn-primary";
 waitForElementCondition(ExpectedConditions.elementToBeClickable(By.cssSelector(startEnrolCss)), getWebDriver(), 25);
 sleep(2000);
 click(findElement(By.cssSelector(startEnrolCss)));
 //1- next step .. improve english for what ?
 String optionListLabelsCss = ".option-list label";
 String anotherReasonCss = "[name=anotherReason]";
 waitForElementCondition(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(anotherReasonCss)), getWebDriver(), 25);
 List<WebElement> improveEnglishForWe =findElements(By.cssSelector(optionListLabelsCss));

 click(improveEnglishForWe.get(0));
 sleep(3000);
 String strepBackCss = ".step-back a";
 waitForElementCondition(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(strepBackCss)), getWebDriver(), 25);
 // 2- current english level
 String levelListCss = ".level-list li";
 String levelListSelectThisLevelCss = levelListCss + ":nth-child(2) .button.bordered"; // " description label span"; //.level-list li description label span

 List<WebElement> levelListWe = findElements(By.cssSelector(levelListCss));
 // need to hover on list
 waitForElementCondition(ExpectedConditions.elementToBeClickable(By.cssSelector(levelListCss+":nth-child(2)")), getWebDriver(), 25);
 MyWebDriverAction.mouseOver(getWebDriver(), levelListWe.get(1));
 //click(getWebDriver(), By.cssSelector(levelListSelectThisLevelCss)); //(levelListWe.get(1));
 sleep(1000);
 waitForElementCondition(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(levelListSelectThisLevelCss)), getWebDriver(), 25);
 click(findElement(By.cssSelector(levelListSelectThisLevelCss)));
 sleep(3000);
 String startLearningCss = ".btn.btn-primary button:nth-child(1)";
 waitForElementCondition(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(startLearningCss)), getWebDriver(), 25);
 waitForElementCondition(ExpectedConditions.elementToBeClickable(By.cssSelector(startLearningCss)), getWebDriver(), 25);
 click(findElement(By.cssSelector(startLearningCss)));
 sleep(1000);
 // at school now    https://englishlive.ef.com/campus/mypage/home
 String userBoxCss = ".ue-notifications"; //".ue-userbox"; //ue-notifications-container email icon top right of page
 waitForElementCondition(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(userBoxCss)), getWebDriver(), 25);
 //sleep(5000);

 **/