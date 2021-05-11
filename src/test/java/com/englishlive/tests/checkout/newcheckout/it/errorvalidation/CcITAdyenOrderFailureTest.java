package com.englishlive.tests.checkout.newcheckout.it.errorvalidation;
/**
 *
 *
 */
import com.englishtown.dataprovider.bin.validation.PaymentPageValidationMsgBean;
import com.englishtown.enumpack.AdyenTestCard;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.tests.checkout.common.core.NewCcBaseCheckoutFlowTest;
import com.englishtown.tests.checkout.common.validation.BaseCCAdyenOrderFailureTest;
import com.englishtown.tests.core.EfConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
//Sherin 04/10/2019 - adyen order failure sceanrio


public class CcITAdyenOrderFailureTest extends BaseCCAdyenOrderFailureTest {
    private static final Logger logger = LoggerFactory.getLogger(CcITAdyenOrderFailureTest.class);
    @Value("#{applicationPropertiesList['new.checkout.member.it.it.invalidoffer.url']}")
    protected String currMemberPageUrl;       //protected String payButtonSelector = "form_tabctrl_tab-0_button"; //id   // .nav-tabs a fr pay page 2 tabs card pay and pay pal


    @BeforeClass
    public void setup(){
        setThreadSafeDriver();
        is_adyenPayment=true;
        adyenTestCard= AdyenTestCard.VISA;
        isNewhousePayment=false;
        submitBtnCss = ".btn.btn-primary";
        is_adyen3DSecure=true;
        phase1OfferPrice ="29";
        TestUtil.printMethodName(logger);
        creditCardLinkText="Card Paymment";  //Card Payment
        tabId = 0;
        setPaymentPageValidationMsgBean();
        isClickTabId = false;
        this.memberPageUrl = currMemberPageUrl;
        memberPageUrl = currMemberPageUrl;
        formDataMap = EfConstants.ukMembersFormMap_new;
        logger.info("setup url: "+memberPageUrl);
        setLanguageAndMarket("it", "it");
        paymentSubmitBtnCss = ".btn.btn-primary";
        isNewhouseTyPage = true;

        this.openUrl(getWebDriver(), this.memberPageUrl, -1 ) ; //getWebDriver().get(this.memberPageUrl);
    }


    public void setPaymentPageValidationMsgBean() {
        paymentPageValidationMsgBean = new PaymentPageValidationMsgBean("pagamento è andato a buon fine ma purtroppo");
    }

    @AfterClass
    protected void testAfterClass(){
        destroyDriver();
    }


}