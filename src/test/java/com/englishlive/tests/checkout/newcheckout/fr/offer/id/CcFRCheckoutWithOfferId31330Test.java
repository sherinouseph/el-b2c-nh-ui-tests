package com.englishlive.tests.checkout.newcheckout.fr.offer.id;
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


public class CcFRCheckoutWithOfferId31330Test extends NewCcBaseCheckoutFlowTest {
    private static final Logger logger = LoggerFactory.getLogger(CcFRCheckoutWithOfferId31330Test.class);
    @Value("#{applicationPropertiesList['member.fr.fr.offerid31330.url']}")
    protected String currMemberPageUrl;
    protected String payButtonSelector = "form_tabctrl_tab-0_button"; //id


    @BeforeClass
    public void setup(){
        //currMemberPageUrl = "https://englishlive.ef.com/fr-fr/buy/default/member/?ctr=fr&offerid=31340";
        //currMemberPageUrl = "https://englishlive.ef.com/fr-fr/buy/default/member/?ctr=fr&offerid=32845";
        //currMemberPageUrl = "https://englishlive.ef.com/fr-fr/buy/default/member/?ctr=fr&offerid=31378";
        //currMemberPageUrl =  "https://englishlive.ef.com/fr-fr/buy/default/member/?ctr=fr&offerid=31338";
        //// return pay currMemberPageUrl =  "https://englishlive.ef.com/fr-fr/buy/default/member/?ctr=fr&offerid=32844";
        ////currMemberPageUrl =  "https://englishlive.ef.com/fr-fr/buy/default/member/?ctr=fr&offerid=33889";

        setThreadSafeDriver();
        setLanguageAndMarket("fr", "fr");
        TestUtil.printMethodName(logger);

        memberPageUrl = currMemberPageUrl;

        isNewhouseTyPage = true;
        isClickTabId =false;
        paymentSubmitBtnCss = ".btn.btn-primary";
        creditCardLinkText="Carte";
        tabId = 0;
        phase1OfferPrice="19";//"79";
        formDataMap = EfConstants.ukMembersFormMap_new;
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

