package com.englishtown.newhouse.school.pages.home;
/**
 * Nikol Jan 2018
 *
 * Header for Home page * Once user logged in and completed enrolment school page is shown
 *
 *
 */

import com.englishtown.helpers.AssertHelper;
import com.englishtown.helpers.MyWebDriverAction;
import com.englishtown.helpers.WaitTool;
import com.englishtown.helpers.WaitToolConfig;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.newhouse.school.pages.core.BaseSchoolPage;
import com.englishtown.newhouse.school.pages.home.modules.ClassroomSubMenuPage;
import com.englishtown.newhouse.school.pages.home.modules.CourseSubMenuPage;
import com.englishtown.newhouse.school.pages.home.modules.MyAccountSubMenuPage;
import com.englishtown.newhouse.school.pages.home.modules.SupportSubMenuPage;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class SchoolHeaderPage extends BaseSchoolPage {

    public static final Logger logger = LoggerFactory.getLogger(SchoolHeaderPage.class);
    public static final String pageUrl = "/campus/mypage/home";

    public static final String courseMenuCss= "li[data-code='Main.Course.2012']";
    protected CourseSubMenuPage    courseSubMenuPage;
    protected ClassroomSubMenuPage classroomSubMenuPage;
    protected MyAccountSubMenuPage myAccountSubMenuPage;
    protected SupportSubMenuPage   supportSubMenuPage;

    /**
     * Includes all header section, menus, links/icons
     */
    @FindBy(className = "ue-header")
    public WebElement headerWe;

    @FindBy(className = "ue-logo")
    public WebElement logoWe;                       // a.ue-logo

    @FindBy(css = ".ue-menu-link")
    public List<WebElement> navigationMenuWeList;   // [Course, Classroom, [community ] support]   community will be removed

    //This is the course menu is selected when user logs in and not once move to other pages  data-code="Main.Home.2012"
    @FindBy(css = ".first-menu.ue-selected")
    public WebElement firstMenuSelectedWe;

    /**
     * Can get the below elements from the list as well
     *
     */ // Main.Course.2012 data-code="Main.Classroom.2012" ; data-code="Main.Community.2012"  data-code="Main.Support.2012"
    @FindBy(css = courseMenuCss)
    public WebElement courseMenuWe;

    @FindBy(css = "li[data-code='Main.Classroom.2012']")
    public WebElement classroomMenuWe;

    @FindBy(css = "li[data-code='Main.Friends.2018']")
    public WebElement friendsLinkWe;

    @FindBy(css = "li[data-code='Main.Support.2012']")
    public WebElement supportMenuWe;


    /**
     * email logo, messages
     * TODO: not sure if this shows a pop up with links
     */
    @FindBy(className = "ue-inbox")
    public WebElement messagesWe;

    /**
     * Alert logo, shows popup menu to go to classroom
     *  Todo ... add alert pop selection options
     */
    @FindBy(className = "pepper-alert-icon")
    public WebElement alertWe;


    @FindBy(className = "ue-avatar")
    public WebElement userMenuWe;

    @FindBy(css = ".ue-avatar img")
    public WebElement userAvatarImgWe;

    public SchoolHeaderPage(WebDriver webDriver){
        super(webDriver);
    }
    public SchoolHeaderPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }
    public SchoolHeaderPage(WebDriver webDriver, int pageLoadTime) {
        super(webDriver, pageLoadTime);
        supportSubMenuPage = new SupportSubMenuPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        supportSubMenuPage.getPageLoadedCondition();
        supportSubMenuPage.simpleTest();
    }
    public SchoolHeaderPage() {
        this(null, null);
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean simpleTest() {
        logger.info("simpleTest Assert Main Navigation and Course element displayed ...!");
        WaitTool.waitForElementVisible_fluentWait(getWebDriver(),courseMenuWe, WaitToolConfig.LONG_WAIT_4_ELEMENT,1000);
        return true;
    }

    @Override
    public boolean checkAllPageComponentsDisplayed() {
        logger.info("checkAllPageComponents [logo, menus and icons]...!");
        checkAllPageComponentsDisplayed(logoWe, courseMenuWe, classroomMenuWe,friendsLinkWe, supportMenuWe, messagesWe, alertWe, userMenuWe);

        return true;
    }

    /**
     * Once user login this menu should be selected
     * @return
     */
    public boolean isMainMenuSelected() {
        logger.info("isMainMenuSelected ...!");
        AssertHelper.assertWebElementDisplayed(firstMenuSelectedWe);
        return true;
    }

    public ExpectedCondition getPageLoadedCondition() {
        WaitTool.waitForElementClickable_fluentWait(getWebDriver(),courseMenuWe, WaitToolConfig.LONG_WAIT_4_ELEMENT,1000);
        //WaitTool.waitForElementVisible(getWebDriver(), By.cssSelector(courseMenuCss), WaitTool.LONG_WAIT_4_ELEMENT);
        return ExpectedConditions.visibilityOf(courseMenuWe);
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public WebElement getMainMenuWe(int index){
        return navigationMenuWeList.get(index);
    }


    /**
     * Course
     */
    public void goToCurrentCourse(){
        logger.info("goToCurrentCourse");
        expandCourseMenuAndSetCourseSubMenu();
        WaitTool.waitForElementClickable_fluentWait(getWebDriver(),courseSubMenuPage.currentCourseMenuItemWe, WaitToolConfig.LONG_WAIT_4_ELEMENT,1000);
        //WaitTool.waitForElementVisibleAndClickable(By.cssSelector(courseSubMenuPage.courseCurrentCourseCss), getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        //courseSubMenuPage.getPageLoadedCondition();
        click(courseSubMenuPage.currentCourseMenuItemWe);
    }

    public void goToFriends(){
        logger.info("goToFriends");
        click(friendsLinkWe);
    }


    public void goToProgressAndTests(){
        logger.info("goToProgressAndTests");
        expandCourseMenuAndSetCourseSubMenu();
        click(courseSubMenuPage.progressAndTestMenuItemWe);
    }

    public void goToChangeCourse(){
        logger.info("goToChangeCourse");
        expandCourseMenuAndSetCourseSubMenu();
        click(courseSubMenuPage.changeCourseMenuItemWe);
    }
    public void goToAppsAndTools(){
        logger.info("goToAppsAndTools");
        expandCourseMenuAndSetCourseSubMenu();
        click(courseSubMenuPage.appsAndToolMenuItemWe);
    }

    /**
     * Classroom
     */
    public void goToBookPrivateClass(){
        logger.info("goToBookPrivateClass");
        expandClassroomAndSetClassroomSubMenu();
        click(classroomSubMenuPage.bookPLeMenuItemWe);
    }

         // Conversation class
    public void goToBookGroupClass(){
        logger.info("goToBookGroupClass");
        expandClassroomAndSetClassroomSubMenu();
        click(classroomSubMenuPage.bookGLeMenuItemWe);
    }

    public void goToBookEFTV(){
        logger.info("goToBookPrivateClass");
        expandClassroomAndSetClassroomSubMenu();
        click(classroomSubMenuPage.bookEFTVeMenuItemWe);
    }

    public void goToCurrentBooking(){
        logger.info("goToCurrentBooking");
        expandClassroomAndSetClassroomSubMenu();
        click(classroomSubMenuPage.currentBookingsMenuItemWe);
    }

    /**
     * Support
     */
    public void goToNewHouseSupport(){
        logger.info("goToNewHouseSupport");
        click(supportSubMenuPage.newHouseSupportWe);
    }

    public void goToSupportLiveHelp(){
        logger.info("goToSupportLiveHelp");
        expandSupportAndSetSupportSubMenu();
        click(supportSubMenuPage.liveHelpMenuItemWe);
    }

    public void goToSupportEmailUs(){
        logger.info("goToSupportEmailUs");
        expandSupportAndSetSupportSubMenu();
        click(supportSubMenuPage.emailUsMenuItemWe);
    }

    public void goToSupportHelplCenter(){
        logger.info("goToSupportHelplCenter");
        expandSupportAndSetSupportSubMenu();
        click(supportSubMenuPage.helpCenterMenuItemWe);
    }

    /**
     * User Profile
     */
    public void goToMyAccountSetting(){
        logger.info("goToMyAccountSetting");
        expandMyAccountAndSetMyAccountSubMenu();
        click(myAccountSubMenuPage.accountSettingMenuItemWe);
        waitForAccountPageSpinnerDisappear(WaitTool.DEFAULT_IMPLICIT_WAIT);
    }
    // this is going to be removed
    /*public void goToMyAccountProfile(){
        logger.info("goToMyAccountProfile");
        expandMyAccountAndSetMyAccountSubMenu();
        click(myAccountSubMenuPage.myProfileMenuItemWe);
    }*/

    public void goToMyAccountReferFriend(){
        logger.info("goToMyProfileAccSetting");
        expandMyAccountAndSetMyAccountSubMenu();
        click(myAccountSubMenuPage.referAFriendMenuItemWe);
    }

    public void goToMyAccountAndLogout(){
        logger.info("goToMyAccountAndLogout");
        expandMyAccountAndSetMyAccountSubMenu();
        click(myAccountSubMenuPage.logoutMenuItemWe);
    }

    public void clickOnEFLogo(){
        logger.info("clickOnEFLogo");
        click(logoWe);
    }


    /**
     * Expand main menus and set sub menu helpers
     */
    // TODO try to reuse this with class params
    public void expandCourseMenuAndSetCourseSubMenu(){
        logger.info("expandCourseMenuAndSetCourseSubMenu");
        MyWebDriverAction.mouseOver(getWebDriver(), courseMenuWe);
        courseSubMenuPage = new CourseSubMenuPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        courseSubMenuPage.getPageLoadedCondition();
        courseSubMenuPage.simpleTest();
    }

    public void expandClassroomAndSetClassroomSubMenu( ){
        logger.info("expandClassroomAndSetClassroomSubMenu");
        MyWebDriverAction.mouseOver(getWebDriver(), classroomMenuWe);
        classroomSubMenuPage = new ClassroomSubMenuPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        classroomSubMenuPage.getPageLoadedCondition();
        classroomSubMenuPage.simpleTest();
    }

    public void expandSupportAndSetSupportSubMenu( ){
        logger.info("expandSupportAndSetSupportSubMenu");
        MyWebDriverAction.mouseOver(getWebDriver(), supportMenuWe);
        supportSubMenuPage = new SupportSubMenuPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        supportSubMenuPage.getPageLoadedCondition();
        supportSubMenuPage.simpleTest();
    }

    public void expandMyAccountAndSetMyAccountSubMenu( ){
        logger.info("expandMyAccountAndSetMyAccountSubMenu");
        MyWebDriverAction.mouseOver(getWebDriver(), userMenuWe);
        myAccountSubMenuPage = new MyAccountSubMenuPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        myAccountSubMenuPage.getPageLoadedCondition();
        myAccountSubMenuPage.simpleTest();
    }


    /**
     * get menu item based on menu text
     * @param menuNameTxt
     * @return
     */
    public WebElement getMainMenuWe(String menuNameTxt) {
        logger.info("Get menu WE for menu text [{}]", menuNameTxt);
        WebElement myMenuWe = null;

        for(WebElement we : navigationMenuWeList){
            if(StringUtils.containsIgnoreCase(TestUtil.getWebElementText(we), menuNameTxt) ){
                logger.info("Found menu text [{}]", menuNameTxt);
                myMenuWe = we;
            }
        }

        if(null == myMenuWe)
            failTest("Cant get Menu with text ["+ menuNameTxt +"]");

        return myMenuWe;
    }



}
