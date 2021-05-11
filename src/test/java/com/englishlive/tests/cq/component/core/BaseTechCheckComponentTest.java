//package com.englishlive.tests.cq.component.core;
///**
// * Created by nikol.marku on 31/05/2016.
// *
// * TC-121:Launch Tech Check Component , check content NavBar, flash holder, cancel button
// *
// */
//import com.englishtown.pages.component.TechCheckComponentPage;
//import com.englishtown.tests.core.BaseTestHelper;
//import org.openqa.selenium.By;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.testng.annotations.Test;
//
//
//public abstract class BaseTechCheckComponentTest extends BaseTestHelper {
//    private static final Logger logger = LoggerFactory.getLogger(BaseTechCheckComponentTest.class);
//    protected String launchTechCheckBtnCss = ".btn.btn-default";
//
//    protected TechCheckComponentPage techCheckComponentPage;
//    protected String frameId =  "fr_fr_lp_oe_tech-check-example_jcr-content_footerPar_tech-check-4a18";
//
//    @Test
//    void validateTechCheckComponentsShown(){
//        logger.info("validateTechCheckComponentsShown  ...!");
//        waitForElementCondition(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id(frameId)), getWebDriver(), 15);
//        techCheckComponentPage = new TechCheckComponentPage(getWebDriver());
//        techCheckComponentPage.mainComponentTest();
//    }
//
//}
