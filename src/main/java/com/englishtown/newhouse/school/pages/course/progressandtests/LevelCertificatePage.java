package com.englishtown.newhouse.school.pages.course.progressandtests;

//sherin - 09/02/2018
//
//Progress and test Page

import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.newhouse.school.pages.core.BaseSchoolPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LevelCertificatePage extends BaseSchoolPage {
    public static final Logger logger = LoggerFactory.getLogger(LevelCertificatePage.class);
    public static final String pageUrl = "school/certificate?key";


    @FindBy(className = "content_frame")    // main frame with all content
    public WebElement certificatePageContentWe;

    @FindBy(className = "top_frame")
    public WebElement certificateTitleWe;

    //certificate details
    @FindBy(className = "student-name")
    public WebElement studentNameWe;

    @FindBy(className = "course-name")
    public WebElement courseNamewe;

    @FindBy(className = "level-name")
    public WebElement levelNameWe;

    @FindBy(className = "cert-date")
    public WebElement certfiedDateWe;

    @FindBy(className = "print")
    public WebElement printBtnWe;


    public LevelCertificatePage(WebDriver webDriver){
        super(webDriver);
    }
    public LevelCertificatePage(WebDriver webDriver, int waitSec){
        super(webDriver, waitSec);
    }

    @Override
    public boolean checkAllPageComponentsDisplayed() {
        logger.info("Check all components are displayed in the level certificate page");
        checkAllPageComponentsDisplayed(certificateTitleWe,levelNameWe,printBtnWe,studentNameWe,courseNamewe,certfiedDateWe);
        return false;
    }

    public boolean simpleTest() {
        logger.info("check certificate title displayed and student name displayed...!");
        AssertHelper.assertWebElementDisplayed(studentNameWe);
        //AssertHelper.assertStringContains(TestUtil.getWebElementText(certificateTitleWe),"Certificate","title certificate incorrect");
        return true;
    }

    public void checkCertificateDetails(String courseName, String studentName,String levelName, String certifiedDate) {
        logger.info("checkCertificateDetails");
        AssertHelper.assertStringContains(TestUtil.getWebElementText(courseNamewe),courseName,"CourseName incorrect");
        AssertHelper.assertStringContains(TestUtil.getWebElementText(studentNameWe),studentName,"studentName incorrect");
        AssertHelper.assertStringContains(TestUtil.getWebElementText(levelNameWe),levelName,"levelName incorrect");
        AssertHelper.assertStringContains(TestUtil.getWebElementText(certfiedDateWe),certifiedDate,"certified date incorrect");

    }




    @Override
    public String getPageUrl(){
        return pageUrl;
    }


}











