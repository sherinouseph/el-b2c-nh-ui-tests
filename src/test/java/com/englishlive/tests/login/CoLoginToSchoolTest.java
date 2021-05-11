//package com.englishlive.tests.login;
///**
// * Login an existing user [de]
// * User: nikol.marku
// * Date: 09/09/14
// *
// *
// */
//import com.englishtown.helpers.UrlMapper;
//import com.englishtown.pages.landing.OSLandingPage;
//import com.englishtown.tests.core.login.BaseLoginTest;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
//
//public class CoLoginToSchoolTest extends BaseLoginTest {
//    private static final Logger logger = LoggerFactory.getLogger(CoLoginToSchoolTest.class);
//    @Value("#{applicationPropertiesList['home.page.co.es']}")
//    protected String osPageUrl;
//    @Value("#{applicationPropertiesList['user.all']}")
//    protected String testUsername;
//
//
//    @BeforeClass
//    protected void setup(){
//        //osPageUrl =  UrlMapper.mapUrlToELive(osPageUrl, getBASEURL());
//        isPopupShown=true;
//        this.getPage().isUrlValidForThisPage();
//        //try{Thread.sleep(1000);}catch (Exception e){}
//        this.username = testUsername;
//    }
//
//    @Override
//    protected OSLandingPage createPage() {
//        return new OSLandingPage(this.webDriver, this.osPageUrl);
//    }
//
//    @Override
//    public  void verifyLanguage(){}
//    @Override
//    public  void verifyMarket(){}
//
//}
