//package com.englishlive.tests.newsite.responsecode.newsite;//package com.englishlive.tests.newsite.responsecode.newsite;//package com.englishlive.tests.responsecode.market;
///**
// * NOTE: THE NEW SITE DOES NOT HAVE MANY HREFs defined on the html source but uses JS
// * Created by nikol.marku on Apr 2018
// * Get all the urls on a page and check response code less than 400
// */
//import com.englishlive.tests.responsecode.core.BaseAllUrlsOnPageResponseCodeTest;
//import com.englishtown.driver.MyBrowserType;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.testng.annotations.BeforeClass;
//
//
//public class Russia2018CheckLinkHome extends BaseAllUrlsOnPageResponseCodeTest {
//    private static final Logger logger = LoggerFactory.getLogger(Russia2018CheckLinkHome.class);
//   //@Value("#{applicationPropertiesList['new.home.page.gb']}")
//    //protected String currTestUrl = "https://qa.ef.ru/englishlive/study-plans-and-prices/"; //https://qa.ef.ru/englishlive/"; //  https://qa.ef.ru/englishlive/study-plans-and-prices/  //https://qa.ef.ru/englishlive/about-us/";// a lot of failures//https://qa.ef.ru/" ;
//    protected String currTestUrl = "https://qa.ef.ru/englishlive/free-consultation/" ;
//
//
//    @BeforeClass
//    void setupOpenUrl(){
//        htmlUnitTestUrl = currTestUrl;
//        createLocalThreadDriver(MyBrowserType.HTMLUNIT, 25);
//        openUrl(getLocalThreadDriver(), htmlUnitTestUrl);
//    }
//
//}
