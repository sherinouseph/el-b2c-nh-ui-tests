package com.englishtown.pages.common.school.enrolmentui;
/**
 *  after selecting motivation 6 main levels are shown
 *
 * User: nikol.marku
 * Date: 17/01/19 remake NH
 *
 */
import com.englishtown.driver.BaseRemoteWebDriver;
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.MyWebDriverAction;
import com.englishtown.helpers.WaitTool;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class EnglishLevelPage extends BaseEnrollmentPage{ //BasePage {
    public static final Logger logger = LoggerFactory.getLogger(EnglishLevelPage.class);

    public static final String pageUrl = "";

    protected int selectLeveId = 1;

    protected final String LEVEL_ITEMS_CSS      = "[class^='level-step_']>div"; //"6 steps

    protected final String SELECT_THISLEVEL_CSS = LEVEL_ITEMS_CSS + " button";//""button"; // 1 default ":nth-child(2) .Enrollment-btn"

    //protected final String SELECT_THISLEVEL_CSS = " button";
    protected final String START_LEARN_CSS      = "[class^='final-step_'] button"; //".FinalStep .FinalStep-cta";



    @FindBy(css = LEVEL_ITEMS_CSS)
    public List<WebElement> englishLevelListWe ;

    @FindBy(css = "[class^='back-button']")
    public WebElement backButtonWe ;

    @FindBy(css = SELECT_THISLEVEL_CSS)
    public List<WebElement> selectLevelListWe ;


    public EnglishLevelPage(WebDriver webDriver){
        super(webDriver);
    }

    public EnglishLevelPage(WebDriver webDriver, int waitTimeSec) {
        super(webDriver, waitTimeSec);
    }

    public EnglishLevelPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }

    public EnglishLevelPage() {
        this(null, null);
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean simpleTest() {
        logger.info("element displayed ...!");
        AssertHelper.assertWebElementDisplayed(englishLevelListWe.get(1));
        return true;
    }

    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOf(englishLevelListWe.get(1));
    }

    public String getPageUrl() {
        return pageUrl;
    }



    public void waitStepLoaded(By bySelector){
        WaitTool.waitForCondition(ExpectedConditions.visibilityOfElementLocated(bySelector), getWebDriver(), 25);
    }

    public void selectEnglishLevel(int levelIndex){
        englishLevelListWe = WaitTool.findElements(getWebDriver(), By.cssSelector(LEVEL_ITEMS_CSS));
        WaitTool.waitForCondition(ExpectedConditions.elementToBeClickable( englishLevelListWe.get(levelIndex) ), getWebDriver(),  WaitTool.MED_WAIT_4_ELEMENT);
        sleep(2000);
        if(BaseRemoteWebDriver.isBrowser("explorer")){ // ie
            //todo click is not working on IE  https://jira.eflabs.io/browse/SAND-7326
            failTest("fail on IE .. TODO fix click on IE SAND-7326 ...!");
        } else {
            MyWebDriverAction.mouseOver(getWebDriver(), englishLevelListWe.get(levelIndex)); //1

            sleep(3000);

            englishLevelListWe = WaitTool.findElements(getWebDriver(), By.cssSelector(LEVEL_ITEMS_CSS));

            WaitTool.waitForCondition(ExpectedConditions.visibilityOf(
                    englishLevelListWe.get(levelIndex).findElement(By.cssSelector(SELECT_THISLEVEL_CSS))), getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);

            click(englishLevelListWe.get(levelIndex).findElement(By.cssSelector(SELECT_THISLEVEL_CSS)));
            sleep(2000);
        }
    }

    //step 3
    public void clickStartLearning(){
        WaitTool.waitForCondition(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(START_LEARN_CSS)), getWebDriver(),  WaitTool.MED_WAIT_4_ELEMENT);
        WaitTool.waitForCondition(ExpectedConditions.elementToBeClickable(By.cssSelector(START_LEARN_CSS)), getWebDriver(),  WaitTool.MED_WAIT_4_ELEMENT);
        click(WaitTool.findElement(getWebDriver(), By.cssSelector(START_LEARN_CSS)));
        sleep(3000);
    }
//
//
//    public void checkStudentIsAtSchoolCampus(){
//        SchoolHomePage schoolHomePage = new SchoolHomePage(getWebDriver());
//        schoolHomePage.simpleTest();
//    }
    //
//    public void clickToSelectMotivation(int motivationIndex){
//        logger.info("Select ["+motivationIndex+"]  - 0=carrer, 1=travel, 2=english test, 3=personal development-");
//        click(motivationListWe.get(motivationIndex));
//    }



    public int getSelectLeveId() {
        return selectLeveId;
    }

    public void setSelectLeveId(int selectLeveId) {
        this.selectLeveId = selectLeveId;
    }


    public boolean checkAllPageComponentsDisplayed() {
        logger.info("checkAllPageComponentsDisplayed ...!");
        englishLevelListWe = WaitTool.findElements(getWebDriver(), By.cssSelector(LEVEL_ITEMS_CSS));
        AssertHelper.assertElementSizeEqual(getWebDriver(),englishLevelListWe,7);
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