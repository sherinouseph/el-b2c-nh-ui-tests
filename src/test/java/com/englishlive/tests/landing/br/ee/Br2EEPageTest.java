//package com.englishlive.tests.landing.br.ee;
//
//import com.englishlive.tests.landing.base.BaseEEtoThankyouFormFlowTest;
//import com.englishtown.driver.MyBrowserType;
//import com.englishtown.driver.local.DriverManager;
//import com.englishtown.helpers.WaitTool;
//import com.englishtown.pages.landing.EELandingPage;
//import com.englishtown.tests.core.EfConstants;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//// form changed so remove
//public class Br2EEPageTest extends BaseEEtoThankyouFormFlowTest {
//    private static final Logger logger = LoggerFactory.getLogger(Br2EEPageTest.class);
//
//    @Value("#{applicationPropertiesList['br.ee2.url']}")
//    private String eePageUrl;
//    @Value("#{applicationPropertiesList['test.telephone.br']}")
//    private String localizedTestPhoneNumber;
//
//
//    @BeforeClass
//    protected void setup(){
//        this.setLanguageAndMarket("pt","br");
//        setThreadSafeDriver();
//       //failTestIfIsNotBrowser(CHROME_BROWSER_LIST, "Chrome Only Test ....!");
//        formLeadTypeValue = "ee";
//        isGetFormSubmit = false;
//        submitBtn = "form button.btn";
//
//        this.getPage().isUrlValidForThisPage();
//        try{Thread.sleep(3000);}catch (Exception e){}
//        noOfWebFormElements = 7;
//        formDataMap = EfConstants.brEEFormMap;
//        thankyou_page_url_contains = "thankyou";
//        //sendEmailEnglisCheckBoxId
//    }
//
//    @Override
//    protected EELandingPage createPage() {
//        //this.setLanguageAndMarket("pt","br");
//        return new EELandingPage(getWebDriver(), this.eePageUrl);
//    }
//
//    @Test//(priority=3)
//    public void verifyMarket() throws Exception{
//        isStateObjectKey(getWebDriver(),"page.market", getMarket());
//    }
//
//    @Test//(priority=3)
//    public void verifyLanguage() {
//        sleep(1000);
//        isStateObjectKey(getWebDriver(),"page.language", getLanguage());
//    }
//
//    @AfterClass
//    protected void testAfterClass(){
//        destroyDriver();
//    }
//
//}
//
//
//
