package com.englishlive.tests.checkout.newcheckout.de;
/**
 *
 *
 */
import com.englishtown.enumpack.CardType;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.tests.checkout.common.core.CheckEnrolmentTest;
import com.englishtown.tests.core.EfConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static org.hamcrest.Matchers.is;


public class CcDEAmexCheckoutTest extends CheckEnrolmentTest {
    private static final Logger logger = LoggerFactory.getLogger(CcDEAmexCheckoutTest.class);
    @Value("#{applicationPropertiesList['new.checkout.member.de.de.url']}")
    protected String currMemberPageUrl;       //protected String payButtonSelector = "form_tabctrl_tab-0_button"; //id   // .nav-tabs a fr pay page 2 tabs card pay and pay pal


    @BeforeClass
    public void setup(){
        failTestPerEnvironment("live", "Can not test this on live ...! see qa test.");
        setThreadSafeDriver();
        phase1OfferPrice ="59";
        TestUtil.printMethodName(logger);
        creditCardLinkText="Kreditkarte";
        tabId = 1;
        testCardType=CardType.AMEX;
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

