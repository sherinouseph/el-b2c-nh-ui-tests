//package com.englishlive.tests.responsive.image;
///**
// * Created by nikol.marku on 24/03/2016.
// *
// * OPen test page
// * check image shown if screen size more than W : 768px
// * https://jira-bos.englishtown.com/browse/SAND-2876
// *
// * Note full size browser used
// */
//import com.englishlive.tests.responsive.image.core.BaseResponsiveImageShownTest;
//import com.englishtown.driver.MyBrowserType;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//
//// moved to run on real devices
//public class GalaxyS5ResponsiveImageShownTest extends BaseResponsiveImageShownTest {
//    private static final Logger logger = LoggerFactory.getLogger(GalaxyS5ResponsiveImageShownTest.class);
//
//    protected static String testImgCss = ".adaptiveimage img.img-responsive";
//
//
//    @BeforeClass
//    public void setup() {
//        setThreadSafeDriver();//MyBrowserType.CHROME_EMULATOR_GALAXY_S5, 25); //setDriverMobileSimulatorGalaxyS4();
//        testUrl = getBASEURL()+testUrl; //UrlMapper.mapEliveBaseUrlToEtown(getBASEURL())+testUrl;
//        this.openUrl(getWebDriver(), testUrl, -1);
//        sleep(3000);
//    }
//
//    @AfterClass
//    protected void destroyDriverAfterClass(){
//        destroyDriver();
//    }
//
//}
