package com.englishtown.newhouse.school.pages.home.modules;
/**
 * Nikol Jan 2018
 *
 * Support Sub menu
 *
 *
 */

import com.englishtown.helpers.AssertHelper;
import com.englishtown.newhouse.school.pages.core.BaseSchoolPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SupportSubMenuPage extends BaseSchoolPage {

    public static final Logger logger = LoggerFactory.getLogger(SupportSubMenuPage.class);
    public static final String pageUrl = "/campus/mypage/home";
    // course menu
    public final String liveHelpCss   = ".ue-td[data-code='School.LiveHelp.2012'] a";
    public final String emailUsCss    = ".ue-td[data-code='School.ContactUs.2012'] a";
    public final String helpCenterCss = ".ue-td[data-code='School.Help.2012'] a";
    public final String newHouseSupportCss = "last-menu"; //.last-menu


    @FindBy(css = liveHelpCss)
    public WebElement liveHelpMenuItemWe;

    @FindBy(css = emailUsCss)
    public WebElement emailUsMenuItemWe;

    @FindBy(css = helpCenterCss)
    public WebElement helpCenterMenuItemWe;

    /**
     * New house support
     */
    @FindBy(className = newHouseSupportCss)
    public WebElement newHouseSupportWe;


    public boolean simpleTest() {
        logger.info("simpleTest element displayed ...!");
        // this is dif for new/old house AssertHelper.assertWebElementDisplayed(liveHelpMenuItemWe);
        return true;
    }

    @Override
    public boolean checkAllPageComponentsDisplayed() {
        logger.info("checkAllPageComponents []...!");
        checkAllPageComponentsDisplayed(liveHelpMenuItemWe, emailUsMenuItemWe, helpCenterMenuItemWe);
        return true;
    }

    public SupportSubMenuPage(WebDriver webDriver){
        super(webDriver);
    }
    public SupportSubMenuPage(WebDriver webDriver, int waitTimeSec) {
        super(webDriver, waitTimeSec);
    }
    public SupportSubMenuPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }
    public SupportSubMenuPage() {
        this(null, null);
    }
    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }


    @Override
    public String getPageUrl() {
        return pageUrl;
    }

}