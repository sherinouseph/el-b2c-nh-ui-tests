package com.englishlive.tests.mobileandtablets.simulator.ios.phone.checkout;
/**
 *
 */
import com.englishtown.driver.BaseRemoteWebDriver;
import com.englishtown.driver.MyBrowserType;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.tests.checkout.common.core.NewCcBaseCheckoutFlowTest;
import com.englishtown.tests.core.EfConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class MobCcSACheckoutTest extends NewCcBaseCheckoutFlowTest {
    private static final Logger logger = LoggerFactory.getLogger(MobCcSACheckoutTest.class);
    @Value("#{applicationPropertiesList['new.checkout.member.ar.sa.url']}")
    protected String currMemberPageUrl;

    @BeforeClass
    public void setup(){
        setLanguageAndMarket("ar", "sa");
        TestUtil.printMethodName(logger);
        BaseRemoteWebDriver.setDeviceNameForMobileSimulator("Apple iPhone 6");
        BaseRemoteWebDriver.setCurrentBrowserName("chrome");
        setScreenShotOnFailure(false);

        //if(BaseRemoteWebDriver.isBrowser("chrome")){
            try {
                setThreadSafeDriver(MyBrowserType.CHROME_EMULATOR_IPHONE6, 25);
            } catch (Exception e) {
                logger.error(" Mobile driver not created : " + TestUtil.getException(e));
            }
        /*} else {
            BasePage.failTest("This test should run only on chrome Mobile simulator [iphone, galaxy, etc ...!] ");
        }*/

        isPhoneTextInputShownOnTYpage = false;
        isRunTestPhoneTextCheckPhoneTxtOnTy = false;
        creditCardLinkText="Card Payment";
        isClickTabId = false;
        tabId = 1;
        this.memberPageUrl = currMemberPageUrl;
        formDataMap = EfConstants.ukMembersFormMap_new;
        logger.info("setup url: "+memberPageUrl);
        this.openUrl(getWebDriver(), this.memberPageUrl, -1 ) ; //getWebDriver().get(this.memberPageUrl);
    }

    @Override
    protected String getMemberPageUrl() {
        memberPageUrl = currMemberPageUrl;
        return memberPageUrl;
    }

    @AfterClass
    protected void testAfterClass(){

        try{
            if(null != webDriver)
                webDriver.quit();
        }catch (Exception e){
            e.printStackTrace();
        }
        destroyDriver();
    }


}

