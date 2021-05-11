package com.englishtown.newhouse.school.pages.course.changecourse;

//sherin - 02/02/2018
//
// Change Course page object

import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.newhouse.school.pages.core.BaseSchoolPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ChangeCourseModulePage extends BaseSchoolPage {
    public static final Logger logger = LoggerFactory.getLogger(ChangeCourseModulePage.class);
    public static final String pageUrl = "changecourse?icid=School.ChangeCourse.2012";



//Course selectors

    @FindBy(className ="btn-primary" )//"button[class*='btn btn-primary']"
    public WebElement changeToThisCourseBtnWe;

    @FindBy(css = ".smui-drawer-title")
    public WebElement levelNameWe;

    @FindBy(css = ".lead")
    public WebElement levelSubHeadingWe;

    @FindBy(css = ".smui-video")
    public WebElement sampleVideoWe;

    @FindBy(css = ".smui-drawer-sample")
    public WebElement sampleVideoTxtWe;

    @FindBy(css = ".span[class='glyphicon glyphicon-close-round margin-bottom-20']")
    public WebElement closeButtonWe;

    @FindBy(css = ".smui-change-course-lead")
    public WebElement videoBelowTxtWe;

    @FindBy(css = ".smui-drawer-showmore")
    public WebElement showMoreLinkWe;

    @FindBy(css = "div[class='smui-panel-message smui-panel-message-locked']")
    public List<WebElement>courseLockWe;

    @FindBy(css = ".smui-drawer-can-do ul li")
    public List<WebElement> levelPointsWe;

    @FindBy(css = ".smui-drawer-note td'")
    public List<WebElement> levelDetailsWe;

    //change to this course popup selectors

    @FindBy(css = ".btn-change-course")
    public WebElement changeCoursePopUpBtnWe;

    @FindBy(css = "button[class='btn btn-default btn-close-dialogue']")
    public WebElement changeCourseCancelPopUpBtnWe;

    @FindBy(css = "p[class='lead margin-bottom-30']")
    public WebElement changeCoursepopUptitleWe;

    @FindBy(css = "p[class='text-left margin-bottom-30']")
    public WebElement changeCoursepopUpContentWe;

    @FindBy(css = "a[class='fancybox-item fancybox-close']")
    public WebElement changeCoursepopUpCloseBtnWe;

    public ChangeCourseModulePage(WebDriver webDriver){
        super(webDriver);
    }

    public ChangeCourseModulePage(WebDriver webDriver, int waitSec){
        super(webDriver, waitSec);
    }


    @Override
    public boolean checkAllPageComponentsDisplayed() {
        checkAllPageComponentsDisplayed(changeToThisCourseBtnWe,levelNameWe,levelSubHeadingWe,sampleVideoWe,sampleVideoTxtWe,videoBelowTxtWe);
        return false;
    }

    public boolean simpleTest() {
        logger.info("check General English course is displayed...!");
        AssertHelper.assertWebElementDisplayed(changeToThisCourseBtnWe);
        return true;
    }


    public void clickChangeToThisCourseBtn(){
        logger.info("Click on the change to this course btn ");
        click(changeToThisCourseBtnWe);
    }

    public void checkLevelDetails(String length,String noOfLessons){
        logger.info("Checking the length ,no of lessons and certificate of the course");
        AssertHelper.assertStringContains(TestUtil.getWebElementText(levelDetailsWe.get(0)),length,"Length of the course is wrong");
        AssertHelper.assertStringContains(TestUtil.getWebElementText(levelDetailsWe.get(1)),length,"Number of lessons in the course is wrong");
       // AssertHelper.assertStringContains(TestUtil.getWebElementText(levelDetailsWe.get(3)),length,"Certificate status is wrong");
        AssertHelper.assertWebElementDisplayed(levelDetailsWe.get(2));
    }

    public void clickShowMoreLink(){
        logger.info("Click on clickShowMoreLink");
        clickOnElement(showMoreLinkWe);
    }


    //change to this course popup

    public void clickChangeCoursePopUpBtn(){
        logger.info("clickChangeCoursePopUpBtn");
        clickOnElement(changeCoursePopUpBtnWe);
    }

    public void clickChangeCourseCancelBtn(){
        logger.info("clickChangeCourseCancelBtn");
        clickOnElement(changeCourseCancelPopUpBtnWe);
    }

    public void closeChangeCoursePopUp(){
        logger.info("closeChangeCoursePopUp");
        clickOnElement(changeCoursepopUpCloseBtnWe);
    }

    public void assertChangeCoursePopUpElements(){

        checkAllPageComponentsDisplayed(changeCoursepopUptitleWe,changeCoursepopUpContentWe);

    }

    @Override
    public String getPageUrl() {
        return pageUrl;
    }


    public void clickOnElement(WebElement webElement){
        try {
            WebElementHelper.click(webElement);
            try { Thread.sleep(1000);  } catch (Exception e) {   }
            webElement.click();
        }catch (Exception e) {
            logger.error(" clickOnElement :"+TestUtil.getExceptionFirstLine(e));
        }
    }


}








