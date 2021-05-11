package com.englishtown.newhouse.school.pages.course.changecourse;

//sherin - 19/02/2018
//
// Toefl Course

import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.JavaScriptHelper;
import com.englishtown.newhouse.school.pages.core.BaseSchoolPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ToeflToeicPage extends BaseSchoolPage {
    public static final Logger logger = LoggerFactory.getLogger(ToeflToeicPage.class);
    public static final String pageUrl = "studytools/TofelToeic/ToeicTofelContainer.aspx?visitType=tofel"; //"";

    public static final String TOEIC_TRAINER = "a[href*='www.testden.com/scripts/validate-etownIBT.asp?resource=IBTOEICTRAIN1&username=tAutoLastName91178&firstname=testing&lastname=AutoLastName&email=auto_toefltoeic@qp1.org&lng=en&Version=V2']";
    //todo update to new house
    // public String iframeName = "mainframe";   // name


   //@FindBy(css = ".toe-banner h1")
   // public WebElement titleWe;
   // @FindBy(css = ".toe-banner h3")
   // public WebElement subtitleWe;

   // @FindBy(css = ".toe-header h1")
   // public WebElement headerWe;
/*
    @FindBy(css = ".toe-trainer-box .toe-link-list a")
    public List<WebElement> trainerCoursesWe;

    @FindBy(css = ".toe-test-box .toe-link-list a")
    public List<WebElement> testCoursesWe;

    @FindBy(css = ".toe-gray-box a")
    public WebElement faqLinkWe;*/

// new house
// https://www.testden.com/scripts/validate-etownIBTbeta.asp?resource=IBTTRAIN1&username=testingAutoLastName&firstname=testing&lastname=AutoLastName&email=auto_accountcontent%40qp1.org&lng=en&Version=V2
    // take a practice https://www.testden.com/scripts/validate-etownIBTbeta.asp?resource=IBT1&username=testingAutoLastName&firstname=testing&lastname=AutoLastName&email=auto_accountcontent%40qp1.org&lng=en&Version=V2

    @FindBy(css="#ctl01_ctl00_main_Content_mainframe")
    public WebElement iframeToefl;

    @FindBy(css ="a[href*='https://www.testden.com/scripts/validate-etownIBT.asp?resource=IBTTRAIN1&username=tAutoLastName91178&firstname=testing&lastname=AutoLastName&email=auto_toefltoeic@qp1.org&lng=en&Version=V2']")
    public WebElement toeflSpeckWriteWe;

    @FindBy(css = "a[href*='https://www.testden.com/scripts/validate-etownIBT.asp?resource=IBT1&username=tAutoLastName91178&firstname=testing&lastname=AutoLastName&email=auto_toefltoeic@qp1.org&lng=en&Version=V2']")
    public WebElement toeflTest1We;

    //toeic
    @FindBy(css = TOEIC_TRAINER)
    public WebElement toeicTrainerWe;


    public ToeflToeicPage(WebDriver webDriver) {
        super(webDriver);
    }

    public ToeflToeicPage(WebDriver webDriver, int waitSec) {
        super(webDriver, waitSec);
    }


    @Override
    public boolean checkAllPageComponentsDisplayed() {
        return checkAllPageComponentsDisplayed(toeflSpeckWriteWe, toeflTest1We);
    }

    public void moveToIframe(){
        getWebDriver().switchTo().frame(iframeToefl);
    }
    public boolean simpleTest() {
        logger.info("check General English course is displayed...!");
        AssertHelper.assertWebElementDisplayed(toeflTest1We);
        return true;
    }

    public ExpectedCondition getPageLoadedCondition() {
        return ExpectedConditions.visibilityOfElementLocated(By.name("remplaceme"));//iframeName));
    }

    /*public void clickOnEachPractiseTest() {
        logger.info("clickOnEachPractiseTest");
        int i = 0;
        while (i <= 3) {
            click(testCoursesWe.get(i));
            AssertHelper.assertUrlContains(TestUtil.getCurrentUrl(getWebDriver()), "ToeicTofelContainer.aspx?visitType=tofel", "url incorrect");
            getWebDriver().navigate().back();
        }
    }*/


    @Override
    public String getPageUrl() {
        return pageUrl;
    }


}








