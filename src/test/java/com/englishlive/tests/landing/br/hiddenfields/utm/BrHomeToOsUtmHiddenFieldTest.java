//package com.englishlive.tests.landing.br.hiddenfields.utm;
///**
// *  Open homepage URL with params then oppen member page and check hidden fields  see $oldHiddenFieldIds
// */
//import com.englishtown.tests.core.hiddenfields.BaseUtmHiddenField;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//
//// page changed BR should test this
//public class BrHomeToOsUtmHiddenFieldTest extends BaseUtmHiddenField {
//    private static final Logger logger = LoggerFactory.getLogger(BrHomeToOsUtmHiddenFieldTest.class);
//
//    @Value("#{applicationPropertiesList['br.home.utm.url']}")
//    private String homepage;
//    @Value("#{applicationPropertiesList['br.os1.url']}")
//    private String memberPage;
//
//    @BeforeClass
//    public void setup(){
//        setThreadSafeDriver();
//        failTestIfIsNotBrowser(CHROME_BROWSER_LIST, "Chrome Only Test ....!");
//        this.openUrl(getWebDriver(), this.homepage, -1 ) ;
//        sleep(2000);//!!!!!
//        this.openUrl(getWebDriver(), this.memberPage, -1 ) ;
//        waitForHidenField(oldHiddenFieldIds[0], 25);
//    }
//
//    @AfterClass
//    protected void testAfterClass(){
//        destroyDriver();
//    }
//
//
//}
//
//
//
//
