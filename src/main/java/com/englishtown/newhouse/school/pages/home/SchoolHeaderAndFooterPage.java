package com.englishtown.newhouse.school.pages.home;
/**
 * Nikol Jan 2018
 *
 * composite page with Header and Footer pages
 *
 *
 */

import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WaitToolConfig;
import com.englishtown.newhouse.school.pages.core.BaseSchoolPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.englishtown.newhouse.school.pages.home.SchoolHeaderPage.courseMenuCss;


public class SchoolHeaderAndFooterPage extends BaseSchoolPage {

    public static final Logger logger = LoggerFactory.getLogger(SchoolHeaderAndFooterPage.class);
    public static final String pageUrl = "/campus/mypage/home";

    public SchoolHeaderPage schoolHeaderPage;
    public SchoolFooterPage schoolFooterPage;

    public SchoolHeaderAndFooterPage(WebDriver webDriver){
        super(webDriver);
    }
    public SchoolHeaderAndFooterPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }
    public SchoolHeaderAndFooterPage(WebDriver webDriver, int pageLoadTime) {
        super(webDriver, pageLoadTime);
        initializeHeader();
        initializeFooter();
    }
    public SchoolHeaderAndFooterPage() {
        this(null, null);
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean simpleTest() {
        logger.info("simpleTest ...!");
        WaitTool.waitForElementClickable_fluentWait(getWebDriver(),schoolHeaderPage.courseMenuWe, WaitToolConfig.LONG_WAIT_4_ELEMENT,1000);
//        schoolHeaderPage = new SchoolHeaderPage(getWebDriver());
//        schoolFooterPage = new SchoolFooterPage(getWebDriver());
//        schoolHeaderPage.simpleTest();
//        schoolFooterPage.simpleTest();
        return true;
    }


    public boolean initializeHeader() {
        logger.info("initializeHeader ...!");
        schoolHeaderPage = new SchoolHeaderPage(getWebDriver(),  WaitTool.MED_WAIT_4_ELEMENT25);
        schoolHeaderPage.getPageLoadedCondition();
        //schoolHeaderPage.simpleTest();
        return true;
    }

    public boolean initializeFooter() {
        logger.info("ini ...!");
        schoolFooterPage = new SchoolFooterPage(getWebDriver());
        schoolFooterPage.getPageLoadedCondition();
        //schoolFooterPage.simpleTest();
        return true;
    }


    @Override
    public boolean checkAllPageComponentsDisplayed() {
        //todo
        return true;
    }

    public ExpectedCondition getPageLoadedCondition() {
        WaitTool.waitForElementClickable_fluentWait(getWebDriver(),schoolHeaderPage.courseMenuWe, WaitToolConfig.LONG_WAIT_4_ELEMENT,1000);
        return ExpectedConditions.visibilityOf(schoolHeaderPage.courseMenuWe);
    }

    public String getPageUrl() {
        return pageUrl;
    }




}
