//package com.englishlive.tests.landing.form.rola.ar;
///**
// *
// *  Niko: NO formm in this page now ... BR team changes things so ON BR team .. Test Removed
// */
//
//import com.englishlive.tests.landing.form.rola.baserolaforms.BaseRolaChangeCountry;
//import com.englishtown.tests.core.EfConstants;
//import org.openqa.selenium.By;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//
//
//public class ARCheckCityCountryFormDataNotChangedTest extends BaseRolaChangeCountry {
//    private static final Logger logger = LoggerFactory.getLogger(ARCheckCityCountryFormDataNotChangedTest.class);
//    @Value("#{applicationPropertiesList['home.ar.url']}")
//    private String testUrl ;
//
//
//
//    @BeforeClass
//    void setupOpenUrlEnterData(){
//        setThreadSafeDriver();
//        clickToCloseDamPopup = true;
//        testStartUrl = testUrl;
//        setLanguageAndMarket("es", "ar");
//        formDataMap = EfConstants.getDynamicMap("first_name", "last_name", "email");
//        openUrl(getWebDriver(), testStartUrl);
//        sleep(3000);
//        if(clickToCloseDamPopup){
//            clickAtWindow(getWebDriver(), 7, 7);
//            sleep(500);
//        }
//        enterFormData(formDataMap);
//        testStartSelectedCountry = getSelectedOption(findElement(By.cssSelector(COUNTRY_CSS)));
//    }
//
//
//    @AfterClass
//    protected void setupAfterClass(){
//        destroyDriver();
//    }
//
//
//}
