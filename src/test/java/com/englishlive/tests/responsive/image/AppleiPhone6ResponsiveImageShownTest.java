//package com.englishlive.tests.responsive.image;
///**
// * Created by nikol.marku on 24/03/2016.
// *
// */
//import com.englishlive.tests.responsive.image.core.BaseResponsiveImageShownTest;
//import com.englishtown.driver.MyBrowserType;
//import com.englishtown.helpers.UrlMapper;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//
//// moved to run on real devices
//public class AppleiPhone6ResponsiveImageShownTest extends BaseResponsiveImageShownTest {
//    private static final Logger logger = LoggerFactory.getLogger(AppleiPhone6ResponsiveImageShownTest.class);
//
//    protected static String testImgCss = ".adaptiveimage img.img-responsive";
//
//
//    @BeforeClass
//    public void setup() {
//        setThreadSafeDriver(MyBrowserType.CHROME_EMULATOR_IPHONE6, 25);; //setDriverMobileSimulatoriPhone6();
//        testUrl = getBASEURL()+testUrl; // UrlMapper.mapEliveBaseUrlToEtown(getBASEURL())+testUrl;
//        this.openUrl(getWebDriver(), testUrl, -1);
//        sleep(3000);
//    }
//
//
//    @AfterClass
//    protected void destroyDriverAfterClass(){
//        destroyDriver();
//    }
//
//}
