//package com.englishlive.tests.mobileandtablets.simulator.android.tablet.checkout;
///**
// *
// *
// */
//import com.englishtown.driver.BaseRemoteWebDriver;
//
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
//import org.testng.annotations.BeforeClass;
////import com.englishtown.driver.mobile.ChromeSimulatorAppleiPadWebDriver;
//
//public class MobCcDECheckoutTest extends NewCcBaseCheckoutFlowTest {
//    private static final Logger logger = LoggerFactory.getLogger(MobCcDECheckoutTest.class);
//    @Value("#{applicationPropertiesList['new.checkout.member.de.de.url']}")
//    protected String currMemberPageUrl;
//
//    @BeforeClass
//    public void setup(){
//        TestUtil.printMethodName(logger);
//        //setupMobile
//        //BaseRemoteWebDriver.setDeviceNameForMobileSimulator("Samsung Galaxy S4");
//        setScreenShotOnFailure(false);
//        if(BaseRemoteWebDriver.isBrowser("chrome")){
//            try {
//                WebDriver simulatorDriver = new ChromeSimulatorGoogleNexus7WebDriver();
//                setWebDriver(simulatorDriver);
//            } catch (Exception e) {
//                logger.error(" Mobile driver not created : " + TestUtil.getException(e));
//            }
//        } else {
//            BasePage.failTest("This test should run only on chrome Mobile simulator [iphone, galaxy, etc ...!] and simulators -- chrome");
//        }
//
//        isPhoneTextInputShownOnTYpage = true;
//        isRunTestPhoneTextCheckPhoneTxtOnTy = true;
//        creditCardLinkText="Kreditkarte";
//        tabId = 1;
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
//
//}
//
