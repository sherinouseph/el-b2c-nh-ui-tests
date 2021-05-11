package com.englishtown.newhouse.school.pages.home.modules;
/**
 * Nikol Jan 2018
 *
 * My account submenu
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


public class MyAccountSubMenuPage extends BaseSchoolPage {

    public static final Logger logger = LoggerFactory.getLogger(MyAccountSubMenuPage.class);
    public static final String pageUrl = "/campus/mypage/home";
    // course menu
    public final String accountSettingsCss = ".ue-header-icons.ue-setting";
    public final String myProfileCss       = ".ue-header-icons.ue-profile";
    public final String referAFriendCss    = ".ue-header-icons.ue-refer";
    public final String logoutCss          = ".ue-header-icons.ue-logout";


    @FindBy(css = accountSettingsCss)
    public WebElement accountSettingMenuItemWe;

    @FindBy(css = myProfileCss)
    public WebElement myProfileMenuItemWe;

    @FindBy(css = referAFriendCss)
    public WebElement referAFriendMenuItemWe;

    @FindBy(css = logoutCss)
    public WebElement logoutMenuItemWe;


    public boolean simpleTest() {
        logger.info("simpleTest element displayed ...!");
        AssertHelper.assertWebElementDisplayed(accountSettingMenuItemWe);
        return true;
    }

    @Override
    public boolean checkAllPageComponentsDisplayed() {
        logger.info("checkAllPageComponents []...!");
        checkAllPageComponentsDisplayed(accountSettingMenuItemWe, myProfileMenuItemWe, referAFriendMenuItemWe, logoutMenuItemWe);
        return true;
    }

    public MyAccountSubMenuPage(WebDriver webDriver) {
        super(webDriver);
    }
    public MyAccountSubMenuPage(WebDriver webDriver, int waitTimeSec) {
        super(webDriver, waitTimeSec);
    }
    public MyAccountSubMenuPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }
    public MyAccountSubMenuPage() {
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