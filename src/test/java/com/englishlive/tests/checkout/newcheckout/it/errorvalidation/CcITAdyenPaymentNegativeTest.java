package com.englishlive.tests.checkout.newcheckout.it.errorvalidation;
/**
 *
 *
 */
import com.englishtown.dataprovider.bin.validation.PaymentPageValidationMsgBean;
import com.englishtown.enumpack.AdyenTestCard;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.pages.checkout.newcheckout.CheckoutPaymentPage;
import com.englishtown.tests.checkout.common.core.NewCcBaseCheckoutFlowTest;
import com.englishtown.tests.checkout.common.validation.BaseCCAdyenPaymentNegativeTest;
import com.englishtown.tests.core.EfConstants;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
//Sherin 02/10/2019 - adyen payment in italy - SAND-7591


public class CcITAdyenPaymentNegativeTest extends BaseCCAdyenPaymentNegativeTest {
    private static final Logger logger = LoggerFactory.getLogger(CcITAdyenPaymentNegativeTest.class);
    @Value("#{applicationPropertiesList['new.checkout.member.it.it.offer.url']}")
    protected String currMemberPageUrl;       //protected String payButtonSelector = "form_tabctrl_tab-0_button"; //id   // .nav-tabs a fr pay page 2 tabs card pay and pay pal


    @BeforeClass
    public void setup(){
        setThreadSafeDriver();
        is_adyenPayment=true;
        adyenTestCard= AdyenTestCard.VISA;
        isNewhousePayment=false;
        is_adyen3DSecure=true;
        phase1OfferPrice ="29";
        submitBtnCss = ".btn.btn-primary";
        TestUtil.printMethodName(logger);
        creditCardLinkText="Card Paymment";  //Card Payment
        tabId = 0;
        isClickTabId = false;
        setPaymentPageValidationMsgBean();
        this.memberPageUrl = currMemberPageUrl;
        formDataMap = EfConstants.ukMembersFormMap_new;
        logger.info("setup url: "+memberPageUrl);
        setLanguageAndMarket("it", "it");
        paymentSubmitBtnCss = ".btn.btn-primary";
        isNewhouseTyPage = true;

        this.openUrl(getWebDriver(), this.memberPageUrl, -1 ) ; //getWebDriver().get(this.memberPageUrl);
    }

    @AfterClass
    protected void testAfterClass(){
        destroyDriver();
    }


    @Override
    public void setPaymentPageValidationMsgBean() {
        paymentPageValidationMsgBean = new PaymentPageValidationMsgBean("Numero carta non valido","Data di scadenza non valida","Codice di sicurezza non valido"," pagamento è stato rifiutato");
    }



}