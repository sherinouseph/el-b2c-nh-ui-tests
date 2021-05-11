//package com.englishlive.tests.home.geoippopup;
///**
// *
// */
//
//import com.englishlive.tests.home.geoippopup.core.BaseGeoippopTest;
//import com.englishtown.helpers.JavaScriptHelper;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
// //TODO Select country goes to Live url . check with norm
//public class OpenEsWwsSiteFromDefaultUkGeoippopTest extends BaseGeoippopTest {
//    private static final Logger logger = LoggerFactory.getLogger(OpenEsWwsSiteFromDefaultUkGeoippopTest.class);
//    @Value("#{applicationPropertiesList['home.es.wws.url']}")
//    private String testUrl;
//
//
//    @BeforeClass
//    public void setUpOpenUrlSetupCookie() {
//        logger.info("setUp beforeTest ...!");
//        endUrl         = "en-gb";
//        endUrl2        = "es-wws";
//        ipctrValue     = "gb" ;
//        testStartUrl = testUrl;
//        openUrl(getWebDriver(), testStartUrl);
//
//        //close popup
//        waitForElementVisibleAndClick(".pagination-left .cq-dd-image", 10);
//        sleep(1000);
//    }
//
//}
//
//
///*       if(getBASEURL().contains("qa")){
//            domain = "qa-"+domain;
//        }
//        cookieScript = "document.cookie ='ipctr="+ipctrValue+"; domain="+domain+"; path=/'";
//        // clear local storage ann update cookie
//        JavaScriptHelper.executeJavaScript(CLEAR_LOCAL_STOREAGE, getWebDriver());
//        sleep(1000);
//        JavaScriptHelper.executeJavaScript(cookieScript, getWebDriver());
//        refresh(getWebDriver());
//        sleep(3000);*/