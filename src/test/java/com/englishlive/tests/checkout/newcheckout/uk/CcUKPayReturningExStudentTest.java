package com.englishlive.tests.checkout.newcheckout.uk;
/**
 *
 *
 */
import com.englishtown.enumpack.CheckoutFlowType;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.tests.checkout.common.core.BaseCCpayReturningStudent;
import com.englishtown.tests.core.BaseTestConfig;
import com.englishtown.tests.core.EfConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class CcUKPayReturningExStudentTest extends BaseCCpayReturningStudent {
    private static final Logger logger = LoggerFactory.getLogger(CcUKPayReturningExStudentTest.class);
    @Value("#{applicationPropertiesList['checkout.member.en.en.url']}")
    protected String currMemberPageUrl;
//    protected String requestUrl = "https://qa-englishlive.ef.com/1/api/salesforce-gateway/subscription/?efId/cancel?reason=test-reason";
    private String myRmLoginSelector = ".form span a";
    private String myConfirmPayBtnId = "form_tabctrl_tab-1_button";
    private String myOfferNotValidLinkCss = "#form_tabctrl_tab-1_form-form .message p a";
    //private String myConfirmPayButton= "form_tabctrl_tab-0_button"; //bs3 button = 3 element #form_tabctrl_tab-0_button

    @BeforeClass
    public void setup() {
        setThreadSafeDriver();
        isNewhouseCheckout = true;
        //isNewHouseEnroll = true;
        //isNewhousePayment = true;
        isNewhouseTyPage = true;
        //isNewhouse = true;
        checkStateObject = true;
        isRunTestPhoneTextCheckPhoneTxtOnTy = true;   // phone number mast enter on TY
        isPhoneTextInputShownOnTYpage = true;
        isTypePhoneNumberOnTyPage = true;
        phoneNubmer = "0875869";
        paymentSubmitBtnCss = ".btn.btn-primary";
        phase1OfferPrice = "49";
        TestUtil.printMethodName(logger);
        isClickTabId = false;
        this.memberPageUrl = currMemberPageUrl;
        formDataMap = EfConstants.ukMembersFormMap_new;
        setLanguageAndMarket("en", "gb");
       // validationMsgContainsTxt = "Vous devez accepter les conditions générales de vente";
        isTestCheckoutFlowType = true;
        checkoutFlowType = CheckoutFlowType.DEFAULT;
        TestUtil.printMethodName(logger);
        this.memberPageUrl = currMemberPageUrl;
        creditCardLinkText = "Carte";
        isNewDesignLogin = true;
        password = BaseTestConfig.getPassword8();
        tabId = 0;
        isClickTabId = false;
        password = BaseTestConfig.getPassword8();
        setSubmitBtn("input[type=submit]");
        formDataMap = EfConstants.ukMembersFormMap_new;
        confirPayBtnId = myConfirmPayBtnId;
        this.rmLoginSelector = myRmLoginSelector;
        this.offerNotValidLinkCss = myOfferNotValidLinkCss;
        logger.info("setup url: " + memberPageUrl + " ENV is : " + getENVIRONMENT());
        this.openUrl(getWebDriver(), this.memberPageUrl, -1);
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