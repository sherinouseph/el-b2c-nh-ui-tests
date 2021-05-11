//package com.englishlive.tests.landing.uk.hiddenfields.utm;
///**
// *  Open homepage URL with params then oppen member page and check hidden fields  see $oldHiddenFieldIds
// */
//import com.englishtown.tests.core.hiddenfields.BaseUtmHiddenField;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
//public class UkHomeToOsUtmHiddenFieldTest extends BaseUtmHiddenField {
//    private static final Logger logger = LoggerFactory.getLogger(UkHomeToOsUtmHiddenFieldTest.class);
//
//    @Value("#{applicationPropertiesList['uk.home.utm.url']}")
//    private String homepage;
//    @Value("#{applicationPropertiesList['uk1.os.url']}")
//    private String memberPage;
//
//    @BeforeClass
//    public void setup(){
//        this.openUrl(getWebDriver(), this.homepage, -1 ) ;
//        sleep(3000);//!!!!!
//        this.openUrl(getWebDriver(), this.memberPage, -1 ) ;
//        waitForHidenField(oldHiddenFieldIds[0], 25);
//    }
//
//
//}
//
//
//
//
