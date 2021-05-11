package com.englishlive.tests.checkout.newcheckout.ja;
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


public class JCBJaCheckoutTest extends CheckEnrolmentTest {
    private static final Logger logger = LoggerFactory.getLogger(JCBJaCheckoutTest.class);
    @Value("#{applicationPropertiesList['new.checkout.member.ja.jp.url']}")
    protected String currMemberPageUrl;


    @BeforeClass
    public void setup(){
        setThreadSafeDriver();
        phase1OfferPrice="8690";
        failTestPerEnvironment("live", "Can not test this on live ...! see qa test.");
        TestUtil.printMethodName(logger);
        creditCardLinkText="Kreditkarte";
        paymentSubmitBtnCss = ".btn.btn-primary"; //".bs3 .btn";
        testCardType= CardType.JCB;
        isNewhouseTyPage = true;
        tabId = 0;
        isClickTabId= false;
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
        destroyDriver();
    }

}

