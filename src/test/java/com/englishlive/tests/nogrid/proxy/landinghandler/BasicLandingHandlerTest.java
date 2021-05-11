//package com.englishlive.tests.nogrid.proxy.landinghandler;
///**
// * Created by nikol.marku on 05/04/2016.
// *
// */
//import com.englishlive.tests.nogrid.proxy.BaseLandingHandlerTest;
//import com.englishtown.helpers.bean.handler.BasicPostDataHandler;
//import com.englishtown.helpers.bean.handler.EfFullDataBean;
//import com.englishtown.helpers.reader.MyJsonReader;
//import com.englishtown.helpers.utils.TestUtil;
//import com.englishtown.tests.core.BaseTest;
//import com.englishtown.tests.core.EfConstants;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//
// // Fail with error thread safety driver ... 27 jul 2017
//public class BasicLandingHandlerTest extends BaseLandingHandlerTest {
//    private static final Logger logger = LoggerFactory.getLogger(BasicLandingHandlerTest.class);
//    @Value("#{applicationPropertiesList['lp.landinghandler.test.url']}")
//    protected String currTestUrl;
//
//
//    @BeforeClass
//    public void setupOpenUrl(){
//        testURL = currTestUrl;
//        setupChromeWithProxyDriver(testURL);
//        proxyServer.newHar("BasicLandingHandlerTest-har");
//        testDataMap =  EfConstants.frEEFormMap1;
//        isSubmitOeFormHandler = true;
//        submitBtnCss = "#osformsubmit";
//        expectedPostData = MyJsonReader.getEfFullDataBeanFromJsonFile(MyJsonReader.getEfBeanJasonFilePath());
//        expectedPostData.setLeadtype("ee");
//        expectedPostData.setLocal("fr");
//        telephoneValue = expectedPostData.getMobilePhone();
//        //expectedPostData.setMobilePhone(testDataMap.get("telephone").toString());
//        isEnterPhoneNumber = true;
//        telephoneCss =  "[name=telephone]";
//        userName = (String)testDataMap.get("email");
//        expectedPostData.setEmail(userName);
//
//        TestUtil.openUrl(driver, currTestUrl);
//    }
//
//    @AfterClass
//    public void destroyDriverAndProxy(){
//        destroyDriverAndProxyServer();
//    }
//
//
//
//}