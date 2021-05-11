package com.englishlive.tests.checkout.newcheckout.de;
/**
 * Open price page and click try us
 * Enter phone on member form
 * phone filed is not shown on new TY page
 *
 */
import com.englishtown.enumpack.AdyenTestCard;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.tests.checkout.common.core.NewCcBaseCheckoutFlowTest;
import com.englishtown.tests.core.EfConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class CcGenDeChCheckoutWithPhoneTest extends NewCcBaseCheckoutFlowTest {
    private static final Logger logger = LoggerFactory.getLogger(CcGenDeChCheckoutWithPhoneTest.class);
    @Value("#{applicationPropertiesList['gen.de.ch.price.page']}")
    protected String currMemberPageUrl;


    @BeforeClass
    public void setup(){
        setThreadSafeDriver();
        is_adyen3DSecure=true;
        is_adyenPayment=true;
        isNewhouseTyPage=true;
        adyenTestCard= AdyenTestCard.VISA;
        TestUtil.printMethodName(logger);
        phase1OfferPrice ="59";
        creditCardLinkText="Kreditkarte";
        isClickTabId = false;
        tabId = 1;
        memberPageUrl = currMemberPageUrl;
        formDataMap = EfConstants.deMembersWithPhoneMap;
        logger.info("setup url: "+memberPageUrl);
        openUrl(getWebDriver(), memberPageUrl, -1 ) ;
        logger.info("Price page opened ...! ");
        WebElement tryUs = findElement(By.cssSelector(".package .btn.btn-primary"));
        click(tryUs);
    }

    @AfterClass
    protected void testAfterClass(){
        destroyDriver();
    }



    @Override
    protected String getMemberPageUrl() {
        memberPageUrl = currMemberPageUrl;
        return memberPageUrl;
    }


}

