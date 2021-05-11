//package com.englishtown.pages.component;
///**
// * Tech check test voice and video component
// * build by china team
// *
// * Note: Need to switch to iframe
// */
//
//import com.englishtown.helpers.AssertHelper;
//import com.englishtown.helpers.WaitTool;
//import com.englishtown.helpers.WebElementHelper;
//import com.englishtown.helpers.utils.TestUtil;
//import com.englishtown.pages.core.BasePage;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebDriverException;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.ui.ExpectedCondition;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.util.List;
//
//
//public class TechCheckComponentPage extends BasePage {
//    public static final Logger logger = LoggerFactory.getLogger(TechCheckComponentPage.class);
//    public WebElement currWebElement;
//
//
//    @FindBy(css = ".tck-ui-nav-module.tck-ui-nav-active")
//    public WebElement techCheckNavActiveStep1;
//
//    @FindBy(css = ".tck-ui-flash-setting-holder")
//    public WebElement flashTestHolder;
//
//    @FindBy(css = ".tck-ui-ft-cancel")
//    public WebElement cancelBtn;
//
//
//    public TechCheckComponentPage(WebDriver webDriver){
//        super(webDriver);
//    }
//    public TechCheckComponentPage(WebDriver webDriver, String url) {
//        super(webDriver, url);
//    }
//    public TechCheckComponentPage() {
//        this(null, null);
//    }
//    public void setWebDriver(WebDriver webDriver) {
//        this.webDriver = webDriver;
//    }
//
//    public boolean simpleTest() {
//        boolean isTestPassed = false;
//        logger.info("Running simpleTest() ...!");
//        if(flashTestHolder != null){
//            try {
//                isTestPassed = flashTestHolder.isDisplayed();
//            }catch (WebDriverException e){
//                BasePage.failTest(e, "FAIL simpleTest ...! nextStep element is not displayed", true);
//            }
//        } else {
//            BasePage.failTest("FAIL simpleTest ...! nextStep element not found or is not displayed", true);
//            return false;
//        }
//        return isTestPassed;
//    }
//
//    public void mainComponentTest() {
//        logger.info("Running mainComponentTest() Navbar, flash holder, Cancel button ...!");
//        AssertHelper.assertWebElementDisplayed(techCheckNavActiveStep1);
//        logger.info(" before assert time :"+System.currentTimeMillis());
//        AssertHelper.assertWebElementDisplayed(cancelBtn);
//        logger.info(" after assert time :"+System.currentTimeMillis());
//        AssertHelper.assertWebElementDisplayed(flashTestHolder);
//        /*AssertHelper.assertThat("Tech check Navigater active step is not displayed ...!", techCheckNavActiveStep1.isDisplayed() );
//        AssertHelper.assertThat("Tech check Cancel button not displayed ...!",           cancelBtn.isDisplayed());
//        AssertHelper.assertThat("Tech check flashTestHolder is not displayed ...!",       flashTestHolder.isDisplayed() );*/
//    }
//
//
//    @Override
//    public ExpectedCondition getPageLoadedCondition() {
//        return ExpectedConditions.visibilityOf(flashTestHolder);
//    }
//
//
//
//}
