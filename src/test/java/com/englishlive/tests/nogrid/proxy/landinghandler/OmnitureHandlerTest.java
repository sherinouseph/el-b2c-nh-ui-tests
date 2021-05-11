//package com.englishlive.tests.nogrid.proxy.landinghandler;
///**
// * Created by nikol.marku on 05/04/2016.
// *
// */
//import com.englishlive.tests.nogrid.proxy.BaseOmnitureHandlerTest;
//import com.englishtown.helpers.bean.handler.BasicOmnitureData;
//import com.englishtown.helpers.bean.handler.EfFullDataBean;
//import com.englishtown.helpers.utils.TestUtil;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
//
//  // form is not submitting
//public class OmnitureHandlerTest extends BaseOmnitureHandlerTest {
//    private static final Logger logger = LoggerFactory.getLogger(OmnitureHandlerTest.class);
//
//    @Value("#{applicationPropertiesList['lp.landinghandler.test.url']}")
//    protected String currTestUrl;
//
//
//    @BeforeClass
//    public void setupOpenUrl(){
//        setupJBorwserProxyDriver(currTestUrl);    //setUpProxy();
//        omniDataObj = new BasicOmnitureData("LandingPages","omnitestptnnikol","fr","fr-fr","fr","OmniTestEtagNikol", "200");
//        TestUtil.openUrl(driver, currTestUrl);
//    }
//
//
//}
