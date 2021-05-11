package com.englishlive.tests.mobileandtablets.simulator.ios.tablet.checkout;
/**
 * Tablet test
 *
 */

import com.englishtown.driver.MyBrowserType;
import com.englishtown.enumpack.AdyenTestCard;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.tests.checkout.common.core.NewCcBaseCheckoutFlowTest;
import com.englishtown.tests.core.EfConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class MobCcDECheckoutTest extends NewCcBaseCheckoutFlowTest {
    private static final Logger logger = LoggerFactory.getLogger(MobCcDECheckoutTest.class);
    @Value("#{applicationPropertiesList['new.checkout.member.de.de.url']}")
    protected String currMemberPageUrl;


    @BeforeClass
    public void setup(){
        TestUtil.printMethodName(logger);
        setThreadSafeDriver(MyBrowserType.CHROME_SIMULATOR_IPAD, 25);
        setScreenShotOnFailure(true);
        setLanguageAndMarket("de", "de");
        phase1OfferPrice ="59";
        isNewhouseTyPage=true;
        isClickTabId=false;
        is_adyenPayment=true;
        is_adyen3DSecure=true;
        adyenTestCard= AdyenTestCard.MASTERCARD;
        isPhoneTextInputShownOnTYpage = true;
        isRunTestPhoneTextCheckPhoneTxtOnTy = true;
        creditCardLinkText="Kreditkarte";
        tabId = 1;
        this.memberPageUrl = currMemberPageUrl;
        formDataMap = EfConstants.DE_MEMBER_FORM;
        logger.info("setup url: "+memberPageUrl);
        this.openUrl(getWebDriver(), this.memberPageUrl, -1 ) ;
    }

    @Override
    protected String getMemberPageUrl() {
        memberPageUrl = currMemberPageUrl;
        return memberPageUrl;
    }

    @AfterClass
    protected void testAfterClass(){
        destroyDriver();
    }

}

