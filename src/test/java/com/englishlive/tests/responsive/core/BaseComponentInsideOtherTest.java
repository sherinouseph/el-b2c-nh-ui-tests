package com.englishlive.tests.responsive.core;
/**
 * Created by nikol.marku on 1/12/2017.
 * https://jira-bos.englishtown.com/browse/SAND-3367
 * US : add test for boundary screen size Desktop to mobile/tab view [1226]
 # Date : Jan 2017
 # URL : https://englishlive.ef.com/en-us/free-consultation/
 # 1. open URL and check submit button is visible
 # 2. resize window to the boundary value 1366 width and check button is visible
 # 3. resize window to the boundary value 1368? width and check button is visible -- as it disappeared sometime
 # var BREAK_4_TABLET = 1366;
 # var BREAK_4_MOBILE = 1226;

 NOTE: checking button is not going to works for this as it could be behind a layer and have properties set to visible
 so need to check the formset element is inside the ilustrator container
 var $constraint = $('section.illustrator').eq(0).find('> .constraint');
 var $formset = $constraint.find('.formset');
 var result = $constraint.offset().top + $constraint.outerHeight(false) >= $formset.offset().top + $formset.outerHeight(true)
 result

 *
 */
import com.englishtown.dataprovider.ScreenSizeDataProvider;
import com.englishtown.helpers.WebDriverWindowHelper;
import com.englishtown.pages.common.FreeConsultationPage;
import com.englishtown.pages.core.BasePage;
import com.englishtown.pages.core.MyBasePage;
import com.englishtown.tests.core.BaseTestHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public abstract class BaseComponentInsideOtherTest extends BaseTestHelper{
    private static final Logger logger = LoggerFactory.getLogger(BaseComponentInsideOtherTest.class);

    protected FreeConsultationPage freeConsultationPage;


    @Test (dataProvider = "screenSizeDataProvider", dataProviderClass = ScreenSizeDataProvider.class)
    void isForm_Inside_illustratorDifScreenWidth(Dimension screenDimension) {
        WebDriverWindowHelper.resizeBrowserWindow(getWebDriver(),screenDimension);
        sleep(2000);
        checkFormInsideIllustratorSection();
    }


    protected void checkFormInsideIllustratorSection(){
        freeConsultationPage = new FreeConsultationPage(getWebDriver());
        freeConsultationPage.setupDimension();
        freeConsultationPage.isFormInsideIllustratorSection();
    }

}


/**
 *
 @Test
 void isForm_Inside_illustratorFullScreen() {
 checkFormInsideIllustratorSection();
 }

 @Test
 void isForm_Inside_illustratorWidth2366() {
 WebDriverWindowHelper.resizeBrowserWindow(getWebDriver(),2366, 2066);
 sleep(3000);
 checkFormInsideIllustratorSection();
 }

 @Test
 void isForm_Inside_illustratorWidth1240() {
 WebDriverWindowHelper.resizeBrowserWindow(getWebDriver(),1240, 1066);
 sleep(3000);
 checkFormInsideIllustratorSection();
 }

 @Test
 void isForm_Inside_illustratorWidth1366() {
 WebDriverWindowHelper.resizeBrowserWindow(getWebDriver(), 1366, 1066);
 sleep(3000);
 checkFormInsideIllustratorSection();
 }

 @Test
 void isForm_Inside_illustratorWidth1226() {
 WebDriverWindowHelper.resizeBrowserWindow(getWebDriver(),1226, 1066);
 sleep(3000);
 checkFormInsideIllustratorSection();
 }

 @Test
 void isForm_Inside_illustratorWidth1270() {
 WebDriverWindowHelper.resizeBrowserWindow(getWebDriver(),1270, 1066);
 sleep(3000);
 checkFormInsideIllustratorSection();
 }

 @Test
 void isForm_Inside_illustratorWidth750() {
 WebDriverWindowHelper.resizeBrowserWindow(getWebDriver(),750, 966);
 sleep(3000);
 checkFormInsideIllustratorSection();
 }

 @Test
 void isForm_Inside_illustratorWidth450() {
 WebDriverWindowHelper.resizeBrowserWindow(getWebDriver(),450, 866);
 sleep(3000);
 checkFormInsideIllustratorSection();
 }


 @Test(priority = 20)  // run this last .. should fail at the moment
 void isForm_Inside_illustratorWidth1245() {
 WebDriverWindowHelper.resizeBrowserWindow(getWebDriver(),1245, 1066);
 sleep(3000);
 checkFormInsideIllustratorSection();
 }
 *
 *
 By weBySelector =  By.cssSelector(webElementCss);
 WebDriverWindowHelper.resizeBrowserWindow(getWebDriver(),1217, 1066);
 sleep(3000);
 By weBySelector =  By.cssSelector(webElementCss);
 WebElement we = WaitTool.safeFindDisplayedAndEnabled(getWebDriver(), weBySelector, 10 ) ;// findElement(By.cssSelector(webElementCss));
 *
 *
 */
//(dependsOnMethods = {""})
// if (we == null) {
//         BasePage.failTest("Element is not shown and should be ...!" + weBySelector);
//         }

