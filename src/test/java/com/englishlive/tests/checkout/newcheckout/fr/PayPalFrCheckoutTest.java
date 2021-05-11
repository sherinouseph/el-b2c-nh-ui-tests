package com.englishlive.tests.checkout.newcheckout.fr;
/**
 *
 *
 */
import com.englishtown.tests.checkout.common.core.PayPalBaseCheckoutFlowTest;
import com.englishtown.tests.core.EfConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * This user run ONLY not LIVE ENVs
 */

public class PayPalFrCheckoutTest extends PayPalBaseCheckoutFlowTest {
    private static final Logger logger = LoggerFactory.getLogger(PayPalFrCheckoutTest.class);
    @Value("#{applicationPropertiesList['new.checkout.member.fr.fr.url']}")
    protected String currMemberPageUrl;

    @BeforeClass
    public void setup(){
        setThreadSafeDriver();
        setLanguageAndMarket("fr", "fr");
        confirPPWeCss = ".btn-primary";
        phase0OfferPrice="89";
        //isStoreData=false;
        testCountry = "fr";
        creditCardLinkText="Paypal";
        isNewhouseTyPage = true;
        this.formDataMap = EfConstants.ukMembersFormMap_new;
        this.memberPageUrl = currMemberPageUrl;
        tabId = 1;
        isRadioButonAtPaymentPage = true;
        logger.info("setup url: "+memberPageUrl);
        this.openUrl(getWebDriver(), this.memberPageUrl, -1 ) ;
    }

    @Override
    protected String getMemberPageUrl() {
        memberPageUrl = currMemberPageUrl;
        return memberPageUrl;
    }

    @Override
    protected String getPaymentPageUrl() {
        return null;
    }

    @Override
    protected String getThankYouPageUrl() {
        return null;
    }

    @AfterClass
    protected void testAfterClass(){
        destroyDriver();
    }

}

