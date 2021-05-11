package com.englishlive.tests.checkout.newcheckout.be;
/**
 * New checkout
 */
import com.englishtown.tests.checkout.common.core.BaseCCpayReturningStudent;
import com.englishtown.tests.core.BaseTestConfig;
import com.englishtown.tests.core.EfConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/*[3:55:55 PM] Nikol Marku:
http://englishlive.ef.com/fr-wws/login?ctr=ch    auto_1484149900921_xdelx@qp1.org   pass
when this user logs in is redirected to de-wws
Nikol Marku: user was created on ... fr-wws */

public class BeFrCCpayReturningExStudentTest extends BaseCCpayReturningStudent {
    private static final Logger logger = LoggerFactory.getLogger(BeFrCCpayReturningExStudentTest.class);
    @Value("#{applicationPropertiesList['new.checkout.member.fr.ch.url']}")
    protected String currMemberPageUrl;
    private String myRmLoginSelector = ".form span a";
    private String myConfirmPayBtnId = "form_tabctrl_tab-1_button";
    private String myOfferNotValidLinkCss = "#form_tabctrl_tab-1_form-form .message p a";


    @BeforeClass
    public void setup(){
        setThreadSafeDriver();
        paymentSubmitBtnCss = ".btn.btn-primary";
        isNewhouseTyPage = true;
        modifyCCdetailsLink = ".functional";
        phase1OfferPrice ="19";
        password= BaseTestConfig.getPassword8();
        isNewDesignLogin=true;
        setLanguageAndMarket("fr", "be");
        validationMsgContainsTxt = "Vous devez accepter les conditions générales de vente";
        failTestIfIsNotBrowser(CHROME_BROWSER_LIST, "Chrome Only Test ....!");
        isClickTabId=false;
        creditCardLinkText="Carte";
        memberPageUrl = currMemberPageUrl;
        rmLoginSelector = myRmLoginSelector;
        confirPayBtnId = myConfirmPayBtnId;
        formDataMap = EfConstants.ukMembersFormMap_new;
        offerNotValidLinkCss = myOfferNotValidLinkCss;
        logger.info("setup url: " + memberPageUrl + " ENV is : " + getENVIRONMENT());
        openUrl(getWebDriver(), this.memberPageUrl, -1 ) ;
    }

    @Override
    protected String getMemberPageUrl() {
        memberPageUrl = currMemberPageUrl;
        return memberPageUrl;
    }


    @AfterClass
    protected void testAfterClass(){ destroyDriver();
    }
}

