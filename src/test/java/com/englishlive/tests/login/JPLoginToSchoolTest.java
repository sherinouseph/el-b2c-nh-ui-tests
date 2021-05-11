//package com.englishlive.tests.login;
///**
// * Login an existing user
// *
// */
//
//import com.englishtown.helpers.UrlMapper;
//import com.englishtown.pages.landing.OSLandingPage;
//import com.englishtown.tests.core.login.BaseLoginTest;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
//
//public class JPLoginToSchoolTest extends BaseLoginTest {
//    private static final Logger logger = LoggerFactory.getLogger(JPLoginToSchoolTest.class);
//    @Value("#{applicationPropertiesList['home.jp.jp.url']}")
//    protected String osPageUrl;
//    @Value("#{applicationPropertiesList['user.all']}")
//    protected String testUsername;
//
//    protected String firstNameId ="first_name";
//
//    @BeforeClass
//    protected void setup(){
//        //osPageUrl = UrlMapper.mapUrlToELive(osPageUrl, getBASEURL());
//        this.getPage().isUrlValidForThisPage();        //try{Thread.sleep(1000);}catch (Exception e){}
//        username = testUsername;
//        popupSelector = ".modal.in";
//        isPopupShown=false;        //waitForElementAndclickAtXY(firstNameId, 1, 1);
//    }
//
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
//
//
//}
