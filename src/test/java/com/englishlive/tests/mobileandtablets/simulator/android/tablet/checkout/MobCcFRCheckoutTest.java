//package com.englishlive.tests.mobileandtablets.simulator.android.tablet.checkout;
///**
// *
// *
// */
//
//import com.englishtown.driver.BaseRemoteWebDriver;
//import com.englishtown.driver.MyBrowserType;
//import com.englishtown.driver.mobile.ChromeSimulatorGoogleNexus7WebDriver;
//import com.englishtown.helpers.utils.TestUtil;
//import com.englishtown.pages.core.BasePage;
//import com.englishtown.tests.checkout.common.core.CheckEnrolmentTest;
//import com.englishtown.tests.checkout.common.core.NewCcBaseCheckoutFlowTest;
//import com.englishtown.tests.core.EfConstants;
//import org.openqa.selenium.WebDriver;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
////import com.englishtown.driver.mobile.ChromeSimulatorAppleiPadWebDriver;
//// not needed as we have real mobiles now
//public class MobCcFRCheckoutTest extends NewCcBaseCheckoutFlowTest {
//    private static final Logger logger = LoggerFactory.getLogger(MobCcFRCheckoutTest.class);
//    @Value("#{applicationPropertiesList['new.checkout.member.fr.fr.url']}")
//    protected String currMemberPageUrl;
//
//    protected WebDriver simulatorDriver;
//
//    @BeforeClass
//    public void setup(){
//        TestUtil.printMethodName(logger);
//        phase0OfferPrice="89";
//        setThreadSafeDriver(MyBrowserType.CHROME_SIMULATOR_NEXUS, 25);
//        isPhoneTextInputShownOnTYpage = true;
//        isRunTestPhoneTextCheckPhoneTxtOnTy = true;
//        creditCardLinkText="Carte";
//        tabId = 1;
//        isClickTabId = false;
//        this.memberPageUrl = currMemberPageUrl;
//        formDataMap = EfConstants.ukMembersFormMap_new;
//        logger.info("setup url: "+memberPageUrl);
//        this.openUrl(getWebDriver(), this.memberPageUrl, -1 ) ; //getWebDriver().get(this.memberPageUrl);
//    }
//
//    @Override
//    protected String getMemberPageUrl() {
//        memberPageUrl = currMemberPageUrl;
//        return memberPageUrl;
//    }
//
//    @AfterClass
//    protected void testAfterClass(){
//        try{
//            if(null != webDriver)
//                webDriver.quit();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        destroyDriver();
//    }
//
//
//}
//
