//package com.englishlive.tests.landing.fr.os;
///**
// *Created by sherin 19/09/2017
// * Free PL test
// *  http://englishlive.ef.com/fr-fr/reservation-cours-particulier/ = new Os form since 21st august 2019
// *
// *
// */
//
//import com.englishtown.helpers.JavaScriptHelper;
//import com.englishtown.helpers.WaitTool;
//import com.englishtown.tests.core.BaseTestHelper;
//import com.englishtown.tests.core.EfConstants;
//import com.englishtown.tests.core.UniqueDataObject;
//import com.englishtown.tests.core.landingpages.BaseLPtoPayment;
//import org.openqa.selenium.By;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//
//public class FRNewOSTest extends BaseLPtoPayment {
//    private static final Logger logger = LoggerFactory.getLogger(FRNewOSTest.class);
//    @Value("#{applicationPropertiesList['fr4.os.url']}")
//    private String testUrl;
//
//
//
//    @BeforeClass
//    protected void setupOpenUrlBeforeClass(){
//        formLeadTypeValue = "os";
//        formDataMap = EfConstants.FRNEWOSFORMMAP;
//        formDataMap.replace("email", new UniqueDataObject().getEmail());
//        FULL_NAME = formDataMap.get("firstname")+ " " + formDataMap.get("lastname");
//        submitBtn = ".formset-button button";
//        setThreadSafeDriver();
//        openUrl(getWebDriver(), testUrl);
//        JavaScriptHelper.waitForPageLoaded(getWebDriver(), WaitTool.MED_WAIT_4_ELEMENT);
//    }
//
//    @AfterClass
//    protected void teardownAfterClass(){
//        destroyDriver();
//    }
//
//}
//
