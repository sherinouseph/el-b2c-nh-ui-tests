//package com.englishlive.tests.responsecode.market;
///**
// * Created by nikol.marku on 13/07/2016.
// * Get all the urls on a page and check response code less than 400
// */
//import com.englishlive.tests.responsecode.core.BaseAllUrlsOnPageResponseCodeTest;
//import com.englishtown.driver.MyBrowserType;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
//
//public class SaAllUrlsOnHomePageResponseCodeLessThan400Test extends BaseAllUrlsOnPageResponseCodeTest {
//    private static final Logger logger = LoggerFactory.getLogger(SaAllUrlsOnHomePageResponseCodeLessThan400Test.class);
//    @Value("#{applicationPropertiesList['home.page.sa']}")
//    protected String currTestUrl ;
//
//    @BeforeClass
//    void setupOpenUrl(){
//        htmlUnitTestUrl = currTestUrl;
//        createLocalThreadDriver(MyBrowserType.HTMLUNIT, 25);
//        openUrl(getLocalThreadDriver(), htmlUnitTestUrl);
//    }
//
//}
