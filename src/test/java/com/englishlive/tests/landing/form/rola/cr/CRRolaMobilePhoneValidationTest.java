//package com.englishlive.tests.landing.form.rola.cr;
///**
// *
// *
// */
//import com.englishlive.tests.landing.form.rola.baserolaforms.BasePhoneTypeDefaultValues;
//import com.englishlive.tests.landing.form.rola.baserolaforms.BaseRolaFormValidation;
//import com.englishlive.tests.landing.form.rola.baserolaforms.BaseRolaPhoneValidation;
//import com.englishtown.helpers.UrlMapper;
//import com.englishtown.helpers.WaitTool;
//import com.englishtown.tests.core.EfConstants;
//import com.englishtown.tests.core.common.BasePhoneValidation;
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
///**
// * Created by nikol.marku on 16/11/2015.
// */
//public class CRRolaMobilePhoneValidationTest extends BaseRolaPhoneValidation {
//    private static final Logger logger = LoggerFactory.getLogger(BasePhoneTypeDefaultValues.class);
//
//    @Value("#{applicationPropertiesList['home.cr.url']}")
//    private String testUrl ;
//
//
//
//    @BeforeClass
//    void setup(){
//        //testUrl = UrlMapper.mapUrlToELive(testUrl, getBASEURL());
//        clickToCloseDamPopup = true;
//        PHONE_TYPE_INDEX = 0;
//        validPhoneNo     = CR_VALID_MOBILE_PHONE;
//        invalidPhoneNo   = CR_INVALID_MOBILE_PHONE;
//        logger.info("test url is :  "+testUrl ) ;
//        openUrl(getWebDriver(), testUrl, WaitTool.MED_WAIT_4_ELEMENT);
//        if(clickToCloseDamPopup){
////            clickToClosePopup(By.className("modal-dialog"), 5,5);
//            waitForElementCondition(ExpectedConditions.invisibilityOfElementLocated( By.className("modal-dialog")) , getWebDriver(), 5);
//            sleep(1000);
//        }
//        enterFormData(EfConstants.crFormMap_testPhone);
//    }
//
//
//
//}
//
//
