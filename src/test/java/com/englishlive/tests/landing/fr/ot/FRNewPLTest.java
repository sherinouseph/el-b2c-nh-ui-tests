//package com.englishlive.tests.landing.fr.ot;
///**
// *Created by sherin 19/09/2017
// * Free PL test
// *  http://englishlive.ef.com/fr-fr/reservation-cours-particulier/
// *
// *
// */
//
//import com.englishtown.tests.core.BaseTestHelper;
//import com.englishtown.tests.core.EfConstants;
//import org.openqa.selenium.By;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//
//public class FRNewPLTest extends BaseTestHelper {
//    private static final Logger logger = LoggerFactory.getLogger(FRNewPLTest.class);
//    @Value("#{applicationPropertiesList['fr.newpl']}")
//    private String testUrl;
//
//
//    @BeforeClass
//    public void setupOpenUrl(){
//        setThreadSafeDriver();
//        setTestStartUrl(testUrl);
//        urlContainsThankyou = "welcome";
//        submitBtn = ".formset-button";
//        formDataMap = EfConstants.FR_FREE_PL_CSS;
//        openUrl(getWebDriver(), getTestStartUrl());
//    }
//
//
//    @Test
//    public void enterFreePlFormData(){
//        enterFormDataCss(formDataMap);
//        sleep(1000);
//    }
//
//    @Test(dependsOnMethods = {"enterFreePlFormData"})
//    public void submitForm(){
//        click(getWebDriver(), By.cssSelector(submitBtn));
//        sleep(5000);
//    }
//
//    @Test(dependsOnMethods = {"submitForm"})
//    public void checkFreePlTyPage(){
//        assertIsUrlContaining(urlContainsThankyou);
//       }
//
//    @AfterClass
//    protected void setupAfterClass(){
//        destroyDriver();
//    }
//
//
//}
