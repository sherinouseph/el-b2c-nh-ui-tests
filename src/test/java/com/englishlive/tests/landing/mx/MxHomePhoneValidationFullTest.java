//package com.englishlive.tests.landing.mx;
//
//import com.englishtown.pages.common.HomePage;
//import com.englishtown.tests.core.EfConstants;
//import com.englishtown.tests.core.common.BaseHomePhoneValidation;
//import org.openqa.selenium.By;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//
//public class MxHomePhoneValidationFullTest extends BaseHomePhoneValidation {
//    private static final Logger logger = LoggerFactory.getLogger(MxHomePhoneValidationFullTest.class);
//    @Value("#{applicationPropertiesList['home.page.mx']}")
//    private String homePageUrl;
//
//
//    @BeforeClass
//    protected void setup(){
//        setThreadSafeDriver();
//        setLanguageAndMarket("es","mx");
//        logger.info("setup ... baseurl :" + getBASEURL() + "  page url is : " + homePageUrl);
//        this.getPage().isUrlValidForThisPage();
//        formDataMap = EfConstants.mxOEFormMapWithPhoneType;
//        sleep(2000);
//        clickAtWindow(getWebDriver(), 5, 5);
//        enterFormData(EfConstants.mxOSFormMap_onlyAge);
//        currWebElement = findElement(By.name("first_name"));
//        this.scrollToWeAndClick(getWebDriver(),currWebElement, 0, 0);
//    }
//
//    @Override
//    protected HomePage createPage() {
//        return new HomePage(getWebDriver(), this.homePageUrl);
//    }
//
//
//    @AfterClass
//    protected void setupAfterClass(){
//        destroyDriver();
//    }
//
//
//}
//
