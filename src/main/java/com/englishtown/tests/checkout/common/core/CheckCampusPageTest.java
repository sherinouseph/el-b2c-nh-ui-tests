package com.englishtown.tests.checkout.common.core;
/**
 * 1. Click Start learning
 * 2. Check Enrolment page (URL should contain 'enrollment')
 *
 */

import com.englishtown.helpers.WaitTool;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public abstract class CheckCampusPageTest extends CheckEnrolmentTest{
    private static final Logger logger = LoggerFactory.getLogger(CheckCampusPageTest.class);
    protected String campusUrlContains = "campus";
    protected String campusWeCss       = "a.btn-primary";

//    @Test(dependsOnMethods = { "checkEnrolmentPage" })
//    public void enrolStudentToSchool(){
//        assertIsUrlContaining("enrollment/b2c/entrance#1");
//        enrolStudentCheckAtSchool();
//    }

    @Test(dependsOnMethods = { "enrolStudentToSchool" })
    public void checkAtCampusPage() {
       // waitForElementCondition(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn.btn-primary")), getWebDriver(), 30);
        assertIsUrlContaining(campusUrlContains);
       // waitForElementCondition(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(campusWeCss)), getWebDriver(), 30);
    }


//    protected void clickSavebtnInTimeZonePopUp(){
//        //TODO Why do we see the timezone ... need to find some more info on this?
//        logger.info("clickSavebtnInTimeZonePopUp  ...!");
//        waitForElementCondition(ExpectedConditions.elementToBeClickable(By.className("timezone-management-form-submit")),
//                getWebDriver(), WaitTool.SHORT_WAIT_4_ELEMENT);
//        click(findElement(By.className("timezone-management-form-submit")));
//        sleep(1000);
//    }







}