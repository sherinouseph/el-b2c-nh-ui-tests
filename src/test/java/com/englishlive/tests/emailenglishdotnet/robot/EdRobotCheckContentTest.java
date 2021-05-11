//package com.englishlive.tests.emailenglishdotnet.robot;
//
//import com.englishtown.helpers.AssertHelper;
//import com.englishtown.helpers.UrlMapper;
//import com.englishtown.tests.core.BaseTestHelper;
//import org.openqa.selenium.By;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import static org.hamcrest.CoreMatchers.containsString;
//
///**
// * Created by nikol.marku on 17/02/2016.
// */
//public class EdRobotCheckContentTest extends BaseTestHelper{
//    private static final Logger logger = LoggerFactory.getLogger(EdRobotCheckContentTest.class);
//    @Value("#{applicationPropertiesList['ee.robot.txt.url']}")
//    protected String pageUrl;
//
//
//    @BeforeClass
//    public void setup(){
//        pageUrl = "http://qa-englishcenters.ef.com/robots.txt"; //UrlMapper.mapBaseUrlToEtown(pageUrl, getBASEURL());
//        this.openUrl(getWebDriver(), this.pageUrl, -1 ) ;
//        logger.info("...   "+getWebDriver().getPageSource());
//        sleep(1000);
//    }
//    @Test
//    public void checkFileRobotTextContent(){
//        AssertHelper.assertThat("Disallow is not present in the content ...!", getWebDriver().getPageSource(), containsString("Disallow1"));
//    }
//
//
//}
