//package com.englishlive.tests.landing.uk.hiddenfields.utm;
///**
// *  Open URL and check hidden fields  see $oldHiddenFieldIds
// */
//import com.englishtown.tests.core.hiddenfields.BaseUtmHiddenField;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
//
//public class UkUtmHiddenFieldOsToPageTest extends BaseUtmHiddenField {
//    private static final Logger logger = LoggerFactory.getLogger(UkUtmHiddenFieldOsToPageTest.class);
//
//    @Value("#{applicationPropertiesList['uk.to.utm.url']}")
//    private String osPageUrl;
//
//
//    @BeforeClass
//    public void setup(){
//        this.openUrl(getWebDriver(), this.osPageUrl, -1 ) ;
//        sleep(200);
//    }
//
//
//}
//
//
//
//
