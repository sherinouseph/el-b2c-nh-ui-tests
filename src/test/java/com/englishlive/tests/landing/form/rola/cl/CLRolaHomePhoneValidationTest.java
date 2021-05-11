//package com.englishlive.tests.landing.form.rola.cl;
///**
// *
// *
// */
//import com.englishlive.tests.landing.form.rola.baserolaforms.BasePhoneTypeDefaultValues;
//import com.englishlive.tests.landing.form.rola.baserolaforms.BaseRolaPhoneValidation;
//import com.englishtown.helpers.UrlMapper;
//import com.englishtown.helpers.WaitTool;
//import com.englishtown.tests.core.EfConstants;
//import org.openqa.selenium.By;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
///**
// * Created by nikol.marku on 16/11/2015.
// */
//public class CLRolaHomePhoneValidationTest extends BaseRolaPhoneValidation {
//    private static final Logger logger = LoggerFactory.getLogger(BasePhoneTypeDefaultValues.class);
//
//    @Value("#{applicationPropertiesList['home.cl.url']}")
//    private String testUrl ;
//
//
//    @BeforeClass
//    void setup(){
//        clickToCloseDamPopup = false;
//        PHONE_TYPE_INDEX = 1;
//        validPhoneNo     = CL_VALID_HOME_PHONE;
//        invalidPhoneNo   = CL_INVALID_HOME_PHONE;
//        depId      = 0;
//        cityId     = 3;
//        DEPARTMENT_TO_SELECT = CL_DEP_LIST_VALUES[depId];
//        CITY_LIST = CL_CITY_LIST_VALUES;
//        logger.info("test url is :  "+testUrl ) ;
//
//        openUrl(getWebDriver(), testUrl, WaitTool.MED_WAIT_4_ELEMENT);
//        if(clickToCloseDamPopup){
//            clickToClosePopup(By.className("modal-dialog"), 1,1);
//            waitForElementCondition(ExpectedConditions.invisibilityOfElementLocated( By.className("modal-dialog")) , getWebDriver(), 5);
//            sleep(1000);
//        }
//        enterFormData(EfConstants.crFormMap_testPhone);
//        select(By.id(DEPT_SELECT),DEPARTMENT_TO_SELECT, null );
//        selectCityCheckPhoneTypesDisplayed( CITY_CSS, CITY_LIST,  cityId) ;
//    }
//
//
//
//}
//
//
