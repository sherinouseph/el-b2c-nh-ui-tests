package com.englishlive.tests.checkout.newcheckout.de;
import com.englishtown.enumpack.AdyenTestCard;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.tests.checkout.common.core.CheckEnrolmentTest;
import com.englishtown.tests.core.EfConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
public class CcDECheckoutTest extends CheckEnrolmentTest {

    private static final Logger logger = LoggerFactory.getLogger(CcDECheckoutTest.class);
    @Value("#{applicationPropertiesList['new.checkout.member.de.de.url']}")
    protected String currMemberPageUrl;       //protected String payButtonSelector = "form_tabctrl_tab-0_button"; //id   // .nav-tabs a fr pay page 2 tabs card pay and pay pal


    @BeforeClass
    public void setup(){
        setThreadSafeDriver();
        phase1OfferPrice ="59";
        is_adyen3DSecure=true;
        adyenTestCard= AdyenTestCard.VISA;
        is_adyenPayment=true;
        isNewhouseTyPage=true;
        TestUtil.printMethodName(logger);
        creditCardLinkText="Kreditkarte";
        setLanguageAndMarket("de", "de");
        isClickTabId = false;
        tabId = 1;
        this.memberPageUrl = currMemberPageUrl;
        formDataMap = EfConstants.deMembersWithPhoneMap;
        logger.info("setup url: "+memberPageUrl);
        this.openUrl(getWebDriver(), this.memberPageUrl, -1 );
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
