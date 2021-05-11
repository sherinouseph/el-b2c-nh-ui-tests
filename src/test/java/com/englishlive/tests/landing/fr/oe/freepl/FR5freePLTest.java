//package com.englishlive.tests.landing.fr.oe.freepl;
///**
// *
// *  https://englishlive.ef.com/fr-fr/lp/oe/ef-home-anglais-cours-d-essai/
// *
// */
//
//import com.englishtown.tests.core.EfConstants;
//import com.englishtown.tests.core.landingpages.BaseOETest;
//import org.openqa.selenium.By;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//
//
//public class FR5freePLTest extends BaseOETest { //FRfreePLTest {
//    private static final Logger logger = LoggerFactory.getLogger(FR5freePLTest.class);
//    @Value("#{applicationPropertiesList['fr.freepl5']}")
//    private String testUrl;
//    public String btn=".variables .column0 .bs3 .btn";
//
//
//    @BeforeClass
//    public void setupOpenUrl() {
//        setThreadSafeDriver();
//        setTestStartUrl(testUrl);
//        isUseCssEnterFormData = true;
//        urlContainsThankyou = "welcome";
//
//        formLeadTypeValue = "oe";
//        formDataMap = EfConstants.FR_FREE_PL_CSS_NO_TOC;//CRM pages to use the map without TC checkbox
//        openUrl(getWebDriver(), getTestStartUrl());
//    }
//
//
//    @AfterClass
//    protected void setupAfterClass(){
//        destroyDriver();
//    }
//
//    @Override
//    protected void submitForm() {
//        submitBtn = ".btn-primary.btn-block";
//        click(By.cssSelector(submitBtn));
//    }
//}
