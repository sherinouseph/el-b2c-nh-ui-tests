package com.englishlive.tests.checkout.newcheckout.tr.fielderrorvalidation;
/**
 * Check validation messages on pay page
 *
 *
 */

import com.englishtown.dataprovider.bin.validation.PaymentPageValidationMsgBean;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.tests.checkout.common.validation.BaseCCPaymentPageNegativeTest;
import com.englishtown.tests.core.EfConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class TRCCPayPageNegativeTest extends BaseCCPaymentPageNegativeTest {
    private static final Logger logger = LoggerFactory.getLogger(TRCCPayPageNegativeTest.class);
    @Value("#{applicationPropertiesList['new.checkout.member.tr.tr.url']}")
    protected String currMemberPageUrl;

    @BeforeClass
    public void setup(){
        setThreadSafeDriver();
        isNewhouseCheckout=true;
        isNewhousePayment=true;
        TestUtil.printMethodName(logger);
        submitBtnCss = ".btn.btn-primary";
        submitPayPage = submitBtnCss;
        paymentSubmitBtnCss = submitBtnCss;
        isClickTabId = false;
        setPaymentPageValidationMsgBean();
        creditCardLinkText="Kreditkarte";
        this.memberPageUrl = currMemberPageUrl;
        formDataMap = EfConstants.ukMembersFormMap_new;
        logger.info("setup url: "+memberPageUrl);
        this.openUrl(getWebDriver(), this.memberPageUrl, -1 ) ;
    }

    @AfterClass
    protected void testAfterClass(){
        destroyDriver();
    }

    @Override
    public void setPaymentPageValidationMsgBean() {
        paymentPageValidationMsgBean = new PaymentPageValidationMsgBean("Kart numarası gereklidir",
                "Karttaki isim gereklidir",
                "ayını giriniz", "yılını giriniz",
                "Güvenlik numarası gereklidir","Devam etmek için");
    }
}

