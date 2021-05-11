package com.englishtown.newhouse.school.pages.course.currentcourse.unit;

//sherin - 05/02/2018
//
// Unit overview page object

import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.newhouse.school.pages.core.BaseSchoolPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.hamcrest.Matchers.equalToIgnoringCase;

public class UnitOverviewPage extends BaseSchoolPage {
    public static final Logger logger = LoggerFactory.getLogger(UnitOverviewPage.class);
    public static final String pageUrl = "/school/studyplan?icid=School.StudyPlan.2013#study/";


//set new goal page


    @FindBy(css = "a.ets-uo-export-link")
    public WebElement downloadBtnWe;

    @FindBy(css = ".ets-uo-title")
    public WebElement unitOverviewTitleWe;

    @FindBy(css = ".ets-uo-unit-info")
    public WebElement unitInfoWe;

    @FindBy(css = ".ets-uo-unit-no")
    public WebElement unitNumberWe;

    @FindBy(css = ".ets-uo-level-no")
    public WebElement levelNoWe;

    @FindBy(css = ".close")
    public List <WebElement> closeBtnWe;

    //table contents

    @FindBy(css = ".ets-uo-word-list-column-player")
    public List <WebElement> playBtnWe;

    @FindBy(css = ".ets-uo-word-list-column-vocabulary")
    public List <WebElement> vocabularyWe;

    @FindBy(css = ".ets-uo-word-list-column-phonetic")
    public List <WebElement> phoneticWe;

    @FindBy(css = ".ets-uo-word-list-column-partofspeech")
    public List <WebElement> partOfSpeechWe;

    @FindBy(css = ".ets-uo-word-list-column-translation")
    public List <WebElement> transalationWe;


    public UnitOverviewPage(WebDriver webDriver){
        super(webDriver);
    }

    public UnitOverviewPage(WebDriver webDriver, int waitSec){
        super(webDriver, waitSec);
    }


    @Override
    public boolean checkAllPageComponentsDisplayed() {
        checkAllPageComponentsDisplayed(unitInfoWe,unitOverviewTitleWe,unitNumberWe,levelNoWe,closeBtnWe.get(2));
        return false;
    }

    public boolean simpleTest() {
        logger.info("check download button  is displayed...!");
        WaitTool.waitForElementVisible_fluentWait(getWebDriver(),unitOverviewTitleWe,30,1000);
        AssertHelper.assertWebElementDisplayed(unitOverviewTitleWe);
        return true;

    }


    public void clickOnCloseButton(){
            logger.info("clickOnCloseButton");
            click(closeBtnWe,2);
    }

    public void clickOnDownloadBtn(){
        logger.info("clickOnDownloadBtn");
        click(downloadBtnWe);
    }

    public void checkUnitOverviewTable(){
       assertSizeofElementList(playBtnWe,15);
       assertSizeofElementList(vocabularyWe,15);

    }

    public void assertSizeofElementList(List WebElement,int noOfElements){
        AssertHelper.assertElementSizeMoreThanOrEqual(getWebDriver(),WebElement,noOfElements);
    }


    public void checkTableRowSize(){
        logger.info("Check the number of rows are greater than 15");
        assertSizeofElementList(vocabularyWe,15);
    }

    public String getUnitNumber(){
        logger.info("getUnitNumber");
        return TestUtil.getWebElementText(unitNumberWe);
    }

    public String getLevelNameAndNumber(){
        logger.info("getLevelName");
        return TestUtil.getWebElementText(levelNoWe);
    }

    public void checkUnitNumber(int unitNumber){
        AssertHelper.assertThat("Unit number incorrect",getUnitNumber(), equalToIgnoringCase(Integer.toString(unitNumber)));
        logger.info("unit number is correct" +getUnitNumber());
    }

    public void checkLevelNumber(int levelNumber){
        AssertHelper.assertStringContains(getLevelNameAndNumber(),Integer.toString(levelNumber),"Level number incorrect");
        logger.info("unit number is correct" +getLevelNameAndNumber());

    }

    @Override
    public String getPageUrl() {
        return pageUrl;
    }



}











