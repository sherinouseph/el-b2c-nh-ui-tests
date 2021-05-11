//package com.englishlive.tests.landing.br.pt;
///**
// *
// */
//import com.englishtown.helpers.utils.TestUtil;
//import com.englishtown.helpers.WaitTool;
//import com.englishtown.tests.core.EfConstants;
//import com.englishtown.tests.core.common.BaseEnterFormDataAndSubmit;
//import org.openqa.selenium.By;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//
//
//public class BR1PtPageTest extends BaseEnterFormDataAndSubmit {
//    private static final Logger logger = LoggerFactory.getLogger(BR1PtPageTest.class);
//
//    @Value("#{applicationPropertiesList['br1.pt.url']}")
//    private String testUrl;
//
//
//    @BeforeClass
//    protected void setup(){
//        TestUtil.printMethodName(logger, 2);
//        openUrl(getWebDriver(), getTestPageUrl(), WaitTool.MED_WAIT_4_ELEMENT25);
//        formDataMap = EfConstants.brOEFormMap;
//        submitWE = new By.ByCssSelector(".button a");
//    }
//
//    @Override
//    protected String getTestPageUrl() {
//        return testUrl;
//    }
//
//}
//
//
////todo this submit is dirty fix
////    @Override // this test
////    public void submit(){
////        logger.info("overritten submit ...!");
////        WebElement we = WebElementHelper.safeFindElement(getWebDriver(), By.cssSelector(".button a"));
////        click(we);
////    }
//
