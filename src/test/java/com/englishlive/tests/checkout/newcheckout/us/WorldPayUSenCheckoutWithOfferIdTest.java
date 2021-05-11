package com.englishlive.tests.checkout.newcheckout.us;
/**
 *
 * only one tab on live 
 */
import com.englishlive.tests.checkout.newcheckout.core.worldpay.core.BaseWorldPayTest;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.tests.core.EfConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class WorldPayUSenCheckoutWithOfferIdTest extends BaseWorldPayTest {
    private static final Logger logger = LoggerFactory.getLogger(WorldPayUSenCheckoutWithOfferIdTest.class);
    @Value("#{applicationPropertiesList['checkout.member.en.us.worldpay.offerid.url']}")
    protected String currMemberPageUrl;


    @BeforeClass
    public void setup(){
        setThreadSafeDriver();
        TestUtil.printMethodName(logger);
        failTestPerEnvironment("live", "This test is set to run only on QA ...!");
        isClickTabId = true;
        creditCardLinkText = "Card";
        this.memberPageUrl = currMemberPageUrl;
        formDataMap = EfConstants.ukMembersFormMap_new;
        paymentCardDetails = EfConstants.WORLDPAY_US_AMEX;
        logger.info("setup url: "+memberPageUrl);
        this.openUrl(getWebDriver(), this.memberPageUrl, -1 ) ;
    }

    @AfterClass
    protected void testAfterClass(){
        destroyDriver();
    }


}

