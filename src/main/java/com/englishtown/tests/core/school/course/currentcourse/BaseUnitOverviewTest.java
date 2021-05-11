package com.englishtown.tests.core.school.course.currentcourse;
/**
 * Unit overview
 * Sherin - 07/02/2018
 * click on unit overview
 * check the current level and unit number
 * go to next unit and click on unit overview
 * check if unit number has changed
 * close the unit overview window
 *
 *
 */


import com.englishtown.helpers.WaitTool;
import com.englishtown.newhouse.school.pages.course.currentcourse.unit.CurrentCourseUnitPage;
import com.englishtown.newhouse.school.pages.course.currentcourse.unit.UnitOverviewPage;
import com.englishtown.tests.core.school.BaseSimpleLogin;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.io.File;

public abstract class BaseUnitOverviewTest extends BaseSimpleLogin {
    private static final Logger logger = LoggerFactory.getLogger(BaseUnitOverviewTest.class);

    @Test(dependsOnMethods = "checkUserIsAtSchoolHomePage")
    protected void clickOnCurrentCourseMenu() {
        logger.info("clickOnCurrentCourseMenu and check if main components are displayed");
        initSchoolHeaderAndFooter();
        schoolHeaderAndFooterPage.schoolHeaderPage.goToCurrentCourse();
        currentCourseUnitPage = new CurrentCourseUnitPage(getWebDriver(),WaitTool.MED_WAIT_4_ELEMENT);
        currentCourseUnitPage.getPageLoadedCondition();
        currentCourseUnitPage.simpleTest();
    }


    @Test(dependsOnMethods = "clickOnCurrentCourseMenu")
    protected void clickOnUnitOverview(){
        logger.info("clickOnUnitOverview");
        //sleep(10000);
        WaitTool.waitForCondition( ExpectedConditions.elementToBeClickable(currentCourseUnitPage.startBtnWe.get(0)),
                getWebDriver(), WaitTool.LONG_WAIT_4_ELEMENT);
        click(currentCourseUnitPage.unitOverviewLinkWe);
        unitOverviewPage = new UnitOverviewPage(getWebDriver(),WaitTool.LONG_WAIT_4_ELEMENT);
        /*waitForElementCondition(ExpectedConditions.visibilityOf(unitOverviewPage.downloadBtnWe),
                getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);*/
        unitOverviewPage.simpleTest();
    }

    @Test(dependsOnMethods = "clickOnUnitOverview")
    protected void checkAllComponents(){
        logger.info("checkAllComponents");
        unitOverviewPage.checkAllPageComponentsDisplayed();
    }

    @Test(dependsOnMethods = "checkAllComponents")
    protected void checkCurrentUnitAndLevelNumber(){
        logger.info("checkCurrentUnitNumber");
        unitOverviewPage.checkUnitNumber(schoolStudentBean.getUnitNumber());
        logger.info("check CurrentLevel Number only if the course code is GE");
        if(courseCodeNumber.getCourseCode()=="GE")
            unitOverviewPage.checkLevelNumber(schoolStudentBean.getLevelNumber());
    }


    //    2019 Jan .. we removing download btn so remove test
    @Test(dependsOnMethods = "checkCurrentUnitAndLevelNumber")
    protected void clickOnDownloadButtonAndCloseWindow(){
        logger.info("clickOnDownloadButtonAndCloseWindow");
        //unitOverviewPage.clickOnDownloadBtn();
        /*AssertHelper.assertElementSizeMoreThanOrEqual(getWebDriver(),
                WaitTool.waitForListElementsPresent(getWebDriver(),
                        By.cssSelector("form[action='/school/StudyTools/downloads/PDF/Export']"),
                        10),1);*/
        unitOverviewPage.clickOnCloseButton();
        /*waitForElementCondition(ExpectedConditions.invisibilityOf(unitOverviewPage.downloadBtnWe),
                getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);*/
        logger.info("Unit overview window closed successfully");
    }

    @Test(dependsOnMethods = "clickOnDownloadButtonAndCloseWindow")
    protected void goToNextUnit() {
        logger.info("goToNextUnit");
        currentCourseUnitPage = new CurrentCourseUnitPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        currentCourseUnitPage.clickOnNextUnitArrow(schoolStudentBean.getUnitNumber());
        currentCourseUnitPage = new CurrentCourseUnitPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        waitForElementCondition(ExpectedConditions.visibilityOf(currentCourseUnitPage.unitLockWe),
                getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        logger.info("successfully navigated to next unit");
    }


    @Test(dependsOnMethods = "goToNextUnit")
    protected void clickOnUnitOverviewLink() {
        logger.info("clickOnUnitOverviewLink");
        click(currentCourseUnitPage.unitOverviewLinkWe);
        unitOverviewPage = new UnitOverviewPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        unitOverviewPage.simpleTest();
    }
    @Test(dependsOnMethods = "clickOnUnitOverviewLink")
    protected void checkCurrentUnitNumberAndClose() {
        logger.info("checkCurrentUnitNumberAndClose");
        int currentUnitNumber=schoolStudentBean.getUnitNumber()+1;//unit number changed when we clicked on next arrow
        unitOverviewPage.checkUnitNumber(currentUnitNumber);
        logger.info("click on close");
        unitOverviewPage.clickOnCloseButton();

    }

    //methods to check if the file is downloaded successfully to the machine using chrome browser
    public boolean isFileDownloaded(String downloadPath, String fileName) {
        boolean flag = false;
        File dir = new File(downloadPath);
        File[] dir_contents = dir.listFiles();

        for (int i = 0; i < dir_contents.length; i++) {
            if (dir_contents[i].getName().contains(fileName)) {
                logger.info("file name is "+dir_contents[i].getName());
                return flag = true;
            }
        }

        return flag;
    }

    private boolean isFileDownloaded_Ext(String dirPath, String ext){
        boolean flag=false;
        File dir = new File(dirPath);
        File[] files = dir.listFiles();
        if (files == null || files.length == 0) {
            flag = false;
        }

        for (int i = 1; i < files.length; i++) {
            if(files[i].getName().contains(ext)) {
                flag=true;
            }
        }
        return flag;
    }



}
