package com.englishtown.newhouse.school.pages.course.changecourse;

//sherin - 01/02/2018
//
// Change Course page object

import com.englishtown.helpers.*;
import com.englishtown.newhouse.school.pages.core.BaseSchoolPage;
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
import org.testng.Assert;

import java.util.List;

public class ChangeCourseMainPage extends BaseSchoolPage {
    public static final Logger logger = LoggerFactory.getLogger(ChangeCourseMainPage.class);
    public static final String pageUrl = "/school/changecourse?icid=School.ChangeCourse.2012";



//Course selectors

    @FindBy(css = "ul[class='nav nav-tabs tabs-pepper'] li a")
    public List<WebElement> courseListWe;

    @FindBy(className = "smui-page-title")
    public WebElement changeCourseTitleWe;

    @FindBy(css = "li.active a")
    public WebElement activeCourseWe;

    @FindBy(css = ".hero-main h2")
    public WebElement recommendedLevel1;

    @FindBy(css = ".hero-aside-top h3")
    public WebElement recommendedLevel2;

    @FindBy(css = ".hero-aside-bottom h3")
    public WebElement recommendedLevel3;

    @FindBy(css = ".recommended-level")
    public List<WebElement> recommendedCoursesWe;





    public WebElement courseLockWe;

    public String courseLock = ".smui-panel-message-locked";



    //level selectors

    @FindBy(className = "smui-card-note-current") // ".smui-panel.active .smui-card-note-current") //"div[class='tab-pane smui-panel active'] a .smui-card-note-current")
    public WebElement currentLevelTextWe;

    @FindBy(css = "div.smui-panel.active a")//"div[class='tab-pane smui-panel active'] a") //div[class="tab-pane smui-panel active"] .col-xs-4 .smui-card-current
    public List<WebElement> levelListWe;

    @FindBy(css = "div[class='tab-pane smui-panel active'] .col-xs-4")
    public List <WebElement> currentCourseLevelListWe;
    //#GE a[class*="smui-card smui-card-ge"]


    String levelNumberS=".smui-card-number";
    String levelNameS=".smui-card-title";
    String levelDescriptionS=".smui-card-body";
    String learnMoreLinkSel=".smui-card-more"; //"div[class='smui-card-action smui-card-more']";
    String currentCardCss = ".smui-card-current"; // combine with course code ... e.g #GE +
    List <WebElement>levelNumberWe;
    List <WebElement>levelNameWe;
    List <WebElement>levelDescriptionWe;
    List <WebElement>levelLearnMoreLinkWe;

    public ChangeCourseMainPage(WebDriver webDriver){
        super(webDriver);
    }

    public ChangeCourseMainPage(WebDriver webDriver, int waitSec){
        super(webDriver, waitSec);
    }
    @Override
    public boolean checkAllPageComponentsDisplayed() {
        checkAllPageComponentsDisplayed(changeCourseTitleWe,activeCourseWe);
        return false;
    }

    public boolean simpleTest() {
        logger.info("check General English course is displayed...!");
        WaitTool.waitForCondition(ExpectedConditions.visibilityOf(activeCourseWe), getWebDriver(), WaitToolConfig.LONG_WAIT_4_ELEMENT);
        AssertHelper.assertWebElementDisplayed(changeCourseTitleWe);
        return true;
    }

    public ExpectedCondition getPageLoadedCondition() {
        //WaitTool.waitForElementVisible_fluentWait(getWebDriver(),activeCourseWe,WaitTool.SHORT_WAIT_4_ELEMENT,1000);
       WaitTool.waitForCondition(ExpectedConditions.visibilityOf(activeCourseWe), getWebDriver(), WaitToolConfig.LONG_WAIT_4_ELEMENT);
        return ExpectedConditions.visibilityOf(activeCourseWe);
    }

    public void checkAllCoursesDisplayed(int noofCourses) {
        logger.info("Check if all the courses are displayed irrespective of the current level");
        AssertHelper.assertElementSizeEqual(getWebDriver(),courseListWe,noofCourses);
        logger.info("Total number of courses displayed: "+courseListWe.size());

    }

    public void clickOnCourse(int coursenumber){
        logger.info("Click on the course tab ");
        click(courseListWe,coursenumber);
    }

    public void clickCourseAndAssertTotalLevels(){
        logger.info("Click on course and check total number of levels");
        int i=4;
        while(i>=0){
            clickOnCourse(i);
            totalLevelsInACourse(i);
            i--;

        }
    }

   public void checkCourseStatus(String courseCode,int currentLevel,String currentCourseTabCode,int noOfLevelsInCourse){
        //coursecode gives you which is the current course of the user and currentcourseTabcode is currently user click on which course
        if (StringUtils.equalsIgnoreCase(courseCode,"GE") && currentLevel<6){
            logger.info("Check if the course is inactive");
            WaitTool.waitForElementVisible(getWebDriver(),By.cssSelector("#"+currentCourseTabCode+" "+courseLock),30);
            AssertHelper.assertWebElementDisplayed(getWebDriver(),By.cssSelector("#"+currentCourseTabCode+" "+courseLock));
            logger.info("Course inactive...Lock message displayed");
        }else{
            logger.info("Check if the course is active");
            AssertHelper.assertElementSizeMoreThanOrEqual(getWebDriver(),levelListWe,noOfLevelsInCourse);
            logger.info("Course is active...");
        }

   }

