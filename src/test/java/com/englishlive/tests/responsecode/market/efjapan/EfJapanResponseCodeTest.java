//package com.englishlive.tests.responsecode.market.efjapan;
///**
// *
// * Created by nikol.marku on 2/27/2017.
// *  Open URL check response 200
// *
// */
//import com.englishlive.tests.basetest.htmlunit.BaseResponseCodeTest;
//import com.englishtown.driver.MyBrowserType;
//import com.englishtown.helpers.UrlMapper;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//// AKI said  No we stopped using the page a while ago
//
//public class EfJapanResponseCodeTest extends BaseResponseCodeTest {
//    private static final Logger logger = LoggerFactory.getLogger(EfJapanResponseCodeTest.class);
//    @Value("#{applicationPropertiesList['efjapan.url']}")
//    protected String currTestUrl ;
//
//    @BeforeClass
//    void setupOpenUrl(){
//        htmlUnitTestUrl = UrlMapper.mapBaseUrlToEtown(currTestUrl, getBASE_URL());
//        createLocalThreadDriver(MyBrowserType.HTMLUNIT, 25);
//        openUrl(getLocalThreadDriver(), htmlUnitTestUrl);
//    }
//
//}
