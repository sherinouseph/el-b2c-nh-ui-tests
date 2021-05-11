package com.englishlive.tests.checkout.newcheckout.us;
/**
 *
 * only one tab on live 
 */
import com.englishlive.tests.checkout.newcheckout.core.worldpay.core.BaseNegativeWorldPayTest;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.tests.core.EfConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class WorldPayUSennNegativeCheckoutTest extends BaseNegativeWorldPayTest {
    private static final Logger logger = LoggerFactory.getLogger(WorldPayUSennNegativeCheckoutTest.class);
    @Value("#{applicationPropertiesList['checkout.member.en.us.worldpay.url']}")
    protected String currMemberPageUrl;


    @BeforeClass
    public void setup(){
        setThreadSafeDriver();
        TestUtil.printMethodName(logger);
        failTestIfIsNotBrowser(CHROME_BROWSER_LIST, "Chrome Only Test ....!");
        isClickTabId = true;
        creditCardLinkText = "Card";
        this.memberPageUrl = currMemberPageUrl;
        formDataMap = EfConstants.ukMembersFormMap_new;
        paymentCardDetails = EfConstants.WORLDPAY_US_AMEX_NEGATIVE;
        logger.info("setup url: "+memberPageUrl);
        this.openUrl(getWebDriver(), this.memberPageUrl, -1 ) ;
    }

    @AfterClass
    protected void testAfterClass(){
        destroyDriver();
    }


}

