package com.englishlive.tests.checkout.newcheckout.fr;
/**
 *
 *
 */

import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.tests.checkout.common.core.NewCcBaseCheckoutFlowTest;
import com.englishtown.tests.core.EfConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class CcGenFrBeCheckoutTest extends NewCcBaseCheckoutFlowTest {
    private static final Logger logger = LoggerFactory.getLogger(CcGenFrBeCheckoutTest.class);
    @Value("#{applicationPropertiesList['gen.member.fr.be']}")
    protected String currMemberPageUrl;
    //protected String payButtonSelector = "form_tabctrl_tab-0_button";


    @BeforeClass
    public void setup(){
        setThreadSafeDriver();
        phase1OfferPrice ="19";

        setLanguageAndMarket("fr","fr");
        TestUtil.printMethodName(logger);
        this.memberPageUrl = currMemberPageUrl;
        creditCardLinkText="Carte";
        isNewhouseTyPage = true;
        isClickTabId =false;
        paymentSubmitBtnCss = ".btn.btn-primary";
        tabId = 0;
        formDataMap = EfConstants.ukMembersFormMap_new;
        logger.info("setup url: "+memberPageUrl);
        this.openUrl(getWebDriver(), this.memberPageUrl, 35 ) ;
    }

    @Override
    protected String getMemberPageUrl() {
        memberPageUrl = currMemberPageUrl;
        return memberPageUrl;
    }

    @Override
    public void check_EnrolmentPage() {
        /* FR only */
        assertIsUrlContaining("enrollment/b2c/entrance");
       // waitForElementCondition(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ue-logo")), getWebDriver(), 30);
    }

    @AfterClass
    protected void testAfterClass(){
        destroyDriver();
    }

}

