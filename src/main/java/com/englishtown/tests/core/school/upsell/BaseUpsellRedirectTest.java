package com.englishtown.tests.core.school.upsell;
/**
 *
 * User: nikol.marku
 * Date: 13/05/19
 *
 * Go to homepage for a user that has no PLs or GLs - Click on links and check upsell page and url for that market
 *
 *  ON PL section - Click book now shows upsell page for the user market - click back link - home page shown
 *  Click on  Classroom menu and select book PL -> shows upsell page for the user market - click back link - home page shown
 *  Click on  Classroom menu and select my booking -> Click book a lesson -> shows upsell page for the user market - click back link - home page shown
 *
 *  // Not implemented as not reliable
 *  ON GL section - Click learn more(shown only if available GlS)   - shows upsell page
 *  ON Course page Click PL ???
 *
 *
 *
 *
 */
import com.englishtown.helpers.WaitTool;
import com.englishtown.newhouse.school.pages.classroom.CurrentBookingsPage;
import com.englishtown.newhouse.school.pages.home.SchoolHomePage;
import com.englishtown.newhouse.school.pages.upsell.SchoolUpsellPage;
import com.englishtown.tests.core.school.BaseSchoolHomePageTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public abstract class BaseUpsellRedirectTest extends BaseSchoolHomePageTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseUpsellRedirectTest.class);

    protected String upsellUrl = "";



    @Test(dependsOnMethods = "checkMyPage")
    protected void clickPLbuyNowCheckUpsellPageUrl() {
        waitForElementVisibleAndClick(getWebDriver(), schoolHomePage.bookClassNowBtnWe, WaitTool.MED_WAIT_4_ELEMENT );
    }

    @Test(dependsOnMethods = "clickPLbuyNowCheckUpsellPageUrl")
    protected void checkUpsellPageContent_ClickBackButton() {
        checkUpsellPageSimpleTest();
        waitForElementVisibleAndClick(getWebDriver(), schoolUpsellPage.returnToMyAccountLinkWe, WaitTool.MED_WAIT_4_ELEMENT);
    }

    @Test(dependsOnMethods = "checkUpsellPageContent_ClickBackButton")
    protected void checkHomePageTest() {
        checkHomePage();
    }

    @Test(dependsOnMethods = "checkHomePageTest")
    protected void goToClassroomBookPlMenuItemCheckUpsell() {
        initSchoolHeaderAndFooter();
        schoolHeaderAndFooterPage.schoolHeaderPage.goToBookPrivateClass();
        sleep(3000);
        checkUpsellPageSimpleTest();
    }

    @Test(dependsOnMethods = "goToClassroomBookPlMenuItemCheckUpsell")
    public void clickBackButtonCheckHomePage(){
        waitForElementVisibleAndClick(getWebDriver(), schoolUpsellPage.returnToMyAccountLinkWe, WaitTool.MED_WAIT_4_ELEMENT);
        checkHomePage();
    }

    @Test(dependsOnMethods = "clickBackButtonCheckHomePage")
    protected void goToClassroomMyBooking_ClickBook_Check_Upsell() {
        initSchoolHeaderAndFooter();
        schoolHeaderAndFooterPage.schoolHeaderPage.goToCurrentBooking();
        sleep(3000);
        currentBookingsPage = new CurrentBookingsPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        currentBookingsPage.getPageLoadedCondition();
        currentBookingsPage.simpleTest();
        waitForElementCondition(ExpectedConditions.elementToBeClickable(By.cssSelector(currentBookingsPage.bookALessonCss)),
                getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT );
        click(currentBookingsPage.bookALessonWe);

        checkUpsellPageSimpleTest();
    }

    @Test(dependsOnMethods = "goToClassroomMyBooking_ClickBook_Check_Upsell")
    public void clickBackButtonFromMyBookingCheckHomePage(){
        waitForElementVisibleAndClick(getWebDriver(), schoolUpsellPage.returnToMyAccountLinkWe, WaitTool.MED_WAIT_4_ELEMENT);
        sleep(3000);
        checkHomePage();
    }


    public void checkUpsellPageSimpleTest(){
        checkUpsellUrlForMarket();
        schoolUpsellPage = new SchoolUpsellPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        schoolUpsellPage.waitForSpinnerDisappear();
        schoolUpsellPage.getPageLoadedCondition();
        schoolUpsellPage.simpleTest();
    }

    public void checkHomePage(){
        schoolHomePage = new SchoolHomePage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT25);
        schoolHomePage.getPageLoadedCondition();
        schoolHomePage.simpleTest();
    }

    public void checkUpsellUrlForMarket(){
        waitForUrlContains(getWebDriver(), upsellUrl, WaitTool.MED_WAIT_4_ELEMENT);
        assertIsUrlContaining(upsellUrl);
    }

}



/*
 protected void goToCoursePageClickGLIcon() {
        currentCourseUnitPage = new CurrentCourseUnitPage(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
        openPageUrl(currentCourseUnitPage);
        sleep(3000);
        currentCourseUnitPage.getPageLoadedCondition();
        currentCourseUnitPage.getPageLoadedCondition();
        currentCourseUnitPage.simpleTest();
        // iconList 3d is GL
        int glId = 2;
        // this flow is not stable sometime there are 2 click to get to add more and sometime 1
        String lessonIconListsCss = ".ets-sp-sqn-main li"; // 1
        String groupLessonGetStartedCss = ".evc-studyplan-wrapper button";
        String buyMoreCss = ".evc-studyplan-coupon-buymore";

        WaitTool.waitForListElementsDisplayed(getWebDriver(), By.cssSelector(lessonIconListsCss), 35);
        click(findElements(By.cssSelector(lessonIconListsCss)).get(glId));
        click(findElement(By.cssSelector(buyMoreCss)));
    }
 */