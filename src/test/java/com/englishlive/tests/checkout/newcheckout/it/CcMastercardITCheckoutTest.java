package com.englishlive.tests.checkout.newcheckout.it;
/**
 *
 *
 */
import com.englishtown.enumpack.CardType;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.tests.checkout.common.core.NewCcBaseCheckoutFlowTest;
import com.englishtown.tests.core.EfConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class CcMastercardITCheckoutTest extends NewCcBaseCheckoutFlowTest {
    private static final Logger logger = LoggerFactory.getLogger(CcMastercardITCheckoutTest.class);
    @Value("#{applicationPropertiesList['new.checkout.member.it.it.url']}")
    protected String currMemberPageUrl;       //protected String payButtonSelector = "form_tabctrl_tab-0_button"; //id   // .nav-tabs a fr pay page 2 tabs card pay and pay pal


    @BeforeClass
    public void setup(){
        failTestPerEnvironment("live", "Can not test this on live ...! see qa test.");
        setThreadSafeDriver();
        setLanguageAndMarket("it", "it");
        phase1OfferPrice ="29";
        TestUtil.printMethodName(logger);
        creditCardLinkText="Card Paymment";  //Card Payment
        tabId = 0;
        isNewhouseTyPage = true;
        payDdWeId = ".btn.btn-primary";
        paymentSubmitBtnCss = payDdWeId;
        testCardType= CardType.MASTERCARD;
        isClickTabId = false;
        this.memberPageUrl = currMemberPageUrl;
        formDataMap = EfConstants.ukMembersFormMap_new;
        logger.info("setup url: "+memberPageUrl);
        this.openUrl(getWebDriver(), this.memberPageUrl, -1 ) ; //getWebDriver().get(this.memberPageUrl);
    }

    @AfterClass
    protected void testAfterClass(){
        destroyDriver();
    }


    @Override
    protected String getMemberPageUrl() {
        memberPageUrl = currMemberPageUrl;
        return memberPageUrl;
    }

}