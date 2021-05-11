package com.englishlive.tests.checkout.newcheckout.kr;
/**
 *
 *
 */
import com.englishlive.tests.checkout.newcheckout.core.simple.BaseFreeStyleCheckout;
import com.englishtown.helpers.utils.TestUtil;
import com.englishtown.tests.core.EfConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class CcKRCheckoutFreeStyleTest extends BaseFreeStyleCheckout {
    private static final Logger logger = LoggerFactory.getLogger(CcKRCheckoutFreeStyleTest.class);
    @Value("#{applicationPropertiesList['new.checkout.member.ko.kr.url']}")
    protected String testUrl;

     @BeforeClass
     public void setup(){
         setThreadSafeDriver();
         phase1OfferPrice ="59000";
         failTestIfIsNotBrowser(CHROME_BROWSER_LIST, "Chrome Only Test ....!");
         TestUtil.printMethodName(logger);
         isClickTabId = false;
         submitMemberBtnSelector = ".bs3 .btn-primary";
         memberFormMap = EfConstants.ukMembersFormMap_new;
         logger.info("setup url: "+memberPageUrl);
         this.openUrl(getWebDriver(), testUrl, -1 ) ;
     }

    @AfterClass
    protected void testAfterClass(){
        destroyDriver();
    }

}