    //    public boolean isTheCourseActive(int currentlevel,int courseNumber,String currentCourseCode) {
//        //current level should come from the enum courselevel as this is the actual level name and not the index to help with the selectors
//        //course number is the course which we have to check if it is active or not,pass values
//            logger.info("Check if all the courses are enabled if the current level is less than 6");
//            //general english and toefl course should be enabled regardless of the current level
//        if ((currentlevel < 6) && (currentCourseCode=="GE") && (courseNumber!=0 || courseNumber!=4)) {
//                AssertHelper.assertWebElementDisplayed(courseLockWe.get(courseNumber));
//                logger.info("Message displayed" + courseLockWe.get(courseNumber).getText());
//                //course not active
//                return true;}
//        else if(courseNumber==0 || courseNumber==4){
//                AssertHelper.assertWebElementNotDisplayed(courseLockWe.get(courseNumber));
//                logger.info("Lock message not present");
//                return true;}
//        else if(currentCourseCode!="GE"){
//            AssertHelper.assertWebElementNotDisplayed(courseLockWe.get(courseNumber));
//            logger.info("Lock message not present");
//            return true;}
//
//        else if(currentlevel>6){
//            AssertHelper.assertWebElementNotDisplayed(courseLockWe.get(courseNumber));
//            logger.info("Lock message not present");
//            return true;}
//        else{
//            logger.info("Not able to find whether course is active or not");
//            return false;
//        }
//
//    }
    public boolean totalLevelsInACourse(int currentCourse){
        logger.info("check total number of levels in a course ");
        if(currentCourse==0){
            //if course =0/GE, then total level=16
            logger.info("check General English total levels==16  ");
            Assert.assertEquals(levelListWe.size(),16);
            return true;}
        else if(currentCourse==1){
            //if course =1/Business, then total level=8
            logger.info("check Business total levels==8  ");
            Assert.assertEquals(levelListWe.size(),8);
            return true;}
        else if(currentCourse==2){
            //if course =1/Industry, then total level=17
            logger.info("check industrytotal levels==17  ");
            Assert.assertEquals(levelListWe.size(),17);
            return true;}
        else if(currentCourse==3){
            //if course =3/travel, then total level=1
            logger.info("check travel total levels==1");
            Assert.assertEquals(levelListWe.size(),1);
            return true;}
        else {
            //if course =4/toefl then total level=2
            logger.info("check toefl total levels==2  ");
            Assert.assertEquals(levelListWe.size(),2);
            return true;}


    }

    //level


    public void clickOnLevel(int levelNumber){
        logger.info("Click on the level ");
        // levelListWe=getWebDriver().findElements(By.cssSelector("div[class='tab-pane smui-panel active'] a"));
        click(levelListWe,levelNumber);
        logger.info("successfully clicked on level "+levelNumber);
    }

//    public boolean isCurrentLevelSelected(int currentLevel){
//            logger.info("check the current level is selected ");
//            levelListWe.get(currentLevel).isSelected();
//            AssertHelper.assertWebElementDisplayed(currentLevelTextWe);
//            return true;
//    }



    public String levelName(int levelIndex,String courseCode){
        logger.info("check the level title  ");
        levelNameWe=WebElementHelper.safeFindListOfElementsPresent(getWebDriver(),By.cssSelector("#"+courseCode+" "+levelNameS),30);
        String levelName= levelNameWe.get(levelIndex).getText();
        return levelName;
    }

    public boolean levelNumber(int levelIndex,String courseCode){
        logger.info("check the level number  ");
        levelNumberWe=WebElementHelper.safeFindListOfElementsPresent(getWebDriver(),By.cssSelector("#"+courseCode+" "+levelNumberS),30);
        String levelNumber= levelNumberWe.get(levelIndex).getText();
        AssertHelper.assertWebElementDisplayed(levelNumberWe.get(levelIndex));
        return true;
    }

    public boolean levelDescription(int levelIndex,String courseCode){
        logger.info("check the levelDescription  ");
        levelDescriptionWe=WebElementHelper.safeFindListOfElementsPresent(getWebDriver(),By.cssSelector("#"+courseCode+" "+levelDescriptionS),30);
        AssertHelper.assertWebElementDisplayed(levelDescriptionWe.get(levelIndex));
        return true;
    }

    public boolean levelLearnMoreLink(int levelIndex, String courseCode){
        logger.info("check the level - learnmore link is present  ");
        //levelLearnMoreLinkWe = WebElementHelper.safeFindListOfElementsPresent(getWebDriver(),By.cssSelector("#"+courseCode+" "+learnMoreLinkSel),30);
        WebElement cardWe = WaitTool.findElement(getWebDriver(), By.cssSelector("#"+courseCode+" "+currentCardCss));
        MyWebDriverAction.mouseOver(getWebDriver(), cardWe); //levelLearnMoreLinkWe.get(levelIndex));
        AssertHelper.assertWebElementDisplayed(cardWe); //levelLearnMoreLinkWe.get(levelIndex));
        return true;
    }



    @Override
    public String getPageUrl() {
        return pageUrl;
    }


    public int findSelectLevelIndex() {
        WebElement webElement = null;
        try {
            webElement = currentCourseLevelListWe.get(5).findElement(By.className("smui-card-current"));
            logger.info("Current Level is 6");
            return 5;
        } catch (WebDriverException e) {
            logger.warn("level 6 is not the current course level ...!  " + e.getMessage());
            webElement = currentCourseLevelListWe.get(6).findElement(By.className("smui-card-current"));
            return 6;
        }
    }


}








