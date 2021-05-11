package com.englishtown.newhouse.school.pages.support.newhouse;
/**
 * Nikol Jul 2018
 * New house
 * https://englishlive.ef.com/1/support/
 *
 * Contains :
 * 1. Help
 * 2. Email us
 *
 */

import com.englishtown.enumpack.ClassTopic;
import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WebElementHelper;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.newhouse.school.pages.classroom.modules.BookPlSummaryModule;
import com.englishtown.newhouse.school.pages.classroom.modules.SelectTimeModule;
import com.englishtown.newhouse.school.pages.classroom.modules.TopicCardModule;
import com.englishtown.newhouse.school.pages.core.BaseSchoolPage;
import com.englishtown.newhouse.school.pages.support.newhouse.component.EmailPage;
import com.englishtown.newhouse.school.pages.support.newhouse.component.HelpPage;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class SupportPage extends BaseSchoolPage {
    public static final Logger logger = LoggerFactory.getLogger(SupportPage.class);
    public static final String pageUrl = "/1/support/";

    public HelpPage helpPage;
    public EmailPage emailPage;


    public SupportPage(WebDriver webDriver, int waitSec){
        super(webDriver, waitSec);
        initHelpAndEmailPages();
    }
    //public SupportPage(WebDriver webDriver){        super(webDriver);    }
    //public SupportPage(WebDriver webDriver, String url) {        super(webDriver, url);    }
    //public SupportPage() {        this(null, null);    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }


    public boolean simpleTest() {
        logger.info(" simpleTest ...!");
        helpPage.simpleTest();
        emailPage.simpleTest();
        return true;
    }
    @Override
    public boolean checkAllPageComponentsDisplayed() {
        logger.info("checkAllPageComponents...!");
        helpPage.checkAllPageComponentsDisplayed();
        //emailPage.checkAllPageComponentsDisplayed();

        return true;
    }


    public ExpectedCondition getPageLoadedCondition() {
        return helpPage.getPageLoadedCondition();
    }



    public void initHelpAndEmailPages(){
        helpPage  = new HelpPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        emailPage = new EmailPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
    }


    public String getPageUrl() {
        return pageUrl;
    }

}
