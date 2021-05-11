//package com.englishlive.tests.responsive;
///**
// * Test for Responsive design
// *
// * Created by nikol.marku on 01/06/2015.
// */
//import com.englishtown.driver.BaseRemoteWebDriver;
//import com.englishtown.helpers.utils.TestUtil;
//import com.englishtown.tests.core.responsivecore.BaseResponsiveDesignTest;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
//
//public class HomeMobileARSAResponsiveTest extends BaseResponsiveDesignTest {
//    private static final Logger logger = LoggerFactory.getLogger(HomeMobileARSAResponsiveTest.class);
//    @Value("#{applicationPropertiesList['home.mobile.ar.sa.url']}")
//    protected String testUrl;
//
//
//    @BeforeClass
//    public void setup(){
//        TestUtil.printMethodName(logger);
//        selectorCss = ".login-link";
//        assertMe = false;
//        screenShotTestName="MobilePageARSA_"+BaseRemoteWebDriver.getCurrentBrowserName();
//        this.openUrl(getWebDriver(), testUrl, -1 ) ;
//        sleep(3000);
//    }
//
//
//}
