//package com.englishlive.tests.checkout.newcheckout.uk;
///**
// * Cant go directly to pay page
// *
// */
//import com.englishtown.tests.checkout.common.StandardCheckoutFlowTest;
//import com.englishtown.tests.checkout.responsivecore.NewCcBaseCheckoutFlowTest;
//import com.englishtown.tests.responsivecore.EfConstants;
//import org.hamcrest.responsivecore.Is;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import static org.hamcrest.CoreMatchers.is;
//import static org.hamcrest.MatcherAssert.assertThat;
//
//
//public class UKCheckPayMethodsTest extends StandardCheckoutFlowTest {
//    private static final Logger logger = LoggerFactory.getLogger(UKCheckPayMethodsTest.class);
//    @Value("#{applicationPropertiesList['checkout.pay.en.en.url']}")
//    protected String url;
//    public static final String weNavTabs = ".nav-tabs";
//
//    @BeforeClass
//    public void setup(){
//        printMethodName(logger);
//        logger.info("setup url: "+url);
//        getWebDriver().get(url);
//    }
//    @Test
//    public void checkPayMethodsAvailable(){
//       assertThat("FAILED is element visible,  element '" + weNavTabs + "'",
//                        isElementVisible(getWebDriver().findElement(By.id(weNavTabs)),
//                                15), Is.is(true));
//    }
//
//    @Override
//    protected String getTestPageUrl() {
//        memberPageUrl = url;
//        return memberPageUrl;
//    }
//
//    @Override
//    protected String getPaymentPageUrl() {
//        return null;
//    }
//
//    @Override
//    protected String getThankYouPageUrl() {
//        return null;
//    }
//
//}
//
