//package com.englishlive.tests.login;
///**
// * Login an existing user
// *
// */
//import com.englishtown.pages.landing.OSLandingPage;
//import com.englishtown.tests.core.login.BaseLoginTest;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
//
//public class FrLoginToSchoolTest extends BaseLoginTest {
//    private static final Logger logger = LoggerFactory.getLogger(FrLoginToSchoolTest.class);
//    @Value("#{applicationPropertiesList['home.page.fr']}")
//    protected String osPageUrl;
//    @Value("#{applicationPropertiesList['user.all']}")
//    protected String testUsername;
//
//
//    @BeforeClass
//    protected void setup(){
//        this.getPage().isUrlValidForThisPage();
//        try{Thread.sleep(3000);}catch (Exception e){}
//        username = testUsername;
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
