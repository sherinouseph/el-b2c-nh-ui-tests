package com.englishtown.newhouse.school.pages.home.modules;
/**
 * Nikol Jan 2018
 *
 * Classroom SubMenu
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


public class ClassroomSubMenuPage extends BaseSchoolPage {

    public static final Logger logger = LoggerFactory.getLogger(ClassroomSubMenuPage.class);
    public static final String pageUrl = "/campus/mypage/home";

    public final String classroomBookPLCss          = ".ue-td[data-code='School.BookPL.2012'] a";
    public final String classroomCurrentBookingCss  = ".ue-td[data-code='School.MyBookings.2012'] a";
    public final String classroomBookGLCss          = ".ue-td[data-code='School.GroupClass.2012'] a";
    public final String classroomBookEFTVCss        = ".ue-td[data-code='School.FluencyClass.2019'] a";


    /**
     * Course menu [Current Course, progress, change, apps&tools]
     */
    @FindBy(css = classroomBookPLCss)
    public WebElement bookPLeMenuItemWe;

    @FindBy(css = classroomCurrentBookingCss)
    public WebElement currentBookingsMenuItemWe;

    @FindBy(css = classroomBookEFTVCss)
    public WebElement bookEFTVeMenuItemWe;

    @FindBy(css = classroomBookGLCss)
    public WebElement bookGLeMenuItemWe;


    public boolean simpleTest() {
        logger.info("simpleTest element displayed ...!");
        AssertHelper.assertWebElementDisplayed(bookPLeMenuItemWe);
        return true;
    }

    @Override
    public boolean checkAllPageComponentsDisplayed() {
        logger.info("checkAllPageComponents []...!");
        checkAllPageComponentsDisplayed(bookPLeMenuItemWe, currentBookingsMenuItemWe, bookGLeMenuItemWe);
        return true;
    }

    public ClassroomSubMenuPage(WebDriver webDriver){
        super(webDriver);
    }
    public ClassroomSubMenuPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }
    public ClassroomSubMenuPage(WebDriver webDriver, int waitTimeSec) {
        super(webDriver, waitTimeSec);
    }
    public ClassroomSubMenuPage() {
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